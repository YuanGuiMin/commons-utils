package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class RSAException extends MeowuRuntimeException{

    public RSAException(){
        super();
    }

    public RSAException(String message){
        super(message);
    }

    public RSAException(Throwable cause){
        super(cause);
    }

    public RSAException(String message, Throwable cause){
        super(message, cause);
    }

    public RSAException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public RSAException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
