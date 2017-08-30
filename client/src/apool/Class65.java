package apool;

class Class65 {

    private SynchronizedInt aSynchronizedInt_1233;
    private SynchronizedBool aSynchronizedBool_1234;
    private double aDouble1235;
    private double aDouble1236;
    private double aDouble1237;
    private double aDouble1238;
    private double aDouble1239;
    private SynchronizedBool aSynchronizedBool_1240;
    private double aDouble1241;
    private double aDouble1242;
    private boolean aBoolean1243;
    private double aDouble1244;
    private double aDouble1245;
    private double aDouble1246;
    private double aDouble1247;
    private double aDouble1248;


    protected Class65(int var1, double var2) {
        this.aSynchronizedInt_1233 = new SynchronizedInt(var1);
        this.aSynchronizedBool_1234 = new SynchronizedBool();
        this.aSynchronizedBool_1240 = new SynchronizedBool();
        this.aDouble1239 = var2;
    }

    protected int method1481() {
        return this.aSynchronizedInt_1233.method1467();
    }

    protected boolean method1482() {
        return this.aSynchronizedBool_1234.method1460();
    }

    protected double method1483() {
        return this.aDouble1235;
    }

    protected double method1484() {
        return this.aDouble1236;
    }

    protected int method1485() {
        return (int) (this.aDouble1235 + 0.5D);
    }

    protected int method1486() {
        return (int) (this.aDouble1236 + 0.5D);
    }

    protected double method1487() {
        return this.aDouble1237;
    }

    protected double method1488() {
        return this.aDouble1238;
    }

    protected double method1489() {
        return Math.sqrt(this.aDouble1237 * this.aDouble1237 + this.aDouble1238 * this.aDouble1238);
    }

    protected double method1490() {
        return this.aDouble1239;
    }

    protected void method1491(double var1, double var3) {
        this.method1492(true);
        this.method1493(var1, var3);
    }

    protected void method1492(boolean var1) {
        this.aSynchronizedBool_1234.method1459(var1);
    }

    protected void method1493(double var1, double var3) {
        this.aDouble1235 = var1;
        this.aDouble1236 = var3;
    }

    protected void method1494(double var1, double var3) {
        this.aDouble1237 = var1;
        this.aDouble1238 = var3;
    }

    protected void method1495() {
        this.aSynchronizedBool_1240.method1459(this.aSynchronizedBool_1234.method1460());
        this.aDouble1241 = this.aDouble1235;
        this.aDouble1242 = this.aDouble1236;
    }

    protected void method1496() {
        this.aSynchronizedBool_1234.method1459(this.aSynchronizedBool_1240.method1460());
        this.aDouble1235 = this.aDouble1241;
        this.aDouble1236 = this.aDouble1242;
    }

    protected void method1497(boolean var1, double var2, double var4, double var6) {
        if (this.aSynchronizedBool_1234.method1460() && this.aBoolean1243) {
            if (var1) {
                this.aDouble1237 += var2 / var6;
                this.aDouble1238 += var4 / var6;
            }

            this.aDouble1235 += this.aDouble1237 / var6;
            this.aDouble1236 += this.aDouble1238 / var6;
        }
    }

    protected void method1498() {
        this.aDouble1237 *= 0.912D;
        this.aDouble1238 *= 0.912D;
    }

