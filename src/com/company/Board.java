package com.company;

import java.util.ArrayList;

public class Board {

    public int [][] board = new int[17][13];
    private int playersNumber;
    private ArrayList<Pawns> pawnsList = new ArrayList<Pawns>();
    private Pawns pawn;

    public Board(int playersNumber){
        this.playersNumber = playersNumber;
        initializeBoard();
    }

    private void initializeBoard() {

        if(playersNumber == 6) {

            for (int i = 0; i < 17; i++)
                for (int j = 0; j < 13; j++) {

                    board[i][j] = -1;

                    if (i <= 3 && j <= i) {
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawns(i,j,1));
                    }

                    if ((i == 4 && j > 8) || (i == 5 && j > 8 && j < 12) || (i == 6 && j > 8 && j < 11) || (i == 7 && j == 9)){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawns(i,j,2));                    }

                    if ((i == 4 && j < 4) || (i == 5 && j < 3) || (i == 6 && j < 2) || (i == 7 && j == 0) ){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawns(i,j,6));
                    }

                    if ((i == 9 && j == 0) || (i == 10 && j < 2) || (i == 11 && j < 3) || (i == 12 && j < 4)) {
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawns(i,j,5));
                    }

                    if ((i == 9 && j == 9) || (i == 10 && j > 8 && j < 11) || (i == 11 && j > 8 && j < 12) || (i == 12 && j > 8)) {
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawns(i,j,3));
                    }

                    if ((i == 15 && j < 2) || (i == 16 && j == 0) || (i == 14 && j < 3) || (i == 13 && j < 4)){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawns(i,j,4));
                    }

                    if (i > 3 && i < 13 && j < 9 && board[i][j] != 1)
                        board[i][j] = 0;

                }
        }

    }

    public Pawns checkIfClickOnPlayerPawn(int x, int y, int playerNumber){

        for(Pawns p : pawnsList){
            if(p.yCoordinate == x && p.yCoordinate == y && p.playerNumber == playerNumber)
                return p;
        }
        return null;
    }

    public Boolean checkIfPawnCanBeMoved(int x, int y){

        if (board[x][y] == 0)
            return true;

        return false;
    }

    public void moveOnBoard(int x, int y, int playerNumber, int newX, int newY){

        checkIfClickOnPlayerPawn(x,y,playerNumber).movePawn(newX,newY);
        board[x][y] = 0;
        board[newX][newY] = 1;

        System.out.println("Moved!!!!");
    }


}
