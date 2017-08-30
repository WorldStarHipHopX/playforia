package adraw.game;

import com.aapeli.tools.Tools;

class Thread_Sub1 extends Thread {

    private final GameWordPanel gameWordPanel;
    private boolean running;


    protected Thread_Sub1(GameWordPanel gameWordPanel) {
        this.gameWordPanel = gameWordPanel;
        this.running = true;
    }

    public void run() {
        do {
            Tools.sleep(1000L);
            if (this.running) {
                this.gameWordPanel.method312();
            }
        } while (this.running);

    }

    protected void stopRunning() {
        this.running = false;
    }
}
