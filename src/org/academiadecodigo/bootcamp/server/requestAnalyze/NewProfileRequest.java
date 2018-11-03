package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class NewProfileRequest implements RequestAnalyzer {


    @Override
    public String analyze(ProfileManager profileManager, String request) {


        return "Register";
    }
}
