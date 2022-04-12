package application;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class accountController extends SHA256{
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    @FXML private Label txtlabel;
    @FXML private TextField txtpass;
    @FXML private TextField txtpasscon;
    @FXML private TextField txtusername;
    @FXML BorderPane scenepanel;
    @FXML AnchorPane ap;
    @FXML
    void submit(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        String username,pass,conpass;
        username = txtusername.getText();
        pass = txtpass.getText();
        conpass = txtpasscon.getText();
        if(username.equals("")||pass.equals("")||conpass.equals("")){
            txtlabel.setText("Please input the information");
        }
        else if(pass.equals(conpass)){
            con = DbConnect.getConnect();
            pst=con.prepareStatement("select * from usercredential where username=?");
            pst.setString(1,username);
            rs = pst.executeQuery();
            if(rs.next()){
                txtlabel.setText("This Username already use");
            }else{
                pst = con.prepareStatement("insert into usercredential(username,password) value(?,?)");
                pst.setString(1, username);
                String password = toHexString(getSHA(pass));
                pst.setString(2,password);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("User added");
                    txtpass.setText("");
                    txtpasscon.setText("");
                    txtusername.setText("");
                }
                else{
                    txtlabel.setText("Add user failed");
                }
            }
        }
        else{
            txtlabel.setText("Re-Enter Password");
        }
    }
    @FXML
    void home(MouseEvent event) {
        scenepanel.setCenter(ap);
    }
    @FXML 
    void changepass(MouseEvent event){
        loader("changepass");
    }
    @FXML
    void deleteacc(MouseEvent event){
        loader("deleteAcc");
    }
    private void loader(String ui){
        Parent root=null;
            try {
                root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        scenepanel.setCenter(root);
    }
}
