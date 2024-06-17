package com.gunni.gunnihaeba.domain.service;

import com.gunni.gunnihaeba.domain.domain.UserEntity;
import com.gunni.gunnihaeba.domain.domain.repository.UserRepository;
import com.gunni.gunnihaeba.domain.dto.request.SignInReq;
import com.gunni.gunnihaeba.domain.dto.request.SignUpReq;
import com.gunni.gunnihaeba.domain.dto.request.TokenRefreshReq;
import com.gunni.gunnihaeba.domain.dto.response.SignInRes;
import com.gunni.gunnihaeba.domain.dto.response.TokenRefreshRes;
import com.gunni.gunnihaeba.domain.exception.PasswordWrongException;
import com.gunni.gunnihaeba.domain.exception.UserAlreadyExistsException;
import com.gunni.gunnihaeba.domain.exception.UserNotFoundException;
import com.gunni.gunnihaeba.global.security.jwt.JwtExtractor;
import com.gunni.gunnihaeba.global.security.jwt.JwtProvider;
import com.gunni.gunnihaeba.global.security.jwt.enums.JwtType;
import com.gunni.gunnihaeba.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtExtractor jwtExtractor;

    /** 학생 회원가입 */
    public void signUp(SignUpReq req){
        existsById(req.getUserId()); // id 중복 체크

        req.setPassword(encoder.encode(req.getPassword())); // password 인코딩
        userRepository.save(req.toEntity()); // 저장
    }

    public SignInRes signIn(SignInReq req){
        UserEntity user = userRepository.findByUserId(req.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw PasswordWrongException.EXCEPTION;

        return SignInRes.builder()
                .accessToken(jwtProvider.generateAccessToken(user.getUserId()))
                .refreshToken(jwtProvider.generateRefreshToken(user.getUserId()))
                .build();
    }

    public TokenRefreshRes refresh(TokenRefreshReq req){
        Jws<Claims> claims = jwtExtractor.getClaims(jwtExtractor.extractToken(req.getToken())); // 토큰 정보 발췌

        if (jwtExtractor.isWrongType(claims, JwtType.REFRESH)) // refresh가 아니면
            throw TokenTypeException.EXCEPTION;

        return TokenRefreshRes.builder()
                .accessToken(jwtProvider.generateAccessToken(claims.getBody().getSubject())).build();
    }

    private void existsById(String userId){
        if(userRepository.existsByUserId(userId))
            throw UserAlreadyExistsException.EXCEPTION;
    }

}
