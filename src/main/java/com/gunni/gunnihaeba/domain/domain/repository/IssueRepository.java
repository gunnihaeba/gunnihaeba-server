package com.gunni.gunnihaeba.domain.domain.repository;

import com.gunni.gunnihaeba.domain.domain.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<IssueEntity,Long> {

}