package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OneAssist.com.OneAssist_API_Automation.core.APIHeaders;
import com.OneAssist.com.OneAssist_API_Automation.core.APIMethods;
import com.OneAssist.com.OneAssist_API_Automation.core.Response;
import com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses.BulkBoardingPojoHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses.CreateRenewalPojoHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.bulkBoardingResponse.BulkBoardingResponse;
import com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse.CreateRenewalResponse;
import com.OneAssist.API_Automation.fileReader.ExcelUtil;
import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.API_Automation.helperClasses.URLProvider;

public class TestCreateRenewal {
	
	APIHeaders apiheaders;
	APIMethods method;
	ObjectMapper mapper;
	String baseURL = "https://qa4.1atesting.in";
	String reqJson=null;
	
	@BeforeClass
	public void setup() {
		apiheaders = new APIHeaders();
		method = new APIMethods();
		mapper = new ObjectMapper();
		
		try {
			method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONRequest\\createRenewal", "com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest", "CreateRenewalRequest");
			method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONResponse\\createRenewalResponse", "com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse", "CreateRenewalResponse");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@DataProvider
	public Object[][] BulkBoardingAPI() {

		Object[][] dataProvider = new Object[1][];
		Map<String, String> apiPayload= ExcelUtil.getExcelRowColDataInHashMap(System.getProperty("user.dir")+ "\\TestDataSheet","APIData.xls","CreateRenewal",2);
		dataProvider[0] = new Object[] {URLProvider.getBaseURL(),
									URLProvider.getAPIResourceURL("bulkBoardingURL"),
									URLProvider.getAPIReqHeaders("accept"),
									URLProvider.getAPIReqHeaders("contentType"),
									URLProvider.getAPIReqHeaders("auth"),
									apiPayload
								};
		return dataProvider;
	}

	@Test(dataProvider = "BulkBoardingAPI")  //  baseURL, ResourceURL, header1 , header2, Auth, apiPayload
	public void testBulkBoardingOASYS(String baseURL, String resourceURL, String header1, String header2, String Auth, Map<String, String> payloadData) 
			throws MalformedURLException, URISyntaxException, IOException {
		
		
		String str = JsonHelper.getJsonStringFromMapData(payloadData);
		System.out.println("request api data JSON: " + str);
		
		String reqJson=CreateRenewalPojoHelper.setCreateRenewalPojo(payloadData);
		
		String apiUrl = baseURL + resourceURL;
		
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders(header1, header2, Auth), reqJson);
		String responseStringJson = response.getResponse();
		response.getResponseHeaders();
		CreateRenewalResponse bulkBoardingResp = JsonHelper.setResponsePojoClass(responseStringJson, CreateRenewalResponse.class);
		
		System.out.println("response API data JSON : " + response.getResponse());
		
		if(response.getStatusCode()==200) {
			Assert.assertTrue(bulkBoardingResp.getMessage().contains("PENDING_CUSTOMER_CREATED_SUCCESSFULLY"), "success message is wrong..");
		} else {
			Assert.assertTrue(false, "Expected status code not returned.." + "{"+response.getStatusCode()+"}");
		}		
	}
}
