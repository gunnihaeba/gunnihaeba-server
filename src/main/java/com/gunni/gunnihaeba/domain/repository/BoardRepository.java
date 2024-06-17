package com.gunni.gunnihaeba.domain.repository;

import com.example.board.crud.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

}