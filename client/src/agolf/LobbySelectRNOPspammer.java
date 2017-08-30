package agolf;

import com.aapeli.tools.Tools;

class LobbySelectRNOPspammer implements Runnable {

    private final LobbySelectPanel lobbySelectPanel;
    private boolean running;


    protected LobbySelectRNOPspammer(LobbySelectPanel lobbySelectPanel) {
        this.lobbySelectPanel = lobbySelectPanel;
        this.running = true;
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public void run() {
        int sleepTime = 10000;

        do {
            this.lobbySelectPanel.requestNumberOfPlayers();
            Tools.sleep((long) sleepTime);
            if (sleepTime < 120000) {
                sleepTime += 5000;
            }
        } while (this.running);

    }

    protected void stop() {
        this.running = false;
    }
}
