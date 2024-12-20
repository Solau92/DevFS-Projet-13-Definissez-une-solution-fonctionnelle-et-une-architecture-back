package com.openclassrooms.yourcaryourway.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MessageDTO implements Comparable<Object>{

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime dateHour;

	private int senderId;
	private String senderFullName;

	private int recipientId;
	private String recipientFullName;

	private String content;

	private String senderEmail;

	public LocalDateTime getDateHour() {
		return dateHour;
	}

	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getSenderFullName() {
		return senderFullName;
	}

	public void setSenderFullName(String senderFullName) {
		this.senderFullName = senderFullName;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public String getRecipientFullName() {
		return recipientFullName;
	}

	public void setRecipientFullName(String recipientFullName) {
		this.recipientFullName = recipientFullName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	@Override
	public int compareTo(Object o) {
		MessageDTO m = (MessageDTO) o;
		return this.dateHour.compareTo(m.dateHour);
	}
}

