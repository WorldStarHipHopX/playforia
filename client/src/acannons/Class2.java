package acannons;

class Class2 {

    private SPanel_Sub7 aSPanel_Sub7_753;
    private int anInt754;
    private String aString755;
    private String aString756;
    private int anInt757;
    private boolean aBoolean758;
    private static final String aString759 = "ÿÿ";


    protected Class2(SPanel_Sub7 var1, int var2) {
        this.aSPanel_Sub7_753 = var1;
        this.anInt754 = var2;
        this.aBoolean758 = true;
        this.anInt757 = 0;
    }

    protected void method981(String var1, String var2) {
        this.aString755 = var1;
        this.aString756 = var2;
    }

    protected void method982(boolean var1) {
        if (var1) {
            this.aString755 = this.aString756 = null;
        } else {
            this.aBoolean758 = false;
        }

    }

    protected void method983(int var1) {
        int var2 = var1 - this.anInt757;
        if (var2 != 0) {
            this.anInt757 = var1;
            this.aSPanel_Sub7_753.method2442(this.anInt754, var2);
        }
    }

    protected void method984(int var1) {
        this.method983(this.anInt757 + var1);
    }

    protected String method985() {
        return this.aString755;
    }

    protected int method986() {
        return this.anInt757;
    }

    protected boolean method987() {
        return this.aBoolean758;
    }

    protected int method988(boolean var1, double var2) {
        int var4 = (this.anInt757 + 100) * 100000;
        if (this.aBoolean758) {
            var4 += 10000;
        }

        if (var1) {
            var4 = (int) ((double) var4 + var2 * 10.0D);
        }

        return var4;
    }

    protected String method989() {
        return this.aString755 != null ? this.aString755.toLowerCase().replace('~', '\u00ff') : "ÿÿ";
    }

}
