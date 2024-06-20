package com.gunni.gunnihaeba.domain.service;

import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import com.gunni.gunnihaeba.domain.domain.repository.ReactRepository;
import com.gunni.gunnihaeba.domain.dto.ReactVO;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;
import com.gunni.gunnihaeba.global.common.repository.UserSessionHolder;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReactService {

    private final ReactRepository reactRepository;
    private final UserSessionHolder userSessionHolder;

    public ResponseData<CountReactRes> countReact(Long noticeId) {
        return ResponseData.ok("공감,비추 조회 성공",reactRepository.countReact(noticeId,userSessionHolder.getUser().getId()));
    }

    public Response react(Long issueId, ReactType reactType){
        ReactVO react = reactRepository.findByIssueAndUser(issueId,userSessionHolder.getUser().getId());

        react.setReactType(reactType);
        reactRepository.save(react.toEntity());
        return Response.ok("공감 or 비추 성공");
    }

}
