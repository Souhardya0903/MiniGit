package com.souhardya.minigit.repository;

import com.souhardya.minigit.domain.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RepositoryInitializer {

    public InitializationResult initialize(Path root) throws IOException {

        Path repositoryRoot = root.resolve(".mgit");
        Repository repository = new Repository(repositoryRoot);

        if (Files.exists(repositoryRoot)) {
            return new InitializationResult(
                    repository,
                    InitializationStatus.ALREADY_EXISTS
            );
        }

        Files.createDirectory(repositoryRoot);
        Files.createDirectory(repository.getObjectsDirectory());
        Files.createDirectory(repository.getRefsDirectory());
        Files.createFile(repository.getHeadFile());

        return new InitializationResult(
                repository,
                InitializationStatus.CREATED
        );
    }
}