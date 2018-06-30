package com.OneAssist.com.OneAssist_API_Automation.core;

import java.util.List;
import java.util.Map;

public class Response {
	
	private int statusCode;
	private String response;
	private long responseTime;
	private Map<String, List<String>> responseHeaders;
	//private ErrorResponse errorResponse;
	
	
	public long getResponseTime() {
		return responseTime;
	}
	
	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}
	
	public Map<String, List<String>> getResponseHeaders() {
		return responseHeaders;
	}
	
	public void setResponseHeaders(Map<String, List<String>> response) {
		this.responseHeaders = response;
	}
	


}
