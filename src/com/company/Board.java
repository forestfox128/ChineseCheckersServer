package com.company;

import BoardFactory.*;

import java.util.ArrayList;

public class Board {

    //public int [][] newBoardArray = new int[17][25];
    private int playersNumber;

    private ArrayList<Pawn> pawnsList = new ArrayList<Pawn>();
    private Pawn pawn;
    private static Board INSTANCE;
    //CreateBoard createBoard;
    private GeneralBoard generalBoard;

    private Board(int playersNumber){
        initializeBoard(playersNumber);

    }

    //SINGLETON
    public static Board getINSTANCE(int playersNumber){
        if (INSTANCE == null)
            synchronized (Board.class) {
                if (INSTANCE == null)
                    INSTANCE = new Board(playersNumber);
            }
        return INSTANCE;
    }

    public void initializeBoard(int playersNumber) {

        generalBoard = CreateBoard.createBoard(playersNumber);
        generalBoard.createNewBoard();

    }


    public void moveOnBoard(int x, int y, int newX, int newY){

        generalBoard.newBoardArray[x][y] = 0;
        generalBoard.newBoardArray[newX][newY] = 1;

        for(Pawn p :pawnsList){
            if(p.getX() == x && p.getY() == y)
                p.movePawn(newX, newY);
        }

        System.out.println("Moved!!!!");
    }

    public Pawn findPawn(int x, int y){

        for(Pawn p :pawnsList){
            if(p.getX() == x && p.getY() == y)
                return p;
        }
        return null;
    }

    public String possibleMoves(int x, int y){

        return generalBoard.possibleMoves(x,y);
    }


//    public String possibleMoves(int x, int y){
//
//        String possMove = null;
//
//        if (generalBoard.newBoardArray[x-1][y-1] == 0){
//            possMove = Integer.toString(x-1) +":"+Integer.toString(y-1);
//            System.out.println("OKKKKK");
//        }
//        else if (generalBoard.newBoardArray[x-1][y-1] == 1){
//            int tempX = x;
//            int tempY = y;
//            while(generalBoard.newBoardArray[tempX-2][tempY-2] == 0 && generalBoard.newBoardArray[tempX-1][tempY-1] == 1) {
//                possMove = possMove + ":" + Integer.toString(tempX - 2) + ":" + Integer.toString(tempY - 2);
//                tempX = tempX -2;
//                tempY = tempY -2;
//            }
//        }
//
//        if (generalBoard.newBoardArray[x+1][y-1] == 0) {
//            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y-1);
//
//        }
//        else if (generalBoard.newBoardArray[x+1][y-1] == 1){
//            int tempX = x;
//            int tempY = y;
//            while(generalBoard.newBoardArray[tempX+2][tempY-2] == 0 && generalBoard.newBoardArray[tempX+1][tempY-1] == 1) {
//                possMove = possMove + ":" + Integer.toString(tempX + 2) + ":" + Integer.toString(tempY - 2);
//                tempX = tempX +2;
//                tempY = tempY -2;
//            }
//        }
//        if (generalBoard.newBoardArray[x-1][y+1] == 0) {
//            possMove = possMove +":"+ Integer.toString(x-1) +":"+Integer.toString(y+1);
//
//        }
//        else if (generalBoard.newBoardArray[x-1][y+1] == 1){
//            int tempX = x;
//            int tempY = y;
//            while(generalBoard.newBoardArray[tempX-2][tempY+2] == 0 && generalBoard.newBoardArray[tempX-1][tempY+1] == 1) {
//                possMove = possMove + ":" + Integer.toString(tempX - 2) + ":" + Integer.toString(tempY + 2);
//                tempX = tempX -2;
//                tempY = tempY +2;
//            }
//        }
//        if (generalBoard.newBoardArray[x+1][y+1] == 0) {
//            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y+1);
//
//        }
//        else if (generalBoard.newBoardArray[x+1][y+1] == 1){
//            int tempX = x;
//            int tempY = y;
//            while(generalBoard.newBoardArray[tempX+2][tempY+2] == 0 && generalBoard.newBoardArray[tempX+1][tempY+1] == 1) {
//                possMove = possMove + ":" + Integer.toString(tempX + 2) + ":" + Integer.toString(tempY + 2);
//                tempX = tempX +2;
//                tempY = tempY +2;
//            }
//        }
//        if (generalBoard.newBoardArray[x][y+2] == 0) {
//            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y+2);
//
//        }
//        else if (generalBoard.newBoardArray[x][y+2] == 1){
//            int tempY = y;
//            while(generalBoard.newBoardArray[x][tempY+4] == 0 && generalBoard.newBoardArray[x][tempY+2] == 1) {
//                possMove = possMove + ":" + Integer.toString(x) + ":" + Integer.toString(tempY + 4);
//                tempY = tempY +4;
//            }
//        }
//        if (generalBoard.newBoardArray[x][y-2] == 0) {
//            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y-2);
//
//        }
//        else if (generalBoard.newBoardArray[x][y-2] == 1){
//            int tempY = y;
//            while(generalBoard.newBoardArray[x][tempY-4] == 0 && generalBoard.newBoardArray[x][tempY-2] == 1) {
//                possMove = possMove + ":" + Integer.toString(x) + ":" + Integer.toString(tempY - 4);
//                tempY = tempY -4;
//            }
//        }
//
//        return possMove;
//
//    }


}
