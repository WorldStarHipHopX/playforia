package adraw.game;

import adraw.GameApplet;
import com.aapeli.client.TextManager;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.PixelGrabber;

class GameDrawingCanvas extends Canvas implements MouseMotionListener, MouseListener {

    private static final boolean[][][] antilag_boolean_array = {
            {
                    new boolean[7], new boolean[7], new boolean[7], {false, false, false, true, false, false, false},
                    new boolean[7], new boolean[7], new boolean[7]
            }, {
                    new boolean[7], new boolean[7], {false, false, false, true, false, false, false}, {false, false, true, true, true, false, false},
                    {false, false, false, true, false, false, false}, new boolean[7], new boolean[7]
            }, {
                    new boolean[7], {false, false, true, true, true, false, false}, {false, true, true, true, true, true, false}, {false, true, true, true, true, true, false},
                    {false, true, true, true, true, true, false}, {false, false, true, true, true, false, false}, new boolean[7]
            }, {
                    {false, false, true, true, true, false, false}, {false, true, true, true, true, true, false}, {true, true, true, true, true, true, true}, {true, true, true, true, true, true, true},
                    {true, true, true, true, true, true, true}, {false, true, true, true, true, true, false}, {false, false, true, true, true, false, false}
            }
    };
    private static final Color[] coloursPainting = {
            new Color(2, 2, 2), new Color(255, 204, 153), new Color(153, 102, 1), new Color(255, 102, 0),
            new Color(127, 127, 127), new Color(255, 255, 0), new Color(102, 255, 0), new Color(51, 153, 0),
            new Color(193, 193, 193), new Color(255, 153, 204), new Color(204, 0, 204), new Color(255, 0, 0),
            new Color(255, 255, 255), new Color(0, 255, 255), new Color(0, 204, 255), new Color(0, 51, 204)
    };
    private static final Color colourBackground = Color.white;
    private static final Color colourBackgroundGameInfo = new Color(250, 150, 0);
    private static final Color colourTextGameInfo = new Color(0, 0, 0);
    private static final Cursor cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    private static final Cursor cursorCrosshair = new Cursor(Cursor.CROSSHAIR_CURSOR);
    private GameApplet gameApple;
    private TextManager textManager;
    private GamePanel gamePanel;
    private GameDrawingToolsPanel gameDrawingToolsPanel;
    private boolean aBoolean12;
    private int anInt13;
    private int anInt14;
    private int anInt15;
    private int anInt16;
    private int lastMouseX;
    private int lastMouseY;
    private int anInt19;
    private int anInt20;
    private Image anImage21;
    private Image image;
    private Graphics aGraphics23;
    private Graphics graphics;
    private Image anImage25;
    private Image anImage26;
    private Graphics aGraphics27;
    private Graphics aGraphics28;
    private int anInt29;
    private int anInt30;
    private StringBuffer drawingBuffer;
    private GameDrawingWorker gameDrawingWorker;
    private int anInt33;
    private boolean aBoolean34;


    protected GameDrawingCanvas(GameApplet gameApplet, TextManager textManager, GamePanel gamePanel, GameDrawingToolsPanel gameDrawingToolsPanel) {
        this.gameApple = gameApplet;
        this.textManager = textManager;
        this.gamePanel = gamePanel;
        this.gameDrawingToolsPanel = gameDrawingToolsPanel;
        this.setSize(465, 260);
        this.anImage21 = gameApplet.createImage(465, 260);
        this.aGraphics23 = this.anImage21.getGraphics();
        this.anImage25 = gameApplet.createImage(465, 260);
        this.aGraphics27 = this.anImage25.getGraphics();
        this.anImage26 = gameApplet.createImage(465, 260);
        this.aGraphics28 = this.anImage26.getGraphics();
        Graphics var5 = this.aGraphics23;
        var5.setColor(colourBackground);
        var5.fillRect(0, 0, 465, 260);
        this.anInt13 = 0;
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
            this.image = this.createImage(465, 260);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.drawImage(this.anImage21, 0, 0, this);
        this.method84(g);
    }

