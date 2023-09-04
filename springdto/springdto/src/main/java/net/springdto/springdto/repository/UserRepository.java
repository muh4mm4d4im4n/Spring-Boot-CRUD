package net.springdto.springdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springdto.springdto.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
