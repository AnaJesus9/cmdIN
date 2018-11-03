package org.academiadecodigo.bootcamp.server.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.ConcurrentHashMap;

public class ProfileManager implements ProfileInterface {
    @JsonProperty("profileList")
    private ConcurrentHashMap<String, Profile> profiles;

    public ProfileManager() {
        init();
    }

    @Override
    public void init() {
        profiles = new ConcurrentHashMap<>();
    }

    @Override
    public String add(Profile profile) {
        synchronized (this) {
            if (profiles.containsKey(profile.getUsername())) {
                return "You can't create a profile with this username.";
            }

            profiles.put(profile.getUsername(), profile);
            return "Your register was success.";
        }
    }

    @Override
    public String listAll() {
        if (profiles.isEmpty()) {
            return "No users to show.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Profile profile : profiles.values()) {
            stringBuilder.append(profile.getUsername() + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Profile findByUsername(String username) {
        return profiles.get(username);
    }

    public void setProfiles(ConcurrentHashMap<String, Profile> profiles) {
        this.profiles = profiles;
    }

    public ConcurrentHashMap<String, Profile> getProfiles() {
        return profiles;
    }
}
