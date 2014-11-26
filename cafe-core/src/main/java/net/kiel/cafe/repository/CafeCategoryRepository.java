package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeCategoryEntity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeCategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public List<CafeCategoryEntity> selectAll() {
        return (List<CafeCategoryEntity>)sessionFactory.getCurrentSession().createQuery("FROM CafeCategoryEntity").list();
    }

}
