package br.com.wcf.model.messages;

import java.io.Serializable;

public class DefaultRestMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5033273402408865964L;
	public enum DefaultRestMessageStatus {
		OK, WAITING, ERROR, UNAUTHORIZED;
	}

	private DefaultRestMessageStatus status;
	private String shortMessage;
	private String message;

	public DefaultRestMessage() {
	}

	public DefaultRestMessage(DefaultRestMessageStatus status) {
		super();
		this.status = status;
	}

	public DefaultRestMessage(DefaultRestMessageStatus status, String shortMessage) {
		super();
		this.status = status;
		this.shortMessage = shortMessage;
	}

	public DefaultRestMessage(DefaultRestMessageStatus status, String shortMessage, String message) {
		super();
		this.status = status;
		this.shortMessage = shortMessage;
		this.message = message;
	}

	public DefaultRestMessageStatus getStatus() {
		return status;
	}

	public void setStatus(DefaultRestMessageStatus status) {
		this.status = status;
	}

	public String getShortMessage() {
		return shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
