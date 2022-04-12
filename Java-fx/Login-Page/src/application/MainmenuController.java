package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainmenuController implements Initializable{
    @FXML BorderPane scenepanel;
    @FXML Circle min;
    @FXML Pane ap;
    @FXML private Label txttotalbook;
    @FXML private Label txtauthor;
    @FXML private Label txtmember;
    private Stage stage;
    private Scene scene;
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    
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
    void author(MouseEvent event) {
        loader("author");
    }

    @FXML
    void book(MouseEvent event) {
        loader("Book");
    }

    @FXML
    void category(MouseEvent event) {
        loader("category");
    }
    @FXML
    void home(MouseEvent event) {
        scenepanel.setCenter(ap);
    }

    @FXML
    void issue(MouseEvent event) {
        loader("issue");
    }

    @FXML
    void member(MouseEvent event) {
        loader("member");
    }

    @FXML
    void publisher(MouseEvent event) {
        loader("publisher");
    }

    @FXML
    void returnbtn(MouseEvent event) {
        loader("return");
    }
    @FXML
    void account(MouseEvent event){
        loader("account");
    }
    @FXML
    void database(MouseEvent event){
        loader("database");
    }
    @FXML
    void about(MouseEvent event) {
        loader("about");
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
    @FXML
    private void logout(MouseEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void totalbook(){
        String total="";
        con = DbConnect.getConnect();
        try {
            pst = con.prepareStatement("select count(bookname) from book");
            rs = pst.executeQuery();
            if(rs.next()){
                total=rs.getString("count(bookname)");
                txttotalbook.setText(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void totalauthor(){
        String total="";
        con = DbConnect.getConnect();
        try {
            pst = con.prepareStatement("select count(name) from author");
            rs = pst.executeQuery();
            if(rs.next()){
                total=rs.getString("count(name)");
                txtauthor.setText(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void totalmember(){
        String total="";
        con = DbConnect.getConnect();
        try {
            pst = con.prepareStatement("select count(mid) from member");
            rs = pst.executeQuery();
            if(rs.next()){
                total=rs.getString("count(mid)");
                txtmember.setText(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        totalbook();
        totalauthor();
        totalmember();
    }
}
