package apool;

import com.playray.multiuser.ChatLobby;
import com.playray.multiuser.GlobalChatListener;
import com.playray.multiuser.Languages;
import com.playray.multiuser.UserListItem;

class LobbyChat extends ChatLobby implements GlobalChatListener {

    private static boolean aBoolean4972 = true;
    private Class60 aClass60_4973;
    private SPanel_Sub21 aSPanel_Sub21_4974;


    protected LobbyChat(Class60 var1, SPanel_Sub21 var2, boolean var3, int var4, int var5) {
        super(var1.params, var1.textManager, var1.imageManager, var1.badWordFilter, var4, var5);
        this.aClass60_4973 = var1;
        this.aSPanel_Sub21_4974 = var2;
        this.setMessageMaximumLength(200);
        this.setBackground(GameApplet.aColor4807);
        this.setForeground(GameApplet.aColor4808);
        int var6 = var1.gameApplet.method2310();
        this.enablePopUp(var6 >= 1, var6 >= 2);
        if (var3) {
            this.disableChatInput(3);
        } else if (!var1.gameApplet.method2309()) {
            this.disableChatInput(1);
        } else if (var1.gameApplet.method2311()) {
            this.disableChatInput(2);
        }

        this.setOutputToGlobal(Languages.getLanguageIdByString(var1.params.getChatLang()));
        this.addChatListener(this);
    }

    public void localUserSay(String var1) {
    }

    public void localUserSay(int var1, String var2) {
        this.aSPanel_Sub21_4974.method2576();
        this.aSPanel_Sub21_4974.method2580("say\t" + var1 + "\t" + var2);
    }

    public void localUserSayPrivately(String var1, String var2) {
        this.aSPanel_Sub21_4974.method2576();
        this.aSPanel_Sub21_4974.method2580("sayp\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2) {
        this.aSPanel_Sub21_4974.method2580("command\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2, String var3) {
        this.aSPanel_Sub21_4974.method2580("command\t" + var1 + "\t" + var2 + "\t" + var3);
    }

    protected boolean method2963(String[] var1) {
        int var2;
        if (var1[1].equals("users")) {
            this.method2967();
            var2 = var1.length - 2;
            String[] var3 = new String[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var3[var4] = var1[2 + var4];
            }

            this.setFullUserList(var3);
            this.setCheckBoxStates(this.aClass60_4973.aClass61_1207.aBoolean1224, this.aClass60_4973.aClass61_1207.aBoolean1225);
            return true;
        } else if (!var1[1].equals("cgs")) {
            if (var1[1].equals("ownjoin")) {
                this.localUserJoin(var1[2]);
                return true;
            } else if (var1[1].equals("join")) {
                this.userJoin(var1[2], false);
                return true;
            } else if (var1[1].equals("show")) {
                this.userJoin(var1[2], true);
                return true;
            } else if (var1[1].equals("hidep")) {
                this.usersLeftStartedGame(var1[2], var1[3]);
                return true;
            } else if (var1[1].equals("hidew")) {
                this.userLeftWatchingGame(var1[2], LobbyGameListPanel.method2493(var1[3], var1[4]));
                return true;
            } else if (var1[1].equals("part")) {
                this.userLeft(var1[2], var1[3].equals("t"));
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
            } else if (var1[1].equals("coingamecantstart")) {
                this.addPlainMessage(this.aClass60_4973.textManager.method2039("Lobby_Chat_CoinGameCantStart"));
                return true;
            } else if (var1[1].equals("watchcantstart")) {
                this.addPlainMessage(this.aClass60_4973.textManager.method2039("Lobby_Chat_WatchCantStart"));
                return true;
            } else if (var1[1].equals("bannedfromgame")) {
                this.addPlainMessage(this.aClass60_4973.textManager.method2039("Lobby_Chat_BannedFromGame"));
                return true;
            } else if (var1[1].equals("nc")) {
                this.method2964(var1[2], var1[3].equals("t"));
                return true;
            } else if (var1[1].equals("cg")) {
                this.method2965(var1[2], var1[3].equals("t"));
                return true;
            } else {
                return false;
            }
        } else {
            for (var2 = 2; var2 < var1.length; ++var2) {
                this.method2965(var1[var2], true);
            }

            return true;
        }
    }

    protected void method2964(String var1, boolean var2) {
        UserListItem var3;
        if (var1 != null) {
            var3 = super.gui_userlist.getUser(var1);
        } else {
            var3 = super.gui_userlist.getLocalUser();
        }

        super.gui_userlist.setNotAcceptingChallenges(var3, var2);
    }

    protected void method2965(String var1, boolean var2) {
        UserListItem var3;
        if (var1 != null) {
            var3 = super.gui_userlist.getUser(var1);
        } else {
            var3 = super.gui_userlist.getLocalUser();
        }

        var3.setAfterNickIcon(var2 ? this.aClass60_4973.imageManager.method1983("coin-icon") : null);
    }

    protected void method2966() {
        boolean[] var1 = this.getCheckBoxStates();
        this.aClass60_4973.aClass61_1207.aBoolean1224 = var1[0];
        this.aClass60_4973.aClass61_1207.aBoolean1225 = var1[1];
    }

    private void method2967() {
        if (aBoolean4972) {
            this.addLine();
            String var1 = this.aClass60_4973.gameApplet.method2316();
            if (var1 != null) {
                this.addPlainMessage(var1);
                this.addLine();
            }

            aBoolean4972 = false;
        } else {
            this.clearOutput();
        }

    }
}
