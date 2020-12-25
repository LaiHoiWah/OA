package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class AccountAbnormalException extends OAException{

    public AccountAbnormalException(){
        super();
    }

    public AccountAbnormalException(String message){
        super(message);
    }

    public AccountAbnormalException(Throwable cause){
        super(cause);
    }

    public AccountAbnormalException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountAbnormalException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public AccountAbnormalException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
