package agolf2;


public class SynchronizedBool {

    private int anInt999;
    private boolean aBoolean1000;


    public SynchronizedBool() {
        this(false);
    }

    public SynchronizedBool(boolean var1) {
        this.method1167(var1);
    }

    public synchronized boolean method1167(boolean var1) {
        this.method1169(var1);
        this.aBoolean1000 = var1;
        return var1;
    }

    public synchronized boolean method1168() {
        return this.method1170();
    }

    private void method1169(boolean var1) {
        this.anInt999 = (int) (Math.random() * 4.1011596E7D) * 4 + (var1 ? 1 : 3);
        if (Math.random() < 0.5D) {
            this.anInt999 = -this.anInt999 - 1;
        }

    }

    private boolean method1170() {
        return this.anInt999 >= 0 ? this.anInt999 % 4 == 1 : (-this.anInt999 - 1) % 4 == 1;
    }
}
