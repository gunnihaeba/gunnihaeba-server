package com.gunni.gunnihaeba.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class CommentListRes {
    private String writer;
    private String content;
    private LocalDate date;
}
