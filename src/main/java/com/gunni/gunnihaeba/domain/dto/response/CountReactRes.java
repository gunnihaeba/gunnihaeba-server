package com.gunni.gunnihaeba.domain.dto.response;

import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder @AllArgsConstructor
public class CountReactRes {
    private Integer likeCnt;
    private Integer hateCnt;
    private ReactType userReact;
}
