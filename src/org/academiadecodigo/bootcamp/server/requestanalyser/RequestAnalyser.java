package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public interface RequestAnalyser {

    String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request);
}
