package com.gunni.gunnihaeba.global.security.jwt.exception;


import com.gunni.gunnihaeba.global.exception.BusinessException;
import com.gunni.gunnihaeba.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends BusinessException {
    public static final ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}
