package com.chatapp.chatapi.model;

import com.chatapp.chatapi.enumerators.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message { // Modelo recebido pela requisição com informações necessárias para mensagem
    
    private String senderName; // Usuário que enviou a mensagem
    private String receiverName; // Usuário que irá receber a mensagem
    private String message; // Mensagem
    private String date; // Data da mensagem
    private Status status; // Status usado no Enumerator próprio ('JOIN', 'MESSAGE', 'LEAVE')
}
