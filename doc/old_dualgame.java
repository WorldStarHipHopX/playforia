package org.server.game;

import org.server.Lobby;
import org.server.Player;
import org.server.game.gametypes.Game;

/**
 * 1 v 1 challenge game?!?
 */
public class DualGame extends Game {

    public DualGame() {
        super(Lobby.LOBBY_DUAL);
        // "challenge\t" + this.opponentName + "\t" + this.tracksNum + "\t" + this.trackType + "\t" + this.maxStrokes + "\t" + this.timeLimit + "\t" + this.waterEvent + "\t" + this.collision + "\t" + this.scoring + "\t" + this.scoringEnd /*+ (isUsingCustomServer ? ("\t" + this.trackCategory) : "")*/);

    }

    @Override
    protected void initTracks() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void startGame() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void nextTrack() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void beginStroke(Player p, String mouseCoords) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void endStroke(Player p, String playStatus) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
