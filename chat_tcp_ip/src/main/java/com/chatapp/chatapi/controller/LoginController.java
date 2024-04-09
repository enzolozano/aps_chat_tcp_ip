package com.chatapp.chatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.chatapi.model.LoginRequest;
import com.chatapp.chatapi.service.LoginService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest) throws Exception {
        
        loginService.autenticate(loginRequest);

        return new ResponseEntity<>("Autenticação realizada com sucesso!", HttpStatus.OK);
    }    
}
