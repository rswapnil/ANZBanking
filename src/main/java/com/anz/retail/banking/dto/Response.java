package com.anz.retail.banking.dto;

import java.util.List;

public class Response<T> {
	
	private String validation;
	private String error;
	private T data;
	private List<Header> headers;

	public Response() {
		super();
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}
	
}
