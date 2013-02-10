Feature: Turn the robot

  Scenario: Successful turn of the robot left
    Given the game has started
      And the robot is in position 0,0,"NORTH"
     When I give it the LEFT command
     Then the position should be 0,0,"WEST"

  Scenario: Successful turn of the robot right
      Given the game has started
        And the robot is in position 0,0,"NORTH"
       When I give it the RIGHT command
       Then the position should be 0,0,"EAST"
