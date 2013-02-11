Feature: Placing the toy on the board

  Scenario: Successful place of the toy
    Given the game has started
     When I issue the command "PLACE 0,0,NORTH"
     Then the position should be 0,0,"NORTH"

  Scenario: Place the toy after already placed
    Given the game has started
     When I issue the command "PLACE 0,0,EAST"
     Then I issue the command "PLACE 0,3,SOUTH"
     Then the position should be 0,3,"SOUTH"

  Scenario Outline: Ignore a bad place command
    Given the game has started
     When I issue the command <bad-command>
     Then the toy should not be on the board

  Examples:
  | bad-command |
  | "PLACE o,0,EAST" |
  | "PLACE 0,o,WEST" |
  | "PLACE 0,0,TEST" |
  | "PLACE,0,0,SOUTH" |
  | "PLACE" |
  | " 0,0,NORTH" |