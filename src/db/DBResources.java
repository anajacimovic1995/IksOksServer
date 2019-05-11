/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Konstante;

/**
 *
 * @author Ana
 */
public class DBResources {
    
    private Properties properties;
    private Connection connection;

    public DBResources() throws FileNotFoundException, SQLException{
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("db.properties");   //na casu smo ovde pisali relativnu putanju
            properties.load(fis);
        } catch (IOException ex) {
            try {
                
                kreirajFajl();
                FileInputStream fis = new FileInputStream("db.properties");
                properties.load(fis);
            } catch (IOException ex1) {
                Logger.getLogger(DBResources.class.getName()).log(Level.SEVERE, null, ex1);
            }
                
           
        }
    }
    public String getDriver(){
        return properties.getProperty(Konstante.DRIVER);
    }
    
    public String getUrl(){
        return properties.getProperty(Konstante.URL);
    }
    public String getUsername(){
        return properties.getProperty(Konstante.USERNAME);
    }
    public String getPassword(){
        return properties.getProperty(Konstante.PASSWORD);
    }

    private void kreirajFajl() {
        PrintWriter write = null;
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/diplomski_baza";
            String user = "root";
            String pass = "";

            write = new PrintWriter("db.properties");
            write.print("");
            write.print("driver=" + driver);
            write.print("\n");
            write.print("url=" + url);
            write.print("\n");
            write.print("username=" + user);
            write.print("\n");
            write.print("password=" + pass);
            write.close();

        } catch (Exception ex) {
//            Logger.getLogger(GlavnaServer.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
        
}
