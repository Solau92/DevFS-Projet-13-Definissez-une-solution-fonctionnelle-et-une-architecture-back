package com.openclassrooms.yourcaryourway.service;

import com.openclassrooms.yourcaryourway.controller.UserController;
import com.openclassrooms.yourcaryourway.entity.User;
import com.openclassrooms.yourcaryourway.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(int id) {
		Optional<User> optuser = userRepository.findById(id);
		User user = optuser.get();
		return user;
	}

	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		log.info("User dans service : " + user);
		return user;
	}
}
