class @SpriteManager

  constructor: () ->
    @sprites = []

  # sheetImage MUST already be loaded
  loadSheet: (context, sheetName, sheetImage, spriteCount, spritesPerColumn, spriteWidth, spriteHeight) ->
    try
      @sprites[sheetName] = new Array(spriteCount);
      sheetWidth = sheetImage.width
      sheetHeight = sheetImage.height
      context.drawImage(sheetImage, 0, 0);

      for index in [0...spriteCount] by 1
        sheetRow = parseInt(index / spritesPerColumn)
        sheetColumn = index % spritesPerColumn
        sheetX = sheetColumn * spriteHeight + sheetColumn + 1
        sheetY = sheetRow * spriteWidth + sheetRow + 1

        @sprites[sheetName][index] = new Sprite(context.getImageData(sheetX, sheetY, spriteWidth, spriteHeight), spriteWidth, spriteHeight)

      context.clearRect(0, 0, sheetWidth, sheetHeight)
    catch err
      error(err.name + ": " + err.message + "\n        at SpriteManager.loadSheet[sheetName=" + sheetName + "]")
    # return or Kappa gets returned, and we don't want that now do we
    return

class @Sprite

  constructor: (@spriteData, @spriteWidth, @spriteHeight) ->

  draw: (context, x, y) ->
    context.putImageData(@spriteData, x, y)
