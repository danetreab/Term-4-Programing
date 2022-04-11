package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class issueController implements Initializable{
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    @FXML private DatePicker txtreturndate;
    @FXML private DatePicker txtdate;
    @FXML private Label txtlabel;
    @FXML private TableColumn<issueTable, String> bookcol;
    @FXML private TableColumn<issueTable, String> datecol;
    @FXML private TableColumn<issueTable, String> idcol;
    @FXML private TableColumn<issueTable, String> memberidcol;
    @FXML private TableColumn<issueTable, String> memcol;
    @FXML private TableColumn<issueTable, String> returncol;
    @FXML private TableView<issueTable> table;
    @FXML private JFXComboBox<String> txtbook;
    @FXML private TextField txtid;
    @FXML private TextField txtname;
    ObservableList<issueTable> list = FXCollections.observableArrayList();
    public void book(){
        con= DbConnect.getConnect();
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select bookname from book");
            rs = pst.executeQuery();
            while(rs.next()){
                list.add(rs.getString("bookname"));
            }
            txtbook.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void txtidKeyPressed(KeyEvent event) {
        String id = txtid.getText();
        if (event.getCode().toString().equals("ENTER")) {
            try {
                pst = con.prepareStatement(
                        "select * from member where mid=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                if (rs.next()==false) {
                    txtlabel.setText("ID not found. Please register");
                }else{
                    txtname.setText((rs.getString("name")).trim());
                    txtlabel.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(issueController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void add(ActionEvent event) {
        String memberid,bookid,date,returndate;
        LocalDate mydate = txtdate.getValue();
        LocalDate mydate2 = txtreturndate.getValue();
        memberid = txtid.getText();
        bookid = txtbook.getSelectionModel().getSelectedItem().toString();
        date = mydate.toString();
        returndate = mydate2.toString();
        con = DbConnect.getConnect();
        if(memberid.equals("")){
            txtlabel.setText("Blank field");
        }
        else{
            try {
                    pst = con.prepareStatement("insert into lendbook(memberid,bookid,issuedate,returndate) values (?,(select id from `book` where bookname=?),?,?)");
                    pst.setString(1, memberid);
                    pst.setString(2, bookid);
                    pst.setString(3, date);
                    pst.setString(4, returndate);

                    int k = pst.executeUpdate();
                    if(k==1){
                        txtname.setText("");
                        txtid.setText("");
                        txtid.requestFocus();
                        txtlabel.setText("Book Issued");
                        load();
                    }
                    else{
                        txtlabel.setText("Issue book failed");
                    }
                    
            } catch (SQLException ex) {
                    Logger.getLogger(issueController.class.getName()).log(Level.SEVERE, null, ex);
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
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));
            try {
                pst=con.prepareStatement("delete from lendbook where id =?");
                pst.setInt(1, id);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Deleted");
                    txtname.setText("");
                    txtid.setText("");
                    load();
                }else{
                    txtlabel.setText("Delete failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void update(ActionEvent event) {
        String memberid,bookid,date,returndate;
        LocalDate mydate = txtdate.getValue();
        LocalDate mydate2 = txtreturndate.getValue();
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id=Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));
            memberid = txtid.getText();
            bookid = txtbook.getSelectionModel().getSelectedItem().toString();
            date = mydate.toString();
            returndate = mydate2.toString();
            if(memberid.equals("")){
                txtlabel.setText("Blank field");
            }else{
                con = DbConnect.getConnect();
                try {
                    pst = con.prepareStatement("update lendbook set bookid=(select id from `book` where bookname=?),issuedate=?,returndate=? where id=?");
                    pst.setString(1, bookid);
                    pst.setString(2, date);
                    pst.setString(3, returndate);
                    pst.setInt(4, id);
                    int k = pst.executeUpdate();
                    if(k==1){
                        txtlabel.setText("Updated");
                        txtname.setText("");
                        txtid.setText("");
                        txtid.requestFocus();
                        load();
                    }else{
                        txtlabel.setText("Update failed");
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
            rs=con.createStatement().executeQuery("select l.id,m.mid,m.name,b.bookname,l.issuedate,l.returndate from lendbook l Join member m ON l.memberid=m.mid Join book b ON l.bookid=b.id");
            while(rs.next()){
                list.add(new issueTable(
                    rs.getString("l.id"),
                    rs.getString("m.mid"),
                    rs.getString("m.name"),
                    rs.getString("b.bookname"),
                    rs.getString("l.issuedate"),
                    rs.getString("l.returndate")
                    ));
            }
        } catch (SQLException e) {
            Logger.getLogger(issueTable.class.getName()).log(Level.SEVERE, null,e);
        }
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        memberidcol.setCellValueFactory(new PropertyValueFactory<>("mid"));
        memcol.setCellValueFactory(new PropertyValueFactory<>("name"));
        bookcol.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("issuedate"));
        returncol.setCellValueFactory(new PropertyValueFactory<>("returndate"));
        table.setItems(list);

        table.setRowFactory(tv -> {
            TableRow<issueTable> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    txtid.setText(table.getItems().get(myIndex).getmid());
                    txtname.setText(table.getItems().get(myIndex).getname());
                }
            });
            return myRow;
        });
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        book();
        load();
    }
}
