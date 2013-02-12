package com.rea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimulatorTest {
    private Simulator simulator;

    @Given("^the simulator has started$")
    public void the_simulator_has_started() throws Throwable {
        simulator = new Simulator();
    }

    @When("^I issue the command \"([^\"]*)\"$")
    public void I_issue_the_command(String command) throws Throwable {
        simulator.issueCommand(command);
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

    @Then("^the toy should not be on the board$")
    public void the_simulator_should_not_be_started() throws Throwable {
        assertNull(simulator.getToyRobot());
    }

}
