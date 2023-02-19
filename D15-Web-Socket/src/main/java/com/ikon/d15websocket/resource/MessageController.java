package com.ikon.d15websocket.resource;

import com.ikon.d15websocket.model.MessageIn;
import com.ikon.d15websocket.model.MessageOut;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public MessageOut getUser(MessageIn messageIn) {

        return new MessageOut(messageIn.getMessage());
    }
}
