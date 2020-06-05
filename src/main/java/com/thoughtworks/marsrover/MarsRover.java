package com.thoughtworks.marsrover;

public class MarsRover {

    private Position current;

    public MarsRover() {
        current = new Position(0, 0, Direction.N);
    }

    public MarsRover(Position position) {
        current = position;
    }

    public Position execute(String command) {
        int index = command.indexOf("\n");
        String behaviorCommand = command;
        if (index > -1) {
            String initializedCommand = command.substring(0, index);
            current = init(initializedCommand);
            behaviorCommand = command.substring(index + 1);
        }

        Position result = current;
        for (int commandIndex = 0; commandIndex < behaviorCommand.length(); commandIndex++) {
            switch (behaviorCommand.charAt(commandIndex)) {
                case 'M':
                    result = move(result);
                    break;
                case 'L':
                    result = left(result);
                    break;
                case 'R':
                    result = right(result);
                    break;
            }
        }

        return result;
    }

    private Position init(String initializedCommand) {
        String[] position = initializedCommand.split(" ");
        return Position.builder()
                .x(Integer.parseInt(position[0]))
                .y(Integer.parseInt(position[1]))
                .direction(Direction.valueOf(position[2])).build();
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
