package com.company;

import com.sun.security.ntlm.Client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class MainServer {

    private static ServerGUI serverWindow;
    private static final int PORT = 6008;
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<ClientThread> clients = new ArrayList<>();
    private static ClientThread client;
    private static GameManager game;
    private static int playerLimit = 1;

    public MainServer() {
        serverWindow = new ServerGUI();
        serverWindow.startServer();
    }

    public static ServerGUI getServerWindow() {
        return serverWindow;
    }

    public static void main(String[] args) {


        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            new MainServer();

        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }

            // new thread for a client
            if(playerLimit <= ServerGUI.givePlayerNumberSelection()) {
                client = new ClientThread(socket, playerLimit);
                client.start();
                clients.add(client);
                addNewPlayer(playerLimit, client);
            }
            else if (playerLimit == ServerGUI.givePlayerNumberSelection()){
                startGame();
            }
            else {
                System.out.println("Lack of place for player");
            }
            playerLimit++;
        }
    }

    public static void addNewPlayer(int playerID, ClientThread client){
        players.add(new Player(playerID,client));

    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void startGame(){
        game = new GameManager();
    }

    public static ArrayList<ClientThread> getClients() {
        return clients;
    }
}
