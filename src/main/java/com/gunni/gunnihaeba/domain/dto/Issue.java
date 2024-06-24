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
public class Issue {

    private Long id;

    private String title;

    private String content;

    private Long writerIdx;

    public static Issue of(IssueEntity issueEntity){
        return Issue.builder()
                .id(issueEntity.getId())
                .title(issueEntity.getTitle())
                .content(issueEntity.getContent())
                .writerIdx(issueEntity.getWriterIdx()).build();
    }

    public IssueEntity toEntity(){
        return IssueEntity.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .writerIdx(this.writerIdx).build();
    }

}
