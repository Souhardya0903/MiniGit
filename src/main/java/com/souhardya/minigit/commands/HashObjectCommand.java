package com.souhardya.minigit.commands;

import com.souhardya.minigit.hashing.Hasher;
import com.souhardya.minigit.objects.Blob;
import com.souhardya.minigit.objects.BlobFormatter;
import com.souhardya.minigit.storage.ObjectDatabase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HashObjectCommand {

    private final BlobFormatter formatter;
    private final Hasher hasher;
    private final ObjectDatabase objectDatabase;
    private final Path repositoryRoot;

    public HashObjectCommand(BlobFormatter formatter, Hasher hasher, ObjectDatabase objectDatabase, Path repositoryRoot) {
        this.formatter = formatter;
        this.hasher = hasher;
        this.objectDatabase = objectDatabase;
        this.repositoryRoot = repositoryRoot;
    }

    public void execute(Path file) throws IOException
    {
        if(!Files.exists(repositoryRoot.resolve(".mgit"))){
            System.out.println("Not a minigit repository");
            return;
        }

        byte[] content= Files.readAllBytes(file);
        Blob blob=new Blob(content);
        byte[] formattedBlob=formatter.format(blob);
        String gitHash=hasher.hash(formattedBlob);
        objectDatabase.store(gitHash,formattedBlob);
        System.out.println(gitHash);
    }
}
