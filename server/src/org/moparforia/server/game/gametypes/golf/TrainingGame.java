package org.moparforia.server.game.gametypes.golf;

import org.moparforia.shared.Track;
import org.moparforia.server.game.Lobby;
import org.moparforia.server.game.LobbyType;
import org.moparforia.server.game.Player;
import org.moparforia.server.game.gametypes.GolfGame;
import org.moparforia.server.track.TrackCategory;
import org.moparforia.server.track.TrackManager;

import java.util.ArrayList;

/**
 * training init
 */
public class TrainingGame extends GolfGame {

    public TrainingGame(Player p, int gameId, int tracksType, int numberOfTracks, int water) {
        super(gameId, LobbyType.SINGLE, "derp", null, false, numberOfTracks,
                PERM_EVERYONE, tracksType, STROKES_UNLIMITED, STROKETIMEOUT_INFINITE,
                water, COLLSION_YES, SCORING_STROKE, SCORING_WEIGHT_END_NONE, 1);

        Lobby lob = p.getLobby();
        if (addPlayer(p)) {
            lob.addGame(this);
            startGame();
        } else {

            //todo: if adding da player failed init!!
        }
    }

    @Override
    public ArrayList<Track> initTracks() {
        return TrackManager.getRandomTracks(numberOfTracks, TrackCategory.getByTypeId(tracksType));
    }
}
