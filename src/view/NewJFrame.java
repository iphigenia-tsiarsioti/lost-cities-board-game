/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import controller.Controller;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.anaktora.AnaktoraType;
import model.cards.Ariadne;
import model.cards.Card;
import model.cards.Minotaur;
import model.findings.Toixografies;
import model.random.RandomNumber;
/**
 *
 * @author iphigenia
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
       
       
        init_menu();
        initComponents();
        init_cardsButtons();
       // this.setResizable(false);
       init_paths();
        this.setTitle("Αναζητώντας τα Χαμένα Μινωικά Ανάκτορα");
        this.setSize(1800, 1000);
      //  this.setPreferredSize(new Dimension(600, 500));
       
    }
    
    /**
     * Transformer: initializes the buttons for the cards
     * Postcondition: CardsButtons initialized
     */
    private void init_cardsButtons(){
        //Player1 Buttons Cards
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        jButton10.setText("");
        
        //Player2 Button Cards
        jButton11.setText("");
        jButton12.setText("");
        jButton13.setText("");
        jButton14.setText("");
        jButton15.setText("");
        jButton16.setText("");
        jButton17.setText("");
        jButton18.setText("");
        
        jButton3.addMouseListener(new CardsButtonActionPerformed());// {
        jButton4.addMouseListener(new CardsButtonActionPerformed());
        jButton5.addMouseListener(new CardsButtonActionPerformed());
        jButton6.addMouseListener(new CardsButtonActionPerformed());
        jButton7.addMouseListener(new CardsButtonActionPerformed());
        jButton8.addMouseListener(new CardsButtonActionPerformed());
        jButton9.addMouseListener(new CardsButtonActionPerformed());
        jButton10.addMouseListener(new CardsButtonActionPerformed());
        jButton11.addMouseListener(new CardsButtonActionPerformed());
        jButton12.addMouseListener(new CardsButtonActionPerformed());
        jButton13.addMouseListener(new CardsButtonActionPerformed());
        jButton14.addMouseListener(new CardsButtonActionPerformed());
        jButton15.addMouseListener(new CardsButtonActionPerformed());
        jButton16.addMouseListener(new CardsButtonActionPerformed());
        jButton17.addMouseListener(new CardsButtonActionPerformed());
        jButton18.addMouseListener(new CardsButtonActionPerformed());
        
        //Add player1 buttons to arraylist
        buttonsP1.add(jButton3);
        buttonsP1.add(jButton4);
        buttonsP1.add(jButton5);
        buttonsP1.add(jButton6);
        buttonsP1.add(jButton7);
        buttonsP1.add(jButton8);
        buttonsP1.add(jButton9);
        buttonsP1.add(jButton10);
       
        //Add player2 buttons to arraylist
        buttonsP2.add(jButton11);
        buttonsP2.add(jButton12);
        buttonsP2.add(jButton13);
        buttonsP2.add(jButton14);
        buttonsP2.add(jButton15);
        buttonsP2.add(jButton16);
        buttonsP2.add(jButton17);
        buttonsP2.add(jButton18);
        
        playersButtons.add(buttonsP1);
        playersButtons.add(buttonsP2);

    
    }  
    /**
     * Transformer: Initializes the icons of the buttons
     * Postcondition: Icons of buttons initialized
     */
    private void init_buttons_icons(){
        for(int i=0;i<8;i++){
                      // buttonsP1.get(i).setIcon(Game.getPlayer(turn).getKartes().getCard(i).getImage());
                       Image newimg1 = new ImageIcon(Game.getPlayer(0).getKartes().getCard(i).getImage()).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                       Image newimg2 = new ImageIcon(Game.getPlayer(1).getKartes().getCard(i).getImage()).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                        buttonsP1.get(i).setIcon(new ImageIcon(newimg1));
                        buttonsP2.get(i).setIcon(new ImageIcon(newimg2));
                   }
    }
    /**
     * Transformer: Initializes the pawns
     * Postcondition: Pawns initialized
     */
    private void init_pawns(){
        P1Pawns.add(P1Pawn1);
        P1Pawns.add(P1Pawn2);
        P1Pawns.add(P1Pawn3);
        P1Pawns.add(P1Theseus);
       
        P2Pawns.add(P2Pawn1);
        P2Pawns.add(P2Pawn2);
        P2Pawns.add(P2Pawn3);
        P2Pawns.add(P2Theseus);

        playersPawns.add(P1Pawns);
        playersPawns.add(P2Pawns);
        int i=0;
        int x,y;
        while(i<2){
             for(int j=0;j<4;j++){
                 if(j<3) playersPawns.get(i).get(j).setIcon(new ImageIcon(new ImageIcon("src/images/pionia/arch.jpg").getImage().getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH)));
                 else playersPawns.get(i).get(j).setIcon(new ImageIcon(new ImageIcon("src/images/pionia/theseus.jpg").getImage().getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH)));
                playersPawns.get(i).get(j).setText("");
                playersPawns.get(i).get(j).setVisible(true);
                playersPawns.get(i).get(j).setOpaque(true);
                x=(int)knossosPath1.getLocation().getX();
                y=(int)knossosPath1.getLocation().getY();
             
             }
             i++;
        }
      
    }
    
    /**
     * Transformer: Initializes paths
     * Postcondition: Paths initialized
     */
    private void init_paths(){
        init_pawns();
        String image;
        Image pathImage ;
        Knossospath.add(knossosPath1);
        Knossospath.add(knossosPath2);
        Knossospath.add(knossosPath3);
        Knossospath.add(knossosPath4);
        Knossospath.add(knossosPath5);
        Knossospath.add(knossosPath6);
        Knossospath.add(knossosPath7);
        Knossospath.add(knossosPath8);
        Knossospath.add(knossosPath9);
        
        Maliapath.add(maliaPath1);
        Maliapath.add(maliaPath2);
        Maliapath.add(maliaPath3);
        Maliapath.add(maliaPath4);
        Maliapath.add(maliaPath5);
        Maliapath.add(maliaPath6);
        Maliapath.add(maliaPath7);
        Maliapath.add(maliaPath8);
        Maliapath.add(maliaPath9);
       
        Phaistospath.add(phaistosPath9);
        Phaistospath.add(phaistosPath8);
        Phaistospath.add(phaistosPath7);
        Phaistospath.add(phaistosPath6);
        Phaistospath.add(phaistosPath5);
        Phaistospath.add(phaistosPath4);
        Phaistospath.add(phaistosPath3);
        Phaistospath.add(phaistosPath2);
        Phaistospath.add(phaistosPath1);
        
        Zakrospath.add(zakrosPath9);
        Zakrospath.add(zakrosPath8);
        Zakrospath.add(zakrosPath7);
        Zakrospath.add(zakrosPath6);
        Zakrospath.add(zakrosPath5);
        Zakrospath.add(zakrosPath4);
        Zakrospath.add(zakrosPath3);
        Zakrospath.add(zakrosPath2);
        Zakrospath.add(zakrosPath1);
       
        for(int i=0;i<9;i++){
           if(i==8){
                image="src/images/paths/knossosPalace.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(140, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else if(i%2==0)  {
               
               image="src/images/paths/knossos.jpg";
                pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else {
               image="src/images/paths/knossos2.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           
           Knossospath.get(i).setText("");
           Knossospath.get(i).setIcon(new ImageIcon(pathImage));
           Knossospath.get(i).setVisible(true);
           Knossospath.get(i).setOpaque(true);
           
        }
        
          for(int i=0;i<9;i++){
           if(i==8){
                image="src/images/paths/maliaPalace.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(140, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else if(i%2==0)  {
               
               image="src/images/paths/malia.jpg";
                pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else {
               image="src/images/paths/malia2.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           
           Maliapath.get(i).setText("");
           Maliapath.get(i).setIcon(new ImageIcon(pathImage));
           Maliapath.get(i).setVisible(true);
           Maliapath.get(i).setOpaque(true);
           
        }
          
            for(int i=0;i<9;i++){
           if(i==8){
                image="src/images/paths/phaistosPalace.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(140, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else if(i%2==0)  {
               
               image="src/images/paths/phaistos.jpg";
                pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else {
               image="src/images/paths/phaistos2.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           
           Phaistospath.get(i).setText("");
           Phaistospath.get(i).setIcon(new ImageIcon(pathImage));
           Phaistospath.get(i).setVisible(true);
           Phaistospath.get(i).setOpaque(true);
           
        }
            for(int i=0;i<9;i++){
           if(i==8){
                image="src/images/paths/zakrosPalace.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(140, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else if(i%2==0)  {
               
               image="src/images/paths/zakros.jpg";
                pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           else {
               image="src/images/paths/zakros2.jpg";
               pathImage = new ImageIcon(image).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
           }
           
           Zakrospath.get(i).setText("");
           Zakrospath.get(i).setIcon(new ImageIcon(pathImage));
           Zakrospath.get(i).setVisible(true);
           Zakrospath.get(i).setOpaque(true);
           
        }
        AnaktoraPaths.add(Knossospath);
        AnaktoraPaths.add(Maliapath);
        AnaktoraPaths.add(Phaistospath);
        AnaktoraPaths.add(Zakrospath);
    }
    
    /**
     * Transformer: Initializes menu
     * Postcondition: Menu initialized
     */
    private void init_menu(){
        MenuBar= new javax.swing.JMenuBar();
        NewGame = new javax.swing.JMenuItem();
        SaveGame = new javax.swing.JMenuItem();
        ContinueSavedGame=new javax.swing.JMenuItem();
        ExitGame = new javax.swing.JMenuItem();
        
        NewGame.setText("New Game");
        SaveGame.setText("Save Game");
        ContinueSavedGame.setText("Continue Saved Game");
        ExitGame.setText("Exit Game");
       // init_cardsButtons();
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Game=new Controller();
                    Game.setTurn(turn);
                   
                  init_buttons_icons();
                    String text="Available Cards: "+Game.RemainingCards()+"\n Checkpoints: \n Turn:Player "+(turn+1);
                 Info.setText(text);
                 Info1.setText("Παίχτης 1 Διαθέσιμα Πιόνια:"+Game.getPlayer(0).NumOfArch()+" Αρχαιολόγοι και 1 Θησέας");
                 Info2.setText("Παίχτης 2 Διαθέσιμα Πιόνια:"+Game.getPlayer(1).NumOfArch()+" Αρχαιολόγοι και 1 Θησέας");
                 Agalmatakia1.setText("Αγαλματάκια: 0");
                 Agalmatakia2.setText("Αγαλματάκια: 0");
                } catch (Exception ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        SaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Save Game!");
            }
        });
        
        ContinueSavedGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Continue Saved Game!");
            }
        });
        
        ExitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        
        
        MenuBar.add(NewGame);
        MenuBar.add(SaveGame);
        MenuBar.add(ContinueSavedGame);
        MenuBar.add(ExitGame);

        this.setJMenuBar(MenuBar);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1Pane = new javax.swing.JLayeredPane();
        Player1Panel = new javax.swing.JPanel();
        Info1 = new javax.swing.JLabel();
        Score1 = new javax.swing.JLabel();
        Agalmatakia1 = new javax.swing.JLabel();
        Fresco1 = new javax.swing.JButton();
        ZakrosPanel1 = new javax.swing.JPanel();
        ZakrosLabel1 = new javax.swing.JLabel();
        PhaistosPanel1 = new javax.swing.JPanel();
        PhaistosLabel1 = new javax.swing.JLabel();
        MaliaPanel1 = new javax.swing.JPanel();
        MaliaLabel1 = new javax.swing.JLabel();
        KnossosPanel1 = new javax.swing.JPanel();
        KnossosLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        Player2Pane = new javax.swing.JLayeredPane();
        Player2Panel = new javax.swing.JPanel();
        Info2 = new javax.swing.JLabel();
        Score2 = new javax.swing.JLabel();
        Agalmatakia2 = new javax.swing.JLabel();
        Fresco2 = new javax.swing.JButton();
        ZakrosPanel2 = new javax.swing.JPanel();
        ZakrosLabel2 = new javax.swing.JLabel();
        PhaistosPanel2 = new javax.swing.JPanel();
        PhaistosLabel2 = new javax.swing.JLabel();
        MaliaPanel2 = new javax.swing.JPanel();
        MaliaLabel2 = new javax.swing.JLabel();
        KnossosPanel2 = new javax.swing.JPanel();
        KnossosLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        BoardPane = new javax.swing.JLayeredPane();
        InfoPanel = new javax.swing.JPanel();
        Info = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        P1Pawn1 = new javax.swing.JLabel();
        P1Pawn2 = new javax.swing.JLabel();
        P1Pawn3 = new javax.swing.JLabel();
        P1Theseus = new javax.swing.JLabel();
        P2Pawn1 = new javax.swing.JLabel();
        P2Pawn2 = new javax.swing.JLabel();
        P2Pawn3 = new javax.swing.JLabel();
        P2Theseus = new javax.swing.JLabel();
        knossosPath1 = new javax.swing.JLabel();
        knossosPath2 = new javax.swing.JLabel();
        knossosPath3 = new javax.swing.JLabel();
        knossosPath4 = new javax.swing.JLabel();
        knossosPath5 = new javax.swing.JLabel();
        knossosPath6 = new javax.swing.JLabel();
        knossosPath7 = new javax.swing.JLabel();
        knossosPath8 = new javax.swing.JLabel();
        knossosPath9 = new javax.swing.JLabel();
        maliaPath1 = new javax.swing.JLabel();
        maliaPath2 = new javax.swing.JLabel();
        maliaPath3 = new javax.swing.JLabel();
        maliaPath4 = new javax.swing.JLabel();
        maliaPath5 = new javax.swing.JLabel();
        maliaPath6 = new javax.swing.JLabel();
        maliaPath7 = new javax.swing.JLabel();
        maliaPath8 = new javax.swing.JLabel();
        maliaPath9 = new javax.swing.JLabel();
        phaistosPath1 = new javax.swing.JLabel();
        phaistosPath2 = new javax.swing.JLabel();
        phaistosPath3 = new javax.swing.JLabel();
        phaistosPath4 = new javax.swing.JLabel();
        phaistosPath5 = new javax.swing.JLabel();
        phaistosPath6 = new javax.swing.JLabel();
        phaistosPath7 = new javax.swing.JLabel();
        phaistosPath8 = new javax.swing.JLabel();
        phaistosPath9 = new javax.swing.JLabel();
        zakrosPath1 = new javax.swing.JLabel();
        zakrosPath2 = new javax.swing.JLabel();
        zakrosPath3 = new javax.swing.JLabel();
        zakrosPath4 = new javax.swing.JLabel();
        zakrosPath5 = new javax.swing.JLabel();
        zakrosPath6 = new javax.swing.JLabel();
        zakrosPath7 = new javax.swing.JLabel();
        zakrosPath8 = new javax.swing.JLabel();
        zakrosPath9 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Player1Pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        Player1Panel.setBackground(new java.awt.Color(255, 255, 255));

        Info1.setText("Παίχτης 1 Διαθέσιμα Πιόνια:");

        Score1.setText("Το Σκορ μου:  Πόντοι");

        Agalmatakia1.setText("Αγαλματάκια: ");

        Fresco1.setText("Οι Τοιχογραφίες μου");
        Fresco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fresco1ActionPerformed(evt);
            }
        });

        ZakrosPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 255)));

        ZakrosLabel1.setBackground(new java.awt.Color(255, 255, 255));
        ZakrosLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ZakrosLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZakrosLabel1.setText("Ζάκρος");
        ZakrosLabel1.setOpaque(true);

        javax.swing.GroupLayout ZakrosPanel1Layout = new javax.swing.GroupLayout(ZakrosPanel1);
        ZakrosPanel1.setLayout(ZakrosPanel1Layout);
        ZakrosPanel1Layout.setHorizontalGroup(
            ZakrosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZakrosLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        ZakrosPanel1Layout.setVerticalGroup(
            ZakrosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZakrosLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PhaistosPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        PhaistosPanel1.setMaximumSize(new java.awt.Dimension(40, 16));
        PhaistosPanel1.setMinimumSize(new java.awt.Dimension(40, 16));

        PhaistosLabel1.setBackground(new java.awt.Color(255, 255, 255));
        PhaistosLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        PhaistosLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhaistosLabel1.setText("Φαιστός");
        PhaistosLabel1.setOpaque(true);

        javax.swing.GroupLayout PhaistosPanel1Layout = new javax.swing.GroupLayout(PhaistosPanel1);
        PhaistosPanel1.setLayout(PhaistosPanel1Layout);
        PhaistosPanel1Layout.setHorizontalGroup(
            PhaistosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PhaistosLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );
        PhaistosPanel1Layout.setVerticalGroup(
            PhaistosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PhaistosLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MaliaPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));

        MaliaLabel1.setBackground(new java.awt.Color(255, 255, 255));
        MaliaLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        MaliaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MaliaLabel1.setText("Μάλια");
        MaliaLabel1.setOpaque(true);

        javax.swing.GroupLayout MaliaPanel1Layout = new javax.swing.GroupLayout(MaliaPanel1);
        MaliaPanel1.setLayout(MaliaPanel1Layout);
        MaliaPanel1Layout.setHorizontalGroup(
            MaliaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MaliaLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        MaliaPanel1Layout.setVerticalGroup(
            MaliaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MaliaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        KnossosPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));

        KnossosLabel1.setBackground(new java.awt.Color(255, 255, 255));
        KnossosLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        KnossosLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KnossosLabel1.setText("Κνωσσός");
        KnossosLabel1.setOpaque(true);

        javax.swing.GroupLayout KnossosPanel1Layout = new javax.swing.GroupLayout(KnossosPanel1);
        KnossosPanel1.setLayout(KnossosPanel1Layout);
        KnossosPanel1Layout.setHorizontalGroup(
            KnossosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KnossosLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        KnossosPanel1Layout.setVerticalGroup(
            KnossosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KnossosLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        jButton7.setText("jButton7");

        jButton8.setText("jButton8");

        jButton9.setText("jButton9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("jButton10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Player1PanelLayout = new javax.swing.GroupLayout(Player1Panel);
        Player1Panel.setLayout(Player1PanelLayout);
        Player1PanelLayout.setHorizontalGroup(
            Player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player1PanelLayout.createSequentialGroup()
                .addGroup(Player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(KnossosPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MaliaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PhaistosPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ZakrosPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(Player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fresco1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Score1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Agalmatakia1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        Player1PanelLayout.setVerticalGroup(
            Player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player1PanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Info1))
            .addGroup(Player1PanelLayout.createSequentialGroup()
                .addComponent(Score1)
                .addGap(45, 45, 45)
                .addComponent(Fresco1)
                .addGap(35, 35, 35)
                .addComponent(Agalmatakia1)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(Player1PanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(Player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KnossosPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaliaPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PhaistosPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ZakrosPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Player1Pane.setLayer(Player1Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Player1PaneLayout = new javax.swing.GroupLayout(Player1Pane);
        Player1Pane.setLayout(Player1PaneLayout);
        Player1PaneLayout.setHorizontalGroup(
            Player1PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Player1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Player1PaneLayout.setVerticalGroup(
            Player1PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Player1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(Player1Pane);
        Player1Pane.setBounds(0, -3, 2810, 180);

        Player2Pane.setBackground(new java.awt.Color(255, 255, 255));
        Player2Pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        Player2Pane.setForeground(new java.awt.Color(255, 255, 255));

        Player2Panel.setBackground(new java.awt.Color(255, 255, 255));

        Info2.setText("Παιχτης 2 Διαθεσιμα Πιόνια:");

        Score2.setText("Το Σκορ μου:  Πόντοι");

        Agalmatakia2.setText("Αγαλματάκια: ");

        Fresco2.setText("Οι Τοιχογραφίες μου");
        Fresco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fresco2ActionPerformed(evt);
            }
        });

        ZakrosPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        ZakrosPanel2.setPreferredSize(new java.awt.Dimension(91, 0));

        ZakrosLabel2.setBackground(new java.awt.Color(255, 255, 255));
        ZakrosLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ZakrosLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZakrosLabel2.setText("Ζάκρος");
        ZakrosLabel2.setOpaque(true);

        javax.swing.GroupLayout ZakrosPanel2Layout = new javax.swing.GroupLayout(ZakrosPanel2);
        ZakrosPanel2.setLayout(ZakrosPanel2Layout);
        ZakrosPanel2Layout.setHorizontalGroup(
            ZakrosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZakrosLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        ZakrosPanel2Layout.setVerticalGroup(
            ZakrosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZakrosLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PhaistosPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        PhaistosPanel2.setPreferredSize(new java.awt.Dimension(91, 0));

        PhaistosLabel2.setBackground(new java.awt.Color(255, 255, 255));
        PhaistosLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        PhaistosLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhaistosLabel2.setText("Φαιστός");
        PhaistosLabel2.setOpaque(true);

        javax.swing.GroupLayout PhaistosPanel2Layout = new javax.swing.GroupLayout(PhaistosPanel2);
        PhaistosPanel2.setLayout(PhaistosPanel2Layout);
        PhaistosPanel2Layout.setHorizontalGroup(
            PhaistosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PhaistosLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        PhaistosPanel2Layout.setVerticalGroup(
            PhaistosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PhaistosLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MaliaPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        MaliaPanel2.setPreferredSize(new java.awt.Dimension(91, 122));

        MaliaLabel2.setBackground(new java.awt.Color(255, 255, 255));
        MaliaLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        MaliaLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MaliaLabel2.setText("Μάλια");
        MaliaLabel2.setOpaque(true);

        javax.swing.GroupLayout MaliaPanel2Layout = new javax.swing.GroupLayout(MaliaPanel2);
        MaliaPanel2.setLayout(MaliaPanel2Layout);
        MaliaPanel2Layout.setHorizontalGroup(
            MaliaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MaliaPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MaliaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MaliaPanel2Layout.setVerticalGroup(
            MaliaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MaliaLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        KnossosPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        KnossosPanel2.setPreferredSize(new java.awt.Dimension(91, 0));

        KnossosLabel2.setBackground(new java.awt.Color(255, 255, 255));
        KnossosLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        KnossosLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KnossosLabel2.setText("Κνωσσός");
        KnossosLabel2.setOpaque(true);

        javax.swing.GroupLayout KnossosPanel2Layout = new javax.swing.GroupLayout(KnossosPanel2);
        KnossosPanel2.setLayout(KnossosPanel2Layout);
        KnossosPanel2Layout.setHorizontalGroup(
            KnossosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KnossosLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        KnossosPanel2Layout.setVerticalGroup(
            KnossosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KnossosLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton11.setText("jButton11");

        jButton12.setText("jButton12");

        jButton13.setText("jButton13");

        jButton14.setText("jButton14");

        jButton15.setText("jButton15");

        jButton16.setText("jButton16");

        jButton17.setText("jButton17");

        jButton18.setText("jButton18");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Player2PanelLayout = new javax.swing.GroupLayout(Player2Panel);
        Player2Panel.setLayout(Player2PanelLayout);
        Player2PanelLayout.setHorizontalGroup(
            Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player2PanelLayout.createSequentialGroup()
                .addGroup(Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(238, 238, 238)
                .addComponent(KnossosPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MaliaPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PhaistosPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ZakrosPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Score2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fresco2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Agalmatakia2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 1111, Short.MAX_VALUE))
        );
        Player2PanelLayout.setVerticalGroup(
            Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player2PanelLayout.createSequentialGroup()
                .addGroup(Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Player2PanelLayout.createSequentialGroup()
                        .addGroup(Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Player2PanelLayout.createSequentialGroup()
                                .addComponent(Score2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Fresco2)
                                .addGap(19, 19, 19))
                            .addGroup(Player2PanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)))
                        .addGroup(Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Agalmatakia2)
                            .addComponent(Info2)))
                    .addGroup(Player2PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KnossosPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(ZakrosPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(PhaistosPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(MaliaPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                .addContainerGap())
        );

        Player2Pane.setLayer(Player2Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Player2PaneLayout = new javax.swing.GroupLayout(Player2Pane);
        Player2Pane.setLayout(Player2PaneLayout);
        Player2PaneLayout.setHorizontalGroup(
            Player2PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Player2Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Player2PaneLayout.setVerticalGroup(
            Player2PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Player2PaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Player2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(Player2Pane);
        Player2Pane.setBounds(0, 755, 2810, 161);

        InfoPanel.setBorder(new javax.swing.border.MatteBorder(null));

        Info.setBackground(new java.awt.Color(255, 255, 255));
        Info.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Info.setOpaque(true);
        Info.setText("Turn:Player "+(turn+1));

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
            .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BoardPane.add(InfoPanel);
        InfoPanel.setBounds(10, 460, 290, 90);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cards/backCard.jpg"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        BoardPane.add(jButton1);
        jButton1.setBounds(20, 230, 150, 230);

        P1Pawn1.setText("P1Pawn1");
        P1Pawn1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BoardPane.add(P1Pawn1);
        P1Pawn1.setBounds(10, 36, 50, 70);

        P1Pawn2.setText("P1Pawn2");
        P1Pawn2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BoardPane.add(P1Pawn2);
        P1Pawn2.setBounds(10, 120, 50, 70);

        P1Pawn3.setText("P1Pawn3");
        P1Pawn3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BoardPane.add(P1Pawn3);
        P1Pawn3.setBounds(70, 40, 50, 70);

        P1Theseus.setText("P1Theseus");
        P1Theseus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BoardPane.add(P1Theseus);
        P1Theseus.setBounds(70, 120, 50, 70);

        P2Pawn1.setText("P2Pawn1");
        P2Pawn1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 51)));
        BoardPane.add(P2Pawn1);
        P2Pawn1.setBounds(130, 40, 50, 70);

        P2Pawn2.setText("P2Pawn2");
        P2Pawn2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 51)));
        BoardPane.add(P2Pawn2);
        P2Pawn2.setBounds(130, 120, 50, 70);

        P2Pawn3.setText("P2Pawn3");
        P2Pawn3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 51)));
        BoardPane.add(P2Pawn3);
        P2Pawn3.setBounds(190, 40, 50, 70);

        P2Theseus.setText("P2Theseus");
        P2Theseus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 51)));
        BoardPane.add(P2Theseus);
        P2Theseus.setBounds(190, 110, 50, 70);

        knossosPath1.setText("jLabel1");
        BoardPane.add(knossosPath1);
        knossosPath1.setBounds(300, 40, 100, 100);

        knossosPath2.setText("jLabel2");
        BoardPane.add(knossosPath2);
        knossosPath2.setBounds(410, 40, 100, 100);

        knossosPath3.setText("jLabel3");
        BoardPane.add(knossosPath3);
        knossosPath3.setBounds(520, 40, 100, 100);

        knossosPath4.setText("jLabel4");
        BoardPane.add(knossosPath4);
        knossosPath4.setBounds(620, 40, 100, 100);

        knossosPath5.setText("jLabel5");
        BoardPane.add(knossosPath5);
        knossosPath5.setBounds(730, 40, 100, 100);

        knossosPath6.setText("jLabel6");
        BoardPane.add(knossosPath6);
        knossosPath6.setBounds(830, 40, 100, 100);

        knossosPath7.setText("jLabel7");
        BoardPane.add(knossosPath7);
        knossosPath7.setBounds(940, 40, 100, 100);

        knossosPath8.setText("jLabel8");
        knossosPath8.setToolTipText("");
        BoardPane.add(knossosPath8);
        knossosPath8.setBounds(1050, 40, 100, 100);

        knossosPath9.setText("jLabel9");
        BoardPane.add(knossosPath9);
        knossosPath9.setBounds(1150, 40, 140, 100);

        maliaPath1.setText("jLabel1");
        BoardPane.add(maliaPath1);
        maliaPath1.setBounds(300, 160, 100, 100);

        maliaPath2.setText("jLabel2");
        BoardPane.add(maliaPath2);
        maliaPath2.setBounds(410, 160, 100, 100);

        maliaPath3.setText("jLabel3");
        BoardPane.add(maliaPath3);
        maliaPath3.setBounds(520, 160, 100, 100);

        maliaPath4.setText("jLabel4");
        BoardPane.add(maliaPath4);
        maliaPath4.setBounds(620, 160, 100, 100);

        maliaPath5.setText("jLabel5");
        BoardPane.add(maliaPath5);
        maliaPath5.setBounds(730, 160, 100, 100);

        maliaPath6.setText("jLabel6");
        BoardPane.add(maliaPath6);
        maliaPath6.setBounds(830, 160, 100, 100);

        maliaPath7.setText("jLabel7");
        BoardPane.add(maliaPath7);
        maliaPath7.setBounds(940, 160, 100, 100);

        maliaPath8.setText("jLabel8");
        BoardPane.add(maliaPath8);
        maliaPath8.setBounds(1050, 160, 100, 100);

        maliaPath9.setText("jLabel9");
        BoardPane.add(maliaPath9);
        maliaPath9.setBounds(1150, 160, 140, 100);

        phaistosPath1.setText("jLabel1");
        BoardPane.add(phaistosPath1);
        phaistosPath1.setBounds(1150, 280, 140, 100);

        phaistosPath2.setText("jLabel2");
        BoardPane.add(phaistosPath2);
        phaistosPath2.setBounds(1050, 280, 100, 100);

        phaistosPath3.setText("jLabel3");
        BoardPane.add(phaistosPath3);
        phaistosPath3.setBounds(940, 280, 100, 100);

        phaistosPath4.setText("jLabel4");
        BoardPane.add(phaistosPath4);
        phaistosPath4.setBounds(830, 280, 100, 100);

        phaistosPath5.setText("jLabel5");
        BoardPane.add(phaistosPath5);
        phaistosPath5.setBounds(730, 280, 100, 100);

        phaistosPath6.setText("jLabel6");
        BoardPane.add(phaistosPath6);
        phaistosPath6.setBounds(620, 280, 100, 100);

        phaistosPath7.setText("jLabel7");
        BoardPane.add(phaistosPath7);
        phaistosPath7.setBounds(520, 280, 100, 100);

        phaistosPath8.setText("jLabel8");
        BoardPane.add(phaistosPath8);
        phaistosPath8.setBounds(410, 280, 100, 100);

        phaistosPath9.setText("jLabel9");
        BoardPane.add(phaistosPath9);
        phaistosPath9.setBounds(300, 280, 100, 100);

        zakrosPath1.setText("jLabel1");
        BoardPane.add(zakrosPath1);
        zakrosPath1.setBounds(1150, 400, 140, 100);

        zakrosPath2.setText("jLabel2");
        BoardPane.add(zakrosPath2);
        zakrosPath2.setBounds(1050, 400, 100, 100);

        zakrosPath3.setText("jLabel3");
        BoardPane.add(zakrosPath3);
        zakrosPath3.setBounds(940, 400, 100, 100);

        zakrosPath4.setText("jLabel4");
        BoardPane.add(zakrosPath4);
        zakrosPath4.setBounds(830, 400, 100, 100);

        zakrosPath5.setText("jLabel5");
        BoardPane.add(zakrosPath5);
        zakrosPath5.setBounds(730, 400, 100, 100);

        zakrosPath6.setText("jLabel6");
        BoardPane.add(zakrosPath6);
        zakrosPath6.setBounds(620, 400, 100, 100);

        zakrosPath7.setText("jLabel7");
        BoardPane.add(zakrosPath7);
        zakrosPath7.setBounds(520, 400, 100, 100);

        zakrosPath8.setText("jLabel8");
        BoardPane.add(zakrosPath8);
        zakrosPath8.setBounds(410, 400, 100, 100);

        zakrosPath9.setText("jLabel9");
        BoardPane.add(zakrosPath9);
        zakrosPath9.setBounds(300, 400, 100, 100);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        BoardPane.add(Background);
        Background.setBounds(0, 0, 1310, 590);

        getContentPane().add(BoardPane);
        BoardPane.setBounds(0, 159, 2810, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Transformer: When click the button fresco is showed up
     * Postcondition: Fresco showed up
     * @param ActionEvent evt 
     */
    private void Fresco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fresco1ActionPerformed
        int l=0;
        while(l<Game.getPlayer(0).SyllogiSize()){
        if(Game.getPlayer(0).getSyllogi(l) instanceof Toixografies) JOptionPane.showMessageDialog(null,Game.getPlayer(0).getSyllogi(l).getDescription(),Game.getPlayer(0).getSyllogi(l).getMessage(),JOptionPane.INFORMATION_MESSAGE,Game.getPlayer(0).getSyllogi(l).getIcon());
        //System.out.println("Toixografies1");
        l++;
        }
    }//GEN-LAST:event_Fresco1ActionPerformed
/**
     * Transformer: When click the button fresco is showed up
     * Postcondition: Fresco showed up
     * @param ActionEvent evt 
     */
    private void Fresco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fresco2ActionPerformed
         int l=0;
        while(l<Game.getPlayer(1).SyllogiSize()){
            if(Game.getPlayer(1).getSyllogi(l) instanceof Toixografies)    JOptionPane.showMessageDialog(null,Game.getPlayer(1).getSyllogi(l).getDescription(),Game.getPlayer(1).getSyllogi(l).getMessage(),JOptionPane.INFORMATION_MESSAGE,Game.getPlayer(1).getSyllogi(l).getIcon());
        //System.out.println("Toixografies1");
        l++;
        }
        //System.out.println("Toixografies2");
    }//GEN-LAST:event_Fresco2ActionPerformed
/**
     * Transformer: When click the button you pick a card
     * Postcondition: Card picked
     * @param ActionEvent evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //if(Game.getPlayer(turn).getKartes().SumofCards() == 8) return;
            if(!Game.CardPlayed() && !Game.CardThrowed() && !Game.gameHasFinished())  return;
            Game.getNewCard();
            init_buttons_icons();
            if(turn==0)	this.turn=1;
            else this.turn=0;
            Game.setTurn(turn);
            String text="Available Cards: "+Game.RemainingCards()+"\n Checkpoints: \n Turn:Player "+(turn+1);
            Info.setText(text);
            
           // System.out.println("TUrn of "+turn);
 //System.out.println("Remaining Cards: "+Game.RemainingCards()+"\n Player "+(turn+1)+"turn");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed
    
    /**
     * Class when it clicks the button of the cards
     */
    class CardsButtonActionPerformed extends MouseAdapter{
        /**
         * Transformer:When left click play card when right throw cards
         * Postconditon: play or throw card
         * @param MouseEvent evt 
         */
        public void mouseClicked(java.awt.event.MouseEvent evt) {   
            
            int i,x,y,at=-1;
            boolean falsePlayer=false;
            boolean isLeft=true;
            if(SwingUtilities.isLeftMouseButton(evt)){
                isLeft=true;
                
            }else if(SwingUtilities.isRightMouseButton(evt)) {
                isLeft=false;
                
            }//edw kleinei i if isLeft mouse
            falsePlayer=false;
            for( i=0;i<8;i++){
                if(evt.getSource()==playersButtons.get(turn).get(i))    break;
                if(i==7)    falsePlayer=true;
            }//edw kleinei o elegxos gia to poia karta tou koumpiou na parei
            
            if(isLeft){
            if(!falsePlayer && !Game.CardPlayed() && !Game.CardThrowed() && !Game.gameHasFinished()){
                Image image= new ImageIcon(Game.getPlayer(turn).getKartes().getCard(i).getImage()).getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH);
                if(!(Game.getPlayer(turn).getKartes().getCard(i) instanceof Ariadne) && !(Game.getPlayer(turn).getKartes().getCard(i) instanceof Minotaur)){
                    try {
                       Card card=Game.getPlayer(turn).getKartes().getCard(i);
                       Game.playCard(i);
                       if(Game.CardPlayed()){
                           
                            if(turn==0){
                                if(card.getType()==AnaktoraType.knossos){
                                    KnossosLabel1.setIcon(new ImageIcon(image));     
                                    KnossosLabel1.setText(" ");
                                    at=0;
                                    
                                }
                                else if(card.getType()==AnaktoraType.malia){
                                    MaliaLabel1.setIcon(new ImageIcon(image));
                                    MaliaLabel1.setText(" ");
                                    at=1;
                                }
                                else if(card.getType()==AnaktoraType.phaistos){
                                    PhaistosLabel1.setIcon(new ImageIcon(image));
                                    PhaistosLabel1.setText(" ");
                                    at=2;
                                }
                                else if(card.getType()==AnaktoraType.zakros){
                                    ZakrosLabel1.setIcon(new ImageIcon(image));
                                    ZakrosLabel1.setText(" ");
                                    at=3;
                                }
                                if(Game.getPlayer(turn).TheseusAvailable())  Info1.setText("Παίχτης 1 Διαθέσιμα Πιόνια:"+Game.getPlayer(turn).NumOfArch()+" Αρχαιολόγοι και 1 Θησέας");
                                else Info1.setText("Παίχτης 1 Διαθέσιμα Πιόνια:"+Game.getPlayer(turn).NumOfArch()+" Αρχαιολόγοι");
                                
                            }else{
                                if(card.getType()==AnaktoraType.knossos){
                                    KnossosLabel2.setIcon(new ImageIcon(image));
                                    KnossosLabel2.setText(" ");
                                    at=0;
                                }
                                else if(card.getType()==AnaktoraType.malia){
                                    MaliaLabel2.setIcon(new ImageIcon(image));
                                    MaliaLabel2.setText(" ");
                                    at=1;
                                }
                                else if(card.getType()==AnaktoraType.phaistos){
                                    PhaistosLabel2.setIcon(new ImageIcon(image));
                                    PhaistosLabel2.setText("");
                                    at=2;
                                }
                                else if(card.getType()==AnaktoraType.zakros) {
                                    ZakrosLabel2.setIcon(new ImageIcon(image));
                                    ZakrosLabel2.setText(" ");
                                    at=3;
                                }
                                if(Game.getPlayer(turn).TheseusAvailable())  Info2.setText("Παίχτης 2 Διαθέσιμα Πιόνια:"+Game.getPlayer(turn).NumOfArch()+" Αρχαιολόγοι και 1 Θησέας");
                                else Info2.setText("Παίχτης 2 Διαθέσιμα Πιόνια:"+Game.getPlayer(turn).NumOfArch()+" Αρχαιολόγοι και");
                            }//edw kleinei to turn
                            
                            if(Game.CardPlayed()){
                                
                                playersButtons.get(turn).get(i).setIcon(null);
                                //if(card.getType()==AnaktoraType.knossos){
                                    int index=Game.getPlayer(turn).findPawn(at).getIndex();
                                    x=(int)AnaktoraPaths.get(at).get(index).getLocation().getX();
                                    y=(int)AnaktoraPaths.get(at).get(index).getLocation().getY();
             // ayto tha mpainei otan kounietai to pioni
                                    if(turn==0) {
                                        playersPawns.get(turn).get(Game.getPlayer(turn).findPawnIndex(at)).setLocation(x, y);
                                    //    System.out.println("ALLAKSE");
                                    }else if(turn==1){
                                       playersPawns.get(turn).get(Game.getPlayer(turn).findPawnIndex(at)).setLocation(x, y+60);
                                    }
                                    //int z;
                                    
                                //}
                            }   //edw kleinie auti i if
                       }//edw kleinei ean paixtike i karta   
                    }catch (Exception ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }//edw kleiniei to try
                }//edw kleinei o elegxos ean einai ariadne i minotauros
                else{  
                    
                    try {
                        Card card=Game.getPlayer(turn).getKartes().getCard(i);
                        Game.playCard(i);
                        if(!Game.CardCantPlayed()){
                            playersButtons.get(turn).get(i).setIcon(null);
                            if(card.getType()==AnaktoraType.knossos)  at=0;  
                                else if(card.getType()==AnaktoraType.malia) at=1; 
                                else if(card.getType()==AnaktoraType.phaistos) at=2;
                                else if(card.getType()==AnaktoraType.zakros) at=3;
                            int z;
                            if(turn==0)  z=1;
                            else z=0;
                            if(!(card instanceof Minotaur))  z=turn; 
                        
                                int index=Game.getPlayer(z).getIndexOfPawn(at);
                               
                                x=(int)AnaktoraPaths.get(at).get(index).getLocation().getX();
                                y=(int)AnaktoraPaths.get(at).get(index).getLocation().getY();
         
                                if(z==0) {
                                    
                                    playersPawns.get(z).get(Game.getPlayer(z).findPawnIndex(at)).setLocation(x, y);
                                
                                }else if(z==1){
                                   playersPawns.get(z).get(Game.getPlayer(z).findPawnIndex(at)).setLocation(x, y+60);
                                }
                             
                       
                       }
                       
                    } catch (Exception ex) {
                        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            }//edw kleinei i false player kai cardplayed    
            }//edw kleinei i isleft
            else{
                try {
                    if(!Game.CardPlayed()&&!Game.CardThrowed()){
                        Game.throwCard(i);
                        playersButtons.get(turn).get(i).setIcon(null);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }         
            }
            Agalmatakia1.setText("Αγαλματάκια: "+Game.getPlayer(0).NumOfSnakes());
            Agalmatakia2.setText("Αγαλματάκια: "+Game.getPlayer(1).NumOfSnakes());
            Score1.setText("Το Σκορ μου: "+Game.getPlayer(0).getScore()+" Πόντοι");
            Score2.setText("Το Σκορ μου: "+Game.getPlayer(1).getScore()+" Πόντοι");
            if(Game.gameHasFinished()){
              if(! Game.hasWinner())  JOptionPane.showMessageDialog(null,"Ισοπαλία","Κανένας Νικητής",JOptionPane.INFORMATION_MESSAGE);
              Agalmatakia1.setText("Αγαλματάκια: "+Game.getPlayer(0).NumOfSnakes());
              Agalmatakia2.setText("Αγαλματάκια: "+Game.getPlayer(1).NumOfSnakes());
              Score1.setText("Το Σκορ μου: "+Game.getPlayer(0).getScore()+" Πόντοι");
              Score2.setText("Το Σκορ μου: "+Game.getPlayer(1).getScore()+" Πόντοι");

            }
        } //edw kleinei i mouseCLicked     
    }   //edw kleinei i CardsButtonAction
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agalmatakia1;
    private javax.swing.JLabel Agalmatakia2;
    private javax.swing.JLabel Background;
    private javax.swing.JLayeredPane BoardPane;
    private javax.swing.JButton Fresco1;
    private javax.swing.JButton Fresco2;
    private javax.swing.JLabel Info;
    private javax.swing.JLabel Info1;
    private javax.swing.JLabel Info2;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JLabel KnossosLabel1;
    private javax.swing.JLabel KnossosLabel2;
    private javax.swing.JPanel KnossosPanel1;
    private javax.swing.JPanel KnossosPanel2;
    private javax.swing.JLabel MaliaLabel1;
    private javax.swing.JLabel MaliaLabel2;
    private javax.swing.JPanel MaliaPanel1;
    private javax.swing.JPanel MaliaPanel2;
    private javax.swing.JLabel P1Pawn1;
    private javax.swing.JLabel P1Pawn2;
    private javax.swing.JLabel P1Pawn3;
    private javax.swing.JLabel P1Theseus;
    private javax.swing.JLabel P2Pawn1;
    private javax.swing.JLabel P2Pawn2;
    private javax.swing.JLabel P2Pawn3;
    private javax.swing.JLabel P2Theseus;
    private javax.swing.JLabel PhaistosLabel1;
    private javax.swing.JLabel PhaistosLabel2;
    private javax.swing.JPanel PhaistosPanel1;
    private javax.swing.JPanel PhaistosPanel2;
    private javax.swing.JLayeredPane Player1Pane;
    private javax.swing.JPanel Player1Panel;
    private javax.swing.JLayeredPane Player2Pane;
    private javax.swing.JPanel Player2Panel;
    private javax.swing.JLabel Score1;
    private javax.swing.JLabel Score2;
    private javax.swing.JLabel ZakrosLabel1;
    private javax.swing.JLabel ZakrosLabel2;
    private javax.swing.JPanel ZakrosPanel1;
    private javax.swing.JPanel ZakrosPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel knossosPath1;
    private javax.swing.JLabel knossosPath2;
    private javax.swing.JLabel knossosPath3;
    private javax.swing.JLabel knossosPath4;
    private javax.swing.JLabel knossosPath5;
    private javax.swing.JLabel knossosPath6;
    private javax.swing.JLabel knossosPath7;
    private javax.swing.JLabel knossosPath8;
    private javax.swing.JLabel knossosPath9;
    private javax.swing.JLabel maliaPath1;
    private javax.swing.JLabel maliaPath2;
    private javax.swing.JLabel maliaPath3;
    private javax.swing.JLabel maliaPath4;
    private javax.swing.JLabel maliaPath5;
    private javax.swing.JLabel maliaPath6;
    private javax.swing.JLabel maliaPath7;
    private javax.swing.JLabel maliaPath8;
    private javax.swing.JLabel maliaPath9;
    private javax.swing.JLabel phaistosPath1;
    private javax.swing.JLabel phaistosPath2;
    private javax.swing.JLabel phaistosPath3;
    private javax.swing.JLabel phaistosPath4;
    private javax.swing.JLabel phaistosPath5;
    private javax.swing.JLabel phaistosPath6;
    private javax.swing.JLabel phaistosPath7;
    private javax.swing.JLabel phaistosPath8;
    private javax.swing.JLabel phaistosPath9;
    private javax.swing.JLabel zakrosPath1;
    private javax.swing.JLabel zakrosPath2;
    private javax.swing.JLabel zakrosPath3;
    private javax.swing.JLabel zakrosPath4;
    private javax.swing.JLabel zakrosPath5;
    private javax.swing.JLabel zakrosPath6;
    private javax.swing.JLabel zakrosPath7;
    private javax.swing.JLabel zakrosPath8;
    private javax.swing.JLabel zakrosPath9;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem NewGame;
    private javax.swing.JMenuItem SaveGame;
    private javax.swing.JMenuItem ContinueSavedGame;
    private javax.swing.JMenuItem ExitGame;
    private Controller Game;
    private int turn=RandomNumber.getRandomVal(0, 1);
    private JButton jButton2;
    private ArrayList<JButton> buttonsP1=new ArrayList<JButton>();
    private ArrayList<JButton> buttonsP2=new ArrayList<JButton>();
    private ArrayList<ArrayList<JButton>> playersButtons=new ArrayList<ArrayList<JButton>>(2);
    private ArrayList<JLabel> Knossospath=new ArrayList<JLabel>();
    private ArrayList<JLabel> Maliapath=new ArrayList<JLabel>();
    private ArrayList<JLabel> Phaistospath=new ArrayList<JLabel>();
    private ArrayList<JLabel> Zakrospath=new ArrayList<JLabel>();
    private ArrayList<ArrayList<JLabel>> AnaktoraPaths=new ArrayList<ArrayList<JLabel>>(4);
    private ArrayList<JLabel> P1Pawns=new ArrayList<JLabel>();
    private ArrayList<JLabel> P2Pawns=new ArrayList<JLabel>();
    private ArrayList<ArrayList<JLabel>> playersPawns=new ArrayList<ArrayList<JLabel>>(2);
}
