package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class databaseController implements Initializable{
    @FXML private TextField txtdbname;
    @FXML private TextField txthost;
    @FXML private TextField txtpass;
    @FXML private TextField txtport;
    @FXML private TextField txtusername;
    @FXML private Label txtlabel;
    
    @FXML
    void submit(ActionEvent event) throws IOException {
        write();
        txtlabel.setText("Database Updated. Please Confirm Before Logout the program");
    }
    static ArrayList readfile(){
        ArrayList<String> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/application/dbinfo.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str=br.readLine())!=null){
                data.add(str);
            }
            br.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        return data;
    }
    void write() throws IOException{
        String host,port,dbname,username,pass;
        host = txthost.getText();
        port = txtport.getText();
        dbname = txtdbname.getText();
        username = txtusername.getText();
        pass = txtpass.getText();
        FileWriter write = new FileWriter("src/application/dbinfo.txt");
        write.write(host+"\n");
        write.write(port+"\n");
        write.write(dbname+"\n");
        write.write(username+"\n");
        write.write(pass+"\n");
        write.close();
    }
    void settxt(){
        txthost.setText((String) readfile().get(0));
        txtport.setText((String) readfile().get(1));
        txtdbname.setText((String) readfile().get(2));
        txtusername.setText((String) readfile().get(3));
        txtpass.setText((String)readfile().get(4));
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        settxt();
        txtlabel.setText("Note : If the database don't have password please input \"None\"");
    }
}
