package com.souhardya.minigit.commands;

import com.souhardya.minigit.storage.ObjectDatabase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;

public class CatFileCommand {

    private final ObjectDatabase objectDatabase;

    public CatFileCommand(ObjectDatabase objectDatabase) {
        this.objectDatabase = objectDatabase;
    }

    public void execute(String hash)throws IOException, DataFormatException
    {
        byte[] object=objectDatabase.read(hash);
        System.out.println(new String(object, StandardCharsets.UTF_8).replace("\0","\\0"));
    }
}
