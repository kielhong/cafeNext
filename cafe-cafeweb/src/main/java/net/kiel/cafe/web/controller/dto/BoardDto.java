package net.kiel.cafe.web.controller.dto;

import java.time.ZoneId;
import java.util.Date;

import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Board.Type;

public class BoardDto {
    private Board board;
    
    public BoardDto(Board board) {
        this.board = board;
    }
    
    public Long getId() {
        return board.getId();
    }
    
    public String getTitle() {
        return board.getTitle();
    }
    
    public String getDescription() {
        return board.getDescription();
    }
    
    public Type getType() {
        return board.getType();
    }
    
    public Date getCreateDate() {
        return Date.from(board.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
    }

}
