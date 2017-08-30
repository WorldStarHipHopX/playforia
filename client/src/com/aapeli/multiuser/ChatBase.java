package com.aapeli.multiuser;

import com.aapeli.client.BadWordFilter;
import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.InputTextField;
import com.aapeli.client.InputTextFieldListener;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;
import com.aapeli.client.UrlLabel;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Vector;

public abstract class ChatBase extends IPanel implements ComponentListener, UserListHandler, ActionListener, InputTextFieldListener {

    public static final int CIDR_NONE = 0;
    public static final int CIDR_UNREG = 1;
    public static final int CIDR_UNCONF = 2;
    private static final Color aColor2342;
    private static boolean aBoolean2343;
    public Parameters param;
    public TextManager textManager;
    public ImageManager imageManager;
    private BadWordFilter badWordFilter;
    private FloodProtection floodProtection;
    public int width;
    public int height;
    private Image image;
    private int anInt2351;
    private int anInt2352;
    private int anInt2353;
    private int anInt2354;
    private String aString2355;
    private int anInt2356;
    public UserList gui_userlist;
    public ChatTextArea gui_output;
    public GlobalTextArea gui_globaloutput;
    public InputTextField gui_input;
    public Component gui_say;
    public UrlLabel gui_idnote;
    private String aString2357;
    private Vector chatListeners;
    private Object synchronizedObject;
    private static final String[] aStringArray2360 = new String[9];


    public ChatBase(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, int var7, int var8) {
        this(var1, var2, var3, var4, true, true, var5, var6, false, var7, var8);
    }

    public ChatBase(Parameters var1, TextManager var2, ImageManager var3, BadWordFilter var4, boolean var5, boolean var6, boolean var7, boolean var8, int var9, int var10) {
        this(var1, var2, var3, var4, var5, var6, var7, var8, false, var9, var10);
    }

    public ChatBase(Parameters params, TextManager textManager, ImageManager imageManager, BadWordFilter badWordFilter, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, int width, int height) {
        this.param = params;
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.badWordFilter = badWordFilter;
        this.synchronizedObject = new Object();
        this.floodProtection = new FloodProtection();
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.aString2355 = null;
        this.anInt2356 = 0;
        this.method892(var5, var6, var7, var8, var9);
        this.addComponentListener(this);
        this.chatListeners = new Vector();
    }

    public void update(Graphics g) {
        if (this.image != null) {
            g.drawImage(this.image, 0, 0, this.width, this.height, this.anInt2351, this.anInt2352, this.anInt2351 + this.width, this.anInt2352 + this.height, this);
        } else {
            this.drawBackground(g);
        }

    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
        if (this.image != null) {
            Point var2 = this.getLocation();
            int var3 = var2.x - this.anInt2353;
            int var4 = var2.y - this.anInt2354;
            this.setBackgroundImage(this.image, this.anInt2351 + var3, this.anInt2352 + var4);
        }

    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.width = var2.width;
        this.height = var2.height;
        this.resizeLayout();
    }

    public void openPlayerCard(String var1) {
        this.param.showPlayerCard(var1);
    }

