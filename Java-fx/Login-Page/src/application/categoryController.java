package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class categoryController implements Initializable  {
    @FXML TextField txtcategory;
    @FXML ComboBox<String> txtstatus;
    @FXML Label txtlabel;
    @FXML private TableView<categoryTable> table;
    @FXML private TableColumn<categoryTable, String> idcol;
    @FXML private TableColumn<categoryTable, String> categorynamecol;
    @FXML private TableColumn<categoryTable, String> statuscol;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    ObservableList<categoryTable> categories = FXCollections.observableArrayList();

    public void add(ActionEvent event){
        String category = txtcategory.getText();
        String status = txtstatus.getSelectionModel().getSelectedItem().toString();
        if(category.equals("")){
            txtlabel.setText("Category name or Status Blank");
        }
        else{
            con = DbConnect.getConnect();
                try {
                    pst = con.prepareStatement("insert into category(categoryname,status) values (?,?)");
                    pst.setString(1, category);
                    pst.setString(2, status);
                    int k = pst.executeUpdate();
                    if(k==1){
                        txtlabel.setText("Category Created");
                        txtcategory.setText("");
                        txtstatus.getSelectionModel().clearSelection();
                        txtcategory.requestFocus();
                        load();
                    }else{
                        txtlabel.setText("Add Category failed");
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
                }
                
        }
        
    }
    public void update(ActionEvent event){
        String categoryname,status;
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            
            status = txtstatus.getSelectionModel().getSelectedItem().toString();
            categoryname = txtcategory.getText();
            if(categoryname.equals("")){
                txtlabel.setText("Category name or Status Blank");
            }else{
            con = DbConnect.getConnect();
            try {
                pst = con.prepareStatement("update category set categoryname =?,status=? where id=?");
                pst.setString(1, categoryname);
                pst.setString(2, status);
                pst.setInt(3, id);
                int k = pst.executeUpdate();
                    if(k==1){
                        txtlabel.setText("Category updated");
                        txtcategory.setText("");
                        txtstatus.getSelectionModel().clearSelection();
                        txtcategory.requestFocus();
                        load();
                    }else{
                        txtlabel.setText("Update Category failed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void delete(ActionEvent event){
        int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        try {
            pst=con.prepareStatement("delete from category where id = ?");
            pst.setInt(1, id);
            int k = pst.executeUpdate();
            if(k==1){
                txtlabel.setText("Category Deleted");
                txtcategory.setText("");
                txtstatus.getSelectionModel().clearSelection();
                txtcategory.requestFocus();
                load();
            }else{
                txtlabel.setText("Delete Category failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> list = FXCollections.observableArrayList("Active","Deactive","None");
        txtstatus.setItems(list);
        load();
    }
    private void load(){
        con=DbConnect.getConnect();
            try {
                rs=con.createStatement().executeQuery("select * from category");
                while (rs.next()){
                categories.add(new categoryTable(
                        rs.getString("id"),
                        rs.getString("categoryname"),
                        rs.getString("status")
                        ));
            }
            } catch (SQLException e) {
                Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null,e);
            }
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        categorynamecol.setCellValueFactory(new PropertyValueFactory<>("categoryname"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(categories);
    }
}
