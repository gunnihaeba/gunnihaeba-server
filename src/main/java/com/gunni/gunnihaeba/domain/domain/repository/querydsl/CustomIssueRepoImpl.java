package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.dto.response.IssueListRes;
import com.gunni.gunnihaeba.global.common.request.PageRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gunni.gunnihaeba.domain.domain.QIssueEntity.issueEntity;

@Repository
@RequiredArgsConstructor
public class CustomIssueRepoImpl implements CustomIssueRepo {

    private final JPAQueryFactory query;

    @Override
    public List<IssueListRes> issueListByWriter(PageRequest request) {
        return query.select(Projections.constructor(IssueListRes.class,
                issueEntity.id,
                issueEntity.title,
                issueEntity.date)).from(issueEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .orderBy(issueEntity.id.desc())
                .fetch();
    }

    @Override
    public List<IssueListRes> issueListByWriter(Long writerId) {
        return query.select(Projections.constructor(IssueListRes.class,
                issueEntity.id,
                issueEntity.title,
                issueEntity.date)).from(issueEntity)
                .orderBy(issueEntity.id.desc())
                .fetch();
    }

}
