package br.com.wcf.bo;

import org.springframework.stereotype.Component;

import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.messages.DefaultRestMessage.DefaultRestMessageStatus;

@Component
public class DefaultBo {
	
	protected DefaultRestMessage unauthorized() {
		return new DefaultRestMessage(DefaultRestMessageStatus.UNAUTHORIZED);
	}
	
	protected DefaultRestMessage error() {
		return new DefaultRestMessage(DefaultRestMessageStatus.ERROR);
	}
	
	protected DefaultRestMessage error(String msg) {
		return new DefaultRestMessage(DefaultRestMessageStatus.ERROR, msg);
	}

}
