package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {
    @FXML Button button;
    @FXML BorderPane bp;
    @FXML
    void btn1(MouseEvent event) {
        loader("ui1");
    }

    @FXML
    void btn2(MouseEvent event) {
        loader("ui2");
    }

    @FXML
    void btn3(MouseEvent event) {
        loader("ui3");
    }
    // @FXML
    private void loader(String ui){
        Parent root=null;
            try {
                root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        bp.setCenter(root);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
}

