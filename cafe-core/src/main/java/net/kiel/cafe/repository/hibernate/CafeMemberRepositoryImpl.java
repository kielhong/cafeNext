package net.kiel.cafe.repository.hibernate;

import java.util.List;

import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.entity.RoleEntity.Role;

import org.hibernate.SessionFactory;

//@Repository
@Deprecated
public class CafeMemberRepositoryImpl {
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
