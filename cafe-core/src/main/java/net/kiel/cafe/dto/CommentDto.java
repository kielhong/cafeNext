package net.kiel.cafe.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class CommentDto {

    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String content;

    @Getter @Setter
    private ArticleDto article;
    
    @Getter @Setter
    private MemberDto member;
    
    @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    public Date getCreatedAt() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
