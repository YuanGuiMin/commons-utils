package com.meowu.commons.utils;

import com.meowu.commons.utils.utils.RadixUtils;
import org.junit.Test;

public class RadixUtilsTest{

    @Test
    public void convert(){
        long i = 3866344621642612736L;

        System.out.println(RadixUtils.toString(i, 32));
        System.out.println(Long.toString(i, 32));
    }
}
