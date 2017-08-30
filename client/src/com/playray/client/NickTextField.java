package com.playray.client;

import com.playray.client.BadWordFilter;
import com.playray.client.InputTextField;
import com.playray.client.TextManager;

public class NickTextField extends InputTextField {

    public static final int ERROR_NONE = 0;
    public static final int ERROR_EMPTY = 1;
    public static final int ERROR_TOOSHORT = 2;
    public static final int ERROR_TOOLONG = 3;
    public static final int ERROR_BADWORDS = 4;
    public static final int ERROR_FORBIDDEN = 5;
    public static final int NICK_MAX_LENGTH = 16;
    private static final String aString4933 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖÜÁÉÍÓÚÑabcdefghijklmnopqrstuvwxyzåäöüáéíóúñ0123456789- ";
    private boolean aBoolean4934;
    private BadWordFilter aBadWordFilter4935;
    private BadWordFilter aBadWordFilter4936;
    private int anInt4937;
    private static final String aString4938 = "Anonymous";


    public NickTextField(TextManager var1) {
        this(var1, false);
    }

    public NickTextField(TextManager var1, boolean var2) {
        super(15);
        this.aBoolean4934 = var2;
        this.aBadWordFilter4935 = new BadWordFilter(var1, true);
        this.aBadWordFilter4936 = new BadWordFilter(var1, false);
        this.anInt4937 = 0;
    }

    public String getNick() {
        this.anInt4937 = 0;
        String var1 = this.getInputText(false);
        var1 = this.method2811(var1);
        this.getTextField().setText(var1);
        int var2 = var1.length();
        if (var2 == 0) {
            if (!this.aBoolean4934) {
                this.anInt4937 = 1;
                return null;
            }

            var1 = "Anonymous";
            var2 = var1.length();
        }

        if (var2 < 3) {
            this.anInt4937 = 2;
            return null;
        } else if (var2 > 15) {
            this.anInt4937 = 3;
            return null;
        } else if (this.aBadWordFilter4935.containsBadWords(var1)) {
            this.anInt4937 = 4;
            return null;
        } else if (this.aBadWordFilter4936.containsBadWords(var1)) {
            this.anInt4937 = 5;
            return null;
        } else {
            return var1;
        }
    }

    public int getLastError() {
        return this.anInt4937;
    }

    private String method2811(String var1) {
        var1 = var1.trim();
        int var2 = var1.length();
        StringBuffer var3 = new StringBuffer(var2);

        for (int var5 = 0; var5 < var2; ++var5) {
            char var4 = var1.charAt(var5);
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖÜÁÉÍÓÚÑabcdefghijklmnopqrstuvwxyzåäöüáéíóúñ0123456789- ".indexOf(var4) == -1) {
                var4 = 45;
            }

            var3.append(var4);
        }

        var1 = var3.toString();

        do {
            if ((var2 = var1.length()) <= 0) {
                return var1;
            }

            if (var1.charAt(0) == 45) {
                var1 = var1.substring(1);
            } else if (var1.charAt(var2 - 1) == 45) {
                var1 = var1.substring(0, var2 - 1);
            }

            var1 = var1.trim();
        } while (var1.length() != var2);

        return var1;
    }

}
