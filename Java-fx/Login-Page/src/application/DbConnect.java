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

public class DbConnect {
    
    private static String HOST = "sql6.freemysqlhosting.net";
        private static int PORT = 3306;
        private static String DB_NAME = "sql6478070";
        private static String USERNAME = "sql6478070";
        private static String PASSWORD = "xcvQ1LVh1q";
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
