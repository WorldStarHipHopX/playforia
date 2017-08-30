class @Tile

  constructor: (special, shape, foreground, background) ->
    @special = parseInt(special)
    @shape = parseInt(shape)
    @foreground = parseInt(foreground)
    @background = parseInt(background)

  isSpecial: () ->
    @special == 2

  getTileCode: () ->
    (@special << 24) | (@shape << 16) | (@background << 8) | @foreground

  toString: () ->
    "Tile[tileCode=" + @getTileCode() + ", special=" + @special + ", shape=" + @shape + ", background=" + @background + ", foreground=" + @foreground + "]"
