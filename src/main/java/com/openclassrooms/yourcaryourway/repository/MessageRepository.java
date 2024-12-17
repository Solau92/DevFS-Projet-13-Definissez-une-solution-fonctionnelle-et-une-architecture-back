package com.openclassrooms.yourcaryourway.repository;

import com.openclassrooms.yourcaryourway.entity.Message;
import com.openclassrooms.yourcaryourway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer>, JpaSpecificationExecutor<Message> {

//	public List<Message> findBySenderId(int id);
//
//	public List<Message> findByRecipientId(int id);

	public List<Message> findBySenderIdOrRecipientId(int senderId, int recipientId);

}
