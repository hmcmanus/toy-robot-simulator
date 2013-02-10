package com.rea;

public class Game
{
    private ToyRobot toyRobot;

    public void setRobot(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public void move() {
        toyRobot.move();
    }

    public ToyRobot getToyRobot() {
        return toyRobot;
    }
}
