package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread extends Thread {

    protected Socket socket;
    private InputStream inp = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private ArrayList<String> users = new ArrayList<>();
    private Board board;
    private Players player;


    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {


        try {
            inp = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(inp));
            out = new PrintWriter(socket.getOutputStream(), true);
            //out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection denied");
        }

        String messageClient;

        while (true) {
            try {

                messageClient = in.readLine();
                handleInfoFromClient(messageClient);

            } catch (IOException e) {
                System.out.println("Cannot connect null message");
                System.exit(-1);
            }

        //TODO: zrobic cos w przypadku zamkniecia jakiegos klienta
        }
    }


    public void handleInfoFromClient(String messageClient){

        String[] dataArray;
        dataArray = messageClient.split(":");

        ServerGUI serverWindow = MainServer.getServerWindow();

        if("startGame".equals(dataArray[0])){

            System.out.println("New connection");
            board = Board.getINSTANCE();
            out.println("connected");
            users.add(dataArray[1]);
            serverWindow.addClient(users);

        }

        if("checkMoves".equals(dataArray[0])){

            String test = board.possibleMoves(Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));

            out.println(test);
            System.out.println(test);
        }

        if("move".equals(dataArray[0])){

            board.moveOnBoard(Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]),Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]));
        }

        if("getBoard".equals(dataArray[0])){

            board = Board.getINSTANCE();

            String msg = "";
            for(int i=0; i<17; i++)
            {
                for(int j=0; j<25; j++)
                {
                    msg = msg + "," + Integer.toString(i) + ":" + Integer.toString(j) + ":"
                            + Integer.toString(board.getPlayer(i, j));
                }
            }
            System.out.println(msg);
            out.println(msg);
        }


        //checking the action which client expect and return
    }
}
