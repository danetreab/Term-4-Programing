package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class mainController {
    
    @FXML private Button submit;
    @FXML private TextField firstnamefield;
    @FXML private TextField lastnamefield;
    @FXML private TextField emailfield;
    @FXML private TextField addressfield;

    public void popup(ActionEvent event){
        String firstname=firstnamefield.getText();
        String lastname=lastnamefield.getText();
        String email=emailfield.getText();
        String address=addressfield.getText();
        JOptionPane.showMessageDialog(null, "Hi ! "+firstname+" "+lastname+"\nEmail : "+email+"\nAddress : "+address);
    }
}

