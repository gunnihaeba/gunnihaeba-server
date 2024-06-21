package com.gunni.gunnihaeba.domain.domain.repository;

import com.gunni.gunnihaeba.domain.domain.CommentEntity;
import com.gunni.gunnihaeba.domain.domain.repository.querydsl.CustomCommentRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> , CustomCommentRepo {
}
