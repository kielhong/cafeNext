package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.ArticleEntity;

public class Article {
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private Board board;
    
    @Getter @Setter
    private Member member;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String content;
    
    @Getter @Setter
    private int readCount;
    
    @Getter @Setter
    private int recommendCount;

    @Getter @Setter
    private List<Comment> comments = new ArrayList<Comment>();

    @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    public Date getCreatedAt() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public ArticleEntity toArticleEntity() {
        ArticleEntity article = new ArticleEntity();
        article.setId(id);
        article.setBoard(board.toBoardEntity());
        article.setMember(member.toMemberEntity());
        article.setTitle(title);
        article.setContent(content);
        article.setReadCount(readCount);
        article.setRecommendCount(recommendCount);
        article.setCreatedAt(createdAt);
        
        //article.setComments(comments);
        
        return article;
    }
}
