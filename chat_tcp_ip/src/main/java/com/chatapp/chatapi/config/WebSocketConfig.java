package com.chatapp.chatapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //Classe de configuração de prefixos do WebSocket

    //Esse método é usado para configurar o broker de mensagens WebSocket. 
    //No caso, está definindo os prefixos de destino e aplicativo e habilitando um broker de mensagens simples com os prefixos '/chatRoom' e '/user'
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/chatRoom", "/user");
        registry.setUserDestinationPrefix("/user");
	}

    // Este método é usado para registrar os endpoints STOMP (Simple Text Oriented Messaging Protocol).
    // Estamos configurando um endpoint /ws e permitindo todas as origens (*) usando o método setAllowedOriginPatterns("*"). 
    // Além disso, estamos habilitando o suporte a SockJS neste endpoint com withSockJS(). Isso permite que o cliente se comunique com o servidor WebSocket, mesmo se o WebSocket nativo não estiver disponível no cliente ou no servidor.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
	}
}