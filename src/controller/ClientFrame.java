/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.UserDatabase;
import view.ClientPanel;
import view.LoginPanel;
import view.PrivateChat;
import view.RoomPanel;
import view.SignUpPanel;
import view.WelcomePanel;


public class ClientFrame extends JFrame implements Runnable {
    String serverHost;
    public static final String NICKNAME_EXIST = "nom d'utilisateur deja utilisé , essayer un autre svp!";
    public static final String NICKNAME_VALID = "nom d'utilisateur OK";
    public static final String NICKNAME_INVALID = "login incorrect";
    public static final String SIGNUP_SUCCESS = "Sign up succes!";
    public static final String ACCOUNT_EXIST = "nom d'utilisateur deja utilisé , essayer un autre svp!";
    
    String name;
    String room;
    Socket socketOfClient;
    BufferedWriter bw;
    BufferedReader br;
    
    JPanel mainPanel;
    LoginPanel loginPanel;
    ClientPanel clientPanel;
    WelcomePanel welcomePanel;
    SignUpPanel signUpPanel;
    RoomPanel roomPanel;
    
    Thread clientThread;
    boolean isRunning;
    
    JMenuBar menuBar;
    JMenuItem itemSendFile;
    JMenu menuAccount;
    JMenuItem itemLeaveRoom, itemLogout, itemChangePass;
    
    SendFileFrame sendFileFrame;
    ReceivingFileThread receivingFileThread;
    StringTokenizer tokenizer;
    String myDownloadFolder;
    
    Socket socketOfSender, socketOfReceiver;
    
    DefaultListModel<String> listModel, listModelThisRoom, listModel_rp;
        
    boolean isConnectToServer;
    
    int timeClicked = 0;    
    
    Hashtable<String, PrivateChat> listReceiver;
    
    //**********************************Constructeur*******************************************************************
   
