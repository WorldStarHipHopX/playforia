package com.playray.client;

import com.playray.client.SoundPlayer;

class Class118 {

    private String aString1837;
    private long aLong1838;
    private final SoundPlayer aSoundPlayer1839;


    public Class118(SoundPlayer var1, String var2, int var3) {
        this.aSoundPlayer1839 = var1;
        this.aString1837 = var2;
        this.aLong1838 = System.currentTimeMillis() + (long) var3;
    }

    protected String method1981() {
        return this.aString1837;
    }

    protected long method1982() {
        return this.aLong1838;
    }
}
