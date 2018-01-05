package com.company;

import BoardFactory.CreateBoard;
import BoardFactory.GeneralBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;
    GeneralBoard gb;

    @Before
    public void setUp() throws Exception{

        ServerGUI.playerNumberSelection = "6";
        //gb = CreateBoard.createBoard(6);
        board = Board.getINSTANCE();
    }

    @Test
    public void testGetPlayer() throws Exception{
        assertEquals(1,board.getPlayer(0,12));
    }

    @Test
    public void testPossibleMoves() throws Exception{
        assertEquals("", board.possibleMoves(0,12));
    }


}