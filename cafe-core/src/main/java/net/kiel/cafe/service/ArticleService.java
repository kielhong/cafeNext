package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.ArticleEntity;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.vo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    
    public List<Article> findByCafe(Integer cafeId) {
        List<Article> results = new ArrayList<Article>();
        
        List<ArticleEntity> articles = articleRepository.selectByCafe(cafeId);
        
        for (ArticleEntity articleEntity : articles) {
            results.add(articleEntity.toArticleVO());
        }
        
        return results;
    }
    
    public List<Article> findByBoard(Integer boardId) {
        List<Article> results = new ArrayList<Article>();
        
        List<ArticleEntity> articles = articleRepository.selectByBoard(boardId);
        
        for (ArticleEntity articleEntity : articles) {
            results.add(articleEntity.toArticleVO());
        }
        
        return results;
    }
    
}
