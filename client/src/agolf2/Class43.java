package agolf2;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

public class Class43 {

    private static final int[] anIntArray1081;
    private static final int[] anIntArray1082;
    protected TrackOverlays aTrackOverlays_1083;
    private Class52 aClass52_1084;
    protected int anInt1085;
    private boolean aBoolean1086;
    protected GameBall[] aGameBallArray1087;
    private Vector[] aVectorArray1088;
    private boolean aBoolean1089;
    private Vector[] aVectorArray1090;
    private Vector aVector1091;
    private Vector aVector1092;
    private Random aRandom1093;
    private int anInt1094;
    private boolean aBoolean1095;
    private boolean aBoolean1096;
    private static final String[] aStringArray1097 = new String[2];


    public Class43(TrackOverlays var1, Class52 var2, int var3, boolean var4, boolean var5) {
        this.aTrackOverlays_1083 = var1;
        this.aClass52_1084 = var2;
        this.anInt1085 = var3;
        this.aBoolean1086 = var4;
        this.aBoolean1096 = var5;
    }

    public void method1297(Random var1, int var2) {
        this.method1303(var2);

        int var3;
        for (var3 = 0; var3 < this.anInt1085; ++var3) {
            this.method1314(var3, var1);
        }

        this.aVectorArray1088 = new Vector[6];
        this.aVectorArray1090 = new Vector[6];

        for (var3 = 0; var3 < 6; ++var3) {
            this.aVectorArray1088[var3] = new Vector();
            this.aVectorArray1090[var3] = new Vector();
        }

        this.aBoolean1089 = false;
        this.method1315();
        this.aVector1091 = new Vector();
        this.aVector1092 = new Vector();
        this.method1316();
    }

    public void method1298(Random var1) {
        this.aRandom1093 = var1;

        for (int var2 = 0; var2 < this.anInt1085; ++var2) {
            this.aGameBallArray1087[var2].method1242(var1);
        }

        this.anInt1094 = 0;
        this.aBoolean1095 = false;
    }

