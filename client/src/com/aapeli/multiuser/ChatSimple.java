package com.aapeli.multiuser;

import com.aapeli.client.BadWordFilter;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorCheckbox;

import java.awt.Color;

public class ChatSimple extends ChatBase {

    private ColorCheckbox aColorCheckbox3668;
    private boolean aBoolean3669;
    private boolean aBoolean3670;
    private static final String[] aStringArray3671 = new String[5];


    public ChatSimple(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, int var5, int var6) {
        this(var1, var2, var3, var4, false, var5, var6);
    }

    public ChatSimple(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, int var6, int var7) {
        super(var1, var2, var3, var4, true, true, false, true, true, var6, var7);
        this.aBoolean3669 = var5;
        this.method913();
        this.resizeLayout();
        this.aBoolean3670 = true;
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        this.aColorCheckbox3668.setBackground(var1);
    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        this.aColorCheckbox3668.setForeground(var1);
    }

    public int setFullUserList(String[] list) {
        int var2 = super.setFullUserList(list);
        if (this.aBoolean3670) {
            if (var2 >= 30) {
                this.aColorCheckbox3668.setState(true);
            }

            this.aBoolean3670 = false;
        }

        return var2;
    }

    public String userJoin(String var1) {
        UserListItem var2 = this.addToUserListNew(var1, false);
        if (!this.aColorCheckbox3668.getState()) {
            this.method889(var2, super.textManager.getShared("Chat_Simple_UserJoined", var2.getNick()));
        }

        return var2.getNick();
    }

    public void userLeft(String var1) {
        UserListItem var2 = super.gui_userlist.removeUserNew(var1);
        if (var2 != null && !this.aColorCheckbox3668.getState()) {
            this.method889(var2, super.textManager.getShared("Chat_Simple_UserLeft", var1));
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
        int var5 = this.aBoolean3669 ? 0 : 18;
        if (var4 < 20) {
            var4 = 20;
        }

        if (var4 > 25) {
            var4 = 25;
        }

        int var6 = super.width - 3 - var1;
        int var7 = super.height - var5 - 3 - var4 - 2;
        int var8 = (int) (50.0D + ((double) var6 - 200.0D) / 300.0D * 70.0D);
        if (var8 < 50) {
            var8 = 50;
        }

        if (var8 > 100) {
            var8 = 100;
        }

        int var9 = var6 - 1 - var8;
        int var10 = (var6 - 2) / 2;
        super.gui_userlist.setBounds(0, 0, var1, super.height);
        synchronized (this) {
            if (super.gui_globaloutput == null) {
                super.gui_output.setBounds(var1 + 3, 0, var6, var7);
            } else {
                super.gui_globaloutput.setBounds(var1 + 3, 0, var6, var7);
            }
        }

        int var11 = var1 + 3;
        int var12 = var7 + 2;
        super.gui_input.setBounds(var11, var12, var9, var4);
        int var13 = var1 + 3 + var9 + 1;
        super.gui_say.setBounds(var13, var7 + 2, var8, var4);
        this.aColorCheckbox3668.setBounds(var1 + 3, super.height - var5, var10 + 2 + var10, var5);
        super.gui_idnote.setBounds(var11, var12, var13 - var11 + var8, var4);
    }

    public String getRegisterationNeededText() {
        return super.textManager.getShared("Chat_Simple_ChatRequiresRegisteration");
    }

    public String getConfirmationNeededText() {
        return super.textManager.getShared("Chat_Simple_ChatRequiresConfirmation");
    }

    private void method913() {
        this.aColorCheckbox3668 = new ColorCheckbox(super.textManager.getShared("Chat_Simple_NoJoinPartMessages"), this.aBoolean3669);
        this.add(this.aColorCheckbox3668);
    }

    static {
        aStringArray3671[0] = "Chat_Simple_UserJoined";
        aStringArray3671[1] = "Chat_Simple_ChatRequiresRegisteration";
        aStringArray3671[2] = "Chat_Simple_UserLeft";
        aStringArray3671[3] = "Chat_Simple_ChatRequiresConfirmation";
        aStringArray3671[4] = "Chat_Simple_NoJoinPartMessages";
    }
}
