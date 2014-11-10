package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.domain.Cafe;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeRepositoryImpl implements CafeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Cafe> selectAll() {
        return (List<Cafe>)sessionFactory.getCurrentSession().createQuery("From Cafe").list();
    }

}