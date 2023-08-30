package com.example.demo.Dto;

import org.springframework.http.HttpStatus;

public class MessageDto {
	private int status;
	private HttpStatus httpstatus;
	private String message;
	public MessageDto(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	private Object data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "MessageDto [status=" + status + ", httpstatus=" + httpstatus + ", message=" + message + ", data=" + data
				+ "]";
	}
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
