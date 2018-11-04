package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.ProfileBuilder.ProfileBuilder;
import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class GetProfileRequest implements RequestAnalyzer {
    @Override
    public String analyze(ProfileManager profileManager, Server.ClientHandler sender, String request) {

        String[] splitResult = request.split("::");

        if(splitResult.length != 2) {
            return "Profile request unavailable. \nend";
        }

        String userToProfile = splitResult[1];
        Profile userProfile = profileManager.findByUsername(userToProfile);

        if(userProfile == null) {
            return "This user doesn't exist.\nend";
        }

        String finalProfile = ProfileBuilder.buildProfile(userProfile);
        return finalProfile;

    }
}
