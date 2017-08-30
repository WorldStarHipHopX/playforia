package com.playray.multiuser;

import com.playray.client.BadWordFilter;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.TextManager;
import com.playray.colorgui.ColorCheckbox;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.UserListItem;

import java.awt.Color;

public class ChatSimple extends ChatBase {

    private ColorCheckbox aColorCheckbox4775;
    private boolean aBoolean4776;
    private boolean aBoolean4777;
    private static final String[] aStringArray4778 = new String[5];


    public ChatSimple(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, int var5, int var6) {
        this(var1, var2, var3, var4, false, var5, var6);
    }

    public ChatSimple(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, int var6, int var7) {
        super(var1, var2, var3, var4, true, true, false, true, true, var6, var7);
        this.aBoolean4776 = var5;
        this.method2968();
        this.resizeLayout();
        this.aBoolean4777 = true;
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aColorCheckbox4775 != null) {
            this.aColorCheckbox4775.setBackground(var1);
        }

    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aColorCheckbox4775 != null) {
            this.aColorCheckbox4775.setForeground(var1);
        }

    }

    public int setFullUserList(String[] var1) {
        int var2 = super.setFullUserList(var1);
        if (this.aBoolean4777) {
            if (var2 >= 30) {
                this.aColorCheckbox4775.setState(true);
            }

            this.aBoolean4777 = false;
        }

        return var2;
    }

    public String userJoin(String var1) {
        UserListItem var2 = this.addToUserListNew(var1, false);
        if (!this.aColorCheckbox4775.getState()) {
            this.method2949(var2, this.aTextManager3809.getShared("Chat_Simple_UserJoined", var2.getNick()));
        }

        return var2.getNick();
    }

    public void userLeft(String var1) {
        UserListItem var2 = this.gui_userlist.removeUserNew(var1);
        if (var2 != null && !this.aColorCheckbox4775.getState()) {
            this.method2949(var2, this.aTextManager3809.getShared("Chat_Simple_UserLeft", var1));
        }

    }

    public void resizeLayout() {
        int var1 = ChatBase.getUserListWidth(this.anInt3813);
        double var2 = ((double) this.anInt3814 - 100.0D) / 100.0D;
        int var4 = (int) (20.0D + var2 * 5.0D);
        int var5 = this.aBoolean4776 ? 0 : 18;
        if (var4 < 20) {
            var4 = 20;
        }

        if (var4 > 25) {
            var4 = 25;
        }

        int var6 = this.anInt3813 - 3 - var1;
        int var7 = this.anInt3814 - var5 - 3 - var4 - 2;
        int var8 = (int) (50.0D + ((double) var6 - 200.0D) / 300.0D * 70.0D);
        if (var8 < 50) {
            var8 = 50;
        }

        if (var8 > 100) {
            var8 = 100;
        }

        int var9 = var6 - 1 - var8;
        int var10 = (var6 - 2) / 2;
        this.gui_userlist.setBounds(0, 0, var1, this.anInt3814);
        synchronized (this) {
            if (this.gui_globaloutput == null) {
                this.gui_output.setBounds(var1 + 3, 0, var6, var7);
            } else {
                this.gui_globaloutput.setBounds(var1 + 3, 0, var6, var7);
            }
        }

        int var11 = var1 + 3;
        int var12 = var7 + 2;
        this.gui_input.setBounds(var11, var12, var9, var4);
        int var13 = var1 + 3 + var9 + 1;
        this.gui_say.setBounds(var13, var7 + 2, var8, var4);
        this.aColorCheckbox4775.setBounds(var1 + 3, this.anInt3814 - var5, var10 + 2 + var10, var5);
        this.gui_idnote.setBounds(var11, var12, var13 - var11 + var8, var4);
    }

    public String getRegisterationNeededText() {
        return this.aTextManager3809.getShared("Chat_Simple_ChatRequiresRegisteration");
    }

    public String getConfirmationNeededText() {
        return this.aTextManager3809.getShared("Chat_Simple_ChatRequiresConfirmation");
    }

    private void method2968() {
        this.aColorCheckbox4775 = new ColorCheckbox(this.aTextManager3809.getShared("Chat_Simple_NoJoinPartMessages"), this.aBoolean4776);
        this.add(this.aColorCheckbox4775);
    }

    static {
        aStringArray4778[0] = "Chat_Simple_ChatRequiresRegisteration";
        aStringArray4778[1] = "Chat_Simple_NoJoinPartMessages";
        aStringArray4778[2] = "Chat_Simple_UserLeft";
        aStringArray4778[3] = "Chat_Simple_UserJoined";
        aStringArray4778[4] = "Chat_Simple_ChatRequiresConfirmation";
    }
}
