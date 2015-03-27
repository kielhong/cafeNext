package net.kiel.cafe.entity;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.repository.ArticleRepository;
import net.kiel.cafe.repository.BoardRepository;
import net.kiel.cafe.repository.CafeRepository;
import net.kiel.cafe.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeCoreApplication.class)
@Transactional
public class ArticleTest {
    @Autowired private CafeRepository cafeRepository;
    @Autowired private BoardRepository boardRepository;
    @Autowired private UserRepository userRepository;
    
    @Autowired private ArticleRepository articleRepository;
    
    private User member;
    private Cafe cafe;
    private Board board;
    
    @Before
    public void setUp() {        
        member = new User();
        member.setUsername("testmember");
        member.setPassword("test");
        userRepository.save(member);
        
        cafe = new Cafe();
        cafe.setName("test");
        cafe.setDomain("testcafe");
        cafe.setDescription("test description");
        CafeCategory category = new CafeCategory();
        category.setId(1);
        category.setName("test");
        cafe.setCategory(category);
        cafeRepository.save(cafe);
        
        board = new Board();
        board.setCafe(cafe);
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(Board.Type.GENERAL);
        boardRepository.save(board);
    }
    
    @Test
    public void testInsert() {        
        Article article = new Article();
        article.setTitle("article title");
        article.setContent("content");
        article.setUser(member);
        article.setBoard(board);
        
        articleRepository.save(article);
        
        assertNotNull(article.getId());
        assertThat(article.getBoard().getCafe().getId(), is(cafe.getId()));
    }
    
    @Test
    public void testSelectByBoard() {
        Long before = articleRepository.count();
        
        Article article = new Article();
        article.setTitle("article title");
        article.setContent("content");
        article.setUser(member);
        article.setBoard(board);
        articleRepository.save(article);
        
        Article article2 = new Article();
        article2.setTitle("article title 2");
        article2.setContent("content 2");
        article2.setUser(member);
        article2.setBoard(board);
        articleRepository.save(article2);
                
        List<Article> articles = articleRepository.findAll();
        
        assertThat(articles, notNullValue());
        assertThat(articles.size() - before, is(2L));
    }
    
}
