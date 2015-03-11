package net.kiel.cafe.repository;

import net.kiel.cafe.entity.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
