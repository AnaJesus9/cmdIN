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
        this.output = new PrintWriter(socket.getOutputStream(), true);
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public boolean login(String userName, String password) throws IOException {
        output.println("login " + userName + " " + password);

        if (input.readLine().equals("ok")) {
            System.out.println(getName(userName) + " logged on successfully.");
            return true;
        }

        System.out.println("Your username or password is incorrect.");
        return false;
    }

    public boolean createRegister(String userName, String name, String password) {

        output.println("register " + userName + " " + name + " " + password);

        try {
            if (input.readLine().equals("Register") ) {
                System.out.println(getName(userName) + " register on successfully.");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("This username already exist.");
        return false;
    }

    public String getUserName() throws IOException {
        output.println("getUserName");

        return input.readLine();
    }

    public boolean writeUserName(String userName) throws IOException {
        output.println("post userName " + userName);

        return (input.readLine().equals("ok"));
    }

    public String getName(String userName) throws IOException {
        output.println("get " + userName + " name");

        return input.readLine();
    }

    public boolean writeName(String name) throws IOException {
        output.println("post name " + name);

        return (input.readLine().equals("ok"));
    }

    public int getAge(String userName) throws IOException {
        output.println("get::userName::age");

        return Integer.parseInt(input.readLine());
    }

    public boolean writeAge(int age) throws IOException {
        output.println("post age " + age);

        return (input.readLine().equals("ok"));
    }

    public String getBirthday() throws IOException {
        output.println("get birthday");

        return input.readLine();
    }

    public boolean writeBirthday(String birthday) throws IOException {
        output.println("post birthday " + birthday);

        return (input.readLine().equals("ok"));
    }

    public String getMessage() throws IOException {
        output.println("get message");

        return input.readLine();
    }

    public boolean writeMessage(String message) throws IOException {
        output.println("post message " + message);

        return (input.readLine().equals("ok"));
    }
}
