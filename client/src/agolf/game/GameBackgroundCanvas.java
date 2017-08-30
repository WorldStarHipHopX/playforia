package agolf.game;

import agolf.GameApplet;
import agolf.GameContainer;

import java.awt.*;
import java.util.StringTokenizer;

public class GameBackgroundCanvas extends Canvas {

    protected static final Color aColor75;
    private static final String mapChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String defaultTrackSettings = "fttt14";
    public static final int[] anIntArray78;
    public static final int[] anIntArray79;
    public static final String[] aStringArray80;
    public static final int trackAdvertSize;
    protected GameContainer gameContainer;
    private Image backgroundImg;
    protected Image image;
    private Graphics aGraphics85;
    private String trackAuthor;
    private String trackName;
    private String trackComment;
    private String trackSettings;
    private String trackFirstBest;
    private String trackLastBest;
    private int[] trackStats;
    private int[] trackRatings;
    protected int[][] trackTiles;
    protected byte[][] isSolidArrayIThink;
    private boolean[] trackSpecialSettings;
    private int[][] anIntArrayArray97;
    private boolean[] aBooleanArray98;
    public static int anInt99;
    private static final String[] aStringArray100 = new String[11];


    protected GameBackgroundCanvas(GameContainer gameContainer, Image backgroundImage) {
        this.gameContainer = gameContainer;
        this.backgroundImg = backgroundImage;
        this.setSize(735, 375);
        this.trackAuthor = this.trackName = null;
        this.trackTiles = new int[49][25];
        this.anIntArrayArray97 = new int[trackAdvertSize][2];

        for (int var3 = 0; var3 < trackAdvertSize; ++var3) {
            this.anIntArrayArray97[var3][0] = this.anIntArrayArray97[var3][1] = -1;
        }

    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        if (this.image == null) {
            g.setColor(GameApplet.colourGameBackground);
            g.fillRect(0, 0, 735, 375);
        } else {
            g.drawImage(this.image, 0, 0, this);
        }
    }

    protected String[] generateTrackInformation() {
        String[] var1 = new String[]{this.trackAuthor, this.trackName, this.trackFirstBest, this.trackLastBest};
        return var1;
    }

    protected int[][] generateTrackStatistics() {
        int[][] var1 = new int[][]{this.trackStats, this.trackRatings};
        return var1;
    }

    protected void drawMap(int var1) {
        if (this.image == null) {
            this.image = this.createImage(735, 375);
            if (this.image == null) {
                this.image = this.backgroundImg;
            }

            this.aGraphics85 = this.image.getGraphics();
        }

        Image var2 = this.gameContainer.imageManager.createImage(this.gameContainer.spriteManager.getPixelsFromTileCode(var1), 15, 15);
        this.aGraphics85.setColor(aColor75);


        for (int y = 0; y < 25; ++y) {
            for (int x = 0; x < 49; ++x) {

                this.trackTiles[x][y] = var1;
                if (var1 == 0) {
                    this.aGraphics85.fillRect(x * 15, y * 15, 15, 15);
                } else {
                    this.aGraphics85.drawImage(var2, x * 15, y * 15, this);
                }
            }
        }


        this.repaint();
    }

    protected boolean parseMapCommands(String var1) {
        try {
            return this.parseMapInstruction(var1);
        } catch (Exception var3) {
            return false;
        }
    }

    protected Image getTileAt(int var1, int var2) {
        int[] imageData = this.gameContainer.spriteManager.getPixelsFromTileCode(this.trackTiles[var1][var2]);
        if (this.gameContainer.graphicsQualityIndex >= 2) {
            for (int var4 = 0; var4 < 15; ++var4) {
                for (int var5 = 0; var5 < 15; ++var5) {
                    for (int var6 = 1; var6 <= 7 && var1 * 15 + var5 - var6 > 0 && var2 * 15 + var4 - var6 > 0; ++var6) {
                        if (this.method126(var1 * 15 + var5 - var6, var2 * 15 + var4 - var6)) {
                            this.method128(imageData, var5, var4, -8, 15);
                        }
                    }

                    this.method128(imageData, var5, var4, (int) (Math.random() * 11.0D) - 5, 15);
                }
            }
        }

        Image var7 = this.gameContainer.imageManager.createImage(imageData, 15, 15);
        this.aGraphics85.drawImage(var7, var1 * 15, var2 * 15, this);
        return var7;
    }

