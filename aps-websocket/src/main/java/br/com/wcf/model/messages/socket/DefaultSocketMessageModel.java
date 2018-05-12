package br.com.wcf.model.messages.socket;

public class DefaultSocketMessageModel {

	private String id;
	private String message;
	private String dateTime;
	private String from;
	private String name;
	private DefaultSocketMessageModel response;
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public DefaultSocketMessageModel getResponse() {
		return response;
	}

	public void setResponse(DefaultSocketMessageModel response) {
		this.response = response;
	}

}
