package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class AccountLockedException extends OAException{

    public AccountLockedException(){
        super();
    }

    public AccountLockedException(String message){
        super(message);
    }

    public AccountLockedException(Throwable cause){
        super(cause);
    }

    public AccountLockedException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountLockedException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public AccountLockedException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
