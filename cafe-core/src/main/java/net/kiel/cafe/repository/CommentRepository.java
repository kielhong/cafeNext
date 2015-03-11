package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByArticle(Article article);
}
