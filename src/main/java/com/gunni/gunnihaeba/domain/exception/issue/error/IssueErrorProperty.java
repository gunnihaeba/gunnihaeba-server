package com.gunni.gunnihaeba.domain.exception.issue.error;

import com.gunni.gunnihaeba.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum IssueErrorProperty implements ErrorProperty {
    ISSUE_NOT_FOUND(HttpStatus.NOT_FOUND, "게시물을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
