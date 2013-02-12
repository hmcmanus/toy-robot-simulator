Feature: Moving the toy around the board

  Scenario Outline: Successful move of the toy
    Given the simulator has started
     When I issue the command <starting-position>
      And I issue the command "MOVE"
     Then the position should be <end-position>

  Examples:
  | starting-position | end-position |
  | "PLACE 0,0,NORTH" | 0,1,"NORTH" |
  | "PLACE 0,0,EAST" | 1,0,"EAST" |
  | "PLACE 0,1,SOUTH" | 0,0,"SOUTH" |
  | "PLACE 1,0,WEST" | 0,0,"WEST" |

  Scenario: Toy doesn't move if the simulator isn't started
    Given the simulator has started
     When I issue the command "MOVE"
     Then the toy should not be on the board

  Scenario Outline: Toy doesn't move beyond the table boundaries
      Given the simulator has started
       When I issue the command <starting-position>
       When I issue the command "MOVE"
       Then the position should be <end-position>

  Examples:
  | starting-position | end-position |
  | "PLACE 0,0,SOUTH" | 0,0,"SOUTH" |
  | "PLACE 0,0,WEST" | 0,0,"WEST" |
  | "PLACE 4,0,EAST" | 4,0,"EAST" |
  | "PLACE 0,4,NORTH" | 0,4,"NORTH" |