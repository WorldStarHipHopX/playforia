package org.server;

import org.server.game.gametypes.Game;
import org.server.game.MultiplayerGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Playforia
 * 30.5.2013
 */
public class Lobby {

    public static final int LOBBY_SINGLE = 0;
    public static final int LOBBY_DUAL = 1;
    public static final int LOBBY_MULTI = 2;
    private List<Player> players;
    private List<Game> games;
    private int id;

    public Lobby(int id) {
        this.id = id + 1; // not sure why this must be +1, but it must!
        players = new ArrayList<Player>();
        games = new ArrayList<Game>();
    }

    public int numPlayersInLobby() {
        return players.size();
    }

    public int numPlayersInGame() {
        int count = 0;
        for (Game g : games) {
            count += g.players.size();
        }
        return count;
    }

    public Player[] getPlayers() {
        return players.toArray(new Player[0]);
    }

    public void addPlayer(Player player) {
        Session session = Server.getSession(player);
        if (!players.contains(player))
            players.add(player);
        Conn.writeD(session, "status", "lobby", id);
        //Conn.writeD(session, "numberofusers", 1, 2, 3, 4, 5, 6);
        // lobbySingle, ingameSingle, lobbyDual, ingameDual, lobbyMulti, ingameMulti


        Player[] lobbyPlayers = getPlayers();
        String[] lobbyPlayersData = new String[lobbyPlayers.length];
        int pointer = 0;
        for (int i = 0; i < lobbyPlayers.length; i++) {
            if (lobbyPlayers[i] != null && !lobbyPlayers[i].equals(player)) {
                lobbyPlayersData[pointer++] = lobbyPlayers[i].toString();
                Session ps = Server.getSession(lobbyPlayers[i]);
                Conn.writeD(ps, "lobby", "join", player.toString());
            }
        }
        if (lobbyPlayersData != null && lobbyPlayersData.length > 0 && lobbyPlayersData[0] != null)
            Conn.writeD(session, "lobby", "users", lobbyPlayersData);
        Conn.writeD(session, "lobby", "ownjoin", player.toString());
        Conn.writeD(session, "lobby", "serversay", "serversay");
        Conn.writeD(session, "lobby", "sheriffsay", "sheriffsay");

        if (id == 3) {
            Game[] games = getGames();
            String[] gameString = new String[games.length];
                        StringBuffer buff = new StringBuffer();
                        int length = 0;
                        for (int i = 0; i < gameString.length; i++) {
                            MultiplayerGame g = (MultiplayerGame) games[i];
                            if (g.isPublic()) {
                                buff.append(g.getLobbyString() + "\t");
                                length++;
                            }
                        }

                        Conn.writeD(session, "lobby", "gamelist", "full", length, buff.toString());
        }

    }

    public void removePlayer(Player p) {
        broadcastD("lobby", "part", p.nick, 3);
        players.remove(p);
    }

    public int numGames() {
        return games.size();
    }

    public Game[] getGames() {
        return games.toArray(new Game[0]);
    }

    public void addGame(Game g) {
        if (!games.contains(g))
            games.add(g);
    }

    public void removeGame(Game g) {
        g.removeGame();
        games.remove(g);
    }

    public Game getGame(Player p) {
        for (Game g : games)
            if (g.hasPlayer(p))
                return g;
        return null;
    }

    public boolean hasPlayer(Player player) {
        for (Player p : players)
            if (p.equals(player))
                return true;
        return false;
    }

    public void broadcastD(Object... data) {
        for (Player p : players) {
            Conn.writeD(Server.getSession(p), data);
        }
    }
}
