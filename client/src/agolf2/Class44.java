package agolf2;

import agolf2.SynchronizedBool;
import agolf2.SynchronizedInteger;

class Class44 {

    private String aString1098;
    private SynchronizedBool aSynchronizedBool_1099;
    private SynchronizedBool aSynchronizedBool_1100;
    private SynchronizedBool aSynchronizedBool_1101;
    private SynchronizedBool aSynchronizedBool_1102;
    private SynchronizedBool aSynchronizedBool_1103;
    private SynchronizedInteger[] aSynchronizedIntegerArray1104;
    private SynchronizedInteger[] aSynchronizedIntegerArray1105;
    private SynchronizedBool[] aSynchronizedBoolArray1106;
    private SynchronizedInteger aSynchronizedInteger_1107;
    private static final String aString1108 = " = ";


    protected Class44(String var1, int var2) {
        this.aString1098 = var1;
        this.aSynchronizedBool_1099 = new SynchronizedBool(true);
        this.aSynchronizedIntegerArray1104 = new SynchronizedInteger[var2];
        this.aSynchronizedIntegerArray1105 = new SynchronizedInteger[var2];
        this.aSynchronizedBoolArray1106 = new SynchronizedBool[var2];
        this.method1326(var2);
    }

    protected void method1326(int var1) {
        this.aSynchronizedBool_1100 = new SynchronizedBool(false);
        this.aSynchronizedBool_1101 = new SynchronizedBool(false);
        this.aSynchronizedBool_1102 = new SynchronizedBool(false);
        this.aSynchronizedBool_1103 = new SynchronizedBool(false);

        for (int var2 = 0; var2 < var1; ++var2) {
            this.aSynchronizedIntegerArray1104[var2] = new SynchronizedInteger(0);
            this.aSynchronizedIntegerArray1105[var2] = new SynchronizedInteger(0);
            this.aSynchronizedBoolArray1106[var2] = new SynchronizedBool(true);
        }

        this.aSynchronizedInteger_1107 = new SynchronizedInteger(0);
    }

    protected String method1327() {
        return this.aString1098;
    }

    protected void method1328(boolean var1) {
        this.aSynchronizedBool_1100.method1167(var1 && this.aSynchronizedBool_1099.method1168());
        if (!this.aSynchronizedBool_1100.method1168()) {
            this.aSynchronizedInteger_1107.set(0);
        }

    }

    protected boolean method1329() {
        return this.aSynchronizedBool_1100.method1168();
    }

    protected void method1330() {
        this.aSynchronizedBool_1099.method1167(false);
        this.aSynchronizedBool_1100.method1167(false);
    }

    protected boolean method1331() {
        return this.aSynchronizedBool_1099.method1168();
    }

    protected void method1332(boolean var1) {
        this.aSynchronizedBool_1103.method1167(var1);
    }

    protected boolean method1333() {
        return this.aSynchronizedBool_1103.method1168();
    }

    protected void method1334(boolean var1) {
        this.aSynchronizedBool_1101.method1167(var1);
    }

    protected boolean method1335() {
        return this.aSynchronizedBool_1101.method1168();
    }

    protected void method1336(boolean var1) {
        this.aSynchronizedBool_1102.method1167(var1);
    }

    protected boolean method1337() {
        return this.aSynchronizedBool_1102.method1168();
    }

    protected void method1338(int var1) {
        this.aSynchronizedIntegerArray1104[var1].method1172();
    }

    protected void method1339(int var1) {
        this.aSynchronizedBoolArray1106[var1].method1167(false);
    }

    protected boolean method1340(int var1) {
        return this.aSynchronizedBoolArray1106[var1].method1168();
    }

    protected void method1341(String[] var1) {
        this.aSynchronizedBool_1099.method1167(var1[3].equals("t"));

        for (int var2 = 0; var2 < this.aSynchronizedIntegerArray1104.length; ++var2) {
            this.aSynchronizedIntegerArray1104[var2].set(Integer.parseInt(var1[4 + var2 * 3]));
            this.aSynchronizedBoolArray1106[var2].method1167(var1[4 + var2 * 3 + 1].equals("t"));
            this.aSynchronizedIntegerArray1105[var2].set(Integer.parseInt(var1[4 + var2 * 3 + 2]));
        }

    }

    protected void method1342(int var1) {
        this.aSynchronizedInteger_1107.set(var1);
    }

    protected void method1343() {
        if (this.aSynchronizedInteger_1107.method1174() > 0) {
            this.aSynchronizedInteger_1107.method1173();
        }

    }

    protected String method1344(int var1, int var2, boolean var3) {
        if (this.aSynchronizedIntegerArray1104[var1].method1174() == 0 && var1 > var2 && var2 >= 0) {
            return "-";
        } else {
            int var4 = this.aSynchronizedIntegerArray1104[var1].method1174();
            if (var3 && (var1 < var2 || var2 == -1)) {
                var4 = this.aSynchronizedIntegerArray1105[var1].method1174();
            }

            return this.aSynchronizedBoolArray1106[var1].method1168() ? "" + var4 : (var4 > 0 ? "(" + var4 + ")" : "-");
        }
    }

    protected String method1345(int var1, boolean var2) {
        int var3 = 0;
        int var4;
        if (!var2) {
            if (var1 == -1) {
                var1 = this.aSynchronizedIntegerArray1104.length - 1;
            }

            for (var4 = 0; var4 <= var1; ++var4) {
                if (this.aSynchronizedBoolArray1106[var4].method1168()) {
                    var3 += this.aSynchronizedIntegerArray1104[var4].method1174();
                }
            }

            if (var3 == 0) {
                return "";
            }
        } else {
            if (var1 == -1) {
                var1 = this.aSynchronizedIntegerArray1104.length;
            }

            for (var4 = 0; var4 < var1; ++var4) {
                if (this.aSynchronizedBoolArray1106[var4].method1168()) {
                    var3 += this.aSynchronizedIntegerArray1105[var4].method1174();
                }
            }
        }

        return " = " + var3;
    }

    protected String method1346() {
        return this.aSynchronizedInteger_1107.method1174() <= 0 ? "" : "(" + this.aSynchronizedInteger_1107.method1174() + ")";
    }

}
