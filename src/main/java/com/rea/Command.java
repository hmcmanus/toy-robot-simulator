package com.rea;

public class Command {

    private String rawCommand;
    private Action action;
    private int xParameter;
    private int yParameter;
    private ToyRobot.Direction dirParameter;

    /**
     * Constructs the command object with the command string as input
     *
     * @param action String representing the action of the command
     */
    public Command(String action) {
        this.rawCommand = action;
    }

    /**
     * Validates that the command given to the simulator
     *
     * @return boolean indicating validity of command
     */
    public boolean isValid() {
        return parseCommand();
    }

    private boolean parseCommand() {
        boolean successfulParse = false;
        String[] actionAndParams = rawCommand.split(" ");
        if (isGoodAction(actionAndParams[0])) {
            if (this.action == Action.PLACE) {
                if (actionAndParams.length > 1 && isGoodParams(actionAndParams[1])){
                    successfulParse = true;
                }
            } else {
                // At this stage we know the command is good
                successfulParse = true;
            }
        }
        return successfulParse;
    }

    private boolean isGoodParams(String params) {
        boolean goodParams;
        String[] splitParams = params.split(",");
        if (splitParams.length == 3) {
            // Cool, we have the correct number of params
            try {
                xParameter = Integer.parseInt(splitParams[0]);
                yParameter = Integer.parseInt(splitParams[1]);
                dirParameter = ToyRobot.Direction.valueOf(splitParams[2]);
                goodParams = true;
            } catch (Exception e) {
                goodParams = false;
            }
        } else {
            goodParams = false;
        }
        return goodParams;
    }

    private boolean isGoodAction(String rawAction) {
        boolean validAction;
        try {
            this.action = Command.Action.valueOf(rawAction);
            validAction = true;
        } catch (IllegalArgumentException e) {
            validAction = false;
        }
        return validAction;
    }

    /**
     * Executes the command given to the simulator
     *
     * @param simulator The simulator to action the command on
     */
    public String execute(Simulator simulator) {
        String result = null;
        switch (this.action) {
            case PLACE:
                handlePlaceCommand(simulator);
                break;
            case MOVE:
                handleMoveCommand(simulator);
                break;
            case LEFT:
                if (simulator.getToyRobot() != null) {
                    simulator.getToyRobot().turnLeft();
                }
                break;
            case RIGHT:
                if (simulator.getToyRobot() != null) {
                    simulator.getToyRobot().turnRight();
                }
                break;
            case REPORT:
                if (simulator.getToyRobot() != null) {
                    result = simulator.getToyRobot().report();
                }
                break;
            default:
                // log - Ignoring command
        }
        return result;
    }

    private void handleMoveCommand(Simulator simulator) {
        if (simulator.getToyRobot() != null) {
            if (canMoveRobot(simulator)) {
                simulator.getToyRobot().move();
            }
        }
    }

    private boolean canMoveRobot(Simulator simulator) {
        boolean movableRobot = true;

        if ( simulator.getToyRobot().getDirection() == ToyRobot.Direction.SOUTH &&
                simulator.getToyRobot().getYPosition() == 0) {
            movableRobot = false;
        }

        if ( simulator.getToyRobot().getDirection() == ToyRobot.Direction.WEST &&
                simulator.getToyRobot().getXPosition() == 0) {
            movableRobot = false;
        }

        if ( simulator.getToyRobot().getDirection() == ToyRobot.Direction.EAST &&
                simulator.getToyRobot().getXPosition() == Simulator.TABLE_X_MAX) {
            movableRobot = false;
        }

        if ( simulator.getToyRobot().getDirection() == ToyRobot.Direction.NORTH &&
                simulator.getToyRobot().getYPosition() == Simulator.TABLE_Y_MAX) {
            movableRobot = false;
        }

        return movableRobot;
    }

    private void handlePlaceCommand(Simulator simulator) {
        if (isXValid(Simulator.TABLE_X_MAX) && isYValid(Simulator.TABLE_Y_MAX)) {
            simulator.setRobot(new ToyRobot(dirParameter, xParameter, yParameter));
        }
    }

    private boolean isYValid(int maxValue) {
        return (yParameter >= 0 && yParameter <= maxValue);
    }

    private boolean isXValid(int maxValue) {
        return (xParameter >= 0 && xParameter <= maxValue);
    }

    private enum Action {
        PLACE,
        MOVE,
        LEFT,
        RIGHT,
        REPORT
    }

}
