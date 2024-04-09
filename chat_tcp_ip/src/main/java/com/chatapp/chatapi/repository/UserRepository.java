package com.chatapp.chatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chatapp.chatapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("FROM #{entityName} WHERE username = ?1 AND password = ?2")
    User getUserByLogin(String username, String password);
}
