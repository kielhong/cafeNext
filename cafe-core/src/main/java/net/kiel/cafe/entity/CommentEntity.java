package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.kiel.cafe.vo.Comment;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String content;

    @ManyToOne
    @Getter @Setter
    private ArticleEntity article;
    
    @ManyToOne
    @Getter @Setter
    private MemberEntity member;
    
    @Column(name = "created_at")
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public Comment toCommentVO() {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setContent(content);
        comment.setArticle(article.toArticleVO(false));
        comment.setMember(member.toMemberVO());
        comment.setCreatedAt(createdAt);
        
        return comment;
        
    }
}
