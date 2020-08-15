package com.vemula.fun.tools.ChatAppSecurity.Controller;

import com.google.gson.Gson;
import com.vemula.fun.tools.ChatAppSecurity.models.MessageRequest;
import com.vemula.fun.tools.ChatAppSecurity.models.ModelConverter;
import com.vemula.fun.tools.ChatAppSecurity.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Map;

@Controller
public class PersonalChatController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessageService messageService;

    @MessageMapping("/chats")
    //@SendTo("/queue/chats")
    public String sendNews(@Payload String message, Principal principal) {
        String chatReceipient = new Gson().fromJson(message, Map.class).get("name").toString();
        String chatMessage = new Gson().fromJson(message, Map.class).get("message").toString();

        //Persist Data in DB
        messageService.save(ModelConverter.buildMessageRequest(chatMessage,chatReceipient,principal));
        simpMessagingTemplate.convertAndSendToUser(chatReceipient,"/queue/chats",chatMessage);
        return  chatMessage;

    }

}


///user/queue/reply