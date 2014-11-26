package net.kiel.cafe.web.controller;

import java.util.ArrayList;
import java.util.List;

import net.kiel.cafe.service.ArticleService;
import net.kiel.cafe.service.CafeMemberService;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.vo.Article;
import net.kiel.cafe.vo.Board;
import net.kiel.cafe.vo.Cafe;
import net.kiel.cafe.vo.CafeMember;

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
    private CafeMemberService cafeMemberService;
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        return "index";
    }
    
    @RequestMapping(value = "/{nickname}", method = RequestMethod.GET)
    public String findById(
            @PathVariable String nickname,
            Model model) {
        
        Cafe cafe = cafeService.findByNickname(nickname);
        CafeMember cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        List<Article> articles = articleService.findListByCafe(cafe.getId());
        
        model.addAttribute("cafe", cafe);
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("articles", articles);
        
        return "cafe";
    }
    
    @RequestMapping(value = "/{nickname}/board/{boardId}", method = RequestMethod.GET)
    public String findBoard(
            @PathVariable String nickname,
            @PathVariable Integer boardId,
            Model model) {
        Cafe cafe = cafeService.findByNickname(nickname);
        CafeMember cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        List<Article> articles = new ArrayList<Article>();
        
        for (Board board : cafe.getBoards()) {
            if (board.getId().equals(boardId)) {
                model.addAttribute("board", board);
                articles = articleService.findListByBoard(boardId);
            }
        }
        model.addAttribute("cafe", cafe);
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("articles", articles);
        
        return "article_list";
    }
    
    @RequestMapping(value = "/{nickname}/{articleId}", method = RequestMethod.GET)
    public String findArticle(
            @PathVariable String nickname,
            @PathVariable Integer articleId,
            Model model) {
        Cafe cafe = cafeService.findByNickname(nickname);
        CafeMember cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        Article article = articleService.findById(articleId);
        
        model.addAttribute("cafe", cafe);
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("article", article);
        
        return "article_read";
    }
    
}