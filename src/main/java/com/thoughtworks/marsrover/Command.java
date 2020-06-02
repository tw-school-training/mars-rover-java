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
                break;
            case "L":
                result = left(current);
                break;
            case "R":
                result = right(current);
        }
        return result;
    }

    private Position right(Position current) {
        Direction newDirection = current.getDirection();
        switch (current.getDirection()) {
            case E:
                newDirection = Direction.S;
                break;
            case S:
                newDirection = Direction.W;
                break;
            case W:
                newDirection = Direction.N;
                break;
            case N:
                newDirection = Direction.E;
        }
        return Position.builder().x(current.getX()).y(current.getY()).direction(newDirection).build();
    }

    private Position left(Position current) {
        Direction newDirection = current.getDirection();
        switch (current.getDirection()) {
            case E:
                newDirection = Direction.N;
                break;
            case N:
                newDirection = Direction.W;
                break;
            case W:
                newDirection = Direction.S;
                break;
            case S:
                newDirection = Direction.E;
        }
        return Position.builder().x(current.getX()).y(current.getY()).direction(newDirection).build();
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
