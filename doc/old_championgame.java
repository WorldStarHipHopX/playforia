package org.server.game;

import org.server.*;
import org.server.game.gametypes.Game;

/**
 * pre set tracks game, the tracklist is static.
 */

public class ChampionshipGame extends Game {

    private int tracksetID;
    Player player;
    Session session;

    public ChampionshipGame(Player p, int tracksetID) {
        super(Lobby.LOBBY_SINGLE);
        this.tracksetID = tracksetID;
        addPlayer(p);
        player = players.get(0);
        session = Server.getSession(player);
        initTracks();
        startGame();
    }

    @Override
    protected void initTracks() {
        // tracks = TrackStore.getRandomTrackSet(10,0); // todo: championship isnt random, must have sets.
        tracks = TrackStore.championshipSet(0);
    }

    protected void startGame() {
        broadcastD("status", "game");
        // name, password, playertype?, playerCount, numberOfTracks,
        // trackType, maxstrokes, strokeTimeout, water, collision, trackscore,
        // trackscoreend, tracksetlist!?!

        broadcastD("game", "gameinfo", "Single Moms In Your Area", "f", 0, 1, tracks.length, -1, 0, 0, 0, 0, 0, 0, "t");
        broadcastD("game", "players");
        broadcastD("game", "owninfo", 0, player.nick, "-");
        broadcastD("game", "cr", "0,0,0,0,0,0,0,0,0",
                "2,2,3,3,3,3,1,4,5", "2,3,3,3,3,4,1,6,7",
                "2,2,2,2,3,3,1,3,4", "2,2,2,2,3,3,1,3,4");
        broadcastD("game", "start");
        broadcastD("game", "starttrack","t", gameId, tracks[0]);
        broadcastD("game", "startturn", 0);
    }
}