    protected void method1499(boolean[] var1) {
        if (var1[8] && var1[1] && var1[2]) {
            var1[8] = var1[2] = false;
        }

        if (var1[2] && var1[3] && var1[4]) {
            var1[2] = var1[4] = false;
        }

        if (var1[4] && var1[5] && var1[6]) {
            var1[4] = var1[6] = false;
        }

        if (var1[6] && var1[7] && var1[8]) {
            var1[6] = var1[8] = false;
        }

        if (var1[2]) {
            var1[2] = this.aDouble1237 > 0.0D && this.aDouble1238 < 0.0D || this.aDouble1237 < 0.0D && this.aDouble1238 < 0.0D && -this.aDouble1238 > -this.aDouble1237 || this.aDouble1237 > 0.0D && this.aDouble1238 > 0.0D && this.aDouble1237 > this.aDouble1238;
        }

        if (var1[4]) {
            var1[4] = this.aDouble1237 > 0.0D && this.aDouble1238 > 0.0D || this.aDouble1237 > 0.0D && this.aDouble1238 < 0.0D && this.aDouble1237 > -this.aDouble1238 || this.aDouble1237 < 0.0D && this.aDouble1238 > 0.0D && this.aDouble1238 > -this.aDouble1237;
        }

        if (var1[6]) {
            var1[6] = this.aDouble1237 < 0.0D && this.aDouble1238 > 0.0D || this.aDouble1237 > 0.0D && this.aDouble1238 > 0.0D && this.aDouble1238 > this.aDouble1237 || this.aDouble1237 < 0.0D && this.aDouble1238 < 0.0D && -this.aDouble1237 > -this.aDouble1238;
        }

        if (var1[8]) {
            var1[8] = this.aDouble1237 < 0.0D && this.aDouble1238 < 0.0D || this.aDouble1237 < 0.0D && this.aDouble1238 > 0.0D && -this.aDouble1237 > this.aDouble1238 || this.aDouble1237 > 0.0D && this.aDouble1238 < 0.0D && -this.aDouble1238 > this.aDouble1237;
        }

        if (var1[1]) {
            var1[1] = this.aDouble1238 < 0.0D;
        }

        if (var1[5]) {
            var1[5] = this.aDouble1238 > 0.0D;
        }

        if (var1[3]) {
            var1[3] = this.aDouble1237 > 0.0D;
        }

        if (var1[7]) {
            var1[7] = this.aDouble1237 < 0.0D;
        }

        if (var1[2] || var1[4] || var1[6] || var1[8]) {
            var1[1] = var1[3] = var1[5] = var1[7] = false;
        }

    }

    protected void method1500(boolean[] var1) {
        if (var1[1] || var1[5]) {
            this.aDouble1238 = -this.aDouble1238;
        }

        if (var1[3] || var1[7]) {
            this.aDouble1237 = -this.aDouble1237;
        }

        double var2;
        if (var1[2] || var1[6]) {
            var2 = this.aDouble1237;
            this.aDouble1237 = this.aDouble1238;
            this.aDouble1238 = var2;
        }

        if (var1[4] || var1[8]) {
            var2 = this.aDouble1237;
            this.aDouble1237 = -this.aDouble1238;
            this.aDouble1238 = -var2;
        }

        this.aDouble1237 *= 0.81D;
        this.aDouble1238 *= 0.81D;
    }

    protected void method1501(double var1, double var3) {
        if (this.aSynchronizedBool_1234.method1460() && this.aBoolean1243) {
            double var5 = var1 + (1.0D - var1) * (0.75D * this.method1489() / var3);
            this.aDouble1237 *= var5;
            this.aDouble1238 *= var5;
        }
    }

    protected int[] method1502() {
        int var1 = this.method1485();
        int var2 = this.method1486();
        this.aDouble1235 = (double) var1;
        this.aDouble1236 = (double) var2;
        return new int[]{var1, var2};
    }

    protected void method1503(int var1, int var2) {
        if (this.aDouble1235 < (double) (var1 - 3)) {
            this.aDouble1235 += 0.85D;
        }

        if (this.aDouble1235 > (double) (var1 + 3)) {
            this.aDouble1235 -= 0.85D;
        }

        if (this.aDouble1236 < (double) (var2 - 3)) {
            this.aDouble1236 += 0.85D;
        }

        if (this.aDouble1236 > (double) (var2 + 3)) {
            this.aDouble1236 -= 0.85D;
        }

    }

