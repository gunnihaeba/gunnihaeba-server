package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.dto.request.SignInReq;
import com.gunni.gunnihaeba.domain.dto.request.SignUpReq;
import com.gunni.gunnihaeba.domain.dto.request.TokenRefreshReq;
import com.gunni.gunnihaeba.domain.dto.response.SignInRes;
import com.gunni.gunnihaeba.domain.dto.response.TokenRefreshRes;
import com.gunni.gunnihaeba.domain.service.AuthService;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "AUTH", description = "auth API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "회원가입", description = "회원가입입니다. (unauthenticated)")
    public Response studentSignUp(
            @RequestBody SignUpReq req
    ){
        return authService.signUp(req);
    }

    @PostMapping("/sign-in")
    @Operation(summary = "로그인", description = "로그인 합니다. (unauthenticated)")
    public ResponseData<SignInRes> signIn(
            @Validated @RequestBody SignInReq req
    ) {
        return authService.signIn(req);
    }

    @GetMapping("/refresh")
    @Operation(summary = "토큰 재발급", description = "access 토큰 재발급, 리프레시 토큰 전달")
    public ResponseData<TokenRefreshRes> refresh(
            @Validated @RequestBody TokenRefreshReq req
    ) {
        return authService.refresh(req);
    }

}
