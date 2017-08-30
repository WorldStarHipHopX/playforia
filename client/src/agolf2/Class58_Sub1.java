package agolf2;

import com.aapeli.client.BadWordFilter;
import com.aapeli.client.Parameters;
import com.aapeli.client.Tournament;

public class Class58_Sub1 extends Class58 {

    public AApplet_Sub3_Sub1 anAApplet_Sub3_Sub1_3567;
    public Tournament aTournament3568;
    public GamePlayerSettings aClass59_Sub1_3569;
    public Class56 aClass56_3570;
    public BadWordFilter aBadWordFilter3571;
    public ServerConnection_Sub1 aClass36_Sub1_3572;
    public static boolean aBoolean3573;
    private static final String[] aStringArray3574 = new String[2];


    public Class58_Sub1(AApplet_Sub3_Sub1 var1, Parameters var2) {
        super(var1, var2);
        this.anAApplet_Sub3_Sub1_3567 = var1;
        this.aClass39_Sub1_1191 = new TrackBallOverlays(this);
        String[] var3 = new String[]{"Playray", "Trad"};
        this.aTournament3568 = Tournament.getTournament(var2, var3);
        this.aClass59_Sub1_3569 = new GamePlayerSettings();
        this.aClass56_3570 = new Class56();
        this.aBadWordFilter3571 = null;
    }

    protected void method1437() {
        this.aBadWordFilter3571 = new BadWordFilter(this.textManager);
    }

    protected boolean method1438() {
        this.aClass36_Sub1_3572 = new ServerConnection_Sub1(this);
        return this.aClass36_Sub1_3572.method1184();
    }

    protected void method1439() {
        this.aClass36_Sub1_3572.method1185();
    }

    protected void method1440() {
        if (this.aClass36_Sub1_3572 != null) {
            this.aClass36_Sub1_3572.method1180();
        }

    }

    public boolean method1436() {
        return this.aClass59_Sub1_3569.soundEffects;
    }

    static {
        aStringArray3574[0] = "Trad";
        aStringArray3574[1] = "Playray";
    }
}
