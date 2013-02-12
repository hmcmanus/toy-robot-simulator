Feature: Turn the robot

  Scenario Outline: Successful turn of the robot left
    Given the simulator has started
     When I issue the command <start-position>
      And I issue the command "LEFT"
     Then the position should be <end-position>

  Examples:
  | start-position | end-position |
  | "PLACE 0,0,NORTH" | 0,0,"WEST" |
  | "PLACE 0,0,EAST" | 0,0,"NORTH" |
  | "PLACE 0,0,SOUTH" | 0,0,"EAST" |
  | "PLACE 0,0,WEST" | 0,0,"SOUTH" |

  Scenario Outline: Successful turn of the robot right
      Given the simulator has started
       When I issue the command <start-position>
        And I issue the command "RIGHT"
       Then the position should be <end-position>

  Examples:
    | start-position | end-position |
    | "PLACE 0,0,NORTH" | 0,0,"EAST" |
    | "PLACE 0,0,EAST" | 0,0,"SOUTH" |
    | "PLACE 0,0,SOUTH" | 0,0,"WEST" |
    | "PLACE 0,0,WEST" | 0,0,"NORTH" |
