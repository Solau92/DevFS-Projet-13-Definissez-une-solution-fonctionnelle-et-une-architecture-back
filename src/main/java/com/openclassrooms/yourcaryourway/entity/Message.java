package com.openclassrooms.yourcaryourway.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="message")
@DynamicUpdate
public class Message implements Comparable<Object>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime dateHour;

	@Column(nullable = false)
	private int senderId;

	@Column(nullable = false)
	private int recipientId;

	@Column(nullable = false)
	private String content;

	// TODO : change String to enum ?
//	@Column(nullable = false)
	@Column
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(Object o) {
		Message m = (Message) o;
		return this.dateHour.compareTo(m.dateHour);
	}
}
