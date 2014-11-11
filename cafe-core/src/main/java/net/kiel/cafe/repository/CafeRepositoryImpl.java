package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeEntity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeRepositoryImpl implements CafeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<CafeEntity> selectAll() {
        return (List<CafeEntity>)sessionFactory.getCurrentSession().createQuery("From CafeEntity").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CafeEntity> selectByCategoryId(Integer categoryId) {

        return (List<CafeEntity>)sessionFactory.getCurrentSession()
                            .createQuery("From CafeEntity as cafe WHERE cafe.category.id = :categoryId")
                            .setParameter("categoryId", categoryId)
                            .list();        
    }

}