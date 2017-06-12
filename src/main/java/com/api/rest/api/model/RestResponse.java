package com.api.rest.api.model;

/**
 * @author Sumati Gupta
 * 
 */

public class RestResponse {

	private int statusCode;

	private String responseBody;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public int getDataCode(int statusCode) {
		return this.statusCode;

	}

	public String getDataBody(String responseBody) {

		return this.responseBody;
	}

}
