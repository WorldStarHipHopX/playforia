package acannons;


public class SynchronizedBool {

    private int anInt790;
    private boolean aBoolean791;


    public SynchronizedBool(boolean var1) {
        this.method1007(var1);
    }

    public synchronized void method1007(boolean var1) {
        this.method1009(var1);
        this.aBoolean791 = var1;
    }

    public synchronized boolean method1008() {
        return this.method1010();
    }

    private void method1009(boolean var1) {
        this.anInt790 = (int) (Math.random() * 3017277.0D) * 3 + (var1 ? 1 : 0);
        if (Math.random() < 0.5D) {
            this.anInt790 = -this.anInt790 - 1;
        }

    }

    private boolean method1010() {
        return this.anInt790 >= 0 ? this.anInt790 % 3 == 1 : (-this.anInt790 - 1) % 3 == 1;
    }
}
