package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Article {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    
    @ManyToOne
    @Getter @Setter
    private User user;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Board board;
    
    @Column(nullable = false)
    @Getter @Setter
    private String title;
    
    @Lob
    @Getter @Setter
    private String content;

    @Column(name = "read_count")
    @Getter @Setter
    private Integer readCount = 0;
    
    @Column(name = "recommend_count")
    @Getter @Setter
    private Integer recommendCount = 0;
    
    @Transient
    @Getter @Setter
    private Long commentCount;
    
//    @OneToMany(fetch=FetchType.LAZY)
//    @Cascade({CascadeType.SAVE_UPDATE})
//    @OrderBy("id DESC")
//    @Getter @Setter
//    private List<Comment> comments;

    @Column(name = "created_at")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @LastModifiedDate
    @Getter @Setter
    private LocalDateTime createdAt = LocalDateTime.now();
}