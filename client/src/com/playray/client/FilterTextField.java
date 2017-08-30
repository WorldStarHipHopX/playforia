package com.playray.client;

import com.playray.client.BadWordFilter;
import com.playray.client.InputTextField;
import com.playray.client.TextManager;

import java.awt.event.FocusEvent;

public class FilterTextField extends InputTextField {

    private BadWordFilter aBadWordFilter4931;
    private BadWordFilter aBadWordFilter4932;


    public FilterTextField(TextManager var1, String var2, int var3) {
        this(var1, var2, var3, false);
    }

    public FilterTextField(TextManager var1, String var2, int var3, boolean var4) {
        super(var2, var3);
        this.aBadWordFilter4931 = new BadWordFilter(var1, true, "#");
        if (var4) {
            this.aBadWordFilter4932 = new BadWordFilter(var1, false, "#");
        }

    }

    public void focusLost(FocusEvent var1) {
        this.method2810();
        super.focusLost(var1);
    }

    public String getInputText(boolean var1) {
        this.method2810();
        return super.getInputText(var1);
    }

    private void method2810() {
        String var1 = this.getTextField().getText();
        var1 = this.aBadWordFilter4931.filter(var1);
        if (this.aBadWordFilter4932 != null) {
            var1 = this.aBadWordFilter4932.filter(var1);
        }

        this.getTextField().setText(var1);
    }
}
