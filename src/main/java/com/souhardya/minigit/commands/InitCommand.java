package com.souhardya.minigit.commands;

import com.souhardya.minigit.repository.InitializationResult;
import com.souhardya.minigit.repository.InitializationStatus;
import com.souhardya.minigit.repository.RepositoryInitializer;

import java.io.IOException;
import java.nio.file.Path;

public class InitCommand {

    private final RepositoryInitializer repositoryInitializer;

    public InitCommand(RepositoryInitializer repositoryInitializer) {
        this.repositoryInitializer = repositoryInitializer;
    }

    public void execute(Path root) throws IOException {

        InitializationResult result =
                repositoryInitializer.initialize(root);

        if (result.status() == InitializationStatus.CREATED) {
            System.out.println(
                    "Initialized empty MiniGit repository in "
                            + result.repository().getRoot().toAbsolutePath()
            );
        } else {
            System.out.println(
                    "Repository already initialized at "
                            + result.repository().getRoot().toAbsolutePath()
            );
        }
    }
}