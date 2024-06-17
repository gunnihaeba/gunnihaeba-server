package com.gunni.gunnihaeba.domain.exception;

import com.gunni.gunnihaeba.domain.exception.error.UserErrorProperty;
import com.gunni.gunnihaeba.global.exception.BusinessException;

public class PasswordWrongException extends BusinessException {
    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException(){
        super(UserErrorProperty.PASSWORD_WRONG);
    }
}
