package br.com.wcf.app;

public class UnauthorizedSocketException extends Exception {

	private static final long serialVersionUID = 750063777220197427L;
	
	public UnauthorizedSocketException() {}
	
	public UnauthorizedSocketException(String message) {
		super(message);
	}

}
