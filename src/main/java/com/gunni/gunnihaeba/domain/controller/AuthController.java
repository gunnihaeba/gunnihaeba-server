package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.dto.request.SignInReq;
import com.gunni.gunnihaeba.domain.dto.request.SignUpReq;
import com.gunni.gunnihaeba.domain.dto.request.TokenRefreshReq;
import com.gunni.gunnihaeba.domain.dto.response.SignInRes;
import com.gunni.gunnihaeba.domain.dto.response.TokenRefreshRes;
import com.gunni.gunnihaeba.domain.service.AuthService;
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
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void studentSignUp(
            @RequestBody SignUpReq req
    ){
        authService.signUp(req);
    }

    @PostMapping("/sign-in")
    public SignInRes signIn(
            @Validated @RequestBody SignInReq req
    ) {
        return authService.signIn(req);
    }

    @GetMapping("/refresh")
    public TokenRefreshRes refresh(
            @Validated @RequestBody TokenRefreshReq req
    ) {
        return authService.refresh(req);
    }

}
