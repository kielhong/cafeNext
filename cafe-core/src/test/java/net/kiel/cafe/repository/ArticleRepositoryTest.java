package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.AppConfig;
import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.ArticleEntity;
import net.kiel.cafe.entity.BoardEntity;
import net.kiel.cafe.entity.CafeCategoryEntity;
import net.kiel.cafe.entity.CafeEntity;
import net.kiel.cafe.entity.MemberEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, RepositoryConfig.class})
@Transactional
public class ArticleRepositoryTest {    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ArticleRepository articleRepository;
    
    @Before
    public void setUp() {
        ArticleEntity articleEntity = new ArticleEntity();
        
        CafeCategoryEntity category = new CafeCategoryEntity();
        category.setId(100);
        category.setName("test category");        
        CafeEntity cafe = new CafeEntity();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test cafe description");
        cafe.setCategory(category);        
        BoardEntity board = new BoardEntity();
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(BoardEntity.Type.GENERAL);
        board.setCafe(cafe);
        articleEntity.setBoard(board);
        MemberEntity member = new MemberEntity();
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
        List<ArticleEntity> articles = articleRepository.selectListByCafe(cafeId);
        
        assertThat(articles, notNullValue());
        for (ArticleEntity articleEntity : articles) {
            assertThat(articleEntity.getBoard().getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectByBoard() {
        final Integer boardId = 1;
        List<ArticleEntity> articles = articleRepository.selectListByBoard(boardId);
        
        assertThat(articles, notNullValue());
        for (ArticleEntity articleEntity : articles) {
            assertThat(articleEntity.getBoard().getId(), is(boardId));
        }
    }
    
    @Test
    public void testSelectById() {
        final Integer articleId = 1;
        ArticleEntity articleEntity = articleRepository.selectById(articleId);
        
        assertThat(articleEntity.getId(), is(articleId));
    }
     
    @Test
    public void testUpdate() {
        Session session = sessionFactory.getCurrentSession();
        final Integer articleId = 1;
        final String testTitle = "Test Case Updated Title";
        ArticleEntity articleEntity = articleRepository.selectById(articleId);
        articleEntity.setTitle(testTitle);
        session.update(articleEntity);
        
        ArticleEntity updatedArticleEntity = articleRepository.selectById(articleId);
        assertThat(articleEntity.getTitle(), is(updatedArticleEntity.getTitle()));
    }
    
}
