package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class AccountFrozenException extends OAException{

    public AccountFrozenException(){
        super();
    }

    public AccountFrozenException(String message){
        super(message);
    }

    public AccountFrozenException(Throwable cause){
        super(cause);
    }

    public AccountFrozenException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountFrozenException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public AccountFrozenException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
