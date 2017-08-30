package acannons;

import com.playray.tools.Tools;

public class SoundManager {

    private static final int[] anIntArray738 = new int[]{1152, 1296, 1438, 1581, 1723, 1872, 2013, 2161};
    private static final int[] anIntArray739 = new int[]{1664, 1789, 2048, 2304, 2560};
    private static final int[] anIntArray740 = new int[]{1147, 1156, 1756, 1502, 2327, 1930, 2046, 2267, 2333, 2262, 2405, 4783};
    private static final int[] anIntArray741 = new int[]{2879, 1882};
    private static final int[] anIntArray742 = new int[]{1358};
    private ClientSettings clientSettings;
    private SoundFile[] soundsShoot;
    private SoundFile[] soundsWhistle;
    private SoundFile[] soundsExplosion;
    private SoundFile[] soundsBurn;
    private SoundFile[] soundsDud;
    private int anInt749;
    private int anInt750;
    private double aDouble751;

    public SoundManager(ClientSettings clientSettings) {
        this.clientSettings = clientSettings;
        this.soundsShoot = new SoundFile[anIntArray738.length];

        int var;
        for (var = 0; var < anIntArray738.length; ++var) {
            this.soundsShoot[var] = new SoundFile(clientSettings, "shoot-" + var, anIntArray738[var]);
        }

        this.soundsWhistle = new SoundFile[anIntArray739.length];

        for (var = 0; var < anIntArray739.length; ++var) {
            this.soundsWhistle[var] = new SoundFile(clientSettings, "whistle-" + var, anIntArray739[var]);
        }

        this.soundsExplosion = new SoundFile[anIntArray740.length];

        for (var = 0; var < anIntArray740.length; ++var) {
            this.soundsExplosion[var] = new SoundFile(clientSettings, "explosion-" + var, anIntArray740[var]);
        }

        this.soundsBurn = new SoundFile[anIntArray741.length];

        for (var = 0; var < anIntArray741.length; ++var) {
            this.soundsBurn[var] = new SoundFile(clientSettings, "burn-" + var, anIntArray741[var]);
        }

        this.soundsDud = new SoundFile[anIntArray742.length];

        for (var = 0; var < anIntArray742.length; ++var) {
            this.soundsDud[var] = new SoundFile(clientSettings, "dud-" + var, anIntArray742[var]);
        }

    }

    protected void method974(int var1, int var2, double var3) {
        this.anInt749 = var1;
        this.anInt750 = var2;
        this.aDouble751 = var3;
    }

    protected void method975(double var1, double var3) {
        if (this.clientSettings.aPlayerInfo_764.aBoolean780) {
            double var5 = Tools.getDistance((double) this.anInt749, (double) this.anInt750, var1, var3);
            double var7 = var5 / this.aDouble751;
            int var9 = (int) (var7 * (double) anIntArray738.length);
            int var10 = (int) (350.0D * var7);
            this.method980(this.soundsShoot, var9, var10);
        }
    }

    protected void method976(double var1) {
        if (this.clientSettings.aPlayerInfo_764.aBoolean780) {
            double var3 = var1 / 100.0D;
            if (var3 <= 1.0D) {
                int var5 = (int) (var3 * (double) anIntArray739.length);
                this.method980(this.soundsWhistle, var5, 0);
            }
        }
    }

    protected void method977(double var1, double var3, int var5) {
        if (this.clientSettings.aPlayerInfo_764.aBoolean780) {
            double var6 = Tools.getDistance((double) this.anInt749, (double) this.anInt750, var1, var3);
            double var8 = var6 / this.aDouble751;
            double var10 = (double) var5 / 200.0D;
            int var12 = (int) (var10 * (double) anIntArray740.length);
            int var13 = (int) (350.0D * var8);
            this.method980(this.soundsExplosion, var12, var13);
        }
    }

    protected void method978() {
        if (this.clientSettings.aPlayerInfo_764.aBoolean780) {
            this.method980(this.soundsBurn, 0, 0);
        }
    }

    protected void method979() {
        if (this.clientSettings.aPlayerInfo_764.aBoolean780) {
            this.method980(this.soundsDud, 0, 0);
        }
    }

    private void method980(SoundFile[] var1, int var2, int var3) {
        if (var2 < 0) {
            var2 = 0;
        } else if (var2 >= var1.length) {
            var2 = var1.length - 1;
        }

        if (!var1[var2].play(var3)) {
            int var4 = Math.max(Math.abs(var2 - 0), Math.abs(var2 - (var1.length - 1)));

            for (int var5 = 1; var5 <= var4; ++var5) {
                if (var2 - var5 >= 0 && var1[var2 - var5].play(var3)) {
                    return;
                }

                if (var2 + var5 < var1.length && var1[var2 + var5].play(var3)) {
                    return;
                }
            }

        }
    }
}
