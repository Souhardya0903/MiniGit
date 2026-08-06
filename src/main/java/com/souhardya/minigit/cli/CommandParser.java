package com.souhardya.minigit.cli;

import com.souhardya.minigit.commands.HashObjectCommand;
import com.souhardya.minigit.commands.InitCommand;

import java.io.IOException;
import java.nio.file.Path;

public class CommandParser {

    private final InitCommand initCommand;
    private final HashObjectCommand hashObjectCommand;

    public CommandParser(InitCommand initCommand, HashObjectCommand hashObjectCommand) {
        this.initCommand = initCommand;
        this.hashObjectCommand = hashObjectCommand;
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

            case "hash-object":
                if(args.length>=2) {
                    hashObjectCommand.execute(Path.of(args[1]));
                }
                break;

            default:
                System.out.println("Unknown command: " + args[0]);
        }
    }
}