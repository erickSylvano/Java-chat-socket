/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author Tsiry
 */
public class SendFileFrame extends javax.swing.JFrame {

     String name;
    public String thePersonIamChattingWith;
    Socket socketOfSender;
    String serverHost;
    BufferedWriter bw;
    BufferedReader br;
    
    public SendFileFrame(String serverHost, String sender) {
        initComponents();
        this.serverHost = serverHost;
        this.name = sender;
    }
    
    public JTextField getTfFilePath() {
        return tfFilePath;
    }

    public JTextField getTfReceiver() {
        return tfReceiver;
    }
    

    private void displayOpenDialog() {
        JFileChooser chooser = new JFileChooser();
        int kq = chooser.showOpenDialog(this);
        if(kq == JFileChooser.APPROVE_OPTION) {
            tfFilePath.setText(chooser.getSelectedFile().getAbsolutePath());
        } else tfFilePath.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFilePath = new javax.swing.JTextField();
        btBrowse = new javax.swing.JButton();
        tfReceiver = new javax.swing.JTextField();
        btSendFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFilePathActionPerformed(evt);
            }
        });

        btBrowse.setText("Browse");
        btBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBrowseActionPerformed(evt);
            }
        });

        tfReceiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfReceiverActionPerformed(evt);
            }
        });

        btSendFile.setText("send");
        btSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendFileActionPerformed(evt);
            }
        });

        jLabel1.setText("Send File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBrowse))
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBrowse))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSendFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFilePathActionPerformed

    private void tfReceiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfReceiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfReceiverActionPerformed

    private void btBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBrowseActionPerformed
        displayOpenDialog();
    }//GEN-LAST:event_btBrowseActionPerformed

    private void btSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendFileActionPerformed
        String receiver = tfReceiver.getText();
        String filePath = tfFilePath.getText();
        try {
            socketOfSender = new Socket(serverHost, 9999);   
            new SendingFileThread(this.name, receiver, filePath, socketOfSender, this, null).start();    
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSendFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SendFileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendFileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendFileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendFileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendFileFrame("localhost",null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBrowse;
    private javax.swing.JButton btSendFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField tfFilePath;
    private javax.swing.JTextField tfReceiver;
    // End of variables declaration//GEN-END:variables
}
