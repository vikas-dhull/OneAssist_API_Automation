package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.OneAssist.API_Automation.fileReader.ExcelUtil;
import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.com.OneAssist_API_Automation.core.APIHeaders;
import com.OneAssist.com.OneAssist_API_Automation.core.APIMethods;
import com.OneAssist.com.OneAssist_API_Automation.core.Response;
import com.OneAssist.com.OneAssist_API_Automation.pojoClasses.BulkBoarding.BulkBoardingPojoHelper;

public class TestBulkBoarding {
	APIHeaders apiheaders;
	APIMethods method;
	ObjectMapper mapper;
	String baseURL = "https://qa4.1atesting.in";
	String reqJson=null;
	
	@Test
	public void testBulkBoardingOASYS() throws MalformedURLException, URISyntaxException, IOException {
		apiheaders = new APIHeaders();
		method = new APIMethods();
		mapper = new ObjectMapper();
		
		/*try {
			method.createPOJOForJSON(System.getProperty("user.dir")+ "\\bulkBoarding", "com.OneAssist.com.OneAssist_API_Automation.pojoClasses.BulkBoarding", "BulkBoarding");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Map<String, String> apiPayload= ExcelUtil.getExcelRowColDataInHashMap(System.getProperty("user.dir")+ "\\TestDataSheet","APIData.xls","BulkBoarding",2);
		String str = JsonHelper.getJsonStringFromMapData(apiPayload);
		System.out.println("request api data JSON: " + str);
		
		String reqJson=BulkBoardingPojoHelper.setBulkBoardingPojo(apiPayload);
		
		String apiUrl = baseURL + "/OASYS/webservice/rest/customer/onboardCustomer";		
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders("application/json", "application/json", "Basic d3N0ZXN0Om9hc3lz"), reqJson);
		
		System.out.println("response API data JSON : " + response.getResponse());
		
		
	}
}
