package org.academiadecodigo.bootcamp.server.file;

import com.google.gson.Gson;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

import java.io.*;

public class FileManager implements FileManagerInt {
    private File dataBase;
    private Gson gson;

    public FileManager() {
        this.dataBase = new File("resources/db.json");
        this.gson = new Gson();
    }

    @Override
    public void read(ProfileManager profileManager) {
        synchronized (this) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(dataBase));
                String json = reader.readLine();
                ProfileManager profileTemp = gson.fromJson(json, ProfileManager.class);
                profileManager.setProfiles(profileTemp.getProfiles());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                notifyAll();
            }
        }
    }

    @Override
    public void write(ProfileManager profileManager) {
        synchronized (this) {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(dataBase));
                String objToJson = gson.toJson(profileManager);
                writer.write(objToJson);
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                notifyAll();
            }
        }
    }
}
