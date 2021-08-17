package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class Base64Exception extends MeowuRuntimeException{

    public Base64Exception(){
        super();
    }

    public Base64Exception(String message){
        super(message);
    }

    public Base64Exception(Throwable cause){
        super(cause);
    }

    public Base64Exception(String message, Throwable cause){
        super(message, cause);
    }

    public Base64Exception(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public Base64Exception(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
