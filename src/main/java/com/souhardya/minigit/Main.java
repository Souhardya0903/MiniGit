package com.souhardya.minigit;

import com.souhardya.minigit.cli.CommandParser;
import com.souhardya.minigit.commands.CatFileCommand;
import com.souhardya.minigit.commands.HashObjectCommand;
import com.souhardya.minigit.commands.InitCommand;
import com.souhardya.minigit.hashing.Hasher;
import com.souhardya.minigit.hashing.SHA1Hasher;
import com.souhardya.minigit.objects.Blob;
import com.souhardya.minigit.objects.BlobFormatter;
import com.souhardya.minigit.repository.RepositoryInitializer;
import com.souhardya.minigit.storage.ObjectDatabase;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {

        BlobFormatter formatter=new BlobFormatter();
        Hasher hasher = new SHA1Hasher();
        Path repositoryRoot=Path.of(".");
        ObjectDatabase objectDatabase=new ObjectDatabase(Path.of(".").resolve(".mgit").resolve("objects"));
        HashObjectCommand hashObjectCommand=new HashObjectCommand(formatter,hasher,objectDatabase,repositoryRoot);

        CatFileCommand catFileCommand =
                new CatFileCommand(objectDatabase);

        RepositoryInitializer repositoryInitializer =
                new RepositoryInitializer();

        InitCommand initCommand =
                new InitCommand(repositoryInitializer);

        CommandParser commandParser =
                new CommandParser(initCommand,hashObjectCommand,catFileCommand);

        commandParser.parse(args);
    }
}