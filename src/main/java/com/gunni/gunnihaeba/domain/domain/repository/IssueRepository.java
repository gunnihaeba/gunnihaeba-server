package com.gunni.gunnihaeba.domain.domain.repository;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import com.gunni.gunnihaeba.domain.domain.repository.querydsl.CustomIssueRepo;
import com.gunni.gunnihaeba.domain.dto.response.IssueListRes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<IssueEntity,Long>, CustomIssueRepo {
}