    protected void checkSolidTile(int tileX, int tileY) {
        int isSpecial = this.trackTiles[tileX][tileY] / 16777216;
        int shapeIndex = this.trackTiles[tileX][tileY] / 65536 % 256;
        int foregroundIndex = this.trackTiles[tileX][tileY] / 256 % 256;
        int backgroundIndex = this.trackTiles[tileX][tileY] % 256;
        int isSolid = Integer.MIN_VALUE;

        if (isSpecial == 1 && (foregroundIndex == 19 || backgroundIndex == 19)) {  // IF HAX BLOCK
            this.aBooleanArray98[0] = true;
        } else if (isSpecial == 2 && shapeIndex == 2) {
            this.aBooleanArray98[1] = true;
        }

        int[][] mask = this.gameContainer.spriteManager.getPixelMask(isSpecial, shapeIndex);

        for (int y = 0; y < 15; ++y) {
            for (int x = 0; x < 15; ++x) {

                if (isSpecial == 1) {
                    isSolid = mask[x][y] == 1 ? foregroundIndex : backgroundIndex;

                } else if (isSpecial == 2) { // If we're drawing a special sprite
                    shapeIndex += 24;
                    isSolid = mask[x][y] == 1 ? foregroundIndex : shapeIndex; // If mask is white draw background, otherwise draw special.
                    if (shapeIndex == 24) {
                        isSolid = foregroundIndex;
                    }

                    if (shapeIndex == 26) { // if small hole shape
                        isSolid = foregroundIndex;
                    }

                    if (shapeIndex == 33 || shapeIndex == 35 || shapeIndex == 37 || shapeIndex == 39) { // if rounded shape?
                        isSolid = foregroundIndex;
                    }

                    if (shapeIndex >= 40 && shapeIndex <= 43) { // if small triangle shape?
                        isSolid = shapeIndex;
                    }

                    if (shapeIndex == 44) {
                        isSolid = foregroundIndex != 12 && foregroundIndex != 13 && foregroundIndex != 14 && foregroundIndex != 15 ? shapeIndex : foregroundIndex;
                    }

                    if (shapeIndex == 45) {
                        isSolid = foregroundIndex;
                    }

                    shapeIndex -= 24;
                }

                this.isSolidArrayIThink[tileX * 15 + x][tileY * 15 + y] = (byte) isSolid;
            }
        }


    }

    protected String getTrackComment() {
        return this.trackComment;
    }

    protected String getTrackSettings() {
        return this.trackSettings.equals("fttt14") ? null : this.trackSettings;
    }

    protected boolean[] method120() {
        return this.aBooleanArray98;
    }

