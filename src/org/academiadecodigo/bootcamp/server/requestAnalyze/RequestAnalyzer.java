package org.academiadecodigo.bootcamp.server.requestAnalyze;

import org.academiadecodigo.bootcamp.server.profiles.ProfileManager;

public interface RequestAnalyzer {

    String analyze(ProfileManager profileManager, String request);
}
