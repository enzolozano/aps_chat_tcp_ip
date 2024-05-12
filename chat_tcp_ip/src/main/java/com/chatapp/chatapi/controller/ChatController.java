package com.chatapp.chatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chatapp.chatapi.model.Message;

@Controller
public class ChatController { // Esta classe é um controlador que lida com mensagens WebSocket no contexto de um bate-papo (chat)

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; // Classe responsável para enviar mensagens para destinos específicos no sistema de mensagens.

    @MessageMapping("/message") // Essa anotação mapeia mensagens WebSocket no destino '/message' para o método receivePublicMessage(). Sempre que uma mensagem é enviada nesse prefixo, o método é invocado.
    @SendTo("/chatRoom/public") // Essa anotação indica para onde a mensagem processada pelo método receivePublicMessage() deve ser enviada.
    public Message receivePublicMessage(@Payload Message message) { // Esse método recebe o objeto de mensagem como parâmetro, processa-a e retorna a mesma mensagem, sendo usado para o chat público geral.
        return message;
    }

    @MessageMapping("privateMessage") // Esta anotação mapeia mensagens WebSocket recebidas no destino '/privateMessage' para o método receivePrivateMessage()
    public Message receivePrivateMessage(@Payload Message message) {  // Este método é invocado quando uma mensagem é recebida no destino /privateMessage. Ele recebe a mensagem como parâmetro, processa-a e a encaminha para o usuário específico usando o SimpMessagingTemplate. O destino para este envio é construído dinamicamente usando o nome do destinatário extraído da mensagem recebida.
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        return message; // Depois de processar a mensagem, o método retorna a mesma mensagem.
    }
}
