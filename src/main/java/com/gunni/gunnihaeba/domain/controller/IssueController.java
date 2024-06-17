package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/issue")
@RequiredArgsConstructor
public class IssueController { // 이름 변경

    private final IssueService issueService;

    @PostMapping()
    public void createIssue(@RequestBody IssueCreateReq createIssueReq){
        issueService.createIssue(createIssueReq);
    }

    @GetMapping("/list")
    public List<IssueRes> readBoard(){
        return ResponseEntity.ok(issueService.issueList());
    }

    @GetMapping("/{id}")
    public IssueByIdRes getIssue(
            @PathVariable Long id
    ){
        return issueService.getIssue(id);
    }

    @PatchMapping("/{id}")
    public void updateIssue(
            @PathVariable("id") Long id,
            @RequestBody IssueUpdateReq issueUpdateReq
    ){
        issueService.updateIssue(id,issueUpdateReq);
    }

    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable Long id){
        issueService.deleteIssue(id);
    }

}
