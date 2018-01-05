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

    private GameManager(){
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

        //return players.size();
        return ServerGUI.givePlayerNumberSelection();
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
        int i = 0;

        int [] checkXArray = new int [10];
        ArrayList<Pawn> pawnList = board.getPawnsList();

        int playerNumber = ServerGUI.givePlayerNumberSelection();

        if(playerNumber == 2){
            if(currentPlayerID == 2)
                currentPlayerID = 4;
        }

        if(playerNumber == 3){
            if(currentPlayerID == 2)
                currentPlayerID = 3;
            if(currentPlayerID == 3)
                currentPlayerID = 5;
        }

        if(playerNumber == 4){
            if(currentPlayerID == 3)
                currentPlayerID = 4;
            if(currentPlayerID == 4)
                currentPlayerID = 5;
        }

        switch(currentPlayerID) {

            case 1:
                i = 0;

                for (Pawn p : pawnList) {
                    //System.out.println("pawn X co " + p.getY());
                    if (p.getPlayerNumber() != currentPlayerID || p.getX() != 16 || p.getY() != 12) {
                        return false;
                    } else if (p.getPlayerNumber() == currentPlayerID && p.getX() == 16 && p.getY() == 12) {
                        //System.out.println("almost win");
                        for (Pawn pw : pawnList)
                            if (pw.getPlayerNumber() == currentPlayerID) {
                                checkXArray[i] = pw.getX() + pw.getY();
                                i++;
                            }
                        for (int k = 0; k < 10; k++) {
                            if (checkXArray[k] == 913 || checkXArray[k] == 915 || checkXArray[k] == 917 || checkXArray[k] == 919
                                    || checkXArray[k] == 1014 || checkXArray[k] == 1016 || checkXArray[k] == 1018 || checkXArray[k] == 1115
                                    || checkXArray[k] == 1117) {
                                System.out.println("Checked");
                            } else return false;
                        }

                            return true;
                    }
                }
            case 2:
                i = 0;
                for (Pawn p : pawnList) {
                    //System.out.println("pawn X co " + p.getY());
                    if (p.getPlayerNumber() != currentPlayerID || p.getX() != 11 || p.getY() != 0) {
                        return false;
                    } else if (p.getPlayerNumber() == currentPlayerID && p.getX() == 11 && p.getY() == 0) {
                        //System.out.println("almost win");
                        for (Pawn pw : pawnList)
                            if (pw.getPlayerNumber() == currentPlayerID) {
                                checkXArray[i] = pw.getX() + pw.getY();
                                i++;
                            }
                        for (int k = 0; k < 10; k++) {
                            if (checkXArray[k] == 112 || checkXArray[k] == 114 || checkXArray[k] == 116 || checkXArray[k] == 101
                                    || checkXArray[k] == 103 || checkXArray[k] == 105 || checkXArray[k] == 92 || checkXArray[k] == 94
                                    || checkXArray[k] == 83) {
                                System.out.println("Checked");
                            } else return false;
                        }

                        return true;
                    }
                }
            case 3:
                i = 0;
                for (Pawn p : pawnList) {
                    //System.out.println("pawn X co " + p.getY());
                    if (p.getPlayerNumber() != currentPlayerID || p.getX() != 4 || p.getY() != 0) {
                        return false;
                    } else if (p.getPlayerNumber() == currentPlayerID && p.getX() == 4 && p.getY() == 0) {
                        //System.out.println("almost win");
                        for (Pawn pw : pawnList)
                            if (pw.getPlayerNumber() == currentPlayerID) {
                                checkXArray[i] = pw.getX() + pw.getY();
                                i++;
                            }
                        for (int k = 0; k < 10; k++) {
                            if (checkXArray[k] == 42 || checkXArray[k] == 44 || checkXArray[k] == 46 || checkXArray[k] == 51
                                    || checkXArray[k] == 53 || checkXArray[k] == 55 || checkXArray[k] == 62 || checkXArray[k] == 64
                                    || checkXArray[k] == 73) {
                                System.out.println("Checked");
                            } else return false;
                        }

                        return true;
                    }
                }

            case 4:
                int j = 0;
                for (Pawn p : pawnList) {
                    //System.out.println("pawn X co " + p.getY());
                    if (p.getPlayerNumber() != currentPlayerID && p.getX() != 0 && p.getY() != 12) {
                        return false;
                    } else if (p.getPlayerNumber() == currentPlayerID || p.getX() == 0 || p.getY() == 12) {
                        //System.out.println("almost win");
                        for (Pawn pw : pawnList)
                            if (pw.getPlayerNumber() == currentPlayerID) {
                                checkXArray[j] = pw.getX() + pw.getY();
                                j++;
                            }
                        for (int k = 0; k < 10; k++) {
                            if(checkXArray[k] == 111 || checkXArray[k] == 113 || checkXArray[k] == 210 || checkXArray[k] == 212
                                    || checkXArray[k] == 214 || checkXArray[k] == 39 || checkXArray[k] == 311 || checkXArray[k] == 313
                                    || checkXArray[k] == 315) {
                                System.out.println("Checked");
                            } else return false;
                        }

                        return true;
                    }
                }
            case 5:
                i = 0;
                for (Pawn p : pawnList) {
                    //System.out.println("pawn X co " + p.getY());
                    if (p.getPlayerNumber() != currentPlayerID || p.getX() != 4 || p.getY() != 24) {
                        return false;
                    } else if (p.getPlayerNumber() == currentPlayerID && p.getX() == 4 && p.getY() == 24) {
                        //System.out.println("almost win");
                        for (Pawn pw : pawnList)
                            if (pw.getPlayerNumber() == currentPlayerID) {
                                checkXArray[i] = pw.getX() + pw.getY();
                                i++;
                            }
                        for (int k = 0; k < 10; k++) {
                            if (checkXArray[k] == 422 || checkXArray[k] == 420 || checkXArray[k] == 418 || checkXArray[k] == 523
                                    || checkXArray[k] == 519 || checkXArray[k] == 521 || checkXArray[k] == 622 || checkXArray[k] == 620
                                    || checkXArray[k] == 721) {
                                System.out.println("Checked");
                            } else return false;
                        }

                        return true;
                    }
                }
            case 6: i = 0;
                for (Pawn p : pawnList) {
                    //System.out.println("pawn X co " + p.getY());
                    if (p.getPlayerNumber() != currentPlayerID || p.getX() != 11 || p.getY() != 24) {
                        return false;
                    } else if (p.getPlayerNumber() == currentPlayerID && p.getX() == 11 && p.getY() == 24) {
                        //System.out.println("almost win");
                        for (Pawn pw : pawnList)
                            if (pw.getPlayerNumber() == currentPlayerID) {
                                checkXArray[i] = pw.getX() + pw.getY();
                                i++;
                            }
                        for (int k = 0; k < 10; k++) {
                            if (checkXArray[k] == 1122 || checkXArray[k] == 1120 || checkXArray[k] == 1118 || checkXArray[k] == 1023
                                    || checkXArray[k] == 1019 || checkXArray[k] == 1021 || checkXArray[k] == 922 || checkXArray[k] == 920
                                    || checkXArray[k] == 821) {
                                System.out.println("Checked");
                            } else return false;
                        }

                        return true;
                    }
                }
        }

        return false;

    }

}
