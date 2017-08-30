String line = tknzr.nextToken();
if (!line.startsWith("V ")) {// "V 1"
    return false;
} else if (Integer.parseInt(line.substring(2)) != 1) {// if not "V 1"
    return false;
} else {
    line = tknzr.nextToken();
    if (!line.startsWith("A ")) {// "A author name"
        return false;
    } else {
        this.author = line.substring(2).trim();
        if (this.author.length() == 0) {
            return false;
        } else {
            line = tknzr.nextToken();
            if (!line.startsWith("N ")) {// "N trakc name"
                return false;
            } else {
                this.trackName = line.substring(2).trim();
                if (this.trackName.length() == 0) {
                    return false;
                } else {
                    line = tknzr.nextToken();
                    if (line.startsWith("C ")) {// "C ???" todo
                        this.aString88 = line.substring(2).trim();
                        line = tknzr.nextToken();
                    } else {
                        this.aString88 = null;
                    }

                    if (!line.startsWith("T ")) {// "T track data,Ads:xxx"
                        return false;

                    } else {

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

                        StringTokenizer tokenizer = new StringTokenizer(mapData, ",");
                        mapData = this.expandMap(tokenizer.nextToken());
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
                                    this.mapTiles[tileX][tileY] = currentMapIndex * 256 * 256 * 256 + mapcursor_one_ahead * 256 * 256 + mapcursor_two_ahead * 256 + mapcursor_three_ahead;
                                } else {
                                    if (currentMapIndex == 3) {  // if input = D
                                        this.mapTiles[tileX][tileY] = this.mapTiles[tileX - 1][tileY]; // tile to west is same as current
                                    }

                                    if (currentMapIndex == 4) { // if input = E;
                                        this.mapTiles[tileX][tileY] = this.mapTiles[tileX][tileY - 1]; // tile to the north is same as current
                                    }

                                    if (currentMapIndex == 5) { // if input = F;
                                        this.mapTiles[tileX][tileY] = this.mapTiles[tileX - 1][tileY - 1]; // tile to the northwest is same as current
                                    }

                                    if (currentMapIndex == 6) {  // if input = G;
                                        this.mapTiles[tileX][tileY] = this.mapTiles[tileX - 2][tileY]; // 2 tiles west is same as current (skip a tile to the left)
                                    }

                                    if (currentMapIndex == 7) { // if input = H
                                        this.mapTiles[tileX][tileY] = this.mapTiles[tileX][tileY - 2]; // 2 tiles north is same as current (skip the tile above)
                                    }

                                    if (currentMapIndex == 8) { // if input= I
                                        this.mapTiles[tileX][tileY] = this.mapTiles[tileX - 2][tileY - 2]; // 2 tiles northwest is same as current (skip the diagonal)
                                    }

                                    ++cursorIndex;
                                }
                            }
                        }

                        for (tileX = 0; tileX < advertSize; ++tileX) {
                            this.anIntArrayArray97[tileX][0] = this.anIntArrayArray97[tileX][1] = -1;
                        }

                        int var12;
                        int var14;
                        if (tokenizer.hasMoreTokens()) {
                            mapData = tokenizer.nextToken();
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

                        this.aString89 = aString77;
                        this.firstBestPar = this.lastBestPar = null;
                        this.trackStokesRecord = null;
                        this.briefRatings = null;

                        while (tknzr.hasMoreTokens()) {
                            mapData = tknzr.nextToken();
                            if (mapData.startsWith("S ")) {
                                this.aString89 = mapData.substring(2).trim();
                                if (this.aString89.length() != 6) {
                                    return false;
                                }
                            }

                            StringTokenizer var15;
                            if (mapData.startsWith("I ")) {
                                var15 = new StringTokenizer(mapData.substring(2), ",");
                                if (var15.countTokens() != 4) {
                                    return false;
                                }

                                this.trackStokesRecord = new int[4];

                                for (var14 = 0; var14 < 4; ++var14) {
                                    this.trackStokesRecord[var14] = Integer.parseInt(var15.nextToken());
                                }
                            }

                            if (mapData.startsWith("B ")) {
                                this.firstBestPar = mapData.substring(2);
                            }

                            if (mapData.startsWith("L ")) {
                                this.lastBestPar = mapData.substring(2);
                            }

                            if (mapData.startsWith("R ")) {
                                var15 = new StringTokenizer(mapData.substring(2), ",");
                                if (var15.countTokens() != 11) {
                                    return false;
                                }

                                this.briefRatings = new int[11];

                                for (var14 = 0; var14 <= 10; ++var14) {
                                    this.briefRatings[var14] = Integer.parseInt(var15.nextToken());
                                }
                            }
                        }

                        this.aBooleanArray96 = new boolean[4];

                        for (var12 = 0; var12 < 4; ++var12) {
                            this.aBooleanArray96[var12] = this.aString89.charAt(var12) == 116;
                        }

                        this.checkSolids();
                        this.drawForegroundMap();
                        return true;
                    }


                }
            }
        }
    }
}
