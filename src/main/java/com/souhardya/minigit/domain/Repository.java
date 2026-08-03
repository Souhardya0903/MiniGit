package com.souhardya.minigit.domain;

import java.nio.file.Path;

public class Repository {

    private final Path root;
    private final Path objectsDirectory;
    private final Path refsDirectory;
    private final Path headFile;

    public Repository(Path root) {
        this.root = root;
        this.objectsDirectory = root.resolve("objects");
        this.refsDirectory = root.resolve("refs");
        this.headFile = root.resolve("HEAD");
    }

    public Path getRoot() {
        return root;
    }

    public Path getObjectsDirectory() {
        return objectsDirectory;
    }

    public Path getRefsDirectory() {
        return refsDirectory;
    }

    public Path getHeadFile() {
        return headFile;
    }
}
