package adraw.game;

import adraw.GameApplet;
import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GameDrawingToolsPanel extends Panel implements ActionListener, MouseListener {

    private static final int[] toolSetX = {182, 63, 15};
    private static final int[] toolSetNumTools = {12, 16, 4};
    private static final int[] toolSetWidthTiles = {4, 4, 1};
    private TextManager textManager;
    private ImageManager imageManager;
    private GameDrawingCanvas gameDrawingCanvas;
    private ColorButton buttonFill;
    private ColorButton buttonClear;
    private ColorButton buttonUndo;
    private int[] toolSetSelected;
    private boolean isDrawing;
    private Image image;
    private Graphics graphics;

    protected GameDrawingToolsPanel(TextManager textManager, ImageManager imageManager) {
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.setSize(290, 155);
        this.toolSetSelected = new int[3];
        this.isDrawing = false;
        this.create();
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
            this.image = this.createImage(290, 155);
            this.graphics = this.image.getGraphics();
        }

        if (this.isDrawing) {
            this.graphics.drawImage(this.imageManager.getImage("game-tools-on"), 0, 0, this);
            this.graphics.setColor(Color.black);

            for (int toolIndex = 0; toolIndex < 3; ++toolIndex) {
                int[] rectLoc = this.getRectLoc(toolIndex, this.toolSetSelected[toolIndex]);
                this.graphics.drawRect(rectLoc[0] - 2, rectLoc[1] - 2, 23, 23);
            }
        } else {
            this.graphics.drawImage(this.imageManager.getImage("game-tools-off"), 0, 0, this);
        }

        g.drawImage(this.image, 0, 0, this);
    }

    public void actionPerformed(ActionEvent evt) {
        if (this.isDrawing) {
            Object evtSource = evt.getSource();
            if (evtSource == this.buttonClear) {
                this.gameDrawingCanvas.clear();
            }

            if (evtSource == this.buttonFill) {
                this.gameDrawingCanvas.fill(this.toolSetSelected[1]);
            }

            if (evtSource == this.buttonUndo) {
                this.gameDrawingCanvas.undo();
            }

        }
    }

    public void mousePressed(MouseEvent var1) {
        int[] var2 = this.getToolIndex(var1.getX(), var1.getY());
        if (var2 != null) {
            this.toolSetSelected[var2[0]] = var2[1];
            this.repaint();
        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    protected void setDrawingCanvas(GameDrawingCanvas drawingCanvas) {
        this.gameDrawingCanvas = drawingCanvas;
    }

    protected void method296(boolean var1) {
        if (var1) {
            this.toolSetSelected[0] = this.toolSetSelected[1] = 0;
            this.toolSetSelected[2] = 1;
            this.setDrawing(true);
        }
    }

    protected void setNotDrawing() {
        this.setDrawing(false);
    }

    protected int getSelectedSize() {
        return this.toolSetSelected[0];
    }

    protected int getSelectedColour() {
        return this.toolSetSelected[1];
    }

    protected int getSelectedTool() {
        return this.toolSetSelected[2];
    }

    private void create() {
        this.buttonClear = new ColorButton(this.textManager.getGame("GameTools_Clear"));
        this.buttonClear.setBounds(15, 120, 70, 20);
        this.buttonClear.setBackground(GameApplet.colourButtonRed);
        this.buttonFill = new ColorButton(this.textManager.getGame("GameTools_Fill"));
        this.buttonFill.setBounds(95, 120, 70, 20);
        this.buttonFill.setBackground(GameApplet.colourButtonRed);
        this.buttonUndo = new ColorButton(this.textManager.getGame("GameTools_Undo"));
        this.buttonUndo.setBounds(205, 120, 70, 20);
        this.buttonUndo.setBackground(GameApplet.colourButtonYellow);
    }

    private void setDrawing(boolean var1) {
        if (var1 != this.isDrawing) {
            this.isDrawing = var1;
            if (var1) {
                this.buttonClear.addActionListener(this);
                this.buttonFill.addActionListener(this);
                this.buttonUndo.addActionListener(this);
                this.add(this.buttonClear);
                this.add(this.buttonFill);
                this.add(this.buttonUndo);
                this.addMouseListener(this);
            } else {
                this.removeMouseListener(this);
                this.remove(this.buttonClear);
                this.remove(this.buttonFill);
                this.remove(this.buttonUndo);
                this.buttonClear.removeActionListener(this);
                this.buttonFill.removeActionListener(this);
                this.buttonUndo.removeActionListener(this);
            }

            this.repaint();
        }
    }

    private int[] getToolIndex(int mouseX, int mouseY) {
        for (int toolSetIndex = 0; toolSetIndex < 3; ++toolSetIndex) {
            for (int toolIndex = 0; toolIndex < toolSetNumTools[toolSetIndex]; ++toolIndex) {
                int[] rectLoc = this.getRectLoc(toolSetIndex, toolIndex);
                if (mouseX >= rectLoc[0] && mouseX < rectLoc[0] + 20 && mouseY >= rectLoc[1] && mouseY < rectLoc[1] + 20) {
                    int[] indexes = new int[]{toolSetIndex, toolIndex};
                    return indexes;
                }
            }
        }

        return null;
    }

    private int[] getRectLoc(int toolSetIndex, int toolIndex) {
        int var3 = toolIndex / toolSetWidthTiles[toolSetIndex];
        int var4 = toolIndex % toolSetWidthTiles[toolSetIndex];
        int[] var5 = new int[]{toolSetX[toolSetIndex] + var4 * 24, 15 + var3 * 24};
        return var5;
    }
}
