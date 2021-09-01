package com.meowu.commons.utils.utils;

import org.junit.Test;

import java.time.LocalDate;

public class DateTimeUtilsTest{

    @Test
    public void distanceDay(){
        Long distanceDay = LocalDate.parse("2021-09-01").toEpochDay() - LocalDate.parse("2021-08-20").toEpochDay();

        System.out.println(distanceDay);
    }
}
