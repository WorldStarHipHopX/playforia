package adraw.lobby;

import adraw.GameApplet;
import com.aapeli.client.BadWordFilter;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.multiuser.ChatListener;
import com.aapeli.multiuser.ChatLobby;

class LobbyChatPanel extends ChatLobby implements ChatListener {

    private static boolean hasPrintedHelp = true;
    private GameApplet gameApplet;
    private LobbyPanel lobbyPanel;


    protected LobbyChatPanel(GameApplet gameApplet, Parameters params, TextManager textManager, ImageManager imageManager, BadWordFilter badwordFilter, LobbyPanel lobbyPanel, int width, int height) {
        super(params, textManager, imageManager, badwordFilter, false, true, width, height);
        this.gameApplet = gameApplet;
        this.lobbyPanel = lobbyPanel;
        this.setBackground(gameApplet.colourBackground);
        this.setForeground(gameApplet.colourForeground);
        int accessLevel = gameApplet.getPlayerAccessLevel();
        this.enablePopUp(accessLevel >= 1, accessLevel >= 2);
        if (!gameApplet.playerIsRegistered()) {
            this.disableChatInput(1);
        } else if (gameApplet.method24()) {
            this.disableChatInput(2);
        }

        this.addChatListener(this);
    }

    public void localUserSay(String var1) {
        this.lobbyPanel.writeLobbyCommand("say\t" + var1);
    }

    public void localUserSayPrivately(String var1, String var2) {
        this.lobbyPanel.writeLobbyCommand("say\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2) {
        this.lobbyPanel.writeLobbyCommand("command\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2, String var3) {
        this.lobbyPanel.writeLobbyCommand("command\t" + var1 + "\t" + var2 + "\t" + var3);
    }

    protected boolean handlePacket(String[] args) {
        if (args[1].equals("numberofusers")) {
            if (!hasPrintedHelp) {
                this.setFullUserList(new String[0]);
            }

            this.printHelp();
            int numPlayersInLobby = Integer.parseInt(args[2]);
            int numPlayersInGames = Integer.parseInt(args[3]);
            String numPlayersInLobbyMessage = null;
            if (numPlayersInLobby == 0) {
                numPlayersInLobbyMessage = super.textManager.getGame("LobbyChat_UsersInLobby0");
            }

            if (numPlayersInLobby == 1) {
                numPlayersInLobbyMessage = super.textManager.getGame("LobbyChat_UsersInLobby1");
            }

            if (numPlayersInLobby >= 2) {
                numPlayersInLobbyMessage = super.textManager.getGame("LobbyChat_UsersInLobbyX", numPlayersInLobby);
            }

            this.addPlainMessage(numPlayersInLobbyMessage);
            if (numPlayersInGames == 1) {
                this.addPlainMessage(super.textManager.getGame("LobbyChat_UsersInGame1"));
            }

            if (numPlayersInGames >= 2) {
                this.addPlainMessage(super.textManager.getGame("LobbyChat_UsersInGameX", numPlayersInGames));
            }

            this.addLine();
            return true;
        } else if(args[1].equals("users")) {
            int argsLen = args.length - 2;
            String[] var3 = new String[argsLen];

            for (int var4 = 0; var4 < argsLen; ++var4) {
                var3[var4] = args[2 + var4];
            }

            this.setFullUserList(var3);
            return true;
        } else if(args[1].equals("ownjoin")) {
            this.localUserJoin(args[2]);
            return true;
        } else if(args[1].equals("join") || args[1].equals("joinfromgame")) {
            this.userJoin(args[2], args[1].equals("joinfromgame"));
            return true;
        } else if(args[1].equals("part")) {
            int reason = Integer.parseInt(args[3]);
            if (reason == 1) {
                this.userLeft(args[2], false);
            }

            if (reason == 2) {
                this.userLeft(args[2], true);
            }

            if (reason == 3) {
                this.userLeftCreatedGame(args[2], args[4]);
            }

            if (reason == 4) {
                this.userLeftJoinedGame(args[2], args[4]);
            }

            return true;
        } else if(args[1].equals("say")) {
            this.userSay(args[2], args[3]);
            return true;
        } else if(args[1].equals("sayp")) {
            this.userSayPrivately(args[2], args[3]);
            return true;
        } else if(args[1].equals("sheriffsay")) {
            this.sheriffSay(args[2]);
            return true;
        } else if(args[1].equals("serversay")) {
            this.serverSay(args[2]);
            return true;
        }
        return false;
    }

    private void printHelp() {
        if (hasPrintedHelp) {
            this.addLine();
            String welcomeMessage = this.gameApplet.getWelcomeMessage();
            if (welcomeMessage != null) {
                this.addPlainMessage(welcomeMessage);
            }

            this.addPlainMessage(super.textManager.getGame("LobbyChat_QuickHelp"));
            this.addLine();
            hasPrintedHelp = false;
        } else {
            this.clearOutput();
        }
    }
}
