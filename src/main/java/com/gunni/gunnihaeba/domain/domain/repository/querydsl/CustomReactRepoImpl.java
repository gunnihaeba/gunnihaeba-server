package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.domain.QReactEntity;
import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import com.gunni.gunnihaeba.domain.dto.ReactVO;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.gunni.gunnihaeba.domain.domain.QReactEntity.reactEntity;

@Repository
@RequiredArgsConstructor
public class CustomReactRepoImpl implements CustomReactRepo {

    private final JPAQueryFactory query;

    @Override
    public CountReactRes countReact(Long issueId, Long viewerId) {
        QReactEntity reactEntity = QReactEntity.reactEntity;

        NumberExpression<Long> likeCountExpression = new CaseBuilder()
                .when(reactEntity.reactType.eq(ReactType.LIKE)).then(reactEntity.count())
                .otherwise(0L);

        NumberExpression<Long> hateCountExpression = new CaseBuilder()
                .when(reactEntity.reactType.eq(ReactType.HATE)).then(reactEntity.count())
                .otherwise(0L);

        return query.select(Projections.constructor(CountReactRes.class,
                        likeCountExpression.sum(),
                        hateCountExpression.sum(),
                        reactEntity.reactType))
                .from(reactEntity)
                .where(reactEntity.issueId.eq(issueId)
                        .and(reactEntity.viewerId.eq(viewerId)))
                .groupBy(reactEntity.reactType)
                .fetchOne();
    }

    @Override
    public ReactVO findByIssueAndUser(Long issueId, Long viewerId) {
        return query.select(Projections.constructor(ReactVO.class,
                reactEntity.id,
                reactEntity.viewerId,
                reactEntity.issueId,
                reactEntity.reactType))
                .from(reactEntity)
                .where(reactEntity.issueId.eq(issueId))
                .where(reactEntity.viewerId.eq(viewerId))
                .fetchFirst();
    }
}
