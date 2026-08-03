package com.souhardya.minigit;

import com.souhardya.minigit.cli.CommandParser;
import com.souhardya.minigit.commands.InitCommand;
import com.souhardya.minigit.hashing.Hasher;
import com.souhardya.minigit.hashing.SHA1Hasher;
import com.souhardya.minigit.repository.RepositoryInitializer;

public class Main {

    public static void main(String[] args) throws Exception {

        Hasher hasher = new SHA1Hasher();

        System.out.println(
                hasher.hash("Hello World".getBytes())
        );

        //temporary

        RepositoryInitializer repositoryInitializer =
                new RepositoryInitializer();

        InitCommand initCommand =
                new InitCommand(repositoryInitializer);

        CommandParser commandParser =
                new CommandParser(initCommand);

        commandParser.parse(args);
    }
}