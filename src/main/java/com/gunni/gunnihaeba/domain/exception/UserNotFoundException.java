package com.gunni.gunnihaeba.domain.exception;

import com.gunni.gunnihaeba.domain.exception.error.UserErrorProperty;
import com.gunni.gunnihaeba.global.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
