package com.playray.client;

import com.playray.client.InputTextFieldListener;
import com.playray.client.PlainTextField;
import com.playray.client.SPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;
import java.util.Vector;

public class InputTextField extends SPanel implements ComponentListener, FocusListener, KeyListener, ActionListener {

    private static final Color aColor4253 = Color.white;
    private static final Color aColor4254 = Color.black;
    private static final Color aColor4255 = new Color(160, 160, 160);
    private PlainTextField aPlainTextField4256;
    private int anInt4257;
    private String aString4258;
    private Color aColor4259;
    private boolean aBoolean4260;
    private boolean aBoolean4261;
    private int anInt4262;
    private boolean aBoolean4263;
    private boolean aBoolean4264;
    private Vector aVector4265;
    private int anInt4266;
    private int anInt4267;
    private String aString4268;
    private int anInt4269;
    private Vector aVector4270;
    private Vector aVector4271;
    private boolean aBoolean4272;
    private Object anObject4273;
    private static final String aString4274 = "~~";


    public InputTextField(int var1) {
        this("", var1, false);
    }

    public InputTextField(String var1, int var2) {
        this(var1, var2, false);
    }

    public InputTextField(int var1, boolean var2) {
        this("", var1, var2);
    }

    public InputTextField(String var1, int var2, boolean var3) {
        this.anObject4273 = new Object();
        this.aPlainTextField4256 = new PlainTextField();
        this.componentResized((ComponentEvent) null);
        this.add(this.aPlainTextField4256);
        this.anInt4257 = var2;
        this.aPlainTextField4256.setText(var1);
        this.aString4258 = "";
        this.aBoolean4260 = var1.length() > 0;
        this.aBoolean4261 = false;
        this.anInt4262 = 0;
        this.aBoolean4263 = false;
        this.aBoolean4272 = false;
        this.aBoolean4264 = var3;
        if (var3) {
            this.aVector4265 = new Vector();
            this.anInt4266 = this.anInt4267 = 0;
        }

        this.aPlainTextField4256.setBackground(aColor4253);
        this.aPlainTextField4256.setForeground(this.aBoolean4260 ? aColor4255 : aColor4254);
        this.aPlainTextField4256.setEditable(true);
        this.aPlainTextField4256.addFocusListener(this);
        this.aPlainTextField4256.addKeyListener(this);
        this.aPlainTextField4256.addActionListener(this);
        this.addComponentListener(this);
        this.anInt4269 = 0;
        this.aVector4270 = new Vector();
        this.aVector4271 = new Vector();
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (var3 <= 0) {
            var3 = 200;
        }

        if (var4 <= 0) {
            var4 = 20;
        }

        if (!this.aBoolean4272) {
            this.aPlainTextField4256.setBounds(2, 2, var3 - 2 - 2, var4 - 2 - 2);
        } else {
            this.aPlainTextField4256.setBounds(0, 0, var3, var4);
        }

    }

    public void focusGained(FocusEvent var1) {
        if (this.aBoolean4260) {
            this.method2805();
        }

        this.aBoolean4261 = true;
    }

    public void focusLost(FocusEvent var1) {
        this.aBoolean4261 = false;
    }

    public void keyPressed(KeyEvent var1) {
        this.method2806();
    }

    public void keyReleased(KeyEvent var1) {
        this.method2806();
        if (this.aBoolean4264) {
            int var2 = var1.getKeyCode();
            if (var2 == 38 || var2 == 40) {
                Vector var3 = this.aVector4265;
                synchronized (this.aVector4265) {
                    if (this.anInt4266 == 0) {
                        return;
                    }

                    if (var2 == 38) {
                        if (this.anInt4267 == 0) {
                            return;
                        }

                        if (this.anInt4267 == this.anInt4266) {
                            this.aString4268 = this.aPlainTextField4256.getText();
                        }

                        --this.anInt4267;
                    } else {
                        if (this.anInt4267 == this.anInt4266) {
                            return;
                        }

                        ++this.anInt4267;
                    }

                    String var4;
                    if (this.anInt4267 < this.anInt4266) {
                        var4 = (String) ((String) this.aVector4265.elementAt(this.anInt4267));
                    } else {
                        var4 = this.aString4268;
                    }

                    this.aPlainTextField4256.setText(var4);
                    this.aPlainTextField4256.setCaretPosition(var4.length());
                    return;
                }
            }
        }

        this.method2807(var1);
    }

