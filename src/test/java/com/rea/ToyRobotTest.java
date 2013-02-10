package com.rea;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToyRobotTest {

    @Test
    public void shouldMoveRobotNorth(){
        ToyRobot toyRobot = new ToyRobot(ToyRobot.Direction.NORTH, 0, 0);
        toyRobot.move();
        assertEquals(toyRobot.getXPosition(), 0);
        assertEquals(toyRobot.getYPosition(), 1);
    }

    @Test
    public void shouldMoveRobotEast(){
        ToyRobot toyRobot = new ToyRobot(ToyRobot.Direction.EAST, 1, 1);
        toyRobot.move();
        assertEquals(toyRobot.getXPosition(), 2);
        assertEquals(toyRobot.getYPosition(), 1);
    }

    @Test
    public void shouldMoveRobotSouth(){
        ToyRobot toyRobot = new ToyRobot(ToyRobot.Direction.SOUTH, 1, 1);
        toyRobot.move();
        assertEquals(toyRobot.getXPosition(), 1);
        assertEquals(toyRobot.getYPosition(), 0);
    }

    @Test
    public void shouldMoveRobotWest(){
        ToyRobot toyRobot = new ToyRobot(ToyRobot.Direction.WEST, 1, 1);
        toyRobot.move();
        assertEquals(toyRobot.getXPosition(), 0);
        assertEquals(toyRobot.getYPosition(), 1);
    }

}
