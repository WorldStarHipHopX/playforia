package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.ParseException;
import com.playray.json.Value;

public class VBoolean extends Value {

    private boolean aBoolean3611;
    private static final String[] aStringArray3612 = new String[7];


    public VBoolean(boolean var1) {
        this.aBoolean3611 = var1;
    }

    public String toString() {
        return this.aBoolean3611 ? "true" : "false";
    }

    public boolean getValue() {
        return this.aBoolean3611;
    }

    protected static Value method2200(Class144 var0) throws ParseException {
        char var1 = var0.method2187();
        String var2;
        if (var1 == 116) {
            var2 = var0.method2189(3);
            if (var2.equals("rue")) {
                return new VBoolean(true);
            } else {
                throw new ParseException("Unexpected boolean string \"" + var1 + var2 + "\"");
            }
        } else if (var1 == 102) {
            var2 = var0.method2189(4);
            if (var2.equals("alse")) {
                return new VBoolean(false);
            } else {
                throw new ParseException("Unexpected boolean string \"" + var1 + var2 + "\"");
            }
        } else {
            throw new ParseException("Unexpected character \'" + var1 + "\', was expecting \'t\' or \'f\'");
        }
    }

    protected void toString(StringBuffer var1) {
        var1.append(this.aBoolean3611 ? "true" : "false");
    }

    static {
        aStringArray3612[0] = "false";
        aStringArray3612[1] = "true";
        aStringArray3612[2] = "rue";
        aStringArray3612[3] = "Unexpected character \'";
        aStringArray3612[4] = "Unexpected boolean string \"";
        aStringArray3612[5] = "\', was expecting \'t\' or \'f\'";
        aStringArray3612[6] = "alse";
    }
}
