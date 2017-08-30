package agolf2;


public abstract class GamePersonalSettings {

    public boolean smoothGraphics;
    public boolean threedeeLights;
    public boolean threedeeBall;
    public boolean soundEffects;
    private String aString1198;


    protected GamePersonalSettings(boolean disableSoundEffects) {
        this.smoothGraphics = this.threedeeLights = this.threedeeBall = true;
        this.soundEffects = !disableSoundEffects;
    }

    public void method1441(String var1) {
        this.aString1198 = var1;
        this.init(var1);
    }

    public String method1442() {
        String var1 = this.getPlayerString();
        if (var1.equals(this.aString1198)) {
            return null;
        } else {
            this.aString1198 = var1;
            return var1;
        }
    }

    protected abstract void init(String var1);

    protected abstract String getPlayerString();

    protected String bool2string(boolean b) {
        return b ? "t" : "f";
    }

    protected boolean string2bool(String s) {
        return s.equals("t");
    }
}
