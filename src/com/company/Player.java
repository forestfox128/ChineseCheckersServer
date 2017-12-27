package com.company;

import java.util.ArrayList;

public class Player {

    private ArrayList<Pawn> pawnList = new ArrayList<>();
    private int playerID;

    public Player(int playerID, ArrayList<Pawn> pawnList){
        this.playerID = playerID;
        this.pawnList = pawnList;
    }

    public boolean checkIfYourPawn(int x, int y){
        return true;
    }
}
