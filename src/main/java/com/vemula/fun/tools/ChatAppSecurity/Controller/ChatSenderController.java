package com.vemula.fun.tools.ChatAppSecurity.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatSenderController {

    @MessageMapping("/chates")
    @SendTo("/topic/chats")
    public String broadcastNews(@Payload String message) {
        return "Hey " + message;
    }

}
