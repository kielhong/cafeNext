package net.kiel.cafe.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import net.kiel.cafe.api.controller.dto.CommentDto;
import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private CommentRepository commentRepository;
    
    @RequestMapping("{articleId}/comment/list")
    public List<CommentDto> listComment(@PathVariable Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        
        return comments.stream().map(CommentDto::new).collect(Collectors.toList());
    }
    

}
