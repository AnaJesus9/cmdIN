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
        output.println("login::" + userName + "::" + password);

        if (input.readLine().equals("Login was a success.")) {
            System.out.println(getName(userName) + " logged on successfully.");
            return true;
        }
        System.out.println("Your username or password is incorrect.");
        return false;
    }

    public void createRegister(String userName, String name, String password) {
        output.println("create::" + userName + "::" + name + "::" + password);
        try {
            System.out.println(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() throws IOException {
        output.println("getUserName");
        return input.readLine();
    }

    public String getName(String userName) throws IOException {
        output.println("get::" + userName + "::name");
        return input.readLine();
    }

    public boolean writeName(String name) throws IOException {
        output.println("post::name::" + name);
        return (input.readLine() == "ok");
    }

    public int getAge() throws IOException {
        output.println("get::age");
        return Integer.parseInt(input.readLine());
    }

    public boolean writeAge(int age) throws IOException {
        output.println("post::age::" + age);

        return (input.readLine() == "ok");
    }

    public String getBirthday() throws IOException {
        output.println("get::birthday");

        return input.readLine();
    }

    public boolean writeBirthday(String birthday) throws IOException {
        output.println("post::birthday::" + birthday);

        return (input.readLine() == "ok");
    }
    public String getMessage() throws IOException {
        output.println("get::message");

        return input.readLine();
    }

    public boolean writeMessage(String message) throws IOException {
        output.println("post::message::" + message);

        return (input.readLine() == "ok");
    }

    public boolean writePassword(String password) throws IOException{
        output.println("post::password::" + password);
        return (input.readLine() == "ok");
    }
    public void getProfile(String username) throws IOException{
        output.println("getProfile::" + username);
        System.out.println("\n\n");
        String line;
        while((line = input.readLine()) != null) {
            if(line.equals("end")) {
                break;
            }
            System.out.println(line);
        }

    }

    public void listAll() throws IOException{
        output.println("list::");
        String line;
        System.out.println("\n -----> User List <----- \n");
        while((line = input.readLine()) != null) {
            if(line.equals("end")) {
                break;
            }
            System.out.println(line);
        }
    }
}