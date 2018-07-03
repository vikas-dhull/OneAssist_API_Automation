package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.OneAssist.com.OneAssist_API_Automation.core.APIHeaders;
import com.OneAssist.com.OneAssist_API_Automation.core.APIMethods;
import com.OneAssist.com.OneAssist_API_Automation.core.Response;
import com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses.CreateRenewalPojoHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse.CreateRenewalResponse;
import com.OneAssist.API_Automation.fileReader.ExcelUtil;
import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.API_Automation.helperClasses.URLProvider;

public class TestCreateRenewal {
	
	APIHeaders apiheaders;
	APIMethods method;
	String reqJson=null;
	
	@BeforeClass
	public void setup() {
		apiheaders = new APIHeaders();
		method = new APIMethods();
		
		/*try {
			method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONRequest\\createRenewal", "com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest", "CreateRenewalRequest");
			method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONResponse\\createRenewalResponse", "com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse", "CreateRenewalResponse");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}	
	
	@DataProvider
	public Object[][] CreateRenewalAPI() {

		Object[][] dataProvider = new Object[1][];
		Map<String, String> apiPayload= ExcelUtil.getExcelRowColDataInHashMap(System.getProperty("user.dir")+ "\\TestDataSheet","APIData.xls","CreateRenewal",2);
		dataProvider[0] = new Object[] {URLProvider.getBaseURL(),
									URLProvider.getAPIResourceURL("createRenewalURL"),
									URLProvider.getAPIReqHeaders("accept"),
									URLProvider.getAPIReqHeaders("contentType"),
									URLProvider.getAPIReqHeaders("auth"),
									apiPayload
								};
		return dataProvider;
	}

	@Test(dataProvider = "CreateRenewalAPI")  //  baseURL, ResourceURL, header1 , header2, Auth, apiPayload
	public void testCreateRenewalOASYS(String baseURL, String resourceURL, String header1, String header2, String Auth, Map<String, String> payloadData) 
			throws MalformedURLException, URISyntaxException, IOException {
		
		
		String str = JsonHelper.getJsonStringFromMapData(payloadData);
		System.out.println("request api data JSON: " + str);
		
		String reqJson=CreateRenewalPojoHelper.setCreateRenewalPojo(payloadData);
		
		String apiUrl = baseURL + resourceURL;
		System.out.println("API request URL under testing : " + apiUrl);
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders(header1, header2, Auth), reqJson);
		String responseStringJson = response.getResponse();
		response.getResponseHeaders();
		CreateRenewalResponse createRenewalResp = JsonHelper.setResponsePojoClass(responseStringJson, CreateRenewalResponse.class);
		
		System.out.println("response API data JSON : " + response.getResponse());
		
		if(response.getStatusCode()==200) {
			if(createRenewalResp != null)
				Assert.assertTrue(createRenewalResp.getMessage().contains("PENDING_CUSTOMER_CREATED_SUCCESSFULLY"), "success message is wrong..");
			else
				Assert.assertTrue(false, "Something went wrong, Response is not expected, found as NULL.." + 
						"{"+response.getStatusCode() + "}. {"+response.getResponse()+"}. ");
		}
		else if(response.getStatusCode()==500){
			Assert.assertTrue(false, "Internal server error. Expected status code not returned.." + 
					"{"+response.getStatusCode());
		}
		else {
			Assert.assertTrue(false, "Something went wrong, Response is not expected.." + 
					"{"+response.getStatusCode() + "}. {"+response.getResponse()+"}. ");
		}
	}
}
