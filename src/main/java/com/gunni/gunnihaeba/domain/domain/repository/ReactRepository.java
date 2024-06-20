package com.gunni.gunnihaeba.domain.domain.repository;

import com.gunni.gunnihaeba.domain.domain.ReactEntity;
import com.gunni.gunnihaeba.domain.domain.repository.querydsl.CustomReactRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactRepository extends JpaRepository<ReactEntity, Long>, CustomReactRepo {
}
