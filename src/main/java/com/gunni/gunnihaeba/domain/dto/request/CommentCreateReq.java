package com.gunni.gunnihaeba.domain.dto.request;

import com.gunni.gunnihaeba.domain.domain.CommentEntity;
import lombok.Getter;

@Getter
public class CommentCreateReq {
    private String content;
    private Long issueId;

    public CommentEntity toEntity(Long userId){
        return CommentEntity.builder()
                .content(this.content)
                .issueId(this.issueId)
                .writerIdx(userId).build();
    }
}
