package org.moparforia.client.trackdump;


class Class100 {

    private long aLong1632;


    protected Class100(long var1) {
        this.aLong1632 = (var1 ^ 25214903917L) & 281474976710655L;
    }

    protected int method1799(int var1, int var2) {
        return var1 + this.method1800() % (var2 - var1 + 1);
    }

    private int method1800() {
        int var1 = this.method1801();
        if (var1 < 0) {
            var1 = -var1;
            if (var1 < 0) {
                var1 = 0;
            }
        }

        return var1;
    }

    private int method1801() {
        this.aLong1632 = this.aLong1632 * 25214903917L + 11L & 281474976710655L;
        return (int) (this.aLong1632 >>> 16);
    }
}
