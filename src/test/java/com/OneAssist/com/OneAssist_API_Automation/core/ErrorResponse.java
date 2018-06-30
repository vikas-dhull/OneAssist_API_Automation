package com.OneAssist.com.OneAssist_API_Automation.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErrorResponse {

	private Integer status;
	private String message;
	private Integer code;
	private Map<String, List<String>> responseHeaders;
	//private List<ValidationErrorDetail> validationErrorDetails = new ArrayList<ValidationErrorDetail>();
    
	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	

	public Integer getErrorStatus() {
        return status;
    }
    
    public String getErrorMessage() {
        return message;
    }
    
    public Integer getErrorCode() {
        return code;
    }

    
   /* void handleNIErrorResponse(apiTestingLibrary.errorModel.ni.NiErrorResponse errReponse)
    {
    	setStatus(errReponse.getErrorStatus());
    	setCode(errReponse.getErrorCode());
    	setMessage(errReponse.getErrorMessage());
    	setCustomData(errReponse.getCustomData());
    }*/
	
}
