package org.academiadecodigo.bootcamp.server.ProfileBuilder;

import org.academiadecodigo.bootcamp.server.profiles.Profile;

public class ProfileBuilder {
    public static String buildProfile(Profile profile) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("┌─────────────┐\n" );
        stringBuilder.append("│            │      " +  profile.getName() + "\n");
        stringBuilder.append("│    |||||   │\n");
        stringBuilder.append("│  {. @ @ .} │    Age: " + profile.getAge() + "\n");
        stringBuilder.append("│   |  o  |  │    Birthday: " + profile.getBirthday() + "\n");
        stringBuilder.append("│    \\_U_/   │\n");
        stringBuilder.append("└─────────────┘\n");
        stringBuilder.append("Message: " + profile.getMessage() + "\n\nend");

        return stringBuilder.toString();


    }
}
