package net.kiel.cafe.repository.hibernate;

import java.util.List;

import net.kiel.cafe.entity.Cafe;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

//@Repository
public class CafeRepositoryImpl {
  //  @Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public List<Cafe> selectAll() {
        return (List<Cafe>)sessionFactory.getCurrentSession().createQuery("From CafeEntity").list();
    }

    @SuppressWarnings("unchecked")
    public List<Cafe> selectByCategoryId(Integer categoryId) {

        return (List<Cafe>)sessionFactory.getCurrentSession()
                            .createQuery("From CafeEntity as cafe WHERE cafe.category.id = :categoryId")
                            .setParameter("categoryId", categoryId)
                            .list();        
    }
    
    public Cafe selectById(Integer id) {
        return (Cafe)sessionFactory.getCurrentSession()
                        .get(Cafe.class, id);
    }   
    
    public Cafe selectByNickname(String nickname) {
        return (Cafe)sessionFactory.getCurrentSession()
                        .createCriteria(Cafe.class)
                        .add(Restrictions.eq("nickname", nickname))
                        .uniqueResult();
    }
}