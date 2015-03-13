package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer>{
    List<Board> findByCafe(Cafe cafe);
}
