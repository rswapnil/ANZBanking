package com.anz.retail.banking.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Response<T> {
	
	@ApiModelProperty(notes = "Validation Message for User")
	private String validation;
	@ApiModelProperty(notes = "Error Message for User")
	private String error;
	@ApiModelProperty(notes = "User Data for screen")
	private T data;
	@ApiModelProperty(notes = "Column Header Data for screen")
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
