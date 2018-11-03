package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class GetDataRequest implements RequestAnalyzer {


    @Override
    public String analyze(ProfileManager profileManager, String request) {
        String[] requestHandler = request.split(" ");

        return null; //return data
    }
}
