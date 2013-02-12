Feature: Turn the robot

  Scenario: Successful turn of the robot left
    Given the simulator has started
     When I issue the command "PLACE 0,0,NORTH"
      And I issue the command "LEFT"
     Then the position should be 0,0,"WEST"

  Scenario: Successful turn of the robot right
      Given the simulator has started
       When I issue the command "PLACE 0,0,NORTH"
        And I issue the command "RIGHT"
       Then the position should be 0,0,"EAST"
