package com.souhardya.minigit.commands;

import com.souhardya.minigit.hashing.Hasher;
import com.souhardya.minigit.objects.Blob;
import com.souhardya.minigit.objects.BlobFormatter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readAllLines;

public class HashObjectCommand {

    private final BlobFormatter formatter;
    private final Hasher hasher;

    public HashObjectCommand(BlobFormatter formatter, Hasher hasher) {
        this.formatter = formatter;
        this.hasher = hasher;
    }

    public void execute(Path file) throws IOException
    {
        byte[] content= Files.readAllBytes(file);
        String hash=hasher.hash(content);
        Blob blob=new Blob(content,hash);
        byte[] formattedBlob=formatter.format(blob);
        String gitHash=hasher.hash(formattedBlob);
        System.out.println(gitHash);

    }
}
