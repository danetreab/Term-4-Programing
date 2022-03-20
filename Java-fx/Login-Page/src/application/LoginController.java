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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class LoginController extends SHA256{
    private static final Stage Stage = null;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private Scene scene;
    private Stage stage;
    @FXML TextField email;
    @FXML AnchorPane scenepanel;
    @FXML Circle min;
    @FXML PasswordField pass;
    @FXML Label message;
    @FXML
    private void submit(ActionEvent event) throws NoSuchAlgorithmException, SQLException, IOException{
        String mail = email.getText();
        String nonehase = pass.getText();
        String password = toHexString(getSHA(nonehase));
        if(mail.equals("")&&nonehase.equals("")){
            message.setText("Email or Password Blank");
        }
        else{
            con = DbConnect.getConnect();
            pst=con.prepareStatement("select * from usercredential where username=? and password=?");
            pst.setString(1,mail);
            pst.setString(2,password);
            rs = pst.executeQuery();
            if(rs.next()){
                changescene(event);
            }else{
                message.setText("Login Fail");
            }
        }
    }
    @FXML
    private void exit(MouseEvent event){
        stage = (Stage)scenepanel.getScene().getWindow();
        stage.close();
    }
    @FXML 
    private void minimize(MouseEvent event){
        stage = (Stage)min.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void changescene(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
