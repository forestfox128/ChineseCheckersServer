package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PawnTest {

    Pawn pawn;

    @Before
    public void testPawn() throws Exception{
        pawn = new Pawn(0,12,1);
    }

    @Test
    public void testgetX() throws Exception{
        assertEquals(0,pawn.getX());
    }

    @Test
    public void testGetY() throws Exception{
        assertEquals(12,pawn.getY());
    }

    @Test
    public void testGetPlayer() throws Exception{
        assertEquals(1, pawn.getPlayerNumber());
    }

    @Test
    public void testMovePawn() throws Exception{
        pawn.movePawn(1,11);
        assertEquals(1,pawn.getX());
        assertEquals(11,pawn.getY());
    }
}
