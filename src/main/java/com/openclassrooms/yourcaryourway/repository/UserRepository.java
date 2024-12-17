package com.openclassrooms.yourcaryourway.repository;

import com.openclassrooms.yourcaryourway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

	public User findByEmail(String email);
}
