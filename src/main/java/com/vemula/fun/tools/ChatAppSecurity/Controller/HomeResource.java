package com.vemula.fun.tools.ChatAppSecurity.Controller;

import com.vemula.fun.tools.ChatAppSecurity.JpaRepository.FriendshipRepository;
import com.vemula.fun.tools.ChatAppSecurity.models.*;
import com.vemula.fun.tools.ChatAppSecurity.service.MessageService;
import com.vemula.fun.tools.ChatAppSecurity.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class HomeResource {

    @Autowired
    FriendshipRepository friendshipRepository;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public String home(Model model) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //Write code for fetching friends from DB
        List<Friendship> friends =  friendshipRepository.findByUserSender(currentPrincipalName);
        List<FriendNameProfile> friendNameProfiles = new ArrayList<>();
        Map<String,List<Message>> chatHistory = new HashMap<>();
        for (Friendship friend : friends) {
            //Fetch profile picture for the friend
            Optional<User> user = userService.findUserByUserName(friend.getUserReceipient());
            String base64EncodedImage = Base64.encodeBase64String(user.get().getProfilePicture());
            friendNameProfiles.add(new FriendNameProfile(friend.getUserReceipient(),base64EncodedImage));
//            List<Message> chatBetweenFriends = messageService.findChatsForUserAndReceipient(currentPrincipalName,receive);
//            chatHistory.put(friend.getUserReceipient(),chatBetweenFriends);
        }
        model.addAttribute("friends",friendNameProfiles);
//        model.addAttribute("chatHistory",chatHistory);


        //Write code for fetching all friends chats and passign it to browser !!!
        //The model would pass to a javascript function which would take care !!
        List<Message> chatBetweenFriends = messageService.findChatsForSingleUser(currentPrincipalName);

        //Should be a Map of String and an ArrayList cause i need to maintain an order
        Map<String,List<Message>> chatUIModel = new HashMap<>();
        for (Message message : chatBetweenFriends){
            if( message.getSender() == currentPrincipalName){
                if(chatUIModel.get(currentPrincipalName) == null){
                    List<Message> messageArrayList = new ArrayList<>();
                    messageArrayList.add(message);
                    chatUIModel.put(message.getRecipient(),messageArrayList);
                } else {
                    chatUIModel.get(message.getRecipient()).add(message);
                    //chatUIModel.put(message.getRecipient(),chatUIModel.get(message.getRecipient()).add(message));
                }
            }else {
                if(chatUIModel.get(currentPrincipalName) == null){
                    List<Message> messageArrayList = new ArrayList<>();
                    messageArrayList.add(message);
                    chatUIModel.put(message.getSender(),messageArrayList);
                } else {
                    chatUIModel.get(message.getSender()).add(message);
                    //chatUIModel.put(message.getRecipient(),chatUIModel.get(message.getRecipient()).add(message));
                }

            }
        }
        model.addAttribute("chatHistory",chatUIModel);
        return "friends";
    }

    //Wrrite code for receving some text from text message bar and persisting it in DB
    @PostMapping("/send/message")
    public String writeMessage(@RequestBody MessageRequest messageRequest  ){

        return "akhil";
    }
    
}
