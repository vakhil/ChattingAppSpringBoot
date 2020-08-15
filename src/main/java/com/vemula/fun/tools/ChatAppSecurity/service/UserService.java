package com.vemula.fun.tools.ChatAppSecurity.service;

import com.vemula.fun.tools.ChatAppSecurity.DTO.UserRegistrationDTO;
import com.vemula.fun.tools.ChatAppSecurity.models.User;

import java.util.Optional;

public interface UserService  {
    User save(UserRegistrationDTO userRegistrationDTO) throws Exception;
    Optional<User> findUserByUserName(String userName);
}
