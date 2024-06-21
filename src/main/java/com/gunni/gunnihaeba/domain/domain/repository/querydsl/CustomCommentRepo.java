package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.dto.response.CommentListRes;

import java.util.List;

public interface CustomCommentRepo {
    List<CommentListRes> commentList(Long issueId);
}
