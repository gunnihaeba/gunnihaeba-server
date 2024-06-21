package com.gunni.gunnihaeba.domain.service;

import com.gunni.gunnihaeba.domain.domain.repository.CommentRepository;
import com.gunni.gunnihaeba.domain.dto.request.CommentCreateReq;
import com.gunni.gunnihaeba.domain.dto.response.CommentListRes;
import com.gunni.gunnihaeba.global.common.repository.UserSessionHolder;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserSessionHolder userSessionHolder;

    public Response createComment(CommentCreateReq req) {
        commentRepository.save(req.toEntity(userSessionHolder.getUser().getId()));
        return Response.ok("댓글 생성 성공");
    }

    public ResponseData<List<CommentListRes>> commentList(Long issueId){
        return ResponseData.ok("댓글 조회 성공",commentRepository.commentList(issueId));
    }


}
