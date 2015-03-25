package net.kiel.cafe.repository;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import net.kiel.cafe.CafeCoreApplication;
import net.kiel.cafe.entity.Article;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CafeCoreApplication.class)
@Transactional
public class ArticleRepositoryTest {
    @Autowired 
    private ArticleRepository articleRepository;    
    
    @Test
    public void testSelectByCafe() {
        final Integer cafeId = 1;
        List<Article> articles = articleRepository.findByBoardCafeId(cafeId);
        
        assertThat(articles, notNullValue());
        for (Article articleEntity : articles) {
            assertThat(articleEntity.getBoard().getCafe().getId(), is(cafeId));
        }
    }
    
    @Test
    public void testSelectByBoard() {
        final Long boardId = 1L;
        List<Article> articles = articleRepository.findByBoardId(boardId);
        
        assertThat(articles, notNullValue());
        for (Article article : articles) {
            assertThat(article.getBoard().getId(), is(boardId));
        }
    }
    
    @Test
    public void testFindById() {
        final Long articleId = 1L;
        Article article = articleRepository.findOne(articleId);
        
        assertThat(article.getId(), is(articleId));
    }
     
    @Test
    public void testUpdate() {
        final Long articleId = 1L;
        final String testTitle = "Test Case Updated Title";
        Article articleEntity = articleRepository.findOne(articleId);
        articleEntity.setTitle(testTitle);
                
        Article updatedArticleEntity = articleRepository.save(articleEntity);
        
        assertThat(articleEntity.getTitle(), is(updatedArticleEntity.getTitle()));
    }
    
    @Test
    public void testFindByCafe() {
        final Integer cafeId = 1;
        
        List<Article> articles = articleRepository.findByBoardCafeId(cafeId);
        Long count = articleRepository.countByBoardCafeId(cafeId);
        
        assertThat(count, is(new Long(articles.size())));
    }
    
}
