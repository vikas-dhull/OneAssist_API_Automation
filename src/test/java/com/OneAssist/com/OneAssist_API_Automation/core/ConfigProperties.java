package com.OneAssist.com.OneAssist_API_Automation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class ConfigProperties {


	private Properties properties = null;
	private static ConfigProperties config = null;

	public static ConfigProperties getObject(){
		if(config==null){
			//synchronized (ConfigProperties.class) {
				//if(config==null){
					config = new ConfigProperties();
				


			
		}
		return config;
	}


	private void loadConfiguration(String propFileName){
		properties = new Properties();

		
		try {
		FileInputStream file = new FileInputStream(propFileName);
		try {
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public String getConfigValue(String propFileName,String key){
		if(properties==null){
			loadConfiguration(propFileName);
		}
		String configValue = null;
		configValue= properties.getProperty(key);

		return configValue;

	}



}
