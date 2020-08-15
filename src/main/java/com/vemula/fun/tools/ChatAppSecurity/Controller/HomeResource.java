package com.vemula.fun.tools.ChatAppSecurity.Controller;

import com.vemula.fun.tools.ChatAppSecurity.JpaRepository.FriendshipRepository;
import com.vemula.fun.tools.ChatAppSecurity.models.FriendNameProfile;
import com.vemula.fun.tools.ChatAppSecurity.models.Friendship;
import com.vemula.fun.tools.ChatAppSecurity.models.MessageRequest;
import com.vemula.fun.tools.ChatAppSecurity.models.User;
import com.vemula.fun.tools.ChatAppSecurity.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeResource {

    @Autowired
    FriendshipRepository friendshipRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(Model model) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        //Write code for fetching friends from DB
        List<Friendship> friends =  friendshipRepository.findByUserSender(currentPrincipalName);
        List<FriendNameProfile> friendNameProfiles = new ArrayList<>();
        for (Friendship friend : friends) {
            //Fetch profile picture for the friend
            Optional<User> user = userService.findUserByUserName(friend.getUserReceipient());
            String base64EncodedImage = Base64.encodeBase64String(user.get().getProfilePicture());
            friendNameProfiles.add(new FriendNameProfile(friend.getUserReceipient(),base64EncodedImage));
        }
        model.addAttribute("friends",friendNameProfiles);
        return "friends";
    }

    //Wrrite code for receving some text from text message bar and persisting it in DB
    @PostMapping("/send/message")
    public String writeMessage(@RequestBody MessageRequest messageRequest  ){

        return "akhil";
    }
    
}
