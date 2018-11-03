package org.academiadecodigo.bootcamp.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket;


    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: java -jar cmdIN <host> <port>");
        }

        Client client = new Client();

        try {
            client.establishConnection(args[0], Integer.parseInt(args[1]));

        } catch (NumberFormatException e) {
            System.err.println("Invalid port number " + args[1]);

        } catch (UnknownHostException e) {
            System.err.println("Host Unknown" + e.getMessage() + " :closing connection...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           client.closeSocket();
        }

    }

    private void establishConnection(String  serverAddress, int serverPort) throws IOException {
        socket = new Socket(serverAddress, serverPort);

        System.out.println("Connected to: " + socket.getReceiveBufferSize());
    }

    private void closeSocket() {

        try {
            if (socket != null) {
                System.out.println("Closing the socket");
                socket.close();
            }
        } catch (IOException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

