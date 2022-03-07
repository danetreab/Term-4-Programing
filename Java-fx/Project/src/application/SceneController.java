package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController {
    @FXML
    private Button END;

    @FXML
    private Button Log;

    @FXML
    private PasswordField passwordfild;

    @FXML
    private TextField usernamefild;

    @FXML
    private AnchorPane scenePane;


    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void gotohome(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exitapp(ActionEvent event){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
        // System.out.println("exit");
    }
    public void imageExit(MouseEvent event){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
        // System.out.println("exit");
    }
    public void login(ActionEvent event){
        String username = usernamefild.getText();
        String password = passwordfild.getText();
        if(username.equals("")&&password.equals("")){
            JOptionPane.showMessageDialog(null, "Username or password blank");
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3308/userlogin?useSSL=false","root","");
                pst=con.prepareStatement("select * from usercredential where username=? and password=?");
                pst.setString(1,username);
                pst.setString(2,password);
                rs = pst.executeQuery();
                if(rs.next()){
                    // JOptionPane.showMessageDialog(null, "Login Success");
                    try {
                        gotohome(event);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Login Failed");
                    usernamefild.setText("");
                    passwordfild.setText("");
                    usernamefild.requestFocus();
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
