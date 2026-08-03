package com.souhardya.minigit.cli;

import com.souhardya.minigit.commands.InitCommand;

import java.io.IOException;
import java.nio.file.Path;

public class CommandParser {

    private final InitCommand initCommand;

    public CommandParser(InitCommand initCommand) {
        this.initCommand = initCommand;
    }

    public void parse(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("No command provided.");
            return;
        }

        switch (args[0]) {

            case "init":
                initCommand.execute(Path.of("."));
                break;

            default:
                System.out.println("Unknown command: " + args[0]);
        }
    }
}