package com.vemula.fun.tools.ChatAppSecurity.service;

import com.vemula.fun.tools.ChatAppSecurity.models.Message;
import com.vemula.fun.tools.ChatAppSecurity.models.MessageRequest;

import java.util.List;

public interface MessageService {
    void save(MessageRequest messageRequest);
    List<Message> findChatsForUserAndReceipient(String sender, String receipient);
    List<Message> findChatsForSingleUser(String user);
}
