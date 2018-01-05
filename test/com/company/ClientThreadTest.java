package com.company;

import org.junit.Before;
import org.junit.Test;

import java.net.Socket;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClientThreadTest {

    String [] test;
    ArrayList<ClientThread> clients = MainServer.getClients();
    Socket socket;
    ClientThread client;

    @Before
    public void setUp() throws Exception{

        ServerGUI.playerNumberSelection = "6";
        client = new ClientThread(socket,2);
    }

    @Test
    public void testHandleInfo() throws Exception{

        for(ClientThread client : clients){
            client.handleInfoFromClient("startGame");
        }
    }

    @Test
    public void testReturnPlayerID() throws Exception{

        assertEquals(2, client.getPlayerID());

    }



}