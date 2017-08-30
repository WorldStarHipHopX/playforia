package agolf2;

import java.util.Iterator;
import java.util.Vector;

public class Class52 {

    private static final String aString1147 = "=+-*/^";
    private TrackOverlays aTrackOverlays_1148;
    private int[] anIntArray1149;
    private Block[][] aBlockArrayArray1150;


    public Class52(TrackOverlays var1) {
        this.aTrackOverlays_1148 = var1;
        this.anIntArray1149 = null;
        this.aBlockArrayArray1150 = new Block[28][52];
        this.method1392();
    }

    public void method1392() {
        BlockBasic var1 = new BlockBasic(this.aTrackOverlays_1148);

        for (int var2 = 0; var2 < 28; ++var2) {
            for (int var3 = 0; var3 < 52; ++var3) {
                this.aBlockArrayArray1150[var2][var3] = var1;
            }
        }

    }

    public void method1393() {
        for (int var1 = 1; var1 < 1456; ++var1) {
            for (int var2 = 0; var2 < var1; ++var2) {
                if (this.aBlockArrayArray1150[var2 / 52][var2 % 52].equals(this.aBlockArrayArray1150[var1 / 52][var2 % 52])) {
                    this.aBlockArrayArray1150[var1 / 52][var2 % 52] = this.aBlockArrayArray1150[var2 / 52][var2 % 52];
                }
            }
        }

    }

    public Block method1394(int var1, int var2) {
        return this.aBlockArrayArray1150[var2][var1];
    }

    public Pixel method1395(int var1, int var2) {
        return this.method1396(var1, var2, false);
    }

    protected Pixel method1396(int var1, int var2, boolean var3) {
        int[] var4 = Class50.method1383(var1, var2);
        if (var4 == null) {
            return null;
        } else {
            int var5 = var4[0];
            int var6 = var4[1];
            int var7 = var1 - var5 * 15;
            int var8 = var2 - var6 * 15;
            return this.aBlockArrayArray1150[var6][var5].method1204(var5, var6, var7, var8, var3);
        }
    }

    public Block[] method1397(int var1, int var2, int var3, int var4) {
        int var5 = Math.min(var1, var3);
        int var6 = Math.min(var2, var4);
        int var7 = Math.abs(var1 - var3) + 1;
        int var8 = Math.abs(var2 - var4) + 1;
        int var9 = 0;
        Block[] var10 = new Block[var7 * var8];

        for (int var11 = var6; var11 < var6 + var8; ++var11) {
            for (int var12 = var5; var12 < var5 + var7; ++var12) {
                var10[var9] = this.aBlockArrayArray1150[var11][var12];
                ++var9;
            }
        }

        return var10;
    }

    public boolean method1398(int var1, int var2, Block var3) {
        if (this.aBlockArrayArray1150[var2][var1] == var3) {
            return false;
        } else {
            this.aBlockArrayArray1150[var2][var1] = var3;
            return true;
        }
    }

    public void method1399(int var1, int var2, Block[] var3, int var4) {
        int var5 = var3.length;
        int var6 = var5 / var4;
        int var7 = 0;
        var1 -= var4 / 2;
        var2 -= var6 / 2;

        for (int var8 = var2; var8 < var2 + var6; ++var8) {
            for (int var9 = var1; var9 < var1 + var4; ++var9) {
                if (var9 >= 0 && var9 < 52 && var8 >= 0 && var8 < 28) {
                    this.aBlockArrayArray1150[var8][var9] = var3[var7];
                }

                ++var7;
            }
        }

    }

    public boolean method1400(int var1, int var2, Block var3) {
        Block var4 = this.aBlockArrayArray1150[var2][var1];
        if (var4.equals(var3)) {
            return false;
        } else {
            Vector var5 = new Vector();
            var5.addElement(new int[]{var1, var2});

            do {
                int[] var6 = (int[]) var5.elementAt(0);
                var5.removeElementAt(0);
                var1 = var6[0];
                var2 = var6[1];
                this.aBlockArrayArray1150[var2][var1] = var3;
                this.method1409(var1 + 1, var2, var4, var5);
                this.method1409(var1 - 1, var2, var4, var5);
                this.method1409(var1, var2 + 1, var4, var5);
                this.method1409(var1, var2 - 1, var4, var5);
            } while (!var5.isEmpty());

            return true;
        }
    }

