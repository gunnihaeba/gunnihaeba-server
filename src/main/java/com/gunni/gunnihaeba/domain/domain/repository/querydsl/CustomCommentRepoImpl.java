package com.gunni.gunnihaeba.domain.domain.repository.querydsl;


import com.gunni.gunnihaeba.domain.dto.response.CommentListRes;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gunni.gunnihaeba.domain.domain.QCommentEntity.commentEntity;
import static com.gunni.gunnihaeba.domain.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class CustomCommentRepoImpl implements CustomCommentRepo{

    private final JPAQueryFactory query;

    @Override
    public List<CommentListRes> commentList(Long issueId) {
        return query.select(Projections.constructor(CommentListRes.class,
                userEntity.name,
                commentEntity.content,
                commentEntity.date))
                .from(commentEntity)
                .orderBy(commentEntity.id.desc())
                .fetch();
    }
}
