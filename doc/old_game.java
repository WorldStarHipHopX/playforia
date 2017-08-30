package org.server.game;

import org.server.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Playforia
 * 30.5.2013
 */
public abstract class Game {

    public static final int PERM_EVERYONE = 0;
    public static final int PERM_REGISTERED = 1;
    public static final int PERM_VIP = 2;
    public static final int STROKES_UNLIMITED = 0;
    public static final int STROKETIMEOUT_INFINITE = 0;
    public static final int WATER_START = 0;
    public static final int WATER_SHORE = 1;
    public static final int COLLISION_NO = 0;
    public static final int COLLISION_YES = 1;
    public static final int SCORING_STROKE = 0;
    public static final int SCORING_TRACK = 1;
    public static final int SCORING_WEIGHT_END_NONE = 0;
    public static final int SCORING_WEIGHT_END_LITTLE = 1;
    public static final int SCORING_WEIGHT_END_PLENTY = 2;
    public int gameId;
    public List<Player> players;
    public List<Integer> playersNumber;
    public int numberIndex = 0;
    protected Track[] tracks;
    protected int currentTrack = 0;
    protected int confirmCount = 0;
    protected int strokesThisTrack = 0;
    protected int lobbySource;
    protected int wantsGameCount = 0;
    protected String playStatus;


    public Game(int lobbySource) {
        this.gameId = Server.generateGameID();
        this.lobbySource = lobbySource;
        players = new ArrayList<Player>();
        playersNumber = new ArrayList<Integer>();
    }


    protected abstract void initTracks();

    protected abstract void startGame();


    public int getLobbySource() {
        return lobbySource;
    }

    public boolean addPlayer(Player p) {
        //todo some check that you can actually add this player to this game.
        players.add(p);
        playersNumber.add(numberIndex++);
        return true;
    }

    public void removeGame() {
        // todo: clearup of game
    }

    public void beginStroke(Player p, String mouseCoords) {
        //todo: anti cheat mechanisms!
        int id = getIndex(p);
        broadcastDExcept(p, "game", "beginstroke", playersNumber.get(id), mouseCoords);

    }

    public void broadcastDExcept(Player p, Object... args) {
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).equals(p)) {
                Session s = Server.getSession(players.get(i));
                Conn.writeD(s, args);
            }
        }
    }

    public void endStroke(Player p, String playStatus) {
        boolean finished = true;
        this.playStatus = playStatus;
        for (int i = 0; i < playStatus.length(); i++) {
            if (playStatus.charAt(i) == 'f') {
                finished = false;
                break;
            }
        }


        confirmCount++; // only sends the command after everyone confirms end stroke.
        if (confirmCount == players.size()) {
            confirmCount = 0;
            if (finished) {
                nextTrack();
            } else {
                broadcastD("game", "startturn", getNextPlayer(playStatus));
            }
        }

    }

    public int getNextPlayer(String s) {
        strokesThisTrack++;
        int player = strokesThisTrack % players.size();

        if (s.charAt(player) == 't') {  // if this player has already finihed
            strokesThisTrack++;
        }
        return playersNumber.get(strokesThisTrack % players.size());
    }

    public int getFirstPlayer() {
        return playersNumber.get(0);
    }


    public void removePlayer(Player p) {
        int id = getIndex(p);
        players.remove(p);
        playersNumber.remove((Integer) id); // im not sure about this one :/
    }

    public int getIndex(Player p) {
        int id = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(p)) {
                id = i;
                break;
            }
        }
        return id;
    }

    protected void nextTrack() {
        strokesThisTrack = 0;
        currentTrack++;
        if (currentTrack < tracks.length) { // there is a next track
            Track t = tracks[currentTrack];
            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < players.size(); i++) {
                buff.append("t");
            }

            broadcastD("game", "starttrack", buff.toString(),gameId, t);
            broadcastD("game", "startturn", getFirstPlayer());
        } else {
            endGame();
        }
    }

    protected void endGame() {
        broadcastD("game", "end");
    }

    public void broadcastD(Object... data) {
        for (Player p : players) {
            Conn.writeD(Server.getSession(p), data);
        }
    }

    public void wantsNewGame(Player p) {
        wantsGameCount++;
        broadcastDExcept(p, "game", "rfng", playersNumber.get(getIndex(p)));
        if (wantsGameCount >= players.size()) {
            wantsGameCount = 0;
            currentTrack = 0;
            strokesThisTrack = 0;
            initTracks();
            startGame();
        }
    }

    public void voteSkip(Player p) {
        nextTrack(); // cba to implement this properly
    }

    public boolean hasPlayer(Player p) {
        return players.contains(p);
    }

    public boolean isEmpty() {
        return players.size() == 0;
    }

    public Player[] getPlayers() {
        return players.toArray(new Player[0]);
    }
}
