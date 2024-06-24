package com.gunni.gunnihaeba.domain.domain;

import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Table(name = "tb_react")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long viewerId;

    @Column(nullable = false)
    private Long issueId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReactType reactType;

}