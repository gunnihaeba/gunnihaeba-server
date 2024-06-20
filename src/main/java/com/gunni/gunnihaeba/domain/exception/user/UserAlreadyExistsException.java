package com.gunni.gunnihaeba.domain.exception.user;


import com.gunni.gunnihaeba.domain.exception.user.error.UserErrorProperty;
import com.gunni.gunnihaeba.global.exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {
    public static final UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException(){
        super(UserErrorProperty.USER_CONFLICT);
    }

}
