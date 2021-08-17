package com.meowu.commons.utils.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

public class AssertUtils{

    public static void notNull(Object object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean expressions, String message){
        if(!expressions){
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasText(String str, String message){
        if(StringUtils.isBlank(str)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection collection, String message){
        if(collection == null || collection.isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Map map, String message){
        if(map == null || map.isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void notEmpty(T[] array, String message){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(char[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(byte[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(short[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(int[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(long[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(float[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(double[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(boolean[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }
}