    private boolean parseMapInstruction(String var1) throws Exception {
        this.trackSettings = defaultTrackSettings;
        this.trackFirstBest = this.trackLastBest = this.trackComment = null;
        this.trackStats = this.trackRatings = null;

        StringTokenizer tknzr = new StringTokenizer(var1, "\n");
        int shiet = 0;
        while(tknzr.hasMoreTokens()) {
            String line = tknzr.nextToken();
            if(line.startsWith("V ") && Integer.parseInt(line.substring(2)) == 1) {
                shiet++;
            } else if(line.startsWith("A ")) {
                shiet++;
                this.trackAuthor = line.substring(2).trim();
            } else if(line.startsWith("N ")) {
                shiet++;
                this.trackName = line.substring(2).trim();
            } else if(line.startsWith("C ")) {
                this.trackComment = line.substring(2).trim();
            } else if(line.startsWith("S ")) {
                this.trackSettings = line.substring(2).trim();
                if(trackSettings.length() != 6) {
                    return false;
                }
            } else if(line.startsWith("I ")) {
                StringTokenizer subtknzr = new StringTokenizer(line.substring(2), ",");
                if(subtknzr.countTokens() != 4) {
                    return false;
                }
                /**
                 * 0 = num of completions
                 * 1 = num of strokes
                 * 2 = best num of strokes
                 * 3 = num of players who got best num of strokes
                 */
                this.trackStats = new int[4];
                for(int i = 0; i < 4; i++) {
                    this.trackStats[i] = Integer.parseInt(subtknzr.nextToken());
                }
            } else if(line.startsWith("B ")) {
                this.trackFirstBest = line.substring(2);
            } else if(line.startsWith("L ")) {
                this.trackLastBest = line.substring(2);
            } else if(line.startsWith("R ")) {
                StringTokenizer subtknzr = new StringTokenizer(line.substring(2), ",");
                if(subtknzr.countTokens() != 11) {
                    return false;
                }
                this.trackRatings = new int[11];
                for(int i = 0; i < 11; i++) {
                    this.trackRatings[i] = Integer.parseInt(subtknzr.nextToken());
                }
            } else if(line.startsWith("T ")) {
                shiet++;
                /**
                 *
                 * The below is the map parsing shit
                 * firstly the input map is "expanded", any letter preceeding by a number is duplicated that number times.
                 * If input letter is A,B,C, the letter + the next three are concatenated into one int (4 * bytes)
                 * If input letters are D,E,F,G,H,I, the current tile is exactly the same as an adjacent one so
                 * one is selected, depending on the input letter.
                 *
                 *
                 */
                String mapData = line.substring(2);

                StringTokenizer subtknzr = new StringTokenizer(mapData, ",");
                mapData = this.expandMap(subtknzr.nextToken());
                int cursorIndex = 0;

                int tileX;
                for (int tileY = 0; tileY < 25; ++tileY) {
                    for (tileX = 0; tileX < 49; ++tileX) {

                        int currentMapIndex = mapChars.indexOf(mapData.charAt(cursorIndex));

                        if (currentMapIndex <= 2) {  // if input= A,B or C
                            int mapcursor_one_ahead;
                            int mapcursor_two_ahead;
                            int mapcursor_three_ahead;

                            if (currentMapIndex == 1) { // if input = B.
                                mapcursor_one_ahead = mapChars.indexOf(mapData.charAt(cursorIndex + 1));
                                mapcursor_two_ahead = mapChars.indexOf(mapData.charAt(cursorIndex + 2));
                                mapcursor_three_ahead = mapChars.indexOf(mapData.charAt(cursorIndex + 3));
                                cursorIndex += 4;
                            } else { // if input = A or C
                                mapcursor_one_ahead = mapChars.indexOf(mapData.charAt(cursorIndex + 1));
                                mapcursor_two_ahead = mapChars.indexOf(mapData.charAt(cursorIndex + 2));
                                mapcursor_three_ahead = 0;
                                cursorIndex += 3;
                            }

                            // (currentMapIndex << 24) + (mapcursor_one_ahead << 16) + (mapcursor_two_ahead << 8) + mapcursor_three_ahead;
                            this.trackTiles[tileX][tileY] = currentMapIndex * 256 * 256 * 256 + mapcursor_one_ahead * 256 * 256 + mapcursor_two_ahead * 256 + mapcursor_three_ahead;
                        } else {
                            if (currentMapIndex == 3) {  // if input = D
                                this.trackTiles[tileX][tileY] = this.trackTiles[tileX - 1][tileY]; // tile to west is same as current
                            }

                            if (currentMapIndex == 4) { // if input = E;
                                this.trackTiles[tileX][tileY] = this.trackTiles[tileX][tileY - 1]; // tile to the north is same as current
                            }

                            if (currentMapIndex == 5) { // if input = F;
                                this.trackTiles[tileX][tileY] = this.trackTiles[tileX - 1][tileY - 1]; // tile to the northwest is same as current
                            }

                            if (currentMapIndex == 6) {  // if input = G;
                                this.trackTiles[tileX][tileY] = this.trackTiles[tileX - 2][tileY]; // 2 tiles west is same as current (skip a tile to the left)
                            }

                            if (currentMapIndex == 7) { // if input = H
                                this.trackTiles[tileX][tileY] = this.trackTiles[tileX][tileY - 2]; // 2 tiles north is same as current (skip the tile above)
                            }

                            if (currentMapIndex == 8) { // if input= I
                                this.trackTiles[tileX][tileY] = this.trackTiles[tileX - 2][tileY - 2]; // 2 tiles northwest is same as current (skip the diagonal)
                            }

                            ++cursorIndex;
                        }
                    }
                }

                for (tileX = 0; tileX < trackAdvertSize; ++tileX) {
                    this.anIntArrayArray97[tileX][0] = this.anIntArrayArray97[tileX][1] = -1;
                }

                int var12;
                int var14;
                if (subtknzr.hasMoreTokens()) {
                    mapData = subtknzr.nextToken();
                    if (!mapData.startsWith("Ads:")) {
                        return false;
                    }

                    mapData = mapData.substring(4);
                    var12 = mapData.length() / 5;

                    for (int var13 = 0; var13 < var12; ++var13) {
                        var14 = mapChars.indexOf(mapData.charAt(var13 * 5));
                        this.anIntArrayArray97[var14][0] = Integer.parseInt(mapData.substring(var13 * 5 + 1, var13 * 5 + 3));
                        this.anIntArrayArray97[var14][1] = Integer.parseInt(mapData.substring(var13 * 5 + 3, var13 * 5 + 5));
                    }
                }
            }
        }
        if(shiet != 4) {
            return false;
        }

        this.trackSpecialSettings = new boolean[4];
        for (int i = 0; i < 4; i++) {
            this.trackSpecialSettings[i] = this.trackSettings.charAt(i) == 't';
        }

        this.checkSolids();
        this.drawForegroundMap();
        return true;
    }

