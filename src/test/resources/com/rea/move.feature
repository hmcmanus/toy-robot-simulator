Feature: Moving the toy around the board

  Scenario: Successful move of the toy
    Given the game has started
     When I issue the command "PLACE 0,0,NORTH"
      And I issue the command "MOVE"
     Then the position should be 0,1,"NORTH"

  Scenario: Toy doesn't move if the game isn't started
    Given the game has started
     When I issue the command "MOVE"
     Then the toy should not be on the board