package org.moparforia.server.track;

import java.util.ArrayList;

/**
 * Playforia
 * 18.6.2013
 */
public class TrackSet {

    private String name;
    private TrackSetDifficulty difficulty;
    private ArrayList<String> filenames;

    public TrackSet(String name, TrackSetDifficulty difficulty, ArrayList<String> filenames) {
        this.name = name;
        this.difficulty = difficulty;
        this.filenames = filenames;
    }

    public String getName() {
        return name;
    }

    public TrackSetDifficulty getDifficulty() {
        return difficulty;
    }

    public ArrayList<String> getFilenames() {
        return filenames;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof TrackSet)) {
            return false;
        }
        TrackSet t = (TrackSet) o;
        return difficulty == t.difficulty && name.equals(t.name) && filenames.equals(t.filenames);
    }
}
