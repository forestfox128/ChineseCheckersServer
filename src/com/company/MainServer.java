package com.company;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainServer {

    private ServerSocket server = null;
    private Socket client = null;
    private BufferedReader in = null;
    private static PrintWriter out = null;
    private String clientName = "";
    private ServerGUI serverWindow;
    private ArrayList<String> users = new ArrayList<>();
    private Board board;
    private Players player;



    private MainServer() {
        try {

            server = new ServerSocket(9999);
            serverWindow = new ServerGUI();
            serverWindow.startServer();
        }

        catch (IOException e) {
            System.out.println("Could not listen on port 6666"); System.exit(-1);
        }
    }

    private void listenSocket() {

        try {
            client = server.accept();

        } catch (IOException e) {
            System.out.println("Accept failed: 6587");
            System.exit(-1);
        }
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }

        while (clientName != null) {

            try {

                clientName = in.readLine();
                serverWindow.addClient(clientName);

                //singleton????
                board = new Board(6);
                if(board.checkIfClickOnPlayerPawn(3,3,1) != null && board.checkIfPawnCanBeMoved(4,7)){
                    board.moveOnBoard(3,3,1,4,7);
                }
                else System.out.println("Error!!!");

            }

            catch (IOException e) {
                System.out.println("Cannot connect");
                System.exit(-1);
            }
        }
    }

    protected void finalize() {
        try {
            in.close();
            out.close();
            client.close();
            server.close();
        }
        catch (IOException e) {
            System.out.println("Could not close."); System.exit(-1);
        }
    }

    public static void main(String[] args) {

        MainServer server = new MainServer();
        server.listenSocket();

    }
}