    private String expandMap(String mapString) throws Exception {
        StringBuffer buffer = new StringBuffer(4900);
        int length = mapString.length();

        for (int var4 = 0; var4 < length; ++var4) {
            int var5 = this.method123(mapString, var4);
            if (var5 >= 2) {
                ++var4;
            }

            if (var5 >= 10) {
                ++var4;
            }

            if (var5 >= 100) {
                ++var4;
            }

            if (var5 >= 1000) {
                ++var4;
            }

            char var6 = mapString.charAt(var4);

            for (int var7 = 0; var7 < var5; ++var7) {
                buffer.append(var6);
            }
        }

        return buffer.toString();
    }

    private int method123(String var1, int var2) {
        String var3 = null;

        while (true) {
            char var4 = var1.charAt(var2);
            if (var4 < '0' || var4 > '9') {
                return var3 == null ? 1 : Integer.parseInt(var3);
            }

            if (var3 == null) {
                var3 = String.valueOf(var4);
            } else {
                var3 = var3 + var4;
            }

            ++var2;
        }
    }

    private void checkSolids() {
        this.aBooleanArray98 = new boolean[2];
        this.aBooleanArray98[0] = this.aBooleanArray98[1] = false;
        this.isSolidArrayIThink = new byte[735][375];

        for (int y = 0; y < 25; ++y) {
            for (int x = 0; x < 49; ++x) {
                this.checkSolidTile(x, y);
            }
        }

    }

