package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class UnknownEnumException extends OAException{

    public UnknownEnumException(){
        super();
    }

    public UnknownEnumException(String message){
        super(message);
    }

    public UnknownEnumException(Throwable cause){
        super(cause);
    }

    public UnknownEnumException(String message, Throwable cause){
        super(message, cause);
    }

    public UnknownEnumException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public UnknownEnumException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
