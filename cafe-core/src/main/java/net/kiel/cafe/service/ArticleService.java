package net.kiel.cafe.service;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.entity.User;

import java.util.List;

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 27.
 */
public interface ArticleService {
    public Long getArticleCountByCafeId(Integer cafeId);

    public Article create(Article articleCommand);

    public Article update(Article articleCommand);

    public Article read(Long id);

    public List<Comment> listComments(Long id);
}
