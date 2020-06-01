package com.thoughtworks.marsrover;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {

    @Test
    public void should_return_init_place_given_command_is_empty() {
        MarsRover marsRover = new MarsRover();

        Command command = new Command();
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }
}
