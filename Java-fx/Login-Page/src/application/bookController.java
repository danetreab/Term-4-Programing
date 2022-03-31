package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class bookController implements Initializable{
    PreparedStatement pst;
    Connection con;
    ResultSet rs;

    @FXML private JFXComboBox<String> txtauthor;
    @FXML private JFXComboBox<String> txtcategory;
    @FXML private JFXComboBox<String> txtpublisher;
    @FXML private TableColumn<bookTable, String> authorcol;
    @FXML private TableColumn<bookTable, String> bookcol;
    @FXML private TableColumn<bookTable, String> catcol;
    @FXML private TableColumn<bookTable, String> concol;
    @FXML private TableColumn<bookTable, String> editcol;
    @FXML private TableColumn<bookTable, String> idcol;
    @FXML private TableColumn<bookTable, String> pagecol;
    @FXML private TableColumn<bookTable, String> pubcol;
    @FXML private TableView<bookTable> table;
    @FXML private TextField txtcontent;
    @FXML private TextField txtedition;
    @FXML private TextField txtname;
    @FXML private TextField txtpage;


    ObservableList<bookTable> list = FXCollections.observableArrayList();
    
    public void category(){
        con= DbConnect.getConnect();
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select categoryname from category");
            rs = pst.executeQuery();
            while(rs.next()){
                list.add(rs.getString("categoryname"));
            }
            txtcategory.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void author(){
        con= DbConnect.getConnect();
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select name from author");
            rs = pst.executeQuery();
            while(rs.next()){
                list.add(rs.getString("name"));
            }
            txtauthor.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void publisher(){
        con= DbConnect.getConnect();
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select name from publisher");
            rs = pst.executeQuery();
            while(rs.next()){
                list.add(rs.getString("name"));
            }
            txtpublisher.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeAllRows(){
        for ( int i = 0; i<table.getItems().size(); i++) {
            table.getItems().clear(); 
        } 
    }
    public void load(){
        removeAllRows();
        con=DbConnect.getConnect();
        try {
            rs=con.createStatement().executeQuery("select * from book");
            while(rs.next()){
                list.add(new bookTable(
                    rs.getString("id"), 
                    rs.getString("bookname"),
                    rs.getString("category"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("contents"),
                    rs.getString("pages"),
                    rs.getString("edition")
                    ));
            }
        } catch (SQLException e) {
            Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null,e);
        }
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookcol.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        catcol.setCellValueFactory(new PropertyValueFactory<>("category"));
        pubcol.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorcol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        concol.setCellValueFactory(new PropertyValueFactory<>("contents"));
        pagecol.setCellValueFactory(new PropertyValueFactory<>("pages"));
        editcol.setCellValueFactory(new PropertyValueFactory<>("edition"));
        
        table.setItems(list);
        table.setRowFactory(tv -> {
            TableRow<bookTable> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    txtname.setText(table.getItems().get(myIndex).getbookname());
                    txtcontent.setText(table.getItems().get(myIndex).getcontents());
                    txtpage.setText(table.getItems().get(myIndex).getpages());
                    txtedition.setText(table.getItems().get(myIndex).getedition());
                }
            });
            return myRow;
        });
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        category();
        author();
        publisher();
        load();
    }

}
