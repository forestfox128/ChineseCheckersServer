package com.company;

import java.awt.*;

public class Pawns {

    int xCoordinate;
    int yCoordinate;
    int playerNumber;

    public Pawns(int x, int y, int playerNumber){
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.playerNumber = playerNumber;
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
