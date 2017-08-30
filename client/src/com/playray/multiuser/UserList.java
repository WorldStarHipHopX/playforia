package com.playray.multiuser;

import com.playray.client.ImageManager;
import com.playray.client.SPanel;
import com.playray.client.TextManager;
import com.playray.colorgui.ColorCheckbox;
import com.playray.colorgui.ColorList;
import com.playray.colorgui.ColorListItem;
import com.playray.colorgui.ColorListItemGroup;
import com.playray.colorgui.ColorTextArea;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.JFrame_Sub5;
import com.playray.multiuser.JFrame_Sub6;
import com.playray.multiuser.Languages;
import com.playray.multiuser.SPanel_Sub48;
import com.playray.multiuser.UserListHandler;
import com.playray.multiuser.UserListItem;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class UserList extends SPanel implements ComponentListener, ItemListener, ActionListener {

    public static final int SORT_NICKNAME_ABC = 1;
    public static final int SORT_NICKNAME_CBA = 2;
    public static final int SORT_RANKING_123 = 3;
    public static final int SORT_RANKING_321 = 4;
    private static final Color aColor4625;
    private static final Color aColor4626;
    private UserListHandler anUserListHandler4627;
    private TextManager aTextManager4628;
    private ImageManager anImageManager4629;
    private int anInt4630;
    private int anInt4631;
    private Image[] anImageArray4632;
    private boolean aBoolean4633;
    private ColorList aColorList4634;
    private ColorCheckbox aColorCheckbox4635;
    private ColorCheckbox aColorCheckbox4636;
    private SPanel_Sub48 aSPanel_Sub48_4637;
    private SPanel_Sub48 aSPanel_Sub48_4638;
    private boolean aBoolean4639;
    private int anInt4640;
    private int anInt4641;
    private JPopupMenu aJPopupMenu4642;
    private JMenuItem aJMenuItem4643;
    private JMenuItem aJMenuItem4644;
    private JMenuItem aJMenuItem4645;
    private JMenuItem aJMenuItem4646;
    private JMenuItem aJMenuItem4647;
    private JMenuItem aJMenuItem4648;
    private JMenuItem aJMenuItem4649;
    private JMenuItem aJMenuItem4650;
    private JMenuItem aJMenuItem4651;
    private JMenuItem aJMenuItem4652;
    private JMenuItem aJMenuItem4653;
    private JMenuItem aJMenuItem4654;
    private JMenuItem aJMenuItem4655;
    private JMenuItem aJMenuItem4656;
    private JMenuItem aJMenuItem4657;
    private UserListItem anUserListItem4658;
    private JFrame_Sub6 aJFrame_Sub6_4659;
    private Vector aVector4660;
    private Vector aVector4661;
    private boolean aBoolean4662;
    private boolean aBoolean4663;
    private ColorTextArea aColorTextArea4664;
    private ChatBase aChatBase4665;
    private Languages aLanguages4666;
    private Hashtable aHashtable4667;
    private static final String[] aStringArray4668 = new String[28];


    public UserList(UserListHandler var1, TextManager var2, ImageManager var3, boolean var4, boolean var5, boolean var6) {
        this(var1, var2, var3, var4, var5, var6, 100, 200);
    }

    public UserList(UserListHandler var1, TextManager var2, ImageManager var3, boolean var4, boolean var5, boolean var6, int var7, int var8) {
        super(false);
        this.anUserListHandler4627 = var1;
        this.aTextManager4628 = var2;
        this.anImageManager4629 = var3;
        this.anInt4630 = var7;
        this.anInt4631 = var8;
        this.setSize(var7, var8);
        this.aBoolean4633 = var4;
        this.method2992(var5, var6);
        this.setBackground(aColor4625);
        this.setForeground(aColor4626);
        if (var4) {
            Image var9 = var3.getShared("ranking-icons.gif");
            this.anImageArray4632 = var3.separateImages(var9, 14);
        }

        this.aBoolean4639 = false;
        this.anInt4640 = this.anInt4641 = 0;
        this.aVector4660 = new Vector();
        this.aVector4661 = new Vector();
        this.aBoolean4662 = this.aBoolean4663 = true;
        this.aLanguages4666 = new Languages(var2, var3);
        this.aHashtable4667 = new Hashtable();
        this.addComponentListener(this);
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt4630 = var2.width;
        this.anInt4631 = var2.height;
        boolean var3 = this.aColorCheckbox4635 != null;
        boolean var4 = this.aColorCheckbox4636 != null;
        if (this.aBoolean4633) {
            this.aSPanel_Sub48_4637.setSize(17, 15);
            this.aSPanel_Sub48_4638.setSize(this.anInt4630 - 17, 15);
        }

        int var5 = this.anInt4630;
        int var6 = this.anInt4631 - (var4 ? 18 : 0) - (var3 ? 18 : 0) - (!var4 && !var3 ? 0 : 2) - (this.aBoolean4633 ? 15 : 0);
        this.aColorList4634.setBounds(0, this.aBoolean4633 ? 15 : 0, var5, var6);
        if (var3) {
            this.aColorCheckbox4635.setBounds(0, this.anInt4631 - 18 - (var4 ? 18 : 0), this.anInt4630, 18);
        }

        if (var4) {
            this.aColorCheckbox4636.setBounds(0, this.anInt4631 - 18, this.anInt4630, 18);
        }

        this.componentMoved(var1);
    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aJMenuItem4644) {
            this.aColorCheckbox4635.click();
        } else if (var2 == this.aJMenuItem4645) {
            this.aColorCheckbox4636.click();
        } else {
            ColorListItem var3 = this.aColorList4634.getSelectedItem();
            boolean var4 = false;
            if (var3 == null) {
                this.method2993();
                var4 = true;
                Object var5 = var1.getItem();
                if (!(var5 instanceof ColorListItem)) {
                    return;
                }

                var3 = (ColorListItem) ((ColorListItem) var1.getItem());
            }

            UserListItem var8 = (UserListItem) ((UserListItem) var3.getData());
            if (var2 == this.aColorList4634) {
                int var6 = var1.getID();
                if (var6 == 2) {
                    if (this.method2996(var8)) {
                        return;
                    }

                    this.anUserListHandler4627.openPlayerCard(var8.getNick());
                } else if (var6 == 1 && this.aBoolean4639) {
                    int[] var7 = this.aColorList4634.getLastClickedMouseXY();
                    this.method2986(var8, var7[0], var7[1]);
                }
            }

            if (!var4) {
                if (var2 == this.aColorList4634) {
                    if (this.aColorCheckbox4635 != null) {
                        this.aColorCheckbox4635.setState(var8.isPrivately());
                    }

                    if (this.aColorCheckbox4636 != null) {
                        this.aColorCheckbox4636.setState(var8.isIgnore());
                    }

                } else {
                    if (var2 == this.aColorCheckbox4635 || var2 == this.aColorCheckbox4636) {
                        if (var8.isLocal()) {
                            this.method2993();
                        } else {
                            var8.method2211(this.aColorCheckbox4635 != null ? this.aColorCheckbox4635.getState() : false);
                            var8.method2212(this.aColorCheckbox4636 != null ? this.aColorCheckbox4636.getState() : false);
                            var3.setColor(this.method2991(var8));
                            this.aColorList4634.repaint();
                        }
                    }

                }
            }
        }
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aJMenuItem4643) {
            if (!this.method2996(this.anUserListItem4658)) {
                this.anUserListHandler4627.openPlayerCard(this.anUserListItem4658.getNick());
            }
        } else if (var2 == this.aJMenuItem4646) {
            this.method2990(1, this.anUserListItem4658.getNick());
        } else if (var2 == this.aJMenuItem4647) {
            this.method2990(2, this.anUserListItem4658.getNick());
        } else if (var2 != this.aJMenuItem4648 && var2 != this.aJMenuItem4649 && var2 != this.aJMenuItem4650 && var2 != this.aJMenuItem4651 && var2 != this.aJMenuItem4652) {
            if (var2 == this.aJMenuItem4653) {
                this.method2990(4, (String) null);
            } else if (var2 == this.aJMenuItem4654) {
                JFrame_Sub5 var4 = new JFrame_Sub5();
                var4.method2352(this.anImageManager4629.getApplet(), (ColorTextArea) (this.aChatBase4665 != null ? this.aChatBase4665.gui_output : this.aColorTextArea4664));
            } else if (var2 == this.aJMenuItem4655) {
                this.anUserListHandler4627.adminCommand("info", this.anUserListItem4658.getNick());
            } else if (var2 == this.aJMenuItem4656) {
                this.anUserListHandler4627.adminCommand("unmute", this.anUserListItem4658.getNick());
            } else if (var2 == this.aJMenuItem4657) {
                this.method2990(5, (String) null);
            }
        } else {
            short var3 = 0;
            if (var2 == this.aJMenuItem4648) {
                var3 = 5;
            } else if (var2 == this.aJMenuItem4649) {
                var3 = 15;
            } else if (var2 == this.aJMenuItem4650) {
                var3 = 60;
            } else if (var2 == this.aJMenuItem4651) {
                var3 = 360;
            } else if (var2 == this.aJMenuItem4652) {
                var3 = 1440;
            }

            this.anUserListHandler4627.adminCommand("mute", this.anUserListItem4658.getNick(), "" + var3);
        }

    }

    public static String getNickFromUserInfo(String var0) {
        if (!method2985(var0)) {
            return method2997(var0);
        } else {
            int var1 = var0.indexOf(58);
            int var2 = var0.indexOf(94);
            return Tools.changeFromSaveable(var0.substring(var1 + 1, var2));
        }
    }

    public void disableSheriffMark() {
        this.aBoolean4662 = false;
    }

    public void disableDimmerNicks() {
        this.aBoolean4663 = false;
    }

    public void enablePopUp() {
        this.enablePopUp(false, false);
    }

    public void enablePopUp(boolean var1, boolean var2) {
        this.anInt4640 = var1 ? 2 : 0;
        this.anInt4641 = var2 ? 1 : 0;
        this.aBoolean4639 = true;
    }

    public void enablePopUpWithOnlyOldCommands(boolean var1, boolean var2) {
        this.anInt4640 = var1 ? 1 : 0;
        this.anInt4641 = var2 ? 1 : 0;
        this.aBoolean4639 = true;
    }

    public void setCheckBoxesVisible(boolean var1) {
        if (this.aColorCheckbox4635 != null) {
            this.aColorCheckbox4635.setVisible(var1);
        }

        if (this.aColorCheckbox4636 != null) {
            this.aColorCheckbox4636.setVisible(var1);
        }

    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aColorCheckbox4635 != null) {
            this.aColorCheckbox4635.setBackground(var1);
        }

        if (this.aColorCheckbox4636 != null) {
            this.aColorCheckbox4636.setBackground(var1);
        }

        this.repaint();
    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aColorCheckbox4635 != null) {
            this.aColorCheckbox4635.setForeground(var1);
        }

        if (this.aColorCheckbox4636 != null) {
            this.aColorCheckbox4636.setForeground(var1);
        }

    }

    public UserListItem addUser(String var1, boolean var2) {
        return this.addUser(var1, var2, -1);
    }

    public UserListItem addUser(String var1, boolean var2, int var3) {
        if (!method2985(var1)) {
            return this.method2998(var1, var2, var3);
        } else {
            int var4 = var1.indexOf(58);
            var1 = var1.substring(var4 + 1);
            StringTokenizer var5 = new StringTokenizer(var1, "^");
            String var6 = Tools.changeFromSaveable(var5.nextToken());
            String var7 = var5.nextToken();
            int var8 = Integer.parseInt(var5.nextToken());
            String var9 = var5.nextToken();
            String var10 = Tools.changeFromSaveable(var5.nextToken());
            String var11 = Tools.changeFromSaveable(var5.nextToken());
            boolean var12 = var7.indexOf(114) >= 0;
            boolean var13 = var7.indexOf(118) >= 0;
            boolean var14 = var7.indexOf(115) >= 0;
            boolean var15 = var7.indexOf(110) >= 0;
            UserListItem var16 = new UserListItem(var6, var2, var12, var13, var14, var8);
            var16.method2208(var15);
            int var17 = Languages.getLanguageIdByString(var9);
            var16.method2209(var17);
            var16.method2210(this.aLanguages4666.getFlag(var17));
            if (var3 >= 0) {
                var16.setOverrideColor(var3);
            }

            this.addUser(var16);
            if (!var10.equals("-")) {
                var16.method2217(var10);
            }

            if (!var11.equals("-")) {
                var16.method2216(var11, this.anImageManager4629, this.aColorList4634);
            }

            return var16;
        }
    }

    public void addUser(UserListItem var1) {
        String var2 = var1.getNick();
        if (this.aVector4660.contains(var2)) {
            var1.method2211(true);
        }

        if (this.aVector4661.contains(var2)) {
            var1.method2212(true);
        }

        String var3 = var1.getNick();
        if (var1.isSheriff() && this.aBoolean4662) {
            var3 = var3 + " " + this.aTextManager4628.getShared("UserList_Sheriff");
        }

        ColorListItem var4 = new ColorListItem(this.method2994(var1), this.method2991(var1), var1.isRegistered(), var3, var1, false);
        var4.setValue(var1.getRanking());
        if (var1.isSheriff()) {
            var4.setSortOverride(true);
        }

        int var5 = var1.getLanguage();
        Integer var6 = new Integer(var5);
        ColorListItemGroup var7 = (ColorListItemGroup) ((ColorListItemGroup) this.aHashtable4667.get(var6));
        if (var7 == null) {
            int var8 = var5;
            if (var5 == 0) {
                var8 = var5 + 50;
            }

            String var9 = this.aLanguages4666.getName(var5);
            var7 = new ColorListItemGroup(var9, this.aLanguages4666.getFlag(var5), var8);
            this.aHashtable4667.put(var6, var7);
        }

        if (var1.isLocal()) {
            var7.changeSortValue(-100);
            this.aColorList4634.reSort();
        }

        var4.setGroup(var7);
        this.aColorList4634.addItem(var4);
        var1.method2214(var4);
    }

    public UserListItem getSelectedUser() {
        ColorListItem var1 = this.aColorList4634.getSelectedItem();
        return var1 == null ? null : (UserListItem) ((UserListItem) var1.getData());
    }

    public UserListItem getUser(String var1) {
        ColorListItem[] var2 = this.aColorList4634.getAllItems();
        if (var2 != null) {
            int var3 = var2.length;
            if (var3 > 0) {
                for (int var5 = 0; var5 < var3; ++var5) {
                    UserListItem var4 = (UserListItem) ((UserListItem) var2[var5].getData());
                    if (var4.getNick().equals(var1)) {
                        return var4;
                    }
                }
            }
        }

        return null;
    }

    public boolean isUser(String var1) {
        return this.getUser(var1) != null;
    }

    public UserListItem getLocalUser() {
        ColorListItem[] var1 = this.aColorList4634.getAllItems();
        if (var1 != null) {
            int var2 = var1.length;
            if (var2 > 0) {
                for (int var4 = 0; var4 < var2; ++var4) {
                    UserListItem var3 = (UserListItem) ((UserListItem) var1[var4].getData());
                    if (var3.isLocal()) {
                        return var3;
                    }
                }
            }
        }

        return null;
    }

    public void removeUser(String var1) {
        ColorListItem[] var2 = this.aColorList4634.getAllItems();
        if (var2 != null) {
            int var3 = var2.length;
            if (var3 > 0) {
                for (int var5 = 0; var5 < var3; ++var5) {
                    UserListItem var4 = (UserListItem) ((UserListItem) var2[var5].getData());
                    if (var4.getNick().equals(var1)) {
                        this.aColorList4634.removeItem(var2[var5]);
                        if (var2[var5].isSelected()) {
                            this.method2993();
                        }

                        this.method2995(var4);
                        return;
                    }
                }
            }
        }

    }

    public UserListItem removeUserNew(String var1) {
        ColorListItem[] var2 = this.aColorList4634.getAllItems();
        if (var2 != null) {
            int var3 = var2.length;
            if (var3 > 0) {
                for (int var5 = 0; var5 < var3; ++var5) {
                    UserListItem var4 = (UserListItem) ((UserListItem) var2[var5].getData());
                    if (var4.getNick().equals(var1)) {
                        this.aColorList4634.removeItem(var2[var5]);
                        if (var2[var5].isSelected()) {
                            this.method2993();
                        }

                        this.method2995(var4);
                        return var4;
                    }
                }
            }
        }

        return null;
    }

    public void removeAllUsers() {
        ColorListItem[] var1 = this.aColorList4634.getAllItems();
        if (var1 != null) {
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                this.method2995((UserListItem) ((UserListItem) var1[var3].getData()));
            }
        }

        this.aColorList4634.removeAllItems();
        this.method2993();
    }

    public void setNotAcceptingChallenges(UserListItem var1, boolean var2) {
        var1.method2208(var2);
        ColorListItem var3 = var1.method2215();
        var3.setColor(this.method2991(var1));
        this.aColorList4634.repaint();
    }

    public void setSorting(int var1) {
        this.aColorList4634.setSorting(var1);
        if (this.aBoolean4633) {
            if (var1 != 3 && var1 != 4) {
                this.aSPanel_Sub48_4637.method2983(false);
                this.aSPanel_Sub48_4638.method2983(true);
            } else {
                this.aSPanel_Sub48_4637.method2983(true);
                this.aSPanel_Sub48_4638.method2983(false);
            }
        }

    }

    public int getSorting() {
        return this.aColorList4634.getSorting();
    }

    public int getUserCount() {
        return this.aColorList4634.getItemCount();
    }

    public void setAlpha(int var1) {
        this.aColorList4634.setAlpha(var1);
        if (this.aBoolean4633) {
            this.aSPanel_Sub48_4637.method2984(var1);
            this.aSPanel_Sub48_4638.method2984(var1);
        }

    }

    public void setNickListTitle(String var1) {
        this.aColorList4634.setTitle(var1);
    }

    public void setChatOutputReference(ColorTextArea var1) {
        this.aColorTextArea4664 = var1;
    }

    public void setChatReference(ChatBase var1) {
        this.aChatBase4665 = var1;
    }

    public void ulbClicked(SPanel_Sub48 var1) {
        if (var1 == this.aSPanel_Sub48_4637) {
            if (this.getSorting() == 4) {
                this.setSorting(3);
            } else {
                this.setSorting(4);
            }
        } else if (var1 == this.aSPanel_Sub48_4638) {
            if (this.getSorting() == 1) {
                this.setSorting(2);
            } else {
                this.setSorting(1);
            }
        }

    }

    private static boolean method2985(String var0) {
        return var0.startsWith("3:");
    }

    private void method2986(UserListItem var1, int var2, int var3) {
        this.anUserListItem4658 = var1;
        if (this.aJPopupMenu4642 != null) {
            this.remove(this.aJPopupMenu4642);
        }

        this.aJPopupMenu4642 = new JPopupMenu();
        this.aJMenuItem4643 = this.method2988(this.aJPopupMenu4642, this.aTextManager4628.getShared("UserList_OpenPlayerCard"));
        this.aJMenuItem4643.setEnabled(var1.isRegistered() || var1.method2218() != null);
        if (this.aColorCheckbox4635 != null || this.aColorCheckbox4636 != null) {
            this.aJPopupMenu4642.addSeparator();
        }

        if (this.aColorCheckbox4635 != null) {
            this.aJMenuItem4644 = this.method2989(this.aJPopupMenu4642, this.aColorCheckbox4635.getLabel(), var1.isPrivately());
            this.aJMenuItem4644.setEnabled(!var1.isLocal());
        }

        if (this.aColorCheckbox4636 != null) {
            this.aJMenuItem4645 = this.method2989(this.aJPopupMenu4642, this.aColorCheckbox4636.getLabel(), var1.isIgnore());
            this.aJMenuItem4645.setEnabled(!var1.isLocal());
        }

        JMenu var4;
        if (this.anInt4640 > 0) {
            this.aJPopupMenu4642.addSeparator();
            var4 = new JMenu("Sheriff");
            this.aJMenuItem4647 = this.method2987(var4, "Send message...");
            if (this.anInt4640 > 1) {
                JMenu var5 = new JMenu("Mute user");
                this.aJMenuItem4648 = this.method2987(var5, "5 minutes");
                this.aJMenuItem4649 = this.method2987(var5, "15 minutes");
                this.aJMenuItem4650 = this.method2987(var5, "1 hour");
                this.aJMenuItem4651 = this.method2987(var5, "6 hours");
                if (this.anInt4641 > 0) {
                    this.aJMenuItem4652 = this.method2987(var5, "1 day (admin)");
                }

                var4.add(var5);
                if (this.aChatBase4665 != null || this.aColorTextArea4664 != null) {
                    this.aJMenuItem4654 = this.method2987(var4, "Copy chat");
                }
            }

            this.aJPopupMenu4642.add(var4);
        }

        if (this.anInt4641 > 0) {
            var4 = new JMenu("Admin");
            this.aJMenuItem4655 = this.method2987(var4, "Get user info");
            this.aJMenuItem4656 = this.method2987(var4, "Unmute user");
            this.aJMenuItem4646 = this.method2987(var4, "Remove user...");
            this.aJMenuItem4657 = this.method2987(var4, "Broadcast message...");
            this.aJPopupMenu4642.add(var4);
        }

        this.add(this.aJPopupMenu4642);
        this.aJPopupMenu4642.show(this.aColorList4634, var2, var3);
    }

    private JMenuItem method2987(JMenu var1, String var2) {
        JMenuItem var3 = new JMenuItem(var2);
        var3.addActionListener(this);
        var1.add(var3);
        return var3;
    }

    private JMenuItem method2988(JPopupMenu var1, String var2) {
        JMenuItem var3 = new JMenuItem(var2);
        var3.addActionListener(this);
        var1.add(var3);
        return var3;
    }

    private JMenuItem method2989(JPopupMenu var1, String var2, boolean var3) {
        JCheckBoxMenuItem var4 = new JCheckBoxMenuItem(var2, var3);
        var4.addItemListener(this);
        var1.add(var4);
        return var4;
    }

    private void method2990(int var1, String var2) {
        if (this.aJFrame_Sub6_4659 != null) {
            this.aJFrame_Sub6_4659.windowClosing((WindowEvent) null);
        }

        this.aJFrame_Sub6_4659 = new JFrame_Sub6(this.aTextManager4628, this.anUserListHandler4627, var1, var2);
        this.aJFrame_Sub6_4659.method2355(this.anImageManager4629.getApplet(), this.anInt4641 > 0);
    }

    private Color method2991(UserListItem var1) {
        int var2 = var1.method2213(this.aBoolean4662);
        Color var3 = ColorListItem.getColorById(var2);
        if (this.aBoolean4663 && var1.isNotAcceptingChallenges()) {
            var3 = new Color((var3.getRed() + 896) / 5, (var3.getGreen() + 896) / 5, (var3.getBlue() + 896) / 5);
        }

        return var3;
    }

    private void method2992(boolean var1, boolean var2) {
        if (this.aBoolean4633) {
            this.aSPanel_Sub48_4637 = new SPanel_Sub48(this, this.aTextManager4628.getShared("UserList_SortByRanking"));
            this.aSPanel_Sub48_4637.setBounds(0, 0, 17, 15);
            this.aSPanel_Sub48_4637.method2983(false);
            this.add(this.aSPanel_Sub48_4637);
            this.aSPanel_Sub48_4638 = new SPanel_Sub48(this, this.aTextManager4628.getShared("UserList_SortByNick"));
            this.aSPanel_Sub48_4638.setBounds(17, 0, this.anInt4630 - 17, 15);
            this.aSPanel_Sub48_4638.method2983(true);
            this.add(this.aSPanel_Sub48_4638);
        }

        int var3 = this.anInt4630;
        int var4 = this.anInt4631 - (var2 ? 18 : 0) - (var1 ? 18 : 0) - (!var2 && !var1 ? 0 : 2) - (this.aBoolean4633 ? 15 : 0);
        if (this.aBoolean4633) {
            this.aColorList4634 = new ColorList(var3, var4, 11, 11);
        } else {
            this.aColorList4634 = new ColorList(var3, var4);
        }

        this.aColorList4634.setSelectable(1);
        this.aColorList4634.setLocation(0, this.aBoolean4633 ? 15 : 0);
        if (this.aBoolean4633) {
            this.aColorList4634.setNoUpperRounding();
        }

        this.aColorList4634.addItemListener(this);
        this.add(this.aColorList4634);
        this.setSorting(1);
        if (var1) {
            this.aColorCheckbox4635 = new ColorCheckbox(this.aTextManager4628.getShared("UserList_Privately"));
            this.aColorCheckbox4635.setBounds(0, this.anInt4631 - 18 - (var2 ? 18 : 0), this.anInt4630, 18);
            this.aColorCheckbox4635.addItemListener(this);
            this.add(this.aColorCheckbox4635);
        }

        if (var2) {
            this.aColorCheckbox4636 = new ColorCheckbox(this.aTextManager4628.getShared("UserList_Ignore"));
            this.aColorCheckbox4636.setBounds(0, this.anInt4631 - 18, this.anInt4630, 18);
            this.aColorCheckbox4636.addItemListener(this);
            this.add(this.aColorCheckbox4636);
        }

    }

    private void method2993() {
        if (this.aColorCheckbox4635 != null) {
            this.aColorCheckbox4635.setState(false);
        }

        if (this.aColorCheckbox4636 != null) {
            this.aColorCheckbox4636.setState(false);
        }

    }

    private Image method2994(UserListItem var1) {
        if (this.anImageArray4632 == null) {
            return null;
        } else if (!var1.isRegistered()) {
            return this.anImageArray4632[0];
        } else {
            int var2 = var1.getRanking();
            if (var2 < 0) {
                return null;
            } else if (var2 == 0) {
                return this.anImageArray4632[1];
            } else if (var2 < 50) {
                return this.anImageArray4632[2];
            } else {
                for (int var3 = 100; var3 <= 1000; var3 += 100) {
                    if (var2 < var3) {
                        return this.anImageArray4632[2 + var3 / 100];
                    }
                }

                return this.anImageArray4632[13];
            }
        }
    }

    private void method2995(UserListItem var1) {
        String var2 = var1.getNick();
        if (var1.isPrivately()) {
            this.aVector4660.addElement(var2);
        } else {
            this.aVector4660.removeElement(var2);
        }

        if (var1.isIgnore()) {
            this.aVector4661.addElement(var2);
        } else {
            this.aVector4661.removeElement(var2);
        }

    }

    private boolean method2996(UserListItem var1) {
        String var2 = var1.method2218();
        if (var2 == null) {
            return false;
        } else {
            try {
                String var3 = this.aTextManager4628.getParameters().getParameter("guestinfotarget");
                if (var3 == null) {
                    var3 = "_blank";
                }

                this.anImageManager4629.getApplet().getAppletContext().showDocument(new URL(var2), var3);
            } catch (Exception var4) {
                ;
            }

            return true;
        }
    }

    private static String method2997(String var0) {
        int var1;
        int var2;
        if (var0.startsWith("2:")) {
            var1 = var0.lastIndexOf(94);
            var2 = var0.lastIndexOf(94, var1 - 1);
            var0 = var0.substring(2, var2);
        }

        var1 = var0.indexOf(44);
        var2 = var0.lastIndexOf(44);
        if (var1 == var2) {
            var2 = var0.length();
        }

        return var0.substring(var1 + 1, var2);
    }

    private UserListItem method2998(String var1, boolean var2, int var3) {
        String var6 = null;
        int var4;
        int var5;
        if (var1.startsWith("2:")) {
            var4 = var1.lastIndexOf(94);
            var5 = var1.lastIndexOf(94, var4 - 1);
            var6 = var1.substring(var5 + 1);
            var1 = var1.substring(2, var5);
        }

        var4 = var1.indexOf(44);
        var5 = var1.lastIndexOf(44);
        String var7;
        int var8;
        if (var4 == var5) {
            var7 = var1.substring(var4 + 1);
            var8 = -2;
        } else {
            var7 = var1.substring(var4 + 1, var5);
            var8 = Integer.parseInt(var1.substring(var5 + 1));
        }

        String var9 = var1.substring(0, var4);
        boolean var10 = var9.indexOf(114) >= 0;
        boolean var11 = var9.indexOf(118) >= 0;
        boolean var12 = var9.indexOf(115) >= 0;
        boolean var13 = var9.indexOf(110) >= 0;
        UserListItem var14 = new UserListItem(var7, var2, var10, var11, var12, var8);
        var14.method2208(var13);
        if (var3 >= 0) {
            var14.setOverrideColor(var3);
        }

        this.addUser(var14);
        if (var6 != null) {
            var4 = var6.indexOf(94);
            String var15 = var6.substring(0, var4);
            String var16 = var6.substring(var4 + 1);
            if (!var15.equals("-")) {
                var14.method2217(Tools.changeFromSaveable(var15));
            }

            if (!var16.equals("-")) {
                var14.method2216(Tools.changeFromSaveable(var16), this.anImageManager4629, this.aColorList4634);
            }
        }

        return var14;
    }

    static {
        aStringArray4668[0] = "Remove user...";
        aStringArray4668[1] = "Get user info";
        aStringArray4668[2] = "1 hour";
        aStringArray4668[3] = "1 day (admin)";
        aStringArray4668[4] = "Admin";
        aStringArray4668[5] = "Broadcast message...";
        aStringArray4668[6] = "Sheriff";
        aStringArray4668[7] = "6 hours";
        aStringArray4668[8] = "15 minutes";
        aStringArray4668[9] = "5 minutes";
        aStringArray4668[10] = "Send message...";
        aStringArray4668[11] = "Mute user";
        aStringArray4668[12] = "Copy chat";
        aStringArray4668[13] = "UserList_OpenPlayerCard";
        aStringArray4668[14] = "Unmute user";
        aStringArray4668[15] = "2:";
        aStringArray4668[16] = "UserList_Ignore";
        aStringArray4668[17] = "UserList_SortByRanking";
        aStringArray4668[18] = "UserList_SortByNick";
        aStringArray4668[19] = "UserList_Privately";
        aStringArray4668[20] = "ranking-icons.gif";
        aStringArray4668[21] = "UserList_Sheriff";
        aStringArray4668[22] = "unmute";
        aStringArray4668[23] = "mute";
        aStringArray4668[24] = "info";
        aStringArray4668[25] = "_blank";
        aStringArray4668[26] = "guestinfotarget";
        aStringArray4668[27] = "3:";
        aColor4625 = Color.white;
        aColor4626 = Color.black;
    }
}
