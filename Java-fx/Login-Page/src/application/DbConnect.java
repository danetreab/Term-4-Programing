/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnect extends databaseController{
        private static String HOST = (String) readfile().get(0);
        private static int PORT = Integer.parseInt((String) readfile().get(1));
        private static String DB_NAME = (String) readfile().get(2);
        private static String USERNAME = (String) readfile().get(3);
        private static String PASSWORD = ((String) readfile().get(4)).equals("None") ? "": (String) readfile().get(4);
        private static Connection connection ;
        
        
        public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            return  connection;
        }
}