package net.kiel.cafe.repository;

import net.kiel.cafe.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer>{
    User findByUsername(String username);
}
