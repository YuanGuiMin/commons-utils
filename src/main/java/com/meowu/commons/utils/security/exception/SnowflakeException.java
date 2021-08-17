package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class SnowflakeException extends MeowuRuntimeException{

    public SnowflakeException(){
        super();
    }

    public SnowflakeException(String message){
        super(message);
    }

    public SnowflakeException(Throwable cause){
        super(cause);
    }

    public SnowflakeException(String message, Throwable cause){
        super(message, cause);
    }

    public SnowflakeException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public SnowflakeException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
