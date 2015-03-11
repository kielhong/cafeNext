package net.kiel.cafe.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.Article;

public class ArticleDto {
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private BoardDto board;
    
    @Getter @Setter
    private MemberDto member;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String content;
    
    @Getter @Setter
    private int readCount;
    
    @Getter @Setter
    private int recommendCount;

    @Getter @Setter
    private List<CommentDto> comments = new ArrayList<CommentDto>();

    @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    public Date getCreatedAt() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public Article toArticleEntity() {
        Article article = new Article();
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
