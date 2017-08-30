package com.playray.client;

import java.net.URL;

class Class110 {

    protected static final String aString1771 = "/Shared/Client2/src/";
    protected static final String aString1772 = "/L10N/";
    private static final String[] aStringArray1773 = new String[2];


    protected static final boolean method1896(URL var0) {
        return !var0.getProtocol().equalsIgnoreCase("file") ? false : var0.toString().indexOf("fs01") <= 0;
    }

    static {
        aStringArray1773[0] = "file";
        aStringArray1773[1] = "fs01";
    }
}
