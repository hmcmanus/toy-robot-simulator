package com.rea;

public class Game
{
    private ToyRobot toyRobot;
    private Command command;

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
