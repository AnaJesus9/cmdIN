package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class GetUserList implements RequestAnalyser {
    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {
        return profileManager.listAll();
    }
}