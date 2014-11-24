package net.kiel.cafe.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.BoardEntity.Type;

public class Board {
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private Cafe cafe;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String description;

    @Getter @Setter
    private Type type;

    @Getter @Setter
    private LocalDateTime createdAt;
}