    public void method1401() {
        for (int var1 = 0; var1 < 26; ++var1) {
            for (int var2 = 0; var2 < 28; ++var2) {
                Block var3 = this.aBlockArrayArray1150[var2][var1];
                this.aBlockArrayArray1150[var2][var1] = Block.method1199(this.aBlockArrayArray1150[var2][51 - var1]);
                this.aBlockArrayArray1150[var2][51 - var1] = Block.method1199(var3);
            }
        }

    }

    public void method1402() {
        for (int var1 = 0; var1 < 14; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                Block var3 = this.aBlockArrayArray1150[var1][var2];
                this.aBlockArrayArray1150[var1][var2] = Block.method1200(this.aBlockArrayArray1150[27 - var1][var2]);
                this.aBlockArrayArray1150[27 - var1][var2] = Block.method1200(var3);
            }
        }

    }

    public void method1403(int var1, int var2) {
        Block[][] var3 = new Block[28][52];

        for (int var4 = 0; var4 < 28; ++var4) {
            for (int var5 = 0; var5 < 52; ++var5) {
                int var6 = var5 - var1;
                int var7 = var4 - var2;
                if (var6 == -1) {
                    var6 = 51;
                }

                if (var6 == 52) {
                    var6 = 0;
                }

                if (var7 == -1) {
                    var7 = 27;
                }

                if (var7 == 28) {
                    var7 = 0;
                }

                var3[var4][var5] = this.aBlockArrayArray1150[var7][var6];
            }
        }

        this.aBlockArrayArray1150 = var3;
    }

    public String method1404() {
        this.method1410();
        StringBuffer var1 = new StringBuffer(8736);

        int var3;
        for (int var2 = 0; var2 < 28; ++var2) {
            for (var3 = 0; var3 < 52; ++var3) {
                this.method1411(var1, var3, var2);
            }
        }

        String var8 = var1.toString();
        var3 = var8.length();
        int var4 = 0;
        int var5 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".length() + 4 - 1;
        var1 = new StringBuffer(2 + var3);
        var1.append(1).append(':');

        do {
            int[] var6 = this.method1412(var8, var4, var3, var5);
            if (var6[1] < 4) {
                for (int var7 = 0; var7 < var6[1]; ++var7) {
                    var1.append((char) var6[0]);
                }
            } else {
                var1.append(aString1147.charAt(5));
                var1.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".charAt(var6[1] - 4));
                var1.append((char) var6[0]);
            }

            var4 += var6[1];
        } while (var4 < var3);

        return var1.toString();
    }

    public void method1405(String var1) {
        int var2 = var1.indexOf(58);
        int var3 = Integer.parseInt(var1.substring(0, var2));
        if (var3 != 1) {
            System.out.println("FATAL ERROR: Unknown trackdata version " + var3);
        } else {
            StringBuffer var4 = new StringBuffer(8736);
            int var5 = var1.length();
            int var6 = var2 + 1;

            int var9;
            do {
                char var7 = var1.charAt(var6);
                if (var7 == aString1147.charAt(5)) {
                    int var8 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}<>_!@$%&?;:,.".indexOf(var1.charAt(var6 + 1)) + 4;
                    var7 = var1.charAt(var6 + 2);

                    for (var9 = 0; var9 < var8; ++var9) {
                        var4.append(var7);
                    }

                    var6 += 3;
                } else {
                    var4.append(var7);
                    ++var6;
                }
            } while (var6 < var5);

            var1 = var4.toString() + aString1147.charAt(0);
            var6 = 0;

            for (int var10 = 0; var10 < 28; ++var10) {
                for (int var11 = 0; var11 < 52; ++var11) {
                    var9 = aString1147.indexOf(var1.charAt(var6));
                    if (var9 > 0) {
                        if (var9 == 1) {
                            this.aBlockArrayArray1150[var10][var11] = this.aBlockArrayArray1150[var10][var11 - 1];
                        } else if (var9 == 2) {
                            this.aBlockArrayArray1150[var10][var11] = this.aBlockArrayArray1150[var10][var11 - 2];
                        } else if (var9 == 3) {
                            this.aBlockArrayArray1150[var10][var11] = this.aBlockArrayArray1150[var10 - 1][var11];
                        } else {
                            this.aBlockArrayArray1150[var10][var11] = this.aBlockArrayArray1150[var10 - 2][var11];
                        }

                        ++var6;
                    } else {
                        for (var5 = 1; aString1147.indexOf(var1.charAt(var6 + var5)) == -1; ++var5) {
                            ;
                        }

                        this.aBlockArrayArray1150[var10][var11] = Block.method1198(this.aTrackOverlays_1148, var1.substring(var6 + 1, var6 + var5));
                        var6 += var5;
                    }
                }
            }

        }
    }

    public void method1406() {
        for (int var1 = 0; var1 < 28; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                this.aBlockArrayArray1150[var1][var2].method1209();
            }
        }

    }

    public int[] method1407(int var1, int var2) {
        if (this.anIntArray1149 != null) {
            return this.anIntArray1149;
        } else {
            Vector var3 = new Vector();

            for (int var4 = 0; var4 < 28; ++var4) {
                for (int var5 = 0; var5 < 52; ++var5) {
                    if (this.aBlockArrayArray1150[var4][var5] instanceof BlockSpecial && this.aBlockArrayArray1150[var4][var5].method1206() == 6) {
                        BlockSpecial var6 = (BlockSpecial) ((BlockSpecial) this.aBlockArrayArray1150[var4][var5]);
                        int var7 = var6.getElement();
                        int var8 = var6.getSlope();
                        this.aBlockArrayArray1150[var4][var5] = new BlockBasic(var6.method1205(), 0, var7, var7, var8, var8);
                        var3.addElement(new int[]{var5, var4});
                    }
                }
            }

            if (var3.isEmpty()) {
                this.anIntArray1149 = new int[]{var1, var2};
            } else {
                this.anIntArray1149 = (int[]) var3.elementAt((int) (Math.random() * (double) var3.size()));
                this.anIntArray1149[0] = this.anIntArray1149[0] * 15 + 7;
                this.anIntArray1149[1] = this.anIntArray1149[1] * 15 + 7;
            }

            return this.anIntArray1149;
        }
    }

    public void method1408() {
        this.aTrackOverlays_1148 = null;

        for (int var1 = 0; var1 < 28; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                this.aBlockArrayArray1150[var1][var2].method1211();
            }
        }

        this.aBlockArrayArray1150 = (Block[][]) null;
    }

    private void method1409(int var1, int var2, Block var3, Vector var4) {
        if (var1 >= 0 && var1 < 52 && var2 >= 0 && var2 < 28) {
            if (this.aBlockArrayArray1150[var2][var1].equals(var3)) {
                Iterator var5 = var4.iterator();

                int[] var6;
                do {
                    if (!var5.hasNext()) {
                        var4.addElement(new int[]{var1, var2});
                        return;
                    }

                    var6 = (int[]) var5.next();
                } while (var6[0] != var1 || var6[1] != var2);

            }
        }
    }

    private void method1410() {
        this.method1393();

        for (int var1 = 0; var1 < 28; ++var1) {
            for (int var2 = 0; var2 < 52; ++var2) {
                this.aBlockArrayArray1150[var1][var2].method1201();
            }
        }

    }

    private void method1411(StringBuffer var1, int var2, int var3) {
        if (var2 > 0 && this.aBlockArrayArray1150[var3][var2 - 1].equals(this.aBlockArrayArray1150[var3][var2])) {
            var1.append("=+-*/^".charAt(1));
        } else if (var2 > 1 && this.aBlockArrayArray1150[var3][var2 - 2].equals(this.aBlockArrayArray1150[var3][var2])) {
            var1.append("=+-*/^".charAt(2));
        } else if (var3 > 0 && this.aBlockArrayArray1150[var3 - 1][var2].equals(this.aBlockArrayArray1150[var3][var2])) {
            var1.append("=+-*/^".charAt(3));
        } else if (var3 > 1 && this.aBlockArrayArray1150[var3 - 2][var2].equals(this.aBlockArrayArray1150[var3][var2])) {
            var1.append("=+-*/^".charAt(4));
        } else {
            var1.append("=+-*/^".charAt(0));
            this.aBlockArrayArray1150[var3][var2].method1202(var1);
        }
    }

    private int[] method1412(String var1, int var2, int var3, int var4) {
        char var5 = var1.charAt(var2);
        int var6 = 1;
        boolean var7 = false;

        do {
            if (var6 == var4) {
                var7 = true;
            } else {
                ++var2;
                if (var2 == var3) {
                    var7 = true;
                } else if (var1.charAt(var2) != var5) {
                    var7 = true;
                } else {
                    ++var6;
                }
            }
        } while (!var7);

        return new int[]{var5, var6};
    }
}
