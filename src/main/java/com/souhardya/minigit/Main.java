package com.souhardya.minigit;

import com.souhardya.minigit.cli.CommandParser;
import com.souhardya.minigit.commands.InitCommand;
import com.souhardya.minigit.repository.RepositoryInitializer;

public class Main {

    public static void main(String[] args) throws Exception {

        RepositoryInitializer repositoryInitializer =
                new RepositoryInitializer();

        InitCommand initCommand =
                new InitCommand(repositoryInitializer);

        CommandParser commandParser =
                new CommandParser(initCommand);

        commandParser.parse(args);
    }
}