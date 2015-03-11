package net.kiel.cafe.repository;

import net.kiel.cafe.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Integer>{

}
