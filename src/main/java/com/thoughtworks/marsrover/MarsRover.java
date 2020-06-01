package com.thoughtworks.marsrover;

public class MarsRover {

    private Position current;

    public MarsRover() {
        current = new Position(0, 0, Direction.N);
    }

    public MarsRover(Position position) {
        current = position;
    }

    public Position execute(Command command) {
        current = command.execute(current);
        return current;
    }
}
