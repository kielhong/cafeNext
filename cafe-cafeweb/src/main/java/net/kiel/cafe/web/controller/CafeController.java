package net.kiel.cafe.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.BoardRepository;
import net.kiel.cafe.repository.CommentRepository;
import net.kiel.cafe.service.ArticleService;
import net.kiel.cafe.service.CafeMemberService;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.web.controller.dto.ArticleDto;
import net.kiel.cafe.web.controller.dto.BoardDto;
import net.kiel.cafe.web.controller.dto.CafeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CafeController {
    @Autowired
    private CafeService cafeService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CafeMemberService cafeMemberService;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        return "index";
    }
    
    @RequestMapping(value = "/{domain}", method = RequestMethod.GET)
    public String findByDomain(
            @PathVariable String domain,
            Model model) {
        
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        List<Board> boards = cafe.getBoards();
        CafeMember cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        List<Article> articles = articleRepository.findByBoardCafe(cafe);
        
        model.addAttribute("cafe", new CafeDto(cafe));
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("boards", boards.stream().map(BoardDto::new).collect(Collectors.toList()));
        model.addAttribute("articles", articles.stream().map(ArticleDto::new).collect(Collectors.toList()));
        
        return "cafe";
    }
    
    @RequestMapping(value = "/{domain}/board/{boardId}", method = RequestMethod.GET)
    public String findBoard(
            @PathVariable String domain,
            @PathVariable Integer boardId,
            Model model) {
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        CafeMember cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        List<Board> boards = cafe.getBoards();
        Board board = boardRepository.findOne(boardId);
        List<Article> articles = articleRepository.findByBoardId(boardId);
        
        model.addAttribute("cafe", new CafeDto(cafe));
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("boards", boards.stream().map(BoardDto::new).collect(Collectors.toList()));
        model.addAttribute("board", new BoardDto(board));
        model.addAttribute("articles", articles.stream().map(ArticleDto::new).collect(Collectors.toList()));
        
        return "article_list";
    }
    
    @RequestMapping(value = "/{domain}/{articleId}", method = RequestMethod.GET)
    public String readArticle(
            @PathVariable String domain,
            @PathVariable Long articleId,
            Model model) {
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        List<Board> boards = cafe.getBoards();
        CafeMember cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        Article article = articleService.read(articleId);
        Board board = article.getBoard();
                
        
        model.addAttribute("cafe", new CafeDto(cafe));
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("boards", boards.stream().map(BoardDto::new).collect(Collectors.toList()));
        model.addAttribute("board", new BoardDto(board));
        model.addAttribute("article", new ArticleDto(article));
        
        return "article_read";
    }
    
}