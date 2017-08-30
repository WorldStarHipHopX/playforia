package org.server;

import com.sun.xml.internal.ws.api.server.AbstractServerAsyncTransport;
import org.server.game.*;

/**
 * Playforia
 * 31.5.2013
 */
public class Handler {

    public void handleS(Session session, String string) {
        String[] args = string.split("\t");
        if (args[0].equals("tlog")) {
            // tlog	1	clientconnect	loadtime:i:539^loadertime:i:1239
            int i = Integer.parseInt(args[1]);
            String dont = args[2];
            String know = args[3];
        }
    }

    public void handleCommand(Session session, String cmd) {
        Player player = session.getPlayer();
        if (cmd.equals("new")) {
            Conn.writeC(session, "id " + Server.nextId());
        } else if (cmd.startsWith("old ")) {
            int oldId = Integer.parseInt(cmd.substring(4));//todo checks, maybe
            Conn.writeC(session, "id " + Server.nextId());
        } else if (cmd.equals("pong")) {
            session.lastPong = System.currentTimeMillis();
        }
    }

    public void handleData(Session session, String data) {
        Player player = session.getPlayer();

        int firstSpace = data.indexOf(' ');
        long numClientSentPackets = Long.parseLong(data.substring(0, firstSpace));//todo checks, maybe
        data = data.substring(firstSpace + 1);
        String[] args = data.split("\t");

        if (args[0].equals("version")) {
            String version = args[1];//todo checks, maybe
            Conn.writeD(session, "versok");
        } else if (args[0].equals("language")) {
            String locale = args[1];
            player.locale = locale;
        } else if (args[0].equals("logintype")) {
            String logintype = args[1];//nr=not registered, reg=registered
            Conn.writeD(session, "status", "login");
        } else if (args[0].equals("login")) {
            Conn.writeD(session, "basicinfo",
                    player.isEmailVerified ? "t" : "f", player.elevation,
                    Config.USE_BADWORD_FILTER ? "t" : "f", Config.DISABLE_GUEST_CHAT ? "t" : "f");
            Conn.writeD(session, "status", "lobbyselect");// thid param would be an integer (with the official server it's 300)
        } else if (args[0].equals("lobbyselect")) {
            if (args[1].equals("rnop")) {
                // request number of players
                Conn.writeD(session, "nop", Server.getLobby(0).numPlayersInLobby(),
                        Server.getLobby(1).numPlayersInLobby(), Server.getLobby(2).numPlayersInLobby());

            } else if (args[1].equals("select")) {
                String lobbyId = args[2];
                int lobbyIdInt = Integer.parseInt(lobbyId.equals("x") ? "3" : lobbyId);
                if (Server.getLobby(lobbyIdInt - 1).hasPlayer(player))
                    return;//todo or disconnect
                for (int i = 0; i < 3; i++)
                    Server.getLobby(i).removePlayer(player);

                Lobby lobby = Server.getLobby(lobbyIdInt - 1);
                lobby.addPlayer(player);

            }
        } else if (args[0].equals("lobby")) {

            if (args[1].equals("tracksetlist")) {
                Conn.writeD(session, "lobby", "tracksetlist", "moparisthebest", "2", "18", "bigT II", "52", "muminjsh",
                        "91", "jimbojones123", "77", "Vargav", "98", "Brolapse", "1", "9", "bigT II", "22",
                        "lutikas", "32", "lutikas", "31", "lutikas", "32", "Niall", "1", "18", "bigT II",
                        "41", "anu42", "54", "taifferi", "50", "anu42", "54", "tL", "2", "9", "bigT II",
                        "35", "jimbojones123", "50", "lutikas", "46", "Modellbauer", "50", "dongs", "3", "9",
                        "Tgib", "36", "DysT", "105", "Modellbauer", "60", "-", "0", "bnl", "3", "18",
                        "Shaun The Best", "88", "muminjsh", "185", "kylamees", "143", "-", "0", "Fat_Cookies",
                        "2", "18", "bigT II", "18", "Nicko1", "39", "Nicko1", "38", "tkrrotk", "43");// temp workaround

            } else if (args[1].equals("cspc")) { // start championship game!11!
                int setId = Integer.parseInt(args[2]);
                ChampionshipGame championshipGame = new ChampionshipGame(player, setId);
                Server.getLobby(0).addGame(championshipGame); // championshipgame is in singleplayer lobby

            } else if (args[1].equals("cspt")) { // create training game
                int numberOfTracks =Integer.parseInt(args[2]);
                int trackType = Integer.parseInt(args[3]);
                int water = Integer.parseInt(args[4]);
                TrainingGame game = new TrainingGame(player,numberOfTracks,trackType,water);
                Server.getLobby(0).addGame(game);
            } else if (args[1].equals("challenge")) { // challenge another player
                // ("challenge\t" + this.opponentName + "\t" + this.tracksNum + "\t" + this.trackType + "\t" + this.maxStrokes + "\t" + this.timeLimit +
                // "\t" + this.waterEvent + "\t" + this.collision + "\t" + this.scoring + "\t" + this.scoringEnd
                Challenge c = new Challenge(player);
                Player other = Server.getPlayer(Lobby.LOBBY_DUAL, args[2]);
                if(other == null || other.equals(player)) {
                    Conn.writeD(session, Tools.tabularize("lobby", "cfail", "nouser"));
                    return;
                } else if(other.isNotAcceptingChallenges) {
                    Conn.writeD(session, Tools.tabularize("lobby", "cfail", "nochall"));
                    return;
                }
                Challenge c1 = Server.getChallenge(other);
                if(c1 != null) {
                    if(c1.challenged != null && c1.challenged.equals(other)) {
                        Conn.write(session, Tools.tabularize("lobby", "cfail", "cbyother"));
                        return;
                    } else if(c1.challenger != null && c1.challenger.equals(other)) {
                        Conn.write(session, Tools.tabularize("lobby", "cfail", "cother"));
                        return;
                    } else {
                        c1 = null;
                    }
                }

                c.challenged = other;
                int i = 3;
                c.numTracks = Integer.parseInt(args[i++]);
                c.trackType = Integer.parseInt(args[i++]);
                c.maxStrokes = Integer.parseInt(args[i++]);
                c.timeLimit = Integer.parseInt(args[i++]);
                c.waterEvent = Integer.parseInt(args[i++]);
                c.collision = Integer.parseInt(args[i++]);
                c.scoring = Integer.parseInt(args[i++]);
                c.scoringEnd = Integer.parseInt(args[i++]);
                Conn.writeD(session, Tools.tabularize("lobby", "challenge", c.challenger.nick, c.numTracks,
                        c.trackType, c.maxStrokes, c.timeLimit, c.waterEvent, c.collision, c.scoring, c.scoringEnd));
                Server.addChallenge(c);
            } else if(args[1].equals("cancel")) {
                Player other = Server.getPlayer(Lobby.LOBBY_DUAL, args[2]);
                Challenge c = Server.getChallenge(player);
                if(c == null) {
                    //todo kick etc
                    return;
                }
                Conn.writeD(Server.getSession(other), Tools.tabularize("lobby", "cancel"));
                Server.removeChallenge(c);
            } else if(args[1].equals("cfail")) {
                Player other = Server.getPlayer(Lobby.LOBBY_DUAL, args[2]);
                if(args[3].equals("refuse")) {
                    Challenge c = Server.getChallenge(other);
                    if(c == null) {
                        //todo kick
                        return;
                    }
                    Conn.writeD(session, Tools.tabularize("lobby", "cfail", "refuse"));
                    Server.removeChallenge(c);
                } else if(args[3].equals("cother")) {

                } else if(args[3].equals("nochall")) {

                } else if(args[3].equals("cbyother")) {

                }
            } else if (args[1].equals("cmpt")) { // create multiplayer game
                MultiplayerGame game = new MultiplayerGame(player, args);
                Lobby l = Server.getLobby(Lobby.LOBBY_MULTI);
                l.addGame(game);
                l.broadcastD("lobby", "gamelist", "add", game.getLobbyString());
                // lobby	gamelist	change

            } else if (args[1].equals("jmpt")) { // join existing multiplayer game
                //CLIENT> WRITE "d 6 lobby	jmpt	1647588	lomad"
                Game[] gams = Server.getLobby(Lobby.LOBBY_MULTI).getGames();
                for (int i = 0; i < gams.length; i++) {
                    MultiplayerGame game = (MultiplayerGame) gams[i];
                    if (game.gameId == Integer.parseInt(args[2])) {
                        String password = null;
                        if (args.length > 3) {
                            password = args[3];
                        }

                        game.addPlayer(player, password);
                        Server.getLobby(Lobby.LOBBY_MULTI).removePlayer(player);


                    }
                }
            } else if (args[1].equals("back")) {
                for (int i = 0; i < 3; i++) {
                    Lobby lob = Server.getLobby(i);
                    if (lob.hasPlayer(player)) {
                        lob.removePlayer(player);
                        Conn.writeD(Server.getSession(player), "status", "lobbyselect");
                    }

                }
            }

        } else if (args[0].equals("game")) {
            if (args[1].equals("beginstroke")) {
                //beginstroke\t7sw8

                Game g = getGame(player);
                String mouseCoords = args[2];
                g.beginStroke(player, mouseCoords);

            } else if (args[1].equals("endstroke")) {
                Game g = getGame(player);
                g.endStroke(player, args[3]);

            } else if (args[1].equals("voteskip") || args[1].equals("skip")) {
                Game g = getGame(player);
                g.voteSkip(player);

            } else if (args[1].equals("newgame")) {
                Game g = getGame(player);
                g.wantsNewGame(player);
            } else if (args[1].equals("back")) {
                Game g = getGame(player);

                // im sorry, i hate instanceof too.
                if (g instanceof MultiplayerGame) {
                    MultiplayerGame g2 = (MultiplayerGame) g;
                    g2.removePlayer(player);
                } else {
                    g.removePlayer(player);
                }

                Lobby l = Server.getLobby(g.getLobbySource());
                if (g.isEmpty()) {
                    System.out.println("is it really empty?");
                    l.removeGame(g);
                    // once again bit messy at the moment, cba to make nice
                    if (g instanceof MultiplayerGame) {
                        MultiplayerGame g2 = (MultiplayerGame) g;
                        g2.removeGameFromLobby();
                    }
                }
                l.addPlayer(player);
            }


        }
    }

    public Game getGame(Player p) {
        for (int i = 0; i < 3; i++) {
            Game yup = Server.getLobby(i).getGame(p);
            if (yup != null) {
                return yup;
            }
        }
        return null;
