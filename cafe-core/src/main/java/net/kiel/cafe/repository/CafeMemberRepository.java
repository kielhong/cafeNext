package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.entity.RoleEntity.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeMemberRepository {
  //  @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public List<CafeMember> selectListByCafe(Integer cafeId) {
        return (List<CafeMember>)sessionFactory.getCurrentSession()
                        .createQuery("FROM CafeMemberEntity as cafeMember WHERE cafeMember.cafe.id = :cafeId")
                        .setParameter("cafeId", cafeId)
                        .list();
    }
    
    
    public CafeMember selectCafeManager(Integer cafeId) {
        return (CafeMember)sessionFactory.getCurrentSession()
                .createQuery("FROM CafeMemberEntity as cafeMember WHERE cafeMember.cafe.id = :cafeId AND cafeMember.role.role = :role")
                .setParameter("cafeId", cafeId)
                .setParameter("role", Role.MANAGER)
                .uniqueResult();
    }
    
}
