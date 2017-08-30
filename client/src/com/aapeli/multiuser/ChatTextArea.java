package com.aapeli.multiuser;

import com.aapeli.client.BadWordFilter;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorTextArea;

import java.awt.Font;
import java.util.Hashtable;

public class ChatTextArea extends ColorTextArea {

    public static final Font DEFAULT_FONT;
    public static final Font SMALL_FONT;
    private TextManager aTextManager4728;
    private BadWordFilter aBadWordFilter4729;
    private Hashtable aHashtable4730;
    private static final String[] aStringArray4731 = new String[11];


    public ChatTextArea(TextManager var1, int var2, int var3) {
        this(var1, (BadWordFilter) null, var2, var3, (Font) null);
    }

    public ChatTextArea(TextManager var1, int var2, int var3, Font var4) {
        this(var1, (BadWordFilter) null, var2, var3, var4);
    }

    public ChatTextArea(TextManager var1, BadWordFilter var2, int var3, int var4) {
        this(var1, var2, var3, var4, (Font) null);
    }

    public ChatTextArea(TextManager var1, BadWordFilter var2, int var3, int var4, Font var5) {
        super(var3, var4, var5 != null ? var5 : DEFAULT_FONT);
        this.aTextManager4728 = var1;
        this.aBadWordFilter4729 = var2;
        this.aHashtable4730 = new Hashtable();
    }

    public void addOwnSay(String var1, String var2) {
        this.method856(3, var1, var2, true);
    }

    public void addOwnSayPrivately(String var1, String var2, String var3) {
        this.method857(3, var1, var2, var3, true);
    }

    public void addSay(String var1, String var2) {
        this.method856(0, var1, var2, false);
    }

    public void addSayPrivately(String var1, String var2, String var3) {
        this.method857(5, var1, var2, var3, false);
    }

    public void addJoinMessage(String var1) {
        this.addMessage(2, var1);
    }

    public void addPartMessage(String var1) {
        this.addMessage(1, var1);
    }

    public void addStartedGameMessage(String var1) {
        this.addMessage(7, var1);
    }

    public void addSheriffSay(String var1) {
        this.addBoldLine(6, this.aTextManager4728.getShared("Chat_SheriffSay", var1));
    }

    public void addServerSay(String var1) {
        this.addLine(6, this.aTextManager4728.getShared("Chat_ServerSay", var1));
    }

    public void addLocalizedServerSay(String var1) {
        this.addLine(6, var1);
    }

    public void addBroadcastMessage(String var1) {
        this.addBoldLine(6, this.aTextManager4728.getShared("Chat_ServerBroadcast", var1));
    }

    public void addWelcomeMessage(String var1) {
        if (var1 != null) {
            this.addLine(6, var1);
        }
    }

    public void addPlainMessage(String var1) {
        this.addLine(7, var1);
    }

    public void addMessage(String var1) {
        this.addMessage(7, var1);
    }

    public void addHighlightMessage(String var1) {
        this.addMessage(6, var1);
    }

    public void addErrorMessage(String var1) {
        this.addMessage(1, var1);
    }

    public void addFloodMessage() {
        this.addMessage(7, this.aTextManager4728.getShared("Chat_MessageFlood"));
    }

    public void addPrivateMessageUserLeftMessage(String var1) {
        this.addMessage(6, this.aTextManager4728.getShared("Chat_MessagePrivateMessageUserLeft", var1));
    }

    public void setUserColor(String var1, int var2) {
        this.aHashtable4730.put(var1, new Integer(var2));
    }

    public void removeUserColor(String var1) {
        this.aHashtable4730.remove(var1);
    }

    public TextManager getTextManager() {
        return this.aTextManager4728;
    }

    public BadWordFilter getBadWordFilter() {
        return this.aBadWordFilter4729;
    }

    private void addMessage(int var1, String var2) {
        this.addLine(this.method858(var1), this.aTextManager4728.getShared("Chat_Message", var2));
    }

    private void method856(int var1, String var2, String var3, boolean var4) {
        var3 = this.method860(var3, var4);
        if (var3.length() > 4 && var3.toLowerCase().startsWith("/me ")) {
            this.addLine(this.method859(var2, var1), this.aTextManager4728.getShared("Chat_UserAction", var2, var3.substring(4)), var4);
        } else {
            this.addLine(this.method859(var2, var1), this.aTextManager4728.getShared("Chat_UserSay", var2, var3), var4);
        }
    }

    private void method857(int var1, String var2, String var3, String var4, boolean var5) {
        var4 = this.method860(var4, var5);
        this.addLine(this.method859(var2, var1), this.aTextManager4728.getShared("Chat_UserSayPrivate", var2, var3, var4), var5);
    }

    private int method858(int var1) {
        return this.aHashtable4730.size() == 0 ? var1 : 7;
    }

    private int method859(String var1, int var2) {
        Integer var3 = (Integer) ((Integer) this.aHashtable4730.get(var1));
        return var3 == null ? var2 : var3.intValue();
    }

    private String method860(String var1, boolean var2) {
        var1 = this.method861(var1);
        var1 = this.method862(var1, var2);
        return var1;
    }

    private String method861(String var1) {
        char[] var2 = var1.toCharArray();
        boolean var3 = false;
        int var4 = var2.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            if (var2[var5] < 32 || var2[var5] == 127 || var2[var5] >= 128 && var2[var5] <= 159 || var2[var5] == 8232 || var2[var5] == 8233 || var2[var5] == '\ufff9' || var2[var5] == '\ufffa' || var2[var5] == '\ufffb' || var2[var5] == 8206 || var2[var5] == 8207 || var2[var5] == 8234 || var2[var5] == 8238 || var2[var5] == '\uf0da') {
                var2[var5] = 32;
                var3 = true;
            }

            if (var2[var5] == '\uf0da') {
                var2[var5] = 32;
                var3 = true;
            }

            if (var2[var5] == 304) {
                var2[var5] = 73;
                var3 = true;
            }
        }

        if (var3) {
            var1 = new String(var2);
        }

        return var1;
    }

    private String method862(String var1, boolean var2) {
        if (this.aBadWordFilter4729 != null && !var2) {
            var1 = this.aBadWordFilter4729.filter(var1);
        }

        return var1;
    }

    static {
        aStringArray4731[0] = "Chat_MessageFlood";
        aStringArray4731[1] = "Chat_UserAction";
        aStringArray4731[2] = "/me ";
        aStringArray4731[3] = "Chat_UserSay";
        aStringArray4731[4] = "Chat_MessagePrivateMessageUserLeft";
        aStringArray4731[5] = "Chat_SheriffSay";
        aStringArray4731[6] = "Chat_ServerBroadcast";
        aStringArray4731[7] = "Chat_ServerSay";
        aStringArray4731[8] = "Chat_UserSayPrivate";
        aStringArray4731[9] = "Chat_Message";
        aStringArray4731[10] = "Dialog";
        DEFAULT_FONT = new Font("Dialog", 0, 12);
        SMALL_FONT = new Font("Dialog", 0, 11);
    }
}