    public ClientFrame(String name) {
        this.name = name;
        socketOfClient = null;
        bw = null;
        br = null;
        isRunning = true;
        listModel = new DefaultListModel<>();
        listModelThisRoom = new DefaultListModel<>();
        listModel_rp = new DefaultListModel<>();
        isConnectToServer = false;
        listReceiver = new Hashtable<>();
        
       
        mainPanel = new JPanel();
        loginPanel = new LoginPanel();
        clientPanel = new ClientPanel();
        welcomePanel = new WelcomePanel();
        signUpPanel = new SignUpPanel();
        roomPanel = new RoomPanel();
        
        //mainPanel.setSize(570, 450);
        welcomePanel.setVisible(false);
        signUpPanel.setVisible(false);
        loginPanel.setVisible(true);
        roomPanel.setVisible(false);
        clientPanel.setVisible(false);
        
        mainPanel.add(welcomePanel);
        mainPanel.add(loginPanel);
        mainPanel.add(signUpPanel);
        mainPanel.add(roomPanel);
        mainPanel.add(clientPanel);
        
        addEventsForWelcomePanel();
        addEventsForSignUpPanel();
        addEventsForLoginPanel();
        addEventsForClientPanel();
        addEventsForRoomPanel();
        
        menuBar = new JMenuBar();   //menuBar 
        menuAccount = new JMenu();
        itemLeaveRoom = new JMenuItem();
        itemLogout = new JMenuItem();
        itemChangePass = new JMenuItem();
        itemSendFile = new JMenuItem();     
        
        menuAccount.setText("compte");
        itemLogout.setText("Exit");
        itemLeaveRoom.setText("changer de bureau");
        menuAccount.add(itemLeaveRoom);
        menuAccount.add(itemLogout);
        
        
        
        menuBar.add(menuAccount);
        
        itemLeaveRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int kq = JOptionPane.showConfirmDialog(ClientFrame.this, "Quittez ce bureau?", "Notice", JOptionPane.YES_NO_OPTION);
                if(kq == JOptionPane.YES_OPTION) {
                    leaveRoom();
                }
            }
        });
        itemChangePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(ClientFrame.this, "", "", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        itemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int kq = JOptionPane.showConfirmDialog(ClientFrame.this, "vous etes sure?", "Notice", JOptionPane.YES_NO_OPTION);
                if(kq == JOptionPane.YES_OPTION) {
                    
                    isRunning = false;
                    System.exit(0);
                }
            }
        });
        itemSendFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 openSendFileFrame();
                //JOptionPane.showMessageDialog(ClientFrame.this, "This function has changed! Go to private chat to send a file", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuBar.setVisible(false);
        setJMenuBar(menuBar);
        pack();
        
        mainPanel.setBackground(new java.awt.Color(33, 150, 243));
        add(mainPanel);
        setSize(600,620);
        setLocation(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(name);
    }
    //**********************************fin du constructeur*******************************************************************
    
    
    //***************************************Evenement des bouton**********************************************************************
    private void addEventsForWelcomePanel() {
           
         welcomePanel.getBtLogin_welcome().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                welcomePanel.setVisible(false);
                signUpPanel.setVisible(false);
                loginPanel.setVisible(true);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
            }
        });
         
        loginPanel.getBtSignUp_welcome().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                welcomePanel.setVisible(false);
                signUpPanel.setVisible(true);
                loginPanel.setVisible(false);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
            }
        });
         
         
       
        
    }

    private void addEventsForSignUpPanel() {
        
         signUpPanel.getLbBack_signup().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                
                signUpPanel.setVisible(false);
                loginPanel.setVisible(true);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
            }
        });
         
        signUpPanel.getBtSignUp().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                btSignUpEvent();
            }
        });
        
       
    }

    private void addEventsForLoginPanel() {
        loginPanel.getTfNickname().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) btOkEvent();
            }
            
        });
        loginPanel.getTfPass().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) btOkEvent();
            }
            
        });
        
        loginPanel.getBtOK().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                    btOkEvent();    
            }
        });
        
    }

    private void addEventsForClientPanel() {
        clientPanel.getBtSend().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btSendEvent();
            }
        });
        clientPanel.getBtExit().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                btExitEvent();
            }
        });
        clientPanel.getTaInput().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    btSendEvent();
                    btClearEvent();
                }
            }
        });
        //*****************************Event emojis***************************************************
        clientPanel.getLbLike().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like");
            }
        });
        clientPanel.getLbLike1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like1");
            }
        });
        clientPanel.getLbLike2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like2");
            }
        });
        clientPanel.getLbLike3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like3");
            }
        });
        clientPanel.getLbLike4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like4");
            }
        });
        clientPanel.getLbLike5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like5");
            }
        });
        clientPanel.getLbLike6().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like6");
            }
        });
        clientPanel.getLbLike7().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like7");
            }
        });
        clientPanel.getLbLike8().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like8");
            }
        });
        clientPanel.getLbLike9().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like9");
            }
        });
        clientPanel.getLbLike10().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like10");
            }
        });
        
        clientPanel.getLbLike11().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like11");
            }
        });
        clientPanel.getLbLike12().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like12");
            }
        });
        clientPanel.getLbLike13().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like13");
            }
        });
        clientPanel.getLbLike14().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like14");
            }
        });
        clientPanel.getLbLike15().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like15");
            }
        });
        clientPanel.getLbLike16().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like16");
            }
        });
        clientPanel.getLbLike17().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like17");
            }
        });
        clientPanel.getLbLike18().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like18");
            }
        });
        clientPanel.getLbLike19().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like19");
            }
        });
        clientPanel.getLbLike20().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like20");
            }
        });
        clientPanel.getLbLike21().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like21");
            }
        });
        clientPanel.getLbLike22().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like22");
            }
        });
        clientPanel.getLbLike23().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like23");
            }
        });
        clientPanel.getLbLike24().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like24");
            }
        });
        clientPanel.getLbLike25().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like25");
            }
        });
        clientPanel.getLbLike26().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like26");
            }
        });
        clientPanel.getLbLike27().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like27");
            }
        });
        clientPanel.getLbLike28().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like28");
            }
        });
        clientPanel.getLbLike29().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like29");
            }
        });
        clientPanel.getLbLike30().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like30");
            }
        });
        clientPanel.getLbLike31().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like31");
            }
        });
        clientPanel.getLbLike32().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like32");
            }
        });
        clientPanel.getLbLike33().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like33");
            }
        });
        clientPanel.getLbLike34().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like34");
            }
        });
        clientPanel.getLbLike35().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like35");
            }
        });
        clientPanel.getLbLike36().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like36");
            }
        });
        clientPanel.getLbLike37().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like37");
            }
        });
        clientPanel.getLbLike38().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like38");
            }
        });
        clientPanel.getLbLike39().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like39");
            }
        });
        clientPanel.getLbLike40().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like40");
            }
        });
        clientPanel.getLbLike41().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like41");
            }
        });
        clientPanel.getLbLike42().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like42");
            }
        });
        clientPanel.getLbLike43().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like43");
            }
        });
        clientPanel.getLbLike44().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like44");
            }
        });
        clientPanel.getLbLike45().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like45");
            }
        });
        clientPanel.getLbLike46().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like46");
            }
        });
        clientPanel.getLbLike47().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like47");
            }
        });
        clientPanel.getLbLike48().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like48");
            }
        });
        clientPanel.getLbLike49().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like49");
            }
        });
        clientPanel.getLbLike50().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like50");
            }
        });
        clientPanel.getLbLike51().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like51");
            }
        });
        clientPanel.getLbLike52().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like52");
            }
        });
        clientPanel.getLbLike53().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like53");
            }
        });
        clientPanel.getLbLike54().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like54");
            }
        });
        clientPanel.getLbLike55().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like55");
            }
        });
        clientPanel.getLbLike56().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                sendToServer("CMD_ICON|like56");
            }
        });
        
        //********************************Fin event emojis*******************************************************************
        
        
        
        clientPanel.getOnlineList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                openPrivateChatInsideRoom();
            }
        });
    }
    
    private void addEventsForRoomPanel() {
        roomPanel.getLbRoom1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom1().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom2().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom3().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom4().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom5().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom6().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom6().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom7().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom7().getText();
                labelRoomEvent();
            }
        });
        roomPanel.getLbRoom8().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = roomPanel.getLbRoom8().getText();
                labelRoomEvent();
            }
        });
        
        roomPanel.getOnlineList_rp().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                openPrivateChatOutsideRoom();
            }
        });
    }
    
    //***********************************************************************************************************************
    
    private void openPrivateChatInsideRoom() {
        timeClicked++;
        if(timeClicked == 1) {
            Thread countingTo500ms = new Thread(counting);
            countingTo500ms.start();
        }

        if(timeClicked == 2) { 
            String nameClicked = clientPanel.getOnlineList().getSelectedValue();
            if(nameClicked.equals(ClientFrame.this.name)) {
                JOptionPane.showMessageDialog(ClientFrame.this, "Vous ne peut pas envoyer de message à vous meme!", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if(!listReceiver.containsKey(nameClicked)) {   
                PrivateChat pc = new PrivateChat(name, nameClicked, serverHost, bw, br);

                pc.getLbReceiver().setText("Chat privé avec \""+pc.receiver+"\"");
                pc.setTitle(name);
                pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pc.setVisible(true);

                listReceiver.put(nameClicked, pc);
            } else {
                PrivateChat pc = listReceiver.get(nameClicked);
                pc.setVisible(true);
            }
        }
    }
            
    private void openPrivateChatOutsideRoom() {
        timeClicked++;
        if(timeClicked == 1) {
            Thread countingTo500ms = new Thread(counting);
            countingTo500ms.start();
        }

        if(timeClicked == 2) {  
            String privateReceiver = roomPanel.getOnlineList_rp().getSelectedValue();
            PrivateChat pc = listReceiver.get(privateReceiver);
            if(pc == null) { 
                pc = new PrivateChat(name, privateReceiver, serverHost, bw, br);
                
                pc.getLbReceiver().setText("Chat privé avec \""+pc.receiver+"\"");
                pc.setTitle(pc.receiver);
                pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pc.setVisible(true);

                listReceiver.put(privateReceiver, pc);
            } else {
                pc.setVisible(true);
            }
        }
    }
    
//    private PrivateChat createNewPC() {    create new PrivateChat Frame
//        PrivateChat pc = new PrivateChat
//    }
    
    Runnable counting = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeClicked = 0;
        }
    };
    
    private void labelRoomEvent() {
        this.clientPanel.getTpMessage().setText("");
        this.sendToServer("CMD_ROOM|"+this.room);
        try {
            Thread.sleep(200);     
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.roomPanel.setVisible(false);
        this.clientPanel.setVisible(true);
        this.setTitle("\""+this.name+"\" - "+this.room);
        clientPanel.getLbRoom().setText(this.room);
    }
    
    private void leaveRoom() {
        this.sendToServer("CMD_LEAVE_ROOM|"+this.room);
        try {
            Thread.sleep(200);   
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        pack();
        
        mainPanel.setBackground(new java.awt.Color(33, 150, 243));
        add(mainPanel);
        setSize(600,620);
        setLocation(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.roomPanel.setVisible(true);
        this.clientPanel.setVisible(false);
        //clear the textPane message:
        clientPanel.getTpMessage().setText("");
        this.setTitle("\""+this.name+"\"");
    }
    //********************************************************
    
    ////////////////////////Events////////////////////////////
    private void btOkEvent() {
        String hostname = loginPanel.getTfHost().getText().trim();
        String nickname = loginPanel.getTfNickname().getText().trim();
        String pass = loginPanel.getTfPass().getText().trim();
        
        
        this.serverHost = hostname;
        this.name = nickname;
        
        if(hostname.equals("") || nickname.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(this, "completer tout les champs", "Notice!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!isConnectToServer) {
            isConnectToServer = true;   
            this.connectToServer(hostname); 
        }    
        this.sendToServer("CMD_CHECK_NAME|" +this.name+"|"+pass); 
        String response = this.recieveFromServer();
        
        if(response != null) {
            if (response.equals(NICKNAME_EXIST) || response.equals(NICKNAME_INVALID)) {
                JOptionPane.showMessageDialog(this, response, "Error", JOptionPane.ERROR_MESSAGE);
                //loginPanel.getBtOK().setText("OK");
            } else {
                
                loginPanel.setVisible(false);
                roomPanel.setVisible(true);
                
                clientPanel.setVisible(false);
                this.setTitle("\""+name+"\"");

                menuBar.setVisible(true);

                clientThread = new Thread(this);
                clientThread.start();
                this.sendToServer("CMD_ROOM|"+this.room);    

                System.out.println("this is \""+name+"\"");
                //loginPanel.getBtOK().setText("OK");
            }
        } else System.out.println("[btOkEvent()] Server n'est pas ouvert, ou a été fermé!");
    }
    
    private void btSignUpEvent() {
        String pass = this.signUpPanel.getTfPass().getText();
        String pass2 = this.signUpPanel.getTfPass2().getText();
        if(!pass.equals(pass2)) {
            JOptionPane.showMessageDialog(this, "Format mot de passe incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nickname = signUpPanel.getTfID().getText().trim();
            String hostName = signUpPanel.getTfHost().getText().trim();
            if(hostName.equals("") || nickname.equals("") || pass.equals("") || pass2.equals("")) {
                JOptionPane.showMessageDialog(this, "completer tous les champs", "Notice!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(!isConnectToServer) {
                isConnectToServer = true;   
                this.connectToServer(hostName); 
            }    
            this.sendToServer("CMD_SIGN_UP|" +nickname+"|"+pass);       
        
            String response = this.recieveFromServer();
            if(response != null) {
                if(response.equals(NICKNAME_EXIST) || response.equals(ACCOUNT_EXIST)) {
                    JOptionPane.showMessageDialog(this, response, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, response+"\n Vous pouvez maintenant revenir vers login et se connecter", "Succes!", JOptionPane.INFORMATION_MESSAGE);
                    signUpPanel.clearTf();
                }
            }
        }
        
    }
            
    private void btSendEvent() {
        String message = clientPanel.getTaInput().getText().trim();
        if(message.equals("")) clientPanel.getTaInput().setText("");
        else {
            this.sendToServer("CMD_CHAT|" + message);       
            this.btClearEvent();
        }
       
    }

    private void btClearEvent() {
        clientPanel.getTaInput().setText("");
    }

    private void btExitEvent() {
        try {
            isRunning = false;
            //this.disconnect();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

 private void openSendFileFrame() {
        sendFileFrame = new SendFileFrame(serverHost , name);
        sendFileFrame.name = this.name;
        sendFileFrame.socketOfSender = this.socketOfClient;
        sendFileFrame.bw = this.bw;
        sendFileFrame.br = this.br;
        sendFileFrame.setVisible(true);
        sendFileFrame.setLocation(450, 250);
         sendFileFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
    
    ////////////////////////End of Events////////////////////////////   
    
    public void connectToServer(String hostAddress) {  
        try {
            socketOfClient = new Socket(hostAddress, 9999);
            bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            
        } catch (java.net.UnknownHostException e) {
            JOptionPane.showMessageDialog(this, "Host IP is not correct.\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch (java.net.ConnectException e) {
            JOptionPane.showMessageDialog(this, "Server is unreachable, maybe server is not open yet, or can't find this host.\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch(java.net.NoRouteToHostException e) {
            JOptionPane.showMessageDialog(this, "Can't find this host!\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void sendToServer(String line) {
        try {
            this.bw.write(line);
            this.bw.newLine();  
            this.bw.flush();
        } catch (java.net.SocketException e) {
            JOptionPane.showMessageDialog(this, "Server est fermé!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NullPointerException e) {
            System.out.println("[sendToServer()] Server est fermé, ou deja fermé!");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieveFromServer() {
        try {
            return this.br.readLine();  
        } catch (java.lang.NullPointerException e) {
            System.out.println("[sendToServer()] Server est fermé, ou deja fermé!");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void disconnect() {
        System.out.println("disconnect()");
        try {
            if(br!=null) this.br.close();
            if(bw!=null) this.bw.close();
            if(socketOfClient!=null) this.socketOfClient.close();
            System.out.println("Deconnection");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClientFrame client = new ClientFrame(null);
        client.setVisible(true);
    }

    @Override
    public void run() {
        String response;
        String sender, receiver, fileName, thePersonIamChattingWith, thePersonSendFile;
        String msg;
        String cmd, icon;
        PrivateChat pc;
        
        while(isRunning) {
            response = this.recieveFromServer();  
            tokenizer = new StringTokenizer(response, "|");
            cmd = tokenizer.nextToken();
            switch (cmd) {
                case "CMD_CHAT":    
                    sender = tokenizer.nextToken();
                    msg = response.substring(cmd.length()+sender.length()+2, response.length());
                    
                    if(sender.equals(this.name)) this.clientPanel.appendMessage(sender+": ", msg, Color.BLACK, new Color(0, 102, 204));
                    else this.clientPanel.appendMessage(sender+": ", msg, Color.orange, new Color(56, 224, 0));
                    
                     break;
                    
                case "CMD_PRIVATECHAT":     
                    sender = tokenizer.nextToken();
                    msg = response.substring(cmd.length()+sender.length()+2, response.length());
                    
                    pc = listReceiver.get(sender);
                    
                    if(pc == null) {
                        pc = new PrivateChat(this.name, sender, serverHost, bw, br);
                        pc.sender = name;
                        pc.receiver = sender;
                        pc.serverHost = this.serverHost;
                        pc.bw = ClientFrame.this.bw;
                        pc.br = ClientFrame.this.br;

                        pc.getLbReceiver().setText("Private chat with \""+pc.receiver+"\"");
                        pc.setTitle(pc.receiver);
                        pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        pc.setVisible(true);   

                        listReceiver.put(sender, pc);
                    } else {
                        pc.setVisible(true);
                    }
                    //pc.appendMessage(sender+": ", msg, Color.CYAN, Color.GREEN);
                    pc.appendMessage_Left(sender+": ", msg);
                    break;
                    
                case "CMD_ONLINE_USERS":
                    listModel.clear();
                    listModel_rp.clear();
                    while(tokenizer.hasMoreTokens()) {
                        cmd = tokenizer.nextToken();
                        listModel.addElement(cmd);
                        listModel_rp.addElement(cmd);
                    }
                    clientPanel.getOnlineList().setModel(listModel);
                    
                    listModel_rp.removeElement(this.name);
                    roomPanel.getOnlineList_rp().setModel(listModel_rp);
                    break;
                    
                case "CMD_ONLINE_THIS_ROOM":
                    listModelThisRoom.clear();
                    while(tokenizer.hasMoreTokens()) {
                        cmd = tokenizer.nextToken();
                        listModelThisRoom.addElement(cmd);
                    }
                    clientPanel.getOnlineListThisRoom().setModel(listModelThisRoom);
                    break;
                    
//                case "CMD_SERVERISBUSY":
//                    JOptionPane.showMessageDialog(this, "Server is busy, please try to send file later", "Info", JOptionPane.INFORMATION_MESSAGE);
//                    break;
                    
                case "CMD_FILEAVAILABLE":
                    System.out.println("file available");
                    fileName = tokenizer.nextToken();
                    thePersonIamChattingWith = tokenizer.nextToken();
                    thePersonSendFile = tokenizer.nextToken();
                    
                    pc = listReceiver.get(thePersonIamChattingWith);
                    
                    if(pc == null) {
                        sender = this.name;
                        receiver = thePersonIamChattingWith;
                        pc = new PrivateChat(sender, receiver, serverHost, bw, br);
                        
                        pc.getLbReceiver().setText("Private chat with \""+pc.receiver+"\"");
                        pc.setTitle(pc.receiver);
                        pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        
                        listReceiver.put(receiver, pc);
                    }
                    
                    pc.setVisible(true);   
                    pc.insertButton(thePersonSendFile, fileName);
                    break;
                    
                
                    
                case "CMD_ICON":
                    icon = tokenizer.nextToken();
                    cmd = tokenizer.nextToken();    //cmd = sender
                    
                    if(cmd.equals(this.name)) this.clientPanel.appendMessage(cmd+": ", "\n  ", Color.BLACK, Color.BLACK);
                    else this.clientPanel.appendMessage(cmd+": ", "\n   ", Color.MAGENTA, Color.MAGENTA);
                    
                    switch (icon) {
                        case "like":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Facebook_Like_16.png")));
                            break;
                            
                        case "like1":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Planting_16.png")));
                            break;
                            
                        case "like2":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Soccer_Ball_16.png")));
                            break;
                            
                        case "like3":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Thumbs_Down_16.png")));
                            break;
                            
                        case "like4":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Scissors_16.png")));
                            break;
                            
                        case "like5":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Basketball_16.png")));
                            break;
                            
                        case "like6":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Happy_16.png")));
                            break;
                            
                        case "like7":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/In_Love_16.png")));
                            break;
                            
                        case "like8":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Kiss_16.png")));
                            break;
                        case "like9":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/LOL_16.png")));
                            break;
                        case "like10":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Neutral_16.png")));
                            break;
                        case "like11":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Question_16.png")));
                            break;
                            
                        case "like12":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Sad_16.png")));
                            break;
                            
                        case "like13":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Silent_16.png")));
                            break;
                            
                        case "like14":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Surprised_16.png")));
                            break;
                            
                        case "like15":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Tongue_Out_16.png")));
                            break;
                            
                        case "like16":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Cool_16.png")));
                            break;
                            
                        case "like17":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Angel_16.png")));
                            break;
                            
                        case "like18":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Crying_16.png")));
                            break;
                        case "like19":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Like_Filled_16.png")));
                            break;
                        case "like20":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Novel_16.png")));
                            break;
                        case "like21":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Trust_16.png")));
                            break;
                            
                        case "like22":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Birthday_Cake_16.png")));
                            break;
                            
                        case "like23":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Up_16.png")));
                            break;
                            
                        case "like24":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Cursor_16.png")));
                            break;
                            
                        case "like25":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Cursor_16.png")));
                            break;
                            
                        case "like26":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Peace_16.png")));
                            break;
                            
                        case "like27":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Hand_Rock_16.png")));
                            break;
                            
                        case "like28":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Beer_16.png")));
                            break;
                        case "like29":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Pizza_16.png")));
                            break;
                        case "like30":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Strawberry_16.png")));
                            break;
                        case "like31":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Watermelon_16.png")));
                            break;
                            
                        case "like32":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/French_Fries_16.png")));
                            break;
                            
                        case "like33":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Grapes_16.png")));
                            break;
                            
                        case "like34":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Citrus_16.png")));
                            break;
                            
                        case "like35":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Banana_16.png")));
                            break;
                            
                        case "like36":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Cafe_16.png")));
                            break;
                            
                        case "like37":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Cafe_16.png")));
                            break;
                            
                        case "like38":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Rice_Bowl_16.png")));
                            break;
                        case "like39":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Confectionery_16.png")));
                            break;
                        case "like40":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Beach_Ball_16.png")));
                            break;
                        case "like41":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Guitar_16.png")));
                            break;
                            
                        case "like42":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Bra_16.png")));
                            break;
                            
                        case "like43":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Nappy_16.png")));
                            break;
                            
                        case "like44":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Bavarian_Girl_16.png")));
                            break;
                            
                        case "like45":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Poo_16.png")));
                            break;
                            
                        case "like46":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Dog_16.png")));
                            break;
                            
                        case "like47":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Ok_16.png")));
                            break;
                            
                        case "like48":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Champagne_16.png")));
                            break;
                        case "like49":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/One_Ring_16.png")));
                            break;
                        case "like50":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Flower_16.png")));
                            break;
                        case "like51":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Human_Footprints_16.png")));
                            break;
                            
                        case "like52":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Women`s_Shoe_16.png")));
                            break;
                            
                        case "like53":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Trophy_16.png")));
                            break;
                            
                        case "like54":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Barcelona_FC_16.png")));
                            break;
                            
                        case "like55":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Flip_Flops_16.png")));
                            break;
                            
                        case "like56":
                            this.clientPanel.getTpMessage().insertIcon(new ImageIcon(getClass().getResource("/images/Cat_16.png")));
                            break;
                
  
                        default:
                            throw new AssertionError("The icon is invalid, or can't find icon!");
                    }
                    
                    break;
                    
                default:
                    if(!response.startsWith("CMD_")) {      
                        if(response.equals("Warnning: Server has been closed!")) {
                            this.clientPanel.appendMessage(response, Color.RED);
                        }
                        else this.clientPanel.appendMessage(response, new Color(153, 153, 153));
                    }
                   
            }
        }
        System.out.println("Disconnected to server!");
    }


}



