package com.chatapp.chatapi.service;

import com.chatapp.chatapi.model.LoginRequest;

public interface LoginService {
    
    void autenticate(LoginRequest loginRequest);
}
