package com.chatapp.chatapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.chatapp.chatapi.exception.model.ErrorDetails;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails exception(Exception e, WebRequest request) {
        return new ErrorDetails(e.getMessage(), request.getDescription(false));
    }
}