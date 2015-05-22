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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@ToString(exclude = {"board"})
@Data
public class Article {
    public Article() {}
    public Article(User user, Board board, String title, String content) {
        this.user = user;
        this.board = board;
        this.title = title;
        this.content = content;
    }

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User user;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    
    @Column(nullable = false)
    private String title;
    
    @Lob
    private String content;

    @Column(name = "read_count")
    private Integer readCount = 0;
    
    @Column(name = "recommend_count")
    private Integer recommendCount = 0;
    
    @Transient
    private Long commentCount;
    
    @Column(name = "create_datetime")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createDatetime = LocalDateTime.now();
}