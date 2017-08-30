package acannons;

import java.util.StringTokenizer;

public class PlayerInfo {

    public boolean aBoolean778 = false;
    public int[] anIntArray779 = new int[]{3, 4, 0, 0, 1, 4, 1, 0, 1};
    public boolean aBoolean780 = true;
    public boolean aBoolean781 = true;
    public boolean aBoolean782 = false;
    public boolean aBoolean783 = false;
    public boolean aBoolean784 = true;
    public int anInt785 = 2;
    public boolean aBoolean786 = true;
    public boolean aBoolean787 = true;
    private String aString788;
    private static final String aString789 = "5:";


    protected void setUserData(String var1) {
        this.method1001(var1);
        this.aString788 = var1;
    }

    protected String method1000() {
        String var1 = this.method1002();
        if (var1.equals(this.aString788)) {
            return null;
        } else {
            this.aString788 = var1;
            return var1;
        }
    }

    private void method1001(String var1) {
        try {
            int var2 = var1.indexOf(':');
            int var3 = Integer.parseInt(var1.substring(0, var2));
            if (var3 != 5 && var3 != 4) {
                return;
            }

            StringTokenizer var4 = new StringTokenizer(var1.substring(var2 + 1), ",");
            this.aBoolean778 = this.string2bool(var4.nextToken());
            this.anIntArray779 = this.method1006(var4.nextToken());
            this.aBoolean780 = this.string2bool(var4.nextToken());
            this.aBoolean781 = this.string2bool(var4.nextToken());
            this.aBoolean782 = this.string2bool(var4.nextToken());
            this.aBoolean783 = this.string2bool(var4.nextToken());
            this.aBoolean784 = this.string2bool(var4.nextToken());
            this.anInt785 = Integer.parseInt(var4.nextToken());
            if (var3 == 5) {
                this.aBoolean786 = this.string2bool(var4.nextToken());
                this.aBoolean787 = this.string2bool(var4.nextToken());
            }
        } catch (Exception var5) {
            ;
        }

    }

    private String method1002() {
        return "5:" + this.bool2string(this.aBoolean778) + "," + this.method1005(this.anIntArray779) + "," + this.bool2string(this.aBoolean780) + "," + this.bool2string(this.aBoolean781) + "," + this.bool2string(this.aBoolean782) + "," + this.bool2string(this.aBoolean783) + "," + this.bool2string(this.aBoolean784) + "," + this.anInt785 + "," + this.bool2string(this.aBoolean786) + "," + this.bool2string(this.aBoolean787);
    }

    private String bool2string(boolean var1) {
        return var1 ? "t" : "f";
    }

    private boolean string2bool(String var1) {
        return var1.equals("t");
    }

    private String method1005(int[] var1) {
        String var2 = "";
        int var3 = var1.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            var2 = var2 + var1[var4];
            if (var4 < var3 - 1) {
                var2 = var2 + ';';
            }
        }

        return var2;
    }

    private int[] method1006(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ";");
        int var3 = var2.countTokens();
        int[] var4 = new int[var3];

        for (int var5 = 0; var5 < var3; ++var5) {
            var4[var5] = Integer.parseInt(var2.nextToken());
        }

        return var4;
    }

}
