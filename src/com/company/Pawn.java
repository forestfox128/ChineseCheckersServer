package com.company;

import java.awt.*;

public class Pawn {

    int xCoordinate;
    int yCoordinate;
    int playerNumber;
    Board board;


    public Pawn(int x, int y, int playerNumber, Board board){
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.playerNumber = playerNumber;
        this.board = board;
    }

    public int getX (){
        return xCoordinate;
    }

    public int getY (){
        return yCoordinate;
    }

    public void movePawn(int newX, int newY){
        xCoordinate = newX;
        yCoordinate = newY;
    }

}


