package com.vemula.fun.tools.ChatAppSecurity.Controller;

import com.vemula.fun.tools.ChatAppSecurity.DTO.UserRegistrationDTO;
import com.vemula.fun.tools.ChatAppSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO(){return new UserRegistrationDTO();}

    @GetMapping
    public String showRegistrationForm(){return "registration";}

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO) throws Exception {
        userService.save(userRegistrationDTO);
        return "redirect:/registration?success";
    }
}
