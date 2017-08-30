package apool;


public class SynchronizedInt {

    private long aLong1231;
    private int anInt1232;


    public SynchronizedInt() {
        this(0);
    }

    public SynchronizedInt(int var1) {
        this.method1463(var1);
    }

    public synchronized int method1463(int var1) {
        this.method1468(var1);
        this.anInt1232 = var1;
        return var1;
    }

    public synchronized int method1464() {
        return this.method1463(this.method1469() + 1);
    }

    public synchronized int method1465() {
        return this.method1463(this.method1469() - 1);
    }

    public synchronized int method1466(int var1) {
        return this.method1463(this.method1469() + var1);
    }

    public synchronized int method1467() {
        return this.method1469();
    }

    private void method1468(int var1) {
        if (var1 % 2 == 0) {
            this.aLong1231 = 7399601316774831L - (long) var1 * 19L;
        } else {
            this.aLong1231 = -604426031576883L + (long) var1 * 5L;
        }

    }

    private int method1469() {
        return this.aLong1231 > 0L ? (int) ((7399601316774831L - this.aLong1231) / 19L) : (int) ((this.aLong1231 + 604426031576883L) / 5L);
    }
}
