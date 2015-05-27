package net.kiel.cafe.web.controller.cafe.dto;

import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.User;

public class ArticleDto {
    private Article article;
    
    public ArticleDto(Article article) {
        this.article = article;
    }
    
    public Long getId() {
        return article.getId();
    }

    public BoardDto getBoard() {
        return new BoardDto(article.getBoard());
    }

    public String getTitle() {
        return article.getTitle();
    }
    
    public String getContent() {
        return article.getContent();
    }
    
    public User getUser() {
        return article.getUser();
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

    public Date getCreateDatetime() {
        return Date.from(article.getCreateDatetime().atZone(ZoneId.systemDefault()).toInstant());
    }

}