    protected void method1504(double var1, boolean[] var3) {
        double var4 = this.aDouble1237 != 0.0D ? Math.atan(this.aDouble1238 / this.aDouble1237) : (double) (this.aDouble1238 < 0.0D ? -1 : 1) * 3.141592653589793D * 0.5D;
        if (this.aDouble1237 < 0.0D) {
            var4 += 3.141592653589793D;
        }

        double var6 = this.method1519(var3);
        var4 -= var1 * 0.8975979010256552D * (var6 / 1.5707963267948966D);
        double var8 = this.method1489();
        this.aDouble1237 = Math.cos(var4) * var8;
        this.aDouble1238 = Math.sin(var4) * var8;
    }

    protected void method1505(boolean var1) {
        this.aBoolean1243 = var1;
        this.aDouble1248 = 0.0D;
    }

    protected void method1506() {
        this.aDouble1244 = this.aDouble1235;
        this.aDouble1245 = this.aDouble1236;
    }

    protected void method1507() {
        this.aDouble1246 = this.aDouble1237;
        this.aDouble1247 = this.aDouble1238;
    }

    protected void method1508() {
        this.aBoolean1243 = true;
    }

    protected boolean method1509() {
        return this.aBoolean1243;
    }

    protected boolean method1510() {
        return this.aSynchronizedBool_1234.method1460() && this.aBoolean1243;
    }

    protected boolean method1511() {
        return this.aSynchronizedBool_1234.method1460() && this.aDouble1248 == 0.0D;
    }

    protected double method1512() {
        return this.aDouble1246;
    }

    protected double method1513() {
        return this.aDouble1247;
    }

    protected void method1514() {
        this.aDouble1248 = 0.01D;
        this.aDouble1237 = this.aDouble1238 = 0.0D;
    }

    protected boolean method1515() {
        return this.aDouble1248 > 0.0D;
    }

    protected double method1516() {
        return this.aDouble1248;
    }

    protected void method1517(double var1) {
        if (this.method1510() && this.method1515()) {
            if (this.aDouble1248 < var1) {
                this.aDouble1248 += 0.18D;
            }

        }
    }

    protected boolean method1518(double var1, double var3) {
        if (this.aSynchronizedBool_1234.method1460() && this.aBoolean1243) {
            if (this.aDouble1248 > 0.0D && this.aDouble1248 < var1) {
                return true;
            } else if (this.method1489() >= var3) {
                return true;
            } else {
                this.aDouble1237 = this.aDouble1238 = 0.0D;
                return false;
            }
        } else {
            return false;
        }
    }

    private double method1519(boolean[] var1) {
        double var2 = this.aDouble1235 + this.aDouble1237;
        double var4 = this.aDouble1236 + this.aDouble1238;
        double var6 = 0.0D;
        double var8 = 0.0D;
        if (var1[2] || var1[3] || var1[4]) {
            var6 = this.aDouble1235 + 1.0D;
        }

        if (var1[6] || var1[7] || var1[8]) {
            var6 = this.aDouble1235 - 1.0D;
        }

        if (var1[4] || var1[5] || var1[6]) {
            var8 = this.aDouble1236 + 1.0D;
        }

        if (var1[8] || var1[1] || var1[2]) {
            var8 = this.aDouble1236 - 1.0D;
        }

        double var10 = this.aDouble1235 - var2 == 0.0D ? (this.aDouble1236 - var4 < 0.0D ? Double.MIN_VALUE : Double.MAX_VALUE) : (this.aDouble1236 - var4) / (this.aDouble1235 - var2);
        double var12 = this.aDouble1235 - var6 == 0.0D ? (this.aDouble1236 - var8 < 0.0D ? Double.MIN_VALUE : Double.MAX_VALUE) : (this.aDouble1236 - var8) / (this.aDouble1235 - var6);
        return var10 * var12 == -1.0D ? 1.5707963267948966D : Math.atan(Math.abs((var10 - var12) / (1.0D + var10 * var12)));
    }
}
