package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class memberController {
    @FXML private TableColumn<?, ?> addresscol;
    @FXML private TableColumn<?, ?> idcol;
    @FXML private TableColumn<?, ?> namecol;
    @FXML private TableColumn<?, ?> phonecol;
    @FXML private TableView<?> table;
    @FXML private TextField txtaddress;
    @FXML private Label txtlabel;
    @FXML private TextField txtname;
    @FXML private TextField txtphone;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

}
