package com.playray.multiuser;

import com.playray.client.ImageManager;
import com.playray.colorgui.ColorList;
import com.playray.colorgui.ColorListItem;

import java.awt.Image;

public final class UserListItem {

    private String aString2173;
    private boolean aBoolean2174;
    private boolean aBoolean2175;
    private boolean aBoolean2176;
    private boolean aBoolean2177;
    private int anInt2178;
    private int anInt2179;
    private int anInt2180;
    private Image anImage2181;
    private boolean aBoolean2182;
    private boolean aBoolean2183;
    private boolean aBoolean2184;
    private ColorListItem aColorListItem2185;
    private String aString2186;
    public static boolean aBoolean2187;


    public UserListItem(String var1, boolean var2, boolean var3, boolean var4, boolean var5) {
        this(var1, var2, var3, var4, var5, -1);
    }

    public UserListItem(String var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6) {
        if (!var3) {
            var5 = false;
            var4 = false;
            var6 = -1;
        }

        this.aString2173 = var1;
        this.aBoolean2174 = var2;
        this.aBoolean2175 = var3;
        this.aBoolean2176 = var4;
        this.aBoolean2177 = var5;
        this.anInt2178 = var6;
        this.aBoolean2182 = this.aBoolean2183 = this.aBoolean2184 = false;
        this.anInt2179 = -1;
        this.anInt2180 = 0;
    }

    public String getNick() {
        return this.aString2173;
    }

    public boolean isLocal() {
        return this.aBoolean2174;
    }

    public boolean isRegistered() {
        return this.aBoolean2175;
    }

    public boolean isVip() {
        return this.aBoolean2176;
    }

    public boolean isSheriff() {
        return this.aBoolean2177;
    }

    public int getRanking() {
        return this.anInt2178;
    }

    public boolean isPrivately() {
        return this.aBoolean2182;
    }

    public boolean isIgnore() {
        return this.aBoolean2183;
    }

    public void setOverrideColor(int var1) {
        this.anInt2179 = var1;
    }

    public boolean isNotAcceptingChallenges() {
        return this.aBoolean2184;
    }

    public void setAfterNickText(String var1) {
        String var2 = this.aString2173;
        if (var1 != null) {
            var2 = var2 + " " + var1;
        }

        this.aColorListItem2185.setString(var2);
    }

    public void setAfterNickIcon(Image var1) {
        this.aColorListItem2185.setIconAfterText(var1);
        ColorList var2 = this.aColorListItem2185.getColorListReference();
        if (var2 != null) {
            var2.repaint();
        }

    }

    public Image getAfterNickIcon() {
        return this.aColorListItem2185.getIconAfterText();
    }

    public int getLanguage() {
        return this.anInt2180;
    }

    public Image getLanguageFlag() {
        return this.anImage2181;
    }

    protected void method2208(boolean var1) {
        this.aBoolean2184 = var1;
    }

    protected void method2209(int var1) {
        this.anInt2180 = var1;
    }

    protected void method2210(Image var1) {
        this.anImage2181 = var1;
    }

    protected void method2211(boolean var1) {
        this.aBoolean2182 = var1;
    }

    protected void method2212(boolean var1) {
        this.aBoolean2183 = var1;
    }

    protected int method2213(boolean var1) {
        if (this.anInt2179 >= 0) {
            return this.anInt2179;
        } else {
            int var2;
            if (this.aBoolean2174) {
                var2 = !this.aBoolean2176 ? 3 : 6;
            } else {
                boolean var3 = this.aBoolean2177 && var1;
                if (!var3 && !this.aBoolean2176) {
                    var2 = 0;
                } else {
                    var2 = var3 ? 4 : 2;
                }
            }

            if (this.aBoolean2182) {
                var2 = 5;
            }

            if (this.aBoolean2183) {
                var2 = 1;
            }

            return var2;
        }
    }

    protected void method2214(ColorListItem var1) {
        this.aColorListItem2185 = var1;
    }

    protected ColorListItem method2215() {
        return this.aColorListItem2185;
    }

    protected void method2216(String var1, ImageManager var2, ColorList var3) {
        if (!var2.isDefined(var1)) {
            var2.defineImage(var1, var1);
        }

        this.aColorListItem2185.setIcon(var2.getEvenNotLoaded(var1));
        var3.repaint();
    }

    protected void method2217(String var1) {
        this.aString2186 = var1;
    }

    protected String method2218() {
        return this.aString2186;
    }
}
