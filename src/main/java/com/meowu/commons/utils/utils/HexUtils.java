package com.meowu.commons.utils.utils;

public class HexUtils{

    public static String toString(byte[] content){
        AssertUtils.notEmpty(content, "content to string must not be null");

        //result
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < content.length; i++){
            String hex = Integer.toHexString(content[i] & 0xFF);

            if(hex.length() == 1){
                hex = '0' + hex;
            }

            sb.append(hex);
        }

        return sb.toString();
    }

    public static byte[] toBytes(String content){
        AssertUtils.hasText(content, "content to byte must not be null");

        int    length = content.length() / 2;
        byte[] result = new byte[length];

        for(int i = 0; i < length; i++){
            int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
            int low  = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);

            result[i] = (byte) (high * 16 + low);
        }

        return result;
    }
}
