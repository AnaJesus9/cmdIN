package org.academiadecodigo.bootcamp.server.requestanalyser;

import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.profiles.Profile;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                String[] dateHandler = updateContent.split("/");
                int birthdayYear = Integer.parseInt(dateHandler[2]);

                if (dateHandler.length != 3 || birthdayYear > currentYear) {
                    return "Wrong birthday format";
                }

                userProfile.setBirthday(updateContent);
                userProfile.setAge(currentYear - birthdayYear);
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
