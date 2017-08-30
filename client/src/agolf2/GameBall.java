package agolf2;

import java.awt.Point;
import java.util.Random;
import java.util.StringTokenizer;

public class GameBall {

    protected static final int[] anIntArray1017 = {13, 17, 9};
    private static final double[] aDoubleArray1018 = {1.0D, 3.0D, 0.4D};
    private static final double[] aDoubleArray1019 = {0.0D, 2.25D, 4.25D, 5.25D, 6.0D, 5.25D, 4.25D, 2.25D, 0.0D, -2.25D, -4.25D, -5.25D, -6.0D, -5.25D, -4.25D, -2.25D};
    private static final double[] aDoubleArray1020 = {-6.0D, -5.25D, -4.25D, -2.25D, 0.0D, 2.25D, 4.25D, 5.25D, 6.0D, 5.25D, 4.25D, 2.25D, 0.0D, -2.25D, -4.25D, -5.25D};
    private static final double[] aDoubleArray1021 = {0.0D, 3.0D, 5.5D, 7.0D, 8.2D, 7.0D, 5.5D, 3.0D, 0.0D, -3.0D, -5.5D, -7.0D, -8.2D, -7.0D, -5.5D, -3.0D};
    private static final double[] aDoubleArray1022 = {-8.2D, -7.0D, -5.5D, -3.0D, 0.0D, 3.0D, 5.5D, 7.0D, 8.2D, 7.0D, 5.5D, 3.0D, 0.0D, -3.0D, -5.5D, -7.0D};
    private static final double[] aDoubleArray1023 = {0.0D, 1.5D, 3.0D, 3.5D, 3.9D, 3.5D, 3.0D, 1.5D, 0.0D, -1.5D, -3.0D, -3.5D, -3.9D, -3.5D, -3.0D, -1.5D};
    private static final double[] aDoubleArray1024 = {-3.9D, -3.5D, -3.0D, -1.5D, 0.0D, 1.5D, 3.0D, 3.5D, 3.9D, 3.5D, 3.0D, 1.5D, 0.0D, -1.5D, -3.0D, -3.5D};
    private static final double[][] aDoubleArrayArray1025 = {aDoubleArray1019, aDoubleArray1021, aDoubleArray1023};
    private static final double[][] aDoubleArrayArray1026 = {aDoubleArray1020, aDoubleArray1022, aDoubleArray1024};
    private static final int[] anIntArray1027 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    protected static final int[] anIntArray1028 = {75, 50, 100};
    protected static final int[] anIntArray1029 = {400, 200, 800};
    private Class43 aClass43_1030;
    protected int anInt1031;
    protected double locationX;
    protected double locationY;
    private double speedX;
    private double speedY;
    private double aimX;
    private double aimY;
    private double aDouble1038;
    private double aDouble1039;
    private double aDouble1040;
    private double aDouble1041;
    private double aDouble1042;
    private double aDouble1043;
    private boolean aBoolean1044;
    private boolean aBoolean1045;
    private Pixel aPixel_1046;
    private Pixel[] aPixelArray1047;
    protected int anInt1048;
    private boolean aBoolean1049;
    private boolean aBoolean1050;
    private boolean aBoolean1051;
    private boolean aBoolean1052;
    private boolean aBoolean1053;
    protected boolean aBoolean1054;
    private int anInt1055;
    private int[] anIntArray1056;
    protected int anInt1057;
    protected int anInt1058;
    protected int anInt1059;
    protected int anInt1060;
    protected int anInt1061;
    protected int anInt1062;
    private int anInt1063;
    private int anInt1064;
    private double aDouble1065;
    private double aDouble1066;
    private double aDouble1067;
    private Point aPoint1068;
    protected boolean aBoolean1069;
    protected boolean aBoolean1070;
    protected boolean aBoolean1071;
    private static final String[] aStringArray1072 = new String[11];


    protected GameBall(Class43 var1, int var2, int var3) {
        this.aClass43_1030 = var1;
        this.anInt1031 = var2;
        this.aPixelArray1047 = new Pixel[16];
        this.anInt1048 = var3 >= 0 ? var3 : 0;
        this.aBoolean1049 = this.aBoolean1050 = this.aBoolean1051 = this.aBoolean1052 = this.aBoolean1054 = this.aBoolean1053 = false;
        this.anInt1055 = -1;
        this.anIntArray1056 = null;
        this.anInt1057 = this.anInt1058 = this.anInt1060 = this.anInt1062 = -1;
        this.aBoolean1069 = false;
        this.aBoolean1044 = this.aBoolean1045 = false;
        this.aBoolean1070 = true;
    }

