package org.server.game;

import org.server.*;

import java.util.Arrays;

/**
 * MULTIPLAYER init!11
 */
public class MultiplayerGame extends Game {


    public String name;
    public String password;
    public int playerCount;
    public int numberOfTracks;
    public int trackType;
    public int maxStrokes;
    public int strokeTimeout;
    public int water;
    public int collision;
    public int scoreSystem;
    public int weightEnd;
    private boolean isPublic = true;
    private boolean passworded;
    private Player creator;


    public MultiplayerGame(Player p, String[] values) {
        super(Lobby.LOBBY_MULTI);
        creator = p;
        this.name = values[2];
        this.password = values[3];
        passworded = (!(this.password.equals("-") || this.password.equals("")));
        this.playerCount = Integer.parseInt(values[5]);
        this.numberOfTracks = Integer.parseInt(values[6]);
        this.trackType = Integer.parseInt(values[7]);
        this.maxStrokes = Integer.parseInt(values[8]);
        this.strokeTimeout = Integer.parseInt(values[9]);
        this.water = Integer.parseInt(values[10]);
        this.collision = Integer.parseInt(values[11]);
        this.scoreSystem = Integer.parseInt(values[12]);
        this.weightEnd = Integer.parseInt(values[13]);
        initTracks();
        this.addPlayer(p, password); // must put pass or wrong method is called.
    }

    public String getLobbyString() {
        // CLIENT> READ "d 82 lobby	gamelist	full	2	1624968	#1624968	t	0	3	-1	10	1	20	60	0	1	0	0	1	1624960	#1624960	t	0	3	-1	10	1	20	60	0	1	0	0	1"

        return Tools.tabularize(gameId, name, passworded ? "t" : "f", 0,
                playerCount, -1, numberOfTracks, trackType, maxStrokes, strokeTimeout,
                water, collision, scoreSystem, weightEnd, players.size());
    }

    public boolean isPublic() {
        return isPublic;
    }


    @Override
    protected void initTracks() {
        if((creator.elevation == 2 && trackType == 10) || (creator.elevation < 2 && trackType == 7)) {
            tracks = TrackStore.getRandomTrackSet(numberOfTracks, 10);
        }
        else {
            tracks = TrackStore.getRandomTrackSet(numberOfTracks, trackType);
        }
    }

    public boolean addPlayer(Player p, String pass) {
        Lobby lobby = Server.getLobby(this.lobbySource);

        if (passworded && (!pass.equals(this.password))) {
            lobby.addPlayer(p); // LOL YOU GOT THE PASSWORD WRONG BACK TO THE LOBBY U GO
            return false;

        } else { // correct password or no password
            broadcastD("game", "join", players.size(), p.nick, "-"); // important this happens before players added.
            super.addPlayer(p);
            welcomeMessage(p);

            if (players.size() > 1) { // if this is not the first player, update list.
                lobby.broadcastD("lobby", "gamelist", "change", getLobbyString());
            }

            if (playerCount == players.size()) { // if game filled up, start!!
                startGame();
            }
            return true;
        }
    }


    protected void startGame() {
        removeGameFromLobby();
        broadcastD("game", "start");
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < players.size(); i++) {
            buff.append("t");
        }

        broadcastD("game", "starttrack", buff.toString(),gameId, tracks[0]);
        broadcastD("game", "startturn", 0);
    }

    private void welcomeMessage(Player p) {
        Session session = Server.getSession(p);
        Conn.writeD(session, "status", "game");
        Conn.writeD(session, "game", "gameinfo", name, "t", gameId, playerCount,
                numberOfTracks, trackType, maxStrokes, strokeTimeout, water, collision, scoreSystem, weightEnd, "f");
        String[] multiplier = new String[numberOfTracks];
        Arrays.fill(multiplier, "1");
        Conn.writeD(session, "game", "scoringmulti", Tools.tabularize(multiplier, ""));
        Conn.writeD(session, "game", "players");
        for (int i = 0; i < players.size(); i++) {
            Conn.writeD(session, "game", "owninfo", i, players.get(i).nick, "-");
        }
    }

    public void removePlayer(Player p) {
        int id = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(p)) {
                id = i;
            }
        }
        super.removePlayer(p);
        if (id != -1) {
            broadcastD("game", "part", id, 4);

            if (!isPublic) { // if the game is being played, just pick the first player to shoot.
                broadcastD("game", "startturn", playersNumber.get(0));
            }
        }
    }

    public void removeGameFromLobby() {
        isPublic = false;
        Server.getLobby(this.lobbySource).broadcastD("lobby", "gamelist", "remove", gameId);
    }

}
