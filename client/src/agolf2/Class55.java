package agolf2;

import com.aapeli.client.CharacterImage;

import java.util.StringTokenizer;

class Class55 {

    private boolean aBoolean1161;
    private CharacterImage aCharacterImage1162;
    private String aString1163;
    private int anInt1164;
    private long aLong1165;


    protected Class55(Class58_Sub1 var1, StringTokenizer var2) {
        String var3 = var2.nextToken();
        if (var3.equals("-")) {
            this.aBoolean1161 = true;
        } else {
            this.aBoolean1161 = false;
            this.aString1163 = var3;
            this.aCharacterImage1162 = new CharacterImage(var1.imageManager, var2.nextToken(), 0);
            this.anInt1164 = Integer.parseInt(var2.nextToken());
            this.aLong1165 = Long.parseLong(var2.nextToken());
        }
    }

    protected boolean method1419() {
        return this.aBoolean1161;
    }

    protected CharacterImage method1420() {
        return this.aCharacterImage1162;
    }

    protected String method1421() {
        return this.aString1163;
    }

    protected int method1422() {
        return this.anInt1164;
    }

    protected long method1423() {
        return this.aLong1165;
    }
}
