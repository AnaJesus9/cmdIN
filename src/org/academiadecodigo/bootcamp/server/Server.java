package org.academiadecodigo.bootcamp.server;

import org.academiadecodigo.bootcamp.server.file.FileManager;
import org.academiadecodigo.bootcamp.server.file.FileManagerInt;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;
import org.academiadecodigo.bootcamp.server.requestanalyser.Command;
import org.academiadecodigo.bootcamp.server.requestanalyser.RequestAnalyser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private ProfileManager profileManager;
    private FileManagerInt file;
    private ExecutorService service;
    private List<ClientHandler> clientHandlerList;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.service = Executors.newCachedThreadPool();
        this.clientHandlerList = new LinkedList<>();
        this.profileManager = new ProfileManager();
        this.file = new FileManager();
    }

    public void start() {
        readFile();
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
        private RequestAnalyser analyzer;
        private BufferedReader in;
        private PrintWriter out;
        private Profile profile;


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
                if(message == null){
                    throw new IOException();
                }
                analyzer = Command.getRequestType(message).getAnalyser();
                respond(analyzer.analyze(profileManager, this, message));
            } catch (IOException e) {
                System.out.println("One client lost Connection.");
                close();
            }
        }

        private void respond(String response) {
            out.println(response);
        }

        @Override
        public void run() {
            initStreams();

            while (!socket.isClosed()) {
                read();
            }
        }

        private void close() {

            try {
                socket.close();
                clientHandlerList.remove(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setProfile(Profile profile) {
            this.profile = profile;
        }

        public Profile getProfile() {
            return profile;
        }
    }
}


