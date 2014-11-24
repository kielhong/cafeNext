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

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Article {
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
    private Member member;    
    
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
    
    public int getCommentCount() {
        return comments.size();
    }
}
