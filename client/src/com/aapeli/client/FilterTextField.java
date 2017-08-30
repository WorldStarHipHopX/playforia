package com.aapeli.client;

import java.awt.event.FocusEvent;

public class FilterTextField extends InputTextField {

    private BadWordFilter aBadWordFilter3528;
    private BadWordFilter aBadWordFilter3529;


    public FilterTextField(TextManager var1, String var2, int var3) {
        this(var1, var2, var3, false);
    }

    public FilterTextField(TextManager var1, String var2, int var3, boolean var4) {
        super(var2, var3);
        this.aBadWordFilter3528 = new BadWordFilter(var1, true, "#");
        if (var4) {
            this.aBadWordFilter3529 = new BadWordFilter(var1, false, "#");
        }

    }

    public void focusLost(FocusEvent var1) {
        this.method968();
        super.focusLost(var1);
    }

    public String getInputText(boolean clear) {
        this.method968();
        return super.getInputText(clear);
    }

    private void method968() {
        String var1 = this.getText();
        var1 = this.aBadWordFilter3528.filter(var1);
        if (this.aBadWordFilter3529 != null) {
            var1 = this.aBadWordFilter3529.filter(var1);
        }

        this.setText(var1);
    }
}
