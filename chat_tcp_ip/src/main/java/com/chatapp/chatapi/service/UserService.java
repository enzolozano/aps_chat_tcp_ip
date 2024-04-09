package com.chatapp.chatapi.service;

import com.chatapp.chatapi.entity.User;

public interface UserService {
    
    User getUserByLogin(String username, String password);
}
