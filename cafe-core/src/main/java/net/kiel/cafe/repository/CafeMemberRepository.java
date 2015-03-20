package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.CafeMember;
import net.kiel.cafe.entity.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeMemberRepository extends JpaRepository<CafeMember, Long>{
    List<CafeMember> findByCafeId(Integer cafeId);
    
    List<CafeMember> findByCafeIdAndRoleRole(Integer cafeId, RoleEntity.Role role);
}
