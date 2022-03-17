package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class categoryController implements Initializable  {
    @FXML TextField txtcategory;
    @FXML ComboBox<String> txtstatus;
    @FXML Label txtlabel;
    @FXML TableView<?> categorytable;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    // categoryController(){
    //     connection();
    // }
    public void add(){
        String category = txtcategory.getText();
        String status = txtstatus.getSelectionModel().getSelectedItem().toString();
        if(category.equals("")){
            txtlabel.setText("Category name or Status Blank");
        }
        else{
                connection();
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
                    }else{
                        txtlabel.setText("Add Category failed");
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
                }
                
        }
        
    }
    @FXML
    void comboBoxupdate(ActionEvent event) {
        String s = txtstatus.getSelectionModel().getSelectedItem().toString();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> list = FXCollections.observableArrayList("Active","Deactive","None");
        txtstatus.setItems(list);
    }
    public void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6478070","sql6478070","xcvQ1LVh1q");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void category_load(){
        connection();
        
    }
}
