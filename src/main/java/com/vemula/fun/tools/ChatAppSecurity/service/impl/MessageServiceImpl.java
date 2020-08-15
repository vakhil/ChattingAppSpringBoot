package com.vemula.fun.tools.ChatAppSecurity.service.impl;

import com.vemula.fun.tools.ChatAppSecurity.JpaRepository.MessageRepository;
import com.vemula.fun.tools.ChatAppSecurity.models.Message;
import com.vemula.fun.tools.ChatAppSecurity.models.MessageRequest;
import com.vemula.fun.tools.ChatAppSecurity.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void save(MessageRequest messageRequest) {
        Message message = new Message(messageRequest.getMessageFrom(),messageRequest.getMessageTo(),messageRequest.getMessage(),
                messageRequest.getBlob(),messageRequest.getMediaType());
        messageRepository.save(message);
    }

    @Override
    public List<Message> findChatsForUserAndReceipient(String sender, String receipient) {
        List<Message> chats = messageRepository.findAllConversation(sender,receipient);
//        List<Message> chats = messageRepository.findBySenderAndRecipient(sender,receipient);
        return chats;

    }




}
