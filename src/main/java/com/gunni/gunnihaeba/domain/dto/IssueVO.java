package com.gunni.gunnihaeba.domain.dto;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueVO {

    private Long id;

    private String title;

    private String content;

    public static IssueVO of(IssueEntity issueEntity){
        return IssueVO.builder()
                .id(issueEntity.getId())
                .title(issueEntity.getTitle())
                .content(issueEntity.getContent()).build();
    }

    public IssueEntity toEntity(){
        return IssueEntity.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content).build();
    }

}
