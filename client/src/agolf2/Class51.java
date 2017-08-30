package agolf2;

import java.util.StringTokenizer;

class Class51 {

    private int anInt1142;
    private String aString1143;
    private String aString1144;
    private boolean aBoolean1145;
    private String[] aStringArray1146;


    protected Class51(int var1, String var2, String var3, boolean var4, String var5) {
        this.anInt1142 = var1;
        this.aString1143 = var2;
        this.aString1144 = var3;
        this.aBoolean1145 = var4;
        if (var5.equals("-")) {
            this.aStringArray1146 = new String[0];
        } else {
            StringTokenizer var6 = new StringTokenizer(var5, "^");
            int var7 = var6.countTokens();
            this.aStringArray1146 = new String[var7];

            for (int var8 = 0; var8 < var7; ++var8) {
                this.aStringArray1146[var8] = var6.nextToken();
            }
        }

    }

    protected int method1386() {
        return this.anInt1142;
    }

    protected String method1387() {
        return this.aString1143;
    }

    protected String method1388() {
        return this.aString1144;
    }

    protected boolean method1389() {
        return this.aBoolean1145;
    }

    protected int method1390() {
        return this.aStringArray1146.length;
    }

    protected String[] method1391() {
        return this.aStringArray1146;
    }
}
