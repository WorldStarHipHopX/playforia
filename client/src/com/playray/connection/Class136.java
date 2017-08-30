package com.playray.connection;


class Class136 {

    private long aLong2066;


    protected Class136(long var1) {
        this.aLong2066 = (var1 ^ 25214903917L) & 281474976710655L;
    }

    protected int method2130(int var1, int var2) {
        return var1 + this.method2131() % (var2 - var1 + 1);
    }

    private int method2131() {
        int var1 = this.method2132();
        if (var1 < 0) {
            var1 = -var1;
            if (var1 < 0) {
                var1 = 0;
            }
        }

        return var1;
    }

    private int method2132() {
        this.aLong2066 = this.aLong2066 * 25214903917L + 11L & 281474976710655L;
        return (int) (this.aLong2066 >>> 16);
    }
}
