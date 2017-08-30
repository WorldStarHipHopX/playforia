class @MapParser

  @parse: (mapData) ->
    try
      parser = new MapParser()
      expandedMapData = parser.expandData(mapData)
      tileCodes = parser.parseExpandedData(expandedMapData)
      tiles = parser.convertTiles(tileCodes)
      new Map(tiles)
    catch err
      error(err.name + ": " + err.message + "\n        at MapParser.parse[mapData.length=" + mapData.length + "]")

  convertTiles: (tileCodes) ->
    tiles = Util.createEmptyArray2d(Map.mapWidth, Map.mapHeight);
    try
      for tileY in [0...Map.mapHeight] by 1
        for tileX in [0...Map.mapWidth] by 1
          tileCode = tileCodes[tileX][tileY]
          #tiles[tileX][tileY] = new Tile(tileCode >> 24, (tileCode >> 16) % 0xff, (tileCode >> 8) % 0xff, tileCode % 0xff)
          tiles[tileX][tileY] = new Tile(tileCode / 0x1000000, tileCode / 0x10000 % 0x100, tileCode / 0x100 % 0x100, tileCode % 0x100)
    catch err
      error(err.name + ": " + err.message + "\n        at MapParser.convertTiles[tileX=" + tileX + ", tileY=" + tileY + "]")
    tiles

  parseExpandedData: (expandedMapData) ->
    tileCodes = Util.createEmptyArray2d(Map.mapWidth, Map.mapHeight);
    cursorIndex = 0
    try
      for tileY in [0...Map.mapHeight] by 1
        for tileX in [0...Map.mapWidth] by 1
            currentMapIndex = Map.mapChars.indexOf(expandedMapData.charAt(cursorIndex))
            if currentMapIndex <= 2
              shape = Map.mapChars.indexOf(expandedMapData.charAt(cursorIndex + 1))
              background = Map.mapChars.indexOf(expandedMapData.charAt(cursorIndex + 2))
              foreground = 0
              if currentMapIndex == 1
                foreground = Map.mapChars.indexOf(expandedMapData.charAt(cursorIndex + 3))
                cursorIndex += 4
              else
                cursorIndex += 3
              # currentMapIndex => special
              # ok the whole foreground background thing is just fucked, but it works so meh
              tileCodes[tileX][tileY] = (currentMapIndex << 24) + (shape << 16) + (background << 8) + foreground
            else
              if currentMapIndex == 3
                tileCodes[tileX][tileY] = tileCodes[tileX - 1][tileY]
              else if currentMapIndex == 4
                tileCodes[tileX][tileY] = tileCodes[tileX][tileY - 1]
              else if currentMapIndex == 5
                tileCodes[tileX][tileY] = tileCodes[tileX - 1][tileY - 1]
              else if currentMapIndex == 6
                tileCodes[tileX][tileY] = tileCodes[tileX - 2][tileY]
              else if currentMapIndex == 7
                tileCodes[tileX][tileY] = tileCodes[tileX][tileY - 2]
              else if currentMapIndex == 8
                tileCodes[tileX][tileY] = tileCodes[tileX - 2][tileY - 2]
              cursorIndex++
    catch err
      error(err.name + ": " + err.message + "\n        at MapParser.parseExpandedData[tileX=" + tileX + ", tileY=" + tileY + "]")
    tileCodes

  expandData: (mapData) ->
    ret = []
    length = mapData.length
    for uselessvar in [0...length] by 1
      var5 = @method123(mapData, _i)
      if var5 >= 2 then _i++
      if var5 >= 10 then _i++
      if var5 >= 100 then _i++
      if var5 >= 1000 then _i++
      var6 = mapData.charAt(_i)
      for var7 in [0...var5] by 1
        ret.push(var6)
    return ret.join("")

  method123: (input, cursor) ->
    var3 = null
    while true
      var4 = input.charAt(cursor)
      if var4 < '0' or var4 > '9'
        return if !var3 then 1 else parseInt(var3)
      if !var3 then var3 = var4 else var3 = var3 + var4
      cursor++
    return
