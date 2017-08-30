package com.playray.client;

import com.playray.client.TextManager;
import com.playray.colorgui.RadioButton;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyButton extends RadioButton implements KeyListener {

    private static final int[] anIntArray5005;
    private static final String[] aStringArray5006;
    private static final int anInt5007;
    private static final Color aColor5008;
    private static final Color aColor5009;
    private static final Color aColor5010;
    private TextManager aTextManager5011;
    private int anInt5012;
    private static final String[] aStringArray5013 = new String[3];


    public KeyButton(TextManager var1) {
        this(var1, -1);
    }

    public KeyButton(TextManager var1, int var2) {
        this.aTextManager5011 = var1;
        this.method2827(var2);
    }

    public void mousePressed(MouseEvent var1) {
        super.mousePressed(var1);
        this.removeKeyListener(this);
        if (this.getState()) {
            this.setLabel(this.aTextManager5011.getShared("Key_EnterNew"));
            this.setBackground(aColor5008);
            this.addKeyListener(this);
        } else {
            this.method2827(this.anInt5012);
        }

    }

    public void keyPressed(KeyEvent var1) {
        if (this.getState()) {
            this.method2827(var1.getKeyCode());
            this.setState(false);
        }

        this.removeKeyListener(this);
    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public boolean isKeySet() {
        return this.anInt5012 >= 0;
    }

    public int getKey() {
        return this.anInt5012;
    }

    public void cancelSettingKey() {
        if (this.getState()) {
            this.setState(false);
            this.removeKeyListener(this);
            this.method2827(this.anInt5012);
        }

    }

    private void method2827(int var1) {
        this.anInt5012 = var1;
        if (var1 < 0) {
            this.setLabel(this.aTextManager5011.getShared("Key_NotSet"));
            this.setBackground(aColor5010);
        } else {
            String var2 = this.method2828();
            if (var2 != null) {
                this.setLabel(this.aTextManager5011.getShared("Key_" + var2));
                this.setBackground(aColor5009);
            } else if ((var1 < 65 || var1 > 90) && var1 < 48 && var1 > 57) {
                if (var1 >= 112 && var1 <= 123) {
                    this.setLabel("F" + (var1 - 112 + 1));
                    this.setBackground(aColor5009);
                } else {
                    this.method2827(-1);
                }
            } else {
                this.setLabel("" + (char) var1);
                this.setBackground(aColor5009);
            }
        }
    }

    private String method2828() {
        for (int var1 = 0; var1 < anInt5007; ++var1) {
            if (this.anInt5012 == anIntArray5005[var1]) {
                return aStringArray5006[var1];
            }
        }

        return null;
    }

    static {
        aStringArray5013[0] = "Key_EnterNew";
        aStringArray5013[1] = "Key_";
        aStringArray5013[2] = "Key_NotSet";
        anIntArray5005 = new int[]{38, 40, 37, 39, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 107, 109, 106, 111, 155, 127, 36, 35, 33, 34, 32, 8, 10, 154, 145, 19, 16, 17, 18, 9, 27};
        aStringArray5006 = new String[35];
        aStringArray5006[0] = "ArrowUp";
        aStringArray5006[1] = "ArrowDown";
        aStringArray5006[2] = "ArrowLeft";
        aStringArray5006[3] = "ArrowRight";
        aStringArray5006[4] = "Numpad0";
        aStringArray5006[5] = "Numpad1";
        aStringArray5006[6] = "Numpad2";
        aStringArray5006[7] = "Numpad3";
        aStringArray5006[8] = "Numpad4";
        aStringArray5006[9] = "Numpad5";
        aStringArray5006[10] = "Numpad6";
        aStringArray5006[11] = "Numpad7";
        aStringArray5006[12] = "Numpad8";
        aStringArray5006[13] = "Numpad9";
        aStringArray5006[14] = "Add";
        aStringArray5006[15] = "Subtrack";
        aStringArray5006[16] = "Multiply";
        aStringArray5006[17] = "Divide";
        aStringArray5006[18] = "Insert";
        aStringArray5006[19] = "Delete";
        aStringArray5006[20] = "Home";
        aStringArray5006[21] = "End";
        aStringArray5006[22] = "PageUp";
        aStringArray5006[23] = "PageDown";
        aStringArray5006[24] = "Space";
        aStringArray5006[25] = "BackSpace";
        aStringArray5006[26] = "Enter";
        aStringArray5006[27] = "PrintScreen";
        aStringArray5006[28] = "ScrollLock";
        aStringArray5006[29] = "Pause";
        aStringArray5006[30] = "Shift";
        aStringArray5006[31] = "Control";
        aStringArray5006[32] = "Alt";
        aStringArray5006[33] = "Tab";
        aStringArray5006[34] = "Escape";
        anInt5007 = anIntArray5005.length;
        aColor5008 = new Color(192, 192, 192);
        aColor5009 = new Color(160, 160, 224);
        aColor5010 = new Color(224, 160, 160);
    }

    private static char[] method2829(String var0) {
        char[] var10000 = var0.toCharArray();
        char[] var10001 = var10000;

        while (true) {
            int var10002 = var10001.length;
            var10001 = var10000;
            int var4 = var10002;
            if (var10002 >= 2) {
                break;
            }

            char[] var1 = var10001;
            int var2 = var4;
            var10000 = var1;
            char[] var10003 = var1;
            var10002 = var2;
            var10001 = var10003;
            if (var10002 != 0) {
                var10001 = var10000;
                boolean var3 = false;
                var10003[0] = (char) (var10003[0] ^ 11);
                break;
            }
        }

        return var10001;
    }

    private static String method2830(char[] var0) {
        int var10000 = var0.length;
        int var1 = 0;
        char[] var10001 = var0;
        if (var10000 > 1) {
            var10001 = var0;
            if (var10000 <= var1) {
                return (new String(var0)).intern();
            }
        }

        do {
            char[] var10002 = var10001;
            int var10003 = var1;

            while (true) {
                char var10004 = var10002[var10003];
                byte var10005;
                switch (var1 % 5) {
                    case 0:
                        var10005 = 93;
                        break;
                    case 1:
                        var10005 = 49;
                        break;
                    case 2:
                        var10005 = 107;
                        break;
                    case 3:
                        var10005 = 4;
                        break;
                    default:
                        var10005 = 11;
                }

                var10002[var10003] = (char) (var10004 ^ var10005);
                ++var1;
                if (var10000 != 0) {
                    break;
                }

                var10003 = var10000;
                var10002 = var10001;
            }
        } while (var10000 > var1);

        return (new String(var10001)).intern();
    }
}
