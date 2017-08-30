package com.playray.multiuser;

import com.playray.client.BadWordFilter;
import com.playray.client.ImageManager;
import com.playray.client.InputTextField;
import com.playray.client.InputTextFieldListener;
import com.playray.client.Parameters;
import com.playray.client.SPanel;
import com.playray.client.TextManager;
import com.playray.client.UrlLabel;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.ChatListener;
import com.playray.multiuser.ChatTextArea;
import com.playray.multiuser.FloodProtection;
import com.playray.multiuser.GlobalChatListener;
import com.playray.multiuser.SPanel_Sub46;
import com.playray.multiuser.UserList;
import com.playray.multiuser.UserListHandler;
import com.playray.multiuser.UserListItem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Vector;

public abstract class ChatBase extends SPanel implements ComponentListener, UserListHandler, ActionListener, InputTextFieldListener {

    public static final int CIDR_NONE = 0;
    public static final int CIDR_UNREG = 1;
    public static final int CIDR_UNCONF = 2;
    public static final int CIDR_MUTE = 3;
    private static boolean aBoolean3808;
    public Parameters param;
    public TextManager aTextManager3809;
    public ImageManager anImageManager3810;
    private BadWordFilter aBadWordFilter3811;
    private FloodProtection aFloodProtection3812;
    public int anInt3813;
    public int anInt3814;
    private String aString3815;
    private int anInt3816;
    public UserList gui_userlist;
    public ChatTextArea gui_output;
    public SPanel_Sub46 gui_globaloutput;
    public InputTextField gui_input;
    public GlossyButton gui_say;
    public UrlLabel gui_idnote;
    private String aString3817;
    private Vector aVector3818;
    private Object anObject3819;
    private static final String[] aStringArray3820 = new String[10];


    public ChatBase(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, int var7, int var8) {
        this(var1, var2, var3, var4, true, true, var5, var6, false, var7, var8);
    }

    public ChatBase(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, boolean var7, boolean var8, int var9, int var10) {
        this(var1, var2, var3, var4, var5, var6, var7, var8, false, var9, var10);
    }

    public ChatBase(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, int var10, int var11) {
        super(false);
        this.param = var1;
        this.aTextManager3809 = var2;
        this.anImageManager3810 = var3;
        this.aBadWordFilter3811 = var4;
        this.anObject3819 = new Object();
        this.aFloodProtection3812 = new FloodProtection();
        this.anInt3813 = var10;
        this.anInt3814 = var11;
        this.setSize(var10, var11);
        this.aString3815 = null;
        this.anInt3816 = 0;
        this.method2952(var5, var6, var7, var8, var9);
        this.addComponentListener(this);
        this.aVector3818 = new Vector();
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt3813 = var2.width;
        this.anInt3814 = var2.height;
        this.resizeLayout();
    }

    public void openPlayerCard(String var1) {
        this.param.showPlayerCard(var1);
    }

