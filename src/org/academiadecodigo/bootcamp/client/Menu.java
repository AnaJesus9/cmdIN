package org.academiadecodigo.bootcamp.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;

public class Menu {


    private final String[] LOGIN = {"Login", "Register"};
    private final String[] MAIN_MENU = {"Edit Profile", "Search" , "Quit"};
    private Prompt prompt;
    private PrintWriter output;
    private BufferedReader input;


    public Menu(Socket socket) throws IOException {
        this.prompt = new Prompt(System.in, System.out);
        this.output = new PrintWriter(socket.getOutputStream());
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public Integer getLogin() throws IOException{
        MenuInputScanner input = new MenuInputScanner(LOGIN);

        input.setMessage("Welcome to cmdIN\n What do you wanna do?");
        switch (prompt.getUserInput(input)) {
            case 1:
                requestLogin();
                break;
            case 2:
                requestRegisterData();
                break;
        }
        return prompt.getUserInput(input);
    }

    private void requestLogin() throws IOException {
        StringInputScanner inputUser = new StringInputScanner();
        PasswordInputScanner inputPassword = new PasswordInputScanner();

        String userName = "";
        String password = "";

        inputUser.setMessage("Enter your username: ");

        while (!(validateUser(userName = prompt.getUserInput(inputUser),
                password = prompt.getUserInput(inputPassword)))) {

            System.out.println("Invalid username or password.");
        }
        getMainMenu(userName);
    }



    private void requestRegisterData() {

    }

    private boolean validateUser(String userName, String password) throws IOException{
        String login = "user: user, password: password\n";

        output.println(login);
        return (input.readLine() == "true");
    }

    private void getMainMenu(String userName) {
        MenuInputScanner inputOption = new MenuInputScanner(MAIN_MENU);
        String name = request.getName;


        inputOption.setMessage("### Welcome " + name + ", your on the Main Menu ###");

    }

}
