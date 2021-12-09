package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class RangeParserException extends MeowuRuntimeException{

    public RangeParserException(){
        super();
    }

    public RangeParserException(String message){
        super(message);
    }

    public RangeParserException(Throwable cause){
        super(cause);
    }

    public RangeParserException(String message, Throwable cause){
        super(message, cause);
    }

    public RangeParserException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public RangeParserException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
