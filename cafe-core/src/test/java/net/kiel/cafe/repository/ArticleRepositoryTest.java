package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeNextCoreApplication;
import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.entity.Member;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeNextCoreApplication.class)
@Transactional
public class ArticleRepositoryTest {    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Before
    public void setUp() {
        Article articleEntity = new Article();
        
        CafeCategory category = new CafeCategory();
        category.setId(100);
        category.setName("test category");        
        Cafe cafe = new Cafe();
        cafe.setName("test");
        cafe.setDomain("testcafe");
        cafe.setDescription("test cafe description");
        cafe.setCategory(category);        
        Board board = new Board();
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(Board.Type.GENERAL);
        board.setCafe(cafe);
        articleEntity.setBoard(board);
        Member member = new Member();
        member.setNickname("testmember");
        articleEntity.setMember(member);
        articleEntity.setTitle("Article Test Case Title");
        articleEntity.setContent("Article Test Case Content");
        articleEntity.setReadCount(10);
        articleEntity.setRecommendCount(5);
        articleEntity.setCreatedAt(LocalDateTime.now());   
    }
    
    
    @Test
    public void testSelectByCafe() {
        final Integer cafeId = 1;
        List<Article> articles = articleRepository.selectListByCafe(cafeId);
        
        assertThat(articles, notNullValue());
        for (Article articleEntity : articles) {
            assertThat(articleEntity.getBoard().getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectByBoard() {
        final Integer boardId = 1;
        List<Article> articles = articleRepository.selectListByBoard(boardId);
        
        assertThat(articles, notNullValue());
        for (Article articleEntity : articles) {
            assertThat(articleEntity.getBoard().getId(), is(boardId));
        }
    }
    
    @Test
    public void testSelectById() {
        final Integer articleId = 1;
        Article articleEntity = articleRepository.selectById(articleId);
        
        assertThat(articleEntity.getId(), is(articleId));
    }
     
    @Test
    public void testUpdate() {
//        Session session = sessionFactory.getCurrentSession();
//        final Integer articleId = 1;
//        final String testTitle = "Test Case Updated Title";
//        ArticleEntity articleEntity = articleRepository.selectById(articleId);
//        articleEntity.setTitle(testTitle);
//        session.update(articleEntity);
//        
//        ArticleEntity updatedArticleEntity = articleRepository.selectById(articleId);
//        assertThat(articleEntity.getTitle(), is(updatedArticleEntity.getTitle()));
    }
    
    @Test
    public void testSelectCountByCafe() {
        final Integer cafeId = 1;
        
        List<Article> articles = articleRepository.selectListByCafe(cafeId);
        Long count = articleRepository.selectCountByCafe(cafeId);
        
        assertThat(count, is(new Long(articles.size())));
    }
    
}
