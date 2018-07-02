package com.OneAssist.com.OneAssist_API_Automation.core;

public class URLProvider extends ConfigDetails{


	public String getBaseURL(){
		if(environment.toLowerCase().contains("qa1"))
			return "https://qa1.1atesting.in";
		if(environment.toLowerCase().contains("qa2"))
			return "https://qa2.1atesting.in";
		if(environment.toLowerCase().contains("qa3"))
			return "https://qa3.1atesting.in";
		if(environment.toLowerCase().contains("qa4"))
			return "https://qa4.1atesting.in";
		if(environment.toLowerCase().contains("sit1"))
			return "https://sit1.1atesting.in";
		if(environment.toLowerCase().contains("sit2"))
			return "https://sit2.1atesting.in";
		if(environment.toLowerCase().contains("sit3"))
			return "https://sit3.1atesting.in";
		if(environment.toLowerCase().contains("sit4"))
			return "https://sit4.1atesting.in";
		else
			return "https://www.oneassist.in";

	}

}
