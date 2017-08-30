package agolf2;

import java.awt.Image;

public class BlockBasic extends Block {

    private static final int[] anIntArray3536 = {0, 1, 2, 4, 3, 5, 7, 6, 8, 9, 10, 11,
            13, 12, 14, 16, 15, 17, 20, 19, 18, 21, 22, 23, 24, 25, 26, 29, 28, 27, 32,
            31, 30, 35, 34, 33, 38, 37, 36, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
            50, 51, 52, 53, 54, 56, 55, 59, 58, 57, 62, 61, 60, -1, 65, 64, 66, 67, 68,
            69, 70, 71};
    private static final int[] anIntArray3537 = {0, 1, 2, 12, 13, 5, 15, 16, 8, 9, 10,
            11, 3, 4, 14, 6, 7, 17, 36, 37, 38, 21, 40, 23, 24, 43, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 18, 19, 20, 39, 22, 41, 42, 25, 44, 45, 46, 47, 48, 67,
            50, 51, 70, 53, -1, 64, 65, 57, 58, 59, 60, 61, 62, 63, 55, 56, 66, 49, 68,
            69, 52, 71};
    private int elements1;//elementX
    private int elements2;//elementY
    private int slopes1;//slopeX       ?????????????????
    private int slopes2;//slopeY
    private static final String[] aStringArray3542 = new String[4];


    public BlockBasic(TrackOverlays var1) {
        this(var1, 0, 0, 0, 4, 4);
    }

    public BlockBasic(TrackOverlays var1, int var2, int elements1, int elements2, int slopes1, int slopes2) {
        super(var1, var2);
        this.elements1 = elements1;
        this.elements2 = elements2;
        this.slopes1 = slopes1;
        this.slopes2 = slopes2;
    }

    public String toString() {
        return "BlockBasic: type=" + this.type + "; elements=" + this.elements1 + "," + this.elements2 + "; slopes=" + this.slopes1 + "," + this.slopes2;
    }

    public boolean equals(Object var1) {
        if (var1 == null) {
            return false;
        } else if (var1 == this) {
            return true;
        } else if (var1.getClass() != this.getClass()) {
            return false;
        } else {
            BlockBasic var2 = (BlockBasic) ((BlockBasic) var1);
            int var3 = var2.method1206();
            int var4 = var2.getElements1();
            int var5 = var2.getElements2();
            int var6 = var2.getSlopes1();
            int var7 = var2.getSlopes2();
            return this.type == var3 && this.elements1 == var4 && this.elements2 == var5 && this.slopes1 == var6 && this.slopes2 == var7 ? true : (this.elements1 == this.elements2 && var4 == var5 && this.elements1 == var4 && this.slopes1 == this.slopes2 && var6 == var7 && this.slopes1 == var6 ? true : ((this.type == 0 && var3 == 1 || this.type == 1 && var3 == 0) && this.elements1 == var5 && this.elements2 == var4 && this.slopes1 == var7 && this.slopes2 == var6 ? true : (this.type == 0 && this.elements2 == var4 && this.elements2 == var5 && this.slopes2 == var6 && this.slopes2 == var7 ? true : (this.type == 1 && this.elements1 == var4 && this.elements1 == var5 && this.slopes1 == var6 && this.slopes1 == var7 ? true : (var3 == 0 && var5 == this.elements1 && var5 == this.elements2 && var7 == this.slopes1 && var7 == this.slopes2 ? true : var3 == 1 && var4 == this.elements1 && var4 == this.elements2 && var6 == this.slopes1 && var6 == this.slopes2)))));
        }
    }

    protected static BlockBasic method1212(BlockBasic var0) {
        int var1 = anIntArray3536[var0.method1206()];
        int var2 = anIntArray1003[var0.getElements1()];
        int var3 = anIntArray1003[var0.getElements2()];
        int var4 = anIntArray1005[var0.getSlopes1()];
        int var5 = anIntArray1005[var0.getSlopes2()];
        return var1 == -1 ? new BlockBasic(var0.method1205(), var0.method1206(), var3, var2, var5, var4) : new BlockBasic(var0.method1205(), var1, var2, var3, var4, var5);
    }

    protected static BlockBasic method1213(BlockBasic var0) {
        int var1 = anIntArray3537[var0.method1206()];
        int var2 = anIntArray1004[var0.getElements1()];
        int var3 = anIntArray1004[var0.getElements2()];
        int var4 = anIntArray1006[var0.getSlopes1()];
        int var5 = anIntArray1006[var0.getSlopes2()];
        return var1 == -1 ? new BlockBasic(var0.method1205(), var0.method1206(), var3, var2, var5, var4) : new BlockBasic(var0.method1205(), var1, var2, var3, var4, var5);
    }

    protected void method1201() {
        if (this.type != 0 && this.type != 1 && this.elements1 == this.elements2 && this.slopes1 == this.slopes2) {
            this.type = 0;
        } else if (this.type == 0) {
            this.elements1 = this.elements2;
            this.slopes1 = this.slopes2;
        } else if (this.type == 1) {
            this.elements2 = this.elements1;
            this.slopes2 = this.slopes1;
        }

        if (!Block.aBooleanArray1007[this.elements1]) {
            this.slopes1 = 4;
        }

        if (!Block.aBooleanArray1007[this.elements2]) {
            this.slopes2 = 4;
        }

    }

    protected void method1202(StringBuffer var1) {
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.type));
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.elements1));
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.elements2));
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.slopes1));
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.slopes2));
    }

    protected Image method1203(boolean var1, boolean var2) {
        int[] var3 = this.aTrackOverlays_1009.method1228(this.elements1);
        int[] var4 = this.aTrackOverlays_1009.method1228(this.elements2);
        int[] var5 = this.aTrackOverlays_1009.method1230(this.slopes1);
        int[] var6 = this.aTrackOverlays_1009.method1230(this.slopes2);
        int[] var7 = new int[225];

        for (int var8 = 0; var8 < 15; ++var8) {
            for (int var9 = 0; var9 < 15; ++var9) {
                int var10 = var8 * 15 + var9;
                if (Class46.method1348(this.type, var9, var8)) {
                    var7[var10] = aBooleanArray1007[this.elements1] ? this.method1210(var3[var10], var5[var10], var1, var2) : var3[var10];
                } else {
                    var7[var10] = aBooleanArray1007[this.elements2] ? this.method1210(var4[var10], var6[var10], var1, var2) : var4[var10];
                }
            }
        }

        return this.aTrackOverlays_1009.method1232(var7, 15, 15);
    }

    protected Pixel method1204(int var1, int var2, int var3, int var4, boolean var5) {
        boolean var6 = Class46.method1348(this.type, var3, var4);
        return new Pixel(var1, var2, var6 ? this.elements1 : this.elements2, var6 ? this.slopes1 : this.slopes2);
    }

    public int getElements1() {
        return this.elements1;
    }

    public int getElements2() {
        return this.elements2;
    }

    public int getSlopes1() {
        return this.slopes1;
    }

    public int getSlopes2() {
        return this.slopes2;
    }
}
