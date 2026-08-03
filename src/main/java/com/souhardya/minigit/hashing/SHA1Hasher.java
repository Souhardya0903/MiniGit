package com.souhardya.minigit.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class SHA1Hasher implements Hasher {

    @Override
    public String hash(byte[] content){

        try
        {
            MessageDigest messageDigest=MessageDigest.getInstance("SHA1");
            byte[] hashBytes=messageDigest.digest(content);
            return HexFormat.of().formatHex(hashBytes);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("SHA-1 algorithm not available",e);
        }
    }
}