    public void adminCommand(String var1, String var2) {
        ChatListener[] var3 = this.method2955();

        for (int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4].localUserAdminCommand(var1, var2);
        }

    }

    public void adminCommand(String var1, String var2, String var3) {
        ChatListener[] var4 = this.method2955();

        for (int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5].localUserAdminCommand(var1, var2, var3);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.gui_say) {
            this.method2953();
        }

    }

    public void startedTyping() {
        this.aString3817 = this.method2954();
    }

    public void clearedField() {
        this.aString3817 = null;
    }

    public void enterPressed() {
        this.method2953();
    }

    public static UrlLabel setInputByCIDR(int var0, Container var1, InputTextField var2, Component var3, UrlLabel var4, TextManager var5, Parameters var6) {
        return method2951(var0, var1, var2, var3, var4, var5.getShared("Chat_NoGuestChatAndRegNote"), var5.getShared("Chat_NoUnconfirmedChatNote"), var5.getShared("Chat_MuteChatRoomReminder"), var6);
    }

    public void setBackground(Color var1) {
        if (this.gui_userlist != null) {
            this.gui_userlist.setBackground(var1);
        }

        if (this.gui_idnote != null) {
            this.gui_idnote.setBackground(var1);
        }

        this.repaint();
    }

    public void setForeground(Color var1) {
        if (this.gui_userlist != null) {
            this.gui_userlist.setForeground(var1);
        }

        if (this.gui_idnote != null) {
            this.gui_idnote.setForeground(var1);
        }

    }

    public void addChatListener(ChatListener var1) {
        this.aVector3818.addElement(var1);
    }

    public void removeChatListener(ChatListener var1) {
        this.aVector3818.removeElement(var1);
    }

    public void setMessageMaximumLength(int var1) {
        this.gui_input.setTextMaximumLength(var1);
    }

    public void clearOutput() {
        Object var1 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput == null) {
                this.gui_output.clear();
            } else {
                this.gui_globaloutput.clear();
            }

        }
    }

    public void enablePopUp(boolean var1, boolean var2) {
        this.gui_userlist.enablePopUp(var1, var2);
    }

    public void addPlainMessage(String var1) {
        this.gui_output.addPlainMessage(var1);
    }

    public void addMessage(String var1) {
        this.gui_output.addMessage(var1);
    }

    public void addHighlightMessage(String var1) {
        this.gui_output.addHighlightMessage(var1);
    }

    public void addErrorMessage(String var1) {
        this.gui_output.addErrorMessage(var1);
    }

    public void addLine() {
        this.gui_output.addLine();
    }

    public int setFullUserList(String[] var1) {
        return this.setFullUserList(var1, -1);
    }

    public int setFullUserList(String[] var1, int var2) {
        this.gui_userlist.removeAllUsers();
        int var3 = var1.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            this.addToUserList(var1[var4], var2 == var4);
        }

        return var3;
    }

    public String localUserJoin(String var1) {
        this.addToUserList(var1, true);
        return this.aString3815;
    }

    public void userSay(String var1, String var2) {
        if (!this.isUserIgnored(var1)) {
            this.gui_output.addSay(var1, var2);
        }

    }

    public void userSay(int var1, String var2, String var3) {
        if (!this.isUserIgnored(var2)) {
            this.gui_globaloutput.method2972(var1, var2, var3);
        }

    }

    public void userSayPrivately(String var1, String var2) {
        if (!this.isUserIgnored(var1)) {
            this.gui_output.addSayPrivately(var1, this.aString3815, var2);
        }

    }

    public void sheriffSay(String var1) {
        Object var2 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addSheriffSay(var1);
            } else {
                this.gui_globaloutput.method2974(var1);
            }

        }
    }

    public void serverSay(String var1) {
        if (var1.startsWith("L10N:")) {
            String var3 = null;
            int var5 = var1.indexOf(59);
            String var4;
            String var12;
            if (var5 == -1) {
                var12 = var1.substring(5);
                var4 = this.aTextManager3809.getShared(var12);
            } else {
                var12 = var1.substring(5, var5);
                int var6 = var1.indexOf(59, var5 + 1);
                if (var6 == -1) {
                    var3 = var1.substring(var5 + 1);
                    var4 = this.aTextManager3809.getShared(var12, var3);
                } else {
                    var3 = var1.substring(var5 + 1, var6);
                    String var7 = var1.substring(var6 + 1);
                    var4 = this.aTextManager3809.getShared(var12, var3, var7);
                }
            }

            if (var4.length() > 1) {
                if ((var12.equals("ServerSay_SheriffGaveWarning") || var12.equals("ServerSay_SheriffMutedUser") || var12.equals("ServerSay_SheriffUnMutedUser")) && var3 != null && !this.gui_userlist.isUser(var3)) {
                    return;
                }

                Object var13 = this.anObject3819;
                synchronized (this.anObject3819) {
                    if (this.gui_globaloutput == null) {
                        this.gui_output.addLocalizedServerSay(var4);
                    } else {
                        this.gui_globaloutput.method2976(var4);
                    }
                }
            }

        } else {
            Object var2 = this.anObject3819;
            synchronized (this.anObject3819) {
                if (this.gui_globaloutput == null) {
                    this.gui_output.addServerSay(var1);
                } else {
                    this.gui_globaloutput.method2975(var1);
                }

            }
        }
    }

    public void broadcastMessage(String var1) {
        Object var2 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addBroadcastMessage(var1);
            } else {
                this.gui_globaloutput.method2977(var1);
            }

        }
    }

    public boolean isUserInChat(String var1) {
        return this.gui_userlist.getUser(var1) != null;
    }

    public boolean isUserIgnored(String var1) {
        UserListItem var2 = this.gui_userlist.getUser(var1);
        return var2 == null ? true : var2.isIgnore();
    }

    public void setOutputToGlobal(int var1) {
        Object var2 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput == null) {
                Point var3 = this.gui_output.getLocation();
                this.remove(this.gui_output);
                this.gui_globaloutput = new SPanel_Sub46(this, this.gui_output, var1);
                this.gui_globaloutput.setLocation(var3.x, var3.y);
                this.add(this.gui_globaloutput);
            }
        }
    }

    public void disableChatInput(int var1) {
        this.anInt3816 = var1;
        this.method2956();
    }

    public boolean isTyping() {
        return this.gui_input.isTyping();
    }

    public void setAlpha(int var1) {
        Object var2 = this.anObject3819;
        synchronized (this.anObject3819) {
            this.gui_userlist.setAlpha(var1);
            this.gui_output.setAlpha(var1);
            if (this.gui_globaloutput != null) {
                this.gui_globaloutput.method2971(var1);
            }

        }
    }

    public abstract void resizeLayout();

    public static int getUserListWidth(int var0) {
        int var1 = var0 / 4;
        if (var1 < 90) {
            var1 = 90;
        } else if (var1 > 160) {
            var1 = 160;
        }

        return var1;
    }

    public String addToUserList(String var1, boolean var2) {
        return this.addToUserListNew(var1, var2).getNick();
    }

    public UserListItem addToUserListNew(String var1, boolean var2) {
        UserListItem var3 = this.gui_userlist.addUser(var1, var2);
        if (var2) {
            this.aString3815 = var3.getNick();
        }

        Object var4 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput != null) {
                this.gui_globaloutput.method2970(var3.getLanguage());
            }

            return var3;
        }
    }

    public String getRegisterationNeededText() {
        return this.aTextManager3809.getShared("Chat_NoGuestChatAndRegNote");
    }

    public String getConfirmationNeededText() {
        return this.aTextManager3809.getShared("Chat_NoUnconfirmedChatNote");
    }

    public String getMuteRoomText() {
        return this.aTextManager3809.getShared("Chat_MuteChatRoomReminder");
    }

    public void setCurrentOutput(ChatTextArea var1) {
        this.gui_output = var1;
    }

    protected void method2949(UserListItem var1, String var2) {
        Object var3 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addMessage(var2);
            } else {
                this.gui_globaloutput.method2973(var1.getLanguage(), var2);
            }

        }
    }

    protected void method2950(UserListItem var1, UserListItem var2, String var3) {
        Object var4 = this.anObject3819;
        synchronized (this.anObject3819) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addMessage(var3);
            } else {
                int var5 = var1.getLanguage();
                int var6 = var2.getLanguage();
                this.gui_globaloutput.method2973(var5, var3);
                if (var6 != var5) {
                    this.gui_globaloutput.method2973(var6, var3);
                }
            }

        }
    }

    private static UrlLabel method2951(int var0, Container var1, InputTextField var2, Component var3, UrlLabel var4, String var5, String var6, String var7, Parameters var8) {
        if (var0 == 0) {
            if (var4 != null) {
                var4.setVisible(false);
            }

            var2.setVisible(true);
            var3.setVisible(true);
            return var4;
        } else {
            if (var4 == null) {
                var4 = new UrlLabel(var8.getApplet());
                Point var9 = var2.getLocation();
                Point var10 = var3.getLocation();
                Dimension var11 = var3.getSize();
                var4.setBounds(var9.x, var9.y, var10.x + var11.width - var9.x, var10.y + var11.height - var9.y);
                var4.setBackground(var1.getBackground());
                var4.setForeground(var1.getForeground());
                var1.add(var4);
            }

            var2.setVisible(false);
            var3.setVisible(false);
            if (var0 == 1) {
                var4.setText(var5, var8.getRegisterPage());
                var4.setTarget(0);
            } else if (var0 == 2) {
                var4.setText(var6, (String) null);
            } else if (var0 == 3) {
                var4.setText(var7, (String) null);
            } else {
                var4.setText((String) null, (String) null);
            }

            var4.setVisible(true);
            return var4;
        }
    }

    private void method2952(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5) {
        this.gui_output = new ChatTextArea(this.aTextManager3809, this.aBadWordFilter3811, 200, 100, var3 ? ChatTextArea.SMALL_FONT : ChatTextArea.DEFAULT_FONT);
        if (aBoolean3808 && !var5) {
            this.gui_output.addWelcomeMessage(this.aTextManager3809.getShared("Chat_Welcome"));
        }

        this.add(this.gui_output);
        if (aBoolean3808) {
            this.gui_input = new InputTextField(this.aTextManager3809.getShared("Chat_InputHelp"), 200, true);
            aBoolean3808 = false;
        } else {
            this.gui_input = new InputTextField(200, true);
        }

        this.gui_input.addInputTextFieldListener(this);
        this.add(this.gui_input);
        this.gui_say = new GlossyButton(this.aTextManager3809.getShared("Chat_SayButton"), 3);
        this.gui_say.addActionListener(this);
        this.add(this.gui_say);
        this.gui_userlist = new UserList(this, this.aTextManager3809, this.anImageManager3810, !var4, var1, var2);
        this.gui_userlist.setChatReference(this);
        this.add(this.gui_userlist);
        this.gui_idnote = new UrlLabel(this.param.getApplet());
        this.add(this.gui_idnote);
        this.method2956();
    }

    private void method2953() {
        if (this.aString3815 != null) {
            String var1 = this.gui_input.getTextField().getText().trim();
            if (var1.length() != 0) {
                if (!this.aFloodProtection3812.isOkToSay(var1)) {
                    this.gui_output.addFloodMessage();
                } else {
                    String var2 = this.method2954();
                    String var3 = this.aString3817;
                    this.aString3817 = null;
                    if (var2 == null && var3 != null && !this.isUserInChat(var3)) {
                        this.gui_output.addPrivateMessageUserLeftMessage(var3);
                    } else {
                        var1 = this.gui_input.getInputText();
                        if (var1.length() > 0) {
                            ChatListener[] var4 = this.method2955();
                            if (var2 != null) {
                                for (int var10 = 0; var10 < var4.length; ++var10) {
                                    var4[var10].localUserSayPrivately(var2, var1);
                                }

                                this.gui_output.addOwnSayPrivately(this.aString3815, var2, var1);
                                return;
                            }

                            Object var5 = this.anObject3819;
                            synchronized (this.anObject3819) {
                                int var6;
                                if (this.gui_globaloutput == null) {
                                    for (var6 = 0; var6 < var4.length; ++var6) {
                                        var4[var6].localUserSay(var1);
                                    }
                                } else {
                                    var6 = this.gui_globaloutput.method2969();

                                    for (int var7 = 0; var7 < var4.length; ++var7) {
                                        ((GlobalChatListener) ((GlobalChatListener) var4[var7])).localUserSay(var6, var1);
                                    }
                                }
                            }

                            this.gui_output.addOwnSay(this.aString3815, var1);
                        }

                    }
                }
            }
        }
    }

    private String method2954() {
        UserListItem var1 = this.gui_userlist.getSelectedUser();
        return var1 != null && var1.isPrivately() ? var1.getNick() : null;
    }

    private ChatListener[] method2955() {
        int var1 = this.aVector3818.size();
        ChatListener[] var2 = new ChatListener[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (ChatListener) ((ChatListener) this.aVector3818.elementAt(var3));
        }

        return var2;
    }

    private void method2956() {
        this.gui_idnote = method2951(this.anInt3816, this, this.gui_input, this.gui_say, this.gui_idnote, this.getRegisterationNeededText(), this.getConfirmationNeededText(), this.getMuteRoomText(), this.param);
    }

    static {
        aStringArray3820[0] = "Chat_MuteChatRoomReminder";
        aStringArray3820[1] = "Chat_NoGuestChatAndRegNote";
        aStringArray3820[2] = "Chat_NoUnconfirmedChatNote";
        aStringArray3820[3] = "Chat_SayButton";
        aStringArray3820[4] = "Chat_InputHelp";
        aStringArray3820[5] = "Chat_Welcome";
        aStringArray3820[6] = "ServerSay_SheriffUnMutedUser";
        aStringArray3820[7] = "ServerSay_SheriffMutedUser";
        aStringArray3820[8] = "ServerSay_SheriffGaveWarning";
        aStringArray3820[9] = "L10N:";
        aBoolean3808 = true;
    }
}
