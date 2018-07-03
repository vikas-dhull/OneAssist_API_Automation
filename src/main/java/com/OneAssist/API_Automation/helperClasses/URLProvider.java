package com.OneAssist.API_Automation.helperClasses;

import com.OneAssist.API_Automation.fileReader.PropertyReader;

public class URLProvider {
	public static String envConfigFilePath = "/ConfigFiles/environment.properties";
	public static String apiConfigFilePath = "/ConfigFiles/APIConfig.properties";	
	public static String projectEnv = PropertyReader.readProperty(envConfigFilePath, "env");
	
	public static String getBaseURL() {
		String baseURL = null;
		
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
	
	public static String getDBURL() {
		String DBURL = null;		
		projectEnv = PropertyReader.readProperty(envConfigFilePath, "env");
		
		if("QA1".equalsIgnoreCase(projectEnv))
			DBURL = PropertyReader.readProperty(envConfigFilePath, "QA1_DB_URL");
		if("QA2".equalsIgnoreCase(projectEnv))
			DBURL = PropertyReader.readProperty(envConfigFilePath, "QA2_DB_URL");
		if("QA3".equalsIgnoreCase(projectEnv))
			DBURL = PropertyReader.readProperty(envConfigFilePath, "QA3_DB_URL");
		if("QA4".equalsIgnoreCase(projectEnv))
			DBURL = PropertyReader.readProperty(envConfigFilePath, "QA4_DB_URL");
		if("SIT1".equalsIgnoreCase(projectEnv))
			DBURL = PropertyReader.readProperty(envConfigFilePath, "SIT1_DB_URL");
		if("SIT2".equalsIgnoreCase(projectEnv))
			DBURL = PropertyReader.readProperty(envConfigFilePath, "SIT2_DB_URL");
		
		return DBURL;
	}
	
	public static String getDBUserName(String key) {		
		return PropertyReader.readProperty(apiConfigFilePath, key);
	}
	
	public static String getDBPassword(String key) {		
		return PropertyReader.readProperty(apiConfigFilePath, key);
	}
	
	public static String getAPIResourceURL(String key) {		
		return PropertyReader.readProperty(apiConfigFilePath, key);
	}
	
	public static String getAPIReqHeaders(String key) {	
		return PropertyReader.readProperty(apiConfigFilePath, key);
	}
}
