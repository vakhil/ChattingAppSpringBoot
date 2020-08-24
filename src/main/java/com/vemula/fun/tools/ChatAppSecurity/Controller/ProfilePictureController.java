package com.vemula.fun.tools.ChatAppSecurity.Controller;

import com.vemula.fun.tools.ChatAppSecurity.models.ProfilePictureModel;
import com.vemula.fun.tools.ChatAppSecurity.models.User;
import com.vemula.fun.tools.ChatAppSecurity.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProfilePictureController {

    @Autowired
    UserService userService;

    @GetMapping("/profileImage")
    public ProfilePictureModel getProfilePictureSenderReceiver(@RequestParam(name = "receive") String receive){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<User> userProfile = userService.findUserByUserName(currentPrincipalName);
        String base64EncodedUserProfile = Base64.encodeBase64String(userProfile.get().getProfilePicture());

        Optional<User> receiveProfile = userService.findUserByUserName(receive);
        String base64EncodedReceiveProfile = Base64.encodeBase64String(receiveProfile.get().getProfilePicture());
        return new ProfilePictureModel(base64EncodedUserProfile,base64EncodedReceiveProfile);
    }

}
