package org.academiadecodigo.bootcamp.server;

import org.academiadecodigo.bootcamp.server.file.FileManagerInt;
import org.academiadecodigo.bootcamp.server.profiles.ProfileInterface;
import org.academiadecodigo.bootcamp.server.requestAnalyze.RequestAnalyzer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private ProfileInterface profile;
    private FileManagerInt file;

    public Server() {

    }

    public void init() {

    }

    public void listen() {

    }


    public class ClientHander implements Runnable {

        private Socket socket;
        private RequestAnalyzer analyzer;

        public ClientHander(){

        }

        public void read() {

            try {
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void respond(String response){

            try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {

    }
}


