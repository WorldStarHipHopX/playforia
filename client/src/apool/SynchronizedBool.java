package apool;


public class SynchronizedBool {

    private int anInt1229;
    private boolean aBoolean1230;


    public SynchronizedBool() {
        this(false);
    }

    public SynchronizedBool(boolean var1) {
        this.method1459(var1);
    }

    public synchronized boolean method1459(boolean var1) {
        this.method1461(var1);
        this.aBoolean1230 = var1;
        return var1;
    }

    public synchronized boolean method1460() {
        return this.method1462();
    }

    private void method1461(boolean var1) {
        this.anInt1229 = (int) (Math.random() * 9.05826947E8D) * 2 + (var1 ? 0 : 1);
        if (Math.random() < 0.5D) {
            this.anInt1229 = -this.anInt1229 - 1;
        }

    }

    private boolean method1462() {
        return this.anInt1229 >= 0 ? this.anInt1229 % 2 == 0 : -(this.anInt1229 + 1) % 2 == 0;
    }
}
