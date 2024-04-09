package com.chatapp.chatapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.chatapi.entity.User;
import com.chatapp.chatapi.repository.UserRepository;
import com.chatapp.chatapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByLogin(String username, String password) {
        
        return userRepository.getUserByLogin(username, password);
    }
}
