package agolf2;

import java.util.StringTokenizer;

public class GamePlayerSettings extends GamePersonalSettings {

    public static final String aString3576 = "9^1^1";
    public static final String aString3577 = "2^9";
    public static final String aString3578 = "2^9^-^1^1^3^3^1^0^1";
    public boolean aBoolean3579 = false;
    public String aString3580;
    public String aString3581;
    public String aString3582;
    public boolean aBoolean3583;
    public boolean aBoolean3584;
    public String aString3585;
    public String aString3586;
    public boolean aBoolean3587;
    public boolean aBoolean3588;
    public boolean beepOnTurn;

    protected GamePlayerSettings() {
        super(false);
        this.aString3580 = aString3576;
        this.aString3581 = "";
        this.aString3582 = "";
        this.aBoolean3583 = true;
        this.aBoolean3584 = false;
        this.aString3585 = aString3577;
        this.aString3586 = aString3578;
        this.aBoolean3587 = false;
        this.aBoolean3588 = true;
        this.beepOnTurn = true;
    }

    protected void init(String var1) {
        try {
            int var2 = var1.indexOf(':');
            int var3 = Integer.parseInt(var1.substring(0, var2));
            if (var3 != 1 && var3 != 2 && var3 != 3) {
                return;
            }

            var1 = var1.substring(var2 + 1);
            int var4;
            if (var3 == 2) {
                while ((var4 = var1.indexOf(",,")) > 0) {
                    var1 = var1.substring(0, var4) + ",-," + var1.substring(var4 + 2);
                }
            }

            StringTokenizer var6 = new StringTokenizer(var1, ",");
            if (var3 == 3) {
                this.aBoolean3579 = this.string2bool(var6.nextToken());
            }

            this.aString3580 = var6.nextToken();
            if (var3 == 2 || var3 == 3) {
                this.aString3581 = this.method1448(var6.nextToken());
            }

            if (var3 == 3) {
                this.aString3582 = this.method1448(var6.nextToken());
            }

            this.aBoolean3583 = this.string2bool(var6.nextToken());
            this.aBoolean3584 = this.string2bool(var6.nextToken());
            this.aString3585 = var6.nextToken();
            this.aString3586 = var6.nextToken();
            this.aBoolean3587 = this.string2bool(var6.nextToken());
            this.aBoolean3588 = this.string2bool(var6.nextToken());
            this.smoothGraphics = this.string2bool(var6.nextToken());
            this.threedeeLights = this.string2bool(var6.nextToken());
            this.threedeeBall = this.string2bool(var6.nextToken());
            this.soundEffects = this.string2bool(var6.nextToken());
            this.beepOnTurn = this.string2bool(var6.nextToken());
        } catch (Exception var5) {
            ;
        }

    }

    protected String getPlayerString() {
        return "3:" + this.bool2string(this.aBoolean3579) + "," + this.aString3580 + "," + this.method1447(this.aString3581) + "," + this.method1447(this.aString3582) + "," + this.bool2string(this.aBoolean3583) + "," + this.bool2string(this.aBoolean3584) + "," + this.aString3585 + "," + this.aString3586 + "," + this.bool2string(this.aBoolean3587) + "," + this.bool2string(this.aBoolean3588) + "," + this.bool2string(this.smoothGraphics) + "," + this.bool2string(this.threedeeLights) + "," + this.bool2string(this.threedeeBall) + "," + this.bool2string(this.soundEffects) + "," + this.bool2string(this.beepOnTurn);
    }

    private String method1447(String var1) {
        return var1.length() == 0 ? "-" : var1;
    }

    private String method1448(String var1) {
        return var1.equals("-") ? "" : var1;
    }
}
