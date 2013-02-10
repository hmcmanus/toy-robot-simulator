package com.rea;

public class ToyRobot {

    private Direction direction;
    private int x;
    private int y;

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

    public void move() {
        switch (this.direction) {
            case NORTH:
                this.y = ++this.y;
                break;
            case EAST:
                this.x = ++this.x;
                break;
            case SOUTH:
                this.y = --this.y;
                break;
            case WEST:
                this.x = --this.x;
                break;
            default:
                System.out.println("Can't move this direction");
                break;
        }
    }

    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }

    public Direction getDirection() {
        return direction;
    }

}