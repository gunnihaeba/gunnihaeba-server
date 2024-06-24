package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.dto.React;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;

import java.util.Optional;

public interface CustomReactRepo {
    CountReactRes countReact(Long noticeId,Long viewerId);
    Optional<React> findByIssueAndUser(Long noticeId, Long viewerId);
}