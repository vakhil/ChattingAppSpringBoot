package com.vemula.fun.tools.ChatAppSecurity.Controller;

import com.vemula.fun.tools.ChatAppSecurity.models.Message;
import com.vemula.fun.tools.ChatAppSecurity.models.MessageUIModel;
import com.vemula.fun.tools.ChatAppSecurity.models.ModelConverter;
import com.vemula.fun.tools.ChatAppSecurity.models.User;
import com.vemula.fun.tools.ChatAppSecurity.service.MessageService;
import com.vemula.fun.tools.ChatAppSecurity.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;


    @GetMapping("/message")
    public String getMessageHistory(@RequestParam(name = "receive") String receive, Model model) throws Exception {
        //Fetch chats between the users

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //Fetch Profile Pictures for the current sender and also the receiver
        Optional<User> userProfile = userService.findUserByUserName(currentPrincipalName);
        String base64EncodedUserProfile = Base64.encodeBase64String(userProfile.get().getProfilePicture());

        Optional<User> receiveProfile = userService.findUserByUserName(receive);
        String base64EncodedReceiveProfile = Base64.encodeBase64String(receiveProfile.get().getProfilePicture());


        List<Message> chatHistory = messageService.findChatsForUserAndReceipient(currentPrincipalName,receive);
        List<MessageUIModel> messageUIModelList = chatHistory.stream().map(message -> {
            return ModelConverter.convertMessageRequest(message,currentPrincipalName,base64EncodedUserProfile,
                    base64EncodedReceiveProfile);
        }).collect(Collectors.toList());
        model.addAttribute("chats",messageUIModelList);

        return "chatScreen";
    }




}
