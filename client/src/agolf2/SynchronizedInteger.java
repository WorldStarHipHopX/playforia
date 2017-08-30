package agolf2;


public class SynchronizedInteger {

    private long aLong1001;
    private int anInt1002;


    public SynchronizedInteger() {
        this(0);
    }

    public SynchronizedInteger(int var1) {
        this.set(var1);
    }

    public synchronized int set(int var1) {
        this.set_priv(var1);
        this.anInt1002 = var1;
        return var1;
    }

    public synchronized int method1172() {
        return this.set(this.method1176() + 1);
    }

    public synchronized int method1173() {
        return this.set(this.method1176() - 1);
    }

    public synchronized int method1174() {
        return this.method1176();
    }

    private void set_priv(int var1) {
        if (var1 % 2 == 0) {
            this.aLong1001 = 3229364861625497L - (long) var1 * 11L;
        } else {
            this.aLong1001 = -537710935422715L + (long) var1 * 7L;
        }

    }

    private int method1176() {
        return this.aLong1001 > 0L ? (int) ((3229364861625497L - this.aLong1001) / 11L) : (int) ((this.aLong1001 + 537710935422715L) / 7L);
    }
}
