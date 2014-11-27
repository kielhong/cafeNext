package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Comment {

    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String content;

    @Getter @Setter
    private Article article;
    
    @Getter @Setter
    private Member member;
    
    @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    public Date getCreatedAt() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
