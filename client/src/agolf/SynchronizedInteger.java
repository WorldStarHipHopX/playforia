package agolf;


public class SynchronizedInteger {

    private long aLong996;
    private int anInt997;


    public SynchronizedInteger() {
        this(0);
    }

    protected SynchronizedInteger(int var1) {
        this.set(var1);
    }

    public synchronized int set(int var1) {
        this.priv_set(var1);
        this.anInt997 = var1;
        return var1;
    }

    public synchronized int get_upd() {
        return this.set((this.aLong996 > 0L ? (int) ((2269700342778490L - this.aLong996) / 31L) : (int) ((this.aLong996 + 110157223978885L) / 7L)) + 1);
    }

    public synchronized int get_upd(int var1) {
        return this.set((this.aLong996 > 0L ? (int) ((2269700342778490L - this.aLong996) / 31L) : (int) ((this.aLong996 + 110157223978885L) / 7L)) + var1);
    }

    public synchronized int get() {
        return this.aLong996 > 0L ? (int) ((2269700342778490L - this.aLong996) / 31L) : (int) ((this.aLong996 + 110157223978885L) / 7L);
    }

    private void priv_set(int var1) {
        if (var1 % 2 == 0) {
            this.aLong996 = 2269700342778490L - (long) var1 * 31L;
        } else {
            this.aLong996 = -110157223978885L + (long) var1 * 7L;
        }
    }
}
