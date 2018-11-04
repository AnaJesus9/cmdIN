package org.academiadecodigo.bootcamp.client;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Menu {

    private final String[] LOGIN = {"Login", "Register", "Quit"};
    private final String[] MAIN_MENU = {"Edit Profile", "Search" , "List Users", "Log Out"};
    private final String[] EDIT_PROFILE = {"Name", "Age", "Birthday", "Message", "Password", "Back"};
    private Prompt prompt;
    private Request request;


    public Menu(Request request) {
        this.prompt = new Prompt(System.in, System.out);
        this.request = request;
    }

    public void start() throws IOException{

        while(true) {
            getLogin();
        }
    }

    public void getLogin() throws IOException{
        ClearScreen.clearScreen();
        MenuInputScanner input = new MenuInputScanner(LOGIN);

        input.setMessage(" ↠ ⋆ Welcome to cmdIN © ⋆ ↞\n" +
                "What do you wanna do?");

        switch (prompt.getUserInput(input)) {
            case 1:
                String userName = dispatchLogin();
                if(userName != null) {
                    boolean logout = false;
                    while(!logout) {
                       logout = getMainMenu(userName);
                    }
                }
                break;
            case 2:
                dispatchRegister();
                break;
            case 3:
                System.exit(1);
                break;
        }
    }

    private String dispatchLogin() throws IOException {
        ClearScreen.clearScreen();
        StringInputScanner inputUser = new StringInputScanner();
        PasswordInputScanner inputPassword = new PasswordInputScanner();

        String userName = "";
        String password = "";

        inputUser.setMessage("Enter your username: ");
        inputPassword.setMessage("Enter your password: ");

            userName = prompt.getUserInput(inputUser);
            password = prompt.getUserInput(inputPassword);
            if (request.login(userName, password)) {
                return userName;
            }
            return null;
    }

    public void dispatchRegister() {
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("    ** Welcome to Register in cmdIN © **\n");
        welcomeMessage.append("*** Please fill the contents carefully ***\n");
        welcomeMessage.append("        ↪ Enjoy cmdIN ↩ \n");
        System.out.println(welcomeMessage.toString());

        StringInputScanner input = new StringInputScanner();
        input.setMessage(" ➢ Type your username: ");

        String username = prompt.getUserInput(input);

        input.setMessage(" ➢ Type your name: ");
        String name = prompt.getUserInput(input);

        input.setMessage(" ➢ Type your password: ");
        String password = prompt.getUserInput(input);

        request.createRegister(username, name, password);
    }

    private boolean getMainMenu(String userName) throws IOException {
        boolean logout = false;
        MenuInputScanner inputOption = new MenuInputScanner(MAIN_MENU);
        String name = request.getName(userName);

        inputOption.setMessage(" ⁂ ◉ Welcome " + name + ", you're on the Menu  ◉ ⁂");

        switch (prompt.getUserInput(inputOption)) {
            case 1:
                boolean back = false;
                while(!back) {
                  back = getEditProfile();
                }
                break;
            case 2:
                search();

                break;
            case 3:
                listUsers();
                break;
            case 4:
                logout = true;
        }
        return logout;
    }

    private boolean getEditProfile() {
        boolean back = false;
        MenuInputScanner input = new MenuInputScanner(EDIT_PROFILE);
        input.setMessage("What do you wanna change?");

        switch (prompt.getUserInput(input)){
            case 1:
                editName();
                break;
            case 2:
                editAge();
                break;
            case 3:
                editBirthday();
                break;
            case 4:
                editMessage();
                break;
            case 5:
                editPassword();
                break;
            case 6:
                back = true;
        }
        return back;
    }

    private void editName() {

        try { StringInputScanner newName = new StringInputScanner();
            newName.setMessage("Edit your name: ");
            String nName = prompt.getUserInput(newName);
            request.writeName(nName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editAge() {

        try {IntegerInputScanner newAge = new IntegerInputScanner();
            newAge.setMessage("Edit your age: ");
            int nAge = prompt.getUserInput(newAge);
            request.writeAge(nAge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editBirthday(){

        try {
            StringInputScanner newBirth = new StringInputScanner();
            newBirth.setMessage("Edit your birthday: ");
            String nBirth = prompt.getUserInput(newBirth);
            request.writeBirthday(nBirth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editMessage(){

        try { StringInputScanner newMessage = new StringInputScanner();
            newMessage.setMessage("Edit your message: ");
            String nMessage = prompt.getUserInput(newMessage);
            request.writeMessage(nMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editPassword(){

        try {StringInputScanner newPassword = new StringInputScanner();
            newPassword.setMessage("Edit your password: ");
            String nPassword = prompt.getUserInput(newPassword);
            request.writePassword(nPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search() throws IOException{
        StringInputScanner search = new StringInputScanner();
        search.setMessage("Which user? ");
        String searchPerson = prompt.getUserInput(search);
        request.getProfile(searchPerson);
    }

    private void listUsers() throws IOException{
        request.listAll();
    }
}