    public String toString() {
        return "GameBall: location=" + this.locationX + "," + this.locationY + "; speed=" + this.speedX + "," + this.speedY + "; aim=" + this.aimX + "," + this.aimY;
    }

    public void method1235() {
        this.aBoolean1044 = this.aBoolean1045 = false;
        this.aimX = this.aimY = 0.0D;
    }

    public void method1236(int var1, int var2) {
        this.aBoolean1045 = true;
        double[] var3 = this.method1270(var1, var2);
        this.aDouble1038 = var3[0];
        this.aDouble1039 = var3[1];
    }

    public double method1237() {
        return Math.sqrt(this.aDouble1038 * this.aDouble1038 + this.aDouble1039 * this.aDouble1039);
    }

    public void method1238() {
        this.aBoolean1044 = this.aBoolean1045;
        this.aimX = this.aDouble1038;
        this.aimY = this.aDouble1039;
    }

    public void method1239(int var1, int var2) {
        this.aBoolean1044 = true;
        double[] var3 = this.method1270(var1, var2);
        this.aimX = var3[0];
        this.aimY = var3[1];
    }

    public int[] method1240() {
        int var1 = (int) (this.locationX + 0.5D);
        int var2 = (int) (this.locationY + 0.5D);
        return new int[]{var1, var2};
    }

    public int[] method1241() {
        if (!this.aBoolean1045) {
            return null;
        } else {
            int var1 = (int) (this.locationX + this.aDouble1038 + 0.5D);
            int var2 = (int) (this.locationY + this.aDouble1039 + 0.5D);
            return new int[]{var1, var2};
        }
    }

    public void method1242(Random var1) {
        this.anInt1064 = 0;
        this.aDouble1067 = 1.0D;
        this.aDouble1042 = this.locationX;
        this.aDouble1043 = this.locationY;
        if (this.aBoolean1044) {
            double var2 = 0.0034999999999999996D;
            this.speedX = this.aimX * var2;
            this.speedY = this.aimY * var2;
            double var4 = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
            double var6 = 0.0D;
            double var8 = 0.04D;
            double var10;
            double var12;
            if (var4 < var8) {
                var10 = (var4 - var6) / (var8 - var6);
                var10 = (var10 * var10 + var10) * 0.5D;
                var12 = var6 + (var8 - var6) * var10;
                var2 = var12 / var4;
                this.speedX *= var2;
                this.speedY *= var2;
            }

            var10 = 0.05D * var4 / 0.7D;
            var12 = var4 * var10;
            this.speedX += var1.nextDouble() * 2.0D * var12 - var12;
            this.speedY += var1.nextDouble() * 2.0D * var12 - var12;
            this.aPoint1068 = null;
        }
    }

    public void method1243() {
        this.anInt1057 = this.anInt1058 = this.anInt1060 = this.anInt1062 = -1;
        this.speedX = this.speedY = 0.0D;
        this.locationX = (double) ((int) (this.locationX + 0.5D));
        this.locationY = (double) ((int) (this.locationY + 0.5D));
    }

    public boolean method1244() {
        return this.aBoolean1069;
    }

    public void method1245() {
        this.aBoolean1069 = true;
    }

    public void method1246() {
        this.aBoolean1070 = false;
    }

    public boolean method1247() {
        return this.aBoolean1070;
    }

