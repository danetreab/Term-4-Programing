package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class bookController implements Initializable{
    PreparedStatement pst;
    Connection con;
    ResultSet rs;

    @FXML private JFXComboBox<String> txtcategory;
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
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        category();
    }

}
