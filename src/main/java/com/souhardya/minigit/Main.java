package com.souhardya.minigit;

import com.souhardya.minigit.cli.CommandParser;

public class Main {

    public static void main(String[] args) {
        CommandParser parser = new CommandParser();
        parser.parse(args);
    }
}