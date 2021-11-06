package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class ThreadException extends MeowuRuntimeException{

    public ThreadException(){
        super();
    }

    public ThreadException(String message){
        super(message);
    }

    public ThreadException(Throwable cause){
        super(cause);
    }

    public ThreadException(String message, Throwable cause){
        super(message, cause);
    }

    public ThreadException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public ThreadException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
