package com.souhardya.minigit.objects;

public class Blob {

    private final byte[] content;
    private final long size;

    public Blob(byte[] content) {
        this.content = content;
        this.size = content.length;
    }

    public long getSize() {
        return size;
    }

    public byte[] getContent() {
        return content;
    }
}
