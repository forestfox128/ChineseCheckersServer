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

    public boolean gameEnd(int currentPlayerID){

        int [] checkXArray = new int [10];
        //int [] checkYArray = new int [10];

        switch(currentPlayerID){
            case 1:
                int i = 0;
                for(Pawn p: board.getPawnsList())
                    if(p.getPlayerNumber() == currentPlayerID && p.getX() == 16 && p.getX() == 12){
                        for(Pawn pw: board.getPawnsList())
                            if(p.getPlayerNumber() == currentPlayerID){
                                checkXArray[i] = p.getX() + p.getY();
                                //checkYArray[i] = p.getY();
                                i++;
                            }
                        for(int k = 0; k < 10 ; k++){
                                if(checkXArray[k] == 913 || checkXArray[k] == 915 || checkXArray[k] == 917 || checkXArray[k] == 919
                                        || checkXArray[k] == 1014 || checkXArray[k] == 1016 || checkXArray[k] == 1018 || checkXArray[k] == 1115
                                        || checkXArray[k] == 1117){
                                    //do nothing
                                }

                                else return false;
                        }
                        return true;
                    }
                    else return false;

            case 2:
                for(Pawn p: board.getPawnsList())
                    if(p.getPlayerNumber() == currentPlayerID && p.getX() == 0 && p.getX() == 12){
                        // sprawdzamy dalej czy wygrał
                    }
                    else return false;
        }

        return false;
    }



}
