package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class QuitAnalyzer implements RequestAnalyzer {


    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {
        return "exit";
    }
}
