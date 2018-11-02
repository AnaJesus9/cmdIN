package org.academiadecodigo.bootcamp.server.file;

import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public class FileMTester {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        ProfileManager profileManager = new ProfileManager();
        System.out.println(profileManager.add(new Profile("anabsjesus", "Ana Jesus", 21, "11/10/97", "Je sius belle!")));
        //System.out.println(profileManager.add(new Profile("anabsjesus", "Ana Jesus", 21, "11/10/97", "Je sius belle!")));
        System.out.println(profileManager.add(new Profile("bootcampter", "Bootcamp Terceira", 21, "11/10/97", "I am the best bootcamp!")));

        System.out.println(profileManager.listAll());

        System.out.println(profileManager.listAll());

        System.out.println(buildProfile(profileManager.findByUsername("bootcampter")));
        System.out.println(buildProfile(profileManager.findByUsername("anabsjesus")));

    }

    public static String buildProfile(Profile profile) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("┌─────────────┐        " +  profile.getName() + "\n");
        stringBuilder.append("│            │\n");
        stringBuilder.append("│            │\n");
        stringBuilder.append("│            │    Age: " + profile.getAge() + "\n");
        stringBuilder.append("│            │    Birthday: " + profile.getBirthday() + "\n");
        stringBuilder.append("│            │\n");
        stringBuilder.append("└─────────────┘\n");
        stringBuilder.append("Message: " + profile.getMessage() + "\n\n\n");

        return stringBuilder.toString();
    }
}
