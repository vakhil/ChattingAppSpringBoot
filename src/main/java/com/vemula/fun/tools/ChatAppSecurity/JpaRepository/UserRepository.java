package com.vemula.fun.tools.ChatAppSecurity.JpaRepository;

import com.vemula.fun.tools.ChatAppSecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserName(String userName);
}
