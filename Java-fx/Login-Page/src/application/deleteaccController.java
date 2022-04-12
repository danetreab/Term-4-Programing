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

public class deleteaccController extends SHA256{
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
        if(username.equals("")||pass.equals("")||conpass.equals("")){
            txtlabel.setText("Please input the information");
        }
        else if(pass.equals(conpass)){
            con = DbConnect.getConnect();
            pst=con.prepareStatement("select * from usercredential where username=? and password=?");
            pst.setString(1,username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
                pst = con.prepareStatement("delete from usercredential where username=?");
                pst.setString(1, username);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Deleted");
                    txtpass.setText("");
                    txtpasscon.setText("");
                    txtusername.setText("");
                }
                else{
                    txtlabel.setText("Delete failed");
                }
            }else{
                txtlabel.setText("Username or password no match");
            }
        }
        else{
            txtlabel.setText("Re-Enter Password");
        }
    }
}
