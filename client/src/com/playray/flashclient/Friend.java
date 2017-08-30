package com.playray.flashclient;

import com.playray.client.CharacterImage;
import com.playray.flashclient.FlashClient;
import com.playray.json.JSON;

public class Friend {

    private FlashClient aFlashClient2124;
    private int anInt2125;
    private String aString2126;
    private String aString2127;
    private String aString2128;
    private CharacterImage aCharacterImage2129;
    private CharacterImage aCharacterImage2130;
    private static final String[] aStringArray2131 = new String[5];


    protected Friend(FlashClient var1, JSON var2) {
        this.aFlashClient2124 = var1;
        this.anInt2125 = var2.getInt("regid");
        this.aString2126 = var2.getString("nick");
        JSON var3 = var2.getJSON("bitmap");
        if (var3 != null) {
            this.aString2127 = var3.getString("small");
            this.aString2128 = var3.getString("medium");
        }

    }

    public int getRegId() {
        return this.anInt2125;
    }

    public String getNick() {
        return this.aString2126;
    }

    public String getBitmapSmall() {
        return this.aString2127;
    }

    public String getBitmapMedium() {
        return this.aString2128;
    }

    public CharacterImage getFaceImage(int var1) {
        if (var1 == 0) {
            if (this.aCharacterImage2129 == null && this.aString2127 != null) {
                this.aCharacterImage2129 = new CharacterImage(this.aFlashClient2124.method2168().anImageManager3822, this.aString2127, var1);
            }

            return this.aCharacterImage2129;
        } else if (var1 == 1) {
            if (this.aCharacterImage2130 == null && this.aString2128 != null) {
                this.aCharacterImage2130 = new CharacterImage(this.aFlashClient2124.method2168().anImageManager3822, this.aString2128, var1);
            }

            return this.aCharacterImage2130;
        } else {
            return null;
        }
    }

    static {
        aStringArray2131[0] = "regid";
        aStringArray2131[1] = "small";
        aStringArray2131[2] = "nick";
        aStringArray2131[3] = "bitmap";
        aStringArray2131[4] = "medium";
    }
}
