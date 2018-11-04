package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class PostDataRequest implements RequestAnalyser {

    @Override
    public String analyze(Server server, Server.ClientHandler user, String request) {

        String[] requestHandler = request.split("::");

        if (requestHandler.length != 3) {
            return "Update failed.";
        }

        String targetField = requestHandler[1];
        String updateContent = requestHandler[2];

        Profile userProfile = server.getProfileManager().findByUsername(user.getProfile().getUsername());

        switch (targetField) {
            case "name":
                userProfile.setName(updateContent);
                server.updateFile();
                return "Name updated.";
            case "birthday":
                userProfile.setBirthday(updateContent);
                server.updateFile();
                return "birthday updated.";
            case "age":
                userProfile.setAge(Integer.parseInt(requestHandler[2]));
                server.updateFile();
                return "Age updated.";
            case "message":
                userProfile.setMessage(updateContent);
                server.updateFile();
                return "Message update.";
            default:
                return "fail";
        }
    }
}
