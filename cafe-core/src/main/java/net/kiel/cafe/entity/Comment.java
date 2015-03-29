package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

@Entity
public class Comment {
    public Comment() {}
    
    public Comment(Article article, User user, String content) {
        this.article = article;
        this.user = user;
        this.content = content;
    }
    
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    
    @Column(length = 1024)
    @Getter @Setter
    private String content;

    @ManyToOne
    @Getter @Setter
    private Article article;
    
    @ManyToOne
    @Getter @Setter
    private User user;
    
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Getter @Setter
    private LocalDateTime createDate;
    
    @PrePersist
    private void prePersisit() {
        createDate = LocalDateTime.now();
    }
}
