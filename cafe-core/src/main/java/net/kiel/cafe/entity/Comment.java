package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.kiel.cafe.dto.CommentDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String content;

    @ManyToOne
    @Getter @Setter
    private Article article;
    
    @ManyToOne
    @Getter @Setter
    private Member member;
    
    @Column(name = "created_at")
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public CommentDto toCommentVO() {
        CommentDto comment = new CommentDto();
        comment.setId(id);
        comment.setContent(content);
        comment.setArticle(article.toArticleVO(false));
        comment.setMember(member.toMemberVO());
        comment.setCreatedAt(createdAt);
        
        return comment;
        
    }
}
