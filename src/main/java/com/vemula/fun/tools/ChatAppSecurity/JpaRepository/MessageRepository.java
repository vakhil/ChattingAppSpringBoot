package com.vemula.fun.tools.ChatAppSecurity.JpaRepository;

import com.vemula.fun.tools.ChatAppSecurity.models.Message;
import com.vemula.fun.tools.ChatAppSecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    Optional<Message> findByMessage(String message);
    List<Message> findBySenderAndRecipient(String sender, String recipient);


    @Query("SELECT u FROM Message u WHERE (u.sender = ?1 and u.recipient = ?2) OR (u.sender = ?2 and u.recipient = ?1) ORDER BY u.id")
    List<Message> findAllConversation(String sender, String recipient);

}
