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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class memberController implements Initializable {
    @FXML private TableColumn<memberTable, String> addresscol;
    @FXML private TableColumn<memberTable, String> idcol;
    @FXML private TableColumn<memberTable, String> namecol;
    @FXML private TableColumn<memberTable, String> phonecol;
    @FXML private TableView<memberTable> table;
    @FXML private TextField txtaddress;
    @FXML private Label txtlabel;
    @FXML private TextField txtname;
    @FXML private TextField txtphone;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    ObservableList<memberTable> list = FXCollections.observableArrayList();

    @FXML
    void add(ActionEvent event) {
        String name = txtname.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        if(name.equals("")&&address.equals("")&&phone.equals("") || name.equals("")){
            txtlabel.setText("Blank field");
        }else{
            con = DbConnect.getConnect();
            try {
                pst = con.prepareStatement("insert into member(name,address,phone) value(?,?,?)");
                pst.setString(1, name);
                pst.setString(2, address);
                pst.setString(3, phone);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Member Created");
                    txtname.setText("");
                    txtaddress.setText("");
                    txtphone.setText("");
                    txtname.requestFocus();
                    load();
                }else{
                    txtlabel.setText("Add Member failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
    }

    @FXML
    void delete(ActionEvent event) {
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getmid()));
            try {
                pst=con.prepareStatement("delete from member where mid =?");
                pst.setInt(1, id);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Member Deleted");
                    txtname.setText("");
                    txtaddress.setText("");
                    txtphone.setText("");
                    txtname.requestFocus();
                    load();
                }else{
                    txtlabel.setText("Delete member failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void update(ActionEvent event) {
        String name,address,phone;
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id=Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getmid()));
            name = txtname.getText();
            address= txtaddress.getText();
            phone=txtphone.getText();
            if(name.equals("")&&address.equals("")&&phone.equals("")){
                txtlabel.setText("Blank field");
            }else{
                con = DbConnect.getConnect();
                try {
                    pst = con.prepareStatement("update member set name=?,address=?,phone=? where id=?");
                    pst.setString(1, name);
                    pst.setString(2, address);
                    pst.setString(3, phone);
                    pst.setInt(4, id);
                    int k = pst.executeUpdate();
                    if(k==1){
                        txtlabel.setText("Member updated");
                        txtname.setText("");
                        txtaddress.setText("");
                        txtphone.setText("");
                        txtname.requestFocus();
                        load();
                    }else{
                        txtlabel.setText("Update member failed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
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
            rs=con.createStatement().executeQuery("select * from member");
            while(rs.next()){
                list.add(new memberTable(
                    rs.getString("mid"), 
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("phone")
                    ));
            }
        } catch (SQLException e) {
            Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null,e);
        }
        idcol.setCellValueFactory(new PropertyValueFactory<>("mid"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        table.setItems(list);

        table.setItems(list);
        table.setRowFactory(tv -> {
            TableRow<memberTable> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    txtname.setText(table.getItems().get(myIndex).getcategoryname());
                    txtaddress.setText(table.getItems().get(myIndex).getstatus());
                    txtphone.setText(table.getItems().get(myIndex).getPhone());
                }
            });
            return myRow;
        });
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        load();
    }
}

