/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;


import domen.DomainObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import kontroler.Kontroler;

import transferobjects.ClientTransferObject;
import transferobjects.ServerTransferObject;
import constants.Constants;
/**
 *
 * @author Ana
 */
public class Obrada extends Thread{
    private Socket s;

    public Obrada(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        while (true){
            
            try {
                ClientTransferObject kz = receiveRequest();
                ServerTransferObject so = new ServerTransferObject();
                DomainObject odo = (DomainObject) kz.getParameter();
                        
                switch(kz.getOperation()){
                    case Constants.LOGIN:
                        try {
//                            so = Kontroler.getInstance().login(odo);
                                    
                        } catch (Exception ex) {
                            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        break;
   
                    default:
                        System.out.println("Sistem ceka na operaciju!");
                        
                }
                sendResponse(so);   
            } catch (Exception ex) {
//                try {
//                    s.close();
//                    
//                } catch (IOException ex1) {
//                    Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex1);
//                }
                Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }
    private ClientTransferObject receiveRequest() {
        ClientTransferObject request = new ClientTransferObject();
        try {
            ObjectInputStream input = new ObjectInputStream(s.getInputStream());
            request = (ClientTransferObject) input.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//              kontroler.Kontroler.getInstance().obrisiKlijenta(this);
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }

    public void sendResponse(ServerTransferObject response) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
            output.writeObject(response);
        } catch (IOException ex) {
            System.out.println("Problem je u obradi");
            Logger.getLogger(Obrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

}
