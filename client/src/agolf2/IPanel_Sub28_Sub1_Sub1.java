package agolf2;

public class IPanel_Sub28_Sub1_Sub1 extends IPanel_Sub28_Sub1 {

    private static final String[] aStringArray4742 = new String[4];


    public IPanel_Sub28_Sub1_Sub1(Class58_Sub1 var1, int var2, int var3, boolean var4) {
        super(var1, 1, var2, var3, var4);
    }

    protected boolean method692(String[] var1) {
        if (var1[1].equals("nextnote")) {
            this.method683();
            return true;
        } else {
            return false;
        }
    }

    protected void method693() {
        if (this.method685()) {
            this.method695("next");
            this.anIPanel_Sub31_3643.method741();
        }

    }

    protected void method694() {
        if (this.method685()) {
            this.method695("newgame");
        }

    }

    protected void method695(String var1) {
        this.aClass58_Sub1_3641.aClass36_Sub1_3572.method1179("game1\t" + var1);
    }

    static {
        aStringArray4742[0] = "next";
        aStringArray4742[1] = "game1\t";
        aStringArray4742[2] = "newgame";
        aStringArray4742[3] = "nextnote";
    }
}
