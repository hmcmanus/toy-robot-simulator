package com.rea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
    public void the_position_should_be_(String xPosition, String yPosition, String direction) throws Throwable {
        String output = simulator.issueCommand("REPORT");
        if (output == null){
            fail("Output null");
        }

        String[] splitOut = output.split(",");

        assertEquals(splitOut[0], xPosition );
        assertEquals(splitOut[1], yPosition);
        assertEquals(splitOut[2], direction);
    }

    @Then("^the toy should not be on the board$")
    public void the_simulator_should_not_be_started() throws Throwable {
        assertNull(simulator.getToyRobot());
    }

}
