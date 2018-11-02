package org.academiadecodigo.bootcamp.server.profiles;

public interface ProfileInterface {

    String write();
    void init();
    void add(Profile profile);
    String listAll();
    Profile findByUsername(String username);
}
