package acannons;

import acannons.ClientSettings;
import acannons.GameApplet;
import com.playray.multiuser.ChatLobby;
import com.playray.multiuser.GlobalChatListener;
import com.playray.multiuser.Languages;

class LobbyChat extends ChatLobby implements GlobalChatListener {

    private static boolean aBoolean4969 = true;
    private ClientSettings aClientSettings_4970;


    protected LobbyChat(ClientSettings var1, int var2, int var3) {
        super(var1.params, var1.textManager, var1.imageManager, var1.badWordFilter, true, var2, var3);
        this.aClientSettings_4970 = var1;
        this.setBackground(GameApplet.aColor4781);
        this.setForeground(GameApplet.aColor4782);
        int var4 = var1.gameApplet.method2283();
        this.enablePopUp(var4 >= 1, var4 >= 2);
        if (!var1.gameApplet.method2282()) {
            this.disableChatInput(1);
        } else if (var1.gameApplet.method2284()) {
            this.disableChatInput(2);
        }

        this.setOutputToGlobal(Languages.getLanguageIdByString(var1.params.getChatLang()));
        this.addChatListener(this);
    }

    public void localUserSay(String var1) {
    }

    public void localUserSay(int var1, String var2) {
        this.aClientSettings_4970.lobbyPanel.method2453("say\t" + var1 + "\t" + var2);
    }

    public void localUserSayPrivately(String var1, String var2) {
        this.aClientSettings_4970.lobbyPanel.method2453("sayp\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2) {
        this.aClientSettings_4970.lobbyPanel.method2453("command\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2, String var3) {
        this.aClientSettings_4970.lobbyPanel.method2453("command\t" + var1 + "\t" + var2 + "\t" + var3);
    }

    protected boolean handlePacket(String[] var1) {
        int var2;
        int var6;
        if (var1[1].equals("numberofusers")) {
            this.method2962();
            var2 = Integer.parseInt(var1[2]);
            var6 = Integer.parseInt(var1[3]);
            String var7 = null;
            if (var2 == 0) {
                var7 = this.aTextManager3809.method2039("LobbyChat_UsersInLobby0");
            } else if (var2 == 1) {
                var7 = this.aTextManager3809.method2039("LobbyChat_UsersInLobby1");
            } else if (var2 >= 2) {
                var7 = this.aTextManager3809.method2045("LobbyChat_UsersInLobbyX", var2);
            }

            this.addPlainMessage(var7);
            if (var6 == 1) {
                this.addPlainMessage(this.aTextManager3809.method2039("LobbyChat_UsersInGame1"));
            } else if (var6 >= 2) {
                this.addPlainMessage(this.aTextManager3809.method2045("LobbyChat_UsersInGameX", var6));
            }

            this.addLine();
            return true;
        } else if(var1[1].equals("users")) {
            var2 = var1.length - 2;
            String[] var3 = new String[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var3[var4] = var1[2 + var4];
            }

            this.setFullUserList(var3);
            return true;
        } else if(var1[1].equals("ownjoin")) {
            this.localUserJoin(var1[2]);
            return true;
        } else if(var1[1].equals("join") || var1[1].equals("joinfromgame")) {
            this.userJoin(var1[2], var1[1].equals("joinfromgame"));
            return true;
        } else if (var1[1].equals("part")) {
            var6 = Integer.parseInt(var1[3]);
            if (var6 == 1) {
                this.userLeft(var1[2], false);
            } else if (var6 == 2) {
                this.userLeft(var1[2], true);
            } else if (var6 == 4) {
                this.userLeftCreatedGame(var1[2], var1[4]);
            } else if (var6 == 5) {
                this.userLeftJoinedGame(var1[2], var1[4]);
            }

            return true;
        } else if (var1[1].equals("gsn")) {
            this.usersLeftStartedGame(var1[2], var1[3]);
            return true;
        } else if (var1[1].equals("say")) {
            this.userSay(Integer.parseInt(var1[2]), var1[3], var1[4]);
            return true;
        } else if (var1[1].equals("sayp")) {
            this.userSayPrivately(var1[2], var1[3]);
            return true;
        } else if (var1[1].equals("sheriffsay")) {
            this.sheriffSay(var1[2]);
            return true;
        } else if (var1[1].equals("serversay")) {
            this.serverSay(var1[2]);
            return true;
        }
        return false;
    }

    private void method2962() {
        if (aBoolean4969) {
            this.addLine();
            String var1 = this.aClientSettings_4970.gameApplet.method2286();
            if (var1 != null) {
                this.addPlainMessage(var1);
                this.addLine();
            }

            aBoolean4969 = false;
        } else {
            this.clearOutput();
        }

    }
}
