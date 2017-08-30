package com.aapeli.client;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;
import java.util.Vector;

public class InputTextField extends TextField implements FocusListener, KeyListener, ActionListener {

    private static final Color colourBackground = Color.white;
    private static final Color colourText = Color.black;
    private static final Color colourDefaultText = new Color(160, 160, 160);
    private int maxLength;
    private String inputText;
    private boolean showDefaultText;
    private boolean hasFocus;
    private int anInt722;
    private boolean aBoolean723;
    private boolean enabled;
    private Vector userInputz;
    private int userInputzCount;
    private int anInt727;
    private String finalInput;
    private int inputTextLength;
    private Vector<InputTextFieldListener> listeners;


    public InputTextField(int var1) {
        this("", var1, false);
    }

    public InputTextField(String var1, int var2) {
        this(var1, var2, false);
    }

    public InputTextField(int var1, boolean var2) {
        this("", var1, var2);
    }

    public InputTextField(String defaultText, int maxLen, boolean enabled) {
        this.maxLength = maxLen;
        this.setText(defaultText);
        this.inputText = "";
        this.showDefaultText = defaultText.length() > 0;
        this.hasFocus = false;
        this.anInt722 = 0;
        this.aBoolean723 = false;
        this.enabled = enabled;
        if (enabled) {
            this.userInputz = new Vector();
            this.userInputzCount = this.anInt727 = 0;
        }

        this.setBackground(colourBackground);
        this.setForeground(this.showDefaultText ? colourDefaultText : colourText);
        this.setEditable(true);
        this.addFocusListener(this);
        this.addKeyListener(this);
        this.addActionListener(this);
        this.inputTextLength = 0;
        this.listeners = new Vector<InputTextFieldListener>();
    }

    public void focusGained(FocusEvent var1) {
        if (this.showDefaultText) {
            this.clearDefaultText();
        }

        this.hasFocus = true;
    }

    public void focusLost(FocusEvent var1) {
        this.hasFocus = false;
    }

    public void keyPressed(KeyEvent var1) {
        this.keyInput();
    }

    public void keyReleased(KeyEvent evt) {
        this.keyInput();
        if (this.enabled) {
            int keyCode = evt.getKeyCode();
            if (keyCode == 38 || keyCode == 40) {
                synchronized (this.userInputz) {
                    if (this.userInputzCount == 0) {
                        return;
                    }

                    if (keyCode == 38) {
                        if (this.anInt727 == 0) {
                            return;
                        }

                        if (this.anInt727 == this.userInputzCount) {
                            this.finalInput = this.getText();
                        }

                        --this.anInt727;
                    } else {
                        if (this.anInt727 == this.userInputzCount) {
                            return;
                        }

                        ++this.anInt727;
                    }

                    String var4;
                    if (this.anInt727 < this.userInputzCount) {
                        var4 = (String) this.userInputz.elementAt(this.anInt727);
                    } else {
                        var4 = this.finalInput;
                    }

                    this.setText(var4);
                    this.setCaretPosition(var4.length());
                    return;
                }
            }
        }

        this.method965(evt);
    }

