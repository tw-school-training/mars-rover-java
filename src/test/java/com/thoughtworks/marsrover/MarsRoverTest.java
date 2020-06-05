package com.thoughtworks.marsrover;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {

    @Test
    public void should_return_init_place_given_initialize_command() {
        MarsRover marsRover = new MarsRover();

        Position position = marsRover.execute("1 2 N\n");

        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(2, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_x_plus_1_given_command_is_M_and_facing_is_E() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.E).build());

        Position position = marsRover.execute("M");

        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.E, position.getDirection());
    }

    @Test
    public void should_return_x_minus_1_given_command_is_M_and_facing_is_W() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.W).build());

        Position position = marsRover.execute("M");

        Assert.assertEquals(-1, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_return_y_plus_1_given_command_is_M_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Position position = marsRover.execute("M");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(1, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_y_minus_1_given_command_is_M_and_facing_is_S() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build());

        Position position = marsRover.execute("M");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(-1, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    public void should_return_facing_N_given_command_is_L_and_facing_is_E() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.E).build());

        Position position = marsRover.execute("L");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_facing_W_given_command_is_L_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Position position = marsRover.execute("L");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_return_facing_S_given_command_is_L_and_facing_is_W() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.W).build());

        Position position = marsRover.execute("L");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    public void should_return_facing_E_given_command_is_L_and_facing_is_S() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build());

        Position position = marsRover.execute("L");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.E, position.getDirection());
    }

    @Test
    public void should_return_facing_S_given_command_is_R_and_facing_is_E() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.E).build());

        Position position = marsRover.execute("R");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }

    @Test
    public void should_return_facing_W_given_command_is_R_and_facing_is_S() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build());

        Position position = marsRover.execute("R");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_return_facing_N_given_command_is_R_and_facing_is_W() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.W).build());

        Position position = marsRover.execute("R");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_return_facing_E_given_command_is_R_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Position position = marsRover.execute("R");

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals(Direction.E, position.getDirection());
    }

    @Test
    public void should_return_correct_location_and_direction_given_command_is_MLMMRMMML_and_facing_is_N() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build());

        Position position = marsRover.execute("MLMMRMMML");//y+1,W,x-1,x-1,N,y+1,y+1,y+1,W

        Assert.assertEquals(-2, position.getX());
        Assert.assertEquals(4, position.getY());
        Assert.assertEquals(Direction.W, position.getDirection());
    }

    @Test
    public void should_just_move_to_max_y_given_command_is_MM_and_facing_is_N_and_max_y_of_bound() {
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.N).build(),
                Bound.builder().maxY(2).build());

        Position position = marsRover.execute("MM");//y+1,W,x-1,x-1,N,y+1,y+1,y+1,W

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(2, position.getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void should_just_move_to_min_y_given_command_is_MM_and_facing_is_S_and_min_y_of_bound(){
        MarsRover marsRover = new MarsRover(Position.builder().x(0).y(0).direction(Direction.S).build(),
                Bound.builder().minY(-2).build());

        Position position = marsRover.execute("MM");//y+1,W,x-1,x-1,N,y+1,y+1,y+1,W

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(-2, position.getY());
        Assert.assertEquals(Direction.S, position.getDirection());
    }
}
