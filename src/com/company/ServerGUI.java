package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class ServerGUI {

    JFrame frame = new JFrame("ChineseCheckersServer");


    private Label output1;
    private Label output2;
    private JComboBox playerNumberChoose;
    private String [] playerNumber = {"2","3","4","6"};
    private static String playerNumberSelection = null;
    private JComboBox bootNumberChoose;
    private String [] bootNumber = {"1","2","3","4","5"};
    private static String bootNumberSelection = null;
    private Label listPlayers;
    private Label pN;
    private Label bN;
    private Label socket;

    //private Socket socket = null;



    public ServerGUI(){
        builtWindow();
    }

    public void builtWindow(){
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 450);
        frame.setTitle("ChineseCheckersServer");
        frame.setFont(new Font ("SansSerif",Font.PLAIN, 18));

        playerNumberChoose = new JComboBox(playerNumber);
        playerNumberChoose.setBounds(230,20,120,40);
        playerNumberChoose.setVisible(true);

        playerNumberChoose.addActionListener((ActionEvent event) -> {
            if(playerNumberSelection == null) {
                playerNumberSelection = playerNumberChoose.getSelectedItem().toString();
                System.out.println(playerNumberSelection);
                playerNumberChoose.setEnabled(false);
                createGameManager();
            }
            else{
                System.out.println("Cannot do it");
            }
        });

        pN = new Label("Number of players: ");
        pN.setFont(new Font ("SansSerif",Font.PLAIN, 16));
        pN.setBounds(30,20,150,35);

        bootNumberChoose = new JComboBox(bootNumber);
        bootNumberChoose.setBounds(530,20,120,40);
        bootNumberChoose.setVisible(true);

        bootNumberChoose.addActionListener((ActionEvent event) -> {
            if(bootNumberSelection == null) {
                bootNumberSelection = bootNumberChoose.getSelectedItem().toString();
                System.out.println(bootNumberSelection);
                bootNumberChoose.setEnabled(false);
                createGameManager();
            }
            else{
                System.out.println("Cannot");
            }
        });

        bN = new Label("Number of boots: ");
        bN.setFont(new Font ("SansSerif",Font.PLAIN, 16));
        bN.setBounds(360,20,150,35);

        socket = new Label("Status");
        socket.setFont(new Font ("SansSerif",Font.PLAIN, 16));
        socket.setBounds(30,50,700,50);

        output1 = new Label();
        output1.setBackground(Color.white);
        output1.setFont(new Font ("SansSerif",Font.PLAIN, 16));
        output1.setBounds(30,100,700,50);


        listPlayers = new Label("List of players: ");
        listPlayers.setBounds(30,180,700,30);
        listPlayers.setFont(new Font ("SansSerif",Font.PLAIN, 16));
        output2 = new Label();
        output2.setBackground(Color.white);
        output2.setBounds(30,220,700,100);
        output2.setFont(new Font ("SansSerif",Font.PLAIN, 16));

        frame.add(output1);
        frame.add(output2);
        frame.add(listPlayers);
        frame.add(socket);
        frame.add(playerNumberChoose);
        frame.add(pN);
        frame.add(bootNumberChoose);
        frame.add(bN);
    }

    public void startServer(){
        output1.setText("Server is running");
    }

    public void addClient(ArrayList<String> player){

        output1.setText("New player logged");
        //output2.setText(player);

        for(String p: player){
            System.out.println(p);
            output2.setText(p);
        }
    }

    public static int giveBootNumberSelection(){
        return Integer.parseInt(bootNumberSelection);
    }
    public static int givePlayerNumberSelection(){
        //return Integer.parseInt(playerNumberSelection);
        return 2;
    }

    public void createGameManager(){

        if(bootNumberSelection != null && playerNumberSelection != null){

           // GameManager gameManager = new GameManager(playerNumberSelection,bootNumberSelection);
        }


    }


}