package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class Error implements RequestAnalyser {

    @Override
    public String analyze(Server server, Server.ClientHandler sender, String request) {
        return "Error";
    }
}
