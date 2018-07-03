package com.OneAssist.com.OneAssist_API_Automation.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIHeaders {
	
	public HashMap<String,String> getLoggedInHeaders(String accept, String contentType,String auth)
	{
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("Accept", accept);
		headers.put("Content-Type", contentType);
		headers.put("Authorization", auth);

		return headers;
	}

	public HashMap<String, String> getNotLoggedInHeaders(String accept, String contentType){
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", accept);
		headers.put("Content-Type", contentType);
		
		
		return headers;
	}
	
	public HashMap<String,String> addNewHeader(HashMap<String,String> existingHeaders,String key,String value)
    {
        existingHeaders.put(key, value);
        return existingHeaders;
    }
	
	
}
