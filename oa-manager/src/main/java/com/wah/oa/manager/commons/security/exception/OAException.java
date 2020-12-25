package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class OAException extends RuntimeException{

    public OAException(){
        super();
    }

    public OAException(String message){
        super(message);
    }

    public OAException(Throwable cause){
        super(cause);
    }

    public OAException(String message, Throwable cause){
        super(message, cause);
    }

    public OAException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public OAException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
