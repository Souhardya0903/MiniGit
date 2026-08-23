package com.souhardya.minigit.index;

import java.nio.file.Path;

public class IndexEntry {

    private final Path filePath;
    private final String hash;


    public IndexEntry(Path filePath, String hash) {
        this.filePath = filePath;
        this.hash = hash;
    }

    public Path getFilePath() {
        return filePath;
    }

    public String getHash() {
        return hash;
    }
}
