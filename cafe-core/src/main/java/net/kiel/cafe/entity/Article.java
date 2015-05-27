package net.kiel.cafe.entity;

import lombok.Data;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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
    private Long commentCount = 0L;
    
    @Column(name = "create_datetime")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createDatetime = LocalDateTime.now();
}