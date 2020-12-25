package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class AccountExistsException extends OAException{

    public AccountExistsException(){
        super();
    }

    public AccountExistsException(String message){
        super(message);
    }

    public AccountExistsException(Throwable cause){
        super(cause);
    }

    public AccountExistsException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountExistsException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public AccountExistsException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
