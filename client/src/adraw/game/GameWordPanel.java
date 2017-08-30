package adraw.game;

import adraw.GameApplet;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWordPanel extends Panel implements ActionListener {

    private static final Color aColor304 = new Color(248, 248, 248);
    private GameApplet gameApplet;
    private TextManager textManager;
    private boolean aBoolean307;
    private int anInt308;
    private int anInt309;
    private String drawWord;
    private String drawWordType;
    private String guessWordHint;
    private String guessWordType;
    private boolean aBoolean314;
    private ColorButton aColorButton315;
    private boolean aBoolean316;
    private Thread_Sub1 aThread_Sub1_317;
    private Image image;
    private Graphics graphics;


    protected GameWordPanel(GameApplet gameApplet, TextManager textManager) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.setSize(465, 29);
        this.setLayout((LayoutManager) null);
        this.aColorButton315 = new ColorButton();
        this.aColorButton315.setBounds(5, 5, 19, 19);
        this.aColorButton315.addActionListener(this);
        this.aBoolean316 = true;
        this.aColorButton315.setLabel("<<");
        this.repaint();
        this.aBoolean314 = true;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        if (this.image == null) {
            this.image = this.createImage(465, 29);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.setColor(aColor304);
        this.graphics.fillRect(0, 0, 465, 29);
        this.graphics.setColor(Color.gray);
        this.graphics.drawRect(0, 0, 464, 28);
        this.graphics.setColor(this.gameApplet.colourForeground);
        String hint = this.guessWordHint;
        String type = this.guessWordType;
        if (this.aBoolean307 && this.aBoolean316) {
            hint = this.drawWord;
            type = this.drawWordType;
        }

        int var4 = this.aBoolean307 ? 34 : 5;
        if (hint != null) {
            this.graphics.setFont(GameApplet.fontSerif20);
            var4 += this.gameApplet.drawText(this.graphics, hint + "  ", var4, 21, -1);
        }

        if (type != null && this.aBoolean314) {
            this.graphics.setFont(GameApplet.fontDialog14b);
            this.gameApplet.drawText(this.graphics, "(" + type + ")", var4, 21, -1);
        }

        int var5 = this.anInt309;
        if (var5 > 0) {
            var4 = 460;
            if (!this.aBoolean307) {
                this.graphics.setFont(GameApplet.fontDialog14b);
                var4 -= this.gameApplet.drawText(this.graphics, "  " + this.textManager.getGame("GameWord_Score", 200 + 600 * this.anInt309 / this.anInt308), var4, 21, 1);
            }

            this.graphics.setFont(GameApplet.fontSerif20);
            this.gameApplet.drawText(this.graphics, this.textManager.getTime((long) var5), var4, 21, 1);
        }

        g.drawImage(this.image, 0, 0, this);
    }

    public void actionPerformed(ActionEvent evt) {
        boolean invertleld = !this.aBoolean316;
        this.aBoolean316 = invertleld;
        this.aColorButton315.setLabel(invertleld ? "<<" : ">>");
        this.repaint();
    }

    protected static String addSpaces(String var0) {
        int var1 = var0.length();
        StringBuffer var2 = new StringBuffer(var1 * 2 - 1);

        for (int var3 = 0; var3 < var1; ++var3) {
            if (var3 > 0) {
                var2.append(' ');
            }

            var2.append(var0.charAt(var3));
        }

        return var2.toString();
    }

    protected boolean handlePacket(String[] args) {
        if (args[1].equals("gameinfo")) {
            if (Integer.parseInt(args[6]) > 0) {
                this.aBoolean314 = false;
            }

            if (args[7].equals("t")) {
                this.aBoolean316 = false;
                this.aColorButton315.setLabel(">>");
                this.repaint();
            }

            return true;
        } else if (args[1].equals("hint")) {
            if (args[2].length() > 1) {
                this.guessWordHint = addSpaces(args[2]);
            } else {
                this.guessWordHint = null;
            }

            this.guessWordType = this.getWordType(Integer.parseInt(args[3]));
            this.anInt309 = Integer.parseInt(args[4]);
            this.repaint();
            return true;
        } else {
            return false;
        }
    }

    protected void method307(boolean var1, String[] var2) {
        this.aBoolean307 = var1;
        this.anInt308 = this.anInt309 = Integer.parseInt(var2[2]);
        if (this.aBoolean307) {
            this.drawWord = addSpaces(var2[4]);
            this.drawWordType = this.getWordType(Integer.parseInt(var2[5]));
            this.add(this.aColorButton315);
        } else {
            this.drawWord = this.drawWordType = null;
        }

        this.guessWordHint = this.guessWordType = null;
        this.repaint();
    }

    protected void method308() {
        if (this.aThread_Sub1_317 != null) {
            this.aThread_Sub1_317.stopRunning();
            this.aThread_Sub1_317 = null;
        }

        this.aThread_Sub1_317 = new Thread_Sub1(this);
        this.aThread_Sub1_317.start();
    }

    protected void method309(String var1) {
        if (this.aThread_Sub1_317 != null) {
            this.aThread_Sub1_317.stopRunning();
            this.aThread_Sub1_317 = null;
        }

        this.anInt309 = 0;
        this.aBoolean307 = false;
        this.remove(this.aColorButton315);
        this.guessWordHint = addSpaces(var1);
        this.repaint();
    }

    protected void stop() {
        if (this.aThread_Sub1_317 != null) {
            this.aThread_Sub1_317.stopRunning();
            this.aThread_Sub1_317 = null;
        }

    }

    private String getWordType(int id) {
        return id == 0 ? this.textManager.getGame("GameWord_Noun") : (id == 1 ? this.textManager.getGame("GameWord_Verb") : (id == 2 ? this.textManager.getGame("GameWord_Adjective") : null));
    }

    protected void method312() {
        if (this.anInt309 > 0) {
            --this.anInt309;
        } else if (this.aThread_Sub1_317 != null) {
            this.aThread_Sub1_317.stopRunning();
            this.aThread_Sub1_317 = null;
        }

        this.repaint();
    }
}
