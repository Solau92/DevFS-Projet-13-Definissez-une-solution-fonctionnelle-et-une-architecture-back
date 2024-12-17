package com.openclassrooms.yourcaryourway.model;

import com.openclassrooms.yourcaryourway.entity.Message;

import java.util.List;

public class Conversation {

	private List<Message> messages;

	public Conversation(List<Message> messages) {
		this.messages = messages;
	}
}
