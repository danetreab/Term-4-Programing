package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainmenuController{
    @FXML BorderPane scenepanel;
    @FXML Circle min;
    @FXML Pane ap;
    private Stage stage;
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
        loader("book");
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
