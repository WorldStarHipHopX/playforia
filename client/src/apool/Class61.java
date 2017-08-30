package apool;

import java.util.StringTokenizer;

public class Class61 {

    public boolean aBoolean1217 = false;
    public int anInt1218 = 1;
    public int anInt1219 = 5;
    public int anInt1220 = 3;
    public boolean playSounds = true;
    public boolean showShadows = true;
    private String aString1223;
    public boolean aBoolean1224;
    public boolean aBoolean1225;
    public boolean aBoolean1226;
    public boolean aBoolean1227;

    protected Class61() {
        this.aBoolean1224 = this.aBoolean1225 = false;
        this.aBoolean1226 = false;
        this.aBoolean1227 = true;
    }

    protected void method1454(String var1) {
        this.aString1223 = var1;

        try {
            int var2 = var1.indexOf(':');
            int var3 = Integer.parseInt(var1.substring(0, var2));
            if (var3 != 5) {
                return;
            }

            StringTokenizer var4 = new StringTokenizer(var1.substring(var2 + 1), ",");
            this.aBoolean1217 = this.string2bool(var4.nextToken());
            this.anInt1218 = Integer.parseInt(var4.nextToken());
            this.anInt1219 = Integer.parseInt(var4.nextToken());
            this.anInt1220 = Integer.parseInt(var4.nextToken());
            this.playSounds = this.string2bool(var4.nextToken());
            this.showShadows = this.string2bool(var4.nextToken());
        } catch (Exception var5) {
            ;
        }

    }

    protected String method1455() {
        String var1 = this.method1456();
        if (var1.equals(this.aString1223)) {
            return null;
        } else {
            this.aString1223 = var1;
            return var1;
        }
    }

    private String method1456() {
        return "5:" + this.bool2string(this.aBoolean1217) + "," + this.anInt1218 + "," + this.anInt1219 + "," + this.anInt1220 + "," + this.bool2string(this.playSounds) + "," + this.bool2string(this.showShadows);
    }

    private String bool2string(boolean var1) {
        return var1 ? "t" : "f";
    }

    private boolean string2bool(String var1) {
        return var1.equals("t");
    }

}
