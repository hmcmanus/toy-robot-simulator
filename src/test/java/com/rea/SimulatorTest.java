package com.rea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimulatorTest {
    private Simulator simulator;
    private ToyRobot toyRobot;

    @Given("^the simulator has started$")
    public void the_simulator_has_started() throws Throwable {
        simulator = new Simulator();
    }

    @Given("^I issue the command \"([^\"]*)\"$")
    public void I_issue_the_command(String command) throws Throwable {
        simulator.issueCommand(command);
    }

    @Given("^the robot is in position (\\d+),(\\d+),\"([^\"]*)\"$")
    public void the_robot_is_in_position_(int x, int y, String direction) throws Throwable {
        toyRobot = new ToyRobot(ToyRobot.Direction.valueOf(direction), 0, 0);
        simulator.setRobot(toyRobot);
    }

    @Then("^the position should be (\\d+),(\\d+),\"([^\"]*)\"$")
    public void the_position_should_be_(int xPosition, int yPosition, String direction) throws Throwable {
        ToyRobot movedRobot = simulator.getToyRobot();
        if (movedRobot == null){
            fail("Moved robot is null");
        }
        assertThat(ToyRobot.Direction.valueOf(direction), is(movedRobot.getDirection()));
        assertEquals(xPosition, movedRobot.getXPosition());
        assertEquals(yPosition, movedRobot.getYPosition());
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

    @Then("^the toy should not be on the board$")
    public void the_simulator_should_not_be_started() throws Throwable {
        assertNull(simulator.getToyRobot());
    }

}
