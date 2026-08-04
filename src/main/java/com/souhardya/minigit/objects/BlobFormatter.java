package com.souhardya.minigit.objects;

import java.nio.charset.StandardCharsets;

public class BlobFormatter {

    public byte[] format(Blob blob)
    {
        String header="blob "+blob.getSize()+"\0";
        byte[] headerBytes=header.getBytes(StandardCharsets.UTF_8);
        byte[] formattedBlob=new byte[blob.getContent().length+headerBytes.length];

        //copying header to formattedBlob
        System.arraycopy(headerBytes,0,formattedBlob,
                0,headerBytes.length);

        //copying content to formattedBlob
        System.arraycopy(blob.getContent(),0,formattedBlob,
                headerBytes.length,blob.getContent().length);

        return formattedBlob;
    }
}
