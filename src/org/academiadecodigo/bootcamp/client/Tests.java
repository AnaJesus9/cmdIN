package org.academiadecodigo.bootcamp.client;

import java.io.IOException;
import java.net.Socket;

public class Tests {

    public static void main(String[] args) {

        Socket socket = new Socket();
        Menu menu = null;

        try {
            menu = new Menu(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (menu != null) {
            menu.dispatchRegister();

        }



    }
}