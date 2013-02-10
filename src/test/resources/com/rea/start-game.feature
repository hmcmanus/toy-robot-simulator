Feature: Start the game

  Scenario: Start the game with a MOVE command
    Given the game has started
      And the robot is in position (NORTH,0,0)
     When I give it the MOVE command
     Then the position should be (NORTH,0,1)
