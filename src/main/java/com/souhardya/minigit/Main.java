package com.souhardya.minigit;

import com.souhardya.minigit.cli.CommandParser;
import com.souhardya.minigit.commands.CatFileCommand;
import com.souhardya.minigit.commands.HashObjectCommand;
import com.souhardya.minigit.commands.InitCommand;
import com.souhardya.minigit.hashing.Hasher;
import com.souhardya.minigit.hashing.SHA1Hasher;
import com.souhardya.minigit.index.Index;
import com.souhardya.minigit.index.IndexEntry;
import com.souhardya.minigit.objects.BlobFormatter;
import com.souhardya.minigit.repository.RepositoryInitializer;
import com.souhardya.minigit.storage.ObjectDatabase;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {

        BlobFormatter formatter=new BlobFormatter();
        Hasher hasher = new SHA1Hasher();
        Path repositoryRoot=Path.of(".");
        ObjectDatabase objectDatabase=new ObjectDatabase(Path.of(".").resolve(".mgit").resolve("objects"));
        HashObjectCommand hashObjectCommand=new HashObjectCommand(formatter,hasher,objectDatabase,repositoryRoot);

        Index index = new Index(
                Path.of(".").resolve(".mgit").resolve("index")
        );

        index.add(new IndexEntry(
                Path.of("hello.txt"),
                "5e1c309dae7f45e0f39b1bf3ac3cd9db12e7d689"
        ));

        index.save();

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