package com.gunni.gunnihaeba.domain.dto.response;

import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder @AllArgsConstructor
public class CountReactRes {
    private Long likeCnt;
    private Long hateCnt;
    private ReactType userReact;
}
