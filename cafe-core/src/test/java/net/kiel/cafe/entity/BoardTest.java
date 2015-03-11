package net.kiel.cafe.entity;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.entity.Board;
import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.repository.BoardRepository;
import net.kiel.cafe.repository.CafeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeCoreApplication.class)
@Transactional
public class BoardTest {
    @Autowired private CafeRepository cafeRepository;
    @Autowired private BoardRepository boardRepository;
    
    @Test
    public void testInsert() {
        Cafe cafe = cafeRepository.findOne(1);
        
        Board board = new Board();
        board.setTitle("board");
        board.setDescription("test board description");
        board.setType(Board.Type.GENERAL);
        board.setCafe(cafe);
        
        boardRepository.save(board);
        
        assertNotNull(board.getId());
    }

}
