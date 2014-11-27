package net.kiel.cafe.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
    
    @ManyToOne
    @Getter @Setter
    private MemberEntity member;    
    
    @ManyToOne
    @Getter @Setter
    private BoardEntity board;
    
    @Column(nullable = false)
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String content;

    @Column(name = "read_count")
    @Getter @Setter
    private Integer readCount = 0;
    
    @Column(name = "recommend_count")
    @Getter @Setter
    private Integer recommendCount = 0;
    
    @OneToMany(mappedBy = "article", fetch=FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE})
    @OrderBy("id DESC")
    @Getter @Setter
    private List<CommentEntity> comments = new ArrayList<CommentEntity>();

    @Column(name = "created_at")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
    
    
    public Article toArticleVO(boolean includeComment) {
        Article article = new Article();
        article.setId(id);
        article.setBoard(board.toBoardVO());
        article.setMember(member.toMemberVO());
        article.setTitle(title);
        article.setContent(content);
        article.setReadCount(readCount);
        article.setRecommendCount(recommendCount);
        article.setCreatedAt(createdAt);
        if (includeComment) {
            for (CommentEntity comment : comments) {
                article.getComments().add(comment.toCommentVO());
            }
        }
        
        return article;
    }
}