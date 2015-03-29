package net.kiel.cafe.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
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
@RequestMapping("{domain}/articles")
public class ArticleController {
    @Autowired
    private CafeService cafeService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CafeMemberService cafeMemberService;
    
    
    @RequestMapping(value = "{articleId}", method = RequestMethod.GET)
    public String readArticle(
            @PathVariable String domain,
            @PathVariable Long articleId,
            Model model) {
        
        Article article = articleService.read(articleId);
        Board board = article.getBoard();
                        
        model.addAllAttributes(getCafeInfo(domain));
        model.addAttribute("board", new BoardDto(board));
        model.addAttribute("article", new ArticleDto(article));
        
        return "article_read";
    }
    
    private Map<String, Object> getCafeInfo(String domain) {
        Map<String, Object> cafeBaseAttributes = new HashMap<String, Object>();
        
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        List<Board> boards = cafe.getBoards();
        CafeUser cafeManager = cafeMemberService.findCafeManager(cafe.getId());
        
        cafeBaseAttributes.put("cafe", new CafeDto(cafe));
        cafeBaseAttributes.put("cafeManager", cafeManager);
        cafeBaseAttributes.put("boards",boards.stream().map(BoardDto::new).collect(Collectors.toList()));
        
        return cafeBaseAttributes;
    }
}