    public void keyTyped(KeyEvent var1) {
        this.method2806();
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aPlainTextField4256) {
            ActionEvent var2 = new ActionEvent(this, var1.getID(), var1.getActionCommand(), var1.getModifiers());
            Object var3 = this.anObject4273;
            synchronized (this.anObject4273) {
                Enumeration var4 = this.aVector4270.elements();

                while (var4.hasMoreElements()) {
                    ((InputTextFieldListener) ((InputTextFieldListener) var4.nextElement())).enterPressed();
                }

                Enumeration var5 = this.aVector4271.elements();

                while (var5.hasMoreElements()) {
                    ((ActionListener) ((ActionListener) var5.nextElement())).actionPerformed(var2);
                }
            }
        }

    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        var1.setColor(Color.white);
        var1.fillRoundRect(0, 0, var2.width, var2.height, 10, 10);
        if (this.aColor4259 != null) {
            var1.setColor(this.aColor4259);
            var1.drawRoundRect(0, 0, var2.width - 1, var2.height - 1, 10, 10);
        }

    }

    public String getInputText() {
        return this.getInputText(true);
    }

    public String getInputText(boolean var1) {
        Object var3 = this.anObject4273;
        String var2;
        synchronized (this.anObject4273) {
            if (this.aBoolean4260) {
                this.method2805();
                return "";
            }

            if (this.aBoolean4263) {
                if (this.anInt4262 == -1) {
                    this.method2809(this.aPlainTextField4256.getText(), this.aPlainTextField4256.getCaretPosition(), 0, "~");
                }

                this.aBoolean4263 = false;
            }

            var2 = this.aPlainTextField4256.getText().trim();
            if (var2.length() > this.anInt4257) {
                var2 = this.aString4258;
            }

            if (var1) {
                this.clear();
            }
        }

        if (this.aBoolean4264) {
            Vector var8 = this.aVector4265;
            synchronized (this.aVector4265) {
                if (this.anInt4266 >= 50) {
                    this.aVector4265.removeElementAt(0);
                    --this.anInt4266;
                }

                this.aVector4265.addElement(var2);
                ++this.anInt4266;
                this.anInt4267 = this.anInt4266;
            }
        }

        return var2;
    }

    public void clear() {
        Object var1 = this.anObject4273;
        synchronized (this.anObject4273) {
            this.aPlainTextField4256.setText("");
            this.aString4258 = "";
            this.anInt4269 = 0;
        }
    }

    public void noClearOnFirstFocus() {
        this.aBoolean4260 = false;
        this.aPlainTextField4256.setForeground(aColor4254);
    }

    public boolean haveFocus() {
        return this.aBoolean4261;
    }

    public void setTextMaximumLength(int var1) {
        this.anInt4257 = var1;
    }

    public boolean isTyping() {
        return !this.aBoolean4260 && this.aPlainTextField4256.getText().length() > 0;
    }

    public void setBorderColor(Color var1) {
        this.aColor4259 = var1;
        this.repaint();
    }

    public PlainTextField getTextField() {
        return this.aPlainTextField4256;
    }

    public void addInputTextFieldListener(InputTextFieldListener var1) {
        Object var2 = this.anObject4273;
        synchronized (this.anObject4273) {
            this.aVector4270.add(var1);
        }
    }

    public void addActionListener(ActionListener var1) {
        Object var2 = this.anObject4273;
        synchronized (this.anObject4273) {
            this.aVector4271.add(var1);
        }
    }

    public void setFullBoxTextField() {
        this.aBoolean4272 = true;
        Dimension var1 = this.getSize();
        this.aPlainTextField4256.setBounds(0, 0, var1.width, var1.height);
    }

    private void method2805() {
        this.aBoolean4260 = false;
        this.aPlainTextField4256.setForeground(aColor4254);
        this.clear();
    }

    private void method2806() {
        Object var1 = this.anObject4273;
        synchronized (this.anObject4273) {
            String var2 = this.aPlainTextField4256.getText();
            int var3 = var2.length();
            if (var3 <= this.anInt4257) {
                this.aString4258 = var2;
            } else {
                int var4 = this.aPlainTextField4256.getCaretPosition() - 1;
                int var5 = this.aString4258.length();
                if (var4 < 0) {
                    var4 = 0;
                } else if (var4 > var5) {
                    var4 = var5;
                }

                this.aPlainTextField4256.setText(this.aString4258);
                this.aPlainTextField4256.setCaretPosition(var4);
            }

            Enumeration var8;
            if (this.anInt4269 == 0 && var3 > 0) {
                var8 = this.aVector4270.elements();

                while (var8.hasMoreElements()) {
                    ((InputTextFieldListener) ((InputTextFieldListener) var8.nextElement())).startedTyping();
                }
            }

            if (this.anInt4269 > 0 && var3 == 0) {
                var8 = this.aVector4270.elements();

                while (var8.hasMoreElements()) {
                    ((InputTextFieldListener) ((InputTextFieldListener) var8.nextElement())).clearedField();
                }
            }

            this.anInt4269 = var3;
        }
    }

    private void method2807(KeyEvent var1) {
        Object var2 = this.anObject4273;
        synchronized (this.anObject4273) {
            if (this.anInt4262 != 1) {
                int var3 = var1.getKeyCode();
                if (var3 < 16 || var3 > 18) {
                    char var4 = var1.getKeyChar();
                    if (var4 >= 32 && var4 <= 255) {
                        if (this.aBoolean4263) {
                            this.method2808(var4);
                            this.aBoolean4263 = false;
                        } else {
                            this.aBoolean4263 = var4 == 126;
                        }

                    } else {
                        this.aBoolean4263 = false;
                    }
                }
            }
        }
    }

    private void method2808(char var1) {
        String var2;
        if (var1 == 32) {
            var2 = "~";
        } else if (var1 == 78) {
            var2 = "Ñ";
        } else if (var1 == 65) {
            var2 = "Ã";
        } else if (var1 == 79) {
            var2 = "Õ";
        } else if (var1 == 110) {
            var2 = "ñ";
        } else if (var1 == 97) {
            var2 = "ã";
        } else if (var1 == 111) {
            var2 = "õ";
        } else if (var1 == 126) {
            var2 = "~~";
        } else {
            var2 = "~" + var1;
        }

        String var3 = this.aPlainTextField4256.getText();
        int var4 = this.aPlainTextField4256.getCaretPosition();
        if (this.anInt4262 == 0) {
            if (var3.substring(0, var4).endsWith(var2)) {
                this.anInt4262 = 1;
                return;
            }

            this.anInt4262 = -1;
        }

        if (var1 == 126) {
            this.method2809(var3, var4, 0, var2);
        } else if (var4 > 0) {
            if (var4 == 0) {
                return;
            }

            if (var1 != var3.charAt(var4 - 1)) {
                return;
            }

            this.method2809(var3, var4, 1, var2);
        }

    }

    private void method2809(String var1, int var2, int var3, String var4) {
        int var5 = var4.length();
        if (var1.length() - var3 + var5 <= this.anInt4257) {
            this.aPlainTextField4256.setText(var1.substring(0, var2 - var3) + var4 + var1.substring(var2));
            this.aPlainTextField4256.setCaretPosition(var2 - var3 + var5);
        }
    }

}
