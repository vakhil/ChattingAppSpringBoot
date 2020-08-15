package com.vemula.fun.tools.ChatAppSecurity.models;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.text.SimpleDateFormat;

public class ModelConverter {

    public static MessageUIModel convertMessageRequest(Message message, String currentPrincipalName,
                                                       String userProfilePicture, String receiveProfilePicture){
        MessageUIModel messageUIModel = new MessageUIModel();
        if(message.getSender().equals(currentPrincipalName)){
            messageUIModel.setUserProfilePicture(userProfilePicture);
            messageUIModel.setMessageDirection(0);
        }else {
            messageUIModel.setReceiveProfilePicture(receiveProfilePicture);
            messageUIModel.setMessageDirection(1);
        }
        messageUIModel.setMessage(message.getMessage());
        messageUIModel.setSeen(message.getSeen());
        messageUIModel.setMediaType(message.getMediaType());
        messageUIModel.setImageBlob(message.getImageBlob());
        messageUIModel.setTimestamp((new SimpleDateFormat("HH:mm a").format(message.getTimestamp())).toString());
        return messageUIModel;
    }

    public static MessageRequest buildMessageRequest(String chatMessage, String chatReceipient, Principal principal){
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMediaType("text");
        messageRequest.setMessage(chatMessage);
        messageRequest.setMessageFrom(principal.getName());
        messageRequest.setMessageTo(chatReceipient);
        return messageRequest;
    }
}
