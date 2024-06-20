package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.dto.request.IssueCreateReq;
import com.gunni.gunnihaeba.domain.dto.request.IssueUpdateReq;
import com.gunni.gunnihaeba.domain.dto.response.IssueByIdRes;
import com.gunni.gunnihaeba.domain.dto.response.IssueListRes;
import com.gunni.gunnihaeba.domain.service.IssueService;
import com.gunni.gunnihaeba.global.common.request.PageRequest;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/issue")
@RequiredArgsConstructor
public class IssueController { // 이름 변경

    private final IssueService issueService;

    @PostMapping()
    public Response createIssue(@RequestBody IssueCreateReq createIssueReq){
        return issueService.createIssue(createIssueReq);
    }

    @GetMapping("/list")
    public ResponseData<List<IssueListRes>> issueList(
            @RequestBody PageRequest pageRequest
    ){
        return issueService.issueList(pageRequest);
    }

    @GetMapping("/user")
    public ResponseData<List<IssueListRes>> issueListByWriter(){
        return issueService.issueListByWriter();
    }

    @GetMapping("/{id}")
    public ResponseData<IssueByIdRes> getIssue(
            @PathVariable Long id
    ){
        return issueService.getIssue(id);
    }

    @PatchMapping("/{id}")
    public Response updateIssue(
            @PathVariable("id") Long id,
            @RequestBody IssueUpdateReq issueUpdateReq
    ){
        return issueService.updateIssue(id,issueUpdateReq);
    }

    @DeleteMapping("/{id}")
    public Response deleteIssue(@PathVariable Long id){
        return issueService.deleteIssue(id);
    }

}
