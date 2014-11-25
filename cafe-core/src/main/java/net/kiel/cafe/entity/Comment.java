package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Comment {
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
}
