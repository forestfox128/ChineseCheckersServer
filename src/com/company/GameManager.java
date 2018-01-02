package com.company;

import java.util.ArrayList;

public class GameManager {

    public static ArrayList<Player> players = MainServer.getPlayers();

    public GameManager(){

    }
    public static int getPlayersNumber(){

        return players.size();
    }

//    public void startGame(){
//
//        for(Player p : players){
//            p.getClient().sendInfo("Game start");
//        }
//    }

}
