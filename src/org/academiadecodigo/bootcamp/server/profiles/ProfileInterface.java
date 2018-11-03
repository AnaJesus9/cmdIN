package org.academiadecodigo.bootcamp.server.profiles;

public interface ProfileInterface {


    void init();
    String add(Profile profile);
    String listAll();
    Profile findByUsername(String username);

}
