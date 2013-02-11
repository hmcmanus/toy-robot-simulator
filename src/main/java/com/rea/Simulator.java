package com.rea;

public class Simulator
{
    private ToyRobot toyRobot;
    private Command command;

    public static int TABLE_X_MAX = 4;
    public static int TABLE_Y_MAX = 4;

    public void issueCommand(String action) {

        command = new Command(action);

        if (command.isValid()){
            command.execute(this);
        } else {
            System.out.println("Invalid command");
        }
    }

    public void setRobot(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public ToyRobot getToyRobot() {
        return toyRobot;
    }
}