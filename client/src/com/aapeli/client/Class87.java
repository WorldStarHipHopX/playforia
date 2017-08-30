package com.aapeli.client;

import com.aapeli.client.SoundPlayer;

class Class87 {

    private String aString1480;
    private long aLong1481;
    private final SoundPlayer aSoundPlayer1482;


    public Class87(SoundPlayer var1, String var2, int var3) {
        this.aSoundPlayer1482 = var1;
        this.aString1480 = var2;
        this.aLong1481 = System.currentTimeMillis() + (long) var3;
    }

    protected String method1685() {
        return this.aString1480;
    }

    protected long method1686() {
        return this.aLong1481;
    }
}
