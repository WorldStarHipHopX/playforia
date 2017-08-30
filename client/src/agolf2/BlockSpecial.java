package agolf2;

import java.awt.Image;

public class BlockSpecial extends Block {

    private static final int[] anIntArray3543 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 71, 70, 69, 72, 73, 74, 75, 76, 77, 78, 79, 80};
    private static final int[] anIntArray3544 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 79, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 61, 80};
    private int element;
    private int slope;
    private int anInt3547;


    public BlockSpecial(TrackOverlays var1, int var2, int element, int slope) {
        super(var1, var2);
        this.element = element;
        this.slope = slope;
        if (var2 == 43) {
            this.anInt3547 = 6;
        }

    }

    public String toString() {
        return "BlockSpecial: type=" + this.type + "; element=" + this.element + "; slope=" + this.slope;
    }

    public boolean equals(Object var1) {
        if (var1 == null) {
            return false;
        } else if (var1 == this) {
            return true;
        } else if (var1.getClass() != this.getClass()) {
            return false;
        } else {
            BlockSpecial var2 = (BlockSpecial) ((BlockSpecial) var1);
            int var3 = var2.method1206();
            int var4 = var2.getElement();
            int var5 = var2.getSlope();
            return this.type == var3 && this.element == var4 && this.slope == var5;
        }
    }

    protected static BlockSpecial method1218(BlockSpecial var0) {
        return new BlockSpecial(var0.method1205(), anIntArray3543[var0.method1206()], anIntArray1003[var0.getElement()], anIntArray1005[var0.getSlope()]);
    }

    protected static BlockSpecial method1219(BlockSpecial var0) {
        return new BlockSpecial(var0.method1205(), anIntArray3544[var0.method1206()], anIntArray1004[var0.getElement()], anIntArray1006[var0.getSlope()]);
    }

    protected void method1201() {
        if (!Block.aBooleanArray1007[this.element]) {
            this.slope = 4;
        }

    }

    protected void method1202(StringBuffer var1) {
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.type));
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.element));
        var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(this.slope));
    }

    protected Image method1203(boolean var1, boolean var2) {
        int[] var3 = this.aTrackOverlays_1009.method1229(this.type);
        int[] var4 = this.aTrackOverlays_1009.method1228(this.element);
        int[] var5 = this.aTrackOverlays_1009.method1230(this.slope);
        int[] var6 = new int[225];

        for (int var7 = 0; var7 < 15; ++var7) {
            for (int var8 = 0; var8 < 15; ++var8) {
                int var9 = var7 * 15 + var8;
                if (Class46.method1349(this.type, var8, var7, false, var1)) {
                    var6[var9] = var3[var9];
                } else {
                    var6[var9] = aBooleanArray1007[this.element] ? this.method1210(var4[var9], var5[var9], var1, var2) : var4[var9];
                }
            }
        }

        return this.aTrackOverlays_1009.method1232(var6, 15, 15);
    }

    protected Pixel method1204(int var1, int var2, int var3, int var4, boolean var5) {
        return Class46.method1349(this.type, var3, var4, var5, false) ? new Pixel(var1, var2, this.element, this.slope, this.type) : new Pixel(var1, var2, this.element, this.slope);
    }

    public int getElement() {
        return this.element;
    }

    public int getSlope() {
        return this.slope;
    }

    protected boolean method1222() {
        if (this.anInt3547 > 0) {
            --this.anInt3547;
        }

        return this.anInt3547 <= 0;
    }
}
