package org.academiadecodigo.bootcamp.server;

import java.io.IOException;

public class ServerLauncher {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java -jar cmdINserver <port>");
            System.exit(1);
        }
        try {
            Server server = new Server(Integer.parseInt(args[0]));
            server.start();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid port number!");
        } catch (IOException e) {
            System.err.println("Error starting server! ");
            e.printStackTrace();
        }
    }
}
