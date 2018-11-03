package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class NewProfileRequest implements RequestAnalyzer {


    @Override
    public String analyze(ProfileManager profileManager, String request) {


        // request format: output.println("register " + userName + " " + name + " " + password + "\n");

        String[] requestHandler = request.split(" ");
        if(requestHandler.length != 4) {
            return "fail";
        }

        String username = requestHandler[1];
        String name = requestHandler[2];
        String password = requestHandler[3];

        Profile newProfile = new Profile(username,password,name, 0, "asd", "asd");

        String success = "You can't create a profile with this username.";
        if (profileManager.add(newProfile).equals(success)) {
            return "ok";
        }
        return "fail";
    }
}