    public void adminCommand(String var1, String var2) {
        ChatListener[] var3 = this.method895();

        for (int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4].localUserAdminCommand(var1, var2);
        }

    }

    public void adminCommand(String var1, String var2, String var3) {
        ChatListener[] var4 = this.method895();

        for (int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5].localUserAdminCommand(var1, var2, var3);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.gui_say) {
            this.method893();
        }

    }

    public void startedTyping() {
        this.aString2357 = this.method894();
    }

    public void clearedField() {
        this.aString2357 = null;
    }

    public void enterPressed() {
        this.method893();
    }

    public static UrlLabel setInputByCIDR(int var0, Container var1, InputTextField var2, Component var3, UrlLabel var4, TextManager var5, Parameters var6) {
        return method891(var0, var1, var2, var3, var4, var5.getShared("Chat_NoGuestChatAndRegNote"), var5.getShared("Chat_NoUnconfirmedChatNote"), var6);
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

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.image = var1;
        this.anInt2351 = var2;
        this.anInt2352 = var3;
        Point var4 = this.getLocation();
        this.anInt2353 = var4.x;
        this.anInt2354 = var4.y;
        Point var5 = this.gui_userlist.getLocation();
        this.gui_userlist.setBackgroundImage(var1, var2 + var5.x, var3 + var5.y);
        this.repaint();
    }

    public void addChatListener(ChatListener var1) {
        this.chatListeners.addElement(var1);
    }

    public void removeChatListener(ChatListener var1) {
        this.chatListeners.removeElement(var1);
    }

    public void setMessageMaximumLength(int var1) {
        this.gui_input.setTextMaximumLength(var1);
    }

    public void clearOutput() {
        Object var1 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput == null) {
                this.gui_output.clear();
            } else {
                this.gui_globaloutput.clear();
            }

        }
    }

    public void enablePopUp(boolean isModerator, boolean isAdmin) {
        this.gui_userlist.enablePopUp(isModerator, isAdmin);
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

    public int setFullUserList(String[] list) {
        return this.setFullUserList(list, -1);
    }

    public int setFullUserList(String[] list, int var2) {
        this.gui_userlist.removeAllUsers();
        int var3 = list.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            this.addToUserList(list[var4], var2 == var4);
        }

        return var3;
    }

    public String localUserJoin(String var1) {
        this.addToUserList(var1, true);
        return this.aString2355;
    }

    public void userSay(String var1, String var2) {
        if (!this.isUserIgnored(var1)) {
            this.gui_output.addSay(var1, var2);
        }

    }

    public void userSay(int var1, String var2, String var3) {
        if (!this.isUserIgnored(var2)) {
            this.gui_globaloutput.method916(var1, var2, var3);
        }

    }

    public void userSayPrivately(String var1, String var2) {
        if (!this.isUserIgnored(var1)) {
            this.gui_output.addSayPrivately(var1, this.aString2355, var2);
        }

    }

    public void sheriffSay(String var1) {
        Object var2 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addSheriffSay(var1);
            } else {
                this.gui_globaloutput.method918(var1);
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
                var4 = this.textManager.getShared(var12);
            } else {
                var12 = var1.substring(5, var5);
                int var6 = var1.indexOf(59, var5 + 1);
                if (var6 == -1) {
                    var3 = var1.substring(var5 + 1);
                    var4 = this.textManager.getShared(var12, var3);
                } else {
                    var3 = var1.substring(var5 + 1, var6);
                    String var7 = var1.substring(var6 + 1);
                    var4 = this.textManager.getShared(var12, var3, var7);
                }
            }

            if (var4.length() > 1) {
                if ((var12.equals("ServerSay_SheriffGaveWarning") || var12.equals("ServerSay_SheriffMutedUser") || var12.equals("ServerSay_SheriffUnMutedUser")) && var3 != null && !this.gui_userlist.isUser(var3)) {
                    return;
                }

                Object var13 = this.synchronizedObject;
                synchronized (this.synchronizedObject) {
                    if (this.gui_globaloutput == null) {
                        this.gui_output.addLocalizedServerSay(var4);
                    } else {
                        this.gui_globaloutput.method920(var4);
                    }
                }
            }

        } else {
            Object var2 = this.synchronizedObject;
            synchronized (this.synchronizedObject) {
                if (this.gui_globaloutput == null) {
                    this.gui_output.addServerSay(var1);
                } else {
                    this.gui_globaloutput.method919(var1);
                }

            }
        }
    }

    public void broadcastMessage(String var1) {
        Object var2 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addBroadcastMessage(var1);
            } else {
                this.gui_globaloutput.method921(var1);
            }

        }
    }

    public boolean isUserInLobby(String var1) {
        return this.isUserInChat(var1);
    }

    public boolean isUserInChat(String var1) {
        return this.gui_userlist.getUser(var1) != null;
    }

    public boolean isUserIgnored(String var1) {
        UserListItem var2 = this.gui_userlist.getUser(var1);
        return var2 == null ? true : var2.isIgnore();
    }

    public UserList getUserList() {
        return this.gui_userlist;
    }

    public boolean useRoundButtons() {
        Object var1 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_say instanceof RoundButton) {
                return false;
            } else {
                RoundButton var2 = this.copyColorButtonToRoundButton(this.gui_say);
                var2.setVisible(this.gui_say.isVisible());
                this.gui_say = var2;
                this.gui_userlist.usePixelRoundedButtonsAndCheckBoxes();
                return true;
            }
        }
    }

    public void setOutputToGlobal(int var1) {
        Object var2 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput == null) {
                Point var3 = this.gui_output.getLocation();
                this.remove(this.gui_output);
                this.gui_globaloutput = new GlobalTextArea(this, this.gui_output, var1);
                this.gui_globaloutput.setLocation(var3.x, var3.y);
                this.add(this.gui_globaloutput);
            }
        }
    }

    public void disableChatInput(int var1) {
        this.anInt2356 = var1;
        this.method896();
    }

    public boolean isTyping() {
        return this.gui_input.isTyping();
    }

    public abstract void resizeLayout();

    public String addToUserList(String var1, boolean var2) {
        return this.addToUserListNew(var1, var2).getNick();
    }

    public UserListItem addToUserListNew(String var1, boolean var2) {
        UserListItem var3 = this.gui_userlist.addUser(var1, var2);
        if (var2) {
            this.aString2355 = var3.getNick();
        }

        Object var4 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput != null) {
                this.gui_globaloutput.method915(var3.getLanguage());
            }

            return var3;
        }
    }

    public RoundButton copyColorButtonToRoundButton(Component var1) {
        ColorButton var2 = (ColorButton) ((ColorButton) var1);
        var2.removeActionListener(this);
        this.remove(var2);
        RoundButton var3 = new RoundButton(var2.getLabel());
        var3.setBounds(var2.getBounds());
        var3.setBackground(var2.getBackground());
        var3.addActionListener(this);
        this.add(var3);
        return var3;
    }

    public String getRegisterationNeededText() {
        return this.textManager.getShared("Chat_NoGuestChatAndRegNote");
    }

    public String getConfirmationNeededText() {
        return this.textManager.getShared("Chat_NoUnconfirmedChatNote");
    }

    public void setCurrentOutput(ChatTextArea var1) {
        this.gui_output = var1;
    }

    protected void method889(UserListItem var1, String var2) {
        Object var3 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addMessage(var2);
            } else {
                this.gui_globaloutput.method917(var1.getLanguage(), var2);
            }

        }
    }

    protected void method890(UserListItem var1, UserListItem var2, String var3) {
        Object var4 = this.synchronizedObject;
        synchronized (this.synchronizedObject) {
            if (this.gui_globaloutput == null) {
                this.gui_output.addMessage(var3);
            } else {
                int var5 = var1.getLanguage();
                int var6 = var2.getLanguage();
                this.gui_globaloutput.method917(var5, var3);
                if (var6 != var5) {
                    this.gui_globaloutput.method917(var6, var3);
                }
            }

        }
    }

    private static UrlLabel method891(int var0, Container var1, InputTextField var2, Component var3, UrlLabel var4, String var5, String var6, Parameters var7) {
        if (var0 == 0) {
            if (var4 != null) {
                var4.setVisible(false);
            }

            var2.setVisible(true);
            var3.setVisible(true);
            return var4;
        } else {
            if (var4 == null) {
                var4 = new UrlLabel(var7.getApplet());
                Point var8 = var2.getLocation();
                Point var9 = var3.getLocation();
                Dimension var10 = var3.getSize();
                var4.setBounds(var8.x, var8.y, var9.x + var10.width - var8.x, var9.y + var10.height - var8.y);
                var4.setBackground(var1.getBackground());
                var4.setForeground(var1.getForeground());
                var1.add(var4);
            }

            var2.setVisible(false);
            var3.setVisible(false);
            if (var0 == 1) {
                var4.setText(var5, var7.getRegisterPage());
                var4.setTarget(0);
            } else if (var0 == 2) {
                var4.setText(var6, (String) null);
            } else {
                var4.setText((String) null, (String) null);
            }

            var4.setVisible(true);
            return var4;
        }
    }

    private void method892(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5) {
        this.setLayout((LayoutManager) null);
        this.gui_output = new ChatTextArea(this.textManager, this.badWordFilter, 200, 100, var3 ? ChatTextArea.SMALL_FONT : ChatTextArea.DEFAULT_FONT);
        if (aBoolean2343 && !var5) {
            this.gui_output.addWelcomeMessage(this.textManager.getShared("Chat_Welcome"));
        }

        this.add(this.gui_output);
        if (aBoolean2343) {
            this.gui_input = new InputTextField(this.textManager.getShared("Chat_InputHelp"), 200, true);
            aBoolean2343 = false;
        } else {
            this.gui_input = new InputTextField(200, true);
        }

        this.gui_input.addInputTextFieldListener(this);
        this.add(this.gui_input);
        ColorButton var6 = new ColorButton(this.textManager.getShared("Chat_SayButton"));
        var6.setBackground(aColor2342);
        var6.addActionListener(this);
        this.add(var6);
        this.gui_say = var6;
        this.gui_userlist = new UserList(this, this.textManager, this.imageManager, !var4, var1, var2);
        this.gui_userlist.setChatReference(this);
        this.add(this.gui_userlist);
        this.gui_idnote = new UrlLabel(this.param.getApplet());
        this.add(this.gui_idnote);
        this.method896();
    }

    private void method893() {
        if (this.aString2355 != null) {
            String var1 = this.gui_input.getText().trim();
            if (var1.length() != 0) {
                if (!this.floodProtection.isOkToSay(var1)) {
                    this.gui_output.addFloodMessage();
                } else {
                    String var2 = this.method894();
                    String var3 = this.aString2357;
                    this.aString2357 = null;
                    if (var2 == null && var3 != null && !this.isUserInChat(var3)) {
                        this.gui_output.addPrivateMessageUserLeftMessage(var3);
                    } else {
                        var1 = this.gui_input.getInputText();
                        if (var1.length() > 0) {
                            ChatListener[] var4 = this.method895();
                            if (var2 != null) {
                                for (int var10 = 0; var10 < var4.length; ++var10) {
                                    var4[var10].localUserSayPrivately(var2, var1);
                                }

                                this.gui_output.addOwnSayPrivately(this.aString2355, var2, var1);
                                return;
                            }

                            Object var5 = this.synchronizedObject;
                            synchronized (this.synchronizedObject) {
                                int var6;
                                if (this.gui_globaloutput == null) {
                                    for (var6 = 0; var6 < var4.length; ++var6) {
                                        var4[var6].localUserSay(var1);
                                    }
                                } else {
                                    var6 = this.gui_globaloutput.method914();

                                    for (int var7 = 0; var7 < var4.length; ++var7) {
                                        ((GlobalChatListener) ((GlobalChatListener) var4[var7])).localUserSay(var6, var1);
                                    }
                                }
                            }

                            this.gui_output.addOwnSay(this.aString2355, var1);
                        }

                    }
                }
            }
        }
    }

    private String method894() {
        UserListItem var1 = this.gui_userlist.getSelectedUser();
        return var1 != null && var1.isPrivately() ? var1.getNick() : null;
    }

    private ChatListener[] method895() {
        int var1 = this.chatListeners.size();
        ChatListener[] var2 = new ChatListener[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (ChatListener) ((ChatListener) this.chatListeners.elementAt(var3));
        }

        return var2;
    }

    private void method896() {
        this.gui_idnote = method891(this.anInt2356, this, this.gui_input, this.gui_say, this.gui_idnote, this.getRegisterationNeededText(), this.getConfirmationNeededText(), this.param);
    }

    static {
        aStringArray2360[0] = "Chat_NoUnconfirmedChatNote";
        aStringArray2360[1] = "Chat_NoGuestChatAndRegNote";
        aStringArray2360[2] = "ServerSay_SheriffUnMutedUser";
        aStringArray2360[3] = "ServerSay_SheriffMutedUser";
        aStringArray2360[4] = "L10N:";
        aStringArray2360[5] = "ServerSay_SheriffGaveWarning";
        aStringArray2360[6] = "Chat_SayButton";
        aStringArray2360[7] = "Chat_InputHelp";
        aStringArray2360[8] = "Chat_Welcome";
        aColor2342 = new Color(144, 144, 224);
        aBoolean2343 = true;
    }
}
