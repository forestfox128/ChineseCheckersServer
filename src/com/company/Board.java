package com.company;

import BoardFactory.*;

import java.util.ArrayList;

public class Board {


    private int playersNumber;

    //private ArrayList<Pawn> pawnsList = new ArrayList<Pawn>();
    private Pawn pawn;
    private static Board INSTANCE;
    private GeneralBoard generalBoard;

    private Board(){
        initializeBoard();
    }

    //SINGLETON
    public static Board getINSTANCE(){
        if (INSTANCE == null)
            synchronized (Board.class) {
                if (INSTANCE == null)
                    INSTANCE = new Board();
            }
        return INSTANCE;
    }

    public void initializeBoard() {

        generalBoard = CreateBoard.createBoard(ServerGUI.givePlayerNumberSelection());
        generalBoard.createNewBoard();

    }


    public void moveOnBoard(int x, int y, int newX, int newY){

        generalBoard.newBoardArray[x][y] = 0;
        generalBoard.newBoardArray[newX][newY] = 1;

        for(Pawn p : getPawnsList()){
            if(p.getX() == x && p.getY() == y)
                p.movePawn(newX, newY);
        }

        generalBoard.playerArray[newX][newY] = generalBoard.playerArray[x][y] ;
        generalBoard.playerArray[x][y] = 0;
    }

    public String possibleMoves(int x, int y){

        return generalBoard.possibleMoves(x,y);
    }

    public int getPlayer(int x, int y)
    {
        return generalBoard.getPlayer(x, y);
    }

    public ArrayList<Pawn> getPawnsList() {
        return generalBoard.getPawnList();
    }
}
