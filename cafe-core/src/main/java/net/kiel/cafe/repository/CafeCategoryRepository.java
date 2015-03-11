package net.kiel.cafe.repository;

import net.kiel.cafe.entity.CafeCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeCategoryRepository extends JpaRepository<CafeCategory, Integer>{

}
