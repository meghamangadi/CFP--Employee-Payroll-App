package com.bridgelabz.employepayrollapp.response;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	private int statusCode;
	private String message;
	private Object obj;

	public Response(String message, Object obj) {
		this.message = message;
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
