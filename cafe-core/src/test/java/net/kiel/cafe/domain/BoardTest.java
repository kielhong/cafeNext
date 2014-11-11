package net.kiel.cafe.domain;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.CafeCategoryEntity;
import net.kiel.cafe.entity.CafeEntity;

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
public class BoardTest {

    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    @Test
    public void testInsert() {
        CafeEntity cafe = new CafeEntity();
        cafe.setName("test");
        cafe.setNickname("testcafe");
        cafe.setDescription("test cafe description");
        cafe.setCategory((CafeCategoryEntity)session.get(CafeCategoryEntity.class, 1));
        
        session.save(cafe);
        
        Board board = new Board();
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(Board.Type.GENERAL);
        board.setCafe(cafe);
        
        session.save(board);
        
        assertNotNull(board.getId());
    }

}
