package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class MD5Exception extends MeowuRuntimeException{

    public MD5Exception(){
        super();
    }

    public MD5Exception(String message){
        super(message);
    }

    public MD5Exception(Throwable cause){
        super(cause);
    }

    public MD5Exception(String message, Throwable cause){
        super(message, cause);
    }

    public MD5Exception(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public MD5Exception(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
