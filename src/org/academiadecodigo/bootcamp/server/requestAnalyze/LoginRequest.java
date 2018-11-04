package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class LoginRequest implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {

        String[] requestHandler = request.split("::");
        if (requestHandler.length != 3) {
            return "Login failed.";
        }
        String username = requestHandler[1];
        String password = requestHandler[2];
        Profile profile = profileManager.findByUsername(username);
        if (profile == null) {

            return "User doesn't exist.";
        }
        if (profile.getUsername().equals(username) &&
                profile.getPassword().equals(password)) {
            sender.setProfile(profile);
            return "Login was a success.";
        } else {
            return "Wrong username/password";
        }
    }
}

