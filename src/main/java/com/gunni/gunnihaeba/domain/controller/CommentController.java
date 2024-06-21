package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.dto.request.CommentCreateReq;
import com.gunni.gunnihaeba.domain.dto.response.CommentListRes;
import com.gunni.gunnihaeba.domain.service.CommentService;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@RequiredArgsConstructor
@Tag(name = "댓글", description = "comment API")
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    @Operation(summary = "댓글 생성", description = "댓글 생성 (authorized)")
    public Response createComment(
            @RequestBody CommentCreateReq commentCreateReq
    ) {
        return commentService.createComment(commentCreateReq);
    }

    @GetMapping("/{id}")
    @Operation(summary = "댓글 생성", description = "댓글 생성 (authorized)")
    public ResponseData<List<CommentListRes>> commentList(
            @PathVariable Long id
    ) {
        return commentService.commentList(id);
    }

}
