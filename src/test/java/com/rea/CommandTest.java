package com.rea;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CommandTest {

    @Test
    public void shouldReturnTrueForMoveCommand(){
        Command command = new Command("MOVE");
        assertTrue(command.isValid());
    }

    @Test
    public void shouldReturnFalseForJibberishCommand() {
        Command command = new Command("foo");
        assertFalse(command.isValid());
    }

    @Test
    public void shouldReturnTrueForParseCommand(){
        Command command = new Command("PLACE 0,0,NORTH");
        assertTrue(command.isValid());
    }

    @Test
    public void shouldReturnFalseForInValidPlaceCommands() {
        Command commandBadX = new Command("PLACE foo,0,NORTH");
        Command commandBadY = new Command("PLACE 0,bar,NORTH");
        Command commandBadDir = new Command("PLACE 0,0,ANYWAY");
        assertFalse(commandBadX.isValid());
        assertFalse(commandBadY.isValid());
        assertFalse(commandBadDir.isValid());
    }
}
