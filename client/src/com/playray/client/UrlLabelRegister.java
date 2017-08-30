package com.playray.client;

import com.playray.client.Parameters;
import com.playray.client.UrlLabel;

public class UrlLabelRegister extends UrlLabel {

    public UrlLabelRegister(Parameters var1, String var2) {
        super(var1.getApplet(), var2, var1.getRegisterPage());
        this.setTarget(0);
    }
}
