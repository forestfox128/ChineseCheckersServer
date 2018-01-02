package com.company;

import java.util.ArrayList;

public class Player {

    private ArrayList<Pawn> pawnList = new ArrayList<>();
    private ClientThread client;
    private int playerID;

    public Player(int playerID, ClientThread client){
        this.playerID = playerID;
        this.client = client;
    }

    public ClientThread getClient() {
        return client;
    }

    public boolean checkIfYourPawn(int x, int y){

        if(client.getPlayerID() == playerID) {
            for (Pawn pawn : pawnList)
                if (pawn.getX() == x && pawn.getY() == y)
                    return true;
        }
        return false;
    }

    public int getPlayerID() {
        return playerID;
    }
}
