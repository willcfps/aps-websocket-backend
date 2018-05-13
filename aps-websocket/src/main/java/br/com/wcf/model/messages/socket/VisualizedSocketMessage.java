package br.com.wcf.model.messages.socket;

public class VisualizedSocketMessage {

	private String user;
	private String messageId;
	private VisualizedSocketMessageTypeEnum type;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public VisualizedSocketMessageTypeEnum getType() {
		return type;
	}

	public void setType(VisualizedSocketMessageTypeEnum type) {
		this.type = type;
	}
}
