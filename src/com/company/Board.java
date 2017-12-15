package com.company;

import java.util.ArrayList;

public class Board {

    public int [][] board = new int[34][26];
    private int playersNumber;
    private ArrayList<Pawn> pawnsList = new ArrayList<Pawn>();
    private Pawn pawn;

    public Board(int playersNumber){
        this.playersNumber = playersNumber;
        initializeBoard();
    }

    private void initializeBoard() {

        if(playersNumber == 6) {

            for (int i = 0; i < 34; i++)
                for (int j = 0; j < 26; j++) {
                    board[i][j] = -1;

                    if((i == 0 && j == 12) || (i == 1 && (j ==11 || j==13)) || (i == 2 && (j ==10 || j==12 || j==14)) || (i == 3 && (j ==9 || j==11 || j==13 || j==15))){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,1));
                    }
                    if((i == 7 && j == 3) || (i == 6 && (j ==2 || j==4)) || (i == 5 && (j ==1 || j==3 || j==5)) || (i == 4 && (j ==0 || j==2 || j==4 || j==6))){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,6));
                    }
                    if((i == 9 && j == 3) || (i == 10 && (j ==2 || j==4)) || (i == 11 && (j ==1 || j==3 || j==5)) || (i == 12 && (j ==0 || j==2 || j==4 || j==6))){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,5));
                    }
                    if((i == 16 && j == 12) || (i == 15 && (j ==11 || j==13)) || (i == 14 && (j ==10 || j==12 || j==14)) || (i == 13 && (j ==9 || j==11 || j==13 || j==15))){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,4));
                    }
                    if((i == 9 && j == 21) || (i == 10 && (j ==20 || j==22)) || (i == 11 && (j ==19 || j==21 || j==23)) || (i == 12 && (j ==18 || j==20 || j==22 || j==24))){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,3));
                    }
                    if((i == 7 && j == 21) || (i == 6 && (j ==20 || j==22)) || (i == 5 && (j ==19 || j==21 || j==23)) || (i == 4 && (j ==18 || j==20 || j== 22 || j==24))){
                        board[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,2));
                    }

                    else if((i == 4 || i == 12) && j>=8 && j <= 16 && j%2 ==0)
                        board[i][j] = 0;
                    else if((i == 5 || i == 11) && j>=7 && j <= 17 && j%2 !=0)
                        board[i][j] = 0;
                    else if((i == 6 || i == 10) && j>=6 && j <= 18 && j%2 ==0)
                        board[i][j] = 0;
                    else if((i == 7 || i == 9) && j>=5 && j <= 19 && j%2 !=0)
                        board[i][j] = 0;
                    else if(i == 8 && j>=4 && j <= 20 && j%2 ==0)
                        board[i][j] = 0;
                }


            for (int i = 0; i < 34; i++)
                for (int j = 0; j < 26; j++)
                    System.out.println(board[i][j]);

        }

    }

    public Pawn checkIfClickOnPlayerPawn(int x, int y){

        for(Pawn p : pawnsList){
            if(p.yCoordinate == x && p.yCoordinate == y )
                return p;
        }
        return null;
    }

    public Boolean checkIfPawnCanBeMoved(int x, int y){

        if (board[x][y] == 0)
            return true;

        return false;
    }

    public void moveOnBoard(int x, int y, int newX, int newY){



        board[x][y] = 0;
        board[newX][newY] = 1;

        System.out.println("Moved!!!!");
    }

    public Boolean checkIfPawnCanMove (int x, int y, int newX, int newY){

        checkIfClickOnPlayerPawn( x,y);

        if (board[newX][newY] != 0)
            return false;

        if (newX == x - 1 && newY == y - 1){
            moveOnBoard(x,y,newX,newY);
            return true;
        }

        else if (newX == x + 1 && newY == y - 1)
        {
            moveOnBoard(x,y,newX,newY);
            return true;
        }
        else if (newX == x + 1 && newY == y + 1)
        {
            moveOnBoard(x,y,newX,newY);
            return true;
        }
        else if (newX == x - 1 && newY == y + 1)
        {
            moveOnBoard(x,y,newX,newY);
            return true;
        }
        else if (newX == x - 2 && newY == y)
        {
            moveOnBoard(x,y,newX,newY);
            return true;
        }
        else if (newX == x + 2 && newY == y)
        {
            moveOnBoard(x,y,newX,newY);
            return true;
        }

        return false;

    }


}
