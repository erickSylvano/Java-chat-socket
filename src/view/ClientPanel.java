/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClientFrame;
import controller.SendingFileThread;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Tsiry
 */
public class ClientPanel extends javax.swing.JPanel {

    JFileChooser chooser;
    String filePath;
    ;
    
    /**
     * Creates new form ClientPanel
     */
    public ClientPanel() {
        initComponents();
        chooser = new JFileChooser();
        
    }
    public String filename ="";
    public String file ="";
    public String path="";
    public void filen(){
        try{
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        file=f.getName();
        filename = f.getAbsolutePath();
        this.path= (filename);
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    public String getp(){
        return path;
    }
    
    public String getf(){
        return file;
    }
    
    public JLabel getBtExit() {
        return btExit;
    }

    public JButton getBtSend() {
        return btSend;
    }

    public JTextArea getTaInput() {
        return taInput;
    }
    
    public JTextPane getTpMessage() {
        return tpMessage;
    }

    
    public JList<String> getOnlineList() {
        return onlineList;
    }

    public JList<String> getOnlineListThisRoom() {
        return onlineListThisRoom;
    }

    public JLabel getLbRoom() {
        return lbRoom;
    }

    public JLabel getLbLike() {
        return lbLike;
    }
    public JLabel getLbLike1() {
        return lbLike1;
    }
    public JLabel getLbLike2() {
        return lbLike2;
    }
    public JLabel getLbLike3() {
        return lbLike3;
    }
    public JLabel getLbLike4() {
        return lbLike4;
    }
    public JLabel getLbLike5() {
        return lbLike5;
    }
    public JLabel getLbLike6() {
        return lbLike6;
    }
    public JLabel getLbLike7() {
        return lbLike7;
    }
    public JLabel getLbLike8() {
        return lbLike8;
    }
    public JLabel getLbLike9() {
        return lbLike9;
    }
    public JLabel getLbLike10() {
        return lbLike10;
    }
    public JLabel getLbLike11() {
        return lbLike11;
    }
    
    public JLabel getLbLike12() {
        return lbLike12;
    }
    public JLabel getLbLike13() {
        return lbLike13;
    }
    public JLabel getLbLike14() {
        return lbLike14;
    }
    public JLabel getLbLike15() {
        return lbLike15;
    }
    public JLabel getLbLike16() {
        return lbLike16;
    }
    public JLabel getLbLike17() {
        return lbLike17;
    }
    public JLabel getLbLike18() {
        return lbLike18;
    }
    public JLabel getLbLike19() {
        return lbLike19;
    }
    public JLabel getLbLike20() {
        return lbLike20;
    }
    public JLabel getLbLike21() {
        return lbLike21;
    }
    public JLabel getLbLike22() {
        return lbLike22;
    }
    public JLabel getLbLike23() {
        return lbLike23;
    }
    public JLabel getLbLike24() {
        return lbLike24;
    }
    public JLabel getLbLike25() {
        return lbLike25;
    }
    public JLabel getLbLike26() {
        return lbLike26;
    }
    public JLabel getLbLike27() {
        return lbLike27;
    }
    public JLabel getLbLike28() {
        return lbLike28;
    }
    public JLabel getLbLike29() {
        return lbLike29;
    }
    public JLabel getLbLike30() {
        return lbLike30;
    }
    public JLabel getLbLike31() {
        return lbLike31;
    }
    public JLabel getLbLike32() {
        return lbLike32;
    }
    public JLabel getLbLike33() {
        return lbLike33;
    }
    public JLabel getLbLike34() {
        return lbLike34;
    }
    public JLabel getLbLike35() {
        return lbLike35;
    }
    public JLabel getLbLike36() {
        return lbLike36;
    }
    public JLabel getLbLike37() {
        return lbLike37;
    }
    public JLabel getLbLike38() {
        return lbLike38;
    }
    public JLabel getLbLike39() {
        return lbLike39;
    }
    public JLabel getLbLike40() {
        return lbLike40;
    }
    public JLabel getLbLike41() {
        return lbLike41;
    }
    public JLabel getLbLike42() {
        return lbLike42;
    }
    public JLabel getLbLike43() {
        return lbLike43;
    }
    public JLabel getLbLike44() {
        return lbLike44;
    }
    public JLabel getLbLike45() {
        return lbLike45;
    }
    public JLabel getLbLike46() {
        return lbLike46;
    }
    public JLabel getLbLike47() {
        return lbLike47;
    }
    public JLabel getLbLike48() {
        return lbLike48;
    }
    public JLabel getLbLike49() {
        return lbLike49;
    }
    public JLabel getLbLike50() {
        return lbLike50;
    }
    public JLabel getLbLike51() {
        return lbLike51;
    }
    public JLabel getLbLike52() {
        return lbLike52;
    }
    public JLabel getLbLike53() {
        return lbLike53;
    }
    public JLabel getLbLike54() {
        return lbLike54;
    }
    public JLabel getLbLike55() {
        return lbLike55;
    }
    public JLabel getLbLike56() {
        return lbLike56;
    }
   

   
    

    public void appendMessage2(String msg1, String msg2, Color c1, Color c2) {  
        tpMessage.setEditable(true);
  
        int len = tpMessage.getDocument().getLength();
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c1);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "tahoma"); 
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);     
        
