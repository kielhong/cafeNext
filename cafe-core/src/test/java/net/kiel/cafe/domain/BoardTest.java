package net.kiel.cafe.domain;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;

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
        Cafe cafe = new Cafe();
        cafe.setName("test");
        cafe.setDomain("testcafe");
        cafe.setDescription("test cafe description");
        cafe.setCategory((CafeCategory)session.get(CafeCategory.class, 1));
        
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
