package com.application;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController extends SHA256{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @FXML TextField email;
    @FXML PasswordField pass;
    @FXML Label message;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void submit(ActionEvent event) throws NoSuchAlgorithmException{
        String mail = email.getText();
        String nonehase = pass.getText();
        String password = toHexString(getSHA(nonehase));
        if(mail.equals("")&&nonehase.equals("")){
            message.setText("Email or Password Blank");
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6478070","sql6478070","xcvQ1LVh1q");
                pst=con.prepareStatement("select * from usercredential where username=? and password=?");
                pst.setString(1,username);
                pst.setString(2,password);
                rs = pst.executeQuery();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
