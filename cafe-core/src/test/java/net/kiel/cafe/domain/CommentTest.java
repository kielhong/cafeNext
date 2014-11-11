package net.kiel.cafe.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfig.class})
@Transactional
public class CommentTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    private Member member;
    private Cafe cafe;
    private Board board;
    private Article article;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
        
        member = new Member();
        member.setNickname("testmember");
        session.save(member);
        
        cafe = new Cafe();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        cafe.setCategory((CafeCategory)session.get(CafeCategory.class, 1));
        session.save(cafe);
        
        board = new Board();
        board.setCafe(cafe);
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(Board.Type.GENERAL);
        session.save(board);
        
        article = new Article();
        article.setTitle("article title");
        article.setContent("content");
        article.setMember(member);
        article.setBoard(board);
        session.save(article);
    }
    
    @Test
    public void testSaveUpdate() {        
        int commentCount = article.getCommentCount();
        
        Comment comment = new Comment();
        comment.setContent("test comment");
        comment.setMember(member);
        comment.setArticle(article);
        
        article.getComments().add(comment);
        
        session.update(article);
        
        Article article2 = (Article)session.get(Article.class, article.getId());
        assertThat(article2.getCommentCount(), is(commentCount + 1));
    }
}
