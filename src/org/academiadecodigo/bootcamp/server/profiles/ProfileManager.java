package org.academiadecodigo.bootcamp.server.profiles;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.ConcurrentHashMap;

public class ProfileManager implements ProfileInterface{
    @JsonProperty("profileList")
    private ConcurrentHashMap<String, Profile> profiles;

    @Override
    public String write() {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void add(Profile profile) {

        }


    @Override
    public String listAll() {
        return null;
    }

    @Override
    public Profile findByUsername(String username) {
        return null;
    }

    public void setProfiles(ConcurrentHashMap<String, Profile> profiles) {
        this.profiles = profiles;
    }

    public ConcurrentHashMap<String, Profile> getProfiles() {
        return profiles;
    }
}
