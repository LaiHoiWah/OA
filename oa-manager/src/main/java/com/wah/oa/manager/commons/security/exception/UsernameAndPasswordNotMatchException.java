package com.wah.oa.manager.commons.security.exception;

import java.text.MessageFormat;

public class UsernameAndPasswordNotMatchException extends OAException{

    public UsernameAndPasswordNotMatchException(){
        super();
    }

    public UsernameAndPasswordNotMatchException(String message){
        super(message);
    }

    public UsernameAndPasswordNotMatchException(Throwable cause){
        super(cause);
    }

    public UsernameAndPasswordNotMatchException(String message, Throwable cause){
        super(message, cause);
    }

    public UsernameAndPasswordNotMatchException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public UsernameAndPasswordNotMatchException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
