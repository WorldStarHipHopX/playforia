package acannons;


public class Class3 {

    private long aLong760;


    public Class3(long var1) {
        this.aLong760 = (var1 ^ 25214903917L) & 281474976710655L;
    }

    public int method990() {
        int var1 = this.method993();
        if (var1 < 0) {
            var1 = -var1;
            if (var1 < 0) {
                var1 = 0;
            }
        }

        return var1;
    }

    public int method991(int var1, int var2) {
        return var1 + this.method990() % (var2 - var1 + 1);
    }

    public double method992() {
        return (double) (this.method990() % 100000) / 100000.0D;
    }

    private int method993() {
        this.aLong760 = this.aLong760 * 25214903917L + 11L & 281474976710655L;
        return (int) (this.aLong760 >>> 16);
    }
}
