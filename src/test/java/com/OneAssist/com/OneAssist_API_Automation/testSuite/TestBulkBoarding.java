package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OneAssist.API_Automation.fileReader.ExcelUtil;
import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.API_Automation.helperClasses.URLProvider;
import com.OneAssist.com.OneAssist_API_Automation.core.APIHeaders;
import com.OneAssist.com.OneAssist_API_Automation.core.APIMethods;
import com.OneAssist.com.OneAssist_API_Automation.core.Response;
import com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses.BulkBoardingPojoHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.bulkBoardingResponse.BulkBoardingResponse;


public class TestBulkBoarding {
	APIHeaders apiheaders;
	APIMethods method;
	String reqJson=null;
	
	@BeforeClass
	public void setup() {
		apiheaders = new APIHeaders();
		method = new APIMethods();
		
		/*try {
		method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONRequest\\bulkBoarding", "com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest", "BulkBoardingRequest");
		method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONResponse\\bulkBoardingResponse", "com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.bulkBoardingResponse", "BulkBoardingResponse");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}	
	
	@DataProvider
	public Object[][] BulkBoardingAPI() {

		Object[][] dataProvider = new Object[1][];
		Map<String, String> apiPayload= ExcelUtil.getExcelRowColDataInHashMap(System.getProperty("user.dir")+ "\\TestDataSheet","APIData.xls","BulkBoarding",2);
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
		
		SoftAssert softAssert = new SoftAssert();
		String str = JsonHelper.getJsonStringFromMapData(payloadData);
		System.out.println("JSON request : " + str);		
		String reqJson=BulkBoardingPojoHelper.setBulkBoardingPojo(payloadData);		
		String apiUrl = baseURL + resourceURL;
		System.out.println("API request URL under testing : " + apiUrl);		
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders(header1, header2, Auth), reqJson);
		String responseStringJson = response.getResponse();
		response.getResponseHeaders();
		BulkBoardingResponse bulkBoardingResp = JsonHelper.setResponsePojoClass(responseStringJson, BulkBoardingResponse.class);		
		System.out.println("JSON response : " + response.getResponse());
		
		if(response.getStatusCode()==200) {
			if(bulkBoardingResp != null) {
				softAssert.assertTrue("success".equals(bulkBoardingResp.getStatus()), 
						"Invalid status received in response..{"+bulkBoardingResp.getStatus()+"}.");
				softAssert.assertTrue(bulkBoardingResp.getPayNowLink().contains("paynow?"), 
						"link is not valid..{"+bulkBoardingResp.getPayNowLink()+"}.");
				softAssert.assertTrue(bulkBoardingResp.getMessage().contains("PENDING_CUSTOMER_CREATED_SUCCESSFULLY"), 
						"success message is wrong..{"+bulkBoardingResp.getMessage()+"}.");
			} else {
				softAssert.assertTrue(false, "Something went wrong, Response is not expected, found as NULL.." + 
						"{"+response.getStatusCode() + "}. {"+response.getResponse()+"}. ");
			}
		} 
		else if(response.getStatusCode()==500){
			softAssert.assertTrue(false, "Internal server error. Expected status code not returned.." + 
					"{"+response.getStatusCode());
		}
		else {
			softAssert.assertTrue(false, "Something went wrong, Response is not expected.." + 
					"{"+response.getStatusCode() + "}. {"+response.getResponse()+"}. ");
		}
		softAssert.assertAll();
	}
}
