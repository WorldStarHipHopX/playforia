package com.playray.singleclient;

import java.util.Hashtable;

class Class146 {

    private Hashtable aHashtable2200 = new Hashtable();


    protected boolean method2238(String var1, String var2) {
        if (var2 == null) {
            return false;
        } else {
            String var3 = this.method2239(var1);
            if (var3 != null && var3.equals(var2)) {
                return false;
            } else {
                this.aHashtable2200.put(var1.toLowerCase(), var2);
                return true;
            }
        }
    }

    protected String method2239(String var1) {
        return (String) ((String) this.aHashtable2200.get(var1.toLowerCase()));
    }
}
