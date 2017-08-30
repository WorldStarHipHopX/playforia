package agolf.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class ConfirmButton extends Canvas implements MouseMotionListener, MouseListener {

    private static final Font fontDialog12 = new Font("Dialog", 0, 12);
    private static final Color colourWhite = new Color(192, 192, 192);
    private static final Color colourBlack = new Color(0, 0, 0);
    private Font font;
    private FontMetrics fontMetrics;
    private int fontSize;
    private Color colourBackground;
    private Color colourBackgroundBrighter;
    private Color colourBackgroundBrightest;
    private Color colourBackgroundDarker;
    private Color colourForeground;
    private String text;
    private String textConfirm;
    private int state;
    private boolean mouseHover;
    private boolean mouseDown;
    private ActionListener actionListener;


    protected ConfirmButton(String text, String confirmText) {
        this.setFont(fontDialog12);
        this.setBackground(colourWhite);
        this.setForeground(colourBlack);
        this.text = text;
        this.textConfirm = confirmText;
        this.state = 0;
        this.setState(1);
        this.mouseHover = this.mouseDown = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics g) {
        Dimension dimensions = this.getSize();
        int width = dimensions.width;
        int height = dimensions.height;
        g.setColor(this.mouseHover ? this.colourBackgroundBrighter : this.colourBackground);
        g.fillRect(0, 0, width, height);
        g.setColor(this.mouseDown ? this.colourBackgroundBrightest : this.colourBackgroundDarker);
        g.drawRect(0, 0, width - 1, height - 1);
        g.setColor(this.mouseDown ? this.colourBackgroundDarker : this.colourBackgroundBrightest);
        g.drawLine(0, 0, width - 1, 0);
        g.drawLine(0, 0, 0, height - 1);
        g.setFont(this.font);
        g.setColor(this.colourForeground);
        String text = this.state == 1 ? this.text : this.textConfirm;
        g.drawString(text, width / 2 - this.fontMetrics.stringWidth(text) / 2, height / 2 + this.fontSize * 3 / 8 + 1);
    }

    public void mouseEntered(MouseEvent var1) {
        this.mouseHover = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.mouseHover = this.mouseDown = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.mouseDown = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent evt) {
        this.mouseDown = false;
        if (this.state == 1) {
            this.setState(2);
        } else {
            this.setState(1);
            this.fireAction();
        }
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseMoved(MouseEvent evt) {
    }

    public void mouseDragged(MouseEvent evt) {
    }

    public void setFont(Font font) {
        this.font = font;
        this.fontMetrics = this.getFontMetrics(font);
        this.fontSize = font.getSize();
        this.repaint();
    }

    public void setBackground(Color colour) {
        this.colourBackground = colour;
        this.colourBackgroundBrighter = this.saturate(colour, 32);
        this.colourBackgroundBrightest = this.saturate(colour, 48);
        this.colourBackgroundDarker = this.saturate(colour, -48);
        this.repaint();
    }

    public void setForeground(Color colour) {
        this.colourForeground = colour;
        this.repaint();
    }

    public void setState(int state) {
        if (state != this.state) {
            this.state = state;
            this.repaint();
        }
    }

    protected void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    protected void fireAction() {
        if (this.actionListener != null) {
            this.actionListener.actionPerformed(new ActionEvent(this, 1001, this.text));
        }

    }

    private Color saturate(Color colour, int by) {
        int red = colour.getRed() + by;
        int green = colour.getGreen() + by;
        int blue = colour.getBlue() + by;
        if (red < 0) {
            red = 0;
        }

        if (red > 255) {
            red = 255;
        }

        if (green < 0) {
            green = 0;
        }

        if (green > 255) {
            green = 255;
        }

        if (blue < 0) {
            blue = 0;
        }

        if (blue > 255) {
            blue = 255;
        }

        return new Color(red, green, blue);
    }

}
