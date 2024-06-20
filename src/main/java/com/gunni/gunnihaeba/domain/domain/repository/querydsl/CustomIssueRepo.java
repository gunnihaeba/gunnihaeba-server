package com.gunni.gunnihaeba.domain.domain.repository.querydsl;

import com.gunni.gunnihaeba.domain.dto.response.IssueListRes;
import com.gunni.gunnihaeba.global.common.request.PageRequest;

import java.util.List;

public interface CustomIssueRepo {
    List<IssueListRes> issueListByWriter(PageRequest pageRequest);

    List<IssueListRes> issueListByWriter(Long writerId);
}
