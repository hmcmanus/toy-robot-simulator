package com.rea;

public class Command {

    private String rawCommand;
    private Action action;
    private int xParameter;
    private int yParameter;
    private ToyRobot.Direction dirParameter;

    public Command(String action) {
        this.rawCommand = action;
    }

    public boolean isValid() {
        return parseCommand();
    }

    private boolean parseCommand() {
        boolean successfulParse = false;
        String[] actionAndParams = rawCommand.split(" ");
        if (isGoodAction(actionAndParams[0])) {
            if (this.action == Action.PLACE) {
                if (actionAndParams.length > 1 & isGoodParams(actionAndParams[1])){
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

    public void execute(Game game) {
        switch (this.action) {
            case PLACE:
                game.setRobot(new ToyRobot(dirParameter, xParameter, yParameter));
                break;
            case MOVE:
                if (game.getToyRobot()!= null) {
                    game.getToyRobot().move();
                }
                break;
            case LEFT:
                if (game.getToyRobot() != null) {
                    game.getToyRobot().turnLeft();
                }
                break;
            case RIGHT:
                if (game.getToyRobot() != null) {
                    game.getToyRobot().turnRight();
                }
                break;
            case REPORT:
                if (game.getToyRobot() != null) {
                    game.getToyRobot().report();
                }
                break;
            default:
                System.out.println("Ignoring command");
        }
    }

    public enum Action {
        PLACE,
        MOVE,
        LEFT,
        RIGHT,
        REPORT;
    }

}
