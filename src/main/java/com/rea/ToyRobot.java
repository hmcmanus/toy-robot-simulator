package com.rea;

public class ToyRobot {

    private Direction direction;
    private int x;
    private int y;

    /**
     * Constructs the toy robot for the simulator
     *
     * @param direction Initialises the direction of the robot
     * @param x Initialises the x position of the board on the table
     * @param y Initialises the y position of the board on the table
     */
    public ToyRobot(Direction direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Moves the robot one square in the direction it is currently facing
     *
     */
    public void move() {
        switch (this.direction) {
            case NORTH:
                ++this.y;
                break;
            case EAST:
                ++this.x;
                break;
            case SOUTH:
                --this.y;
                break;
            case WEST:
                --this.x;
                break;
            default:
                // Should not get to this point - log
                break;
        }
    }

    /**
     * Turns the robot through 90 degrees anticlockwise from where it's currently facing without moving it
     */
    public void turnLeft() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            case WEST:
                this.direction = Direction.SOUTH;
                break;
            default:
                // Should not get to this point - log
                break;
        }
    }

    /**
     * Turns the robot through 90 degrees clockwise from where it's currently facing without moving it
     */
    public void turnRight() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.NORTH;
                break;
            default:
                // Should not get to this point - log
                break;
        }
    }

    /**
     * Returns the current position of the robot
     *
     * @return String describing the current position of the robot
     */
    public String report() {
        return this.x + "," + this.y + "," + this.direction.toString();
    }

    /**
     * Enum denoting the possible directions allowed for the robot
     */
    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
}
