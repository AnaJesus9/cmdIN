package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class GetUserList implements RequestAnalyzer {
    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {
        return profileManager.listAll();
    }
}
