package com.gunni.gunnihaeba.domain.dto.response;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import com.gunni.gunnihaeba.domain.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class IssueByIdRes {
    private String title;
    private String content;
    private String writer;
    private LocalDate date;

    public static IssueByIdRes of(IssueEntity issueEntity, User user){
        return IssueByIdRes.builder()
                .title(issueEntity.getTitle())
                .content(issueEntity.getContent())
                .writer(user.getName())
                .date(issueEntity.getDate()).build();
    }
}
