package com.vemula.fun.tools.ChatAppSecurity.service.impl;

import com.vemula.fun.tools.ChatAppSecurity.DTO.UserRegistrationDTO;
import com.vemula.fun.tools.ChatAppSecurity.JpaRepository.UserRepository;
import com.vemula.fun.tools.ChatAppSecurity.models.User;
import com.vemula.fun.tools.ChatAppSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDTO userRegistrationDTO) throws Exception {
        User user = new User(userRegistrationDTO.getUsername(),userRegistrationDTO.getPassword(),userRegistrationDTO.getFile().getBytes(),"ROLE_USER",true);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        return user;
    }
}
