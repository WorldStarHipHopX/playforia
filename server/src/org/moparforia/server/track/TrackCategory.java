package org.moparforia.server.track;

/**
 * Playforia
 * 18.6.2013
 */
public enum TrackCategory {

    UNKNOWN("?", -1), ALL("-", 0), BASIC("basic", 1), TRADITIONAL("traditional", 2), MODERN("modern", 3), HIO("hio", 4), SHORT("short", 5), LONG("long", 6), CUSTOM("custom", 7);

    private final String dir;
    private final int id;

    private TrackCategory(String dir, int id) {
        this.dir = dir;
        this.id = id;
    }

    public String getDir() {
        return dir;
    }

    public int getId() {
        return id;
    }

    public static TrackCategory getByTypeId(int id) {
        for (TrackCategory type : TrackCategory.values())
            if (type.getId() == id)
                return type;

        return TrackCategory.UNKNOWN;
    }

}
