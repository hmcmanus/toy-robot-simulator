Feature: Moving the toy around the board

  Scenario: Successful move of the toy
    Given the game has started
      And the robot is in position 0,0,"NORTH"
     When I give it the MOVE command
     Then the position should be 0,1,"NORTH"
