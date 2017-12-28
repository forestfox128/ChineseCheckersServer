package com.company;

import GameStates.GameManagerState;
import GameStates.WaitingForPlayers;

public class GameManager {

    private int playerNum;
    private int bootNUM;
    protected Board board;

    private GameManagerState state;

    public GameManager(String playerNum, String bootNum){
        this.playerNum = Integer.parseInt(playerNum);
        this.bootNUM = Integer.parseInt(bootNum);
        this.state = new WaitingForPlayers();

    }

    public void reportGameState(int playerNum){
        this.state.reportGameState(this,playerNum);
    }



}
