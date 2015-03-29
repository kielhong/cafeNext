package net.kiel.cafe.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import net.kiel.cafe.api.controller.dto.CommentDto;
import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.CommentRepository;
import net.kiel.cafe.repository.UserRepository;
import net.kiel.cafe.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles/{articleId}/comments")
public class CommentController {
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("")
    public List<CommentDto> listComment(@PathVariable Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        
        return comments.stream().map(CommentDto::new).collect(Collectors.toList());
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public CommentDto createComment(@PathVariable Long articleId, @RequestParam String content) {
        Article article = articleRepository.findOne(articleId);
        // TODO : session handle
//        User user = userService.getUserByContext();
        User user = userRepository.findOne(1);
        
        logger.info("param content : {}", content);
        
        Comment comment = new Comment(article, user, content);
        comment = commentRepository.saveAndFlush(comment);
        
        return new CommentDto(comment);
    }
}
