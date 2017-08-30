package agolf;


public class SynchronizedBool {

    private int anInt994;
    private boolean aBoolean995;


    public SynchronizedBool() {
        this(false);
    }

    public SynchronizedBool(boolean var1) {
        this.set(var1);
    }

    public SynchronizedBool clone() {
        SynchronizedBool result = new SynchronizedBool();
        result.anInt994 = this.anInt994;
        result.aBoolean995 = this.aBoolean995;
        return result;
    }

    public synchronized boolean set(boolean var1) {
        this.priv_set(var1);
        this.aBoolean995 = var1;
        return var1;
    }

    public synchronized boolean get() {
        return this.anInt994 >= 0 ? this.anInt994 % 2 == 0 : -(this.anInt994 + 1) % 2 == 0;
    }

    private void priv_set(boolean var1) {
        this.anInt994 = (int) (Math.random() * 1.073741823E9D) * 2 + (var1 ? 0 : 1);
        if (Math.random() < 0.5D) {
            this.anInt994 = -this.anInt994 - 1;
        }

    }
}
