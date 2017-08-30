package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.UserList;
import com.playray.multiuser.UserListHandler;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SPanel_Sub21 extends SPanel implements Runnable, UserListHandler, ActionListener {

    private Class60 aClass60_2676;
    private boolean aBoolean2677;
    private LobbyHeaderPanel aSPanel__2678;
    private LobbyCoinsPanel aSPanel__2679;
    private LobbyControlPanel aSPanel__2680;
    private LobbyChat aLobby_Chat_2681;
    private LobbyGameListPanel aSPanel__2682;
    private GlossyButton aGlossyButton2683;
    private int anInt2684;
    private long aLong2685;
    private Thread aThread2686;
    private boolean aBoolean2687;
    private boolean aBoolean2688;
    private boolean aBoolean2689;
    public static boolean aBoolean2690;
    private static final String[] aStringArray2691 = new String[12];


    public SPanel_Sub21(Class60 var1) {
        this.aClass60_2676 = var1;
        this.aBoolean2677 = var1.aBoolean1205;
        this.setSize(var1.anInt1201, var1.anInt1202);
        this.setBackground(var1.imageManager.method1983("bg-multi"), -20, 0);
        this.aBoolean2688 = true;
        this.aBoolean2689 = false;
        this.anInt2684 = -1;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean2688) {
            this.aBoolean2688 = false;
            var1.drawImage(this.aClass60_2676.imageManager.method1983("lobby_header"), this.aClass60_2676.anInt1201 / 2 - 370, 0, this);
            this.useCurrentBufferAsBackground();
        } else {
            if (this.anInt2684 >= 0) {
                var1.setFont(GameApplet.aFont4814);
                var1.setColor(Color.white);
                StringDraw.drawString(var1, this.aClass60_2676.textManager.method2039("GameName_" + GameApplet.aStringArray4805[this.anInt2684]), 80, 34, -1);
            }

        }
    }

    public void updateUI(Object var1) {
        boolean var2 = ((Boolean) ((Boolean) var1)).booleanValue();
        byte var3 = 60;
        short var4 = 580;
        int var5 = this.aClass60_2676.anInt1201 - 5 - 5 - var4 - 5;
        short var6 = 155;
        int var7 = this.aClass60_2676.anInt1202 - var3 - 5 - 5 - var6 - 5;
        this.aSPanel__2678 = new LobbyHeaderPanel(this.aClass60_2676, this, this.anInt2684 == 2, var4 - 170 - 5, var6);
        this.aSPanel__2678.setLocation(5, var3);
        this.add(this.aSPanel__2678);
        this.aSPanel__2679 = new LobbyCoinsPanel(this.aClass60_2676, this, this.aSPanel__2678, var6);
        this.aSPanel__2679.setLocation(5 + var4 - 170, var3);
        this.add(this.aSPanel__2679);
        this.aSPanel__2680 = new LobbyControlPanel(this.aClass60_2676, this, var2, var5, var6);
        this.aSPanel__2680.setLocation(5 + var4 + 5, var3);
        this.add(this.aSPanel__2680);
        this.aLobby_Chat_2681 = new LobbyChat(this.aClass60_2676, this, var2, var4, var7);
        this.aLobby_Chat_2681.setLocation(5, var3 + var6 + 5);
        this.aLobby_Chat_2681.setAlpha(208);
        this.add(this.aLobby_Chat_2681);
        this.aSPanel__2682 = new LobbyGameListPanel(this.aClass60_2676, this, var5, var7 - 23);
        this.aSPanel__2682.setLocation(5 + var4 + 5, var3 + var6 + 5);
        this.add(this.aSPanel__2682);
        this.aGlossyButton2683 = new GlossyButton(this.aClass60_2676.textManager.method2039("Lobby_" + (!this.aBoolean2677 ? "Back" : "Quit")), !this.aBoolean2677 ? 4 : 2);
        this.aGlossyButton2683.setBounds(this.aClass60_2676.anInt1201 - 30 - 140, 11, 140, 33);
        this.aGlossyButton2683.addActionListener(this);
        this.add(this.aGlossyButton2683);
    }

    public void run() {
        do {
            Tools.sleep(1000L);
            if (this.aBoolean2687) {
                int var1 = (int) (System.currentTimeMillis() - this.aLong2685);
                if (var1 > 1800000) {
                    this.aSPanel__2680.method2491();
                }

                if (var1 > 3600000) {
                    this.method2585();
                }
            }
        } while (this.aBoolean2687);

    }

    public void openPlayerCard(String var1) {
        this.aClass60_2676.gameApplet.method2318(var1);
    }

    public void adminCommand(String var1, String var2) {
        this.method2580("command\t" + var1 + "\t" + var2);
    }

    public void adminCommand(String var1, String var2, String var3) {
        this.method2580("command\t" + var1 + "\t" + var2 + "\t" + var3);
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.aClass60_2676.gameApplet.aSynchronizedBool_4803.method1460()) {
            this.method2576();
            if (var1.getSource() == this.aGlossyButton2683) {
                this.method2585();
            }

        }
    }

    public void method2573() {
        this.method2574(true);
        this.method2576();
        if (this.aClass60_2676.gameApplet.method2310() == 0) {
            this.aBoolean2687 = true;
            this.aThread2686 = new Thread(this);
            this.aThread2686.setDaemon(true);
            this.aThread2686.start();
        }

    }

    public void method2574(boolean var1) {
        this.aBoolean2687 = false;
        if (var1 && this.aThread2686 != null) {
            this.aThread2686.interrupt();
        }

        this.aThread2686 = null;
    }

    public void method2575(String[] var1) {
        if (var1[1].equals("gameid")) {
            this.anInt2684 = Integer.parseInt(var1[2]);
            this.callUpdateUI(new Boolean(var1[3].equals("t")));
            this.repaint();
        } else if (this.aSPanel__2678 == null || !this.aSPanel__2678.method2505(var1)) {
            if (this.aSPanel__2682 == null || !this.aSPanel__2682.method2494(var1)) {
                if (this.aLobby_Chat_2681 != null && this.aLobby_Chat_2681.method2963(var1)) {
                    ;
                }

            }
        }
    }

    protected void method2576() {
        this.aLong2685 = System.currentTimeMillis();
    }

    protected void method2577(boolean var1) {
        this.aLobby_Chat_2681.method2964((String) null, var1);
    }

    public void method2578(String var1) {
        this.aLobby_Chat_2681.broadcastMessage(var1);
    }

    protected void method2579(String var1) {
        this.aLobby_Chat_2681.addMessage(var1);
    }

    public void method2580(String var1) {
        this.method2586(var1, false);
    }

    public void method2581() {
        this.aLobby_Chat_2681.method2966();
    }

    protected UserList method2582() {
        return this.aLobby_Chat_2681 == null ? null : this.aLobby_Chat_2681.gui_userlist;
    }

    protected void method2583() {
        this.aSPanel__2678.method2506();
        this.method2580("nc\t" + (this.aClass60_2676.aClass61_1207.aBoolean1226 ? 't' : 'f'));
        this.method2577(this.aClass60_2676.aClass61_1207.aBoolean1226);
    }

    protected void method2584() {
        this.aSPanel__2678.method2507();
        this.aLobby_Chat_2681.method2965((String) null, this.aClass60_2676.aClass61_1207.aBoolean1217);
        this.method2580("cg\t" + (this.aClass60_2676.aClass61_1207.aBoolean1217 ? 't' : 'f'));
    }

    private void method2585() {
        this.aSPanel__2678.method2508();
        this.aBoolean2689 = true;
        if (!this.aBoolean2677) {
            this.aClass60_2676.gameApplet.method2304(0);
            this.method2586("back", true);
        } else {
            this.aClass60_2676.gameApplet.method2325(true);
        }

    }

    private void method2586(String var1, boolean var2) {
        if (!this.aBoolean2689 || var2) {
            this.aClass60_2676.connection.method1475("lobby\t" + var1);
        }

    }

    static {
        aStringArray2691[0] = "gameid";
        aStringArray2691[1] = "back";
        aStringArray2691[2] = "command\t";
        aStringArray2691[3] = "Quit";
        aStringArray2691[4] = "Back";
        aStringArray2691[5] = "Lobby_";
        aStringArray2691[6] = "lobby\t";
        aStringArray2691[7] = "lobby_header";
        aStringArray2691[8] = "GameName_";
        aStringArray2691[9] = "nc\t";
        aStringArray2691[10] = "cg\t";
        aStringArray2691[11] = "bg-multi";
    }
}
