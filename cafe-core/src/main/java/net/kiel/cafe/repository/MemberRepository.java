package net.kiel.cafe.repository;

import net.kiel.cafe.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<User, Integer>{

}
