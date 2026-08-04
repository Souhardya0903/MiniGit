package com.souhardya.minigit;

import com.souhardya.minigit.cli.CommandParser;
import com.souhardya.minigit.commands.InitCommand;
import com.souhardya.minigit.hashing.Hasher;
import com.souhardya.minigit.hashing.SHA1Hasher;
import com.souhardya.minigit.objects.Blob;
import com.souhardya.minigit.objects.BlobFormatter;
import com.souhardya.minigit.repository.RepositoryInitializer;

public class Main {

    public static void main(String[] args) throws Exception {

        Blob blob=new Blob("Hello World".getBytes(),"SHA1");
        BlobFormatter formatter=new BlobFormatter();
        Hasher hasher = new SHA1Hasher();
        byte[] formattedBlob= formatter.format(blob);
        String hash= hasher.hash(formattedBlob);

        System.out.println(hash);

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