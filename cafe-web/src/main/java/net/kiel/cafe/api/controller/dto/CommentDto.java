package net.kiel.cafe.api.controller.dto;

import java.time.ZoneId;
import java.util.Date;

import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.entity.User;

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
    public User getUser() {
        return comment.getUser();
    }
    
    @JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreateDatetime() {
        return Date.from(comment.getCreateDate().atZone(ZoneId.systemDefault()).toInstant());
    }
    

}
