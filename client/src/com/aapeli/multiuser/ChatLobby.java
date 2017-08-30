package com.aapeli.multiuser;

import com.aapeli.client.BadWordFilter;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorCheckbox;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

public class ChatLobby extends ChatBase {

    private ColorCheckbox aColorCheckbox3664;
    private ColorCheckbox aColorCheckbox3665;
    private boolean aBoolean3666;
    private static final String[] aStringArray3667 = new String[14];


    public ChatLobby(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, int var5, int var6) {
        this(var1, var2, var3, var4, false, false, var5, var6);
    }

    public ChatLobby(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, int var6, int var7) {
        this(var1, var2, var3, var4, var5, false, var6, var7);
    }

    public ChatLobby(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, int var7, int var8) {
        super(var1, var2, var3, var4, var5, var6, var7, var8);
        this.method905();
        this.resizeLayout();
        this.aBoolean3666 = true;
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aColorCheckbox3664 != null) {
            this.aColorCheckbox3664.setBackground(var1);
        }

        if (this.aColorCheckbox3665 != null) {
            this.aColorCheckbox3665.setBackground(var1);
        }

    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aColorCheckbox3664 != null) {
            this.aColorCheckbox3664.setForeground(var1);
        }

        if (this.aColorCheckbox3665 != null) {
            this.aColorCheckbox3665.setForeground(var1);
        }

    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        super.setBackgroundImage(var1, var2, var3);
        Point var4 = this.aColorCheckbox3664.getLocation();
        Point var5 = this.aColorCheckbox3665.getLocation();
        this.aColorCheckbox3664.setBackgroundImage(var1, var2 + var4.x, var3 + var4.y);
        this.aColorCheckbox3665.setBackgroundImage(var1, var2 + var5.x, var3 + var5.y);
    }

    public int setFullUserList(String[] list) {
        int var2 = super.setFullUserList(list);
        if (this.aBoolean3666) {
            if (var2 >= 30) {
                this.aColorCheckbox3664.setState(true);
                if (var2 >= 40) {
                    this.aColorCheckbox3665.setState(true);
                }
            }

            this.aBoolean3666 = false;
        }

        return var2;
    }

    public String userJoin(String var1) {
        return this.addToUserList(var1, false);
    }

    public String userJoin(String var1, boolean var2) {
        UserListItem var3 = this.addToUserListNew(var1, false);
        if (!this.aColorCheckbox3664.getState()) {
            this.method889(var3, super.textManager.getShared("Chat_Lobby_User" + (var2 ? "ReturnedFromGame" : "Joined"), var3.getNick()));
        }

        return var3.getNick();
    }

    public void userLeft(String var1) {
        super.gui_userlist.removeUser(var1);
    }

    public void userLeft(String var1, boolean var2) {
        UserListItem var3 = super.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox3664.getState()) {
            this.method889(var3, super.textManager.getShared("Chat_Lobby_UserLeft" + (var2 ? "ConnectionProblem" : ""), var1));
        }

    }

    public void userLeftCreatedGame(String var1, String var2) {
        UserListItem var3 = super.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox3665.getState()) {
            this.method889(var3, super.textManager.getShared("Chat_Lobby_UserCreatedGame", var1, var2));
        }

    }

    public void userLeftJoinedGame(String var1, String var2) {
        UserListItem var3 = super.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox3665.getState()) {
            this.method889(var3, super.textManager.getShared("Chat_Lobby_UserJoinedGame", var1, var2));
        }

    }

    public void userLeftWatchingGame(String var1, String var2) {
        UserListItem var3 = super.gui_userlist.removeUserNew(var1);
        if (var3 != null && !this.aColorCheckbox3665.getState()) {
            this.method889(var3, super.textManager.getShared("Chat_Lobby_UserWathicngGame", var1, var2));
        }

    }

    public void usersLeftStartedGame(String var1, String var2, String var3) {
        UserListItem var4 = super.gui_userlist.removeUserNew(var1);
        UserListItem var5 = super.gui_userlist.removeUserNew(var2);
        if (var4 != null && var5 != null && !this.aColorCheckbox3665.getState()) {
            String var6;
            if (var3 != null) {
                var6 = super.textManager.getShared("Chat_Lobby_UsersStartedGame", var1, var2, var3);
            } else {
                var6 = super.textManager.getShared("Chat_Lobby_UsersStartedUnnamedGame", var1, var2);
            }

            this.method890(var4, var5, var6);
        }

    }

    public void usersLeftStartedGame(String var1, String var2) {
        this.usersLeftStartedGame(var1, var2, (String) null);
    }

    public UserListItem getSelectedUserForChallenge() {
        UserListItem var1 = super.gui_userlist.getSelectedUser();
        if (var1 == null) {
            super.gui_output.addMessage(super.textManager.getShared("Chat_Lobby_CantChallengeNone"));
        } else {
            if (!var1.isLocal()) {
                return var1;
            }

            super.gui_output.addMessage(super.textManager.getShared("Chat_Lobby_CantChallengeSelf"));
        }

        return null;
    }

    public String getSelectedNickForChallenge() {
        UserListItem var1 = this.getSelectedUserForChallenge();
        return var1 != null ? var1.getNick() : null;
    }

    public boolean[] getCheckBoxStates() {
        boolean[] var1 = new boolean[]{this.aColorCheckbox3664.getState(), this.aColorCheckbox3665.getState()};
        return var1;
    }

    public void setCheckBoxStates(boolean var1, boolean var2) {
        this.aColorCheckbox3664.setState(var1);
        this.aColorCheckbox3665.setState(var2);
    }

    public boolean isNoJoinPartMessages() {
        return this.aColorCheckbox3664.getState();
    }

    public boolean isNoGameMessages() {
        return this.aColorCheckbox3665.getState();
    }

    public synchronized boolean useRoundButtons() {
        if (!super.useRoundButtons()) {
            return false;
        } else {
            this.aColorCheckbox3664.setBoxPixelRoundedCorners(true);
            this.aColorCheckbox3665.setBoxPixelRoundedCorners(true);
            return true;
        }
    }

    public void resizeLayout() {
        int var1 = super.width / 5;
        if (var1 < 100) {
            var1 = 100;
        }

        if (var1 > 150) {
            var1 = 150;
        }

        double var2 = ((double) super.height - 100.0D) / 100.0D;
        int var4 = (int) (20.0D + var2 * 5.0D);
        int var5 = (int) (15.0D + var2 * 5.0D);
        if (var4 < 20) {
            var4 = 20;
        }

        if (var4 > 25) {
            var4 = 25;
        }

        if (var5 < 15) {
            var5 = 15;
        }

        if (var5 > 20) {
            var5 = 20;
        }

        int var6 = super.width - 0 - 3 - var1 - 0;
        int var7 = super.height - 0 - var5 - 3 - var4 - 2 - 0;
        int var8 = (int) (50.0D + ((double) var6 - 200.0D) / 300.0D * 70.0D);
        if (var8 < 50) {
            var8 = 50;
        }

        if (var8 > 100) {
            var8 = 100;
        }

        int var9 = var6 - 1 - var8;
        int var10 = (var6 - 2) / 2;
        super.gui_userlist.setBounds(0, 0, var1, super.height - 0 - 0);
        synchronized (this) {
            if (super.gui_globaloutput == null) {
                super.gui_output.setBounds(0 + var1 + 3, 0, var6, var7);
            } else {
                super.gui_globaloutput.setBounds(0 + var1 + 3, 0, var6, var7);
            }
        }

        int var11 = 0 + var1 + 3;
        int var12 = 0 + var7 + 2;
        super.gui_input.setBounds(var11, var12, var9, var4);
        int var13 = 0 + var1 + 3 + var9 + 1;
        super.gui_say.setBounds(var13, 0 + var7 + 2, var8, var4);
        this.aColorCheckbox3664.setBounds(0 + var1 + 3, super.height - 0 - var5, var10, var5);
        this.aColorCheckbox3665.setBounds(0 + var1 + 3 + var10 + 2, super.height - 0 - var5, var10, var5);
        super.gui_idnote.setBounds(var11, var12, var13 - var11 + var8, var4);
    }

    private void method905() {
        this.aColorCheckbox3664 = new ColorCheckbox(super.textManager.getShared("Chat_Lobby_NoJoinPartMessages"));
        this.add(this.aColorCheckbox3664);
        this.aColorCheckbox3665 = new ColorCheckbox(super.textManager.getShared("Chat_Lobby_NoGameMessages"));
        this.add(this.aColorCheckbox3665);
    }

    static {
        aStringArray3667[0] = "Chat_Lobby_UsersStartedUnnamedGame";
        aStringArray3667[1] = "Chat_Lobby_UsersStartedGame";
        aStringArray3667[2] = "Chat_Lobby_UserJoinedGame";
        aStringArray3667[3] = "Chat_Lobby_NoJoinPartMessages";
        aStringArray3667[4] = "Chat_Lobby_NoGameMessages";
        aStringArray3667[5] = "Chat_Lobby_User";
        aStringArray3667[6] = "ReturnedFromGame";
        aStringArray3667[7] = "Joined";
        aStringArray3667[8] = "Chat_Lobby_UserWathicngGame";
        aStringArray3667[9] = "ConnectionProblem";
        aStringArray3667[10] = "Chat_Lobby_UserLeft";
        aStringArray3667[11] = "Chat_Lobby_CantChallengeNone";
        aStringArray3667[12] = "Chat_Lobby_CantChallengeSelf";
        aStringArray3667[13] = "Chat_Lobby_UserCreatedGame";
    }
}
