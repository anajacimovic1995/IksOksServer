/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class ZaustaviNit extends Thread{
    ServerSocket ss;
    PokreniNit pn;
    boolean kraj = false;
    public ZaustaviNit(ServerSocket ss, PokreniNit pn) {
        this.ss = ss;
        this.pn = pn;
    }   

    @Override
    public void run() {
        while(!kraj){
            if(pn.isInterrupted()){
                System.out.println("Nit je interruptovana");
                try {
                    ss.close();
                    System.out.println("Server je zaustavljen!");
                    kraj=true;
                    sleep(1000);
                   System.out.println("Nit je osvezena!");
                } catch (IOException ex) {
                    Logger.getLogger(ZaustaviNit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ZaustaviNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }
        if(kraj==true){
            System.out.println("Zaustavljen");
        }
    }
    
}
