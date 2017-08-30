package com.playray.multiuser;

import com.playray.client.BadWordFilter;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.TextManager;
import com.playray.colorgui.ColorCheckbox;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.UserListItem;

import java.awt.Color;

public class ChatLobby extends ChatBase {

    private ColorCheckbox aColorCheckbox4771;
    private ColorCheckbox aColorCheckbox4772;
    private boolean aBoolean4773;
    private static final String[] aStringArray4774 = new String[14];


    public ChatLobby(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, int var5, int var6) {
        this(var1, var2, var3, var4, false, false, var5, var6);
    }

    public ChatLobby(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, int var6, int var7) {
        this(var1, var2, var3, var4, var5, false, var6, var7);
    }

    public ChatLobby(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, int var7, int var8) {
        super(var1, var2, var3, var4, var5, var6, var7, var8);
        this.method2960();
        this.resizeLayout();
        this.aBoolean4773 = true;
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aColorCheckbox4771 != null) {
            this.aColorCheckbox4771.setBackground(var1);
        }

        if (this.aColorCheckbox4772 != null) {
            this.aColorCheckbox4772.setBackground(var1);
        }

    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aColorCheckbox4771 != null) {
            this.aColorCheckbox4771.setForeground(var1);
        }

        if (this.aColorCheckbox4772 != null) {
            this.aColorCheckbox4772.setForeground(var1);
        }

    }

    public int setFullUserList(String[] var1) {
        int var2 = super.setFullUserList(var1);
        if (this.aBoolean4773) {
            if (var2 >= 30) {
                this.aColorCheckbox4771.setState(true);
                if (var2 >= 40) {
                    this.aColorCheckbox4772.setState(true);
                }
            }

            this.aBoolean4773 = false;
        }

        return var2;
    }

    public String userJoin(String var1) {
        return this.addToUserList(var1, false);
    }

    public String userJoin(String var1, boolean var2) {
        UserListItem var3 = this.addToUserListNew(var1, false);
        if (!this.aColorCheckbox4771.getState()) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Lobby_User" + (var2 ? "ReturnedFromGame" : "Joined"), var3.getNick()));
        }

        return var3.getNick();
    }

    public void userLeft(String var1) {
        this.gui_userlist.removeUser(var1);
    }

    public void userLeft(String var1, boolean var2) {
        UserListItem var3 = this.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox4771.getState()) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Lobby_UserLeft" + (var2 ? "ConnectionProblem" : ""), var1));
        }

    }

    public void userLeftCreatedGame(String var1, String var2) {
        UserListItem var3 = this.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox4772.getState()) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Lobby_UserCreatedGame", var1, var2));
        }

    }

    public void userLeftJoinedGame(String var1, String var2) {
        UserListItem var3 = this.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox4772.getState()) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Lobby_UserJoinedGame", var1, var2));
        }

    }

    public void userLeftWatchingGame(String var1, String var2) {
        UserListItem var3 = this.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox4772.getState()) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Lobby_UserWathicngGame", var1, var2));
        }

    }

    public void usersLeftStartedGame(String var1, String var2, String var3) {
        UserListItem var4 = this.gui_userlist.removeUserNew(var1);
        UserListItem var5 = this.gui_userlist.removeUserNew(var2);
        if (var4 != null && var5 != null && !this.aColorCheckbox4772.getState()) {
            String var6;
            if (var3 != null) {
                var6 = this.aTextManager3809.getShared("Chat_Lobby_UsersStartedGame", var1, var2, var3);
            } else {
                var6 = this.aTextManager3809.getShared("Chat_Lobby_UsersStartedUnnamedGame", var1, var2);
            }

            this.method2950(var4, var5, var6);
        }

    }

    public void usersLeftStartedGame(String var1, String var2) {
        this.usersLeftStartedGame(var1, var2, (String) null);
    }

    public UserListItem getSelectedUserForChallenge() {
        UserListItem var1 = this.gui_userlist.getSelectedUser();
        if (var1 == null) {
            this.gui_output.addMessage(this.aTextManager3809.getShared("Chat_Lobby_CantChallengeNone"));
        } else {
            if (!var1.isLocal()) {
                return var1;
            }

            this.gui_output.addMessage(this.aTextManager3809.getShared("Chat_Lobby_CantChallengeSelf"));
        }

        return null;
    }

    public String getSelectedNickForChallenge() {
        UserListItem var1 = this.getSelectedUserForChallenge();
        return var1 != null ? var1.getNick() : null;
    }

    public boolean[] getCheckBoxStates() {
        boolean[] var1 = new boolean[]{this.aColorCheckbox4771.getState(), this.aColorCheckbox4772.getState()};
        return var1;
    }

    public void setCheckBoxStates(boolean var1, boolean var2) {
        this.aColorCheckbox4771.setState(var1);
        this.aColorCheckbox4772.setState(var2);
    }

    public boolean isNoGameMessages() {
        return this.aColorCheckbox4772.getState();
    }

    public void disableChatInput(int var1) {
        if (var1 == 3) {
            this.aColorCheckbox4771.setState(false);
            this.aColorCheckbox4772.setState(false);
            this.aColorCheckbox4771.setVisible(false);
            this.aColorCheckbox4772.setVisible(false);
            this.resizeLayout();
        }

        super.disableChatInput(var1);
    }

    public void resizeLayout() {
        int var1 = ChatBase.getUserListWidth(this.anInt3813);
        double var2 = ((double) this.anInt3814 - 100.0D) / 100.0D;
        int var4 = (int) (20.0D + var2 * 5.0D);
        int var5 = (int) (15.0D + var2 * 5.0D);
        if (var4 < 20) {
            var4 = 20;
        } else if (var4 > 25) {
            var4 = 25;
        }

        if (var5 < 15) {
            var5 = 15;
        } else if (var5 > 20) {
            var5 = 20;
        }

        if (!this.aColorCheckbox4771.isVisible() && !this.aColorCheckbox4772.isVisible()) {
            var5 = 0;
        }

        int var6 = this.anInt3813 - 0 - 3 - var1 - 0;
        int var7 = this.anInt3814 - 0 - var5 - 3 - var4 - 2 - 0;
        int var8 = (int) (50.0D + ((double) var6 - 200.0D) / 300.0D * 70.0D);
        if (var8 < 50) {
            var8 = 50;
        } else if (var8 > 100) {
            var8 = 100;
        }

        int var9 = var6 - 1 - var8;
        int var10 = (var6 - 2) / 2;
        this.gui_userlist.setBounds(0, 0, var1, this.anInt3814 - 0 - 0);
        synchronized (this) {
            if (this.gui_globaloutput == null) {
                this.gui_output.setBounds(0 + var1 + 3, 0, var6, var7);
            } else {
                this.gui_globaloutput.setBounds(0 + var1 + 3, 0, var6, var7);
            }
        }

        int var11 = 0 + var1 + 3;
        int var12 = 0 + var7 + 2;
        this.gui_input.setBounds(var11, var12, var9, var4);
        int var13 = 0 + var1 + 3 + var9 + 1;
        this.gui_say.setBounds(var13, 0 + var7 + 2, var8, var4);
        if (var5 > 0) {
            this.aColorCheckbox4771.setBounds(0 + var1 + 3, this.anInt3814 - 0 - var5, var10, var5);
            this.aColorCheckbox4772.setBounds(0 + var1 + 3 + var10 + 2, this.anInt3814 - 0 - var5, var10, var5);
        }

        this.gui_idnote.setBounds(var11, var12, var13 - var11 + var8, var4);
    }

    private void method2960() {
        this.aColorCheckbox4771 = new ColorCheckbox(this.aTextManager3809.getShared("Chat_Lobby_NoJoinPartMessages"));
        this.add(this.aColorCheckbox4771);
        this.aColorCheckbox4772 = new ColorCheckbox(this.aTextManager3809.getShared("Chat_Lobby_NoGameMessages"));
        this.add(this.aColorCheckbox4772);
    }

    static {
        aStringArray4774[0] = "Chat_Lobby_UserJoinedGame";
        aStringArray4774[1] = "Chat_Lobby_UserCreatedGame";
        aStringArray4774[2] = "Chat_Lobby_NoJoinPartMessages";
        aStringArray4774[3] = "Chat_Lobby_NoGameMessages";
        aStringArray4774[4] = "Chat_Lobby_CantChallengeSelf";
        aStringArray4774[5] = "Chat_Lobby_CantChallengeNone";
        aStringArray4774[6] = "Chat_Lobby_UserLeft";
        aStringArray4774[7] = "ConnectionProblem";
        aStringArray4774[8] = "Chat_Lobby_UsersStartedUnnamedGame";
        aStringArray4774[9] = "Chat_Lobby_UsersStartedGame";
        aStringArray4774[10] = "Chat_Lobby_UserWathicngGame";
        aStringArray4774[11] = "Joined";
        aStringArray4774[12] = "ReturnedFromGame";
        aStringArray4774[13] = "Chat_Lobby_User";
    }
}
