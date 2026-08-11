package com.souhardya.minigit.storage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ObjectDatabase {

    private final Path objectsDirectory;

    public ObjectDatabase(Path objectsDirectory) {
        this.objectsDirectory = objectsDirectory;
    }

    public void store(String hash, byte[] content) throws IOException {
        Path objectDirectory = objectsDirectory.resolve(hash.substring(0, 2));
        Path objectFile = objectDirectory.resolve(hash.substring(2));
        Files.createDirectories(objectDirectory);
        byte[] compressedContent=compress(content);
        Files.write(objectFile,compressedContent);
    }

    public byte[] compress(byte[] content)
    {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Deflater deflater=new Deflater();
        deflater.setInput(content);
        deflater.finish();

        byte[] buffer=new byte[1024];
        while(!deflater.finished()) {
            int compressedLength = deflater.deflate(buffer);
            output.write(buffer, 0, compressedLength);
        }
        return output.toByteArray();
    }

    public byte[] read(String hash) throws IOException, DataFormatException {

        Path objectDirectory = objectsDirectory.resolve(hash.substring(0,2));
        Path objectFile = objectDirectory.resolve(hash.substring(2));
        byte[] compressedContent = Files.readAllBytes(objectFile);

        Inflater inflater=new Inflater();
        inflater.setInput(compressedContent);

        byte[] buffer=new byte[1024];
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while(!inflater.finished())
        {
            int decompressedLength = inflater.inflate(buffer);
            output.write(buffer,0,decompressedLength);
        }
        inflater.end();
        return output.toByteArray();
    }
}