    private void drawForegroundMap() {
        int[] mapPixels = new int[275625];
        int[] currentTileImageData = null;
        int oldTile = -1;
        boolean trackTestMode = this.gameContainer.synchronizedTrackTestMode.get(); // track test mode?

        int currentTile;
        int yPixels;
        int xPixels;
        int var13;
        for (int tileY = 0; tileY < 25; ++tileY) {
            for (int tileX = 0; tileX < 49; ++tileX) {


                if (this.trackTiles[tileX][tileY] != oldTile) {
                    currentTile = this.trackTiles[tileX][tileY];

                    int specialStatus = currentTile / 16777216;

                    // Shape index + 24 !?!?!
                    int var9 = currentTile / 65536 % 256 + 24;
                    int foregroundIndex = currentTile / 256 % 256;

                    if (specialStatus == 2) { // If this tile is a special one huehuehue
                        if (!this.trackSpecialSettings[0] && (var9 == 28 || var9 == 30)) {
                            currentTile = 16777216 + foregroundIndex * 256;
                        }

                        if (!this.trackSpecialSettings[1] && (var9 == 44 || var9 == 45)) {
                            currentTile = 16777216 + foregroundIndex * 256;
                        }

                        if (!this.trackSpecialSettings[2]) {
                            if (var9 == 34 || var9 == 36 || var9 == 38) {
                                currentTile = 34078720 + foregroundIndex * 256;
                            }

                            if (var9 == 35 || var9 == 37 || var9 == 39) {
                                currentTile = 34144256 + foregroundIndex * 256;
                            }
                        }
                    }

                    currentTileImageData = this.gameContainer.spriteManager.getPixelsFromTileCode(currentTile);

                    oldTile = this.trackTiles[tileX][tileY];

                    if (trackTestMode && specialStatus == 2) {
                        yPixels = -1;
                        if (var9 == 24) {
                            yPixels = 16777215;
                        }

                        if (var9 == 48) {
                            yPixels = 11579647;
                        }

                        if (var9 == 49) {
                            yPixels = 16752800;
                        }

                        if (var9 == 50) {
                            yPixels = 16777088;
                        }

                        if (var9 == 51) {
                            yPixels = 9502608;
                        }

                        if (yPixels != -1) {
                            for (xPixels = 6; xPixels <= 8; ++xPixels) {
                                for (var13 = 6; var13 <= 8; ++var13) {
                                    currentTileImageData[xPixels * 15 + var13] = yPixels;
                                }
                            }
                        }
                    }
                }


                for (currentTile = 0; currentTile < 15; ++currentTile) {
                    for (yPixels = 0; yPixels < 15; ++yPixels) {
                        mapPixels[(tileY * 15 + currentTile) * 735 + tileX * 15 + yPixels] = currentTileImageData[currentTile * 15 + yPixels];
                    }
                }
            }
        }

        try {
            int var14;
            int var15;
            if (this.gameContainer.graphicsQualityIndex > 0) {
                for (yPixels = 0; yPixels < 375; ++yPixels) {
                    for (xPixels = 0; xPixels < 735; ++xPixels) {
                        boolean var25;
                        boolean var27;
                        if (this.method126(xPixels, yPixels)) {
                            var25 = this.method126(xPixels - 1, yPixels - 1);
                            var27 = this.method126(xPixels + 1, yPixels + 1);
                            if (!var25 && var27 && !this.method126(xPixels, yPixels - 1) && !this.method126(xPixels - 1, yPixels)) {
                                this.method128(mapPixels, xPixels, yPixels, 128, 735);
                            } else {
                                if (!var25 && var27) {
                                    this.method128(mapPixels, xPixels, yPixels, 24, 735);
                                }

                                if (!var27 && var25) {
                                    this.method128(mapPixels, xPixels, yPixels, -24, 735);
                                }
                            }

                            if (this.gameContainer.graphicsQualityIndex >= 2) {
                                for (var13 = 1; var13 <= 7 && xPixels + var13 < 735 && yPixels + var13 < 375; ++var13) {
                                    if (!this.method126(xPixels + var13, yPixels + var13)) {
                                        var14 = xPixels + var13;
                                        var15 = yPixels + var13;
                                        this.method128(mapPixels, var14, var15, -8, 735);
                                    }
                                }
                            }
                        }

                        if (this.method127(xPixels, yPixels)) {
                            var25 = this.method127(xPixels - 1, yPixels - 1);
                            var27 = this.method127(xPixels + 1, yPixels + 1);
                            if (!var25 && var27 && !this.method127(xPixels, yPixels - 1) && !this.method127(xPixels - 1, yPixels)) {
                                this.method128(mapPixels, xPixels, yPixels, 96, 735);
                            } else {
                                if (!var25 && var27) {
                                    this.method128(mapPixels, xPixels, yPixels, 16, 735);
                                }

                                if (!var27 && var25) {
                                    this.method128(mapPixels, xPixels, yPixels, -16, 735);
                                }
                            }
                        }

                        if (this.gameContainer.graphicsQualityIndex >= 2) {
                            var13 = (int) (Math.random() * 11.0D) - 5;
                            this.method128(mapPixels, xPixels, yPixels, var13, 735);
                        }
                    }
                }
            }

            int[][] var26 = this.gameContainer.spriteManager.method1138();
            currentTile = -1;

            for (yPixels = trackAdvertSize - 2; yPixels >= 0 && currentTile == -1; --yPixels) {
                if (this.anIntArrayArray97[yPixels][0] >= 0 && this.anIntArrayArray97[yPixels][1] >= 0 && var26[yPixels] != null) {
                    currentTile = yPixels;
                }
            }

            if (currentTile == -1 && var26[trackAdvertSize - 1] != null) {
                currentTile = trackAdvertSize - 1;
            }

            if (currentTile >= 0) {
                double var16 = 0.4D - (double) currentTile * 0.05D;
                var14 = 0;
                var15 = 0;
                int var18 = 735;
                int var19 = 375;
                int var20 = 0;
                int var21 = 0;
                if (currentTile < trackAdvertSize - 1) {
                    var14 = this.anIntArrayArray97[currentTile][0] * 15;
                    var15 = this.anIntArrayArray97[currentTile][1] * 15;
                    var18 = anIntArray78[currentTile] * 15;
                    var19 = anIntArray79[currentTile] * 15;
                }

                for (int var22 = var15; var22 < var15 + var19; ++var22) {
                    for (int var23 = var14; var23 < var14 + var18; ++var23) {
                        if (currentTile < 3 || currentTile == 3 && this.isSolidArrayIThink[var23][var22] >= 0 && this.isSolidArrayIThink[var23][var22] <= 15) {
                            mapPixels[var22 * 735 + var23] = this.method129(mapPixels[var22 * 735 + var23], var26[currentTile][var21 * var18 + var20], var16);
                        }

                        ++var20;
                    }

                    ++var21;
                    var20 = 0;
                }
            }
        } catch (OutOfMemoryError var24) {
            ;
        }

        // PAINTS DA MOTHER FUCKING MAP FOREGROUND!!!!!
        this.aGraphics85.drawImage(this.gameContainer.imageManager.createImage(mapPixels, 735, 375), 0, 0, this);
    }

