/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import forma.GlavnaServer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Ana
 */
public class Main extends Thread{

    public static void main(String[] args) {
        JFrame form;
        try {
            form = new GlavnaServer();
             form.setVisible(true);
        } catch (IOException ex) {
            System.out.println("Problem je u main-u");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
