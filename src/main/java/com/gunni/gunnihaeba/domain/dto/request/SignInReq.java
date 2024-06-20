package com.gunni.gunnihaeba.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SignInReq {
    private String userId;
    private String password;
}
