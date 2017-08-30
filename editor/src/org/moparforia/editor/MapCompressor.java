package org.moparforia.editor;

/**
 * makes maps smaller so Svitvona's ISP wont complain about too much bandwidth.
 */
public class MapCompressor {

    private static final String mapChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    int[][] mapTiles;
    StringBuffer buff;

    public MapCompressor() {
        this.mapTiles = new int[49][25];
    }

    public String compress(Map m) {
        Tile[][] tiles = m.toTileArray();
        mapTiles = tileTotileCodes(tiles);
        String longString = encodeMapTiles();
        return shortenString(longString);
    }

    private String shortenString(String map) {
        StringBuffer buff = new StringBuffer();

        for (int i = 0; i < map.length(); i++) {
            int count = 1;
                if(i+1 < map.length()) {
                while (map.charAt(i) == map.charAt(i + 1)) {
                    count++;
                    i++;
                    if (i + 1 == map.length()) break;
                }
                }

            if (count > 1) {
                buff.append(Integer.toString(count));
            }
            buff.append(map.charAt(i));
        }

        return buff.toString();
    }

    private String encodeMapTiles() {
        buff = new StringBuffer();
        // The first
        buff.append(tileCodeToString(mapTiles[0][0]));
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 49; x++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                char c = checkContiguousRegion(x, y);
                if (c != '\0') {
                    buff.append(c);
                    continue;
                }

                buff.append(tileCodeToString(mapTiles[x][y]));

            }
        }
        return buff.toString();
    }

    private char checkContiguousRegion(int tileX, int tileY) {

        if (tileX > 0)
            if (this.mapTiles[tileX][tileY] == this.mapTiles[tileX - 1][tileY]) {  // if input = D
                // tile to west is same as current
                return 'D';
            }

        if (tileY > 0)
            if (this.mapTiles[tileX][tileY] == this.mapTiles[tileX][tileY - 1]) { // if input = E;
                // tile to the north is same as current
                return 'E';
            }

        if (tileX > 0 && tileY > 0)
            if (this.mapTiles[tileX][tileY] == this.mapTiles[tileX - 1][tileY - 1]) { // if input = F;
                // tile to the northwest is same as current
                return 'F';
            }

        if (tileX > 1)
            if (this.mapTiles[tileX][tileY] == this.mapTiles[tileX - 2][tileY]) {  // if input = G;
                // 2 tiles west is same as current (skip a tile to the left)
                return 'G';
            }

        if (tileY > 1)
            if (this.mapTiles[tileX][tileY] == this.mapTiles[tileX][tileY - 2]) { // if input = H
                // 2 tiles north is same as current (skip the tile above)
                return 'H';
            }

        if (tileX > 1 && tileY > 1)
            if (this.mapTiles[tileX][tileY] == this.mapTiles[tileX - 2][tileY - 2]) { // if input= I
                // 2 tiles northwest is same as current (skip the diagonal)
                return 'I';
            }
        return '\0';
    }

    private String tileCodeToString(int tileCode) {
        int isNoSpecial = tileCode / 16777216;
        int shapeIndex = tileCode / 65536 % 256; // Becomes the SpecialIndex if isNoSpecial==2
        int foregroundElementIndex = tileCode / 256 % 256;
        int backgroundElementIndex = tileCode % 256;


        return mapChars.charAt(isNoSpecial) + "" + mapChars.charAt(shapeIndex) +
                "" + mapChars.charAt(foregroundElementIndex) + "" + (isNoSpecial == 2 ? "" : mapChars.charAt(backgroundElementIndex));
    }

    private int[][] tileTotileCodes(Tile[][] tiles) {
        int[][] result = new int[49][25];

        for (int y = 0; y < tiles[0].length; y++) {
            for (int x = 0; x < tiles.length; x++) {
                result[x][y] = tiles[x][y].getTileCode();
            }
        }
        return result;
    }
}
