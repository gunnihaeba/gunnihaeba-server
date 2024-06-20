package com.gunni.gunnihaeba.domain.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@MappedSuperclass // 엔티티들이 해당 클래스를 상속 시 createdDate,modifiedDate 도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public abstract class BaseEntity { // BaseEntity : 모든 엔티티의 조상이 되는 엔티티

    @LastModifiedDate
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate date;

}
