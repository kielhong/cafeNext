package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> findByBoardCafe(Cafe cafe);
    List<Article> findByBoardCafeId(Integer cafeId);
    Long countByBoardCafeId(Integer cafeId);
    
    List<Article> findByBoard(Board board);
    List<Article> findByBoardId(Integer boardId);
    
}
