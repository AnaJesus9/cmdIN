package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class NewProfileRequest implements RequestAnalyser {

    @Override
    public String analyze(Server server , Server.ClientHandler sender, String request) {

        String[] requestHandler = request.split("::");
        if(requestHandler.length != 4) {
            return "Register failed.";
        }

        String username = requestHandler[1];
        String name = requestHandler[2];
        String password = requestHandler[3];

        Profile newProfile = new Profile(username, password, name, 0, "", "Nothing to display.");

        String response = server.getProfileManager().add(newProfile);
        server.updateFile();
        return response;
    }
}
