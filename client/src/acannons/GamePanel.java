package acannons;

import com.playray.client.SPanel;

public class GamePanel extends SPanel {

    private ClientSettings clientSettings;
    private GameWaitPanel gameWaitPanel;
    private GameAreaPanel gameAreaPanel;
    private GameChatPanel gameChatPanel;
    private SPanel_Sub7 aSPanel_Sub7_3864;
    private GameRoundInfoPanel gameRoundInfoPanel;
    private GameControlPanel gameControlPanel;
    private GameSettingsFrame aJFrame__3867;
    private long aLong3868;
    public static boolean aBoolean3869;
    private static final String[] aStringArray3870 = new String[3];


    public GamePanel(ClientSettings var1) {
        super(false);
        this.clientSettings = var1;
        this.setSize(var1.anInt774, var1.anInt775);
        this.setBackground(var1.imageManager.method1983("bg-game"));
        this.aLong3868 = System.currentTimeMillis() + 5000L;
        this.method2436();
    }

    public void updateUI(Object var1) {
        if (this.gameWaitPanel != null) {
            this.remove(this.gameWaitPanel);
            this.add(this.gameAreaPanel);
            this.gameWaitPanel = null;
        }

        this.repaint();
    }

    public void handlePacket(String[] var1) {
        boolean var2 = false;
        if (this.gameWaitPanel != null && this.gameWaitPanel.handlePacket(var1)) {
            var2 = true;
        }

        if (this.aJFrame__3867.handlePacket(var1)) {
            var2 = true;
        }

        if (this.gameChatPanel.handlePacket(var1)) {
            var2 = true;
        }

        if (this.gameRoundInfoPanel.handlePacket(var1)) {
            var2 = true;
        }

        if (this.aSPanel_Sub7_3864.handlePacket(var1)) {
            var2 = true;
        }

        if (this.gameAreaPanel.handlePacket(var1)) {
            var2 = true;
        }

        if (this.gameControlPanel.handlePacket(var1)) {
            var2 = true;
        }

        if (var1[1].equals("startgame") && this.gameWaitPanel != null) {
            this.callUpdateUI((Object) null);
            var2 = true;
        }

        if (var2) {
            ;
        }

    }

    protected String method2422(int var1) {
        return this.aSPanel_Sub7_3864.method2440(var1);
    }

    public void broadcastMessage(String var1) {
        this.gameChatPanel.broadcastMessage(var1);
    }

    public void method2424(String var1) {
        this.clientSettings.aConnection_772.writeData("game\t" + var1);
    }

    public void method2425() {
        this.aSPanel_Sub7_3864.repaint();
    }

    protected double[] method2426() {
        return this.gameAreaPanel.method2362();
    }

    protected void method2427(String var1) {
        this.gameAreaPanel.method2363(var1);
    }

    public void method2428(int var1, int var2) {
        this.aSPanel_Sub7_3864.method2441(var1, var2);
    }

    protected void method2429() {
        this.gameAreaPanel.method2364();
    }

    protected void method2430() {
        long var1 = System.currentTimeMillis();
        if (var1 >= this.aLong3868 + 5000L) {
            this.aLong3868 = var1;
            this.clientSettings.soundManager.playNotify();
        }
    }

    public String[] method2431() {
        return this.aSPanel_Sub7_3864.method2443();
    }

    public String method2432(String var1) {
        return var1.length() <= 1 ? null : var1;
    }

    protected void method2433() {
        this.aJFrame__3867.method2337();
    }

    protected void method2434() {
        this.aJFrame__3867.hideFrame();
    }

    protected void method2435() {
        this.aJFrame__3867.dispose();
        this.gameAreaPanel.method2379();
    }

    private void method2436() {
        this.gameAreaPanel = new GameAreaPanel(this.clientSettings, this);
        this.gameAreaPanel.setLocation(5, 5);
        this.gameWaitPanel = new GameWaitPanel(this.clientSettings, this);
        this.gameWaitPanel.setLocation(25, 25);
        this.add(this.gameWaitPanel);
        this.gameChatPanel = new GameChatPanel(this.clientSettings, this, 500, 120);
        this.gameChatPanel.setLocation(5, 416);
        this.add(this.gameChatPanel);
        this.aSPanel_Sub7_3864 = new SPanel_Sub7(this.clientSettings, this, this.gameAreaPanel, 140, 120);
        this.aSPanel_Sub7_3864.setLocation(515, 416);
        this.add(this.aSPanel_Sub7_3864);
        this.gameRoundInfoPanel = new GameRoundInfoPanel(this.clientSettings, 100, 36);
        this.gameRoundInfoPanel.setLocation(664, 416);
        this.add(this.gameRoundInfoPanel);
        this.gameControlPanel = new GameControlPanel(this.clientSettings, this, 100, 70);
        this.gameControlPanel.setLocation(664, 466);
        this.add(this.gameControlPanel);
        this.aJFrame__3867 = new GameSettingsFrame(this.clientSettings, this, this.gameAreaPanel);
    }

    static {
        aStringArray3870[0] = "game\t";
        aStringArray3870[1] = "startgame";
        aStringArray3870[2] = "bg-game";
    }
}
