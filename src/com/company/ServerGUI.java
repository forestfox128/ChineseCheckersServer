package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ServerGUI {

    JFrame frame = new JFrame("ChineseCheckersServer");


    private Label output1;
    private Label output2;
    private Label listPlayers;
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
    }

    public void startServer(){
        output1.setText("Server is running");
    }

    public void addClient(ArrayList<String> player){

        output1.setText("New player logged");
        //output2.setText(player);

        for(String p: player){
            System.out.println(p);
        }
    }
}

