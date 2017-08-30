package org.moparforia.editor.util;

import java.awt.*;

/**
 * User: Johan
 * Date: 2013-07-31
 * Time: 11:23
 */
public class RectangleDragSelector {

    private int x1, x2, y1, y2;

    public RectangleDragSelector() {
        reset();
    }

    public void refresh(int x, int y) {
        if (x1 == -1) x1 = x;
        if (y1 == -1) y1 = y;

        if (x > x1) {
            x2 = x;
        }
        if (y > y1) {
            y2 = y;
        }
    }

    public void reset() {
        x1 = x2 = y1 = y2 = -1;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public void draw(Graphics g) {
        if (x1 == -1 || x2 == -1 || y1 == -1 || y2 == -1) return;

        int width = (x2 * 15) - (x1 * 15);
        int height = (y2 * 15) - (y1 * 15);

        g.setColor(Color.RED);
        g.drawRect(x1 * 15, y1 * 15, width, height);
    }
}
