package org.moparforia.server.game.gametypes.golf;

import org.moparforia.shared.Track;
import org.moparforia.server.game.Lobby;
import org.moparforia.server.game.LobbyType;
import org.moparforia.server.game.Player;
import org.moparforia.server.game.gametypes.GolfGame;
import org.moparforia.server.track.TrackManager;

import java.util.ArrayList;

/**

 */
public class ChampionshipGame extends GolfGame {

    private int championshipId;

    public ChampionshipGame(Player p, int gameId, int championshipId) {
        super(gameId, LobbyType.SINGLE, "derp", null, false, 10,
                PERM_EVERYONE, 0, STROKES_UNLIMITED, STROKETIMEOUT_INFINITE,
                WATER_START, COLLSION_YES, SCORING_STROKE, SCORING_WEIGHT_END_NONE, 1);
        this.championshipId = championshipId;
        tracks = initTracks();

        Lobby lob = p.getLobby();
        if (addPlayer(p)) {
            lob.addGame(this);
            startGame();
        } else {
            //todo: if adding da player failed init!!
        }
    }

    public ArrayList<Track> initTracks() {
        ArrayList<Track> tracks = TrackManager.getTrackSet(championshipId);
        this.numberOfTracks = tracks.size(); // important we set this depending on set.
        return tracks;
    }
}
