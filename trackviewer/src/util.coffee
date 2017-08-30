class @Util
  @createEmptyArray2d: (rows, cols) ->
    array = new Array(rows)
    for i in [0...rows] by 1
      array[i] = new Array(cols)
      for j in [0...cols] by 1
        array[i][j] = 0
    array

  @rgb2long: (red, green, blue) ->
    (red << 16) + (green << 8) + blue

  @usingAgent: (agent) ->
    return navigator.userAgent.toLowerCase().indexOf(agent.toLowerCase()) > -1
