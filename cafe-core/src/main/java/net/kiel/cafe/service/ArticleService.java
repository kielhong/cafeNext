package net.kiel.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.vo.ArticleDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    
    public List<ArticleDto> findListByCafe(Integer cafeId) {
        List<ArticleDto> results = new ArrayList<ArticleDto>();
        
        List<Article> articles = articleRepository.selectListByCafe(cafeId);
        
        for (Article articleEntity : articles) {
            results.add(articleEntity.toArticleVO(false));
        }
        
        return results;
    }
    
    public Long getArticleCountByCafe(Integer cafeId) {
        return articleRepository.selectCountByCafe(cafeId);
    }
    
    public List<ArticleDto> findListByBoard(Integer boardId) {
        List<ArticleDto> results = new ArrayList<ArticleDto>();
        
        List<Article> articles = articleRepository.selectListByBoard(boardId);
        
        for (Article articleEntity : articles) {
            results.add(articleEntity.toArticleVO(false));
        }
        
        return results;
    }
    
    public ArticleDto findById(Integer id) {
        Article article = articleRepository.selectById(id);
        
        return article.toArticleVO(true);
    }
    
    public ArticleDto read(Integer id) {
        Article article = articleRepository.selectById(id);
        article.setReadCount(article.getReadCount() + 1);
        articleRepository.update(article);
        
        return article.toArticleVO(true);
    }
    
    public void update(ArticleDto article) {
        Article articleEntity = article.toArticleEntity();
        articleRepository.update(articleEntity);
    }
}
