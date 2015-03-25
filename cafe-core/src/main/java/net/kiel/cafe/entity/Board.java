package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="FK_board_cafe"))
    @Getter @Setter
    private Cafe cafe;
    
    @Column(nullable = false, length = 512)
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Type type;

    @Getter @Setter
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createDatetime = LocalDateTime.now();
    
    
    public enum Type {
        GENERAL,
        UNKNOWN;
    }

    @Override
    public String toString() {
        return "Board [id=" + id + ", cafe.id=" + cafe.getId() + ", title=" + title + ", description=" + description + ", type="
                + type + ", createdAt=" + createDatetime + "]";
    }
}
