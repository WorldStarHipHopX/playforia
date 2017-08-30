class @Map

  @mapChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
  @mapWidth = 49
  @mapHeight = 25

  constructor: (@tiles) ->

  getTile: (x, y) ->
    return if x >= 0 and x < @mapWidth and y >= 0 and y < @mapHeight then @tiles[x][y] else undefined

  draw: (context, spriteManager, contextX, contextY) ->
    grid = true
    context.clearRect(0, 0, Map.mapWidth * 15, Map.mapWidth * 15)
    lastTile = null
    try
      for tileY in [0...Map.mapHeight] by 1
        for tileX in [0...Map.mapWidth] by 1
          lastTile = tile = @tiles[tileX][tileY]
          isSpecial = tile.isSpecial()
          shape = tile.shape
          background = tile.background
          foreground = tile.foreground

          drawAtX = contextX + tileX * 15
          drawAtY = contextY + tileY * 15

          if isSpecial || shape == 0
            spriteManager.sprites["elements"][background].draw(context, drawAtX, drawAtY)
            spriteManager.sprites["elements"][foreground].draw(context, drawAtX, drawAtY)
            if isSpecial and shape != 4 and shape != 6
              # 4 and 6 are mines
              foregroundPixels = context.getImageData(drawAtX, drawAtY, 15, 15).data
              if shape == 0 or (shape >= 24 and shape <= 27)
                spriteManager.sprites["balls"][if shape == 0 then 0 else shape - 24].draw(context, drawAtX + 1, drawAtY + 1)# balls are 13x13
              else
                spriteManager.sprites["special"][shape].draw(context, drawAtX, drawAtY)
              tileImageData = context.getImageData(drawAtX, drawAtY, 15, 15)
              tilePixels = tileImageData.data
              for i in [0...tilePixels.length] by 4
                if Util.rgb2long(tilePixels[i], tilePixels[i + 1], tilePixels[i + 2]) == 0xccccff or tilePixels[i + 3] == 0
                  tileImageData.data[i] = foregroundPixels[i]
                  tileImageData.data[i + 1] = foregroundPixels[i + 1]
                  tileImageData.data[i + 2] = foregroundPixels[i + 2]
                  tileImageData.data[i + 3] = foregroundPixels[i + 3]
              context.putImageData(tileImageData, drawAtX, drawAtY)
          else if !isSpecial and shape > 0
            sw = spriteManager.sprites["shapes"][shape].spriteWidth
            sh = spriteManager.sprites["shapes"][shape].spriteHeight

            spriteManager.sprites["elements"][background].draw(context, drawAtX, drawAtY)
            pixelsBg = context.getImageData(drawAtX, drawAtY, sw, sh).data

            spriteManager.sprites["elements"][foreground].draw(context, drawAtX, drawAtY)
            pixelsFg = context.getImageData(drawAtX, drawAtY, sw, sh).data

            spriteManager.sprites["shapes"][shape].draw(context, drawAtX, drawAtY)

            tileImageData = context.getImageData(drawAtX, drawAtY, sw, sh)
            tilePixels = tileImageData.data
            for i in [0...tilePixels.length] by 4
              colour = Util.rgb2long(tilePixels[i], tilePixels[i + 1], tilePixels[i + 2])
              if colour == 0xccccff
                tileImageData.data[i] = pixelsFg[i]
                tileImageData.data[i + 1] = pixelsFg[i + 1]
                tileImageData.data[i + 2] = pixelsFg[i + 2]
                tileImageData.data[i + 3] = pixelsFg[i + 3]
              else if colour == 0
                tileImageData.data[i] = pixelsBg[i]
                tileImageData.data[i + 1] = pixelsBg[i + 1]
                tileImageData.data[i + 2] = pixelsBg[i + 2]
                tileImageData.data[i + 3] = pixelsBg[i + 3]
            context.putImageData(tileImageData, drawAtX, drawAtY)

    catch err
      error(err.name + ": " + err.message + "\n        at Map.draw[tileX=" + tileX + ", tileY=" + tileY + "]" + (if lastTile then "\n            last tile: " + lastTile))
    return
