package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.Comment;

public class Article {
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String content;

    @Getter @Setter
    private Member member;    
    
    @Getter @Setter
    private int readCount;
    
    @Getter @Setter
    private int recommendCount;
    
    @Getter @Setter
    private Board board;

    @Getter @Setter
    private Set<Comment> comments = new HashSet<Comment>();

    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
}
