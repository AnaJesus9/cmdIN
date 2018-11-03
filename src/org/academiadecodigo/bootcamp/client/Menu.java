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
    private Request request;


    public Menu(Socket socket) throws IOException {
        this.prompt = new Prompt(System.in, System.out);
    }

    public Integer getLogin() throws IOException{
        MenuInputScanner input = new MenuInputScanner(LOGIN);

        input.setMessage("Welcome to cmdIN\n What do you wanna do?");
        switch (prompt.getUserInput(input)) {
            case 1:
                dispatchLogin();
                break;
            case 2:
                dispatchRegister();
                break;
        }
        return prompt.getUserInput(input);
    }

    private void dispatchLogin() throws IOException {
        StringInputScanner inputUser = new StringInputScanner();
        PasswordInputScanner inputPassword = new PasswordInputScanner();

        String userName = "";
        String password = "";

        inputUser.setMessage("Enter your username: ");
        inputPassword.setMessage("Enter your password: ");

        while (!request.login(userName, password)) {
            prompt.getUserInput(inputUser);
            prompt.getUserInput(inputPassword);
        }
        getMainMenu(userName);
    }



    private void dispatchRegister() {
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("### Welcome to Register in cmdIN ###");
        welcomeMessage.append("### Please fill the contents carefully ###");
        welcomeMessage.append("Enjoy cmdIN");
        System.out.println(welcomeMessage.toString());

    }

    private void getMainMenu(String userName) throws IOException {
        MenuInputScanner inputOption = new MenuInputScanner(MAIN_MENU);
        String name = request.getName();

        inputOption.setMessage("### Welcome " + name + ", your on the Main Menu ###");
        prompt.getUserInput(inputOption);
    }
}