    private boolean method126(int var1, int var2) {
        return var1 >= 0 && var1 < 735 && var2 >= 0 && var2 < 375 ? this.isSolidArrayIThink[var1][var2] >= 16 && this.isSolidArrayIThink[var1][var2] <= 23 && (this.trackSpecialSettings[3] || !this.trackSpecialSettings[3] && this.isSolidArrayIThink[var1][var2] != 19) : false;
    }

    private boolean method127(int var1, int var2) {
        return var1 >= 0 && var1 < 735 && var2 >= 0 && var2 < 375 ? this.isSolidArrayIThink[var1][var2] == 32 || this.isSolidArrayIThink[var1][var2] == 34 || this.isSolidArrayIThink[var1][var2] == 36 || this.isSolidArrayIThink[var1][var2] == 38 : false;
    }

    private void method128(int[] var1, int var2, int var3, int var4, int var5) {
        int var6 = var1[var3 * var5 + var2] & 16777215;
        int var7 = var6 / 65536 % 256;
        int var8 = var6 / 256 % 256;
        int var9 = var6 % 256;
        var7 += var4;
        if (var7 < 0) {
            var7 = 0;
        }

        if (var7 > 255) {
            var7 = 255;
        }

        var8 += var4;
        if (var8 < 0) {
            var8 = 0;
        }

        if (var8 > 255) {
            var8 = 255;
        }

        var9 += var4;
        if (var9 < 0) {
            var9 = 0;
        }

        if (var9 > 255) {
            var9 = 255;
        }

        var1[var3 * var5 + var2] = -16777216 + var7 * 256 * 256 + var8 * 256 + var9;
    }

    private int method129(int var1, int var2, double var3) {
        long var5 = ((long) var2 & 4278190080L) >> 24;
        if (var5 < 255L) {
            return var1;
        } else {
            int var7 = (var1 & 16711680) >> 16;
            int var8 = (var1 & '\uff00') >> 8;
            int var9 = var1 & 255;
            int var10 = (var2 & 16711680) >> 16;
            int var11 = (var2 & '\uff00') >> 8;
            int var12 = var2 & 255;
            int var13 = var10 - var7;
            int var14 = var11 - var8;
            int var15 = var12 - var9;
            int var16 = (int) ((double) var7 + (double) var13 * var3 + 0.5D);
            int var17 = (int) ((double) var8 + (double) var14 * var3 + 0.5D);
            int var18 = (int) ((double) var9 + (double) var15 * var3 + 0.5D);
            return (int) (4278190080L + (long) (var16 << 16) + (long) (var17 << 8) + (long) var18);
        }
    }

    static {
        aStringArray100[0] = "A ";
        aStringArray100[1] = "T ";
        aStringArray100[2] = "S ";
        aStringArray100[3] = "R ";
        aStringArray100[4] = "Ads:";
        aStringArray100[5] = "I ";
        aStringArray100[6] = "L ";
        aStringArray100[7] = "N ";
        aStringArray100[8] = "B ";
        aStringArray100[9] = "C ";
        aStringArray100[10] = "V ";
        aColor75 = new Color(240, 240, 255);
        anIntArray78 = new int[]{3, 5, 8, 49};
        anIntArray79 = new int[]{2, 3, 5, 25};
        aStringArray80 = new String[4];
        aStringArray80[0] = "small";
        aStringArray80[1] = "medium";
        aStringArray80[2] = "large";
        aStringArray80[3] = "full";
        trackAdvertSize = aStringArray80.length;
    }
}