    public void keyTyped(KeyEvent evt) {
        this.keyInput();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == this) {
            synchronized (this) {
                Enumeration<InputTextFieldListener> enumeration = this.listeners.elements();

                while (enumeration.hasMoreElements()) {
                    enumeration.nextElement().enterPressed();
                }
            }
        }

    }

    public String getInputText() {
        return this.getInputText(true);
    }

    public String getInputText(boolean clear) {
        String userInput;
        synchronized (this) {
            if (this.showDefaultText) {
                this.clearDefaultText();
                return "";
            }

            if (this.aBoolean723) {
                if (this.anInt722 == -1) {
                    this.method967(this.getText(), this.getCaretPosition(), 0, "~");
                }

                this.aBoolean723 = false;
            }

            userInput = this.getText().trim();
            if (userInput.length() > this.maxLength) {
                userInput = this.inputText;
            }

            if (clear) {
                this.clear();
            }
        }

        if (this.enabled) {
            synchronized (this.userInputz) {
                if (this.userInputzCount >= 50) {
                    this.userInputz.removeElementAt(0);
                    --this.userInputzCount;
                }

                this.userInputz.addElement(userInput);
                ++this.userInputzCount;
                this.anInt727 = this.userInputzCount;
            }
        }

        return userInput;
    }

    public synchronized void clear() {
        this.setText("");
        this.inputText = "";
        this.inputTextLength = 0;
    }

    public void noClearOnFirstFocus() {
        this.showDefaultText = false;
        this.setForeground(colourText);
    }

    public boolean haveFocus() {
        return this.hasFocus;
    }

    public void setTextMaximumLength(int var1) {
        this.maxLength = var1;
    }

    public boolean isTyping() {
        return !this.showDefaultText && this.getText().length() > 0;
    }

    public void addInputTextFieldListener(InputTextFieldListener listener) {
        synchronized (this) {
            this.listeners.addElement(listener);
        }
    }

    private void clearDefaultText() {
        this.showDefaultText = false;
        this.setForeground(colourText);
        this.clear();
    }

    private synchronized void keyInput() {
        String text = this.getText();
        int textLen = text.length();
        if (textLen <= this.maxLength) {
            this.inputText = text;
        } else {
            int lastCharIndex = this.getCaretPosition() - 1;
            int inputTextLen = this.inputText.length();
            if (lastCharIndex < 0) {
                lastCharIndex = 0;
            } else if (lastCharIndex > inputTextLen) {
                lastCharIndex = inputTextLen;
            }

            this.setText(this.inputText);
            this.setCaretPosition(lastCharIndex);
        }

        Enumeration<InputTextFieldListener> enumeration;
        if (this.inputTextLength == 0 && textLen > 0) {
            enumeration = this.listeners.elements();

            while (enumeration.hasMoreElements()) {
                enumeration.nextElement().startedTyping();
            }
        }

        if (this.inputTextLength > 0 && textLen == 0) {
            enumeration = this.listeners.elements();

            while (enumeration.hasMoreElements()) {
                enumeration.nextElement().clearedField();
            }
        }

        this.inputTextLength = textLen;
    }

    private synchronized void method965(KeyEvent evt) {
        if (this.anInt722 != 1) {
            int keyCode = evt.getKeyCode();
            if (keyCode < 16 || keyCode > 18) {
                char chr = evt.getKeyChar();
                if (chr >= ' ' && chr <= 255) {
                    if (this.aBoolean723) {
                        this.method966(chr);
                        this.aBoolean723 = false;
                    } else {
                        this.aBoolean723 = chr == '~';
                    }

                } else {
                    this.aBoolean723 = false;
                }
            }
        }
    }

    private void method966(char chr) {
        String var2;
        if (chr == ' ') {
            var2 = "~";
        } else if (chr == 'N') {
            var2 = "Ñ";
        } else if (chr == 'A') {
            var2 = "Ã";
        } else if (chr == 'O') {
            var2 = "Õ";
        } else if (chr == 'n') {
            var2 = "ñ";
        } else if (chr == 'a') {
            var2 = "ã";
        } else if (chr == 'o') {
            var2 = "õ";
        } else if (chr == '~') {
            var2 = "~~";
        } else {
            var2 = "~" + chr;
        }

        String text = this.getText();
        int var4 = this.getCaretPosition();
        if (this.anInt722 == 0) {
            if (text.substring(0, var4).endsWith(var2)) {
                this.anInt722 = 1;
                return;
            }

            this.anInt722 = -1;
        }

        if (chr == '~') {
            this.method967(text, var4, 0, var2);
        } else if (var4 > 0) {
            if (var4 == 0) {
                return;
            }

            if (chr != text.charAt(var4 - 1)) {
                return;
            }

            this.method967(text, var4, 1, var2);
        }

    }

    private void method967(String var1, int var2, int var3, String var4) {
        int var5 = var4.length();
        if (var1.length() - var3 + var5 <= this.maxLength) {
            this.setText(var1.substring(0, var2 - var3) + var4 + var1.substring(var2));
            this.setCaretPosition(var2 - var3 + var5);
        }
    }

}
