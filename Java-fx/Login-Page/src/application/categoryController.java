package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class categoryController implements Initializable {
    
    @FXML
    private ComboBox<String> comb;

    @FXML
    void comboBoxupdate(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> list = FXCollections.observableArrayList("Active","Deactive");
        comb.setItems(list);
    }
}
