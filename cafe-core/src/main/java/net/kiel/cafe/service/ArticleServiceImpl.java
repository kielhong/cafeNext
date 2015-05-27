package net.kiel.cafe.service;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Comment;
import net.kiel.cafe.entity.User;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.BoardRepository;
import net.kiel.cafe.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private UserService userService;
    
    
    public Long getArticleCountByCafeId(Integer cafeId) {
        return articleRepository.countByBoardCafeId(cafeId);
    }
    
    public Article create(Article articleCommand) {
        User user = userService.getUserByContext();
        Board board = boardRepository.findOne(articleCommand.getBoard().getId());
        Article article = new Article(user, board, articleCommand.getTitle(), articleCommand.getContent());

        return articleRepository.save(article);
    }

    public Article update(Article articleCommand) {
        Article article = articleRepository.findOne(articleCommand.getId());
        Board board = boardRepository.findOne(articleCommand.getBoard().getId());

        article.setTitle(articleCommand.getTitle());
        article.setContent(articleCommand.getContent());
        article.setBoard(board);

        return articleRepository.save(article);
    }

    public Article read(Long id) {
        Article article = articleRepository.findOne(id);
        article.setReadCount(article.getReadCount() + 1);
        article.setCommentCount(commentRepository.countByArticle(article));
        
        return articleRepository.save(article);
        
    }

    public List<Comment> listComments(Long id) {
        return commentRepository.findByArticleId(id);
    }


}
