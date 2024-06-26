package com.gunni.gunnihaeba.domain.service;

import com.gunni.gunnihaeba.domain.domain.ReactEntity;
import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import com.gunni.gunnihaeba.domain.domain.repository.IssueRepository;
import com.gunni.gunnihaeba.domain.domain.repository.ReactRepository;
import com.gunni.gunnihaeba.domain.dto.React;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;
import com.gunni.gunnihaeba.domain.exception.issue.IssueNotFoundException;
import com.gunni.gunnihaeba.global.common.repository.UserSessionHolder;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.gunni.gunnihaeba.domain.domain.enums.ReactType.NON;

@Service
@RequiredArgsConstructor
public class ReactService {

    private final IssueRepository issueRepository;
    private final ReactRepository reactRepository;
    private final UserSessionHolder userSessionHolder;

    public ResponseData<CountReactRes> countReact(Long issueId) {
        if(!issueRepository.existsById(issueId))
            throw IssueNotFoundException.EXCEPTION;

        Optional<CountReactRes> countReactRes = reactRepository.countReact(issueId,userSessionHolder.getUser().getId());

        return countReactRes.map(reactRes -> ResponseData.ok("공감,비추 조회 성공", reactRes)).orElseGet(() -> ResponseData.ok("공감,비추 조회 성공", CountReactRes.builder()
                .likeCnt(0)
                .hateCnt(0)
                .userReact(NON).build()));


    }

    public Response react(Long issueId, ReactType reactType){
        if(!issueRepository.existsById(issueId))
            throw IssueNotFoundException.EXCEPTION;

        Long viewerId = userSessionHolder.getUser().getId();
        Optional<React> react = reactRepository.findByIssueAndUser(issueId,viewerId);

        if(react.isPresent()){
            React reactObj = react.get();
            reactObj.setReactType(reactType);
            reactRepository.save(reactObj.toEntity());
        }
        else {
            reactRepository.save(ReactEntity.builder()
                    .viewerId(viewerId)
                    .issueId(issueId)
                    .reactType(reactType).build());
        }
        return Response.ok("공감 or 비추 or 반응취소 성공");
    }

}