    public boolean method1299() {
        boolean var1 = this.anInt1094 % 5 == 0;
        boolean var2 = this.anInt1094 % 25 == 0;
        boolean var3 = this.anInt1094 >= '\u88b8';
        ++this.anInt1094;

        int var4;
        for (var4 = 0; var4 < this.anInt1085; ++var4) {
            this.aGameBallArray1087[var4].method1251(var1);
        }

        for (var4 = 0; var4 < this.anInt1085; ++var4) {
            this.aGameBallArray1087[var4].method1252(this.aClass52_1084);
        }

        if (this.aBoolean1096 && this.aGameBallArray1087[0].method1263() == 1 && this.aGameBallArray1087[0].method1253()) {
            this.aGameBallArray1087[0].method1245();
            return true;
        } else {
            int var5;
            if (this.anInt1085 > 1 && this.aBoolean1086) {
                for (var4 = 0; var4 < this.anInt1085; ++var4) {
                    if (this.aGameBallArray1087[var4].method1258()) {
                        for (var5 = var4 + 1; var5 < this.anInt1085; ++var5) {
                            if (this.aGameBallArray1087[var5].method1258()) {
                                this.method1322(this.aGameBallArray1087[var4], this.aGameBallArray1087[var5]);
                            }
                        }
                    }
                }
            }

            for (var4 = 0; var4 < this.anInt1085; ++var4) {
                this.aGameBallArray1087[var4].method1254();
            }

            for (var4 = 0; var4 < this.anInt1085; ++var4) {
                this.aGameBallArray1087[var4].method1255(var3);
            }

            if (var1 && !var3) {
                for (var4 = 0; var4 < this.anInt1085; ++var4) {
                    for (var5 = 0; var5 < this.aVector1091.size(); ++var5) {
                        this.aGameBallArray1087[var4].method1256((Point) this.aVector1091.elementAt(var5), 1);
                    }

                    for (var5 = 0; var5 < this.aVector1092.size(); ++var5) {
                        this.aGameBallArray1087[var4].method1256((Point) this.aVector1092.elementAt(var5), -1);
                    }

                    this.aGameBallArray1087[var4].method1257();
                }
            }

            if (var2) {
                this.aBoolean1095 = this.method1319();
            }

            if (this.anInt1094 >= '\uafc8') {
                return true;
            } else if (this.aBoolean1095) {
                return false;
            } else {
                for (var4 = 0; var4 < this.anInt1085; ++var4) {
                    if (this.aGameBallArray1087[var4].method1267()) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public void method1300() {
        for (int var1 = 0; var1 < this.anInt1085; ++var1) {
            this.aGameBallArray1087[var1].method1243();
        }

    }

    public boolean method1301() {
        for (int var1 = 0; var1 < this.anInt1085; ++var1) {
            if (!this.aGameBallArray1087[var1].method1244()) {
                return false;
            }
        }

        return true;
    }

    public void method1302() {
        this.aTrackOverlays_1083 = null;
        this.aClass52_1084 = null;

        for (int var1 = 0; var1 < this.anInt1085; ++var1) {
            this.aGameBallArray1087[var1].method1269();
        }

        this.aGameBallArray1087 = null;
        this.aVectorArray1088 = null;
        this.aVector1091 = null;
        this.aVector1092 = null;
        this.aRandom1093 = null;
    }

    protected void method1303(int var1) {
        this.aGameBallArray1087 = new GameBall[this.anInt1085];

        for (int var2 = 0; var2 < this.anInt1085; ++var2) {
            this.aGameBallArray1087[var2] = new GameBall(this, var2, var1);
        }

    }

    protected void method1304(int var1, int var2, boolean var3) {
        Block var4 = this.aClass52_1084.method1394(var1, var2);
        int var5 = var4.method1206();
        if (var5 == 32) {
            if (!var3) {
                this.method1309(var1, var2);
            }
        } else {
            this.method1310(var1, var2, var5 + 1);
        }

    }

    protected void method1305(int var1, int var2, int var3) {
        if (var3 == 23) {
            this.method1309(var1, var2);
        } else {
            this.method1310(var1, var2, var3 + 1);
        }

    }

    protected Point method1306(GameBall var1, int var2, int var3, int var4) {
        int var5;
        Point var6;
        if (this.aBoolean1089) {
            var5 = this.aVectorArray1088[var2].size();
            if (var5 > 0) {
                var6 = (Point) this.aVectorArray1088[var2].elementAt((int) (this.aRandom1093.nextDouble() * (double) var5));
            } else {
                int var7;
                for (var7 = 0; var7 < 6; ++var7) {
                    var5 += this.aVectorArray1088[var7].size();
                }

                var7 = (int) (this.aRandom1093.nextDouble() * (double) var5);

                int var8;
                for (var8 = 0; var7 >= this.aVectorArray1088[var8].size(); ++var8) {
                    var7 -= this.aVectorArray1088[var8].size();
                }

                var6 = (Point) this.aVectorArray1088[var8].elementAt(var7);
            }
        } else {
            var5 = this.aVectorArray1090[var2].size();
            if (var5 <= 1) {
                return null;
            }

            do {
                var6 = (Point) this.aVectorArray1090[var2].elementAt((int) (this.aRandom1093.nextDouble() * (double) var5));
            } while (var6.x == var3 && var6.y == var4);
        }

        return var6;
    }

    protected void method1307(int var1, int var2, boolean var3, GameBall var4) {
        this.method1313("mine");
        this.method1310(var1, var2, var3 ? 14 : 11);
        var4.method1250(this.aRandom1093, var3);
        if (var3) {
            this.method1311(var1, var2, 4);
            this.method1311(var1, var2 - 1, 7);
            this.method1311(var1, var2 + 1, 1);
            this.method1311(var1 - 1, var2, 5);
            this.method1311(var1 + 1, var2, 3);
            this.method1311(var1 - 1, var2 - 1, 8);
            this.method1311(var1 + 1, var2 - 1, 6);
            this.method1311(var1 - 1, var2 + 1, 2);
            this.method1311(var1 + 1, var2 + 1, 0);
        }

    }

    protected boolean method1308(int var1, int var2, int var3, int var4) {
        if (this.method1312((BlockSpecial) ((BlockSpecial) this.aClass52_1084.method1394(var1, var2)), var1, var2, var3, var4)) {
            this.aBoolean1095 = true;
            return true;
        } else {
            return false;
        }
    }

    protected boolean method1309(int var1, int var2) {
        BlockSpecial var3 = this.method1318(var1, var2);
        if (var3 == null) {
            return false;
        } else {
            int var4 = var3.getElement();
            int var5 = var3.getSlope();
            this.aClass52_1084.method1398(var1, var2, new BlockBasic(this.aTrackOverlays_1083, 0, var4, var4, var5, var5));
            return true;
        }
    }

    protected boolean method1310(int var1, int var2, int var3) {
        BlockSpecial var4 = this.method1318(var1, var2);
        if (var4 == null) {
            return false;
        } else {
            this.aClass52_1084.method1398(var1, var2, new BlockSpecial(this.aTrackOverlays_1083, var3, var4.getElement(), var4.getSlope()));
            return true;
        }
    }

    protected boolean method1311(int var1, int var2, int var3) {
        if (var1 >= 0 && var1 < 52 && var2 >= 0 && var2 < 28) {
            Block var4 = this.aClass52_1084.method1394(var1, var2);
            int var6;
            if (var4 instanceof BlockBasic) {
                BlockBasic var5 = (BlockBasic) ((BlockBasic) var4);
                var6 = var5.method1206();
                int var7 = var3;
                if (var6 == 0 || var6 == 1) {
                    if (var3 == 8) {
                        var6 = 3;
                    } else if (var3 == 6) {
                        var6 = 4;
                    } else if (var3 == 2) {
                        var6 = 12;
                    } else if (var3 == 0) {
                        var6 = 13;
                    } else {
                        var6 = 1;
                    }

                    if (var6 > 1) {
                        var7 = var6 == 0 ? var5.getSlopes2() : var5.getSlopes1();
                    }
                }

                BlockBasic var8 = new BlockBasic(this.aTrackOverlays_1083, var6, 1, var5.getElements2(), var3, var7);
                this.aClass52_1084.method1398(var1, var2, var8);
            } else {
                BlockSpecial var9 = (BlockSpecial) ((BlockSpecial) var4);
                var6 = var9.method1206();
                Object var10;
                if (var6 >= 18 && var6 <= 23) {
                    var10 = new BlockBasic(this.aTrackOverlays_1083, 1, 1, var9.getElement(), var3, var9.getSlope());
                } else {
                    var10 = new BlockSpecial(this.aTrackOverlays_1083, var6, 1, var3);
                }

                this.aClass52_1084.method1398(var1, var2, (Block) var10);
            }

            return true;
        } else {
            return false;
        }
    }

    protected boolean method1312(BlockSpecial var1, int var2, int var3, int var4, int var5) {
        BlockBasic var6 = this.method1320(var2, var3, var4, var5);
        if (var6 == null) {
            return false;
        } else {
            int var7 = var1.getElement();
            int var8 = var1.getSlope();
            this.aClass52_1084.method1398(var2, var3, new BlockBasic(this.aTrackOverlays_1083, 0, var7, var7, var8, var8));
            int var9 = var1.method1206();
            int var10 = var6.getElements1();
            if (var9 == 43 && (var10 == 4 || var10 == 8 || var10 == 10)) {
                var9 = 44;
            }

            this.aClass52_1084.method1398(var2 + var4, var3 + var5, new BlockSpecial(this.aTrackOverlays_1083, var9, var10, var6.getSlopes1()));
            return true;
        }
    }

    protected void method1313(String var1) {
        this.aTrackOverlays_1083.method1234("ball_" + var1);
    }

    private void method1314(int var1, Random var2) {
        Vector var3 = new Vector();
        Vector var4 = new Vector();

        for (int var5 = 0; var5 < 28; ++var5) {
            for (int var6 = 0; var6 < 52; ++var6) {
                int var7 = this.method1317(var6, var5);
                if (var7 == 45 + var1) {
                    var3.addElement(new int[]{var6, var5});
                }

                if (var7 == 0) {
                    var4.addElement(new int[]{var6, var5});
                }
            }
        }

        if (var3.isEmpty() && var4.isEmpty()) {
            this.aGameBallArray1087[var1].method1249(390.0D, 210.0D);
        } else {
            int[] var8;
            if (!var3.isEmpty()) {
                var8 = (int[]) var3.elementAt((int) (var2.nextDouble() * (double) var3.size()));
            } else {
                var8 = (int[]) var4.elementAt((int) (var2.nextDouble() * (double) var4.size()));
            }

            this.aGameBallArray1087[var1].method1249(((double) var8[0] + 0.5D) * 15.0D, ((double) var8[1] + 0.5D) * 15.0D);
        }
    }

    private void method1315() {
        for (int var1 = 0; var1 < 28; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                int var3 = this.method1317(var2, var1);

                for (int var4 = 0; var4 < 6; ++var4) {
                    if (var3 == 72 + var4) {
                        this.aVectorArray1088[var4].addElement(new Point(var2, var1));
                        this.aBoolean1089 = true;
                    }

                    if (var3 == 63 + var4) {
                        this.aVectorArray1090[var4].addElement(new Point(var2, var1));
                    }
                }
            }
        }

    }

    private void method1316() {
        for (int var1 = 0; var1 < 28; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                int var3 = this.method1317(var2, var1);
                if (var3 != 37 && var3 != 36) {
                    if (var3 == 39 || var3 == 38) {
                        this.aVector1092.addElement(new Point(var2, var1));
                    }
                } else {
                    this.aVector1091.addElement(new Point(var2, var1));
                }
            }
        }

    }

    private int method1317(int var1, int var2) {
        BlockSpecial var3 = this.method1318(var1, var2);
        return var3 == null ? -1 : var3.method1206();
    }

    private BlockSpecial method1318(int var1, int var2) {
        Block var3 = this.aClass52_1084.method1394(var1, var2);
        return !(var3 instanceof BlockSpecial) ? null : (BlockSpecial) ((BlockSpecial) var3);
    }

    private boolean method1319() {
        boolean var1 = false;

        for (int var2 = 0; var2 < 28; ++var2) {
            for (int var3 = 0; var3 < 52; ++var3) {
                BlockSpecial var4 = this.method1318(var3, var2);
                if (var4 != null) {
                    int var5 = var4.method1206();
                    if (var5 == 43) {
                        int var6 = var4.getSlope();
                        boolean var7 = false;
                        if (var4.method1222() && var6 != 4) {
                            var7 = this.method1312(var4, var3, var2, anIntArray1081[var6], anIntArray1082[var6]);
                            if (var7) {
                                var1 = true;
                            }
                        }

                        if (!var7 && var6 != 4 && this.method1320(var3, var2, anIntArray1081[var6], anIntArray1082[var6]) != null) {
                            var1 = true;
                        }
                    }
                }
            }
        }

        return var1;
    }

    private BlockBasic method1320(int var1, int var2, int var3, int var4) {
        BlockBasic var5 = this.method1321(var1 + var3, var2 + var4);
        if (var5 == null) {
            return null;
        } else {
            if (var3 != 0 && var4 != 0) {
                boolean var6 = this.method1321(var1 + var3, var2) != null;
                boolean var7 = this.method1321(var1, var2 + var4) != null;
                if (!var6 && !var7) {
                    return null;
                }
            }

            return var5;
        }
    }

    private BlockBasic method1321(int var1, int var2) {
        if (var1 >= 0 && var1 < 52 && var2 >= 0 && var2 < 28) {
            Block var3 = this.aClass52_1084.method1394(var1, var2);
            if (!(var3 instanceof BlockBasic)) {
                return null;
            } else {
                BlockBasic var4 = (BlockBasic) ((BlockBasic) var3);
                int var5 = var4.method1206();
                if (var5 != 0 && var5 != 1) {
                    return null;
                } else {
                    int var6 = var5 == 0 ? var4.getElements2() : var4.getElements1();
                    return Pixel.method1368(var6) ? null : var4;
                }
            }
        } else {
            return null;
        }
    }

    private boolean method1322(GameBall var1, GameBall var2) {
        double var3 = var2.getLocationX() - var1.getLocationX();
        double var5 = var2.getLocationY() - var1.getLocationY();
        if (var3 == 0.0D && var5 == 0.0D) {
            return false;
        } else {
            double var7 = Math.sqrt(var3 * var3 + var5 * var5);
            if (var7 > (double) var1.method1264() * 0.5D + (double) var2.method1264() * 0.5D) {
                return false;
            } else {
                double var9 = var1.getSpeedX();
                double var11 = var1.getSpeedY();
                double var13 = var2.getSpeedX();
                double var15 = var2.getSpeedY();
                double var17 = var3 / var7;
                double var19 = var5 / var7;
                double var21 = var9 * var17 + var11 * var19;
                double var23 = var13 * var17 + var15 * var19;
                if (var21 - var23 <= 0.0D) {
                    return false;
                } else {
                    double var25 = -var9 * var19 + var11 * var17;
                    double var27 = -var13 * var19 + var15 * var17;
                    double var29 = var1.method1265();
                    double var31 = var2.method1265();
                    double var33 = var21;
                    double var37 = var29 + var31;
                    var21 = var21 * (var29 - var31) / var37 + var23 * 2.0D * var31 / var37;
                    var23 = var33 * 2.0D * var29 / var37 + var23 * (var31 - var29) / var37;
                    var1.setSpeed(var21 * var17 - var25 * var19, var21 * var19 + var25 * var17);
                    var2.setSpeed(var23 * var17 - var27 * var19, var23 * var19 + var27 * var17);
                    return true;
                }
            }
        }
    }

    static {
        aStringArray1097[0] = "mine";
        aStringArray1097[1] = "ball_";
        anIntArray1081 = new int[]{-1, 0, 1, -1, 0, 1, -1, 0, 1};
        anIntArray1082 = new int[]{-1, -1, -1, 0, 0, 0, 1, 1, 1};
    }
}
