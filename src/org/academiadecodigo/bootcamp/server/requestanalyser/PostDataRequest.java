package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class PostDataRequest implements RequestAnalyser {

    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler user, String request) {

        String[] requestHandler = request.split("::");

        if (requestHandler.length != 3) {
            return "Update failed.";
        }

        String targetField = requestHandler[1];
        String updateContent = requestHandler[2];

        Profile userProfile = profileManager.findByUsername(user.getProfile().getUsername());

        switch (targetField) {
            case "name":
                userProfile.setName(updateContent);
                return "Name updated.";
            case "birthday":
                userProfile.setBirthday(updateContent);
                return "birthday updated.";
            case "age":
                int age = Integer.parseInt(requestHandler[2]);
                userProfile.setAge(age);
                return "Age updated.";
            case "message":
                userProfile.setMessage(updateContent);
                return "Message update.";
            default:
                return "fail";
        }
    }
}
