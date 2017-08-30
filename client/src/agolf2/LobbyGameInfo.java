package agolf2;

import com.aapeli.tools.Tools;

import java.util.StringTokenizer;

class LobbyGameInfo {

    private int anInt1113;
    private char aChar1114;
    private int numPlayersIndex;
    private int numTracksIndex;
    private int tracksTypeIndex;
    private int playingOrderIndex;
    private int maxStrokesIndex;
    private int timeLimitIndex;
    private int collisionIndex;
    private int scoringIndex;
    private int audienceIndex;
    private String gameName;
    private String aString1125;
    private Class49[] aClass49Array1126;
    private String[] aStringArray1127;


    protected LobbyGameInfo(int var1, char var2, String var3, String var4, String var5, String var6) {
        this.anInt1113 = var1;
        this.aChar1114 = var2;
        this.aString1125 = var3;
        StringTokenizer tokenizer = new StringTokenizer(var4, "^");
        this.numPlayersIndex = Integer.parseInt(tokenizer.nextToken());
        this.numTracksIndex = Integer.parseInt(tokenizer.nextToken());
        this.gameName = Tools.changeFromSaveable(tokenizer.nextToken());
        this.tracksTypeIndex = Integer.parseInt(tokenizer.nextToken());
        this.playingOrderIndex = Integer.parseInt(tokenizer.nextToken());
        this.maxStrokesIndex = Integer.parseInt(tokenizer.nextToken());
        this.timeLimitIndex = Integer.parseInt(tokenizer.nextToken());
        this.collisionIndex = Integer.parseInt(tokenizer.nextToken());
        this.scoringIndex = Integer.parseInt(tokenizer.nextToken());
        this.audienceIndex = Integer.parseInt(tokenizer.nextToken());
        int var8;
        int var9;
        if (var5.equals("-")) {
            this.aClass49Array1126 = new Class49[0];
        } else {
            tokenizer = new StringTokenizer(var5, "^");
            var8 = tokenizer.countTokens();
            this.aClass49Array1126 = new Class49[var8];

            for (var9 = 0; var9 < var8; ++var9) {
                this.aClass49Array1126[var9] = new Class49(tokenizer.nextToken());
            }
        }

        if (var6.equals("-")) {
            this.aStringArray1127 = new String[0];
        } else {
            tokenizer = new StringTokenizer(var6, "^");
            var8 = tokenizer.countTokens();
            this.aStringArray1127 = new String[var8];

            for (var9 = 0; var9 < var8; ++var9) {
                this.aStringArray1127[var9] = tokenizer.nextToken();
            }
        }

    }

    protected int method1350() {
        return this.anInt1113;
    }

    protected boolean method1351() {
        return this.aChar1114 == 's';
    }

    protected boolean method1352() {
        return this.aChar1114 == 'f';
    }

    protected String method1353() {
        return this.aString1125;
    }

    protected String getGameName() {
        return this.gameName;
    }

    protected int getNumPlayersIndex() {
        return this.numPlayersIndex;
    }

    protected int getNumTracksIndex() {
        return this.numTracksIndex;
    }

    protected int getTracksTypeIndex() {
        return this.tracksTypeIndex;
    }

    protected int getPlayingOrderIndex() {
        return this.playingOrderIndex;
    }

    protected int getMaxStrokesIndex() {
        return this.maxStrokesIndex;
    }

    protected int getTimeLimitIndex() {
        return this.timeLimitIndex;
    }

    protected int getCollisionIndex() {
        return this.collisionIndex;
    }

    protected int getScoringIndex() {
        return this.scoringIndex;
    }

    protected int getAudienceIndex() {
        return this.audienceIndex;
    }

    protected int method1364() {
        return this.aClass49Array1126.length;
    }

    protected int method1365() {
        return this.aStringArray1127.length;
    }

    protected Class49[] method1366() {
        return this.aClass49Array1126;
    }

    protected String[] method1367() {
        return this.aStringArray1127;
    }
}
