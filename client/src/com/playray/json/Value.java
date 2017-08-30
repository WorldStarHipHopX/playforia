package com.playray.json;

import com.playray.json.Class144;
import com.playray.json.JSON;
import com.playray.json.ParseException;
import com.playray.json.VArray;
import com.playray.json.VBoolean;
import com.playray.json.VNull;
import com.playray.json.VNumber;
import com.playray.json.VString;

public abstract class Value {

    public static int anInt2157;


    protected static Value method2195(Class144 var0) throws ParseException {
        char var1 = var0.method2188();
        return var1 == 34 ? VString.method2204(var0) : (var1 == 123 ? JSON.method2196(var0) : (var1 == 91 ? VArray.method2199(var0) : (var1 != 116 && var1 != 102 ? (var1 == 110 ? VNull.method2201(var0) : VNumber.method2202(var0)) : VBoolean.method2200(var0))));
    }

    protected abstract void toString(StringBuffer var1);
}
