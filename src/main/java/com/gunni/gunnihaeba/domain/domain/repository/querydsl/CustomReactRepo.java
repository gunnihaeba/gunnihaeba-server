package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.dto.ReactVO;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;

public interface CustomReactRepo {
    CountReactRes countReact(Long noticeId,Long viewerId);
    ReactVO findByIssueAndUser(Long noticeId, Long viewerId);
}