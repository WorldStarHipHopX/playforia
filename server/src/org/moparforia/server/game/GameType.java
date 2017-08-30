package org.moparforia.server.game;

/**
 * Playforia
 * 24.6.2013
 */
public enum GameType {

    GOLF(35), GOLF2(14), CANNONS(24), POOL(41);//, DRAW(16)

    private final int version;

    private GameType(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public static GameType getType(int version) {
        for (GameType type : GameType.values()) {
            if (type.getVersion() == version) {
                return type;
            }
        }
        return null;
    }
}
