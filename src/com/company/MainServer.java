package com.company;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class MainServer {

    private ServerSocket server = null;
    private Socket client = null;
    private BufferedReader in = null;
    private static PrintWriter out = null;
    private String messageClient = "";
    private static ServerGUI serverWindow;
    private ArrayList<String> users = new ArrayList<>();
    private Board board;
    private Players player;
    private static final int PORT = 6008;



    public MainServer() {
        serverWindow = new ServerGUI();
        serverWindow.startServer();
    }

    public static ServerGUI getServerWindow() {
        return serverWindow;
    }

    public static void main(String[] args) {


//        server.listenSocket();

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
            new ClientThread(socket).start();
        }
    }

}
