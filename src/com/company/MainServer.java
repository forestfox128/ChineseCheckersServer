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
    private String messageClient = "";
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

        while (messageClient != null) {

            try {

                messageClient = in.readLine();
//                serverWindow.addClient(messageClient);

                handleInfoFromClient(messageClient);

                //singleton????
                //board = new Board(6);


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

    private void handleInfoFromClient(String messageClient){

        String[] dataArray;
        dataArray = messageClient.split(":");
        board = new Board(6);
        if("startGame".equals(dataArray[0])){

        }

        if("move".equals(dataArray[0])){


            out.println((board.checkIfPawnCanMove(Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]) ,Integer.parseInt(dataArray[4]))).toString());
        }


        //checking the action which client expect and return
    }
}

