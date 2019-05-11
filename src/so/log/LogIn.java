/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.log;

import db.DBBroker;
import domen.DomainObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import constants.Constants;
import transferobjects.ServerTransferObject;
/**
 *
 * @author Ana
 */
public class LogIn extends Constants{



    protected void proveriPreduslov(DomainObject odo) throws Exception {
        
    }
    
    public ServerTransferObject izvrsi(DomainObject gdo) throws Exception {
     ServerTransferObject so = new ServerTransferObject();
        try {
            List<DomainObject> lista = gdo.ucitajListu(DBBroker.getInstance().select(gdo));
            if(lista.isEmpty())
                throw new Exception("Neuspesno prijavljivanje na sistem");
            so.setOdgovor(lista);
           
            so.setPoruka("Uspesno ste se prijavili na sistem");
        } catch (Exception ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno prijavljivanje na sistem");
        }
        return so;
    
    }
   
}
