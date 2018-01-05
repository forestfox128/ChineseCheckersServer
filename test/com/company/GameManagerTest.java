package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameManagerTest {

    GameManager gameManager;
    Board board;


   @Before
    public void setUp() throws  Exception{
       ServerGUI.playerNumberSelection = "2";
       board = Board.getINSTANCE();
       gameManager = GameManager.getINSTANCE();

   }

   @Test
    public void testEndGame() throws Exception{
       assertEquals(false, gameManager.gameEnd(1));
   }

   @Test
    public void testCheckTurn() throws Exception{
       gameManager.giveLastPlayer(2);
       System.out.println(gameManager.checkTurn());
       assertEquals(1,gameManager.checkTurn());
   }




}