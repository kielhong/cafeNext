package net.kiel.cafe.api.controller.dto;

import java.time.ZoneId;
import java.util.Date;

import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.entity.Member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CommentDto {
    private Comment comment;
    
    public CommentDto(Comment comment) {
        this.comment = comment;
    }

    public Long getId() {
        return comment.getId();
    }
    
    public String getContent() {
        return comment.getContent();
    }
    public Member getMember() {
        return comment.getMember();
    }
    
    @JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return Date.from(comment.getCreateDate().atZone(ZoneId.systemDefault()).toInstant());
    }
    

}
