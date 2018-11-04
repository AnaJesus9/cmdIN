package org.academiadecodigo.bootcamp.server;

import java.io.IOException;

public class ServerLauncher {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java -jar cmdINserver <port>");
        }

        try {
            Server server = new Server(Integer.parseInt(args[0]));
            server.start();
        } catch (NumberFormatException e) {
            System.err.println("Invalid port number " + args[0]);
        } catch (IOException e) {
            System.out.println("Error starting server! Shutting down.");
            e.printStackTrace();
        }
    }
}