        tpMessage.setCaretPosition(len);    
        tpMessage.setCharacterAttributes(aset, false);  
        tpMessage.replaceSelection(msg1);           
        
        len = len + msg1.length();
        
        sc = StyleContext.getDefaultStyleContext();
        
        aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c2); 
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Arial"); //  FontFamily
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      
        
        tpMessage.setCaretPosition(len);
        tpMessage.setCharacterAttributes(aset, false);
        tpMessage.replaceSelection(msg2+"\n");   
        
        len = len + msg2.length();
        tpMessage.setCaretPosition(len);
        tpMessage.setEditable(false);
    }

    public void appendMessage2(String message, Color color) {
        int len = tpMessage.getDocument().getLength();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "tahoma");
        
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);    
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);     
        
        tpMessage.setCaretPosition(len);   
        tpMessage.setCharacterAttributes(aset, false); 
        tpMessage.replaceSelection(message+"\n");   
        
    }  
    public void appendMessage(String msg1, String msg2, Color c1, Color c2) {  

        int len = tpMessage.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "tahoma");
        StyleConstants.setBold(sas, true);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c1);
        
        try {
            doc.insertString(len, msg1, sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        doc = (StyledDocument) tpMessage.getDocument();
        len = len+msg1.length();
        
        sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "tahoma");
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, black);
        
        try {
            doc.insertString(len, msg2+"\n", sas);      
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage.setCaretPosition(len+msg2.length());
    }
    
    public void appendMessage(String message, Color color) {
        int len = tpMessage.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "tahoma");
        StyleConstants.setItalic(sas, false);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, color);
        
        try {
            doc.insertString(len, message+"\n", sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage.setCaretPosition(len+message.length());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        onlineListThisRoom = new javax.swing.JList<>();
        btExit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbRoom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        taInput = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        lbLike = new javax.swing.JLabel();
        lbLike1 = new javax.swing.JLabel();
        lbLike2 = new javax.swing.JLabel();
        lbLike3 = new javax.swing.JLabel();
        lbLike4 = new javax.swing.JLabel();
        lbLike5 = new javax.swing.JLabel();
        lbLike6 = new javax.swing.JLabel();
        lbLike7 = new javax.swing.JLabel();
        lbLike8 = new javax.swing.JLabel();
        lbLike9 = new javax.swing.JLabel();
        lbLike10 = new javax.swing.JLabel();
        lbLike11 = new javax.swing.JLabel();
        lbLike12 = new javax.swing.JLabel();
        lbLike13 = new javax.swing.JLabel();
        lbLike14 = new javax.swing.JLabel();
        lbLike15 = new javax.swing.JLabel();
        lbLike16 = new javax.swing.JLabel();
        lbLike17 = new javax.swing.JLabel();
        lbLike18 = new javax.swing.JLabel();
        lbLike19 = new javax.swing.JLabel();
        lbLike20 = new javax.swing.JLabel();
        lbLike21 = new javax.swing.JLabel();
        lbLike22 = new javax.swing.JLabel();
        lbLike23 = new javax.swing.JLabel();
        lbLike24 = new javax.swing.JLabel();
        lbLike25 = new javax.swing.JLabel();
        lbLike26 = new javax.swing.JLabel();
        lbLike27 = new javax.swing.JLabel();
        lbLike28 = new javax.swing.JLabel();
        lbLike29 = new javax.swing.JLabel();
        lbLike30 = new javax.swing.JLabel();
        lbLike31 = new javax.swing.JLabel();
        lbLike32 = new javax.swing.JLabel();
        lbLike33 = new javax.swing.JLabel();
        lbLike34 = new javax.swing.JLabel();
        lbLike35 = new javax.swing.JLabel();
        lbLike36 = new javax.swing.JLabel();
        lbLike37 = new javax.swing.JLabel();
        lbLike38 = new javax.swing.JLabel();
        lbLike39 = new javax.swing.JLabel();
        lbLike40 = new javax.swing.JLabel();
        lbLike41 = new javax.swing.JLabel();
        lbLike42 = new javax.swing.JLabel();
        lbLike43 = new javax.swing.JLabel();
        lbLike44 = new javax.swing.JLabel();
        lbLike45 = new javax.swing.JLabel();
        lbLike46 = new javax.swing.JLabel();
        lbLike47 = new javax.swing.JLabel();
        lbLike48 = new javax.swing.JLabel();
        lbLike49 = new javax.swing.JLabel();
        lbLike50 = new javax.swing.JLabel();
        lbLike51 = new javax.swing.JLabel();
        lbLike52 = new javax.swing.JLabel();
        lbLike53 = new javax.swing.JLabel();
        lbLike54 = new javax.swing.JLabel();
        lbLike55 = new javax.swing.JLabel();
        lbLike56 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tpMessage = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btSend = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(33, 150, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(255, 255, 255)));

        jPanel2.setBackground(new java.awt.Color(33, 150, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(255, 255, 255)));

        jPanel4.setBackground(new java.awt.Color(35, 145, 234));

        jLabel2.setBackground(new java.awt.Color(35, 145, 234));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(217, 212, 212));
        jLabel2.setText(" Personnel en ligne");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jScrollPane2.setBorder(null);

        onlineList.setBackground(new java.awt.Color(35, 145, 234));
        onlineList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        onlineList.setForeground(new java.awt.Color(255, 255, 255));
        onlineList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        onlineList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onlineList.setSelectionBackground(new java.awt.Color(0, 51, 153));
        jScrollPane2.setViewportView(onlineList);

        jPanel5.setBackground(new java.awt.Color(35, 145, 234));

        jLabel3.setBackground(new java.awt.Color(35, 145, 234));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(217, 212, 212));
        jLabel3.setText("Dans ce bureau");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(null);

        onlineListThisRoom.setBackground(new java.awt.Color(35, 145, 234));
        onlineListThisRoom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        onlineListThisRoom.setForeground(new java.awt.Color(255, 255, 255));
        onlineListThisRoom.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        onlineListThisRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onlineListThisRoom.setSelectionBackground(new java.awt.Color(0, 51, 153));
        jScrollPane3.setViewportView(onlineListThisRoom);

        btExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExit.setForeground(new java.awt.Color(255, 255, 255));
        btExit.setText("      Quitter");
        btExit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        btExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(btExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(33, 150, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        lbRoom.setBackground(new java.awt.Color(255, 255, 255));
        lbRoom.setForeground(new java.awt.Color(255, 255, 255));
        lbRoom.setText("Bureau");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home_26px.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bureau:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRoom)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(33, 150, 243));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        taInput.setColumns(20);
        taInput.setRows(5);
        jScrollPane6.setViewportView(taInput);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(33, 150, 243));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setMaximumSize(new java.awt.Dimension(426, 64));
        jPanel7.setMinimumSize(new java.awt.Dimension(426, 64));

        lbLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Facebook_Like_16.png"))); // NOI18N
        lbLike.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Planting_16.png"))); // NOI18N
        lbLike1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Soccer_Ball_16.png"))); // NOI18N
        lbLike2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Thumbs_Down_16.png"))); // NOI18N
        lbLike3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Scissors_16.png"))); // NOI18N
        lbLike4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Basketball_16.png"))); // NOI18N
        lbLike5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Happy_16.png"))); // NOI18N
        lbLike6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/In_Love_16.png"))); // NOI18N
        lbLike7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Kiss_16.png"))); // NOI18N
        lbLike8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOL_16.png"))); // NOI18N
        lbLike9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Neutral_16.png"))); // NOI18N
        lbLike10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Question_16.png"))); // NOI18N
        lbLike11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sad_16.png"))); // NOI18N
        lbLike12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Silent_16.png"))); // NOI18N
        lbLike13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Surprised_16.png"))); // NOI18N
        lbLike14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tongue_Out_16.png"))); // NOI18N
        lbLike15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cool_16.png"))); // NOI18N
        lbLike16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Angel_16.png"))); // NOI18N
        lbLike17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Crying_16.png"))); // NOI18N
        lbLike18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLike18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLike18MouseClicked(evt);
            }
        });

        lbLike19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Like_Filled_16.png"))); // NOI18N
        lbLike19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Novel_16.png"))); // NOI18N
        lbLike20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Trust_16.png"))); // NOI18N
        lbLike21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Birthday_Cake_16.png"))); // NOI18N
        lbLike22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Up_16.png"))); // NOI18N
        lbLike23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Cursor_16.png"))); // NOI18N
        lbLike24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Lizard_16.png"))); // NOI18N
        lbLike25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Peace_16.png"))); // NOI18N
        lbLike26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hand_Rock_16.png"))); // NOI18N
        lbLike27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Beer_16.png"))); // NOI18N
        lbLike28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pizza_16.png"))); // NOI18N
        lbLike29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Strawberry_16.png"))); // NOI18N
        lbLike30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Watermelon_16.png"))); // NOI18N
        lbLike31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/French_Fries_16.png"))); // NOI18N
        lbLike32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grapes_16.png"))); // NOI18N
        lbLike33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Citrus_16.png"))); // NOI18N
        lbLike34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Banana_16.png"))); // NOI18N
        lbLike35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hamburger_16.png"))); // NOI18N
        lbLike36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cafe_16.png"))); // NOI18N
        lbLike37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rice_Bowl_16.png"))); // NOI18N
        lbLike38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Confectionery_16.png"))); // NOI18N
        lbLike39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Beach_Ball_16.png"))); // NOI18N
        lbLike40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guitar_16.png"))); // NOI18N
        lbLike41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bra_16.png"))); // NOI18N
        lbLike42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nappy_16.png"))); // NOI18N
        lbLike43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bavarian_Girl_16.png"))); // NOI18N
        lbLike44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Poo_16.png"))); // NOI18N
        lbLike45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dog_16.png"))); // NOI18N
        lbLike46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ok_16.png"))); // NOI18N
        lbLike47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Champagne_16.png"))); // NOI18N
        lbLike48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/One_Ring_16.png"))); // NOI18N
        lbLike49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flower_16.png"))); // NOI18N
        lbLike50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Human_Footprints_16.png"))); // NOI18N
        lbLike51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Women`s_Shoe_16.png"))); // NOI18N
        lbLike52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Trophy_16.png"))); // NOI18N
        lbLike53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Barcelona_FC_16.png"))); // NOI18N
        lbLike54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flip_Flops_16.png"))); // NOI18N
        lbLike55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbLike56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cat_16.png"))); // NOI18N
        lbLike56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbLike1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike39))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbLike2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLike56)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lbLike)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLike22)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLike)
                            .addComponent(lbLike3)
                            .addComponent(lbLike6)
                            .addComponent(lbLike7)
                            .addComponent(lbLike8)
                            .addComponent(lbLike9)
                            .addComponent(lbLike10)
                            .addComponent(lbLike11)
                            .addComponent(lbLike12)
                            .addComponent(lbLike13)
                            .addComponent(lbLike14)
                            .addComponent(lbLike15)
                            .addComponent(lbLike16)
                            .addComponent(lbLike17)
                            .addComponent(lbLike18)
                            .addComponent(lbLike19)
                            .addComponent(lbLike20)
                            .addComponent(lbLike21)
                            .addComponent(lbLike22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbLike1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbLike23, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lbLike24)
                            .addComponent(lbLike25)
                            .addComponent(lbLike26)
                            .addComponent(lbLike27)
                            .addComponent(lbLike28)
                            .addComponent(lbLike29)
                            .addComponent(lbLike30)
                            .addComponent(lbLike31)
                            .addComponent(lbLike32)
                            .addComponent(lbLike33)
                            .addComponent(lbLike34)
                            .addComponent(lbLike35)
                            .addComponent(lbLike36)
                            .addComponent(lbLike37)
                            .addComponent(lbLike38)
                            .addComponent(lbLike39)))
                    .addComponent(lbLike4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbLike2)
                    .addComponent(lbLike5)
                    .addComponent(lbLike40)
                    .addComponent(lbLike41)
                    .addComponent(lbLike42)
                    .addComponent(lbLike43)
                    .addComponent(lbLike44)
                    .addComponent(lbLike45)
                    .addComponent(lbLike46)
                    .addComponent(lbLike47)
                    .addComponent(lbLike48)
                    .addComponent(lbLike49)
                    .addComponent(lbLike50)
                    .addComponent(lbLike51)
                    .addComponent(lbLike52)
                    .addComponent(lbLike53)
                    .addComponent(lbLike54)
                    .addComponent(lbLike55)
                    .addComponent(lbLike56))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tpMessage.setEditable(false);
        jScrollPane4.setViewportView(tpMessage);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        btSend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSend.setText("Envoyer");
        btSend.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbLike18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLike18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbLike18MouseClicked

    private void btSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btExit;
    private javax.swing.JButton btSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbLike;
    private javax.swing.JLabel lbLike1;
    private javax.swing.JLabel lbLike10;
    private javax.swing.JLabel lbLike11;
    private javax.swing.JLabel lbLike12;
    private javax.swing.JLabel lbLike13;
    private javax.swing.JLabel lbLike14;
    private javax.swing.JLabel lbLike15;
    private javax.swing.JLabel lbLike16;
    private javax.swing.JLabel lbLike17;
    private javax.swing.JLabel lbLike18;
    private javax.swing.JLabel lbLike19;
    private javax.swing.JLabel lbLike2;
    private javax.swing.JLabel lbLike20;
    private javax.swing.JLabel lbLike21;
    private javax.swing.JLabel lbLike22;
    private javax.swing.JLabel lbLike23;
    private javax.swing.JLabel lbLike24;
    private javax.swing.JLabel lbLike25;
    private javax.swing.JLabel lbLike26;
    private javax.swing.JLabel lbLike27;
    private javax.swing.JLabel lbLike28;
    private javax.swing.JLabel lbLike29;
    private javax.swing.JLabel lbLike3;
    private javax.swing.JLabel lbLike30;
    private javax.swing.JLabel lbLike31;
    private javax.swing.JLabel lbLike32;
    private javax.swing.JLabel lbLike33;
    private javax.swing.JLabel lbLike34;
    private javax.swing.JLabel lbLike35;
    private javax.swing.JLabel lbLike36;
    private javax.swing.JLabel lbLike37;
    private javax.swing.JLabel lbLike38;
    private javax.swing.JLabel lbLike39;
    private javax.swing.JLabel lbLike4;
    private javax.swing.JLabel lbLike40;
    private javax.swing.JLabel lbLike41;
    private javax.swing.JLabel lbLike42;
    private javax.swing.JLabel lbLike43;
    private javax.swing.JLabel lbLike44;
    private javax.swing.JLabel lbLike45;
    private javax.swing.JLabel lbLike46;
    private javax.swing.JLabel lbLike47;
    private javax.swing.JLabel lbLike48;
    private javax.swing.JLabel lbLike49;
    private javax.swing.JLabel lbLike5;
    private javax.swing.JLabel lbLike50;
    private javax.swing.JLabel lbLike51;
    private javax.swing.JLabel lbLike52;
    private javax.swing.JLabel lbLike53;
    private javax.swing.JLabel lbLike54;
    private javax.swing.JLabel lbLike55;
    private javax.swing.JLabel lbLike56;
    private javax.swing.JLabel lbLike6;
    private javax.swing.JLabel lbLike7;
    private javax.swing.JLabel lbLike8;
    private javax.swing.JLabel lbLike9;
    private javax.swing.JLabel lbRoom;
    private javax.swing.JList<String> onlineList;
    private javax.swing.JList<String> onlineListThisRoom;
    private javax.swing.JTextArea taInput;
    private javax.swing.JTextPane tpMessage;
    // End of variables declaration//GEN-END:variables
}
