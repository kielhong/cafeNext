package net.kiel.cafe.domain;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.ArticleEntity;
import net.kiel.cafe.entity.BoardEntity;
import net.kiel.cafe.entity.CafeCategoryEntity;
import net.kiel.cafe.entity.CafeEntity;
import net.kiel.cafe.entity.CommentEntity;
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
@ContextConfiguration(classes = {RepositoryConfig.class})
@Transactional
public class CommentTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    private MemberEntity member;
    private CafeEntity cafe;
    private BoardEntity board;
    private ArticleEntity article;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
        
        member = new MemberEntity();
        member.setNickname("testmember");
        session.save(member);
        
        cafe = new CafeEntity();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test description");
        cafe.setCategory((CafeCategoryEntity)session.get(CafeCategoryEntity.class, 1));
        session.save(cafe);
        
        board = new BoardEntity();
        board.setCafe(cafe);
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(BoardEntity.Type.GENERAL);
        session.save(board);
        
        article = new ArticleEntity();
        article.setTitle("article title");
        article.setContent("content");
        article.setMember(member);
        article.setBoard(board);
        session.save(article);
    }
    
    @Test
    public void testSaveUpdate() {        
        //int commentCount = article.getCommentCount();
        
        CommentEntity comment = new CommentEntity();
        comment.setContent("test comment");
        comment.setMember(member);
        comment.setArticle(article);
        
        article.getComments().add(comment);
        
        session.update(article);
        
        //ArticleEntity article2 = (ArticleEntity)session.get(ArticleEntity.class, article.getId());
        //assertThat(article2.getCommentCount(), is(commentCount + 1));
    }
}
