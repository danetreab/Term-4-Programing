package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



public class publisherController implements Initializable {
    @FXML private TableView<publisherTable> table;
    @FXML private TableColumn<publisherTable,String> idcol;
    @FXML private TableColumn<publisherTable,String> addresscol;
    @FXML private TableColumn<publisherTable, String> namecol;
    @FXML private TableColumn<publisherTable,String> phonecol;
    @FXML private TextField addresstextfield;
    @FXML private TextField nametextfield;
    @FXML private TextField phonetextfield;
    @FXML private Label txtlabel;

    public Connection con;
    PreparedStatement pst;
    int id;
    int myIndex;
    ObservableList<publisherTable> models = FXCollections.observableArrayList();

    @FXML
    void onadd() {
        String pname, paddress, pcontact;
        pname = nametextfield.getText();
        paddress = addresstextfield.getText();
        pcontact = phonetextfield.getText();
        if(pname.equals("")&&paddress.equals("")&&pcontact.equals("") || pname.equals("")){
            txtlabel.setText("Blank field");
        }else{
            try {
                con = DbConnect.getConnect();
                pst = con.prepareStatement("insert into publisher(name,address,phone)values(?,?,?)");
                pst.setString(1, pname);
                pst.setString(2, paddress);
                pst.setString(3, pcontact);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Publisher Created");
                    load();
                    nametextfield.setText("");
                    addresstextfield.setText("");
                    phonetextfield.setText("");
                    nametextfield.requestFocus();
                }else{
                    txtlabel.setText("Add Member failed");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(publisherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public void removeAllRows(){
        for ( int i = 0; i<table.getItems().size(); i++) {
            table.getItems().clear(); 
        } 
    }
    public void load() {
        removeAllRows();
        con = DbConnect.getConnect();
            try {
                pst = con.prepareStatement("select * from publisher");
                ResultSet rs = pst.executeQuery();
                {
                    while (rs.next()) {
                        publisherTable st = new publisherTable();
                        st.setId(rs.getString("id"));
                        st.setName(rs.getString("name"));
                        st.setAddress(rs.getString("address"));
                        st.setphone(rs.getString("phone"));
                        models.add(st);
                    }
                }
                table.setItems(models);
                idcol.setCellValueFactory(f -> f.getValue().idProperty());
                namecol.setCellValueFactory(f -> f.getValue().nameProperty());
                addresscol.setCellValueFactory(f -> f.getValue().addressProperty());
                phonecol.setCellValueFactory(f -> f.getValue().phoneProperty());
            }
            catch(SQLException ex)
            {
                Logger.getLogger(publisherController.class.getName()).log(Level.SEVERE, null, ex);
            }
            table.setRowFactory(tv -> {
                TableRow<publisherTable> myRow = new TableRow<>();
                myRow.setOnMouseClicked(event ->
                {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                        int myIndex = table.getSelectionModel().getSelectedIndex();

                        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                        nametextfield.setText(table.getItems().get(myIndex).getName());
                        addresstextfield.setText(table.getItems().get(myIndex).getAddress());
                        phonetextfield.setText(table.getItems().get(myIndex).getphone());

                    }
                });
                return myRow;
            });
    }
    @FXML
    void ondelete() {
        if(table.getSelectionModel().getSelectedIndex()==-1){
            txtlabel.setText("Item not select");
        }
        else{
            myIndex = table.getSelectionModel().getSelectedIndex();
            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            try{
                pst = con.prepareStatement("delete from publisher where id = ? ");
                pst.setInt(1, id);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Publisher Deleted");
                    nametextfield.setText("");
                    addresstextfield.setText("");
                    phonetextfield.setText("");
                    nametextfield.requestFocus();
                    load();
                }else{
                    txtlabel.setText("Delet Publisher failed");
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(publisherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void onedit() {
        String pname, paddress, pcontact;
        myIndex = table.getSelectionModel().getSelectedIndex();
        if(myIndex==-1){
            txtlabel.setText("Item not select");
        }
        else{
            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            pname = nametextfield.getText();
            paddress = addresstextfield.getText();
            pcontact= phonetextfield.getText();
            try
            {
                pst = con.prepareStatement("update publisher set name = ?,address = ? ,phone = ? where id = ? ");
                pst.setString(1, pname);
                pst.setString(2, paddress);
                pst.setString(3, pcontact);
                pst.setInt(4, id);
                int k = pst.executeUpdate();
                if(k==1){
                    txtlabel.setText("Publisher Updated");
                    nametextfield.setText("");
                    addresstextfield.setText("");
                    phonetextfield.setText("");
                    nametextfield.requestFocus();
                    load();
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(publisherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
    }
}






