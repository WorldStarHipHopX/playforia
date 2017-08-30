package com.aapeli.multiuser;

import com.aapeli.client.ImageManager;
import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;

import java.awt.Image;

public final class UserListItem {

    private String nick;
    private boolean isLocal;
    private boolean isRegistered;
    private boolean isVip;
    private boolean isSheriff;
    private int ranking;
    private int overrideColour;
    private int language;
    private Image languageFlag;
    private boolean isPrivately;
    private boolean isIgnore;
    private boolean isNotAcceptingChallenges;
    private ColorListItem aColorListItem1682;
    private String aString1683;
    public static boolean aBoolean1684;


    public UserListItem(String nick, boolean isLocal, boolean isRegistered, boolean isVip, boolean isSheriff) {
        this(nick, isLocal, isRegistered, isVip, isSheriff, -1);
    }

    public UserListItem(String nick, boolean isLocal, boolean isRegistered, boolean isVip, boolean isSheriff, int ranking) {
        if (!isRegistered) {
            isSheriff = false;
            isVip = false;
            ranking = -1;
        }

        this.nick = nick;
        this.isLocal = isLocal;
        this.isRegistered = isRegistered;
        this.isVip = isVip;
        this.isSheriff = isSheriff;
        this.ranking = ranking;
        this.isPrivately = this.isIgnore = this.isNotAcceptingChallenges = false;
        this.overrideColour = -1;
        this.language = 0;
    }

    public String getNick() {
        return this.nick;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean isVip() {
        return this.isVip;
    }

    public boolean isSheriff() {
        return this.isSheriff;
    }

    public int getRanking() {
        return this.ranking;
    }

    public boolean isPrivately() {
        return this.isPrivately;
    }

    public boolean isIgnore() {
        return this.isIgnore;
    }

    public void setOverrideColor(int var1) {
        this.overrideColour = var1;
    }

    public boolean isNotAcceptingChallenges() {
        return this.isNotAcceptingChallenges;
    }

    public void setAfterNickText(String var1) {
        String var2 = this.nick;
        if (var1 != null) {
            var2 = var2 + " " + var1;
        }

        this.aColorListItem1682.setString(var2);
    }

    public void setAfterNickIcon(Image var1) {
        this.aColorListItem1682.setIconAfterText(var1);
        ColorList var2 = this.aColorListItem1682.getColorListReference();
        if (var2 != null) {
            var2.repaint();
        }

    }

    public Image getAfterNickIcon() {
        return this.aColorListItem1682.getIconAfterText();
    }

    public int getLanguage() {
        return this.language;
    }

    public Image getLanguageFlag() {
        return this.languageFlag;
    }

    protected void isNotAcceptingChallenges(boolean var1) {
        this.isNotAcceptingChallenges = var1;
    }

    protected void setLanguage(int var1) {
        this.language = var1;
    }

    protected void setLanguageFlag(Image var1) {
        this.languageFlag = var1;
    }

    protected void isPrivately(boolean var1) {
        this.isPrivately = var1;
    }

    protected void isIgnore(boolean var1) {
        this.isIgnore = var1;
    }

    protected int method1821(boolean var1) {
        if (this.overrideColour >= 0) {
            return this.overrideColour;
        } else {
            int var2;
            if (this.isLocal) {
                var2 = !this.isVip ? 3 : 6;
            } else {
                boolean var3 = this.isSheriff && var1;
                if (!var3 && !this.isVip) {
                    var2 = 0;
                } else {
                    var2 = var3 ? 4 : 2;
                }
            }

            if (this.isPrivately) {
                var2 = 5;
            }

            if (this.isIgnore) {
                var2 = 1;
            }

            return var2;
        }
    }

    protected void method1822(ColorListItem var1) {
        this.aColorListItem1682 = var1;
    }

    protected ColorListItem method1823() {
        return this.aColorListItem1682;
    }

    protected void loadAvatar(String var1, ImageManager var2, ColorList var3) {
        if (!var2.isDefined(var1)) {
            var2.defineImage(var1, var1);
        }

        this.aColorListItem1682.setIcon(var2.getEvenNotLoaded(var1));
        var3.repaint();
    }

    protected void method1825(String var1) {
        this.aString1683 = var1;
    }

    protected String method1826() {
        return this.aString1683;
    }
}
