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

        if ("M".equals(command) && current.getDirection() == Direction.W) {
            result = Position.builder().x(current.getX() - 1).y(current.getY()).direction(current.getDirection()).build();
        }

        if ("M".equals(command) && current.getDirection() == Direction.N) {
            result = Position.builder().x(current.getX()).y(current.getY() + 1).direction(current.getDirection()).build();
        }

        if ("M".equals(command) && current.getDirection() == Direction.S) {
            result = Position.builder().x(current.getX()).y(current.getY() - 1).direction(current.getDirection()).build();
        }

        if ("L".equals(command) && current.getDirection() == Direction.E) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.N).build();
        }
        return result;
    }
}
