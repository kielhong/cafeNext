package net.kiel.cafe.repository.hibernate;

import java.util.List;

import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.CafeUser.Role;

import org.hibernate.SessionFactory;

//@Repository
@Deprecated
public class CafeMemberRepositoryImpl {
  //  @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public List<CafeUser> selectListByCafe(Integer cafeId) {
        return (List<CafeUser>)sessionFactory.getCurrentSession()
                        .createQuery("FROM CafeMemberEntity as cafeMember WHERE cafeMember.cafe.id = :cafeId")
                        .setParameter("cafeId", cafeId)
                        .list();
    }
    
    
    public CafeUser selectCafeManager(Integer cafeId) {
        return (CafeUser)sessionFactory.getCurrentSession()
                .createQuery("FROM CafeMemberEntity as cafeMember WHERE cafeMember.cafe.id = :cafeId AND cafeMember.role = :role")
                .setParameter("cafeId", cafeId)
                .setParameter("role", Role.MANAGER)
                .uniqueResult();
    }
    
}
