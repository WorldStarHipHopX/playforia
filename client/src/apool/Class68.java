package apool;

public class Class68 {

    private Class60 aClass60_1255;
    private long[] aLongArray1256;
    private boolean[] aBooleanArray1257;
    private int[] anIntArray1258;


    protected Class68(Class60 var1) {
        this.aClass60_1255 = var1;
        this.aLongArray1256 = new long[10];

        for (int var2 = 0; var2 < 10; ++var2) {
            this.aLongArray1256[var2] = 0L;
        }

        this.aBooleanArray1257 = new boolean[10];
        this.anIntArray1258 = new int[10];
    }

    protected void method1526() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.aBooleanArray1257[var1] = false;
        }

    }

    protected void method1527(int var1) {
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 >= 10) {
            var1 = 9;
        }

        if (!this.aBooleanArray1257[var1]) {
            if (!this.method1528(var1)) {
                if (!this.method1528(var1 - 1)) {
                    if (this.method1528(var1 + 1)) {
                        ;
                    }

                }
            }
        }
    }

    private boolean method1528(int var1) {
        if (var1 >= 0 && var1 < 10) {
            long var2 = System.currentTimeMillis();
            if (var2 < this.aLongArray1256[var1] + 330L) {
                return false;
            } else {
                this.aClass60_1255.soundManager.play("collision-" + var1);
                this.aLongArray1256[var1] = var2;
                this.aBooleanArray1257[var1] = true;
                ++this.anIntArray1258[var1];
                return true;
            }
        } else {
            return false;
        }
    }
}
