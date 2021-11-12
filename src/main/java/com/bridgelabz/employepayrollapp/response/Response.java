package com.bridgelabz.employepayrollapp.response;

import java.util.List;

  
public class Response {
	private int statusCode;
	private String message;
	private Object obj;
		 
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Response(int statusCode, String message, Object obj) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.obj = obj;
	}
	public Response(int statusCode, String message, List<Object> obj) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.obj = obj;
	}
	public Response(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	 
	}

}
