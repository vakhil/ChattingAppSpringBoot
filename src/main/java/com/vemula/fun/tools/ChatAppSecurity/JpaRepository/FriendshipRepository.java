package com.vemula.fun.tools.ChatAppSecurity.JpaRepository;

import com.vemula.fun.tools.ChatAppSecurity.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship,Integer> {
    List<Friendship> findByUserSender(String userSender);

}
