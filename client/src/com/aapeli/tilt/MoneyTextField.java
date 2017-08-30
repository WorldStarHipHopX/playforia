package com.aapeli.tilt;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MoneyTextField extends TextField implements FocusListener {

    private static final Color aColor732 = Color.white;
    private static final Color aColor733 = Color.black;
    private int valueLimitLow;
    private int valueLimitHigh;
    public static int anInt736;


    public MoneyTextField(int var1, int var2, int var3) {
        this.valueLimitLow = var1;
        this.valueLimitHigh = var2;
        this.setText(getValueString(this.getValueLimited(var3)));
        this.setBackground(aColor732);
        this.setForeground(aColor733);
        this.setEditable(true);
        this.addFocusListener(this);
    }

    public void focusGained(FocusEvent var1) {
    }

    public void focusLost(FocusEvent var1) {
        this.setText(getValueString(this.getValueLimited(this.parseValue(this.getText()))));
    }

    public static String getValueString(int var0) {
        int var1 = var0 / 100;
        int var2 = var0 % 100;
        return var1 + "," + (var2 < 10 ? "0" : "") + var2;
    }

    public int getAmount() {
        return this.getValueLimited(this.parseValue(this.getText()));
    }

    private int getValueLimited(int var1) {
        if (var1 < this.valueLimitLow) {
            var1 = this.valueLimitLow;
        }

        if (var1 > this.valueLimitHigh) {
            var1 = this.valueLimitHigh;
        }

        return var1;
    }

    private int parseValue(String text) {
        text = this.parseDoubleString(text);
        if (text == null) {
            return 0;
        } else {
            int commaPos = text.indexOf(',');
            if (commaPos == -1) {
                return this.parseInt(text + "00");
            } else {
                String whole = text.substring(0, commaPos);
                String digits = text.substring(commaPos + 1);
                int digitsLen = digits.length();
                if (digitsLen > 2) {
                    return 0;
                } else {
                    text = whole;
                    if (digitsLen == 0) {
                        text = whole + "00";
                    } else if (digitsLen == 1) {
                        text = whole + digits + "0";
                    } else if (digitsLen == 2) {
                        text = whole + digits;
                    }

                    return this.parseInt(text);
                }
            }
        }
    }

    private String parseDoubleString(String str) {
        int len = str.length();
        StringBuffer output = new StringBuffer(len);
        boolean putComma = false;

        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (c == '.') {
                c = ',';
            }

            if (c == ',') {
                if (putComma) {
                    return null;
                }

                putComma = true;
                output.append(c);
            } else if (c != ' ') {
                if (c < '0' || c > '9') {
                    return null;
                }

                output.append(c);
            }
        }

        return output.toString();
    }

    private int parseInt(String var1) {
        try {
            return Integer.parseInt(var1);
        } catch (NumberFormatException var3) {
            return 0;
        }
    }

}
