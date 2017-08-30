package com.aapeli.client;

import com.aapeli.client.TextManager;
import com.aapeli.colorgui.RadioButton;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyButton extends RadioButton implements KeyListener {

    private static final int[] anIntArray4976;
    private static final String[] aStringArray4977;
    private static final int anInt4978;
    private static final Color aColor4979;
    private static final Color aColor4980;
    private static final Color aColor4981;
    private TextManager aTextManager4982;
    private int anInt4983;
    private static final String[] aStringArray4984 = new String[3];


    public KeyButton(TextManager var1) {
        this(var1, -1);
    }

    public KeyButton(TextManager var1, int var2) {
        this.aTextManager4982 = var1;
        this.method831(var2);
    }

    public void mousePressed(MouseEvent var1) {
        super.mousePressed(var1);
        this.removeKeyListener(this);
        if (this.getState()) {
            this.setLabel(this.aTextManager4982.getShared("Key_EnterNew"));
            this.setBackground(aColor4979);
            this.addKeyListener(this);
        } else {
            this.method831(this.anInt4983);
        }

    }

    public void keyPressed(KeyEvent var1) {
        if (this.getState()) {
            this.method831(var1.getKeyCode());
            this.setState(false);
        }

        this.removeKeyListener(this);
    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public boolean isKeySet() {
        return this.anInt4983 >= 0;
    }

    public int getKey() {
        return this.anInt4983;
    }

    public void cancelSettingKey() {
        if (this.getState()) {
            this.setState(false);
            this.removeKeyListener(this);
            this.method831(this.anInt4983);
        }

    }

    private void method831(int var1) {
        this.anInt4983 = var1;
        if (var1 < 0) {
            this.setLabel(this.aTextManager4982.getShared("Key_NotSet"));
            this.setBackground(aColor4981);
        } else {
            String var2 = this.method832();
            if (var2 != null) {
                this.setLabel(this.aTextManager4982.getShared("Key_" + var2));
                this.setBackground(aColor4980);
            } else if ((var1 < 65 || var1 > 90) && var1 < 48 && var1 > 57) {
                if (var1 >= 112 && var1 <= 123) {
                    this.setLabel("F" + (var1 - 112 + 1));
                    this.setBackground(aColor4980);
                } else {
                    this.method831(-1);
                }
            } else {
                this.setLabel("" + (char) var1);
                this.setBackground(aColor4980);
            }
        }
    }

    private String method832() {
        for (int var1 = 0; var1 < anInt4978; ++var1) {
            if (this.anInt4983 == anIntArray4976[var1]) {
                return aStringArray4977[var1];
            }
        }

        return null;
    }

    static {
        aStringArray4984[0] = "Key_EnterNew";
        aStringArray4984[1] = "Key_";
        aStringArray4984[2] = "Key_NotSet";
        anIntArray4976 = new int[]{38, 40, 37, 39, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 107, 109, 106, 111, 155, 127, 36, 35, 33, 34, 32, 8, 10, 154, 145, 19, 16, 17, 18, 9, 27};
        aStringArray4977 = new String[35];
        aStringArray4977[0] = "ArrowUp";
        aStringArray4977[1] = "ArrowDown";
        aStringArray4977[2] = "ArrowLeft";
        aStringArray4977[3] = "ArrowRight";
        aStringArray4977[4] = "Numpad0";
        aStringArray4977[5] = "Numpad1";
        aStringArray4977[6] = "Numpad2";
        aStringArray4977[7] = "Numpad3";
        aStringArray4977[8] = "Numpad4";
        aStringArray4977[9] = "Numpad5";
        aStringArray4977[10] = "Numpad6";
        aStringArray4977[11] = "Numpad7";
        aStringArray4977[12] = "Numpad8";
        aStringArray4977[13] = "Numpad9";
        aStringArray4977[14] = "Add";
        aStringArray4977[15] = "Subtrack";
        aStringArray4977[16] = "Multiply";
        aStringArray4977[17] = "Divide";
        aStringArray4977[18] = "Insert";
        aStringArray4977[19] = "Delete";
        aStringArray4977[20] = "Home";
        aStringArray4977[21] = "End";
        aStringArray4977[22] = "PageUp";
        aStringArray4977[23] = "PageDown";
        aStringArray4977[24] = "Space";
        aStringArray4977[25] = "BackSpace";
        aStringArray4977[26] = "Enter";
        aStringArray4977[27] = "PrintScreen";
        aStringArray4977[28] = "ScrollLock";
        aStringArray4977[29] = "Pause";
        aStringArray4977[30] = "Shift";
        aStringArray4977[31] = "Control";
        aStringArray4977[32] = "Alt";
        aStringArray4977[33] = "Tab";
        aStringArray4977[34] = "Escape";
        anInt4978 = anIntArray4976.length;
        aColor4979 = new Color(192, 192, 192);
        aColor4980 = new Color(160, 160, 224);
        aColor4981 = new Color(224, 160, 160);
    }

    private static char[] method833(String var0) {
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
                var10003[0] = (char) (var10003[0] ^ 49);
                break;
            }
        }

        return var10001;
    }

    private static String method834(char[] var0) {
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
                        var10005 = 92;
                        break;
                    case 1:
                        var10005 = 113;
                        break;
                    case 2:
                        var10005 = 36;
                        break;
                    case 3:
                        var10005 = 90;
                        break;
                    default:
                        var10005 = 49;
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
