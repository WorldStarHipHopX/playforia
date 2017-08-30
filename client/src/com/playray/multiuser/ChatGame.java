package com.playray.multiuser;

import com.playray.client.BadWordFilter;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.TextManager;
import com.playray.colorgui.ColorCheckbox;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.ChatGameListener;
import com.playray.multiuser.ChatListener;
import com.playray.multiuser.UserList;
import com.playray.multiuser.UserListItem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class ChatGame extends ChatBase {

    private boolean aBoolean4762;
    private ColorCheckbox aColorCheckbox4763;
    private boolean aBoolean4764;
    private GlossyButton aGlossyButton4765;
    private String aString4766;
    private Vector aVector4767;
    private Vector aVector4768;
    private int anInt4769;
    private static final String[] aStringArray4770 = new String[12];


    public ChatGame(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, int var7, int var8) {
        this(var1, var2, var3, var4, var5, var6, false, false, var7, var8);
    }

    public ChatGame(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, boolean var7, int var8, int var9) {
        this(var1, var2, var3, var4, var5, var6, false, var7, var8, var9);
    }

    public ChatGame(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, boolean var7, boolean var8, int var9, int var10) {
        super(var1, var2, var3, var4, false, false, var7, var8, var9, var10);
        this.gui_userlist.disableSheriffMark();
        this.gui_userlist.disableDimmerNicks();
        this.aBoolean4762 = var5;
        this.aBoolean4764 = var6;
        this.aString4766 = null;
        this.aVector4767 = new Vector();
        this.aVector4768 = new Vector();
        this.anInt4769 = 0;
        this.method2957();
        this.resizeLayout();
    }

    public void actionPerformed(ActionEvent var1) {
        super.actionPerformed(var1);
        if (this.aBoolean4764) {
            if (var1.getSource() == this.aGlossyButton4765) {
                UserListItem var2 = this.gui_userlist.getSelectedUser();
                if (var2 == null) {
                    this.gui_output.addMessage(this.aTextManager3809.getShared("Chat_Game_CantRemoveNone"));
                } else {
                    String var3 = var2.getNick();
                    if (var3.equalsIgnoreCase(this.aString4766)) {
                        this.gui_output.addMessage(this.aTextManager3809.getShared("Chat_Game_CantRemoveSelf"));
                    } else if (this.aVector4767.contains(var3)) {
                        this.gui_output.addMessage(this.aTextManager3809.getShared("Chat_Game_CantRemovePlayer"));
                    } else {
                        ChatGameListener[] var4 = this.method2958();

                        for (int var5 = 0; var5 < var4.length; ++var5) {
                            var4[var5].localUserBan(var3);
                        }

                    }
                }
            }
        }
    }

    public void addChatGameListener(ChatListener var1) {
        this.aVector4768.addElement(var1);
    }

    public void removeChatGameListener(ChatListener var1) {
        this.aVector4768.removeElement(var1);
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aBoolean4762) {
            this.aColorCheckbox4763.setBackground(var1);
        }

    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aBoolean4762) {
            this.aColorCheckbox4763.setForeground(var1);
        }

    }

    public void setUserListHeight(int var1) {
        this.anInt4769 = var1;
        this.resizeLayout();
    }

    public int setFullPlayerList(String[] var1) {
        this.gui_userlist.removeAllUsers();
        int var2 = var1.length;

        for (int var4 = 0; var4 < var2; ++var4) {
            String var3 = this.addToUserList(var1[var4], false);
            this.aVector4767.addElement(var3);
        }

        return var2;
    }

    public int setFullUserList(String[] var1, int var2) {
        if (var2 >= 0) {
            this.aString4766 = UserList.getNickFromUserInfo(var1[var2]);
        }

        return super.setFullUserList(var1, var2);
    }

    public String localUserJoin(String var1) {
        this.aString4766 = super.localUserJoin(var1);
        return this.aString4766;
    }

    public String localPlayerJoin(String var1) {
        String var2 = this.localUserJoin(var1);
        this.aVector4767.addElement(var2);
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
        this.aVector4767.addElement(var5);
        if (var3) {
            this.method2949(var4, var2 != null ? this.aTextManager3809.getShared("Chat_Game_PlayerJoinedClan", var5, var2) : this.aTextManager3809.getShared("Chat_Game_PlayerJoined", var5));
        }

        return var5;
    }

    public void playerLeft(String var1) {
        this.playerLeft(var1, false);
    }

    public void playerLeft(String var1, boolean var2) {
        UserListItem var3 = this.gui_userlist.removeUserNew(var1);
        this.aVector4767.removeElement(var1);
        if (var3 != null) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Game_PlayerLeft" + (var2 ? "ConnectionProblem" : ""), var1));
        }

    }

    public String spectatorJoin(String var1) {
        UserListItem var2 = this.addToUserListNew(var1, false);
        if (this.method2959()) {
            this.method2949(var2, this.aTextManager3809.getShared("Chat_Game_SpectatorJoined", var2.getNick()));
        }

        return var2.getNick();
    }

    public void spectatorLeft(String var1) {
        this.spectatorLeft(var1, false);
    }

    public void spectatorLeft(String var1, boolean var2) {
        UserListItem var3 = this.gui_userlist.removeUserNew(var1);
        if (var3 != null && this.method2959()) {
            this.method2949(var3, this.aTextManager3809.getShared("Chat_Game_SpectatorLeft" + (var2 ? "RemovedByPlayer" : ""), var1));
        }

    }

    public void changeToPlayer(String var1) {
        if (this.gui_userlist.getUser(var1) != null && !this.aVector4767.contains(var1)) {
            this.aVector4767.addElement(var1);
        }

    }

    public void changeToNonPlayer(String var1) {
        if (this.gui_userlist.getUser(var1) != null) {
            this.aVector4767.removeElement(var1);
        }

    }

    public void resizeLayout() {
        int var1 = ChatBase.getUserListWidth(this.anInt3813);
        double var2 = ((double) this.anInt3814 - 100.0D) / 150.0D;
        int var4 = (int) (20.0D + var2 * 5.0D);
        if (var4 < 20) {
            var4 = 20;
        } else if (var4 > 25) {
            var4 = 25;
        }

        int var5 = this.anInt3813 - 0 - 3 - var1 - 0;
        int var6 = this.anInt3814 - 0 - var4 - 2 - 0;
        int var7 = (int) (40.0D + ((double) var5 - 170.0D) / 430.0D * 60.0D);
        int var8 = (int) (70.0D + ((double) var5 - 200.0D) / 500.0D * 80.0D);
        if (var7 < 40) {
            var7 = 40;
        } else if (var7 > 100) {
            var7 = 100;
        }

        if (var8 < 70) {
            var8 = 70;
        } else if (var8 > 150) {
            var8 = 150;
        }

        int var9 = var5 - 1 - var7 - (this.aBoolean4762 ? 3 + var8 : 0);
        int var10 = 15;
        int var11 = this.anInt3814 - 0 - (this.aBoolean4764 ? var10 + 2 : 0) - 0;
        if (this.anInt4769 > 0) {
            var11 = this.anInt4769;
            var10 = this.anInt3814 - this.anInt4769 - 0 - 2;
        }

        this.gui_userlist.setBounds(0, 0, var1, var11);
        if (this.aBoolean4764) {
            this.aGlossyButton4765.setBounds(0, this.anInt3814 - 0 - var10, var1, var10);
        }

        synchronized (this) {
            if (this.gui_globaloutput == null) {
                this.gui_output.setBounds(0 + var1 + 3, 0, var5, var6);
            } else {
                this.gui_globaloutput.setBounds(0 + var1 + 3, 0, var5, var6);
            }
        }

        int var12 = 0 + var1 + 3;
        int var13 = 0 + var6 + 2;
        this.gui_input.setBounds(var12, var13, var9, var4);
        int var14 = 0 + var1 + 3 + var9 + 1;
        this.gui_say.setBounds(var14, 0 + var6 + 2, var7, var4);
        if (this.aBoolean4762) {
            this.aColorCheckbox4763.setBounds(0 + var1 + 3 + var9 + 1 + var7 + 3, 0 + var6 + 2 + 1, var8, var4 - 2);
        }

        this.gui_idnote.setBounds(var12, var13, var14 - var12 + var7, var4);
    }

    private void method2957() {
        if (this.aBoolean4762) {
            this.aColorCheckbox4763 = new ColorCheckbox(this.aTextManager3809.getShared("Chat_Game_NoSpectatorJoinPartMessages"));
            this.add(this.aColorCheckbox4763);
        }

        if (this.aBoolean4764) {
            this.aGlossyButton4765 = new GlossyButton(this.aTextManager3809.getShared("Chat_Game_RemoveSpectatorButton"), 7);
            this.aGlossyButton4765.addActionListener(this);
            this.add(this.aGlossyButton4765);
        }

    }

    private ChatGameListener[] method2958() {
        int var1 = this.aVector4768.size();
        ChatGameListener[] var2 = new ChatGameListener[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (ChatGameListener) ((ChatGameListener) this.aVector4768.elementAt(var3));
        }

        return var2;
    }

    private boolean method2959() {
        if (this.aBoolean4762) {
            return !this.aColorCheckbox4763.getState();
        } else {
            int var1 = this.gui_userlist.getUserCount() - this.aVector4767.size();
            return var1 < 20;
        }
    }

    static {
        aStringArray4770[0] = "Chat_Game_CantRemoveNone";
        aStringArray4770[1] = "Chat_Game_CantRemoveSelf";
        aStringArray4770[2] = "Chat_Game_CantRemovePlayer";
        aStringArray4770[3] = "Chat_Game_SpectatorJoined";
        aStringArray4770[4] = "Chat_Game_PlayerJoined";
        aStringArray4770[5] = "Chat_Game_PlayerJoinedClan";
        aStringArray4770[6] = "RemovedByPlayer";
        aStringArray4770[7] = "Chat_Game_SpectatorLeft";
        aStringArray4770[8] = "Chat_Game_RemoveSpectatorButton";
        aStringArray4770[9] = "Chat_Game_NoSpectatorJoinPartMessages";
        aStringArray4770[10] = "Chat_Game_PlayerLeft";
        aStringArray4770[11] = "ConnectionProblem";
    }
}
