package com.gunni.gunnihaeba.domain.dto.request;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import com.gunni.gunnihaeba.domain.dto.User;
import lombok.Getter;

@Getter
public class IssueCreateReq {
    private String title;
    private String content;

    public IssueEntity toEntity(User user){
        return IssueEntity.builder()
                .title(this.title)
                .content(this.content)
                .writerIdx(user.getId()).build();
    }
}
