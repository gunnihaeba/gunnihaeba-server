package com.gunni.gunnihaeba.domain.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "tb_issue")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45,nullable = false)
    private String title;

    @Column(length = 500,nullable = false)
    private String content;

    @Builder
    public IssueEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
