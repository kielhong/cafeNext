package net.kiel.cafe.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.CommentRepository;

import net.kiel.cafe.repository.UserRepository;
import net.kiel.cafe.service.UserService;
import net.kiel.cafe.web.controller.api.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/articles")
@Slf4j
public class ApiArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("{articleId}/comments")
    public List<CommentDto> listComment(@PathVariable Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        return comments.stream().map(CommentDto::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "{articleId}/comments", method= RequestMethod.POST)
    public CommentDto createComment(@PathVariable Long articleId, @RequestParam String content) {
        Article article = articleRepository.findOne(articleId);
        // TODO : session handle
//        User user = userService.getUserByContext();
        User user = userRepository.findOne(1);

        log.info("param content : {}", content);

        Comment comment = new Comment(article, user, content);
        comment = commentRepository.saveAndFlush(comment);

        return new CommentDto(comment);
    }
}
