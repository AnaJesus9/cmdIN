package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class LoginRequest implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {

        String[] requestHandler = request.split(" ");
        if(requestHandler.length != 3) {
            return "error";
        }
        String username = requestHandler[1];
        String password = requestHandler[2];

        for (Profile profile: profileManager.getProfiles().values()) {
            if (profile.getUsername().equals(username) &&
                    profile.getPassword().equals(password)) {
                profile.setLoggedIn(true);
                return "ok";
            }
        }
        return "fail";
    }
}
