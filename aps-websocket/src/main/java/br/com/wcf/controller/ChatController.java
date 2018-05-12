package br.com.wcf.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.wcf.model.messages.socket.DefaultSocketMessageModel;
import br.com.wcf.model.messages.socket.RegisteredSocketMessage;
import br.com.wcf.model.messages.socket.VisualizedSocketMessage;

@Controller
public class ChatController {

	@MessageMapping("/{discussion}")
	@SendTo("/topic/{discussion}")
	public DefaultSocketMessageModel topic(@DestinationVariable String discussion, DefaultSocketMessageModel message) {
		return message;
	}

	@MessageMapping("/confirm/{discussion}/{destination}")
	@SendTo("/confirmation/{discussion}/{destination}")
	public VisualizedSocketMessage confirmation(VisualizedSocketMessage message) throws InterruptedException {
		Thread.sleep(1000);
		return message;
	}

	@MessageMapping("/register/{discussion}")
	@SendTo("/registered/{discussion}")
	public RegisteredSocketMessage registered(RegisteredSocketMessage message) {
		return message;
	}
}
