package net.kiel.cafe.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;

import org.springframework.data.jpa.domain.Specification;

public class ArticleSpecification {

    public static Specification<Article> isCafe(Cafe cafe) {
        return (root, query, cb) -> cb.equal(root.get("board").get("cafe"), cafe);
    }

    public static Specification<Article> isBoard(Board board) {
        return (root, query, cb) -> cb.equal(root.get("board"), board);
    }
}
