package com.gunni.gunnihaeba.global.security.jwt.exception;


import com.gunni.gunnihaeba.global.exception.BusinessException;
import com.gunni.gunnihaeba.global.security.jwt.exception.error.JwtErrorProperty;

public class UnsupportedTokenException extends BusinessException {
    public static final UnsupportedTokenException EXCEPTION = new UnsupportedTokenException();

    private UnsupportedTokenException() {
        super(JwtErrorProperty.UNSUPPORTED_TOKEN);
    }
}
