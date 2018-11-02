package org.academiadecodigo.bootcamp.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Menu {


    public static final String[] LOGIN = {"Login", "Register"};
    public static final String[] MAIN_MENU = {"Edit Profile", "Search" , "Quit"};
    private Prompt prompt;


    public Integer getLogin() {
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

    private void requestLogin() {
        StringInputScanner inputUser = new StringInputScanner();

        inputUser.setMessage("Enter your username: ");
        prompt.getUserInput(inputUser);
        
    }

    private void requestRegisterData() {

    }

}
