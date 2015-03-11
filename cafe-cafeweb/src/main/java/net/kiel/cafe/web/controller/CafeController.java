package net.kiel.cafe.web.controller;

import java.util.ArrayList;
import java.util.List;

import net.kiel.cafe.service.ArticleService;
import net.kiel.cafe.service.CafeMemberService;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.vo.ArticleDto;
import net.kiel.cafe.vo.BoardDto;
import net.kiel.cafe.vo.CafeDto;
import net.kiel.cafe.vo.CafeMemberDto;

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
        
        CafeDto cafe = cafeService.findByNickname(nickname);
        cafe.setArticleCount(articleService.getArticleCountByCafe(cafe.getId()));
        CafeMemberDto cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        List<ArticleDto> articles = articleService.findListByCafe(cafe.getId());
        
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
        CafeDto cafe = cafeService.findByNickname(nickname);
        cafe.setArticleCount(articleService.getArticleCountByCafe(cafe.getId()));
        CafeMemberDto cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        List<ArticleDto> articles = new ArrayList<ArticleDto>();
        
        for (BoardDto board : cafe.getBoards()) {
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
    public String readArticle(
            @PathVariable String nickname,
            @PathVariable Integer articleId,
            Model model) {
        CafeDto cafe = cafeService.findByNickname(nickname);
        cafe.setArticleCount(articleService.getArticleCountByCafe(cafe.getId()));
        CafeMemberDto cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        ArticleDto article = articleService.read(articleId);
        
        model.addAttribute("cafe", cafe);
        model.addAttribute("cafeManager", cafeManager);
        model.addAttribute("article", article);
        
        return "article_read";
    }
    
}