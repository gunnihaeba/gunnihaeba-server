package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.domain.QReactEntity;
import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import com.gunni.gunnihaeba.domain.dto.React;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.gunni.gunnihaeba.domain.domain.QReactEntity.reactEntity;

@Repository
@RequiredArgsConstructor
public class CustomReactRepoImpl implements CustomReactRepo {

    private final JPAQueryFactory query;

    @Override
    public Optional<CountReactRes> countReact(Long issueId, Long viewerId) {
        QReactEntity reactEntity = QReactEntity.reactEntity;

        NumberExpression<Integer> likeCountExpression = new CaseBuilder()
                .when(reactEntity.reactType.eq(ReactType.LIKE)).then(1)
                .otherwise(0).sum();

        NumberExpression<Integer> hateCountExpression = new CaseBuilder()
                .when(reactEntity.reactType.eq(ReactType.HATE)).then(1)
                .otherwise(0).sum();

        return Optional.ofNullable(query.select(Projections.constructor(CountReactRes.class,
                        likeCountExpression,
                        hateCountExpression,
                        reactEntity.reactType))
                .from(reactEntity)
                .where(reactEntity.issueId.eq(issueId)
                        .and(reactEntity.viewerId.eq(viewerId)))
                .groupBy(reactEntity.reactType)
                .fetchOne());
    }

    @Override
    public Optional<React> findByIssueAndUser(Long issueId, Long viewerId) {
        return Optional.ofNullable(query.select(Projections.constructor(React.class,
                        reactEntity.id,
                        reactEntity.viewerId,
                        reactEntity.issueId,
                        reactEntity.reactType))
                .from(reactEntity)
                .where(reactEntity.issueId.eq(issueId))
                .where(reactEntity.viewerId.eq(viewerId))
                .fetchFirst());
    }
}
