package adraw.game;

import adraw.GameApplet;
import com.aapeli.client.CharacterImage;
import com.aapeli.client.ImageManager;
import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

class GameDrawerInfoPanel extends Canvas {

    private TextManager textManager;
    private ImageManager imageManager;
    private String nameDrawer;
    private String nameGuesser;
    private CharacterImage imageDrawer;
    private CharacterImage imageGuesser;
    private Image image;
    private Graphics graphics;


    protected GameDrawerInfoPanel(TextManager textManager, ImageManager imageManager) {
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.setSize(290, 155);
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics g) {
        if (this.image == null) {
            this.image = this.createImage(290, 155);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.drawImage(this.imageManager.getImage("game-tools-off"), 0, 0, this);
        int var2 = CharacterImage.IMAGE_WIDTH[1];
        int var3 = CharacterImage.IMAGE_HEIGHT[1];
        this.graphics.setColor(GameApplet.colourForegroundDefault);
        if (this.nameDrawer != null && this.imageDrawer != null) {
            this.imageDrawer.draw(this.graphics, 82 - var2 / 2, 82 - var3 / 2, this);
            this.graphics.setFont(GameApplet.fontDialog12b);
            StringDraw.drawString(this.graphics, this.textManager.getGame("GameFaces_Drawer"), 82, 82 - var3 / 2 - 15, 0);
            this.graphics.setFont(GameApplet.fontDialog12);
            StringDraw.drawString(this.graphics, this.nameDrawer, 82, 82 + var3 / 2 + 20, 0);
        }

        if (this.nameGuesser != null && this.imageGuesser != null) {
            this.imageGuesser.draw(this.graphics, 207 - var2 / 2, 82 - var3 / 2, this);
            this.graphics.setFont(GameApplet.fontDialog12b);
            StringDraw.drawString(this.graphics, this.textManager.getGame("GameFaces_Guesser"), 207, 82 - var3 / 2 - 15, 0);
            this.graphics.setFont(GameApplet.fontDialog12);
            StringDraw.drawString(this.graphics, this.nameGuesser, 207, 82 + var3 / 2 + 20, 0);
        }

        g.drawImage(this.image, 0, 0, this);
    }

    protected void setDrawer(String name, CharacterImage image) {
        this.nameDrawer = name;
        this.imageDrawer = image;
        this.nameGuesser = null;
        this.imageGuesser = null;
        this.repaint();
    }

    protected void setGuesser(String name, CharacterImage image) {
        this.nameGuesser = name;
        this.imageGuesser = image;
        this.repaint();
    }
}
