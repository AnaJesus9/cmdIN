package org.academiadecodigo.bootcamp.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;

public class Menu {


    private final String[] LOGIN = {"Login", "Register"};
    private final String[] MAIN_MENU = {"Edit Profile", "Search" , "Logout", "Quit"};
    private final String[] SEARCH_MENU = {"List profiles", "View profile"};
    private Prompt prompt;
    private Request request;
    private String userName;


    public Menu(Request request) throws IOException {
        this.prompt = new Prompt(System.in, System.out);
        this.request = request;
        this.userName = "";
    }

    public void getLoginMenu() throws IOException{
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
        getMainMenu();
    }

    public void dispatchRegister() throws IOException {
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
        getMainMenu();
    }

    private void getMainMenu() throws IOException {
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

    private void getEditMenu() throws IOException {
        String name = request.getName(userName);
        int age = request.getAge(userName);
        String birthday = request.getBirthday();
        String message = request.getMessage();

        String[] editMenu = {   "'" + name + "' - Edit name",
                                "'" + age + "' - Edit age",
                                "'" + birthday + "' - Edit birthday",
                                "'" + message + "' - Edit message"};

        MenuInputScanner inputOption = new MenuInputScanner(editMenu);
        inputOption.setMessage(name + " choose what you want to edit:");

        StringInputScanner inputString = new StringInputScanner();
        IntegerInputScanner inputInteger = new IntegerInputScanner();

        switch (prompt.getUserInput(inputOption)) {
            case 1:
                while (true) {
                    inputString.setMessage("Enter name: ");

                    if (request.writeName(prompt.getUserInput(inputString))) {
                        break;
                    }
                }
                break;
        case 2:
        while (true) {
                inputInteger.setMessage("Enter age: ");

                    if (request.writeAge(prompt.getUserInput(inputInteger))) {
                        break;
                    }
                break;
                }
            case 3:
                while (true) {
                    inputString.setMessage("Enter birthday: ");

                    if (request.writeBirthday(prompt.getUserInput(inputString))) {
                        break;
                    }
                break;
                }
            case 4:
                while (true) {
                    inputString.setMessage("Enter message: ");

                    if (request.writeMessage(prompt.getUserInput(inputString))) {
                        break;
                    }
                break;
                }
        getMainMenu();
        }
    }

    private void getSearhMenu() throws IOException {
        MenuInputScanner inputOption = new MenuInputScanner(SEARCH_MENU);
        inputOption.setMessage("Choose an option:");

        switch(prompt.getUserInput(inputOption)) {
            case 1:
                request.getList();
                break;
            case 2:

                break;

        }
        getMainMenu();
    }
}
