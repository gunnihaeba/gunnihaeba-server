package com.gunni.gunnihaeba.domain;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 엔티티들이 해당 클래스를 상속 시 createdDate,modifiedDate 도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity { // BaseEntity : 모든 엔티티의 조상이 되는 엔티티

    @LastModifiedDate
    @Column(name = "modified_date") // 마지막 수정시간 자동 저장
    private LocalDateTime modifiedDate;

}
