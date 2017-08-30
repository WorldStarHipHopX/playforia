package acannons;

import com.playray.tools.Tools;

class GameSomethingrunnable implements Runnable {

    private boolean aBoolean822;
    private final GameAreaPanel gameAreaPanel;


    protected GameSomethingrunnable(GameAreaPanel var1) {
        this.gameAreaPanel = var1;
        this.aBoolean822 = true;
    }

    public void run() {
        do {
            Tools.sleep(1000L);
            if (this.aBoolean822 && this.gameAreaPanel.method2402()) {
                this.aBoolean822 = false;
            }
        } while (this.aBoolean822);

    }

    protected void method1033() {
        this.aBoolean822 = false;
    }
}
