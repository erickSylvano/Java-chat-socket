/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SignUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelcomePanel
     */
    public SignUpPanel() {
        initComponents();
    }

    public JLabel getBtSignUp() {
        return BtSignUp;
    }

    public JTextField getTfHost() {
        return tfHost;
    }

    public JTextField getTfID() {
        return tfID;
    }

    public JLabel getLbBack_signup() {
        return lbBack_signup;
    }

    public JTextField getTfPass() {
        return tfPass;
    }
    
    public JTextField getTfPass2() {
        return tfPass2;
    }
    
    public void clearTf() {
        tfID.setText("");
        tfPass.setText("");
        tfPass2.setText("");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        tfPass2 = new javax.swing.JPasswordField();
        lbBack_signup = new javax.swing.JLabel();
        BtSignUp = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Formulaire = new javax.swing.JLabel();
        Principal = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/conf22.PNG"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        tfPass2.setBackground(new java.awt.Color(33, 150, 243));
        tfPass2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfPass2.setForeground(new java.awt.Color(239, 239, 239));
        tfPass2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfPass2.setOpaque(false);
        tfPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPass2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPass2KeyReleased(evt);
            }
        });
        add(tfPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 250, 30));

        lbBack_signup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbBack_signup.setForeground(new java.awt.Color(255, 255, 255));
        lbBack_signup.setText("Retour");
        lbBack_signup.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbBack_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBack_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBack_signupMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBack_signupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBack_signupMouseEntered(evt);
            }
        });
        add(lbBack_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

        BtSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/entrer.PNG"))); // NOI18N
        BtSignUp.setText("jLabel4");
        BtSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtSignUpMouseClicked(evt);
            }
        });
        add(BtSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 250, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ut22.PNG"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Groups_26px.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 30, 30));

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
        jLabel10.setText("Creer un utilisateur");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 170, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fond.PNG"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 280, 80));

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
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 280, 170));

        tfID.setBackground(new java.awt.Color(33, 150, 243));
        tfID.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tfID.setForeground(new java.awt.Color(239, 239, 239));
        tfID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfID.setOpaque(false);
        tfID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIDKeyPressed(evt);
            }
        });
        add(tfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 250, 30));

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

    private void tfIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIDKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfIDKeyPressed

    private void tfPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfPassKeyPressed

    private void tfPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassKeyReleased

    private void BtSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtSignUpMouseClicked

        

    }//GEN-LAST:event_BtSignUpMouseClicked

    private void lbBack_signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBack_signupMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lbBack_signupMouseClicked

    private void lbBack_signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBack_signupMouseExited
        // TODO add your handling code here:
        lbBack_signup.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_lbBack_signupMouseExited

    private void lbBack_signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBack_signupMouseEntered
        // TODO add your handling code here:
        lbBack_signup.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_lbBack_signupMouseEntered

    private void tfHostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHostKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHostKeyPressed

    private void tfPass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPass2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPass2KeyPressed

    private void tfPass2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPass2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPass2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtSignUp;
    private javax.swing.JLabel Formulaire;
    private javax.swing.JLabel Principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbBack_signup;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfID;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JPasswordField tfPass2;
    // End of variables declaration//GEN-END:variables
}
