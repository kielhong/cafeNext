package net.kiel.cafe.service;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    
    
    public Long getArticleCountByCafeId(Integer cafeId) {
        return articleRepository.countByBoardCafeId(cafeId);
    }
    
        
    public Article read(Long id) {
        Article article = articleRepository.findOne(id);
        article.setReadCount(article.getReadCount() + 1);
        
        return articleRepository.save(article);
        
    }
}
