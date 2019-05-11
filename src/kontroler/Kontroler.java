/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.DomainObject;

import java.net.Socket;
import java.util.ArrayList;
import niti.Obrada;
import so.log.LogIn;
import transferobjects.ServerTransferObject;

/**
 *
 * @author Ana
 */
public class Kontroler {
    private static Kontroler instance;
    private ArrayList<Obrada> klijenti;

    private Kontroler() {
        klijenti = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ArrayList<Obrada> getKlijenti() {
        return klijenti;
    }

//    public ServerTransferObject login(DomainObject gdo) throws Exception {
//        return new LogIn().izvrsi(gdo);
//    }
//
// 
//
//    public void ubaciUListuKlijenata(Obrada o) {
//        klijenti.add(o);
//    }
//
//    public void obrisiKlijenta(int o) {
//        klijenti.remove(o);
//    }
//    public int vratiKlijenta(Obrada o) {
//        
//       return klijenti.indexOf(o);
    
    
}
