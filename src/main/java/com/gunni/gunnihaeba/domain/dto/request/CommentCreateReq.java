package com.gunni.gunnihaeba.domain.dto.request;

import com.gunni.gunnihaeba.domain.domain.CommentEntity;
import lombok.Getter;

@Getter
public class CommentCreateReq {
    private String content;

    public CommentEntity toEntity(Long issueId,Long userId){
        return CommentEntity.builder()
                .content(this.content)
                .issueId(issueId)
                .writerIdx(userId).build();
    }
}
