package com.rea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTest {
//    private Game hello;
//    private String hi;
//
//    @Given("^I have a hello app with \"([^\"]*)\"$")
//    public void I_have_a_hello_app_with(String greeting) {
//        hello = new Game(greeting);
//    }
//
//    @When("^I ask it to say hi$")
//    public void I_ask_it_to_say_hi() {
//        hi = hello.sayHi();
//    }
//
//    @Then("^it should answer with \"([^\"]*)\"$")
//    public void it_should_answer_with(String expectedHi) {
//        assertEquals(expectedHi, hi);
//    }

    private Game game;
    private ToyRobot toyRobot;

    @Given("^the game has started$")
    public void the_game_has_started() throws Throwable {
        game = new Game();
    }

    @Given("^the robot is in position \\(NORTH,(\\d+),(\\d+)\\)$")
    public void the_robot_is_in_position_NORTH_(int xPosition, int yPosition) throws Throwable {
        toyRobot = new ToyRobot(ToyRobot.Direction.NORTH, 0, 0);
        game.setRobot(toyRobot);
    }

    @When("^I give it the MOVE command$")
    public void I_give_it_the_MOVE_command() throws Throwable {
        toyRobot.move();
    }

    @Then("^the position should be \\(NORTH,(\\d+),(\\d+)\\)$")
    public void the_position_should_be_NORTH_(int xPosition, int yPosition) throws Throwable {
        ToyRobot movedRobot = game.getToyRobot();
        assertThat(movedRobot.getDirection(), is(ToyRobot.Direction.NORTH));
        assertEquals(movedRobot.getXPosition(), xPosition);
        assertEquals(movedRobot.getYPosition(), yPosition);
    }


}
