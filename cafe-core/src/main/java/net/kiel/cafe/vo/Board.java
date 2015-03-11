package net.kiel.cafe.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.BoardEntity;
import net.kiel.cafe.entity.BoardEntity.Type;

public class Board {
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private CafeVO cafe;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private String description;

    @Getter @Setter
    private Type type;

    @Getter @Setter
    private int articleCount;
    
    @Getter @Setter
    private LocalDateTime createdAt;
    
    public BoardEntity toBoardEntity() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(this.id);
        boardEntity.setTitle(title);
        boardEntity.setDescription(description);
        boardEntity.setType(type);
        boardEntity.setCreatedAt(createdAt);
        
        return boardEntity;
    }
}
