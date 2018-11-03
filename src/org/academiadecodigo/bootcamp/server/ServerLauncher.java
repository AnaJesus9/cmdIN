package org.academiadecodigo.bootcamp.server;

import java.io.IOException;

public class ServerLauncher {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {

        try {
            Server server = new Server(DEFAULT_PORT);
            server.start();
        } catch (IOException e) {
            System.out.println("Error starting server! ");
            e.printStackTrace();
        }

    }
}
