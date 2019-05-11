/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma;


import db.DBResources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import niti.Obrada;
import kontroler.Kontroler;

import niti.PokreniNit;
import transferobjects.ServerTransferObject;


/**
 *
 * @author Ana
 */
public class GlavnaServer extends javax.swing.JFrame {
    PokreniNit pn;
    private Properties prop;
 
    /**
     * Creates new form MainServer
     */
    public GlavnaServer() throws FileNotFoundException, IOException {
        initComponents();
    
        srediFormu();
    
        inicijalizacija();
        prop = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        prop.load(fis);
        
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPokreni = new javax.swing.JButton();
        btnZaustavi = new javax.swing.JButton();
        txtStanje = new javax.swing.JTextField();
        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPromeni = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Glavna serverska forma");

        btnPokreni.setText("Pokreni server");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnZaustavi.setText("Zaustavi server");
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        txtStanje.setText("Server nije pokrenut!");
        txtStanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStanjeActionPerformed(evt);
            }
        });

        jLabel2.setText("Password:");

        jLabel4.setText("Username:");

        jLabel5.setText("URL:");

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(txtUser)
                            .addComponent(pass))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel3)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPromeni)
                .addGap(22, 22, 22))
        );

        jButton1.setText("Izmeni parametre konekcije");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStanje, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPokreni)
                        .addGap(18, 18, 18)
                        .addComponent(btnZaustavi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreni)
                    .addComponent(btnZaustavi)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        pn = new PokreniNit();
        pn.start();
        txtStanje.setText("Server je pokrenut!");
        
        btnPokreni.setEnabled(false);
        btnZaustavi.setEnabled(true);
        txtUrl.setEditable(false);
        txtUser.setEditable(false);
        pass.setEditable(false);
        panel.setVisible(false);
        btnPromeni.setEnabled(false);

    }//GEN-LAST:event_btnPokreniActionPerformed

    private void txtStanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStanjeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStanjeActionPerformed

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviActionPerformed
        
//        ArrayList<Obrada> klijenti = kontroler.Kontroler.getInstance().getKlijenti();
//        if(klijenti!=null && klijenti.size()!=0){
//            for (Obrada o : klijenti) {
//                    ServerskiTransferObjekat so = new ServerskiTransferObjekat();
//                    so.setOdgovor(null);
//                    so.setPoruka("STOP");
//                    o.sendResponse(so);
//                    int index = Kontroler.getInstance().vratiKlijenta(o);
//                    if(index!=0){
//                        try {                                
//                            o.getS().close();
//                        } catch (IOException ex) {
//                            Logger.getLogger(GlavnaServer.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        int indexx = Kontroler.getInstance().vratiKlijenta(o)-1;
//                        Kontroler.getInstance().obrisiKlijenta(indexx);
//                    }
//                }
//        }
//        System.out.println("Br klijenata je " + klijenti.size());
        if (pn.isAlive() && pn != null) {
            
            pn.interrupt();
            txtStanje.setText("Server nije pokrenut!");
            panel.setVisible(false);
            btnPokreni.setEnabled(true);
            btnZaustavi.setEnabled(false);
            txtUrl.setEditable(true);
            txtUser.setEditable(true);
            pass.setEditable(true);
            btnPromeni.setEnabled(true);
        }
    }//GEN-LAST:event_btnZaustaviActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
            PrintWriter write = null;
        try {
            String url = txtUrl.getText().trim();
            String user = txtUser.getText().trim();
            String passs = String.valueOf(pass.getPassword());

            write = new PrintWriter("db.properties");
            write.print("");
            write.print("url=" + url);
            write.print("\n");
            write.print("username=" + user);
            write.print("\n");
            write.print("password=" + passs);
            write.close();
            JOptionPane.showMessageDialog(this, "Sistem je sacuvao parametre", "Uspesno", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            Logger.getLogger(GlavnaServer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem nije sacuvao parametre", "Neuspesno", JOptionPane.ERROR_MESSAGE);

        }
        panel.setVisible(false);
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GlavnaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GlavnaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GlavnaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GlavnaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new GlavnaServer().setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(GlavnaServer.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField txtStanje;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        panel.setVisible(false);
        txtStanje.setEditable(false);
        btnZaustavi.setEnabled(false);           
    
    
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    private void inicijalizacija() {
        try {
            DBResources dbr = new DBResources();
            txtUrl.setText(dbr.getUrl());
            txtUser.setText(dbr.getUsername());
            pass.setText(dbr.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(GlavnaServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
