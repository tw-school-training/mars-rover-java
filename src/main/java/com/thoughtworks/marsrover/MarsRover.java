package com.thoughtworks.marsrover;

public class MarsRover {

    private Position current;

    private Bound bound;

    public MarsRover() {
    }

    public MarsRover(Position position) {
        current = position;
        bound = Bound.builder().build();
    }

    public MarsRover(Position position, Bound bound) {
        current = position;
        this.bound = bound;
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
        try {
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
        } catch (OutOfBoundsException e) {
        }

        current = result;
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
                if (isInMaxBound(x, bound.getMaxX())) {
                    x++;
                } else {
                    throw new OutOfBoundsException("out of max x.");
                }
                break;
            case W:
                if (isInMinBound(x, bound.getMinX())) {
                    x--;
                } else {
                    throw new OutOfBoundsException("out of min x.");
                }
                break;
            case N:
                if (isInMaxBound(y, bound.getMaxY())) {
                    y++;
                } else {
                    throw new OutOfBoundsException("out of max y.");
                }
                break;
            case S:
                if (isInMinBound(y, bound.getMinY())) {
                    y--;
                } else {
                    throw new OutOfBoundsException("out of min y.");
                }

        }
        return Position.builder().x(x).y(y).direction(current.getDirection()).build();
    }

    private boolean isInMinBound(int value, Integer min) {
        return min == null || value > min;
    }

    private boolean isInMaxBound(int value, Integer max) {
        return max == null || value < max;
    }
}
