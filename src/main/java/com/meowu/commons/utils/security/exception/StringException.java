package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class StringException extends MeowuRuntimeException{

    public StringException(){
        super();
    }

    public StringException(String message){
        super(message);
    }

    public StringException(Throwable cause){
        super(cause);
    }

    public StringException(String message, Throwable cause){
        super(message, cause);
    }

    public StringException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public StringException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
