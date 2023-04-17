/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClientFrame;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import server.UserDatabase;


public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelcomePanel
     */
    public LoginPanel() {
        initComponents();
    }

    public JLabel getBtOK() {
        return btOK;
    }

    public JTextField getTfHost() {
        return tfHost;
    }

    public JTextField getTfNickname() {
        return tfNickname;
    }

    public JLabel getBtSignUp_welcome() {
        return btSignUp_welcome;
    }

    public JTextField getTfPass() {
        return tfPass;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btSignUp_welcome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btOK = new javax.swing.JLabel();
        tfPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        tfNickname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Formulaire = new javax.swing.JLabel();
        Principal = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lock_26px.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 50, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/host.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        tfHost.setBackground(new java.awt.Color(33, 150, 243));
        tfHost.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tfHost.setForeground(new java.awt.Color(239, 239, 239));
        tfHost.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfHost.setText("localhost");
        tfHost.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfHost.setOpaque(false);
        tfHost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfHostKeyPressed(evt);
            }
        });
        add(tfHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 250, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Authentification");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 100, 20));

        btSignUp_welcome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSignUp_welcome.setForeground(new java.awt.Color(255, 255, 255));
        btSignUp_welcome.setText("Creer un utilisateur");
        btSignUp_welcome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btSignUp_welcome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSignUp_welcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSignUp_welcomeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSignUp_welcomeMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSignUp_welcomeMouseClicked(evt);
            }
        });
        add(btSignUp_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 110, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond.PNG"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 280, 80));

        btOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/entrer.PNG"))); // NOI18N
        btOK.setText("jLabel4");
        btOK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOKMouseClicked(evt);
            }
        });
        add(btOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 250, 40));

        tfPass.setBackground(new java.awt.Color(33, 150, 243));
        tfPass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfPass.setForeground(new java.awt.Color(239, 239, 239));
        tfPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfPass.setOpaque(false);
        tfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPassKeyReleased(evt);
            }
        });
        add(tfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 250, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond.PNG"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 280, 130));

        tfNickname.setBackground(new java.awt.Color(33, 150, 243));
        tfNickname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tfNickname.setForeground(new java.awt.Color(239, 239, 239));
        tfNickname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfNickname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfNickname.setOpaque(false);
        tfNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNicknameActionPerformed(evt);
            }
        });
        tfNickname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNicknameKeyPressed(evt);
            }
        });
        add(tfNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 290, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond.PNG"))); // NOI18N
        jLabel3.setOpaque(true);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 190, 70));

        Formulaire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond2.PNG"))); // NOI18N
        Formulaire.setText("Authentification");
        add(Formulaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 330, 510));

        Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond.PNG"))); // NOI18N
        add(Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void tfNicknameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNicknameKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfNicknameKeyPressed

    private void tfPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfPassKeyPressed

    private void tfPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassKeyReleased

    private void btOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOKMouseClicked
         
                        

    }//GEN-LAST:event_btOKMouseClicked

    private void btSignUp_welcomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSignUp_welcomeMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btSignUp_welcomeMouseClicked

    private void btSignUp_welcomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSignUp_welcomeMouseExited
        // TODO add your handling code here:
        btSignUp_welcome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_btSignUp_welcomeMouseExited

    private void btSignUp_welcomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSignUp_welcomeMouseEntered
        // TODO add your handling code here:
        btSignUp_welcome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_btSignUp_welcomeMouseEntered

    private void tfHostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHostKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHostKeyPressed

    private void tfNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNicknameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Formulaire;
    private javax.swing.JLabel Principal;
    private javax.swing.JLabel btOK;
    private javax.swing.JLabel btSignUp_welcome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JPasswordField tfPass;
    // End of variables declaration//GEN-END:variables
}
