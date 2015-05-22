package net.kiel.cafe.web.controller.cafe.dto;

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
    
    public Date getCreateDatetime() {
        return Date.from(board.getCreateDatetime().atZone(ZoneId.systemDefault()).toInstant());
    }

}
