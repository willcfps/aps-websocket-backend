package br.com.wcf.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;

@Component
public class WebsocketSessionInterceptor extends ChannelInterceptorAdapter {
	
	private static final String UNAUTHORIZED = "Nao autenticado.";

	@Autowired
	private UsersSession session;

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
		List<String> authorization = headerAccessor.getNativeHeader("authorization");
		
		StompCommand command = headerAccessor.getCommand();
		if (command.equals(StompCommand.DISCONNECT) || command.equals(StompCommand.UNSUBSCRIBE)) {
			return super.preSend(message, channel);
		}

		if (authorization == null || authorization.isEmpty()) {
			throw new IllegalArgumentException(UNAUTHORIZED);
		}

		String aux = this.session.get(authorization.get(0));
		if (aux == null) {
			throw new IllegalArgumentException(UNAUTHORIZED);
		}

		return super.preSend(message, channel);
	}
}
