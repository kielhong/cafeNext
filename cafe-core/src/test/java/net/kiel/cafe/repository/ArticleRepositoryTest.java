package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.config.AppConfig;
import net.kiel.cafe.config.RepositoryConfig;
import net.kiel.cafe.entity.ArticleEntity;

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
    private ArticleRepository articleRepository;
    
    @Test
    public void testSelectByCafe() {
        final Integer cafeId = 1;
        List<ArticleEntity> articles = articleRepository.selectByCafe(cafeId);
        
        assertThat(articles, notNullValue());
        for (ArticleEntity articleEntity : articles) {
            assertThat(articleEntity.getBoard().getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectByBoard() {
        final Integer boardId = 1;
        List<ArticleEntity> articles = articleRepository.selectByBoard(boardId);
        
        assertThat(articles, notNullValue());
        for (ArticleEntity articleEntity : articles) {
            assertThat(articleEntity.getBoard().getId(), is(boardId));
        }
    }
}
