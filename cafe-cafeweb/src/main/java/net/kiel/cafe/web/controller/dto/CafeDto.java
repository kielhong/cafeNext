package net.kiel.cafe.web.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;

public class CafeDto {
    private Cafe cafe;
   
    public CafeDto(Cafe cafe) {
        this.cafe = cafe;
    }
    
    public Integer getId() {
        return cafe.getId();
    }
    
    public String getDomain() {
        return cafe.getDomain();
    }
    
    public String getName() {
        return cafe.getName();
    }
    
    public String getDescription() {
        return cafe.getDescription();
    }
    
    public List<Board> getBoards() {
        return cafe.getBoards();
    }
    
    public Long getArticleCount() {
        return cafe.getArticleCount();
    }
    
    public LocalDateTime getCreateDate() {
        return cafe.getCreateDatetime();
    }
    
    public LocalDateTime getUpdateDate() {
        return cafe.getUpdateDatetime();
    }
}
