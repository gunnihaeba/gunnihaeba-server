package com.gunni.gunnihaeba.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder @AllArgsConstructor
public class IssueListRes {
    private Long id;
    private String title;
    private LocalDate date;
}
