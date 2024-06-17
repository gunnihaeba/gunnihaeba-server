package com.gunni.gunnihaeba.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInReq {
    private String userId;
    private String password;
}
