package apool;


public class GameReplay {

    private int version;
    private int anInt1251;
    private long aLong1252;
    private String aString1253;

    public GameReplay(String var1) {
        var1 = var1.replace('(', '<').replace(')', '>');
        int var2 = var1.indexOf(':');
        this.version = Integer.parseInt(var1.substring(0, var2));
        if (this.version < 3) {
            System.out.println("WARNING! Replay version (" + this.version + ") is less than current (4), replay may not work correctly");
        }

        var1 = var1.substring(var2 + 1);
        var2 = var1.indexOf(',');
        this.anInt1251 = Integer.parseInt(var1.substring(0, var2));
        var1 = var1.substring(var2 + 1);
        var2 = var1.indexOf(',');
        this.aLong1252 = Long.parseLong(var1.substring(0, var2));
        this.aString1253 = var1.substring(var2 + 1);
    }

    protected int method1522() {
        return this.anInt1251;
    }

    protected long method1523() {
        return this.aLong1252;
    }

    protected int method1524() {
        return this.aString1253.length() == 0 ? 0 : (this.aString1253.charAt(0) == '-' ? 1 : 3);
    }

    protected String method1525() {
        int var1 = this.method1524();
        int var2 = -1;
        if (this.version == 1) {
            var2 = var1 == 1 ? 4 : 8;
        }

        if (this.version >= 2) {
            var2 = var1 == 1 ? 3 : 7;
        }

        if (var1 == 1) {
            this.aString1253 = this.aString1253.substring(1);
        }

        String var3 = this.aString1253.substring(0, var2);
        this.aString1253 = this.aString1253.substring(var2);
        return var3;
    }
}
