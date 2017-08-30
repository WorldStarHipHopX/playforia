package com.aapeli.multiuser;

import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;
import com.aapeli.colorgui.ColorListItemGroup;
import com.aapeli.colorgui.ColorTextArea;
import com.aapeli.tools.Tools;

import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
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

public class UserList extends IPanel implements ComponentListener, ItemListener, ActionListener {

    public static final int SORT_NICKNAME_ABC = 1;
    public static final int SORT_NICKNAME_CBA = 2;
    public static final int SORT_RANKING_123 = 3;
    public static final int SORT_RANKING_321 = 4;
    private static final Color aColor3453;
    private static final Color aColor3454;
    private static final Font aFont3455;
    private static final Color aColor3456;
    private static final Color aColor3457;
    private UserListHandler anUserListHandler3458;
    private TextManager aTextManager3459;
    private ImageManager anImageManager3460;
    private int anInt3461;
    private int anInt3462;
    private Image[] anImageArray3463;
    private boolean aBoolean3464;
    private ColorList aColorList3465;
    private ColorCheckbox aColorCheckbox3466;
    private ColorCheckbox aColorCheckbox3467;
    private ColorButton_Sub1 aColorButton_Sub1_3468;
    private ColorButton_Sub1 aColorButton_Sub1_3469;
    private Image anImage3470;
    private Image anImage3471;
    private int anInt3472;
    private int anInt3473;
    private int anInt3474;
    private int anInt3475;
    private boolean isSheriff;
    private int sheriffStatus;
    private int adminStatus;
    private PopupMenu aPopupMenu3479;
    private MenuItem aMenuItem3480;
    private MenuItem aMenuItem3481;
    private MenuItem aMenuItem3482;
    private MenuItem aMenuItem3483;
    private MenuItem aMenuItem3484;
    private MenuItem aMenuItem3485;
    private MenuItem aMenuItem3486;
    private MenuItem aMenuItem3487;
    private MenuItem aMenuItem3488;
    private MenuItem aMenuItem3489;
    private MenuItem aMenuItem3490;
    private MenuItem aMenuItem3491;
    private MenuItem aMenuItem3492;
    private MenuItem aMenuItem3493;
    private MenuItem aMenuItem3494;
    private UserListItem anUserListItem3495;
    private StaffActionFrame aStaffActionFrame__3496;
    private Vector aVector3497;
    private Vector aVector3498;
    private boolean aBoolean3499;
    private boolean aBoolean3500;
    private ColorTextArea aColorTextArea3501;
    private ChatBase aChatBase3502;
    private Languages aLanguages3503;
    private Hashtable aHashtable3504;
    private static final String[] aStringArray3505 = new String[29];


    public UserList(UserListHandler var1, TextManager var2, ImageManager var3, boolean var4, boolean var5, boolean var6) {
        this(var1, var2, var3, var4, var5, var6, 100, 200);
    }

    public UserList(UserListHandler hndlr, TextManager var2, ImageManager var3, boolean var4, boolean var5, boolean var6, int var7, int var8) {
        this.anUserListHandler3458 = hndlr;
        this.aTextManager3459 = var2;
        this.anImageManager3460 = var3;
        this.anInt3461 = var7;
        this.anInt3462 = var8;
        this.setSize(var7, var8);
        this.aBoolean3464 = var4;
        this.method931(var5, var6);
        this.setBackground(aColor3453);
        this.setForeground(aColor3454);
        if (var4) {
            Image var9 = var3.getShared("ranking-icons.gif");
            this.anImageArray3463 = var3.separateImages(var9, 14);
        }

        this.isSheriff = false;
        this.sheriffStatus = this.adminStatus = 0;
        this.aVector3497 = new Vector();
        this.aVector3498 = new Vector();
        this.aBoolean3499 = this.aBoolean3500 = true;
        this.aLanguages3503 = new Languages(var2, var3);
        this.aHashtable3504 = new Hashtable();
        this.addComponentListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage3470 != null) {
            var1.drawImage(this.anImage3470, 0, 0, this.anInt3461, this.anInt3462, this.anInt3472, this.anInt3473, this.anInt3472 + this.anInt3461, this.anInt3473 + this.anInt3462, this);
        } else {
            this.drawBackground(var1);
        }

    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
        if (this.anImage3470 != null) {
            Point var2 = this.getLocation();
            int var3 = var2.x - this.anInt3474;
            int var4 = var2.y - this.anInt3475;
            this.setBackgroundImage(this.anImage3470, this.anImage3471, this.anInt3472 + var3, this.anInt3473 + var4);
        }

