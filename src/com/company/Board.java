package com.company;

import java.util.ArrayList;

public class Board {

    public int [][] newBoardArray = new int[17][25];
    private int playersNumber;
    private ArrayList<Pawn> pawnsList = new ArrayList<Pawn>();
    private Pawn pawn;

    public Board(int playersNumber){
        this.playersNumber = playersNumber;
        initializeBoard();
    }

    public void initializeBoard() {


        //if(playersNumber == 6) {
        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 25; j++)
                newBoardArray[i][j] = -1;

            for (int i = 0; i < 17; i++)
                for (int j = 0; j < 25; j++) {

                    if((i == 0 && j == 12) || (i == 1 && (j ==11 || j==13)) || (i == 2 && (j ==10 || j==12 || j==14)) || (i == 3 && (j ==9 || j==11 || j==13 || j==15))){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,1));
                    }
                    if((i == 7 && j == 3) || (i == 6 && (j ==2 || j==4)) || (i == 5 && (j ==1 || j==3 || j==5)) || (i == 4 && (j ==0 || j==2 || j==4 || j==6))){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,6));
                    }
                    if((i == 9 && j == 3) || (i == 10 && (j ==2 || j==4)) || (i == 11 && (j ==1 || j==3 || j==5)) || (i == 12 && (j ==0 || j==2 || j==4 || j==6))){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,5));
                    }
                    if((i == 16 && j == 12) || (i == 15 && (j ==11 || j==13)) || (i == 14 && (j ==10 || j==12 || j==14)) || (i == 13 && (j ==9 || j==11 || j==13 || j==15))){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,4));
                    }
                    if((i == 9 && j == 21) || (i == 10 && (j ==20 || j==22)) || (i == 11 && (j ==19 || j==21 || j==23)) || (i == 12 && (j ==18 || j==20 || j==22 || j==24))){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,3));
                    }
                    if((i == 7 && j == 21) || (i == 6 && (j ==20 || j==22)) || (i == 5 && (j ==19 || j==21 || j==23)) || (i == 4 && (j ==18 || j==20 || j== 22 || j==24))){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,2));
                    }
                    if(i==8 && j==12){
                        newBoardArray[i][j] = 1;
                        pawnsList.add(pawn = new Pawn(i,j,2));
                    }

                    else if((i == 4 || i == 12) && j>=8 && j <= 16 && j%2 ==0)
                        newBoardArray[i][j] = 0;
                    else if((i == 5 || i == 11) && j>=7 && j <= 17 && j%2 !=0)
                        newBoardArray[i][j] = 0;
                    else if((i == 6 || i == 10) && j>=6 && j <= 18 && j%2 ==0)
                        newBoardArray[i][j] = 0;
                    else if((i == 7 || i == 9) && j>=5 && j <= 19 && j%2 != 0)
                        newBoardArray[i][j] = 0;
                    else if(i == 8 && j>=4 && j <= 20 && j%2 ==0)
                        newBoardArray[i][j] = 0;
                  }


            for (int k = 0; k < 17; k++) {
                for (int z = 0; z < 25; z++) {
                    System.out.println(k  +" "+z +" "+newBoardArray[k][z]);
                }
                System.out.println(" ");
            }


    }

    public void moveOnBoard(int x, int y, int newX, int newY){

        newBoardArray[x][y] = 0;
        newBoardArray[newX][newY] = 1;

        for(Pawn p :pawnsList){
            if(p.getX() == x && p.getY() == y)
                p.movePawn(newX, newY);
        }

        System.out.println("Moved!!!!");
    }


    public String possPawnMove (int x, int y){

        String possMove = null;

        if (newBoardArray[x-1][y-1] == 0){
            possMove = Integer.toString(x-1) +":"+Integer.toString(y-1);
        }
        else if (newBoardArray[x-1][y-1] == 1){
            if(newBoardArray[x-2][y-2] == 0)
                possMove = Integer.toString(x-2) +":"+Integer.toString(y-2);
        }

        if (newBoardArray[x+1][y-1] == 0) {
            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y-1);

        }
        else if (newBoardArray[x+1][y-1] == 1){
            if(newBoardArray[x+2][y-2] == 0)
                possMove = possMove +":"+Integer.toString(x+2) +":"+Integer.toString(y-2);
        }
        if (newBoardArray[x-1][y+1] == 0) {
            possMove = possMove +":"+ Integer.toString(x-1) +":"+Integer.toString(y+1);

        }
        else if (newBoardArray[x-1][y+1] == 1){
            if(newBoardArray[x-2][y+2] == 0)
                possMove = possMove +":"+Integer.toString(x-2) +":"+Integer.toString(y+2);
        }
        if (newBoardArray[x+1][y+1] == 0) {
            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y+1);

        }
        else if (newBoardArray[x+1][y+1] == 1){
            if(newBoardArray[x+2][y+2] == 0)
                possMove = possMove +":"+Integer.toString(x+2) +":"+Integer.toString(y+2);
        }
        if (newBoardArray[x][y+2] == 0) {
            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y+2);

        }
        else if (newBoardArray[x][y+2] == 1){
            if(newBoardArray[x][y+4] == 0)
                possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y+4);
        }
        if (newBoardArray[x][y-2] == 0) {
            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y-2);

        }
        else if (newBoardArray[x][y-2] == 1){
            if(newBoardArray[x][y-4] == 0)
                possMove = possMove +":"+Integer.toString(x) +":"+Integer.toString(y-4);
        }

        return possMove;

    }


}
