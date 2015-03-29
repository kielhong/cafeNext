package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeUser;
import net.kiel.cafe.entity.CafeUser.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeUserRepository extends JpaRepository<CafeUser, Long>{
    List<CafeUser> findByCafeId(Integer cafeId);
    
    List<CafeUser> findByCafeIdAndRole(Integer cafeId, Role role);
}
