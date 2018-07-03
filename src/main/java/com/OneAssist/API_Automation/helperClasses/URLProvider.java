package com.OneAssist.API_Automation.helperClasses;

import com.OneAssist.API_Automation.fileReader.PropertyReader;

public class URLProvider {

	public static String getBaseURL() {
		String baseURL = null;
		String envConfigFilePath = "/ConfigFiles/environment.properties";
		String projectEnv = PropertyReader.readProperty(envConfigFilePath, "env");
		
		if("QA1".equalsIgnoreCase(projectEnv))
			baseURL = PropertyReader.readProperty(envConfigFilePath, "QA1_BASE_URL");
		if("QA2".equalsIgnoreCase(projectEnv))
			baseURL = PropertyReader.readProperty(envConfigFilePath, "QA2_BASE_URL");
		if("QA3".equalsIgnoreCase(projectEnv))
			baseURL = PropertyReader.readProperty(envConfigFilePath, "QA3_BASE_URL");
		if("QA4".equalsIgnoreCase(projectEnv))
			baseURL = PropertyReader.readProperty(envConfigFilePath, "QA4_BASE_URL");
		if("SIT1".equalsIgnoreCase(projectEnv))
			baseURL = PropertyReader.readProperty(envConfigFilePath, "SIT1_BASE_URL");
		if("SIT2".equalsIgnoreCase(projectEnv))
			baseURL = PropertyReader.readProperty(envConfigFilePath, "SIT2_BASE_URL");
		
		return baseURL;
	}
	
	public static String getAPIResourceURL(String key) {		
		String envConfigFilePath = "/ConfigFiles/APIConfig.properties";		
		return PropertyReader.readProperty(envConfigFilePath, key);
	}
	
	public static String getAPIReqHeaders(String key) {		
		String envConfigFilePath = "/ConfigFiles/APIConfig.properties";		
		return PropertyReader.readProperty(envConfigFilePath, key);
	}
}
