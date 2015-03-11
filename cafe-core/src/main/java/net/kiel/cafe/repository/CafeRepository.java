package net.kiel.cafe.repository;

import java.util.List;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.CafeCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Integer>{
    Cafe findByDomain(String domain);
    
    List<Cafe> findByCategory(CafeCategory category);
}
