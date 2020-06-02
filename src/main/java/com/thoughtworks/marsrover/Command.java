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

        switch (command) {
            case "M":
                result = move(current);
        }

        if ("L".equals(command) && current.getDirection() == Direction.E) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.N).build();
        }

        if ("L".equals(command) && current.getDirection() == Direction.N) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.W).build();
        }

        if ("L".equals(command) && current.getDirection() == Direction.W) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.S).build();
        }

        if ("L".equals(command) && current.getDirection() == Direction.S) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.E).build();
        }

        if ("R".equals(command) && current.getDirection() == Direction.E) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.S).build();
        }

        if ("R".equals(command) && current.getDirection() == Direction.S) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.W).build();
        }

        if ("R".equals(command) && current.getDirection() == Direction.W) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.N).build();
        }

        if ("R".equals(command) && current.getDirection() == Direction.N) {
            result = Position.builder().x(current.getX()).y(0).direction(Direction.E).build();
        }
        return result;
    }

    private Position move(Position current) {
        int x = current.getX();
        int y = current.getY();
        switch (current.getDirection()) {
            case E:
                x++;
                break;
            case W:
                x--;
                break;
            case N:
                y++;
                break;
            case S:
                y--;
        }
        return Position.builder().x(x).y(y).direction(current.getDirection()).build();
    }
}