        this.repaint();
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        this.anInt3461 = var2.width;
        this.anInt3462 = var2.height;
        boolean var3 = this.aColorCheckbox3466 != null;
        boolean var4 = this.aColorCheckbox3467 != null;
        if (this.aBoolean3464) {
            this.aColorButton_Sub1_3468.setSize(17, 11);
            this.aColorButton_Sub1_3469.setSize(this.anInt3461 - 17, 11);
        }

        int var5 = this.anInt3461;
        int var6 = this.anInt3462 - (var4 ? 18 : 0) - (var3 ? 18 : 0) - (!var4 && !var3 ? 0 : 2) - (this.aBoolean3464 ? 11 : 0);
        this.aColorList3465.setBounds(0, this.aBoolean3464 ? 11 : 0, var5, var6);
        if (var3) {
            this.aColorCheckbox3466.setBounds(0, this.anInt3462 - 18 - (var4 ? 18 : 0), this.anInt3461, 18);
        }

        if (var4) {
            this.aColorCheckbox3467.setBounds(0, this.anInt3462 - 18, this.anInt3461, 18);
        }

        this.componentMoved(var1);
    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aMenuItem3481) {
            this.aColorCheckbox3466.click();
        } else if (var2 == this.aMenuItem3482) {
            this.aColorCheckbox3467.click();
        } else {
            ColorListItem var3 = this.aColorList3465.getSelectedItem();
            boolean var4 = false;
            if (var3 == null) {
                this.method932();
                var4 = true;
                Object var5 = var1.getItem();
                if (!(var5 instanceof ColorListItem)) {
                    return;
                }

                var3 = (ColorListItem) ((ColorListItem) var1.getItem());
            }

            UserListItem var8 = (UserListItem) ((UserListItem) var3.getData());
            if (var2 == this.aColorList3465) {
                int var6 = var1.getID();
                if (var6 == 2) {
                    if (this.openProfilePage(var8)) {
                        return;
                    }

                    this.anUserListHandler3458.openPlayerCard(var8.getNick());
                } else if (var6 == 1 && this.isSheriff) {
                    int[] var7 = this.aColorList3465.getLastClickedMouseXY();
                    this.showSheriffMenu(var8, var7[0], var7[1]);
                }
            }

            if (!var4) {
                if (var2 == this.aColorList3465) {
                    if (this.aColorCheckbox3466 != null) {
                        this.aColorCheckbox3466.setState(var8.isPrivately());
                    }

                    if (this.aColorCheckbox3467 != null) {
                        this.aColorCheckbox3467.setState(var8.isIgnore());
                    }

                } else {
                    if (var2 == this.aColorCheckbox3466 || var2 == this.aColorCheckbox3467) {
                        if (var8.isLocal()) {
                            this.method932();
                        } else {
                            var8.isPrivately(this.aColorCheckbox3466 != null ? this.aColorCheckbox3466.getState() : false);
                            var8.isIgnore(this.aColorCheckbox3467 != null ? this.aColorCheckbox3467.getState() : false);
                            var3.setColor(this.method930(var8));
                            this.aColorList3465.repaint();
                        }
                    }

                }
            }
        }
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorButton_Sub1_3468) {
            if (this.getSorting() == 4) {
                this.setSorting(3);
            } else {
                this.setSorting(4);
            }
        } else if (var2 == this.aColorButton_Sub1_3469) {
            if (this.getSorting() == 1) {
                this.setSorting(2);
            } else {
                this.setSorting(1);
            }
        } else if (var2 == this.aMenuItem3480) {
            if (!this.openProfilePage(this.anUserListItem3495)) {
                this.anUserListHandler3458.openPlayerCard(this.anUserListItem3495.getNick());
            }
        } else if (var2 == this.aMenuItem3483) {
            this.method929(1, this.anUserListItem3495.getNick());
        } else if (var2 == this.aMenuItem3484) {
            this.method929(2, this.anUserListItem3495.getNick());
        } else if (var2 != this.aMenuItem3485 && var2 != this.aMenuItem3486 && var2 != this.aMenuItem3487 && var2 != this.aMenuItem3488 && var2 != this.aMenuItem3489) {
            if (var2 == this.aMenuItem3490) {
                this.method929(4, (String) null);
            } else if (var2 == this.aMenuItem3491) {
                CopyChatFrame var4 = new CopyChatFrame();
                var4.create(this.anImageManager3460.getApplet(), (ColorTextArea) (this.aChatBase3502 != null ? this.aChatBase3502.gui_output : this.aColorTextArea3501));
            } else if (var2 == this.aMenuItem3492) {
                this.anUserListHandler3458.adminCommand("info", this.anUserListItem3495.getNick());
            } else if (var2 == this.aMenuItem3493) {
                this.anUserListHandler3458.adminCommand("unmute", this.anUserListItem3495.getNick());
            } else if (var2 == this.aMenuItem3494) {
                this.method929(5, (String) null);
            }
        } else {
            short var3 = 0;
            if (var2 == this.aMenuItem3485) {
                var3 = 5;
            } else if (var2 == this.aMenuItem3486) {
                var3 = 15;
            } else if (var2 == this.aMenuItem3487) {
                var3 = 60;
            } else if (var2 == this.aMenuItem3488) {
                var3 = 360;
            } else if (var2 == this.aMenuItem3489) {
                var3 = 1440;
            }

            this.anUserListHandler3458.adminCommand("mute", this.anUserListItem3495.getNick(), "" + var3);
        }

    }

    public static String getNickFromUserInfo(String var0) {
        if (!method925(var0)) {
            return method936(var0);
        } else {
            int var1 = var0.indexOf(58);
            int var2 = var0.indexOf(94);
            return Tools.changeFromSaveable(var0.substring(var1 + 1, var2));
        }
    }

    public void disableSheriffMark() {
        this.aBoolean3499 = false;
    }

    public void disableDimmerNicks() {
        this.aBoolean3500 = false;
    }

    public void enablePopUp() {
        this.enablePopUp(false, false);
    }

    public void enablePopUp(boolean isSheriff, boolean isAdmin) {
        this.sheriffStatus = isSheriff ? 2 : 0;
        this.adminStatus = isAdmin ? 1 : 0;
        this.isSheriff = true;
    }

    public void enablePopUpWithOnlyOldCommands(boolean isSheriff, boolean isAdmin) {
        this.sheriffStatus = isSheriff ? 1 : 0;
        this.adminStatus = isAdmin ? 1 : 0;
        this.isSheriff = true;
    }

    public void setCheckBoxesVisible(boolean var1) {
        if (this.aColorCheckbox3466 != null) {
            this.aColorCheckbox3466.setVisible(var1);
        }

        if (this.aColorCheckbox3467 != null) {
            this.aColorCheckbox3467.setVisible(var1);
        }

    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        if (this.aColorCheckbox3466 != null) {
            this.aColorCheckbox3466.setBackground(var1);
        }

        if (this.aColorCheckbox3467 != null) {
            this.aColorCheckbox3467.setBackground(var1);
        }

        this.repaint();
    }

    public void setForeground(Color var1) {
        super.setForeground(var1);
        if (this.aColorCheckbox3466 != null) {
            this.aColorCheckbox3466.setForeground(var1);
        }

        if (this.aColorCheckbox3467 != null) {
            this.aColorCheckbox3467.setForeground(var1);
        }

    }

    public void setBackgroundImage(Image var1, int var2, int var3) {
        this.setBackgroundImage(var1, (Image) null, var2, var3);
    }

    public void setBackgroundImage(Image var1, Image var2, int var3, int var4) {
        this.anImage3470 = var1;
        this.anImage3471 = var2;
        this.anInt3472 = var3;
        this.anInt3473 = var4;
        Point var5 = this.getLocation();
        this.anInt3474 = var5.x;
        this.anInt3475 = var5.y;
        Point var6;
        if (var2 != null) {
            var6 = this.aColorList3465.getLocation();
            this.aColorList3465.setBackgroundImage(var2, var3 + var6.x, var4 + var6.y);
        }

        if (this.aColorCheckbox3466 != null) {
            var6 = this.aColorCheckbox3466.getLocation();
            this.aColorCheckbox3466.setBackgroundImage(var1, var3 + var6.x, var4 + var6.y);
        }

        if (this.aColorCheckbox3467 != null) {
            var6 = this.aColorCheckbox3467.getLocation();
            this.aColorCheckbox3467.setBackgroundImage(var1, var3 + var6.x, var4 + var6.y);
        }

        this.repaint();
    }

    public void setListBackgroundImage(Image var1, int var2, int var3) {
        Point var4 = this.aColorList3465.getLocation();
        this.aColorList3465.setBackgroundImage(var1, var2 + var4.x, var3 + var4.y);
    }

    public UserListItem addUser(String var1, boolean var2) {
        return this.addUser(var1, var2, -1);
    }

    public UserListItem addUser(String userData, boolean userIsLocal, int var3) {
        if (!method925(userData)) {
            return this.method937(userData, userIsLocal, var3);
        } else {
            // 3:im the man111^r^111^fi_FI^-^-
            int colonIndex = userData.indexOf(':');
            userData = userData.substring(colonIndex + 1);// looks like the number is skipped
            StringTokenizer tokenizer = new StringTokenizer(userData, "^");
            String username = Tools.changeFromSaveable(tokenizer.nextToken());
            String elevation = tokenizer.nextToken();
            int points = Integer.parseInt(tokenizer.nextToken());// points earned, maybe
            String locale = tokenizer.nextToken();
            String unknown = Tools.changeFromSaveable(tokenizer.nextToken());
            String avatarUrl = Tools.changeFromSaveable(tokenizer.nextToken());
            boolean isRegistered = elevation.indexOf('r') >= 0;
            boolean isVip = elevation.indexOf('v') >= 0;
            boolean isSheriff = elevation.indexOf('s') >= 0;
            boolean isNotAcceptingChallenges = elevation.indexOf('n') >= 0;
            UserListItem listItem = new UserListItem(username, userIsLocal, isRegistered, isVip, isSheriff, points);
            listItem.isNotAcceptingChallenges(isNotAcceptingChallenges);
            int var17 = Languages.getLanguageIdByString(locale);
            listItem.setLanguage(var17);
            listItem.setLanguageFlag(this.aLanguages3503.getFlag(var17));
            if (var3 >= 0) {
                listItem.setOverrideColor(var3);
            }

            this.addUser(listItem);
            if (!unknown.equals("-")) {
                listItem.method1825(unknown);
            }

            if (!avatarUrl.equals("-")) {
                listItem.loadAvatar(avatarUrl, this.anImageManager3460, this.aColorList3465);
            }

            return listItem;
        }
    }

    public void addUser(UserListItem var1) {
        String var2 = var1.getNick();
        if (this.aVector3497.contains(var2)) {
            var1.isPrivately(true);
        }

        if (this.aVector3498.contains(var2)) {
            var1.isIgnore(true);
        }

        String var3 = var1.getNick();
        if (var1.isSheriff() && this.aBoolean3499) {
            var3 = var3 + " " + this.aTextManager3459.getShared("UserList_Sheriff");
        }

        ColorListItem var4 = new ColorListItem(this.method933(var1), this.method930(var1), var1.isRegistered(), var3, var1, false);
        var4.setValue(var1.getRanking());
        if (var1.isSheriff()) {
            var4.setSortOverride(true);
        }

        int var5 = var1.getLanguage();
        Integer var6 = new Integer(var5);
        ColorListItemGroup var7 = (ColorListItemGroup) ((ColorListItemGroup) this.aHashtable3504.get(var6));
        if (var7 == null) {
            int var8 = var5;
            if (var5 == 0) {
                var8 = var5 + 50;
            }

            String var9 = this.aLanguages3503.getName(var5);
            var7 = new ColorListItemGroup(var9, this.aLanguages3503.getFlag(var5), var8);
            this.aHashtable3504.put(var6, var7);
        }

        if (var1.isLocal()) {
            var7.changeSortValue(-100);
            this.aColorList3465.reSort();
        }

        var4.setGroup(var7);
        this.aColorList3465.addItem(var4);
        var1.method1822(var4);
    }

    public UserListItem getSelectedUser() {
        ColorListItem var1 = this.aColorList3465.getSelectedItem();
        return var1 == null ? null : (UserListItem) ((UserListItem) var1.getData());
    }

    public UserListItem getUser(String var1) {
        ColorListItem[] var2 = this.aColorList3465.getAllItems();
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
        ColorListItem[] var1 = this.aColorList3465.getAllItems();
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
        ColorListItem[] var2 = this.aColorList3465.getAllItems();
        if (var2 != null) {
            int var3 = var2.length;
            if (var3 > 0) {
                for (int var5 = 0; var5 < var3; ++var5) {
                    UserListItem var4 = (UserListItem) ((UserListItem) var2[var5].getData());
                    if (var4.getNick().equals(var1)) {
                        this.aColorList3465.removeItem(var2[var5]);
                        if (var2[var5].isSelected()) {
                            this.method932();
                        }

                        this.method934(var4);
                        return;
                    }
                }
            }
        }

    }

    public UserListItem removeUserNew(String var1) {
        ColorListItem[] var2 = this.aColorList3465.getAllItems();
        if (var2 != null) {
            int var3 = var2.length;
            if (var3 > 0) {
                for (int var5 = 0; var5 < var3; ++var5) {
                    UserListItem var4 = (UserListItem) ((UserListItem) var2[var5].getData());
                    if (var4.getNick().equals(var1)) {
                        this.aColorList3465.removeItem(var2[var5]);
                        if (var2[var5].isSelected()) {
                            this.method932();
                        }

                        this.method934(var4);
                        return var4;
                    }
                }
            }
        }

        return null;
    }

    public void removeAllUsers() {
        ColorListItem[] var1 = this.aColorList3465.getAllItems();
        if (var1 != null) {
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                this.method934((UserListItem) ((UserListItem) var1[var3].getData()));
            }
        }

        this.aColorList3465.removeAllItems();
        this.method932();
    }

    public void setNotAcceptingChallenges(UserListItem var1, boolean var2) {
        var1.isNotAcceptingChallenges(var2);
        ColorListItem var3 = var1.method1823();
        var3.setColor(this.method930(var1));
        this.aColorList3465.repaint();
    }

    public void setSorting(int var1) {
        this.aColorList3465.setSorting(var1);
        if (this.aBoolean3464) {
            if (var1 != 3 && var1 != 4) {
                this.aColorButton_Sub1_3468.setBackground(aColor3456);
                this.aColorButton_Sub1_3469.setBackground(aColor3457);
            } else {
                this.aColorButton_Sub1_3468.setBackground(aColor3457);
                this.aColorButton_Sub1_3469.setBackground(aColor3456);
            }
        }

    }

    public int getSorting() {
        return this.aColorList3465.getSorting();
    }

    public int getUserCount() {
        return this.aColorList3465.getItemCount();
    }

    public void setChatOutputReference(ColorTextArea var1) {
        this.aColorTextArea3501 = var1;
    }

    public void setChatReference(ChatBase var1) {
        this.aChatBase3502 = var1;
    }

    public void usePixelRoundedButtonsAndCheckBoxes() {
        if (this.aColorButton_Sub1_3468 != null) {
            this.aColorButton_Sub1_3468.setPixelRoundedUpperCorners();
        }

        if (this.aColorButton_Sub1_3469 != null) {
            this.aColorButton_Sub1_3469.setPixelRoundedUpperCorners();
        }

        if (this.aColorCheckbox3466 != null) {
            this.aColorCheckbox3466.setBoxPixelRoundedCorners(true);
        }

        if (this.aColorCheckbox3467 != null) {
            this.aColorCheckbox3467.setBoxPixelRoundedCorners(true);
        }

    }

    private static boolean method925(String var0) {
        return var0.startsWith("3:");
    }

    private void showSheriffMenu(UserListItem var1, int var2, int var3) {
        this.anUserListItem3495 = var1;
        if (this.aPopupMenu3479 != null) {
            this.remove(this.aPopupMenu3479);
        }

        this.aPopupMenu3479 = new PopupMenu();
        this.aMenuItem3480 = this.method927(this.aPopupMenu3479, this.aTextManager3459.getShared("UserList_OpenPlayerCard"));
        this.aMenuItem3480.setEnabled(var1.isRegistered() || var1.method1826() != null);
        if (this.aColorCheckbox3466 != null || this.aColorCheckbox3467 != null) {
            this.aPopupMenu3479.addSeparator();
        }

        if (this.aColorCheckbox3466 != null) {
            this.aMenuItem3481 = this.method928(this.aPopupMenu3479, this.aColorCheckbox3466.getLabel(), var1.isPrivately());
            this.aMenuItem3481.setEnabled(!var1.isLocal());
        }

        if (this.aColorCheckbox3467 != null) {
            this.aMenuItem3482 = this.method928(this.aPopupMenu3479, this.aColorCheckbox3467.getLabel(), var1.isIgnore());
            this.aMenuItem3482.setEnabled(!var1.isLocal());
        }

        Menu var4;
        if (this.sheriffStatus > 0) {
            this.aPopupMenu3479.addSeparator();
            var4 = new Menu("Sheriff");
            this.aMenuItem3484 = this.method927(var4, "Send message...");
            if (this.sheriffStatus > 1) {
                Menu var5 = new Menu("Mute user");
                this.aMenuItem3485 = this.method927(var5, "5 minutes");
                this.aMenuItem3486 = this.method927(var5, "15 minutes");
                this.aMenuItem3487 = this.method927(var5, "1 hour");
                this.aMenuItem3488 = this.method927(var5, "6 hours");
                if (this.adminStatus > 0) {
                    this.aMenuItem3489 = this.method927(var5, "1 day (admin)");
                }

                var4.add(var5);
                if (this.aChatBase3502 != null || this.aColorTextArea3501 != null) {
                    this.aMenuItem3491 = this.method927(var4, "Copy chat");
                }
            }

            this.aPopupMenu3479.add(var4);
        }

        if (this.adminStatus > 0) {
            var4 = new Menu("Admin");
            this.aMenuItem3492 = this.method927(var4, "Get user info");
            this.aMenuItem3493 = this.method927(var4, "Unmute user");
            this.aMenuItem3483 = this.method927(var4, "Remove user...");
            this.aMenuItem3494 = this.method927(var4, "Broadcast message...");
            this.aPopupMenu3479.add(var4);
        }

        this.add(this.aPopupMenu3479);
        this.aPopupMenu3479.show(this.aColorList3465, var2, var3);
    }

    private MenuItem method927(Menu var1, String var2) {
        MenuItem var3 = new MenuItem(var2);
        var3.addActionListener(this);
        var1.add(var3);
        return var3;
    }

    private MenuItem method928(Menu var1, String var2, boolean var3) {
        CheckboxMenuItem var4 = new CheckboxMenuItem(var2, var3);
        var4.addItemListener(this);
        var1.add(var4);
        return var4;
    }

    private void method929(int var1, String var2) {
        if (this.aStaffActionFrame__3496 != null) {
            this.aStaffActionFrame__3496.windowClosing((WindowEvent) null);
        }

        this.aStaffActionFrame__3496 = new StaffActionFrame(this.aTextManager3459, this.anUserListHandler3458, var1, var2);
        this.aStaffActionFrame__3496.method251(this.anImageManager3460.getApplet(), this.adminStatus > 0);
    }

    private Color method930(UserListItem var1) {
        int var2 = var1.method1821(this.aBoolean3499);
        Color var3 = ColorListItem.getColorById(var2);
        if (this.aBoolean3500 && var1.isNotAcceptingChallenges()) {
            var3 = new Color((var3.getRed() + 896) / 5, (var3.getGreen() + 896) / 5, (var3.getBlue() + 896) / 5);
        }

        return var3;
    }

    private void method931(boolean var1, boolean var2) {
        this.setLayout((LayoutManager) null);
        if (this.aBoolean3464) {
            this.aColorButton_Sub1_3468 = new ColorButton_Sub1(this.aTextManager3459.getShared("UserList_SortByRanking"));
            this.aColorButton_Sub1_3468.setBounds(0, 0, 17, 11);
            this.aColorButton_Sub1_3468.setFont(aFont3455);
            this.aColorButton_Sub1_3468.setBackground(aColor3456);
            this.aColorButton_Sub1_3468.addActionListener(this);
            this.add(this.aColorButton_Sub1_3468);
            this.aColorButton_Sub1_3469 = new ColorButton_Sub1(this.aTextManager3459.getShared("UserList_SortByNick"));
            this.aColorButton_Sub1_3469.setBounds(17, 0, this.anInt3461 - 17, 11);
            this.aColorButton_Sub1_3469.setFont(aFont3455);
            this.aColorButton_Sub1_3469.setBackground(aColor3457);
            this.aColorButton_Sub1_3469.addActionListener(this);
            this.add(this.aColorButton_Sub1_3469);
        }

        int var3 = this.anInt3461;
        int var4 = this.anInt3462 - (var2 ? 18 : 0) - (var1 ? 18 : 0) - (!var2 && !var1 ? 0 : 2) - (this.aBoolean3464 ? 11 : 0);
        if (this.aBoolean3464) {
            this.aColorList3465 = new ColorList(var3, var4, 11, 11);
        } else {
            this.aColorList3465 = new ColorList(var3, var4);
        }

        this.aColorList3465.setSelectable(1);
        this.aColorList3465.setLocation(0, this.aBoolean3464 ? 11 : 0);
        this.aColorList3465.addItemListener(this);
        this.add(this.aColorList3465);
        this.setSorting(1);
        if (var1) {
            this.aColorCheckbox3466 = new ColorCheckbox(this.aTextManager3459.getShared("UserList_Privately"));
            this.aColorCheckbox3466.setBounds(0, this.anInt3462 - 18 - (var2 ? 18 : 0), this.anInt3461, 18);
            this.aColorCheckbox3466.addItemListener(this);
            this.add(this.aColorCheckbox3466);
        }

        if (var2) {
            this.aColorCheckbox3467 = new ColorCheckbox(this.aTextManager3459.getShared("UserList_Ignore"));
            this.aColorCheckbox3467.setBounds(0, this.anInt3462 - 18, this.anInt3461, 18);
            this.aColorCheckbox3467.addItemListener(this);
            this.add(this.aColorCheckbox3467);
        }

    }

    private void method932() {
        if (this.aColorCheckbox3466 != null) {
            this.aColorCheckbox3466.setState(false);
        }

        if (this.aColorCheckbox3467 != null) {
            this.aColorCheckbox3467.setState(false);
        }

    }

    private Image method933(UserListItem var1) {
        if (this.anImageArray3463 == null) {
            return null;
        } else if (!var1.isRegistered()) {
            return this.anImageArray3463[0];
        } else {
            int var2 = var1.getRanking();
            if (var2 < 0) {
                return null;
            } else if (var2 == 0) {
                return this.anImageArray3463[1];
            } else if (var2 < 50) {
                return this.anImageArray3463[2];
            } else {
                for (int var3 = 100; var3 <= 1000; var3 += 100) {
                    if (var2 < var3) {
                        return this.anImageArray3463[2 + var3 / 100];
                    }
                }

                return this.anImageArray3463[13];
            }
        }
    }

    private void method934(UserListItem var1) {
        String var2 = var1.getNick();
        if (var1.isPrivately()) {
            this.aVector3497.addElement(var2);
        } else {
            this.aVector3497.removeElement(var2);
        }

        if (var1.isIgnore()) {
            this.aVector3498.addElement(var2);
        } else {
            this.aVector3498.removeElement(var2);
        }

    }

    private boolean openProfilePage(UserListItem var1) {
        String var2 = var1.method1826();
        if (var2 == null) {
            return false;
        } else {
            try {
                String var3 = this.aTextManager3459.getParameters().getParameter("guestinfotarget");
                if (var3 == null) {
                    var3 = "_blank";
                }

                this.anImageManager3460.getApplet().getAppletContext().showDocument(new URL(var2), var3);
            } catch (Exception var4) {
                ;
            }

            return true;
        }
    }

    private static String method936(String var0) {
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

    private UserListItem method937(String var1, boolean var2, int var3) {
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
        var14.isNotAcceptingChallenges(var13);
        if (var3 >= 0) {
            var14.setOverrideColor(var3);
        }

        this.addUser(var14);
        if (var6 != null) {
            var4 = var6.indexOf(94);
            String var15 = var6.substring(0, var4);
            String var16 = var6.substring(var4 + 1);
            if (!var15.equals("-")) {
                var14.method1825(Tools.changeFromSaveable(var15));
            }

            if (!var16.equals("-")) {
                var14.loadAvatar(Tools.changeFromSaveable(var16), this.anImageManager3460, this.aColorList3465);
            }
        }

        return var14;
    }

    static {
        aStringArray3505[0] = "UserList_SortByNick";
        aStringArray3505[1] = "UserList_Privately";
        aStringArray3505[2] = "UserList_Ignore";
        aStringArray3505[3] = "UserList_SortByRanking";
        aStringArray3505[4] = "ranking-icons.gif";
        aStringArray3505[5] = "mute";
        aStringArray3505[6] = "info";
        aStringArray3505[7] = "unmute";
        aStringArray3505[8] = "UserList_Sheriff";
        aStringArray3505[9] = "2:";
        aStringArray3505[10] = "Admin";
        aStringArray3505[11] = "Send message...";
        aStringArray3505[12] = "Remove user...";
        aStringArray3505[13] = "Unmute user";
        aStringArray3505[14] = "1 hour";
        aStringArray3505[15] = "6 hours";
        aStringArray3505[16] = "Copy chat";
        aStringArray3505[17] = "15 minutes";
        aStringArray3505[18] = "1 day (admin)";
        aStringArray3505[19] = "Mute user";
        aStringArray3505[20] = "5 minutes";
        aStringArray3505[21] = "Get user info";
        aStringArray3505[22] = "Sheriff";
        aStringArray3505[23] = "Broadcast message...";
        aStringArray3505[24] = "UserList_OpenPlayerCard";
        aStringArray3505[25] = "3:";
        aStringArray3505[26] = "_blank";
        aStringArray3505[27] = "guestinfotarget";
        aStringArray3505[28] = "Dialog";
        aColor3453 = Color.white;
        aColor3454 = Color.black;
        aFont3455 = new Font("Dialog", 0, 9);
        aColor3456 = new Color(224, 224, 224);
        aColor3457 = new Color(208, 208, 255);
    }
}
