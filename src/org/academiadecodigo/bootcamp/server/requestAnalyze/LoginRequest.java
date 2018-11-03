package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class LoginRequest implements RequestAnalyzer {

    @Override
    public String analyze(ProfileManager profileManager, String request) {

        //compare request userName and password to existing usernames and corresponding passwords

        for (Profile profile: profileManager.getProfiles().values()) {
            if (profile.getUsername().equals(request) /* && requestPass = userPass */) {
                return "validLogin";
            }
        }
        return "invalidLogin";
    }
}
