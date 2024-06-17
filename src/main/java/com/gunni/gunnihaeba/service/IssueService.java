package com.gunni.gunnihaeba.service;

import com.gunni.gunnihaeba.domain.IssueEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public void createIssue(IssueCreateReq createIssueReq){
        issueRepository.save(createIssueReq.toEntity());
    }

    public IssueByIdRes getIssue(Long id){
        IssueEntity issueEntity = issueRepository.findById(id)
                .orElseThrow(() -> IssueNotFoundException.EXCEPTION);
        return IssueByIdRes.of(issueEntity);
    }

   
    public void updateIssue(Long id,IssueUpdateReq issueUpdateReq){
        IssueVO issueVO = issueRepository.findById(id)
                .orElseThrow(() -> IssueNotFoundException.EXCEPTION);
        issueVO.setTitle(issueUpdateReq.getTitle());
        issueVO.setContent(issueUpdateReq.getContent());
        issueRepository.save(issueVO.toEntity());
    }

    public void deleteIssue(Long id){
        IssueEntity issueEntity = boardRepository.findById(id)
                .orElseThrow(() -> IssueNotFoundException.EXCEPTION);
        issueRepository.delete(id);
    }

}
