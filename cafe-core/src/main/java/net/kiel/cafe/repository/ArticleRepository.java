package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.ArticleEntity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @SuppressWarnings("unchecked")
    public List<ArticleEntity> selectListByCafe(Integer cafeId) {
        
        return (List<ArticleEntity>)sessionFactory.getCurrentSession()
                .createQuery("From ArticleEntity as article WHERE article.board.cafe.id = :cafeId ORDER BY id DESC")
                .setParameter("cafeId", cafeId)
                .list();        
    }
    
    @SuppressWarnings("unchecked")
    public List<ArticleEntity> selectListByBoard(Integer boardId) {
        
        return (List<ArticleEntity>)sessionFactory.getCurrentSession()
                .createQuery("From ArticleEntity as article WHERE article.board.id = :boardId ORDER BY id DESC")
                .setParameter("boardId", boardId)
                .list();        
    }
    
    public ArticleEntity selectById(Integer id) {
        return (ArticleEntity)sessionFactory.getCurrentSession()
                    .get(ArticleEntity.class, id);
    }
     

}
