package com.gunni.gunnihaeba.global.exception;

import com.gunni.gunnihaeba.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorProperty error;
}
