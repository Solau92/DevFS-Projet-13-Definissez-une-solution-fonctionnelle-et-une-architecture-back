package com.openclassrooms.yourcaryourway.controller;

import com.openclassrooms.yourcaryourway.entity.Message;
import com.openclassrooms.yourcaryourway.model.MessageDTO;
import com.openclassrooms.yourcaryourway.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MessageController {

	private MessageService messageService;

	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@CrossOrigin
	@GetMapping("/conversation/{email}")
	public ResponseEntity<List<MessageDTO>> findConversation(@PathVariable String email) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(messageService.getConversation(email));
	}

	@CrossOrigin
	@PostMapping("message/send")
	public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO messagedto) {

		Message message = new Message();
		message.setContent(messagedto.getContent());
		message.setDateHour(LocalDateTime.now());

		if(!messagedto.getSenderEmail().equals("email@serviceclient.com")) {
			message.setRecipientId(1);
		} else {
			message.setRecipientId(2);
		}

		message.setStatus("send");
		return ResponseEntity.status(HttpStatus.CREATED).body(messageService.sendMessage(message, messagedto.getSenderEmail()));
	}

}
