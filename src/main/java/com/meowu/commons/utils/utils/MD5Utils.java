package com.meowu.commons.utils.utils;

import com.meowu.commons.utils.security.exception.MD5Exception;

import java.io.InputStream;
import java.security.MessageDigest;

public class MD5Utils{

    private static final String ALGORITHM   = "md5";
    private static final int    BUFFER_SIZE = 8192;

    public static byte[] encode(byte[] content){
        AssertUtils.notEmpty(content, "content to encode must not be null");

        try{
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);

            return digest.digest(content);
        }catch(Exception e){
            throw new MD5Exception(e.getMessage(), e);
        }
    }

    public static byte[] encode(InputStream stream){
        AssertUtils.notNull(stream, "stream to encode must not be null");

        try{
            byte[]        buffer = new byte[BUFFER_SIZE];
            int           length = 0;
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);

            while((length = stream.read(buffer)) != -1){
                digest.update(buffer, 0, length);
            }

            return digest.digest();
        }catch(Exception e){
            throw new MD5Exception(e.getMessage(), e);
        }
    }
}
