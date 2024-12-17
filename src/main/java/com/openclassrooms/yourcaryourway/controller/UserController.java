package com.openclassrooms.yourcaryourway.controller;

import com.openclassrooms.yourcaryourway.entity.Message;
import com.openclassrooms.yourcaryourway.entity.User;
import com.openclassrooms.yourcaryourway.service.UserService;
import com.openclassrooms.yourcaryourway.session.ConnectedUser;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;

@Controller
public class UserController {

	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);


	public UserController(UserService userService) {
		this.userService = userService;
	}

	/** A supprimer : pour tester **/
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		return ResponseEntity.status(ACCEPTED).body(userService.findAll());
	}

	@GetMapping("/user")
	public ResponseEntity<User> findUserByEmail(@RequestBody User useruser) {
		User user = userService.findByEmail(useruser.getEmail());
		log.info("email : " + useruser.getEmail());
		log.info("User dans service : " + String.valueOf(user));
		return ResponseEntity.status(ACCEPTED).body(userService.findByEmail(useruser.getEmail()));
	}

	// TODO : A supprimer pour tester
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUserById(@PathVariable int id) {
		User user = userService.findById(id);
		log.info("User by id dans service : " + String.valueOf(user));
		return ResponseEntity.status(ACCEPTED).body(userService.findById(id));
	}

//	@CrossOrigin
//	@PostMapping("/connect")
//	public ResponseEntity<User> connect(@RequestBody Message message) {
//		log.info("/connect : " + message.getContent());
//		User userFound = userService.findByEmail(message.getContent());
//		ConnectedUser.setUser(userFound);
//		log.info("Connected user email : " + ConnectedUser.getUser().getEmail());
//		return ResponseEntity.status(ACCEPTED).body(userFound);
//	}

	@CrossOrigin
	@PostMapping("/connect")
	public ResponseEntity<User> connect(@RequestBody String email) {
		User userFound = userService.findByEmail(email);
		return ResponseEntity.status(ACCEPTED).body(userFound);
	}

	@CrossOrigin
	@PostMapping("/deconnect")
	public ResponseEntity<Void> deconnect(@RequestBody Message message) {
		log.info("/deconnect : " + message.getContent());
		User userFound = userService.findByEmail(message.getContent());
		ConnectedUser.setUser(new User());
		return new ResponseEntity<>(ACCEPTED);
	}
}