    public void mousePressed(MouseEvent var1) {
        if (this.anInt13 == 0) {
            this.anInt14 = this.gameDrawingToolsPanel.getSelectedSize();
            this.anInt15 = this.gameDrawingToolsPanel.getSelectedColour();
            this.anInt16 = this.gameDrawingToolsPanel.getSelectedTool();
            this.anInt13 = 1;
            this.lastMouseX = var1.getX();
            this.lastMouseY = var1.getY();
            this.drawingBuffer = new StringBuffer(1000);
            this.drawingBuffer.append((char) ('6' + this.anInt15 * 4 + this.anInt16));
            this.drawingBuffer.append((char) ('$' + this.anInt14));
            if (this.anInt14 == 0) {
                this.method95(this.aGraphics23, this.lastMouseX, this.lastMouseY);
            }

            if (this.anInt14 == 10) {
                this.method101(this.aGraphics23, this.lastMouseX, this.lastMouseY);
            }

            if (this.anInt14 == 0 || this.anInt14 == 2 || this.anInt14 == 10) {
                this.method86(this.lastMouseX, this.lastMouseY);
            }

            if (this.anInt14 == 11) {
                if (this.method102(this.anImage21, this.aGraphics23, this.lastMouseX, this.lastMouseY)) {
                    this.method86(this.lastMouseX, this.lastMouseY);
                    this.method92();
                }

                this.anInt13 = 0;
            }

        }
    }