    public void method1248(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ";");
        this.locationX = (double) Integer.parseInt(var2.nextToken());
        this.locationY = (double) Integer.parseInt(var2.nextToken());
        this.aBoolean1069 = var2.nextToken().equals("t");
        this.anInt1048 = Integer.parseInt(var2.nextToken());
    }

    protected void method1249(double var1, double var3) {
        this.locationX = (double) ((int) var1);
        this.locationY = (double) ((int) var3);
        this.aDouble1040 = var1;
        this.aDouble1041 = var3;
    }

    protected void method1250(Random var1, boolean var2) {
        double var3 = 0.7D * (var2 ? 1.0D : 0.5D);
        double var5 = var3 * 0.5D;

        double var7;
        do {
            do {
                this.speedX = var1.nextDouble() * var3 * 2.0D - var3;
                this.speedY = var1.nextDouble() * var3 * 2.0D - var3;
                var7 = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
            } while (var7 < var5);
        } while (var7 >= var3);

    }

    protected void method1251(boolean var1) {
        this.aBoolean1049 = this.aBoolean1051 = this.aBoolean1052 = this.aBoolean1054 = this.aBoolean1053 = false;
        if (var1) {
            this.aBoolean1050 = false;
        }

    }

    protected void method1252(Class52 var1) {
        if (this.aBoolean1070) {
            if (this.anInt1062 == -1) {
                this.locationX += this.speedX;
                this.locationY += this.speedY;
            } else {
                this.locationX += this.aDouble1065;
                this.locationY += this.aDouble1066;
            }

            if (this.anInt1057 >= 0) {
                ++this.anInt1057;
                if (this.anInt1057 >= 500) {
                    this.anInt1057 = -1;
                    if (this.anInt1059 != 1 && this.anInt1059 != 54 + this.anInt1031) {
                        this.locationX = this.aDouble1042;
                        this.locationY = this.aDouble1043;
                    } else {
                        this.aBoolean1069 = true;
                        this.speedX = this.speedY = 0.0D;
                    }
                }
            }

            if (this.anInt1058 >= 0) {
                ++this.anInt1058;
                if (this.method1268()) {
                    if (this.anInt1058 >= 500) {
                        this.anInt1058 = -1;
                    }
                } else if (this.anInt1058 >= 1200) {
                    this.anInt1058 = -1;
                }

                if (this.anInt1058 == -1) {
                    if (this.anInt1059 != 4 && this.anInt1059 != 5) {
                        if (this.anInt1059 != 8 && this.anInt1059 != 9) {
                            this.aBoolean1070 = false;
                        } else {
                            this.locationX = this.aDouble1040;
                            this.locationY = this.aDouble1041;
                        }
                    } else {
                        this.locationX = this.aDouble1042;
                        this.locationY = this.aDouble1043;
                    }

                    this.speedX = this.speedY = 0.0D;
                }
            }

            if (this.anInt1060 >= 0) {
                ++this.anInt1060;
                if (this.anInt1060 >= this.anInt1061) {
                    this.anInt1060 = -1;
                }
            }

            if (this.anInt1062 >= 0) {
                ++this.anInt1062;
                if (this.anInt1062 >= this.anInt1063) {
                    this.anInt1062 = -1;
                }
            }

            this.aBoolean1071 = false;
            if (this.anInt1058 == -1 && this.anInt1062 == -1 && !this.aBoolean1069) {
                if (this.anInt1057 == -1 && this.anInt1060 == -1) {
                    this.aPixel_1046 = this.method1271(var1);
                }

                for (int var2 = 0; var2 < 16; ++var2) {
                    this.aPixelArray1047[var2] = this.method1272(var1, aDoubleArrayArray1025[this.anInt1048][var2], aDoubleArrayArray1026[this.anInt1048][var2]);
                }
            }

        }
    }

    protected boolean method1253() {
        return this.aBoolean1071;
    }

    protected void method1254() {
        if (this.aBoolean1070 && !this.aBoolean1069 && this.anInt1060 < 0 && this.anInt1062 < 0) {
            if (this.anInt1057 >= 0) {
                this.speedX *= 0.95D;
                this.speedY *= 0.95D;
            } else if (this.anInt1058 >= 0) {
                if (this.method1268()) {
                    this.speedX *= 0.85D;
                    this.speedY *= 0.85D;
                } else {
                    this.speedX *= 0.996D;
                    this.speedY *= 0.996D;
                }

            } else {
                int[] var1 = Class50.method1383((int) (this.locationX + 0.5D), (int) (this.locationY + 0.5D));
                boolean var3;
                if (this.anIntArray1056 != null && (var1[0] != this.anIntArray1056[0] || var1[1] != this.anIntArray1056[1])) {
                    int[] var2 = Class50.method1383((int) (this.aDouble1042 + 0.5D), (int) (this.aDouble1043 + 0.5D));
                    var3 = var2[0] == this.anIntArray1056[0] && var2[1] == this.anIntArray1056[1];
                    this.aClass43_1030.method1304(this.anIntArray1056[0], this.anIntArray1056[1], var3);
                    this.anIntArray1056 = null;
                }

                int var7 = this.aPixel_1046.getObject();
                if (this.anIntArray1056 == null && var7 >= 27 && var7 <= 32) {
                    this.anIntArray1056 = var1;
                }

                if ((var7 == 61 || var7 == 79 || var7 == 69 || var7 == 71) && (this.anInt1055 == -1 || this.anInt1055 == var7)) {
                    byte var9;
                    if (var7 == 61) {
                        var9 = 7;
                    } else if (var7 == 79) {
                        var9 = 1;
                    } else if (var7 == 69) {
                        var9 = 5;
                    } else {
                        var9 = 3;
                    }

                    this.method1278(Pixel.aDoubleArray1131[var9], Pixel.aDoubleArray1132[var9]);
                    this.anInt1055 = var7;
                } else {
                    if (this.anInt1055 != -1) {
                        var3 = false;
                        if (this.anInt1055 == 61 && this.speedY < 0.0D) {
                            var3 = true;
                        } else if (this.anInt1055 == 79 && this.speedY > 0.0D) {
                            var3 = true;
                        } else if (this.anInt1055 == 69 && this.speedX < 0.0D) {
                            var3 = true;
                        } else if (this.anInt1055 == 71 && this.speedX > 0.0D) {
                            var3 = true;
                        }

                        if (var3) {
                            this.anInt1061 = (int) ((double) anIntArray1028[this.anInt1048] + Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY) / 0.7D * (double) (anIntArray1029[this.anInt1048] - anIntArray1028[this.anInt1048]));
                            this.anInt1060 = 0;
                        }

                        this.anInt1055 = -1;
                    }

                    int var8 = this.aPixel_1046.getSlope();
                    if (var8 != 4) {
                        this.method1278(Pixel.aDoubleArray1131[var8], Pixel.aDoubleArray1132[var8]);
                        this.aBoolean1049 = true;
                    }

                    int var4 = this.aPixel_1046.getElement();
                    this.aBoolean1054 = var4 == 24 || var4 == 26 || var4 == 27;
                    if (this.anIntArray1056 != null) {
                        var4 = 3;
                    }

                    if (var7 >= 44) {
                        var4 = 0;
                    }

                    double var5 = Pixel.aDoubleArray1128[var4];
                    this.speedX *= var5;
                    this.speedY *= var5;
                    if ((var7 == 1 || var7 >= 54 && var7 <= 59) && this.anInt1048 != 1) {
                        if (this.method1277(var7)) {
                            if (Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY) <= 0.325D) {
                                this.anInt1057 = 0;
                                this.anInt1059 = var7;
                                this.aClass43_1030.method1313("hole");
                            } else {
                                this.speedX *= 0.965D;
                                this.speedY *= 0.965D;
                            }
                        } else {
                            this.speedX *= 0.992D;
                            this.speedY *= 0.992D;
                        }
                    }

                    this.aBoolean1052 = Pixel.method1369(var4);
                    if (this.aBoolean1052 && this.method1279()) {
                        this.anInt1058 = 0;
                        this.anInt1059 = var4;
                        if (this.anInt1059 == 4) {
                            this.aClass43_1030.method1313("water");
                        } else if (this.anInt1059 == 8) {
                            this.aClass43_1030.method1313("acid");
                        } else if (this.anInt1059 == 10) {
                            this.aClass43_1030.method1313("sacid");
                        } else {
                            this.aClass43_1030.method1313("swamp");
                        }
                    }

                }
            }
        }
    }

    protected void method1255(boolean var1) {
        if (this.aBoolean1070 && !this.aBoolean1069 && this.anInt1062 < 0) {
            if (!this.method1276()) {
                double var2 = Class50.method1381(this.speedX, this.speedY);
                double var4 = 0.0625D;

                int var6;
                double var7;
                for (var6 = 0; var6 < 16; ++var6) {
                    var7 = (double) anIntArray1027[var6] * var4;
                    if (this.method1273(this.aPixelArray1047[anIntArray1027[var6]], var7, var2, var1)) {
                        return;
                    }
                }

                for (var6 = 0; var6 < 16; ++var6) {
                    var7 = (double) anIntArray1027[var6] * var4;
                    if (this.method1274(this.aPixelArray1047[anIntArray1027[var6]], var7, var1)) {
                        return;
                    }
                }

            }
        }
    }

    protected void method1256(Point var1, int var2) {
        if (this.aBoolean1070 && !this.aBoolean1069 && this.anInt1057 < 0 && this.anInt1058 < 0 && this.anInt1062 < 0) {
            double var3 = ((double) var1.x + 0.5D) * 15.0D;
            double var5 = ((double) var1.y + 0.5D) * 15.0D;
            double var7 = var3 - this.locationX;
            double var9 = var5 - this.locationY;
            double var11 = Math.sqrt(var7 * var7 + var9 * var9);
            if (var11 > 1.5D && var11 < 100.0D) {
                this.aBoolean1050 = true;
                double var13 = (double) var2 * (1.0D - var11 / 100.0D) * 0.005D / var11;
                var13 *= this.aDouble1067;
                this.method1278(var7 * var13, var9 * var13);
            }
        }
    }

    protected void method1257() {
        if (this.aBoolean1050) {
            if (Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY) < 0.02D) {
                this.aDouble1067 -= 0.001D;
            } else {
                this.aDouble1067 -= 1.0E-4D;
            }

            if (this.aDouble1067 < 0.0D) {
                this.aDouble1067 = 0.0D;
            }
        } else {
            this.aDouble1067 += 0.001D;
            if (this.aDouble1067 > 1.0D) {
                this.aDouble1067 = 1.0D;
            }
        }

    }

    protected boolean method1258() {
        return this.aBoolean1070 && this.anInt1057 == -1 && this.anInt1058 == -1 && this.anInt1060 == -1 && this.anInt1062 == -1 && !this.aBoolean1069;
    }

    protected double getLocationX() {
        return this.locationX;
    }

    protected double getLocationY() {
        return this.locationY;
    }

    protected double getSpeedX() {
        return this.speedX;
    }

    protected double getSpeedY() {
        return this.speedY;
    }

    protected int method1263() {
        return this.anInt1048;
    }

    protected int method1264() {
        return anIntArray1017[this.anInt1048];
    }

    protected double method1265() {
        return aDoubleArray1018[this.anInt1048];
    }

    protected void setSpeed(double speedX, double speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    protected boolean method1267() {
        if (this.anInt1062 == -1 && !this.aBoolean1053) {
            this.aPoint1068 = null;
        }

        if (this.aBoolean1070 && !this.aBoolean1069) {
            if (!this.method1279()) {
                this.anInt1064 = 0;
                return true;
            } else if (this.anInt1057 < 0 && this.anInt1058 < 0 && this.anInt1060 < 0 && this.anInt1062 < 0) {
                ++this.anInt1064;
                return this.anInt1064 >= 1500 ? false : (this.anInt1055 == -1 && !this.aBoolean1049 ? this.aBoolean1050 || this.aBoolean1051 || this.aBoolean1052 : true);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected boolean method1268() {
        return this.anInt1059 == 4 || this.anInt1059 == 8 || this.anInt1059 == 10;
    }

    public void method1269() {
        this.aClass43_1030 = null;
        this.aPixel_1046 = null;
        this.aPixelArray1047 = null;
        this.anIntArray1056 = null;
    }

    private double[] method1270(int var1, int var2) {
        double var3 = (double) var1 - this.locationX;
        double var5 = (double) var2 - this.locationY;
        double var7 = Math.sqrt(var3 * var3 + var5 * var5);
        if (var7 > 200.0D) {
            var7 = 200.0D / var7;
            var3 *= var7;
            var5 *= var7;
        }

        return new double[]{var3, var5};
    }

    private Pixel method1271(Class52 var1) {
        int var2 = (int) (this.locationX + 0.5D);
        int var3 = (int) (this.locationY + 0.5D);
        Pixel var4 = var1.method1396(var2, var3, true);
        if (var4 == null) {
            var4 = new Pixel(0);
        }

        return var4;
    }

    private Pixel method1272(Class52 var1, double var2, double var4) {
        int var6 = (int) (this.locationX + var2 + 0.5D);
        int var7 = (int) (this.locationY + var4 + 0.5D);
        Pixel var8 = var1.method1396(var6, var7, true);
        if (var8 == null) {
            var8 = new Pixel(24);
            this.aBoolean1071 = true;
        }

        return var8;
    }

    private boolean method1273(Pixel var1, double var2, double var4, boolean var6) {
        if (this.anInt1057 < 0 && this.anInt1058 < 0) {
            if (!var1.method1377() && (this.aBoolean1054 || this.anInt1060 >= 0)) {
                return false;
            } else if (!var1.method1376(this.anInt1055 == -1)) {
                return false;
            } else {
                double var7 = Class50.method1382(var2, var4);
                if (var7 >= 0.25D) {
                    return false;
                } else {
                    double var9 = var4 - var2;
                    if (var9 < -0.25D || var9 > 0.25D) {
                        var9 = 1.0D + var4 - var2;
                    }

                    int var11;
                    if (this.anInt1055 == -1) {
                        var11 = var1.getObject();
                        if (var11 == 61 || var11 == 79) {
                            if (var11 == 61 && (var2 >= 0.75D || var2 <= 0.25D)) {
                                return false;
                            }

                            if (var11 == 79 && var2 >= 0.25D && var2 <= 0.75D) {
                                return false;
                            }

                            this.speedX *= 0.95D;
                            this.speedY = -this.speedY * 0.95D;
                            return true;
                        }

                        if (var11 == 69 || var11 == 71) {
                            if (var11 == 69 && var2 > 0.5D) {
                                return false;
                            }

                            if (var11 == 71 && var2 < 0.5D) {
                                return false;
                            }

                            this.speedX = -this.speedX * 0.95D;
                            this.speedY *= 0.95D;
                            return true;
                        }
                    }

                    var11 = var1.getElement();
                    if (var11 == 13 || var11 == 21) {
                        if (var11 == 13 && (var4 > 0.875D || var4 < 0.125D)) {
                            return false;
                        }

                        if (var11 == 21 && var4 > 0.375D && var4 < 0.625D) {
                            return false;
                        }
                    }

                    if (var11 == 18 || var11 == 16) {
                        if (var11 == 18 && var4 > 0.125D && var4 < 0.375D) {
                            return false;
                        }

                        if (var11 == 16 && var4 > 0.625D && var4 < 0.875D) {
                            return false;
                        }
                    }

                    double var12 = (var4 - var9 * 2.0D + 0.25D) * 3.141592653589793D * 2.0D;
                    double var14 = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
                    double var16 = Pixel.aDoubleArray1129[var11];
                    if (var16 > 1.0D) {
                        this.aClass43_1030.method1313("bouncer");
                    }

                    if (var16 > 1.0D && var6) {
                        var16 = 0.95D;
                    }

                    if (var16 == 0.0D) {
                        var16 = 0.95D;
                    }

                    var14 *= var16;
                    if (var14 > 0.7D) {
                        var14 = 0.7D;
                    }

                    this.speedX = Math.cos(var12) * var14;
                    this.speedY = Math.sin(var12) * var14;
                    int var18 = var1.getObject();
                    if (var18 >= 18 && var18 <= 23) {
                        this.aClass43_1030.method1305(var1.getBaseX(), var1.getBaseY(), var18);
                    }

                    byte var19;
                    if (var18 == 42 || var18 == 43) {
                        var19 = 0;
                        byte var20 = 0;
                        double var21 = 0.0625D;
                        double var23 = 0.125D;
                        if (var2 < var21 + var23 * 7.0D && var2 > var21) {
                            if (var2 > var21 && var2 < var21 + var23) {
                                var20 = -1;
                                var19 = 1;
                            } else if (var2 >= var21 + var23 && var2 <= var21 + var23 * 2.0D) {
                                var19 = 1;
                            } else if (var2 > var21 + var23 * 2.0D && var2 < var21 + var23 * 3.0D) {
                                var19 = 1;
                                var20 = 1;
                            } else if (var2 >= var21 + var23 * 3.0D && var2 <= var21 + var23 * 4.0D) {
                                var20 = 1;
                            } else if (var2 > var21 + var23 * 4.0D && var2 < var21 + var23 * 5.0D) {
                                var20 = 1;
                                var19 = -1;
                            } else if (var2 >= var21 + var23 * 5.0D && var2 <= var21 + var23 * 6.0D) {
                                var19 = -1;
                            } else if (var2 > var21 + var23 * 6.0D && var2 < var21 + var23 * 7.0D) {
                                var19 = -1;
                                var20 = -1;
                            }
                        } else {
                            var20 = -1;
                        }

                        if (var19 != 0 || var20 != 0) {
                            int var25 = var1.getBaseX();
                            int var26 = var1.getBaseY();
                            if (this.aClass43_1030.method1308(var25, var26, var19, var20)) {
                                this.speedX *= 0.5D;
                                this.speedY *= 0.5D;
                            }
                        }
                    }

                    var19 = -1;
                    if (var18 == 24) {
                        var19 = 1;
                    } else if (var18 == 25) {
                        var19 = 2;
                    } else if (var18 == 26) {
                        var19 = 0;
                    }

                    if (var19 >= 0 && var19 != this.anInt1048) {
                        this.aClass43_1030.method1313("sizechange");
                        this.anInt1048 = var19;
                    }

                    return true;
                }
            }
        } else {
            return false;
        }
    }

    private boolean method1274(Pixel var1, double var2, boolean var4) {
        if (this.anInt1058 < 0 && this.anInt1060 < 0) {
            int var5 = var1.getObject();
            if (var5 == 1 || var5 >= 54 && var5 <= 59) {
                double var6 = (var2 - 0.25D) * 3.141592653589793D * 2.0D;
                this.method1278(Math.cos(var6) * 1.5E-4D, Math.sin(var6) * 1.5E-4D);
                this.aBoolean1051 = true;
            }

            if (this.anInt1057 >= 0) {
                return false;
            } else {
                if (!var4 && var5 >= 63 && var5 <= 68) {
                    int var8 = var1.getBaseX();
                    int var9 = var1.getBaseY();
                    if (!this.method1275(var8, var9)) {
                        Point var10 = this.aClass43_1030.method1306(this, var5 - 63, var8, var9);
                        if (var10 != null) {
                            double var11 = ((double) var10.x + 0.5D) * 15.0D;
                            double var13 = ((double) var10.y + 0.5D) * 15.0D;
                            double var15 = var11 - this.locationX;
                            double var17 = var13 - this.locationY;
                            this.anInt1063 = (int) (500.0D + 1250.0D * Math.sqrt(var15 * var15 + var17 * var17) / Class50.aDouble1141);
                            this.aDouble1065 = var15 / (double) this.anInt1063;
                            this.aDouble1066 = var17 / (double) this.anInt1063;
                            this.anInt1062 = 0;
                            this.aPoint1068 = var10;
                            this.aClass43_1030.method1313("teleport");
                            return true;
                        }
                    }

                    this.aBoolean1053 = true;
                }

                return false;
            }
        } else {
            return false;
        }
    }

    private boolean method1275(int var1, int var2) {
        return this.aPoint1068 == null ? false : var1 == this.aPoint1068.x && var2 == this.aPoint1068.y;
    }

    private boolean method1276() {
        if (this.anInt1057 < 0 && this.anInt1058 < 0 && this.anInt1060 < 0) {
            int var1 = this.aPixel_1046.getObject();
            if (var1 != 10 && var1 != 9) {
                if (var1 != 13 && var1 != 12) {
                    return false;
                } else {
                    this.aClass43_1030.method1307(this.aPixel_1046.getBaseX(), this.aPixel_1046.getBaseY(), true, this);
                    return true;
                }
            } else {
                this.aClass43_1030.method1307(this.aPixel_1046.getBaseX(), this.aPixel_1046.getBaseY(), false, this);
                return true;
            }
        } else {
            return false;
        }
    }

    private boolean method1277(int var1) {
        byte var2 = 13;
        int var3 = 0;

        for (int var4 = 0; var4 < 16; ++var4) {
            if (this.aPixelArray1047[var4].getObject() == var1) {
                ++var3;
            }
        }

        return var3 >= var2;
    }

    private void method1278(double var1, double var3) {
        this.speedX += var1;
        this.speedY += var3;
        double var5 = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
        if (var5 > 0.7D) {
            double var7 = 0.7D / var5;
            this.speedX *= var7;
            this.speedY *= var7;
        }

    }

    private boolean method1279() {
        return Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY) < 0.01D;
    }
}
