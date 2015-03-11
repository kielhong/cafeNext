package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeMemberEntity;
import net.kiel.cafe.entity.RoleEntity.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeMemberRepository {
  //  @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public List<CafeMemberEntity> selectListByCafe(Integer cafeId) {
        return (List<CafeMemberEntity>)sessionFactory.getCurrentSession()
                        .createQuery("FROM CafeMemberEntity as cafeMember WHERE cafeMember.cafe.id = :cafeId")
                        .setParameter("cafeId", cafeId)
                        .list();
    }
    
    
    public CafeMemberEntity selectCafeManager(Integer cafeId) {
        return (CafeMemberEntity)sessionFactory.getCurrentSession()
                .createQuery("FROM CafeMemberEntity as cafeMember WHERE cafeMember.cafe.id = :cafeId AND cafeMember.role.role = :role")
                .setParameter("cafeId", cafeId)
                .setParameter("role", Role.MANAGER)
                .uniqueResult();
    }
    
}
