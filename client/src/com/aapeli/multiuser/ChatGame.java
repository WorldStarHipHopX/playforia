package com.aapeli.multiuser;

import com.aapeli.client.BadWordFilter;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.ColorCheckbox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class ChatGame extends ChatBase {

    private static final Color aColor3654;
    private boolean aBoolean3655;
    private ColorCheckbox aColorCheckbox3656;
    private boolean aBoolean3657;
    private Component aComponent3658;
    private String aString3659;
    private Vector aVector3660;
    private Vector aVector3661;
    private int anInt3662;
    private static final String[] aStringArray3663 = new String[12];


    public ChatGame(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, int var7, int var8) {
        this(var1, var2, var3, var4, var5, var6, false, var7, var8);
    }

    public ChatGame(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, boolean var7, int var8, int var9) {
        super(var1, var2, var3, var4, false, false, false, var7, var8, var9);
        super.gui_userlist.disableSheriffMark();
        super.gui_userlist.disableDimmerNicks();
        this.aBoolean3655 = var5;
        this.aBoolean3657 = var6;
        this.aString3659 = null;
        this.aVector3660 = new Vector();
        this.aVector3661 = new Vector();
        this.anInt3662 = 0;
        this.method897();
        this.resizeLayout();
    }

    public void actionPerformed(ActionEvent var1) {
        super.actionPerformed(var1);
        if (this.aBoolean3657) {
            if (var1.getSource() == this.aComponent3658) {
                UserListItem var2 = super.gui_userlist.getSelectedUser();
                if (var2 == null) {
                    super.gui_output.addMessage(super.textManager.getShared("Chat_Game_CantRemoveNone"));
                } else {
                    String var3 = var2.getNick();
                    if (var3.equalsIgnoreCase(this.aString3659)) {
                        super.gui_output.addMessage(super.textManager.getShared("Chat_Game_CantRemoveSelf"));
                    } else if (this.aVector3660.contains(var3)) {
                        super.gui_output.addMessage(super.textManager.getShared("Chat_Game_CantRemovePlayer"));
                    } else {
                        ChatGameListener[] var4 = this.method898();

                        for (int var5 = 0; var5 < var4.length; ++var5) {
                            var4[var5].localUserBan(var3);
                        }

                    }
                }
            }
        }
    }

    public void addChatGameListener(ChatListener var1) {
        this.aVector3661.addElement(var1);
    }

    public void removeChatGameListener(ChatListener var1) {
        this.aVector3661.removeElement(var1);
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aBoolean3655) {
            this.aColorCheckbox3656.setBackground(var1);
        }

    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aBoolean3655) {
            this.aColorCheckbox3656.setForeground(var1);
        }

    }

    public void setUserListHeight(int var1) {
        this.anInt3662 = var1;
        this.resizeLayout();
    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        super.setBackgroundImage(var1, var2, var3);
        if (this.aBoolean3655) {
            Point var4 = this.aColorCheckbox3656.getLocation();
            this.aColorCheckbox3656.setBackgroundImage(var1, var2 + var4.x, var3 + var4.y);
        }

    }

    public int setFullPlayerList(String[] var1) {
        super.gui_userlist.removeAllUsers();
        int var2 = var1.length;

        for (int var4 = 0; var4 < var2; ++var4) {
            String var3 = this.addToUserList(var1[var4], false);
            this.aVector3660.addElement(var3);
        }

        return var2;
    }

    public int setFullUserList(String[] list, int var2) {
        if (var2 >= 0) {
            this.aString3659 = UserList.getNickFromUserInfo(list[var2]);
        }

        return super.setFullUserList(list, var2);
    }

    public String localUserJoin(String var1) {
        this.aString3659 = super.localUserJoin(var1);
        return this.aString3659;
    }

    public String localPlayerJoin(String var1) {
        String var2 = this.localUserJoin(var1);
        this.aVector3660.addElement(var2);
        return var2;
    }

    public String playerJoin(String var1) {
        return this.playerJoin(var1, (String) null, true);
    }

    public String playerJoin(String var1, String var2) {
        return this.playerJoin(var1, var2, true);
    }

    public String playerJoin(String var1, String var2, boolean var3) {
        UserListItem var4 = this.addToUserListNew(var1, false);
        String var5 = var4.getNick();
        this.aVector3660.addElement(var5);
        if (var3) {
            this.method889(var4, var2 != null ? super.textManager.getShared("Chat_Game_PlayerJoinedClan", var5, var2) : super.textManager.getShared("Chat_Game_PlayerJoined", var5));
        }

        return var5;
    }

    public void playerLeft(String var1) {
        this.playerLeft(var1, false);
    }

    public void playerLeft(String var1, boolean var2) {
        UserListItem var3 = super.gui_userlist.removeUserNew(var1);
        this.aVector3660.removeElement(var1);
        if (var3 != null) {
            this.method889(var3, super.textManager.getShared("Chat_Game_PlayerLeft" + (var2 ? "ConnectionProblem" : ""), var1));
        }

    }

    public String spectatorJoin(String var1) {
        UserListItem var2 = this.addToUserListNew(var1, false);
        if (this.method899()) {
            this.method889(var2, super.textManager.getShared("Chat_Game_SpectatorJoined", var2.getNick()));
        }

        return var2.getNick();
    }

    public void spectatorLeft(String var1) {
        this.spectatorLeft(var1, false);
    }

    public void spectatorLeft(String var1, boolean var2) {
        UserListItem var3 = super.gui_userlist.removeUserNew(var1);
        if (var3 != null && this.method899()) {
            this.method889(var3, super.textManager.getShared("Chat_Game_SpectatorLeft" + (var2 ? "RemovedByPlayer" : ""), var1));
        }

    }

    public void changeToPlayer(String var1) {
        if (super.gui_userlist.getUser(var1) != null && !this.aVector3660.contains(var1)) {
            this.aVector3660.addElement(var1);
        }

    }

    public void changeToNonPlayer(String var1) {
        if (super.gui_userlist.getUser(var1) != null) {
            this.aVector3660.removeElement(var1);
        }

    }

    public synchronized boolean useRoundButtons() {
        if (!super.useRoundButtons()) {
            return false;
        } else {
            if (this.aBoolean3657) {
                this.aComponent3658 = this.copyColorButtonToRoundButton(this.aComponent3658);
            }

            if (this.aBoolean3655) {
                this.aColorCheckbox3656.setBoxPixelRoundedCorners(true);
            }

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
        if (var4 < 20) {
            var4 = 20;
        }

        if (var4 > 25) {
            var4 = 25;
        }

        int var5 = super.width - 0 - 3 - var1 - 0;
        int var6 = super.height - 0 - var4 - 2 - 0;
        int var7 = (int) (40.0D + ((double) var5 - 170.0D) / 430.0D * 60.0D);
        int var8 = (int) (70.0D + ((double) var5 - 200.0D) / 500.0D * 80.0D);
        if (var7 < 40) {
            var7 = 40;
        }

        if (var7 > 100) {
            var7 = 100;
        }

        if (var8 < 70) {
            var8 = 70;
        }

        if (var8 > 150) {
            var8 = 150;
        }

        int var9 = var5 - 1 - var7 - (this.aBoolean3655 ? 3 + var8 : 0);
        int var10 = 15;
        int var11 = super.height - 0 - (this.aBoolean3657 ? var10 + 2 : 0) - 0;
        if (this.anInt3662 > 0) {
            var11 = this.anInt3662;
            var10 = super.height - this.anInt3662 - 0 - 2;
        }

        super.gui_userlist.setBounds(0, 0, var1, var11);
        if (this.aBoolean3657) {
            this.aComponent3658.setBounds(0, super.height - 0 - var10, var1, var10);
        }

        synchronized (this) {
            if (super.gui_globaloutput == null) {
                super.gui_output.setBounds(0 + var1 + 3, 0, var5, var6);
            } else {
                super.gui_globaloutput.setBounds(0 + var1 + 3, 0, var5, var6);
            }
        }

        int var12 = 0 + var1 + 3;
        int var13 = 0 + var6 + 2;
        super.gui_input.setBounds(var12, var13, var9, var4);
        int var14 = 0 + var1 + 3 + var9 + 1;
        super.gui_say.setBounds(var14, 0 + var6 + 2, var7, var4);
        if (this.aBoolean3655) {
            this.aColorCheckbox3656.setBounds(0 + var1 + 3 + var9 + 1 + var7 + 3, 0 + var6 + 2 + 1, var8, var4 - 2);
        }

        super.gui_idnote.setBounds(var12, var13, var14 - var12 + var7, var4);
    }

    private void method897() {
        if (this.aBoolean3655) {
            this.aColorCheckbox3656 = new ColorCheckbox(super.textManager.getShared("Chat_Game_NoSpectatorJoinPartMessages"));
            this.add(this.aColorCheckbox3656);
        }

        if (this.aBoolean3657) {
            ColorButton var1 = new ColorButton(super.textManager.getShared("Chat_Game_RemoveSpectatorButton"));
            var1.setBackground(aColor3654);
            var1.addActionListener(this);
            this.add(var1);
            this.aComponent3658 = var1;
        }

    }

    private ChatGameListener[] method898() {
        int var1 = this.aVector3661.size();
        ChatGameListener[] var2 = new ChatGameListener[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (ChatGameListener) ((ChatGameListener) this.aVector3661.elementAt(var3));
        }

        return var2;
    }

    private boolean method899() {
        if (this.aBoolean3655) {
            return !this.aColorCheckbox3656.getState();
        } else {
            int var1 = super.gui_userlist.getUserCount() - this.aVector3660.size();
            return var1 < 20;
        }
    }

    static {
        aStringArray3663[0] = "Chat_Game_PlayerJoined";
        aStringArray3663[1] = "Chat_Game_PlayerJoinedClan";
        aStringArray3663[2] = "Chat_Game_NoSpectatorJoinPartMessages";
        aStringArray3663[3] = "Chat_Game_RemoveSpectatorButton";
        aStringArray3663[4] = "Chat_Game_CantRemovePlayer";
        aStringArray3663[5] = "Chat_Game_CantRemoveSelf";
        aStringArray3663[6] = "Chat_Game_CantRemoveNone";
        aStringArray3663[7] = "ConnectionProblem";
        aStringArray3663[8] = "Chat_Game_PlayerLeft";
        aStringArray3663[9] = "RemovedByPlayer";
        aStringArray3663[10] = "Chat_Game_SpectatorLeft";
        aStringArray3663[11] = "Chat_Game_SpectatorJoined";
        aColor3654 = new Color(224, 144, 144);
    }
}
