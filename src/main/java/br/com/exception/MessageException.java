package br.com.exception;

import org.springframework.http.HttpStatus;

public class MessageException {
	
	private HttpStatus status;
	private String error;
	private String message;
	public HttpStatus getStatus() {
		return status;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public void setError(String error) {
		this.error = error;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageException(HttpStatus status, String error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}

}
