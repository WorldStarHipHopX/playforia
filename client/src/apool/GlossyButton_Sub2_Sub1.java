package apool;

class GlossyButton_Sub2_Sub1 extends GlossyButton_Sub2 {

    private Class60 aClass60_5014;
    private String aString5015;
    private boolean aBoolean5016;
    private int anInt5017;
    private int anInt5018;
    private static final String[] aStringArray5019 = new String[2];


    protected GlossyButton_Sub2_Sub1(Class60 var1, String var2, int var3, boolean var4, int var5) {
        super(var2, var3);
        this.aClass60_5014 = var1;
        this.aString5015 = var2;
        this.aBoolean5016 = var4;
        this.anInt5017 = var5;
        this.anInt5018 = -1;
        this.method2884();
    }

    protected boolean method2880() {
        return false;
    }

    protected boolean method2881() {
        return this.aClass60_5014.gameApplet.method2310() >= 1 ? true : (!this.aClass60_5014.gameApplet.method2309() && this.aBoolean5016 ? false : this.anInt5018 < this.anInt5017);
    }

    protected void method2877(int var1) {
        this.anInt5018 = var1;
        this.method2883();
        this.method2884();
    }

    private void method2883() {
        if (this.anInt5018 == 0) {
            this.setLabel(this.aString5015);
        } else if (this.anInt5018 >= this.anInt5017) {
            this.setLabel(this.aString5015 + " " + this.aClass60_5014.textManager.method2039("LSB_Text_RoomFull"));
        } else {
            this.setLabel(this.aString5015 + " (" + this.anInt5018 + ")");
        }

    }

    private void method2884() {
        if (!this.aClass60_5014.gameApplet.method2309() && this.aBoolean5016) {
            this.setEnabled(false);
        }

        if (this.anInt5018 >= this.anInt5017) {
            this.setColor(4);
        } else {
            this.setColor(1);
        }

    }

    static {
        aStringArray5019[0] = " (";
        aStringArray5019[1] = "LSB_Text_RoomFull";
    }
}
