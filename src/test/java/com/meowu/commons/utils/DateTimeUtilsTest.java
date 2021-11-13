package com.meowu.commons.utils;

import com.meowu.commons.utils.utils.DateTimeUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class DateTimeUtilsTest{

    @Test
    public void distanceDay(){
        Long distanceDay = LocalDate.parse("2021-09-01").toEpochDay() - LocalDate.parse("2021-08-20").toEpochDay();

        System.out.println(distanceDay);
    }

    @Test
    public void toDate(){
        Date   date    = new Date();
        String locale  = "UTC";
        String convert = "UTC";

        System.out.println(date);
        System.out.println(DateTimeUtils.toDate(date, locale, convert));
    }
}
