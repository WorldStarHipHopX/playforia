package apool;

public class SPanel_Sub20_Sub2_Sub2 extends SPanel_Sub20_Sub2 {

    public SPanel_Sub20_Sub2_Sub2(Class60 var1) {
        super(var1, 5);
    }

    protected void method2535(int var1, boolean var2) {
        if (var1 > 0) {
            super.aSPanel_Sub34_Sub1_4857.method2742(var1, true);
        }

    }

    protected void method2536(int var1) {
        if (var1 == 0 && super.aSPanel__4859 != null) {
            super.aSPanel__4859.method2503();
        }

    }

    protected String method2541() {
        return "-";
    }

    protected void method2570() {
        super.method2570();
        SPanel_Sub31 var1 = new SPanel_Sub31(super.aClass60_4028);
        var1.setLocation(630, 190);
        this.add(var1);
        super.aSPanel_Sub32_4032 = new SPanel_Sub32_Sub2(super.aClass60_4028, this);
        super.aSPanel_Sub32_4032.setLocation(15, 80);
        this.add(super.aSPanel_Sub32_4032);
        Class71 var2 = new Class71(super.aClass60_4028, this, super.aSPanel_Sub32_4032, false, true);
        super.aSPanel_Sub32_4032.method2649(var2);
        super.aSPanel_Sub14_Sub2_4858 = new GameControlPanel_Sub14_Sub2(super.aClass60_4028, this, 125, 128);
        super.aSPanel_Sub14_Sub2_4858.setLocation(630, 417);
        this.add(super.aSPanel_Sub14_Sub2_4858);
        super.aSPanel__4859 = new GameEditPanel(super.aClass60_4028, this, 620, 128);
        super.aSPanel__4859.setLocation(5, 417);
        this.add(super.aSPanel__4859);
    }
}
