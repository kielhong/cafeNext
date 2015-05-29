package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.CafeUser.Role;

import net.kiel.cafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CafeUserRepository extends JpaRepository<CafeUser, Long>{
    List<CafeUser> findByCafeId(Integer cafeId);
    
    List<CafeUser> findByCafeIdAndRole(Integer cafeId, Role role);

    CafeUser findOneByCafeAndUser(Cafe cafe, User user);

    @Query("SELECT case when count(cu) > 0 then true else false end FROM CafeUser cu WHERE cu.cafe = ?1 and cu.user = ?2")
    Boolean existsByCafeAndUser(Cafe cafe, User user);
}
