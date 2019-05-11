/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ana
 */
public class PokreniNit extends Thread{
       private ServerSocket s;

    public PokreniNit() {
    }
   
   
    @Override
    public void run() {
        
        try {
            ServerSocket ss = new ServerSocket(9002);
            System.out.println("Server je pokrenut!");
            ZaustaviNit zn = new ZaustaviNit(ss,this);                    
            zn.start();
            
            while(!isInterrupted()){          
                System.out.println("Radi");
                Socket s = ss.accept();
                System.out.println("Klijent se zakacio!");
                
                Obrada o = new Obrada(s);
                o.start();
 //               kontroler.Kontroler.getInstance().ubaciUListuKlijenata(o);
        }
        } catch (IOException ex) {
            System.out.println("Ne radi");
        }
        
    }
}
