package net.kiel.cafe.web.controller.cafe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.kiel.cafe.entity.*;
import net.kiel.cafe.service.ArticleService;
import net.kiel.cafe.service.CafeMemberService;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.web.controller.cafe.dto.ArticleDto;
import net.kiel.cafe.web.controller.cafe.dto.BoardDto;
import net.kiel.cafe.web.controller.cafe.dto.CafeDto;

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

    @RequestMapping("new")
    public String newArticle(
            @PathVariable String domain,
            Model model) {

        model.addAllAttributes(getCafeInfo(domain));

        return "article_new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(
            @PathVariable String domain,
            Article article,
            Long boardId,
            Model model) {

        article = articleService.create(boardId, article.getTitle(), article.getContent());

        return "redirect:/" + domain + "/articles/" + article.getId();
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
