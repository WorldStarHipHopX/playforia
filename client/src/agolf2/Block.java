package agolf2;

import java.awt.Image;

public abstract class Block {

    protected static final int[] anIntArray1003 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 22, 21, 20, 23, 24, 25, 26, 27};
    protected static final int[] anIntArray1004 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 21, 14, 15, 16, 17, 18, 19, 20, 13, 22, 23, 24, 25, 26, 27};
    protected static final int[] anIntArray1005 = new int[]{2, 1, 0, 5, 4, 3, 8, 7, 6};
    protected static final int[] anIntArray1006 = new int[]{6, 7, 8, 3, 4, 5, 0, 1, 2};
    public static final boolean[] aBooleanArray1007 = new boolean[]{true, true, true, true, false, true, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    protected static final String aString1008 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.";
    protected TrackOverlays aTrackOverlays_1009;
    protected int type;
    private Image anImage1011;
    public static int anInt1012;


    protected Block(TrackOverlays var1, int var2) {
        this.aTrackOverlays_1009 = var1;
        this.type = var2;
    }

    protected static Block method1198(TrackOverlays var0, String var1) {
        int var2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".indexOf(var1.charAt(0));
        int var3 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".indexOf(var1.charAt(1));
        int var4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".indexOf(var1.charAt(2));
        if (var1.length() == 5) {
            int var5 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".indexOf(var1.charAt(3));
            int var6 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".indexOf(var1.charAt(4));
            return new BlockBasic(var0, var2, var3, var4, var5, var6);
        } else {
            return new BlockSpecial(var0, var2, var3, var4);
        }
    }

    protected static Block method1199(Block var0) {
        return (Block) (var0 instanceof BlockBasic ? BlockBasic.method1212((BlockBasic) ((BlockBasic) var0)) : BlockSpecial.method1218((BlockSpecial) ((BlockSpecial) var0)));
    }

    protected static Block method1200(Block var0) {
        return (Block) (var0 instanceof BlockBasic ? BlockBasic.method1213((BlockBasic) ((BlockBasic) var0)) : BlockSpecial.method1219((BlockSpecial) ((BlockSpecial) var0)));
    }

    public abstract boolean equals(Object var1);

    protected abstract void method1201();

    protected abstract void method1202(StringBuffer var1);

    protected abstract Image method1203(boolean var1, boolean var2);

    protected abstract Pixel method1204(int var1, int var2, int var3, int var4, boolean var5);

    protected TrackOverlays method1205() {
        return this.aTrackOverlays_1009;
    }

    public int method1206() {
        return this.type;
    }

    public Image method1207() {
        return this.method1208(false, false);
    }

    public Image method1208(boolean var1, boolean var2) {
        if (this.anImage1011 == null) {
            this.anImage1011 = this.method1203(var1, var2);
        }

        return this.anImage1011;
    }

    protected void method1209() {
        this.anImage1011 = null;
    }

    protected int method1210(int var1, int var2, boolean var3, boolean var4) {
        int var5 = (var1 & 16711680) >> 16;
        int var6 = (var1 & '\uff00') >> 8;
        int var7 = var1 & 255;
        int var8 = (var2 & 16711680) >> 16;
        int var9 = (var2 & '\uff00') >> 8;
        int var10 = var2 & 255;
        if (!var4) {
            if (var3) {
                var5 = Class50.method1385(var5, var8 / 2 - 64);
                var6 = Class50.method1385(var6, var9 / 2 - 64);
                var7 = Class50.method1385(var7, var10 / 2 - 64);
            } else {
                var5 = Class50.method1385(var5, var8 - 128);
                var6 = Class50.method1385(var6, var9 - 128);
                var7 = Class50.method1385(var7, var10 - 128);
            }
        } else if (var8 == 0 && var9 == 0 && var10 == 0) {
            var5 = Class50.method1385(var5, -32);
            var6 = Class50.method1385(var6, -32);
            var7 = Class50.method1385(var7, -32);
        } else if (var8 == 255 && var9 == 255 && var10 == 255) {
            var5 = Class50.method1385(var5, 32);
            var6 = Class50.method1385(var6, 32);
            var7 = Class50.method1385(var7, 32);
        }

        return (int) (4278190080L + (long) var5 * 256L * 256L + (long) var6 * 256L + (long) var7);
    }

    protected void method1211() {
        this.aTrackOverlays_1009 = null;
        this.anImage1011 = null;
    }

}
