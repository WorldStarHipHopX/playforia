package acannons;

import com.playray.tools.QuickTimer;
import com.playray.tools.QuickTimerListener;

class SoundFile implements QuickTimerListener {

    private ClientSettings clientSettings;
    private String name;
    private int length;
    private long lastPlayed;


    protected SoundFile(ClientSettings clientSettings, String name, int var3) {
        this.clientSettings = clientSettings;
        this.name = name;
        this.length = var3;
        clientSettings.soundManager.defineSound(name + ".au");
        this.lastPlayed = 0L;
    }

    public void qtFinished() {
        this.clientSettings.soundManager.play(this.name);
    }

    protected boolean play(int var1) {
        if (var1 < 10) {
            var1 = 0;
        }

        long time = System.currentTimeMillis();
        if (time > this.lastPlayed + (long) this.length - (long) var1) {
            this.lastPlayed = time + (long) var1;
            if (var1 > 0) {
                new QuickTimer(var1, this);
            } else {
                this.clientSettings.soundManager.play(this.name);
            }

            return true;
        }
        return false;
    }

}
