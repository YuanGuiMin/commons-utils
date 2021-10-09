package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class HostParserException extends MeowuRuntimeException{

    public HostParserException(){
        super();
    }

    public HostParserException(String message){
        super(message);
    }

    public HostParserException(Throwable cause){
        super(cause);
    }

    public HostParserException(String message, Throwable cause){
        super(message, cause);
    }

    public HostParserException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public HostParserException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
