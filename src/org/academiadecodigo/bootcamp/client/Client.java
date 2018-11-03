package org.academiadecodigo.bootcamp.client;

import java.net.Socket;

public class Client {

    private Socket socket;


    public static void main(String[] args) {

    }

    private void establishConnection(String  serverAdress, int serverPort) {
        socket = new Socket(serverAdress, serverPort);

        System.out.println("Connected to: " + socket.getReceiveBufferSize());
    }
}
