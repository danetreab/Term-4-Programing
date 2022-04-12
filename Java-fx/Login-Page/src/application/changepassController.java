package application;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class changepassController extends SHA256{
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    @FXML private AnchorPane ap;
    @FXML private Label txtlabel;
    @FXML private TextField txtpass;
    @FXML private TextField txtpasscon;
    @FXML private TextField txtusername;
    @FXML
    void submit(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        String username,pass,conpass;
        username = txtusername.getText();
        pass = txtpass.getText();
        conpass = txtpasscon.getText();
        String password = toHexString(getSHA(pass));
        String password2 = toHexString(getSHA(conpass));
        if(username.equals("")||pass.equals("")||conpass.equals("")){
            txtlabel.setText("Please input the information");
        }
        else{
            con = DbConnect.getConnect();
            pst=con.prepareStatement("select * from usercredential where username=? and password=?");
            pst.setString(1,username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
                pst = con.prepareStatement("update usercredential set password=? where username=?");
                pst.setString(1, password2);
                pst.setString(2, username);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Updated");
                    txtpass.setText("");
                    txtpasscon.setText("");
                    txtusername.setText("");
                }
                else{
                    txtlabel.setText("Update failed");
                }
            }else{
                txtlabel.setText("Username or Password not match");
            }
        }
    }
}
