package apool;

public class Class69 {

    private Class60 aClass60_1260;
    private long[] aLongArray1261;
    private boolean[] aBooleanArray1262;


    protected Class69(Class60 var1) {
        this.aClass60_1260 = var1;
        this.aLongArray1261 = new long[3];

        for (int var2 = 0; var2 < 3; ++var2) {
            this.aLongArray1261[var2] = 0L;
        }

        this.aBooleanArray1262 = new boolean[3];
    }

    protected void method1529() {
        for (int var1 = 0; var1 < 3; ++var1) {
            this.aBooleanArray1262[var1] = false;
        }

    }

    protected void method1530(int var1) {
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 >= 3) {
            var1 = 2;
        }

        if (!this.aBooleanArray1262[var1]) {
            if (!this.method1531(var1)) {
                if (!this.method1531(var1 - 1)) {
                    if (this.method1531(var1 + 1)) {
                        ;
                    }

                }
            }
        }
    }

    private boolean method1531(int var1) {
        if (var1 >= 0 && var1 < 3) {
            long var2 = System.currentTimeMillis();
            if (var2 < this.aLongArray1261[var1] + 160L) {
                return false;
            } else {
                this.aClass60_1260.soundManager.play("wall-" + var1);
                this.aLongArray1261[var1] = var2;
                this.aBooleanArray1262[var1] = true;
                return true;
            }
        } else {
            return false;
        }
    }

}
