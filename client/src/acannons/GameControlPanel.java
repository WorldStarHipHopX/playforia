package acannons;

import com.playray.client.SPanel;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.QuitConfirm;
import com.playray.multiuser.QuitHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameControlPanel extends SPanel implements ActionListener, QuitHandler {

    private ClientSettings aClientSettings_2666;
    private GamePanel aSPanel__2667;
    private int anInt2668;
    private GlossyButton aGlossyButton2669;
    private GlossyButton aGlossyButton2670;
    private GlossyButton aGlossyButton2671;
    private int anInt2672;
    private boolean aBoolean2673;
    private QuitConfirm aQuitConfirm2674;
    private static final String[] aStringArray2675 = new String[9];


    protected GameControlPanel(ClientSettings var1, GamePanel var2, int var3, int var4) {
        super(false);
        this.aClientSettings_2666 = var1;
        this.aSPanel__2667 = var2;
        this.anInt2668 = var3;
        this.setSize(var3, var4);
        this.method2416();
    }

    public void actionPerformed(ActionEvent var1) {
        this.method2420();
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton2669) {
            this.aSPanel__2667.method2433();
        } else if (var2 == this.aGlossyButton2670) {
            this.method2418();
            this.aSPanel__2667.method2429();
            this.aSPanel__2667.method2424("newgame");
        } else {
            if (var2 == this.aGlossyButton2671) {
                if (this.aBoolean2673) {
                    this.aSPanel__2667.method2434();
                    this.method2419();
                } else {
                    this.userQuit();
                }
            }

        }
    }

    public void userQuit() {
        this.method2420();
        this.aClientSettings_2666.gameApplet.setGameState(0);
        this.aSPanel__2667.method2435();
        this.aSPanel__2667.method2424("quit");
        this.aClientSettings_2666.gameApplet.method2291();
    }

    public void userCancel() {
        this.method2420();
    }

    protected boolean handlePacket(String[] var1) {
        if (var1[1].equals("gameinfo")) {
            this.anInt2672 = Integer.parseInt(var1[2]);
            return true;
        } else if (var1[1].equals("part")) {
            if (Integer.parseInt(var1[3]) != 3) {
                --this.anInt2672;
                if (this.anInt2672 <= 1) {
                    this.method2418();
                }
            }

            return true;
        } else if (var1[1].equals("startgame")) {
            this.anInt2672 = Integer.parseInt(var1[3]);
            this.aGlossyButton2671.setColor(2);
            this.aBoolean2673 = true;
            return true;
        } else if (var1[1].equals("endgame")) {
            this.aGlossyButton2671.setColor(4);
            if (this.anInt2672 >= 2) {
                this.method2417();
            }

            this.aBoolean2673 = false;
            return true;
        } else {
            return false;
        }
    }

    private void method2416() {
        this.aGlossyButton2669 = new GlossyButton(this.aClientSettings_2666.textManager.method2039("GameControl_Settings"), 3);
        this.aGlossyButton2669.setBounds(0, 0, this.anInt2668, 20);
        this.aGlossyButton2669.addActionListener(this);
        this.add(this.aGlossyButton2669);
        this.aGlossyButton2670 = new GlossyButton(this.aClientSettings_2666.textManager.method2039("GameControl_NewGame"), 1);
        this.aGlossyButton2670.setBounds(0, 25, this.anInt2668, 20);
        this.aGlossyButton2670.addActionListener(this);
        this.aGlossyButton2670.setVisible(false);
        this.add(this.aGlossyButton2670);
        this.aGlossyButton2671 = new GlossyButton(this.aClientSettings_2666.textManager.method2039("GameControl_Quit"), 4);
        this.aGlossyButton2671.setBounds(0, 50, this.anInt2668, 20);
        this.aGlossyButton2671.addActionListener(this);
        this.add(this.aGlossyButton2671);
        this.aBoolean2673 = false;
    }

    private void method2417() {
        this.aGlossyButton2670.setVisible(true);
    }

    private void method2418() {
        this.aGlossyButton2670.setVisible(false);
    }

    private void method2419() {
        this.method2420();
        this.aQuitConfirm2674 = new QuitConfirm(this.aClientSettings_2666.textManager, this.aClientSettings_2666.imageManager, this);
        this.aQuitConfirm2674.open(this.aClientSettings_2666.gameApplet);
    }

    private void method2420() {
        if (this.aQuitConfirm2674 != null) {
            this.aQuitConfirm2674.close();
            this.aQuitConfirm2674 = null;
            this.aClientSettings_2666.gameApplet.requestFocus();
        }
    }

    static {
        aStringArray2675[0] = "quit";
        aStringArray2675[1] = "endgame";
        aStringArray2675[2] = "startgame";
        aStringArray2675[3] = "part";
        aStringArray2675[4] = "gameinfo";
        aStringArray2675[5] = "newgame";
        aStringArray2675[6] = "GameControl_Quit";
        aStringArray2675[7] = "GameControl_Settings";
        aStringArray2675[8] = "GameControl_NewGame";
    }
}
