package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class Error implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, String request) {
        return "error";
    }
}
