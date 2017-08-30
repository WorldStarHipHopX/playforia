package acannons;

import com.playray.client.SPanel;

public class LobbyPanel extends SPanel {

    public static final int[] anIntArray3924;
    private ClientSettings aClientSettings_3925;
    private LobbyCreateGamePanel aSPanel__3926;
    private LobbyChat lobbyChat;
    private LobbyControlPanel aSPanel_Sub10_3928;
    public static boolean aBoolean3929;
    private static final String[] aStringArray3930 = new String[2];


    public LobbyPanel(ClientSettings var1) {
        super(false);
        this.aClientSettings_3925 = var1;
        this.setSize(var1.anInt774, var1.anInt775);
        this.setBackground(var1.imageManager.method1983("bg-lobby"));
        this.method2456();
    }

    public void method2452(int var1) {
        this.aSPanel__3926.method2457(var1);
    }

    protected void method2453(String var1) {
        this.aClientSettings_3925.aConnection_772.writeData("lobby\t" + var1);
    }

    public void handlePacket(String[] args) {
        boolean var2 = false;
        if (this.aSPanel__3926.handlePacket(args)) {
            var2 = true;
        }

        if (this.lobbyChat.handlePacket(args)) {
            var2 = true;
        }

        if (var2) {
            ;
        }

    }

    public void broadcastMessage(String var1) {
        this.lobbyChat.broadcastMessage(var1);
    }

    private void method2456() {
        this.aSPanel__3926 = new LobbyCreateGamePanel(this.aClientSettings_3925, this.aClientSettings_3925.anInt774 - 10, this.aClientSettings_3925.anInt775 - 135 - 10);
        this.aSPanel__3926.setLocation(5, 5);
        this.add(this.aSPanel__3926);
        this.lobbyChat = new LobbyChat(this.aClientSettings_3925, this.aClientSettings_3925.anInt774 - 100 - 10, 130);
        this.lobbyChat.setLocation(5, this.aClientSettings_3925.anInt775 - 130 - 5);
        this.add(this.lobbyChat);
        this.aSPanel_Sub10_3928 = new LobbyControlPanel(this.aClientSettings_3925, 90, 130);
        this.aSPanel_Sub10_3928.setLocation(this.aClientSettings_3925.anInt774 - 90 - 5, this.aClientSettings_3925.anInt775 - 130 - 5);
        this.add(this.aSPanel_Sub10_3928);
    }

    static {
        aStringArray3930[0] = "lobby\t";
        aStringArray3930[1] = "bg-lobby";
        anIntArray3924 = new int[]{0, 10, 15, 20, 30, 40, 50, 60};
    }
}
