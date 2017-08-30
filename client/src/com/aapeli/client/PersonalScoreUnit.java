package com.aapeli.client;

import com.aapeli.tools.Tools;

public final class PersonalScoreUnit {

    private long aLong1462;
    private long aLong1463;
    private String aString1464;


    protected PersonalScoreUnit(long var1, String var3) {
        this.aLong1462 = System.currentTimeMillis();
        this.aLong1463 = var1;
        this.aString1464 = var3;
    }

    protected PersonalScoreUnit(String var1) {
        int var2 = var1.indexOf(44);
        int var3 = var1.indexOf(44, var2 + 1);
        this.aLong1462 = Long.parseLong(var1.substring(0, var2));
        this.aLong1463 = Long.parseLong(var1.substring(var2 + 1, var3));
        this.aString1464 = Tools.changeFromSaveable(var1.substring(var3 + 1));
    }

    public long getTimeStamp() {
        return this.aLong1462;
    }

    public long getCompScore() {
        return this.aLong1463;
    }

    public String getClientData() {
        return this.aString1464;
    }
}
