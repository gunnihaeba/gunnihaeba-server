package com.gunni.gunnihaeba.domain.service;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import com.gunni.gunnihaeba.domain.domain.repository.CommentRepository;
import com.gunni.gunnihaeba.domain.domain.repository.IssueRepository;
import com.gunni.gunnihaeba.domain.dto.Issue;
import com.gunni.gunnihaeba.domain.dto.request.IssueCreateReq;
import com.gunni.gunnihaeba.domain.dto.request.IssueUpdateReq;
import com.gunni.gunnihaeba.domain.dto.response.IssueByIdRes;
import com.gunni.gunnihaeba.domain.dto.response.IssueListRes;
import com.gunni.gunnihaeba.domain.exception.issue.IssueNotFoundException;
import com.gunni.gunnihaeba.global.common.repository.UserSessionHolder;
import com.gunni.gunnihaeba.global.common.request.PageRequest;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;
    private final UserSessionHolder userSessionHolder;

    public Response createIssue(IssueCreateReq createIssueReq){
        issueRepository.save(createIssueReq.toEntity(userSessionHolder.getUser()));
        return Response.created("건의글 저장 성공");
    }

    public ResponseData<IssueByIdRes> getIssue(Long id){
        IssueEntity issueEntity = findById(id);
        return ResponseData.ok("건의 내용 조회 성공",IssueByIdRes.of(issueEntity,userSessionHolder.getUser()));
    }

    public ResponseData<List<IssueListRes>> issueList(PageRequest pageRequest){
        return ResponseData.ok("건의 리스트 조회 성공",issueRepository.issueListByWriter(pageRequest));
    }

    public ResponseData<List<IssueListRes>> issueListByWriter(){
        return ResponseData.ok("내가 작성한 건의 리스트 조회 성공",issueRepository.issueListByWriter(userSessionHolder.getUser().getId()));
    }
   
    public Response updateIssue(Long id, IssueUpdateReq issueUpdateReq){
        Issue issueVO = issueRepository.findById(id)
                .map(Issue::of)
                .orElseThrow(() -> IssueNotFoundException.EXCEPTION);
        issueVO.setTitle(issueUpdateReq.getTitle());
        issueVO.setContent(issueUpdateReq.getContent());
        issueRepository.save(issueVO.toEntity());
        return Response.ok("건의 수정 성공");
    }

    public Response deleteIssue(Long id){
        findById(id);
        issueRepository.deleteById(id);
        return Response.ok("건의 삭제 성공");
    }

    private IssueEntity findById(Long id){
        return issueRepository.findById(id)
                .orElseThrow(() -> IssueNotFoundException.EXCEPTION);
    }
}
