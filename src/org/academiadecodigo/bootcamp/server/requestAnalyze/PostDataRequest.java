package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class PostDataRequest implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, String request) {
        /*search for logged user
        update requested fields

        the 0 index of requestHandler should contain the field that user wants to update
        switch case to to get field user wants to update and post index 1 of requestHandler to respective field
        */
        String[] requestHandler = request.split(" ");

        if (requestHandler.length != 3) {

        }


        //return a message confirming whether data was updated successfully or not

        if(/*successful*/ ) {
            return "ok";
        }
        return "fail";
    }
}
