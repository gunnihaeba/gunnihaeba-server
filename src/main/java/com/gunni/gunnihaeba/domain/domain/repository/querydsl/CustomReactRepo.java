package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.dto.React;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;

public interface CustomReactRepo {
    CountReactRes countReact(Long noticeId,Long viewerId);
    React findByIssueAndUser(Long noticeId, Long viewerId);
}