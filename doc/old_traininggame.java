package org.server.game;

import org.server.Lobby;
import org.server.Player;
import org.server.TrackStore;

/**
 * single player training game
 */
public class TrainingGame extends Game {

    private int tracksType;
    private int noOfTracks;
    private int water;
    private int permission;
    private int maxStrokes;
    private int strokeTimeout;
    private int collision;
    private int scoring;
    private int scoringEnd;

    public TrainingGame(Player p, int noOfTracks, int trackTypes, int water) {
        super(Lobby.LOBBY_SINGLE);
        addPlayer(p);
        this.noOfTracks = noOfTracks;
        this.tracksType = trackTypes;
        this.water = water;
        permission = PERM_EVERYONE;
        maxStrokes = STROKES_UNLIMITED;
        strokeTimeout = STROKETIMEOUT_INFINITE;
        collision = COLLISION_YES;
        scoring = SCORING_STROKE;
        scoringEnd = SCORING_WEIGHT_END_NONE;
        initTracks();
        startGame();
    }

    @Override
    protected void initTracks() {
        if((players.get(0).elevation == 2 && tracksType == 10) || (players.get(0).elevation < 2 && tracksType == 7)) {
            tracks = TrackStore.getRandomTrackSet(noOfTracks, 10);
        }
        else {
            tracks = TrackStore.getRandomTrackSet(noOfTracks, tracksType);
        }
    }

    @Override
    protected void startGame() {
        broadcastD("status", "game");
        broadcastD("game", "gameinfo", "Single Moms In Your Area", "f", permission, 1, tracks.length, tracksType,
                maxStrokes, strokeTimeout, water, collision, scoring, scoringEnd, "f");
        broadcastD("game", "players");
        for (int i = 0; i < players.size(); i++) {
            broadcastD("game", "owninfo", i, players.get(i).nick, "-");
        }
        broadcastD("game", "start");
        broadcastD("game", "starttrack", "t", gameId, tracks[0]);
        broadcastD("game", "startturn", 0);
    }


}
