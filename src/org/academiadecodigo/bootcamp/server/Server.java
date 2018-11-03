package org.academiadecodigo.bootcamp.server;

import org.academiadecodigo.bootcamp.server.file.FileManagerInt;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;
import org.academiadecodigo.bootcamp.server.requestAnalyze.Command;
import org.academiadecodigo.bootcamp.server.requestAnalyze.RequestAnalyzer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    /*
    FileManager methods are returning strings
     */

    private ServerSocket serverSocket;
    private ProfileManager profileManager;
    private FileManagerInt file;
    private ExecutorService service;
    private List<ClientHandler> clientHandlerList;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.service = Executors.newCachedThreadPool();
        this.clientHandlerList = new LinkedList<>();

    }


    public void start() {
        while (true) {
            listen();
            System.out.println(clientHandlerList.size() + " clients currently connected");
        }
    }

    private void listen() {

        try {
            System.out.println("Waiting for new connections...");

            Socket clientSocket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(clientSocket);

            System.out.println("Connection established: " + clientSocket.getInetAddress().getHostName());
            clientHandlerList.add(clientHandler);
            service.submit(clientHandler);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateFile() {
        file.write(profileManager);
    }

    private void readFile() {
        file.read(profileManager);
    }


    public class ClientHandler implements Runnable {

        private Socket socket;
        private RequestAnalyzer analyzer;
        private BufferedReader in;
        private PrintWriter out;


        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        private void initStreams() {
            try {
                this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void read() {
            try {
                String message = in.readLine();
                analyzer = Command.getRequestType(message).getAnalyzer();
                respond(analyzer.analyze(profileManager, this, message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void respond(String response) {
            out.println(response);
        }

        @Override
        public void run() {

            initStreams();

            while (!socket.isClosed()) {
                read();
            }

        }

        public void close() {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


