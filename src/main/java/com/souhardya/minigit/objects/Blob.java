package com.souhardya.minigit.objects;

public class Blob {

    private final byte[] content;
    private final long size;
    private final String hash;

    public Blob(byte[] content, String hash) {
        this.content = content;
        this.size = content.length;
        this.hash = hash;
    }

    public long getSize() {
        return size;
    }

    public byte[] getContent() {
        return content;
    }
}
