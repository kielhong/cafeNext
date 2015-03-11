package net.kiel.cafe.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Board.Type;

public class BoardDto {
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private CafeDto cafe;
    
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
    
    public Board toBoardEntity() {
        Board boardEntity = new Board();
        boardEntity.setId(this.id);
        boardEntity.setTitle(title);
        boardEntity.setDescription(description);
        boardEntity.setType(type);
        boardEntity.setCreatedAt(createdAt);
        
        return boardEntity;
    }
}
