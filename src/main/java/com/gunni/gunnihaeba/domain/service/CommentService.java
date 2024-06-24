package com.gunni.gunnihaeba.domain.service;

import com.gunni.gunnihaeba.domain.domain.repository.CommentRepository;
import com.gunni.gunnihaeba.domain.domain.repository.IssueRepository;
import com.gunni.gunnihaeba.domain.dto.request.CommentCreateReq;
import com.gunni.gunnihaeba.domain.dto.response.CommentListRes;
import com.gunni.gunnihaeba.domain.exception.issue.IssueNotFoundException;
import com.gunni.gunnihaeba.global.common.repository.UserSessionHolder;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final IssueRepository issueRepository;
    private final CommentRepository commentRepository;
    private final UserSessionHolder userSessionHolder;

    public Response createComment(Long issueId,CommentCreateReq req) {
        if(!issueRepository.existsById(issueId))
            throw IssueNotFoundException.EXCEPTION;
        commentRepository.save(req.toEntity(issueId,userSessionHolder.getUser().getId()));
        return Response.ok("댓글 생성 성공");
    }

    public ResponseData<List<CommentListRes>> commentList(Long issueId){
        if(!issueRepository.existsById(issueId))
            throw IssueNotFoundException.EXCEPTION;
        return ResponseData.ok("댓글 조회 성공",commentRepository.commentList(issueId));
    }

}
