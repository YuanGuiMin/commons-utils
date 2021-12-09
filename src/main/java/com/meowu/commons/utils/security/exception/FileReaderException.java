package com.meowu.commons.utils.security.exception;

import java.text.MessageFormat;

public class FileReaderException extends MeowuRuntimeException{

    public FileReaderException(){
        super();
    }

    public FileReaderException(String message){
        super(message);
    }

    public FileReaderException(Throwable cause){
        super(cause);
    }

    public FileReaderException(String message, Throwable cause){
        super(message, cause);
    }

    public FileReaderException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public FileReaderException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
