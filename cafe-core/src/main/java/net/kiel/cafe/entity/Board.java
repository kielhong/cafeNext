package net.kiel.cafe.entity;

import lombok.Data;
import lombok.ToString;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString(exclude = "cafe")
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="FK_board_cafe"))
    private Cafe cafe;
    
    @Column(nullable = false, length = 512)
    private String title;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "create_datetime")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createDatetime = LocalDateTime.now();

    public enum Type {
        GENERAL,
        UNKNOWN;
    }
}
