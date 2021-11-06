package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class IPException extends MeowuRuntimeException{

    public IPException(){
        super();
    }

    public IPException(String message){
        super(message);
    }

    public IPException(Throwable cause){
        super(cause);
    }

    public IPException(String message, Throwable cause){
        super(message, cause);
    }

    public IPException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public IPException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
