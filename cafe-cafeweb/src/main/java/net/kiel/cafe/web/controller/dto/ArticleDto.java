package net.kiel.cafe.web.controller.dto;

import java.time.ZoneId;
import java.util.Date;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Member;

public class ArticleDto {
    private Article article;
    
    public ArticleDto(Article article) {
        this.article = article;
    }
    
    public Long getId() {
        return article.getId();
    }
    
    public String getTitle() {
        return article.getTitle();
    }
    
    public String getContent() {
        return article.getContent();
    }
    
    public Member getMember() {
        return article.getMember();
    }
    
    public Integer getReadCount() {
        return article.getReadCount();
    }
    
    public Integer getRecommendCount() {
        return article.getRecommendCount();
    }
    
    public Long getCommentCount() {
        return article.getCommentCount();
    }
    
    public Date getCreatedAt() {
        return Date.from(article.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
    }

}
