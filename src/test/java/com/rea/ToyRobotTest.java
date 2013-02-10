package com.rea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ToyRobotTest {

    private Game game;
    private ToyRobot toyRobot;

    @Given("^the game has started$")
    public void the_game_has_started() throws Throwable {
        game = new Game();
    }

    @Given("^the robot is in position (\\d+),(\\d+),\"([^\"]*)\"$")
    public void the_robot_is_in_position_(int x, int y, String direction) throws Throwable {
        toyRobot = new ToyRobot(ToyRobot.Direction.valueOf(direction), 0, 0);
        game.setRobot(toyRobot);
    }

    @Then("^the position should be (\\d+),(\\d+),\"([^\"]*)\"$")
    public void the_position_should_be_(int xPosition, int yPosition, String direction) throws Throwable {
        ToyRobot movedRobot = game.getToyRobot();
        assertThat(movedRobot.getDirection(), Is.is(ToyRobot.Direction.valueOf(direction)));
        assertEquals(movedRobot.getXPosition(), xPosition);
        assertEquals(movedRobot.getYPosition(), yPosition);
    }

    @When("^I give it the LEFT command$")
    public void I_give_it_the_LEFT_command() throws Throwable {
        toyRobot.turnLeft();
    }

    @When("^I give it the MOVE command$")
    public void I_give_it_the_MOVE_command() throws Throwable {
        toyRobot.move();
    }

    @When("^I give it the RIGHT command$")
    public void I_give_it_the_RIGHT_command() throws Throwable {
        toyRobot.turnRight();
    }
}
