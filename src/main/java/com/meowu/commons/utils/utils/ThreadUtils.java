package com.meowu.commons.utils.utils;

import com.meowu.commons.utils.security.exception.ThreadException;

import java.util.concurrent.TimeUnit;

public class ThreadUtils{

    public static void sleep(long milliseconds){
        sleep(TimeUnit.MILLISECONDS, milliseconds);
    }

    public static void sleep(TimeUnit timeUnit, long time){
        if(timeUnit == null){
            timeUnit = TimeUnit.MILLISECONDS;
        }

        try{
            Thread.sleep(timeUnit.toMillis(time));
        }catch(Exception e){
            throw new ThreadException(e.getMessage(), e);
        }
    }
}
