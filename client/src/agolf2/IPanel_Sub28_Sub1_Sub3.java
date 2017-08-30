package agolf2;

import java.util.Random;

public class IPanel_Sub28_Sub1_Sub3 extends IPanel_Sub28_Sub1 {

    private String aString4746;
    private int anInt4747;
    private boolean aBoolean4748;


    public IPanel_Sub28_Sub1_Sub3(Class58_Sub1 var1, int var2, int var3) {
        super(var1, 0, var2, var3, true);
        this.method684(0);
        this.aBoolean4748 = false;
    }

    protected boolean method692(String[] var1) {
        return false;
    }

    protected void method695(String var1) {
    }

    protected void method696() {
        if (this.aClass43_Sub1_2331.method1301()) {
            this.aBoolean4748 = true;
            this.method712();
        } else if (!this.aClass43_Sub1_2331.method1325()[0].method1247()) {
            this.anIPanel_Sub31_3643.method741();
            this.method712();
        } else {
            this.method713();
        }

    }

    protected void method693() {
        this.aBoolean2338 = false;
        this.anIPanel_Sub31_3643.method741();
        this.method712();
    }

    protected void method694() {
        this.anIPanel_Sub31_3643.method728();
        this.anIPanel_Sub29_3647.method714();
        this.anInt4747 = -1;
        this.method712();
    }

    protected void method697(boolean var1) {
        this.aBoolean2338 = false;
        this.aClass58_Sub1_3641.anAApplet_Sub3_Sub1_3567.method72(this.aBoolean4748);
    }

    public void method711(String var1, String var2) {
        this.anIPanel_Sub31_3643.method727(18, new String[]{var1});
        this.aString4746 = var2;
        this.anInt4747 = -1;
        this.method712();
    }

    protected void method712() {
        ++this.anInt4747;
        if (this.anInt4747 == 18) {
            this.anIPanel_Sub31_3643.method730(-1);
            this.anIPanel_Sub29_3647.method716();
        } else {
            this.method700(this.anInt4747, this.aString4746, -1, new Random());
            this.anIPanel_Sub29_3647.method715(false, true);
            this.method713();
        }
    }

    protected void method713() {
        this.aSynchronizedBool_2334.method1167(true);
        this.aSynchronizedInteger_2335.set(0);
        this.anGameOverPanel__3642.method767().method200();
        this.method11(this.anInt2336, this.anInt2337);
    }
}
