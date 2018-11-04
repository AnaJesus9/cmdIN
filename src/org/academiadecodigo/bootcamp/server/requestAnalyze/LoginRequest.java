package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class LoginRequest implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {

        String[] requestHandler = request.split(" ");
        if (requestHandler.length != 3) {
            return "Error.";
        }
        String username = requestHandler[1];
        String password = requestHandler[2];
        Profile profile = profileManager.findByUsername(username);
        if (profile == null) {

            return "User doesn't exist.";
        }
        System.out.println("just before profile.getUsername().equals(username)");
        System.out.println(profile.getUsername().equals(username));
        if (profile.getUsername().equals(username) &&
                profile.getPassword().equals(password)) {
            sender.setProfile(profile);
            return "Login was a success.";
        } else {
            System.out.println("inside else");
            return "Wrong username/password";
        }
    }
}

