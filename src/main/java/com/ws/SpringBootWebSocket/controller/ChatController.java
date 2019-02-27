package com.ws.SpringBootWebSocket.controller;

import com.ws.SpringBootWebSocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.registration")
    @SendTo("/room/public")
    public Message registration(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",message.getSender());
        return message;
    }

    @MessageMapping("/chat.send")
    @SendTo("/room/public")
    public Message sendMessage(@Payload Message message){
        return message;
    }

}
