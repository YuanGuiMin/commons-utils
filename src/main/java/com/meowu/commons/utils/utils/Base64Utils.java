package com.meowu.commons.utils.utils;

import java.util.Base64;

public class Base64Utils{

    public static byte[] encode(byte[] content){
        AssertUtils.notEmpty(content, "content to encode must not be null");

        return Base64.getEncoder().encode(content);
    }

    public static byte[] decode(byte[] content){
        AssertUtils.notEmpty(content, "content to decode must not be null");

        return Base64.getDecoder().decode(content);
    }
}