    public void mouseDragged(MouseEvent evt) {
        if (this.anInt13 == 1) {
            int mouseX = evt.getX();
            int mouseY = evt.getY();
            int[] var4;
            if (this.anInt14 == 0 && !this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 3)) {
                var4 = this.method88(this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                mouseX = this.lastMouseX + var4[0];
                mouseY = this.lastMouseY + var4[1];
                this.method96(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                this.lastMouseX = mouseX;
                this.lastMouseY = mouseY;
            }

            if (this.anInt14 == 1 || this.anInt14 == 2 || this.anInt14 == 4 || this.anInt14 == 5) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method96(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                this.method84((Graphics) null);
            }

            if (this.anInt14 == 3 && (this.lastMouseX != mouseX || this.lastMouseY != mouseY)) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method97(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                this.method84((Graphics) null);
            }

            if (this.anInt14 == 6 || this.anInt14 == 7) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method99(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY, this.anInt14 == 7);
                this.method84((Graphics) null);
            }

            if (this.anInt14 == 8 || this.anInt14 == 9) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method100(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY, this.anInt14 == 9);
                this.method84((Graphics) null);
            }

            if (this.anInt14 == 10 && !this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 2)) {
                var4 = this.method90(this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                mouseX = this.lastMouseX + var4[0];
                mouseY = this.lastMouseY + var4[1];
                this.method101(this.aGraphics23, mouseX, mouseY);
                this.lastMouseX = mouseX;
                this.lastMouseY = mouseY;
            }

        }
    }

    public void mouseMoved(MouseEvent evt) {
        if (this.anInt13 != 0) {
            int mouseX = evt.getX();
            int mouseY = evt.getY();
            if ((this.anInt14 == 1 || this.anInt14 == 2) && this.anInt13 == 2) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method96(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                this.method84((Graphics) null);
            }

            if (this.anInt14 == 3 && this.anInt13 == 2) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method97(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                this.method84((Graphics) null);
            }

            if (this.anInt14 == 4 || this.anInt14 == 5) {
                if (this.anInt13 == 2) {
                    this.graphics.drawImage(this.anImage21, 0, 0, this);
                    this.method96(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                    this.method84((Graphics) null);
                }

                if (this.anInt13 == 3) {
                    this.graphics.drawImage(this.anImage21, 0, 0, this);
                    this.method98(this.graphics, this.lastMouseX, this.lastMouseY, this.anInt19, this.anInt20, mouseX, mouseY, this.anInt14 == 5);
                    this.method84((Graphics) null);
                }
            }

            if ((this.anInt14 == 6 || this.anInt14 == 7) && this.anInt13 == 2) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method99(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY, this.anInt14 == 7);
                this.method84((Graphics) null);
            }

            if ((this.anInt14 == 8 || this.anInt14 == 9) && this.anInt13 == 2) {
                this.graphics.drawImage(this.anImage21, 0, 0, this);
                this.method100(this.graphics, this.lastMouseX, this.lastMouseY, mouseX, mouseY, this.anInt14 == 9);
                this.method84((Graphics) null);
            }

        }
    }

    public void mouseReleased(MouseEvent evt) {
        if (this.anInt13 != 0) {
            int mouseX = evt.getX();
            int mouseY = evt.getY();
            if (this.anInt14 != 0 && this.anInt14 != 10) {
                if (this.anInt14 == 1) {
                    if ((this.anInt13 != 1 || this.method85(this.lastMouseX, this.lastMouseY, mouseX, mouseY, 1)) && this.anInt13 != 2) {
                        this.anInt13 = 2;
                    } else {
                        this.method96(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                        this.method86(this.lastMouseX, this.lastMouseY);
                        if (!this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 1)) {
                            this.method86(mouseX, mouseY);
                        }

                        this.method92();
                        this.anInt13 = 0;
                    }
                } else if (this.anInt14 == 2) {
                    if (!this.method85(this.lastMouseX, this.lastMouseY, mouseX, mouseY, 1)) {
                        this.method96(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                        this.method86(mouseX, mouseY);
                        this.lastMouseX = mouseX;
                        this.lastMouseY = mouseY;
                    }

                    this.anInt13 = 2;
                } else if (this.anInt14 == 3) {
                    if ((this.anInt13 != 1 || this.method85(this.lastMouseX, this.lastMouseY, mouseX, mouseY, 1)) && this.anInt13 != 2) {
                        this.anInt13 = 2;
                    } else {
                        if (!this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 1)) {
                            this.method97(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                            this.method86(this.lastMouseX, this.lastMouseY);
                            this.method86(mouseX, mouseY);
                            this.method92();
                        }

                        this.anInt13 = 0;
                    }
                } else {
                    if (this.anInt14 == 4 || this.anInt14 == 5) {
                        if (this.anInt13 == 1 && !this.method85(this.lastMouseX, this.lastMouseY, mouseX, mouseY, 1) || this.anInt13 == 2) {
                            this.anInt19 = mouseX;
                            this.anInt20 = mouseY;
                            this.anInt13 = 3;
                            return;
                        }

                        if (this.anInt13 == 1) {
                            this.anInt13 = 2;
                            return;
                        }

                        if (this.anInt13 == 3) {
                            boolean var4 = this.method85(this.anInt19, this.anInt20, this.lastMouseX, this.lastMouseY, 1);
                            boolean var5 = this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 1);
                            this.method86(this.lastMouseX, this.lastMouseY);
                            if (!var4 && !var5) {
                                this.method98(this.aGraphics23, this.lastMouseX, this.lastMouseY, this.anInt19, this.anInt20, mouseX, mouseY, this.anInt14 == 5);
                                this.method86(mouseX, mouseY);
                                this.method86(this.anInt19, this.anInt20);
                            } else if (var4 && var5) {
                                this.method95(this.aGraphics23, this.lastMouseX, this.lastMouseY);
                            } else if (var4) {
                                this.method96(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY);
                                this.method86(mouseX, mouseY);
                            } else {
                                this.method96(this.aGraphics23, this.lastMouseX, this.lastMouseY, this.anInt19, this.anInt20);
                                this.method86(this.anInt19, this.anInt20);
                            }

                            this.method92();
                            this.anInt13 = 0;
                            return;
                        }
                    }

                    if (this.anInt14 != 6 && this.anInt14 != 7) {
                        if (this.anInt14 == 8 || this.anInt14 == 9) {
                            if (this.anInt13 == 1 && !this.method85(this.lastMouseX, this.lastMouseY, mouseX, mouseY, 1) || this.anInt13 == 2) {
                                this.method86(this.lastMouseX, this.lastMouseY);
                                if (!this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 1)) {
                                    this.method100(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY, this.anInt14 == 9);
                                    this.method86(mouseX, mouseY);
                                } else {
                                    this.method95(this.aGraphics23, this.lastMouseX, this.lastMouseY);
                                }

                                this.method92();
                                this.anInt13 = 0;
                                return;
                            }

                            this.anInt13 = 2;
                        }

                    } else if ((this.anInt13 != 1 || this.method85(this.lastMouseX, this.lastMouseY, mouseX, mouseY, 1)) && this.anInt13 != 2) {
                        this.anInt13 = 2;
                    } else {
                        this.method99(this.aGraphics23, this.lastMouseX, this.lastMouseY, mouseX, mouseY, this.anInt14 == 7);
                        this.method86(this.lastMouseX, this.lastMouseY);
                        if (!this.method85(mouseX, mouseY, this.lastMouseX, this.lastMouseY, 1)) {
                            this.method86(mouseX, mouseY);
                        }

                        this.method92();
                        this.anInt13 = 0;
                    }
                }
            } else {
                this.method92();
                this.anInt13 = 0;
            }
        }
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
        if (this.anInt13 != 0) {
            if (this.anInt14 == 0 || this.anInt14 == 10 || this.anInt14 == 2 && this.drawingBuffer.length() > 5) {
                this.method92();
            }

            this.anInt13 = 0;
            this.repaint();
        }
    }

    protected boolean handlePacket(String[] args) {
        if (!args[1].equals("d")) {
            return false;
        } else {
            int numArgs = args.length;

            for (int i = 2; i < numArgs; ++i) {
                this.method81(args[i]);
                this.paintDrawing();
            }

            this.repaint();
            return true;
        }
    }

    protected void method74(boolean var1, String var2, String var3) {
        Graphics var4 = this.aGraphics23;
        var4.setColor(colourBackground);
        var4.fillRect(0, 0, 465, 260);
        this.aGraphics23.setColor(colourBackgroundGameInfo);
        this.aGraphics23.fillRect(0, 0, 465, 260);
        this.aGraphics23.setFont(GameApplet.fontSerif20);
        this.aGraphics23.setColor(colourTextGameInfo);
        if (var1) {
            this.gameApple.drawText(this.aGraphics23, this.textManager.getGame("GameDraw_SplashYourTurn"), 232, 65, 0);
            this.gameApple.drawText(this.aGraphics23, this.textManager.getGame("GameDraw_SplashWordIs"), 232, 140, 0);
            this.gameApple.drawText(this.aGraphics23, GameWordPanel.addSpaces(var3), 232, 185, 0);
        } else {
            this.gameApple.drawText(this.aGraphics23, this.textManager.getGame("GameDraw_SplashOtherTurn"), 232, 65, 0);
            this.gameApple.drawText(this.aGraphics23, this.textManager.getGame("GameDraw_SplashDrawerIs"), 232, 140, 0);
            this.gameApple.drawText(this.aGraphics23, var2, 232, 185, 0);
        }

        this.repaint();
    }

    protected void method75(boolean var1) {
        this.method82(var1);
        this.repaint();
    }

    protected void method76(String var1) {
        this.method83();
        this.aGraphics23.setColor(colourBackgroundGameInfo);
        this.aGraphics23.fillRect(0, 0, 465, 40);
        this.aGraphics23.setFont(GameApplet.fontSerif20);
        this.aGraphics23.setColor(colourTextGameInfo);
        this.gameApple.drawText(this.aGraphics23, this.textManager.getGame("GameDraw_SplashRoundEnd", var1), 232, 30, 0);
        this.repaint();
    }

    protected void clear() {
        if (this.anInt33 != 0) {
            this.anInt33 = 0;
            Graphics var1 = this.aGraphics23;
            var1.setColor(colourBackground);
            var1.fillRect(0, 0, 465, 260);
            this.paintDrawing();
            this.aBoolean34 = true;
            this.gameDrawingWorker.addSeparator();
            this.repaint();
        }
    }

    protected void fill(int colour) {
        Graphics g = this.aGraphics23;
        g.setColor(coloursPainting[colour]);
        g.fillRect(0, 0, 465, 260);
        this.paintDrawing();
        this.aBoolean34 = true;
        this.gameDrawingWorker.addInteger(colour);
        this.repaint();
    }

    protected void undo() {
        if (this.aBoolean34) {
            this.aBoolean34 = false;
            this.method94();
            this.gameDrawingWorker.addUndo();
            this.repaint();
        }
    }

    protected void stop() {
        this.method83();
    }

    private void method81(String var1) {
        char var2 = var1.charAt(0);
        Graphics var9;
        if (var2 == 36) {
            var9 = this.aGraphics23;
            var9.setColor(colourBackground);
            var9.fillRect(0, 0, 465, 260);
        } else if (var2 >= 37 && var2 <= 52) {
            var9 = this.aGraphics23;
            int var10 = var2 - 37;
            var9.setColor(coloursPainting[var10]);
            var9.fillRect(0, 0, 465, 260);
        } else if (var2 == 53) {
            this.method94();
        } else {
            var2 = (char) (var2 - 54);
            this.anInt15 = var2 / 4;
            this.anInt16 = var2 % 4;
            this.anInt14 = var1.charAt(1) - 36;
            var1 = var1.substring(2);
            int var3 = var1.length();
            int[] var4 = this.method87(var1, 0);
            int var5 = var4[0];
            int var6 = var4[1];
            if (var3 == 3) {
                if (this.anInt14 == 10) {
                    this.method101(this.aGraphics23, var5, var6);
                } else if (this.anInt14 == 11) {
                    this.method102(this.anImage21, this.aGraphics23, var5, var6);
                } else {
                    this.method95(this.aGraphics23, var5, var6);
                }
            } else {
                int var7 = 3;
                if (this.anInt14 == 0) {
                    while ((var4 = this.method89(var1, var7)) != null) {
                        this.method96(this.aGraphics23, var5, var6, var5 + var4[0], var6 + var4[1]);
                        var5 += var4[0];
                        var6 += var4[1];
                        var7 += 2;
                    }

                } else if (this.anInt14 != 1 && (this.anInt14 != 4 && this.anInt14 != 5 || var3 != 6)) {
                    if (this.anInt14 == 2) {
                        while ((var4 = this.method87(var1, var7)) != null) {
                            this.method96(this.aGraphics23, var5, var6, var4[0], var4[1]);
                            var5 = var4[0];
                            var6 = var4[1];
                            var7 += 3;
                        }

                    } else if (this.anInt14 == 3) {
                        var4 = this.method87(var1, var7);
                        this.method97(this.aGraphics23, var5, var6, var4[0], var4[1]);
                    } else if (this.anInt14 != 4 && this.anInt14 != 5) {
                        if (this.anInt14 != 6 && this.anInt14 != 7) {
                            if (this.anInt14 != 8 && this.anInt14 != 9) {
                                if (this.anInt14 == 10) {
                                    this.method101(this.aGraphics23, var5, var6);

                                    while ((var4 = this.method91(var1, var7)) != null) {
                                        var5 += var4[0];
                                        var6 += var4[1];
                                        this.method101(this.aGraphics23, var5, var6);
                                        ++var7;
                                    }
                                }

                            } else {
                                var4 = this.method87(var1, var7);
                                this.method100(this.aGraphics23, var5, var6, var4[0], var4[1], this.anInt14 == 9);
                            }
                        } else {
                            var4 = this.method87(var1, var7);
                            this.method99(this.aGraphics23, var5, var6, var4[0], var4[1], this.anInt14 == 7);
                        }
                    } else {
                        var4 = this.method87(var1, var7);
                        int[] var8 = this.method87(var1, var7 + 3);
                        this.method98(this.aGraphics23, var5, var6, var4[0], var4[1], var8[0], var8[1], this.anInt14 == 5);
                    }
                } else {
                    var4 = this.method87(var1, var7);
                    this.method96(this.aGraphics23, var5, var6, var4[0], var4[1]);
                }
            }
        }
    }

    private void method82(boolean var1) {
        Graphics var2 = this.aGraphics23;
        var2.setColor(colourBackground);
        var2.fillRect(0, 0, 465, 260);
        var2 = this.aGraphics27;
        var2.setColor(colourBackground);
        var2.fillRect(0, 0, 465, 260);
        var2 = this.aGraphics28;
        var2.setColor(colourBackground);
        var2.fillRect(0, 0, 465, 260);
        if (var1) {
            this.gameDrawingWorker = new GameDrawingWorker(this.gamePanel);
            Thread var3 = new Thread(this.gameDrawingWorker);
            var3.setDaemon(true);
            var3.start();
        }

        this.anInt13 = this.anInt33 = 0;
        this.aBoolean34 = false;
        this.aBoolean12 = var1;
        if (var1) {
            this.addMouseMotionListener(this);
            this.addMouseListener(this);
            this.setCursor(cursorCrosshair);
        }

    }

    private void method83() {
        if (this.aBoolean12) {
            this.setCursor(cursorDefault);
            this.removeMouseListener(this);
            this.removeMouseMotionListener(this);
            this.gameDrawingWorker.stop();
            this.aBoolean12 = false;
        }
    }

    private void method84(Graphics var1) {
        this.graphics.setColor(Color.gray);
        this.graphics.drawRect(0, 0, 464, 259);
        if (var1 == null) {
            var1 = this.getGraphics();
        }

        var1.drawImage(this.image, 0, 0, this);
    }

    private boolean method85(int var1, int var2, int var3, int var4, int var5) {
        int var6 = var1 - var3;
        int var7 = var2 - var4;
        int var8 = (int) (Math.sqrt((double) (var6 * var6 + var7 * var7)) + 0.5D);
        return var8 >= -var5 && var8 <= var5;
    }

    private void method86(int var1, int var2) {
        int var3 = var1 * 260 + var2;
        int var4 = var3 / 91 / 91;
        int var5 = var3 / 91 % 91;
        int var6 = var3 % 91;
        this.drawingBuffer.append((char) (36 + var4));
        this.drawingBuffer.append((char) (36 + var5));
        this.drawingBuffer.append((char) (36 + var6));
    }

    private int[] method87(String var1, int var2) {
        if (var2 >= var1.length()) {
            return null;
        } else {
            int var3 = var1.charAt(var2) - 36;
            int var4 = var1.charAt(var2 + 1) - 36;
            int var5 = var1.charAt(var2 + 2) - 36;
            int var6 = var3 * 91 * 91 + var4 * 91 + var5;
            int[] var7 = new int[]{var6 / 260, var6 % 260};
            return var7;
        }
    }

    private int[] method88(int var1, int var2, int var3, int var4) {
        int var5 = var3 - var1;
        int var6 = var4 - var2;
        if (var5 < -45) {
            var5 = -45;
        }

        if (var5 > 45) {
            var5 = 45;
        }

        if (var6 < -45) {
            var6 = -45;
        }

        if (var6 > 45) {
            var6 = 45;
        }

        this.drawingBuffer.append((char) (36 + var5 + 45));
        this.drawingBuffer.append((char) (36 + var6 + 45));
        int[] var7 = new int[]{var5, var6};
        return var7;
    }

    private int[] method89(String var1, int var2) {
        if (var2 >= var1.length()) {
            return null;
        } else {
            int var3 = var1.charAt(var2) - 36;
            int var4 = var1.charAt(var2 + 1) - 36;
            int[] var5 = new int[]{var3 - 45, var4 - 45};
            return var5;
        }
    }

    private int[] method90(int var1, int var2, int var3, int var4) {
        int var5 = var3 - var1;
        int var6 = var4 - var2;
        if (var5 < -12) {
            var5 = -12;
        }

        if (var5 > 12) {
            var5 = 12;
        }

        if (var6 < -12) {
            var6 = -12;
        }

        if (var6 > 12) {
            var6 = 12;
        }

        int var7 = (var5 + 12) / 3;
        int var8 = (var6 + 12) / 3;
        this.drawingBuffer.append((char) (36 + var7 * 9 + var8));
        var5 = var7 * 3 - 12;
        var6 = var8 * 3 - 12;
        int[] var9 = new int[]{var5, var6};
        return var9;
    }

    private int[] method91(String var1, int var2) {
        if (var2 >= var1.length()) {
            return null;
        } else {
            int var3 = var1.charAt(var2) - 36;
            int[] var4 = new int[]{var3 / 9 * 3 - 12, var3 % 9 * 3 - 12};
            return var4;
        }
    }

    private void method92() {
        if (this.gameApple.isValidSite) {
            String var1 = this.drawingBuffer.toString();
            this.paintDrawing();
            this.aBoolean34 = true;
            this.gameDrawingWorker.addString(var1);
        }
    }

    private void paintDrawing() {
        this.aGraphics28.drawImage(this.anImage25, 0, 0, this);
        this.anInt30 = this.anInt29;
        this.aGraphics27.drawImage(this.anImage21, 0, 0, this);
        this.anInt29 = this.anInt33++;
    }

    private void method94() {
        this.aGraphics23.drawImage(this.anImage26, 0, 0, this);
        this.anInt33 = this.anInt30;
        this.aGraphics27.drawImage(this.anImage26, 0, 0, this);
        this.anInt29 = this.anInt30;
    }

    private void method95(Graphics var1, int var2, int var3) {
        var1.setColor(coloursPainting[this.anInt15]);

        for (int var4 = 0; var4 < 7; ++var4) {
            for (int var5 = 0; var5 < 7; ++var5) {
                if (antilag_boolean_array[this.anInt16][var4][var5]) {
                    var1.fillRect(var2 + var5 - 3, var3 + var4 - 3, 1, 1);
                }
            }
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private void method96(Graphics var1, int var2, int var3, int var4, int var5) {
        var1.setColor(coloursPainting[this.anInt15]);

        for (int var6 = 0; var6 < 7; ++var6) {
            for (int var7 = 0; var7 < 7; ++var7) {
                if (antilag_boolean_array[this.anInt16][var6][var7]) {
                    var1.drawLine(var2 + var7 - 3, var3 + var6 - 3, var4 + var7 - 3, var5 + var6 - 3);
                }
            }
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private void method97(Graphics var1, int var2, int var3, int var4, int var5) {
        int var6 = var2 + (var4 - var2) * 4 / 5;
        int var7 = var3 + (var5 - var3) * 4 / 5;
        int var8 = var4 - var6;
        int var9 = var5 - var7;
        int var10 = var9 * 3 / 4;
        int var11 = -var8 * 3 / 4;
        int var12 = var6 + var10 / 2;
        int var13 = var7 + var11 / 2;
        int var14 = var6 - var10 / 2;
        int var15 = var7 - var11 / 2;
        var1.setColor(coloursPainting[this.anInt15]);

        for (int var16 = 0; var16 < 7; ++var16) {
            for (int var17 = 0; var17 < 7; ++var17) {
                if (antilag_boolean_array[this.anInt16][var16][var17]) {
                    var1.drawLine(var2 + var17 - 3, var3 + var16 - 3, var6 + var17 - 3, var7 + var16 - 3);
                    var1.drawLine(var12 + var17 - 3, var13 + var16 - 3, var14 + var17 - 3, var15 + var16 - 3);
                    var1.drawLine(var12 + var17 - 3, var13 + var16 - 3, var4 + var17 - 3, var5 + var16 - 3);
                    var1.drawLine(var14 + var17 - 3, var15 + var16 - 3, var4 + var17 - 3, var5 + var16 - 3);
                }
            }
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private void method98(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
        var1.setColor(coloursPainting[this.anInt15]);

        for (int var9 = 0; var9 < 7; ++var9) {
            for (int var10 = 0; var10 < 7; ++var10) {
                if (antilag_boolean_array[this.anInt16][var9][var10]) {
                    int[] var11 = new int[]{var2 + var10 - 3, var4 + var10 - 3, var6 + var10 - 3};
                    int[] var12 = new int[]{var3 + var9 - 3, var5 + var9 - 3, var7 + var9 - 3};
                    if (!var8) {
                        var1.drawPolygon(var11, var12, 3);
                    } else {
                        var1.fillPolygon(var11, var12, 3);
                    }
                }
            }
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private void method99(Graphics var1, int var2, int var3, int var4, int var5, boolean var6) {
        int var7;
        if (var4 < var2) {
            var7 = var2;
            var2 = var4;
            var4 = var7;
        }

        if (var5 < var3) {
            var7 = var3;
            var3 = var5;
            var5 = var7;
        }

        int var8 = var4 - var2;
        int var9 = var5 - var3;
        var1.setColor(coloursPainting[this.anInt15]);

        for (int var10 = 0; var10 < 7; ++var10) {
            for (int var11 = 0; var11 < 7; ++var11) {
                if (antilag_boolean_array[this.anInt16][var10][var11]) {
                    if (!var6) {
                        var1.drawRect(var2 + var11 - 3, var3 + var10 - 3, var8, var9);
                    } else {
                        var1.fillRect(var2 + var11 - 3, var3 + var10 - 3, var8 + 1, var9 + 1);
                    }
                }
            }
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private void method100(Graphics var1, int var2, int var3, int var4, int var5, boolean var6) {
        int var7 = var2 > var4 ? var2 - var4 : var4 - var2;
        int var8 = var3 > var5 ? var3 - var5 : var5 - var3;
        var1.setColor(coloursPainting[this.anInt15]);

        for (int var9 = 0; var9 < 7; ++var9) {
            for (int var10 = 0; var10 < 7; ++var10) {
                if (antilag_boolean_array[this.anInt16][var9][var10]) {
                    if (!var6) {
                        var1.drawOval(var2 - var7 + var10 - 3, var3 - var8 + var9 - 3, var7 * 2, var8 * 2);
                    } else {
                        var1.fillOval(var2 - var7 + var10 - 3, var3 - var8 + var9 - 3, var7 * 2, var8 * 2);
                    }
                }
            }
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private void method101(Graphics var1, int var2, int var3) {
        var1.setColor(coloursPainting[this.anInt15]);
        int var4 = (this.anInt16 + 1) * 10;
        int var5 = (int) ((double) var4 * 3.141592653589793D * 3.141592653589793D + 0.5D);
        int var6 = var5 / 5;

        for (int var7 = 0; var7 < var6; ++var7) {
            int var8;
            int var9;
            int var10;
            int var11;
            do {
                var8 = var2 - var4 + (int) (Math.random() * (double) var4 * 2.0D);
                var9 = var3 - var4 + (int) (Math.random() * (double) var4 * 2.0D);
                var10 = var2 - var8;
                var11 = var3 - var9;
            } while (Math.sqrt((double) (var10 * var10 + var11 * var11)) > (double) var4);

            var1.fillRect(var8, var9, 1, 1);
        }

        if (this.aBoolean12 && var1 == this.aGraphics23) {
            this.repaint();
        }

    }

    private boolean method102(Image var1, Graphics var2, int var3, int var4) {
        int[] var5 = this.method103(var1);
        int var6 = var5[var4 * 465 + var3];
        if (var6 == (coloursPainting[this.anInt15].getRGB() & 16777215)) {
            return false;
        } else {
            var5[var4 * 465 + var3] = 123456;
            int var7 = var3;
            int var8 = var4;
            int var9 = var3;
            int var10 = var4;
            int[][] var11 = new int[][]{{var3, var4}, {var3, var4}};

            int var17;
            int var16;
            do {
                int var12 = var11[0][0];
                int var13 = var11[0][1];
                int var14 = var11[1][0];
                int var15 = var11[1][1];
                if (var12 < var7) {
                    var7 = var12;
                }

                if (var13 < var8) {
                    var8 = var13;
                }

                if (var14 > var9) {
                    var9 = var14;
                }

                if (var15 > var10) {
                    var10 = var15;
                }

                var11[0][0] = var11[0][1] = Integer.MAX_VALUE;
                var11[1][0] = var11[1][1] = Integer.MIN_VALUE;

                for (var16 = var12; var16 <= var14; ++var16) {
                    for (var17 = var13; var17 <= var15; ++var17) {
                        if (var5[var17 * 465 + var16] == 123456) {
                            var5[var17 * 465 + var16] = 654321;
                            this.method104(var5, var16 - 1, var17, var6, var11);
                            this.method104(var5, var16 + 1, var17, var6, var11);
                            this.method104(var5, var16, var17 - 1, var6, var11);
                            this.method104(var5, var16, var17 + 1, var6, var11);
                        }
                    }
                }
            } while (var11[0][0] < 465);

            var2.setColor(coloursPainting[this.anInt15]);

            for (var16 = var7; var16 <= var9; ++var16) {
                for (var17 = var8; var17 <= var10; ++var17) {
                    if (var5[var17 * 465 + var16] == 654321) {
                        var2.fillRect(var16, var17, 1, 1);
                    }
                }
            }

            if (this.aBoolean12 && var2 == this.aGraphics23) {
                this.repaint();
            }

            return true;
        }
    }

    private int[] method103(Image var1) {
        int[] var2 = new int[120900];
        PixelGrabber var3 = new PixelGrabber(var1, 0, 0, 465, 260, var2, 0, 465);

        try {
            var3.grabPixels();
        } catch (InterruptedException var5) {
            ;
        }

        for (int var4 = 0; var4 < 120900; ++var4) {
            var2[var4] &= 16777215;
        }

        return var2;
    }

    private boolean method104(int[] var1, int var2, int var3, int var4, int[][] var5) {
        if (var2 >= 0 && var2 < 465 && var3 >= 0 && var3 < 260) {
            if (var1[var3 * 465 + var2] != var4) {
                return false;
            } else {
                var1[var3 * 465 + var2] = 123456;
                if (var2 < var5[0][0]) {
                    var5[0][0] = var2;
                }

                if (var3 < var5[0][1]) {
                    var5[0][1] = var3;
                }

                if (var2 > var5[1][0]) {
                    var5[1][0] = var2;
                }

                if (var3 > var5[1][1]) {
                    var5[1][1] = var3;
                }

                return true;
            }
        } else {
            return false;
        }
    }
}
