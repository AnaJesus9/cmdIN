package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class GetDataRequest implements RequestAnalyser {


    @Override
    public String analyze(Server server, Server.ClientHandler sender, String request) {
        String[] requestHandler = request.split("::");

        if (requestHandler.length != 3) {
            return "fail";
        }

        String targetUsername = requestHandler[1];

        Profile tempProfile = server.getProfileManager().findByUsername(targetUsername);

        switch (requestHandler[2]) {
            case "name":
                return tempProfile.getName();
            case "birthday":
                return tempProfile.getBirthday();
            case "age":
                String age = tempProfile.getAge() + "";
                return age;
            case "message":
                return tempProfile.getMessage();
            default:
                return "fail";
        }
    }
}
