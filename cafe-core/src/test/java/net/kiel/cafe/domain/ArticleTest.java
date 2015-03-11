package net.kiel.cafe.domain;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Article;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;
import net.kiel.cafe.entity.Member;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {RepositoryConfig.class})
@Transactional
public class ArticleTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    private Member member;
    private Cafe cafe;
    private Board board;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
        
        member = new Member();
        member.setNickname("testmember");
        session.save(member);
        
        cafe = new Cafe();
        cafe.setName("test");
        cafe.setDomain("testcafe");
        cafe.setDescription("test description");
        cafe.setCategory((CafeCategory)session.get(CafeCategory.class, 1));
        session.save(cafe);
        
        board = new Board();
        board.setCafe(cafe);
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(Board.Type.GENERAL);
        session.save(board);
    }
    
    @Test
    public void testInsert() {        
        Article article = new Article();
        article.setTitle("article title");
        article.setContent("content");
        article.setMember(member);
        article.setBoard(board);
        
        session.save(article);
        
        assertNotNull(article.getId());
        assertThat(article.getBoard().getCafe().getId(), is(cafe.getId()));
    }
    
    @Test
    public void testSelectByBoard() {
        Article article = new Article();
        article.setTitle("article title");
        article.setContent("content");
        article.setMember(member);
        article.setBoard(board);
        session.save(article);
        
        Article article2 = new Article();
        article2.setTitle("article title 2");
        article2.setContent("content 2");
        article2.setMember(member);
        article2.setBoard(board);
        session.save(article2);
        
        Query query = session.createQuery("FROM Article as article WHERE article.board.id = :boardId")
                                .setInteger("boardId", board.getId());
        
        @SuppressWarnings("unchecked")
        List<Article> articles = (List<Article>)query.list();
        
        assertThat(articles, notNullValue());
        assertThat(articles.size(), is(2));
    }
    
}
