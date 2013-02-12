package com.rea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulator
{
    private ToyRobot toyRobot;

    public static int TABLE_X_MAX = 4;
    public static int TABLE_Y_MAX = 4;

    public void setRobot(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public ToyRobot getToyRobot() {
        return toyRobot;
    }

    public static void main(String[] args){
        Simulator simulator = new Simulator();
        System.out.println("Enter a command:");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String input = null;
        try {
            while ( ! "EXIT".equals(input = bufferedReader.readLine()) ) {
                String output = simulator.issueCommand(input);
                if (null != output) {
                    System.out.println(output);
                }
            }
        } catch (IOException ioe) {
            System.out.println("An error has occurred");
        }
    }

    /**
     * Issues the command from the user of the simulator
     *
     * @param action String command from the user
     * @return result String result of the command of the user if any
     */
    public String issueCommand(String action) {

        Command command = new Command(action);
        String result;

        if (command.isValid()){
            result = command.execute(this);
        } else {
            result = "Valid commands are: \"PLACE X,Y,NORTH|SOUTH|EAST|WEST\", MOVE, LEFT, RIGHT, REPORT or EXIT";
        }

        return result;
    }
}
