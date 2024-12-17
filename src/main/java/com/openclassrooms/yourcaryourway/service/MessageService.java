package com.openclassrooms.yourcaryourway.service;

import com.openclassrooms.yourcaryourway.controller.UserController;
import com.openclassrooms.yourcaryourway.entity.Message;
import com.openclassrooms.yourcaryourway.entity.User;
import com.openclassrooms.yourcaryourway.model.Conversation;
import com.openclassrooms.yourcaryourway.model.MessageDTO;
import com.openclassrooms.yourcaryourway.repository.MessageRepository;
import com.openclassrooms.yourcaryourway.session.ConnectedUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MessageService {

	private MessageRepository messageRepository;

	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(MessageService.class);

	public MessageService(MessageRepository messageRepository, UserService userService) {
		this.messageRepository = messageRepository;
		this.userService = userService;
	}

	// Récupérer tous les messages d'un utilisateur, étant donné son id, et les classer en ordre ...
//	public List<Message> getConversation(int id) {
//
//		// Récup
//		List<Message> receivedMessageList = messageRepository.findByRecipientId(id);
//		List<Message> sentMessageList = messageRepository.findBySenderId(id);
//
//		List<Message> messageList = new ArrayList<>();
//		messageList.addAll(receivedMessageList);
//		messageList.addAll(sentMessageList);
//
//		// Tri
//		Collections.sort(messageList);
//
//		// Set Conv
//		return messageList;
//
//	}


	// Fonctionne
//	public List<MessageDTO> getConversation(int id) {
//
//		// Récup
//		List<Message> receivedMessageList = messageRepository.findByRecipientId(id);
//		List<Message> sentMessageList = messageRepository.findBySenderId(id);
//
//		List<Message> messageList = new ArrayList<>();
//		messageList.addAll(receivedMessageList);
//		messageList.addAll(sentMessageList);
//
//		List<MessageDTO> messageListDto = new ArrayList<>();
//
//		for(Message m: messageList) {
//
//			MessageDTO messageDTO = new MessageDTO();
//			messageDTO.setDateHour(m.getDateHour());
//			messageDTO.setContent(m.getContent());
//			messageDTO.setRecipientId(m.getRecipientId());
//			messageDTO.setSenderId(m.getSenderId());
//
//			User recipient = this.userService.findById(m.getRecipientId());
//			messageDTO.setRecipientFullName(recipient.getFirstName() + " " + recipient.getLastName());
//
//			User sender = this.userService.findById(m.getSenderId());
//			messageDTO.setSenderFullName(sender.getFirstName() + " " + sender.getLastName());
//
//			messageListDto.add(messageDTO);
//		}
//
//		// Tri
//		Collections.sort(messageListDto);
//
//		// Set Conv
//		return messageListDto;
//	}

	// Dernier truc qui marchait
//	public List<MessageDTO> getConversation(int id) {
//
//		// Récup
//		List<Message> messageList = messageRepository.findBySenderIdOrRecipientId(id, id);
//
//		List<MessageDTO> messageListDto = new ArrayList<>();
//
//		for(Message m: messageList) {
//
//			MessageDTO messageDTO = new MessageDTO();
//			messageDTO.setDateHour(m.getDateHour());
//			messageDTO.setContent(m.getContent());
//			messageDTO.setRecipientId(m.getRecipientId());
//			messageDTO.setSenderId(m.getSenderId());
//
//			User recipient = this.userService.findById(m.getRecipientId());
//			messageDTO.setRecipientFullName(recipient.getFirstName() + " " + recipient.getLastName());
//
//			User sender = this.userService.findById(m.getSenderId());
//			messageDTO.setSenderFullName(sender.getFirstName() + " " + sender.getLastName());
//
//			messageListDto.add(messageDTO);
//		}
//
//		// Tri
//		Collections.sort(messageListDto);
//
//		// Set Conv
//		return messageListDto;
//	}

//	public List<MessageDTO> getConversation() {
//
//		// Récup
//
//		List<Message> messageList = messageRepository.findBySenderIdOrRecipientId(ConnectedUser.user.getId(), ConnectedUser.user.getId());
//
//		List<MessageDTO> messageListDto = new ArrayList<>();
//
//		for(Message m: messageList) {
//
//			MessageDTO messageDTO = new MessageDTO();
//			messageDTO.setDateHour(m.getDateHour());
//			messageDTO.setContent(m.getContent());
//			messageDTO.setRecipientId(m.getRecipientId());
//			messageDTO.setSenderId(m.getSenderId());
//			messageDTO.setSenderEmail(ConnectedUser.user.getEmail());
//
//			User recipient = this.userService.findById(m.getRecipientId());
//			messageDTO.setRecipientFullName(recipient.getFirstName() + " " + recipient.getLastName());
//
//			User sender = this.userService.findById(m.getSenderId());
//			messageDTO.setSenderFullName(sender.getFirstName() + " " + sender.getLastName());
//
//			messageListDto.add(messageDTO);
//		}
//
//		// Tri
//		Collections.sort(messageListDto);
//
//		// Set Conv
//		return messageListDto;
//	}

	public List<MessageDTO> getConversation(String email) {

		if(email.equals("deconnect")) {
			return new ArrayList<MessageDTO>();
		}
		// Récup

		User user = userService.findByEmail(email);
		int id = user.getId();

		List<Message> messageList = messageRepository.findBySenderIdOrRecipientId(id, id);

		List<MessageDTO> messageListDto = new ArrayList<>();

		for(Message m: messageList) {

			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setDateHour(m.getDateHour());
			messageDTO.setContent(m.getContent());
			messageDTO.setRecipientId(m.getRecipientId());
			messageDTO.setSenderId(m.getSenderId());
			messageDTO.setSenderEmail(user.getEmail());

			User recipient = this.userService.findById(m.getRecipientId());
			messageDTO.setRecipientFullName(recipient.getFirstName() + " " + recipient.getLastName());

			User sender = this.userService.findById(m.getSenderId());
			messageDTO.setSenderFullName(sender.getFirstName() + " " + sender.getLastName());

			messageListDto.add(messageDTO);
		}

		// Tri
		Collections.sort(messageListDto);

		// Set Conv
		return messageListDto;
	}

	public Message sendMessage(Message message, String email) {
		message.setSenderId(userService.findByEmail(email).getId());
		return messageRepository.save(message);
	}
}
