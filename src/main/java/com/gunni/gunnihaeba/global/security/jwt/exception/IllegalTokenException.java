package com.gunni.gunnihaeba.global.security.jwt.exception;


import com.gunni.gunnihaeba.global.exception.BusinessException;
import com.gunni.gunnihaeba.global.security.jwt.exception.error.JwtErrorProperty;

public class IllegalTokenException extends BusinessException {
    public static final IllegalTokenException EXCEPTION = new IllegalTokenException();

    private IllegalTokenException() {
        super(JwtErrorProperty.ILLEGAL_TOKEN);
    }
}
