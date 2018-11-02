package org.academiadecodigo.bootcamp.server.file;

import com.google.gson.Gson;
import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

import java.io.File;

public class FileManager implements FileManagerInt {
   private File dataBase;
   private Gson gson;

   public FileManager(){
       this.dataBase = new File("resources/db.json");
       this.gson = new Gson();
   }
   @Override
    public void read(ProfileManager profileManager) {

    }

    @Override
    public void write(ProfileManager profileManager) {

    }
}
