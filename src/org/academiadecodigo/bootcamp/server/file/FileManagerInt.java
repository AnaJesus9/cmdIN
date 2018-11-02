package org.academiadecodigo.bootcamp.server.file;

import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public interface FileManagerInt {

    void read(ProfileManager profileManager);


    void write(ProfileManager profileManager);

}
