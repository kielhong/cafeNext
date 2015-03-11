package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.converter.LocalDateTimePersistenceConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @ManyToOne
    @Getter @Setter
    @JsonIgnore
    private Cafe cafe;
    
    @Column(nullable = false)
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Type type;

    @Column(name = "created_at")
    @Getter @Setter
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public enum Type {
        GENERAL,
        UNKNOWN;
    }

    @Override
    public String toString() {
        return "Board [id=" + id + ", cafe.id=" + cafe.getId() + ", title=" + title + ", description=" + description + ", type="
                + type + ", createdAt=" + createdAt + "]";
    }
}
