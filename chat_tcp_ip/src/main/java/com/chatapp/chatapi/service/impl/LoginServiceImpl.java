package com.chatapp.chatapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.chatapi.exception.ResourceNotFoundException;
import com.chatapp.chatapi.model.LoginRequest;
import com.chatapp.chatapi.service.LoginService;
import com.chatapp.chatapi.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public void autenticate(LoginRequest loginRequest) {
        
        var user = userService.getUserByLogin(loginRequest.getUsername(), loginRequest.getPassword());

        if (user == null)
            throw new ResourceNotFoundException("Login e/ou senha inválidos");
    }
}
