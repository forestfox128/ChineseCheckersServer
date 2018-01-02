package com.company;

import java.util.ArrayList;

public class GameManager {

    public static ArrayList<Player> players = MainServer.getPlayers();
    public static ArrayList<ClientThread> clients = MainServer.getClients();
    public ClientThread clientThread;
    Player currentPlayer;
    Board board;
    private int lastPlayer = 0;

    private static GameManager INSTANCE;

    public GameManager(){
        startGame();
    }

    public static GameManager getINSTANCE(){
        if (INSTANCE == null)
            synchronized (GameManager.class) {
                if (INSTANCE == null)
                    INSTANCE = new GameManager();
            }
        return INSTANCE;
    }

    public static int getPlayersNumber(){

        return players.size();
    }

    public void startGame(){
        board = Board.getINSTANCE();
    }

    public void giveLastPlayer(int lastPlayerMoved){
        lastPlayer = lastPlayerMoved;
    }

    public int checkTurn(){
        int numberOfPlayers = getPlayersNumber();

        return lastPlayer % numberOfPlayers + 1;
    }
//
//    public boolean manageGame(){
//
//        int i = 0;
//        int numberOfPlayers = getPlayersNumber();
//        while(true){
//            int currentID = ;
//
//            if(gameEnd(currentID))
//                break;
//            i++;
//        }
//
//    }

    public boolean gameEnd(int currentPlayerID){

        return false;
    }



}
