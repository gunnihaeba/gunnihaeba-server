package com.gunni.gunnihaeba.domain.dto.request;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import com.gunni.gunnihaeba.domain.dto.UserVO;
import lombok.Getter;
import lombok.Setter;

@Getter
public class IssueCreateReq {
    private String title;
    private String content;

    public IssueEntity toEntity(UserVO user){
        return IssueEntity.builder()
                .title(this.title)
                .content(this.content)
                .writerIdx(user.getId()).build();
    }
}
