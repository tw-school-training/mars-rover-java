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

    @Test
    public void should_return_x_plus_1_given_command_is_M_and_facing_is_E() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.E).build());

        Command command = new Command("M");
        Position position = marsRover.execute(command);

        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.E, position.getDirection());
    }

    @Test
    public void should_return_x_minus_1_given_command_is_M_and_facing_is_W() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.W).build());

        Command command = new Command("M");
        Position position = marsRover.execute(command);

        Assert.assertEquals(-1, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_return_y_plus_1_given_command_is_M_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Command command = new Command("M");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(1, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_y_minus_1_given_command_is_M_and_facing_is_S() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build());

        Command command = new Command("M");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(-1, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    public void should_return_facing_N_given_command_is_L_and_facing_is_E() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.E).build());

        Command command = new Command("L");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_facing_W_given_command_is_L_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Command command = new Command("L");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_return_facing_S_given_command_is_L_and_facing_is_W() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.W).build());

        Command command = new Command("L");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    public void should_return_facing_E_given_command_is_L_and_facing_is_S() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build());

        Command command = new Command("L");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.E, position.getDirection());
    }

    @Test
    public void should_return_facing_S_given_command_is_R_and_facing_is_E() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.E).build());

        Command command = new Command("R");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    public void should_return_facing_W_given_command_is_R_and_facing_is_S() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build());

        Command command = new Command("R");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_return_facing_N_given_command_is_R_and_facing_is_W() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.W).build());

        Command command = new Command("R");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_facing_E_given_command_is_R_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Command command = new Command("R");
        Position position = marsRover.execute(command);

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.E, position.getDirection());
    }
}
