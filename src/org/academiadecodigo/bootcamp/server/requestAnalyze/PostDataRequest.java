package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class PostDataRequest implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler user, String request) {
        /*search for logged user
        update requested fields

        the 0 index of requestHandler should contain the field that user wants to update
        switch case to to get field user wants to update and post index 1 of requestHandler to respective field
        */
        String[] requestHandler = request.split(" ");

        if (requestHandler.length != 3) {
            return "fail";
        }

        String targetField = requestHandler[1];
        String updateContent = requestHandler[2];

        Profile userProfile = profileManager.findByUsername();
        //return a message confirming whether data was updated successfully or not

        switch (targetField) {
            case "name":
                userProfile.setName(updateContent);
                return "ok";
            case "birthday":
                userProfile.setBirthday(updateContent);
                return "ok";
            case "age":
                int age = Integer.parseInt(requestHandler[2]);
                userProfile.setAge(age);
                return "ok";
            case "message":
                userProfile.setMessage(updateContent);
                return "ok";
            default:
                return "fail";

        }
        return "fail";
    }
}
