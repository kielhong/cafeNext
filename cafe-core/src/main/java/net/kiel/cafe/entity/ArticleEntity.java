package net.kiel.cafe.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;
import net.kiel.cafe.vo.Article;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String content;

    @ManyToOne
    @Getter @Setter
    private MemberEntity member;    
    
    @ManyToOne
    @Getter @Setter
    private BoardEntity board;

    @OneToMany(mappedBy = "article")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Getter @Setter
    private Set<Comment> comments = new HashSet<Comment>();

    @Column(name = "created_at")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    
    
    public Article toArticleVO() {
        Article article = new Article();
        article.setId(id);
        article.setBoard(board.toBoardVO());
        article.setTitle(title);
        article.setContent(content);
        article.setCreatedAt(createdAt);
        article.setMember(member.toMemberVO());
        //article.setComments(comments);
        
        return article;
    }
}
