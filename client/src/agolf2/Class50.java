package agolf2;


public class Class50 {

    public static final double aDouble1141 = Math.sqrt(784800.0D);


    public static double method1381(double var0, double var2) {
        return var0 == 0.0D ? (var2 < 0.0D ? 0.0D : 0.5D) : (var0 < 0.0D ? 0.75D : 0.25D) + Math.atan(var2 / var0) / 6.283185307179586D;
    }

    public static double method1382(double var0, double var2) {
        double var4 = Math.abs(var0 - var2);
        if (var4 > 0.5D) {
            var4 = 1.0D - var4;
        }

        return var4;
    }

    public static int[] method1383(int var0, int var1) {
        if (var0 >= 0 && var1 >= 0 && var0 < 780 && var1 < 420) {
            int var2 = var0 / 15;
            int var3 = var1 / 15;
            return new int[]{var2, var3};
        } else {
            return null;
        }
    }

    public static int method1384(int var0, double var1) {
        var0 = (int) ((double) var0 * var1 + 0.5D);
        if (var0 < 0) {
            var0 = 0;
        }

        if (var0 > 255) {
            var0 = 255;
        }

        return var0;
    }

    public static int method1385(int var0, int var1) {
        var0 += var1;
        if (var0 < 0) {
            var0 = 0;
        }

        if (var0 > 255) {
            var0 = 255;
        }

        return var0;
    }

}
