package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.Class145;
import com.playray.json.ParseException;
import com.playray.json.Value;

public class VString extends Value {

    private String aString3618;


    public VString(String var1) {
        this.aString3618 = var1;
    }

    public String toString() {
        return this.aString3618;
    }

    public String getValue() {
        return this.aString3618;
    }

    protected static Value method2204(Class144 var0) throws ParseException {
        String var1 = Class145.method2192(var0);
        VString var2 = new VString(var1);
        return var2;
    }

    protected void toString(StringBuffer var1) {
        Class145.method2191(this.aString3618, var1);
    }
}
