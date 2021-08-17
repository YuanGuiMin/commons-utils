package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class DataAccessException extends MeowuRuntimeException{

    public DataAccessException(){
        super();
    }

    public DataAccessException(String message){
        super(message);
    }

    public DataAccessException(Throwable cause){
        super(cause);
    }

    public DataAccessException(String message, Throwable cause){
        super(message, cause);
    }

    public DataAccessException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public DataAccessException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
