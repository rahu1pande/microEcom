package com.userService.repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userService.entity.Userss;

@Repository
public interface UserRepository extends JpaRepository<Userss, Integer> {
	    Optional<Userss> findByEmail(String email);
}

