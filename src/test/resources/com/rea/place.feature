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