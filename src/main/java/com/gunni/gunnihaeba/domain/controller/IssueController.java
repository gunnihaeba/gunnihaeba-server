package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.dto.request.IssueCreateReq;
import com.gunni.gunnihaeba.domain.dto.request.IssueUpdateReq;
import com.gunni.gunnihaeba.domain.dto.response.IssueByIdRes;
import com.gunni.gunnihaeba.domain.dto.response.IssueListRes;
import com.gunni.gunnihaeba.domain.service.IssueService;
import com.gunni.gunnihaeba.global.common.request.PageRequest;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/issue")
@RequiredArgsConstructor
@Tag(name = "건의", description = "issue API")
public class IssueController { // 이름 변경

    private final IssueService issueService;

    @PostMapping()
    @Operation(summary = "건의 생성", description = "건의 생성 (authorized)")
    public Response createIssue(@RequestBody IssueCreateReq createIssueReq){
        return issueService.createIssue(createIssueReq);
    }

    @GetMapping("/list")
    @Operation(summary = "건의 리스트", description = "건의 리스트 조회 (authorized)")
    public ResponseData<List<IssueListRes>> issueList(
            @RequestBody PageRequest pageRequest
    ){
        return issueService.issueList(pageRequest);
    }

    @GetMapping("/user")
    @Operation(summary = "내 건의 리스트", description = "내가 작성한 건의 리스트 조회 (authorized)")
    public ResponseData<List<IssueListRes>> issueListByWriter(){
        return issueService.issueListByWriter();
    }

    @GetMapping("/{id}")
    @Operation(summary = "건의 내용 조회", description = "건의 내용 조회 (authorized)")
    public ResponseData<IssueByIdRes> getIssue(
            @PathVariable Long id
    ){
        return issueService.getIssue(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "건의 수정", description = "건의 수정 (authorized)")
    public Response updateIssue(
            @PathVariable("id") Long id,
            @RequestBody IssueUpdateReq issueUpdateReq
    ){
        return issueService.updateIssue(id,issueUpdateReq);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "건의 삭제", description = "건의 삭제 (authorized)")
    public Response deleteIssue(@PathVariable Long id){
        return issueService.deleteIssue(id);
    }

}
