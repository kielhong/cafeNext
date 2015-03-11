package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.ArticleEntity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
  //  @Autowired
    private SessionFactory sessionFactory;
        
    @SuppressWarnings("unchecked")
    public List<ArticleEntity> selectListByCafe(Integer cafeId) {        
        return (List<ArticleEntity>)sessionFactory.getCurrentSession()
                .createQuery("From ArticleEntity as article WHERE article.board.cafe.id = :cafeId ORDER BY id DESC")
                .setParameter("cafeId", cafeId)
                .list();        
    }
    
    public Long selectCountByCafe(Integer cafeId) {
        Query query = sessionFactory.getCurrentSession()
                        .createQuery("SELECT count(*) FROM ArticleEntity as article WHERE article.board.cafe.id = :cafeId");
        
        return (Long)query.setParameter("cafeId", cafeId).uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<ArticleEntity> selectListByBoard(Integer boardId) {
        
        return (List<ArticleEntity>)sessionFactory.getCurrentSession()
                .createQuery("From ArticleEntity as article WHERE article.board.id = :boardId ORDER BY id DESC")
                .setParameter("boardId", boardId)
                .list();        
    }
    
    public Integer selectCountByBoard(Integer boardId) {
        Query query = sessionFactory.getCurrentSession()
                        .createQuery("SELECT count(*) FROM ArticleEntity as article WHERE article.board.id = :boardId");
        
        return (Integer)query.setParameter("boardId", boardId).uniqueResult();
    }
    
    public ArticleEntity selectById(Integer id) {
        return (ArticleEntity)sessionFactory.getCurrentSession()
                    .get(ArticleEntity.class, id);
    }
     
    public void update(ArticleEntity article) {
        Session session = sessionFactory.getCurrentSession();
        session.update(article);
    }

}
