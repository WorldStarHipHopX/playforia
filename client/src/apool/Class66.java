package apool;


class Class66 {

    private long aLong1249;


    protected Class66(long var1) {
        this.aLong1249 = (var1 ^ 25214903917L) & 281474976710655L;
    }

    protected int method1520() {
        int var1 = this.method1521();
        if (var1 < 0) {
            var1 = -var1;
            if (var1 < 0) {
                var1 = 0;
            }
        }

        return var1;
    }

    private int method1521() {
        this.aLong1249 = this.aLong1249 * 25214903917L + 11L & 281474976710655L;
        return (int) (this.aLong1249 >>> 16);
    }
}
