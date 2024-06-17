package com.gunni.gunnihaeba.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SignInRes {
    private String accessToken;
    private String refreshToken;
}
