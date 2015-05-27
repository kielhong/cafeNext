package net.kiel.cafe.web.controller.cafe;

import lombok.extern.slf4j.Slf4j;
import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.BoardRepository;
import net.kiel.cafe.repository.CommentRepository;
import net.kiel.cafe.service.ArticleService;
import net.kiel.cafe.service.CafeMemberService;
import net.kiel.cafe.service.CafeService;
import net.kiel.cafe.web.controller.cafe.dto.ArticleDto;
import net.kiel.cafe.web.controller.cafe.dto.BoardDto;
import net.kiel.cafe.web.controller.cafe.dto.CafeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.kiel.cafe.repository.specification.ArticleSpecification.isBoard;
import static net.kiel.cafe.repository.specification.ArticleSpecification.isCafe;

@Controller
@Slf4j
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
    
    @RequestMapping(value = "/{domain}", method = RequestMethod.GET)
    public String findByDomain(
            @PathVariable String domain,
            @PageableDefault(size = 15, page = 0) Pageable pageable,
            Model model) {
        Cafe cafe = cafeService.findCafeWithDataByDomain(domain);
        Page<Article> page = articleRepository.findAll(isCafe(cafe), pageable);
        
        model.addAllAttributes(getCafeInfo(domain));
        model.addAttribute("articles", page.getContent().stream().map(ArticleDto::new).collect(Collectors.toList()));
        model.addAttribute("page", page);        
        
        return "cafe";
    }
    
    @RequestMapping(value = "/{domain}/boards/{boardId}", method = RequestMethod.GET)
    public String findBoard(
            @PathVariable String domain,
            @PathVariable Long boardId,
            @PageableDefault(size = 15, page = 0) Pageable pageable,
            Model model) {
        Board board = boardRepository.findOne(boardId);
        Page<Article> page = articleRepository.findAll(isBoard(board), pageable);
        
        model.addAllAttributes(getCafeInfo(domain));
        model.addAttribute("board", new BoardDto(board));
        model.addAttribute("articles", page.getContent().stream().map(ArticleDto::new).collect(Collectors.toList()));
        model.addAttribute("page", page);
        
        return "article_list";
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