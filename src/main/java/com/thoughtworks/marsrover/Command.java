package com.thoughtworks.marsrover;

public class Command {

    public Command() {

    }

    public Command(String command) {

    }

    public Position execute(Position current) {
        return current;
    }
}
