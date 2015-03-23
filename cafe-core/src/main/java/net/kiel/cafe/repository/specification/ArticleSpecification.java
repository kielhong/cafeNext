package net.kiel.cafe.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;

import org.springframework.data.jpa.domain.Specification;

public class ArticleSpecification implements Specification<Article> {
    private Cafe cafe;
    private Board board;
    
    public ArticleSpecification(Cafe cafe) {
        this.cafe = cafe;
    }
    
    public ArticleSpecification(Cafe cafe, Board board) {
        this.cafe = cafe;
        this.board = board;
    }
    
    @Override
    public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.get("board").get("cafe"), cafe);
    }
}