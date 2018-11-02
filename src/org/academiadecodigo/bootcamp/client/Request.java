package org.academiadecodigo.bootcamp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Request {

    private PrintWriter output;
    private BufferedReader input;


    public Request(Socket socket) throws IOException {
        this.output = new PrintWriter(socket.getOutputStream());
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public boolean login(String userName, String password) throws IOException {
        output.println(userName + " " + password + "\n");

        if (input.readLine() == "logOn") {
            System.out.println(getName() + " logged on successfully.");
            return true;
        }

        System.out.println("Your username or password is incorrect.");
        return false;
    }

    public String getName() throws IOException {
        output.println("get name");

        return input.readLine();
    }
}
