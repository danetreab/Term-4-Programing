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
import javafx.scene.input.KeyEvent;

public class returnController implements Initializable {
    @FXML private TableColumn<returnTable, String> bnamecol;
    @FXML private TableColumn<returnTable, String> idcol;
    @FXML private TableColumn<returnTable, String> midcol;
    @FXML private TableColumn<returnTable, String> mnamecol;
    @FXML private TableColumn<returnTable, String> returnDatecol;
    @FXML private TableColumn<returnTable, String> daysElipcol;
    @FXML private TableColumn<returnTable, String> finecol;
    @FXML private TableView<returnTable> table;
    @FXML private Label txtlabel;
    @FXML private TextField txtDayElip;
    @FXML private TextField txtFine;
    @FXML private Label lbReturnDate;
    @FXML private Label txtReturnDate;
    @FXML private TextField txtmemberid;
    @FXML private Label lbName;
    @FXML private Label txtName;
    @FXML private Label lbBook;
    @FXML private Label txtBookName;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    ObservableList<returnTable> list = FXCollections.observableArrayList();

    @FXML
    void txtmemberidKeyPressed(KeyEvent event) {
        String id = txtmemberid.getText();
        if (event.getCode().toString().equals("ENTER")) {
            try {
                pst = con.prepareStatement(
                        "SELECT m.name, b.bookname, l.returndate, DATEDIFF(now(), l.returndate) as elap FROM lendbook l JOIN member m ON l.memberid = m.id JOIN book b ON l.bookid = b.id and l.memberid = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    txtName.setText((rs.getString("m.name")).trim());
                    txtBookName.setText((rs.getString("b.bookname")).trim());
                    txtReturnDate.setText(rs.getString("l.returndate"));
                    txtDayElip.setText(rs.getString("elap"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(returnController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    void add(ActionEvent event) {
        String memberid = txtmemberid.getText();
        String mname = txtName.getText();
        String bname = txtBookName.getText();
        String returndate = txtReturnDate.getText();
        String dayselip = txtDayElip.getText();
        String fine = txtFine.getText();
        if (memberid.equals("") && returndate.equals("") && dayselip.equals("") || fine.equals("")) {
            txtlabel.setText("Blank field");
        } else {
            con = DbConnect.getConnect();
            try {
                pst = con.prepareStatement(
                        "insert into returnbook(mid,mname,bname,returndate,dayselip,fine) value(?,?,?,?,?,?)");
                pst.setString(1, memberid);
                pst.setString(2, mname);
                pst.setString(3, bname);
                pst.setString(4, returndate);
                pst.setString(5, dayselip);
                pst.setString(6, fine);
                int k = pst.executeUpdate();
                pst = con.prepareStatement("delete from lendbook where memberid = ?");
                pst.setString(1, memberid);
                pst.executeUpdate();
                if (k == 1) {
                    txtlabel.setText("Return Book successfully");
                    txtmemberid.setPromptText("Member ID");
                    txtName.setText("");
                    txtBookName.setText("");
                    txtReturnDate.setText("");
                    txtDayElip.setPromptText("Days Elapsed");
                    txtFine.setPromptText("Fine");
                    txtmemberid.requestFocus();
                    load();
                } else {
                    txtlabel.setText("Return Book failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void delete(ActionEvent event) {
        if (table.getSelectionModel().getSelectedIndex() == -1) {
            txtlabel.setText("Item not select");
        } else {
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            try {
                pst = con.prepareStatement("delete from returnbook where id =?");
                pst.setInt(1, id);
                int k = pst.executeUpdate();
                if (k == 1) {
                    txtlabel.setText("Delete successfully");
                    txtmemberid.setPromptText("Member ID");
                    txtName.setText("");
                    txtBookName.setText("");
                    txtReturnDate.setText("");
                    txtDayElip.setPromptText("Days Elapsed");
                    txtFine.setPromptText("Fine");
                    txtmemberid.requestFocus();
                    load();
                } else {
                    txtlabel.setText("Delete failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void update(ActionEvent event) {
        if (table.getSelectionModel().getSelectedIndex() == -1) {
            txtlabel.setText("Item not select");
        } else {
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

            String memberid = txtmemberid.getText();
            String mname = txtName.getText();
            String bname = txtBookName.getText();
            String returndate = txtReturnDate.getText();
            String dayselip = txtDayElip.getText();
            String fine = txtFine.getText();
            if (memberid.equals("") && returndate.equals("") && dayselip.equals("") || fine.equals("")) {
                txtlabel.setText("Blank field");
            } else {
                con = DbConnect.getConnect();
                try {
                    pst = con.prepareStatement(
                            "update returnbook set mid=?,mname=?,bname=?,returndate=?,dayselip=?,fine=? where id=?");
                    pst.setString(1, memberid);
                    pst.setString(2, mname);
                    pst.setString(3, bname);
                    pst.setString(4, returndate);
                    pst.setString(5, dayselip);
                    pst.setString(6, fine);
                    pst.setInt(7, id);
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        txtlabel.setText("Update successfully");
                        txtmemberid.setPromptText("Member ID");
                        txtName.setText("");
                        txtBookName.setText("");
                        txtReturnDate.setText("");
                        txtDayElip.setPromptText("Days Elapsed");
                        txtFine.setPromptText("Fine");
                        txtmemberid.requestFocus();
                        load();
                    } else {
                        txtlabel.setText("Update failed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeAllRows() {
        for (int i = 0; i < table.getItems().size(); i++) {
            table.getItems().clear();
        }
    }

    public void load() {
        removeAllRows();
        con = DbConnect.getConnect();
        try {
            rs = con.createStatement().executeQuery("select * from returnbook");
            while (rs.next()) {
                list.add(new returnTable(
                        rs.getString("id"),
                        rs.getString("mid"),
                        rs.getString("mname"),
                        rs.getString("bname"),
                        rs.getString("returndate"),
                        rs.getString("dayselip"),
                        rs.getString("fine")));
            }
        } catch (SQLException e) {
            Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null, e);
        }
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        midcol.setCellValueFactory(new PropertyValueFactory<>("mid"));
        mnamecol.setCellValueFactory(new PropertyValueFactory<>("mname"));
        bnamecol.setCellValueFactory(new PropertyValueFactory<>("bname"));
        returnDatecol.setCellValueFactory(new PropertyValueFactory<>("returndate"));
        daysElipcol.setCellValueFactory(new PropertyValueFactory<>("dayselip"));
        finecol.setCellValueFactory(new PropertyValueFactory<>("fine"));

        table.setItems(list);
        table.setRowFactory(tv -> {
            TableRow<returnTable> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    txtmemberid.setText(table.getItems().get(myIndex).getmId());
                    txtName.setText(table.getItems().get(myIndex).getmname());
                    txtBookName.setText(table.getItems().get(myIndex).getBookName());
                    txtReturnDate.setText(table.getItems().get(myIndex).getreturnDate());
                    txtDayElip.setText(table.getItems().get(myIndex).getdaysElip());
                    txtFine.setText(table.getItems().get(myIndex).getfine());
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
