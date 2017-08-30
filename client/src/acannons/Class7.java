package acannons;


public class Class7 {

    private long aLong792;
    private int anInt793;
    private long aLong794;
    private long aLong795;


    public Class7() {
        this.method1011("0");
    }

    public Class7(int var1) {
        this.method1012(var1);
    }

    public synchronized int method1011(String var1) {
        return this.method1012(Integer.parseInt(var1));
    }

    public synchronized int method1012(int var1) {
        this.method1017(var1);
        this.anInt793 = var1;
        return var1;
    }

    public synchronized void method1013(int var1) {
        this.method1012(this.method1018() + var1);
    }

    public synchronized int method1014() {
        return this.method1012(this.method1018() + 1);
    }

    public synchronized int method1015() {
        return this.method1012(this.method1018() - 1);
    }

    public synchronized int method1016() {
        return this.method1018();
    }

    private void method1017(int var1) {
        if (Math.random() < 0.5D) {
            this.aLong794 = this.method1019(2406647810223766L);
            this.aLong795 = this.method1020();
            this.aLong792 = this.aLong794 - (long) var1 * this.aLong795;
        } else {
            this.aLong794 = this.method1019(-991533974001219L);
            this.aLong795 = this.method1020();
            this.aLong792 = this.aLong794 + (long) var1 * this.aLong795;
        }

    }

    private int method1018() {
        return this.aLong792 > 0L ? (int) ((this.aLong794 - this.aLong792) / this.aLong795) : (int) ((this.aLong792 - this.aLong794) / this.aLong795);
    }

    private long method1019(long var1) {
        boolean var3 = var1 < 0L;
        if (var3) {
            var1 = -var1;
        }

        double var4 = (double) var1 * (0.7D + Math.random() * 0.6D);
        var1 = (long) (var4 + 0.5D);
        if (var3) {
            var1 = -var1;
        }

        return var1;
    }

    private long method1020() {
        return (long) (3.0D + Math.random() * 11.0D * 2.0D);
    }
}
