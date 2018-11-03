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


    public Menu(Request request) throws IOException {
        this.prompt = new Prompt(System.in, System.out);
        this.request = request;
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

        while (true) {

            userName = prompt.getUserInput(inputUser);
            password = prompt.getUserInput(inputPassword);
            if (request.login(userName, password)) {
                break;
            }
        }
        getMainMenu(userName);
    }



    public void dispatchRegister() {
        String userName = "";
        String password = "";
        String name = "";

        StringInputScanner input = new StringInputScanner();

        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("### Welcome to Register in cmdIN ###\n");
        welcomeMessage.append("### Please fill the contents carefully ###\n");
        welcomeMessage.append("### Enjoy cmdIN ###\n");
        System.out.println(welcomeMessage.toString());

        while (true) {

            input.setMessage("Enter a user name: ");
            name = prompt.getUserInput(input);

            input.setMessage("Enter your password: ");
            password = prompt.getUserInput(input);

            input.setMessage("Enter your name: ");
            name = prompt.getUserInput(input);

            if (request.createRegister(userName, name, password)) {
                break;
            }
        }
        getMainMenu(userName);
    }

    private void getMainMenu(String userName) throws IOException {
        MenuInputScanner inputOption = new MenuInputScanner(MAIN_MENU);
        String name = request.getName(userName);

        inputOption.setMessage("### Welcome " + name + ", your on the Main Menu ###");
        prompt.getUserInput(inputOption);

        switch (prompt.getUserInput(inputOption)) {
            case 1:
                getEditMenu();
                break;
            case 2:
                //getSearchMenu();
                break;
            case 3:
        }
    }

    private void getEditMenu() {

    }
}
