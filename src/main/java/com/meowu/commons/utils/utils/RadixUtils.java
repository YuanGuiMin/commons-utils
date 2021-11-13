package com.meowu.commons.utils.utils;

public class RadixUtils{

    private final static char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'a', 'b', 'c', 'd',
        'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y',
        'z', 'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private final static int MIN_RADIX = 2;
    private final static int MAX_RADIX = 62;

    public static String toString(long i, int radix){
        if(radix < MIN_RADIX || radix > MAX_RADIX){
            radix = 10;
        }

        if(radix == 10){
            return Long.toString(i);
        }

        boolean negative = (i < 0);
        if(!negative){
            i = -i;
        }

        // result
        StringBuilder sb = new StringBuilder();

        // calculate
        while(i <= -radix){
            sb.append(DIGITS[(int) (-(i% radix))]);
            i = i / radix;
        }

        sb.append(DIGITS[(int) (-i)]);

        if(negative){
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
