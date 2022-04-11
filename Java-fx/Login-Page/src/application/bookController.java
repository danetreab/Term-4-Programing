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
    @FXML private Label txtlabel;

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
    public void add(ActionEvent event) {
        String name, category, publisher, author,content,page,edition;
       // Connect();
        name = txtname.getText();
        category = txtcategory.getSelectionModel().getSelectedItem().toString();
        publisher= txtpublisher.getSelectionModel().getSelectedItem().toString();
        author = txtauthor.getSelectionModel().getSelectedItem().toString();
        content = txtcontent.getText();
        page = txtpage.getText();
        edition = txtedition.getText();

        con = DbConnect.getConnect();
        if(name.equals("")&&content.equals("")&&page.equals("")){
            txtlabel.setText("Blank field");
        }
        else{
            try {
                    pst = con.prepareStatement("insert into book(bookname,category,author,publisher,contents,pages,edition) value (?,?,?,?,?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, category);
                    pst.setString(3, author);
                    pst.setString(4, publisher);
                    pst.setString(5, content);
                    pst.setString(6, page);
                    pst.setString(7, edition);

                    int k = pst.executeUpdate();
                    if(k==1){
                        txtname.setText("");
                        txtcategory.getSelectionModel().clearSelection();
                        txtpublisher.getSelectionModel().clearSelection();
                        txtauthor.getSelectionModel().clearSelection();
                        txtcontent.setText("");
                        txtpage.setText("");
                        txtedition.setText("");
                        txtname.requestFocus();
                        txtlabel.setText("Book added");
                        load();
                    }
                    else{
                        txtlabel.setText("Add book failed");
                    }
                    
            } catch (SQLException ex) {
                    Logger.getLogger(bookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void update(ActionEvent event){
        String name, category, publisher, author,content,page,edition;
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id=Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                name = txtname.getText();
                category = txtcategory.getSelectionModel().getSelectedItem().toString();
                publisher= txtpublisher.getSelectionModel().getSelectedItem().toString();
                author = txtauthor.getSelectionModel().getSelectedItem().toString();
                content = txtcontent.getText();
                page = txtpage.getText();
                edition = txtedition.getText();
            if(name.equals("")&&content.equals("")&&page.equals("")){
                txtlabel.setText("Blank field");
            }else{
                con = DbConnect.getConnect();
                try {
                    pst = con.prepareStatement("update book set bookname=?,category=?,author=?,publisher=?,contents=?,pages=?,edition=? where id=?");
                    pst.setString(1, name);
                    pst.setString(2, category);
                    pst.setString(3, author);
                    pst.setString(4, publisher);
                    pst.setString(5, content);
                    pst.setString(6, page);
                    pst.setString(7, edition);
                    pst.setInt(8, id);
                    int k = pst.executeUpdate();
                    if(k==1){
                        txtname.setText("");
                        txtcategory.getSelectionModel().clearSelection();
                        txtpublisher.getSelectionModel().clearSelection();
                        txtauthor.getSelectionModel().clearSelection();
                        txtcontent.setText("");
                        txtpage.setText("");
                        txtedition.setText("");
                        txtname.requestFocus();
                        load();
                    }else{
                        txtlabel.setText("Update Book failed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            }
        }
    }
    public void delete(ActionEvent event){
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            try {
                pst=con.prepareStatement("delete from book where id =?");
                pst.setInt(1, id);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Book Deleted");
                    txtname.setText("");
                    txtcategory.getSelectionModel().clearSelection();
                    txtpublisher.getSelectionModel().clearSelection();
                    txtauthor.getSelectionModel().clearSelection();
                    txtcontent.setText("");
                    txtpage.setText("");
                    txtedition.setText("");
                    txtname.requestFocus();
                    load();
                }else{
                    txtlabel.setText("Delete Book failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            Logger.getLogger(bookController.class.getName()).log(Level.SEVERE, null,e);
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
