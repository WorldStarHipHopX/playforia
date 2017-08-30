package agolf.game;

import com.aapeli.tools.Tools;

class GamePlayerInfoPanelThread implements Runnable {

    private final GamePlayerInfoPanel gamePlayerInfoPanel;
    private boolean running;


    protected GamePlayerInfoPanelThread(GamePlayerInfoPanel var1) {
        this.gamePlayerInfoPanel = var1;
        this.running = true;
        Thread var2 = new Thread(this);
        var2.setDaemon(true);
        var2.start();
    }

    public void run() {
        do {
            Tools.sleep(1000L);
            if (this.running) {
                this.running = this.gamePlayerInfoPanel.run();
            }
        } while (this.running);

    }

    protected void stopRunning() {
        this.running = false;
    }
}
