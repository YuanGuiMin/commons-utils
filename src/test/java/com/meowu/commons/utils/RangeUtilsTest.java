package com.meowu.commons.utils;

import com.meowu.commons.utils.utils.RangeUtils;
import org.junit.Test;

public class RangeUtilsTest{

    @Test
    public void parse(){
        String header = "bytes=-432,433-599,600-";

        System.out.println(RangeUtils.parse(header));
    }
}
