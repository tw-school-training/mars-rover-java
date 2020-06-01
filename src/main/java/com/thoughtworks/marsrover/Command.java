package com.thoughtworks.marsrover;

public class Command {

    private String command;

    public Command() {

    }

    public Command(String command) {
        this.command = command;
    }

    public Position execute(Position current) {
        if (command == null) {
            return current;
        }

        Position result = current;

        if ("M".equals(command) && current.getDirection() == Direction.E) {
            result = Position.builder().x(current.getX() + 1).y(current.getY()).direction(current.getDirection()).build();
        }
        return result;
    }
}
