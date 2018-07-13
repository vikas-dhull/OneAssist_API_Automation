package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OneAssist.API_Automation.fileReader.ExcelUtil;
import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.API_Automation.helperClasses.URLProvider;
import com.OneAssist.com.OneAssist_API_Automation.core.APIHeaders;
import com.OneAssist.com.OneAssist_API_Automation.core.APIMethods;
import com.OneAssist.com.OneAssist_API_Automation.core.ConfigDetails;
import com.OneAssist.com.OneAssist_API_Automation.core.Response;
import com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses.BulkBoardingPojoHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses.CustomerOnBoardPojoHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.CustomerOnBoardResponse.CustomerOnBoardResponse;
import com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.bulkBoardingResponse.BulkBoardingResponse;

public class CustomerOnBoarding extends ConfigDetails{
	
	APIHeaders apiheaders;
	APIMethods method;
	
	@BeforeClass
	public void setup() {
		apiheaders = new APIHeaders();
		method = new APIMethods();
		
		/*try {
		method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONRequest\\CustomerOnBoardAPI\\V1\\CustomerOnBoardRequestMaxSet", "com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest", "CustomerOnBoardRequest");
		method.createPOJOForJSON(System.getProperty("user.dir")+ "\\JSONFiles\\JSONResponse\\CustomerOnBoardAPI\\V1\\CustomerOnBoardAPIResponse", "com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.CustomerOnBoardResponse", "CustomerOnBoardResponse");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	
	@DataProvider
	public Object[][] CustomerBoardAPI() {
		
		String filePath=System.getProperty("user.dir")+ "\\TestDataSheet";
		String fileName="CustomerOneboardAPI.xls";
		String sheetName="CustomerOneboardAPI";
		int rowCount=ExcelUtil.getNoOfRows(filePath, fileName, sheetName);
		int dataproviderSize= rowCount -1;
		Object[][] dataProvider = new Object[dataproviderSize][];
        for (int i=2;i<=rowCount;i++){
        	Map<String, String> exlData= ExcelUtil.getExcelRowColDataInHashMap(filePath,fileName,sheetName,i);
			dataProvider[i-2] = new Object[] {URLProvider.getBaseURL(),
										URLProvider.getAPIResourceURL("customerOnBoardURL"),
										URLProvider.getAPIReqHeaders("accept"),
										URLProvider.getAPIReqHeaders("contentType"),
										URLProvider.getAPIReqHeaders("auth"),
										exlData
									};
		
        }
        return dataProvider;
	}
	
	
	@Test(dataProvider = "CustomerBoardAPI")  //  baseURL, ResourceURL, header1 , header2, Auth, apiPayload
	public void TC_CustomerBoardAPI_01(String baseURL, String resourceURL, String header1, String header2, String Auth, Map<String, String> payloadData) 
			throws MalformedURLException, URISyntaxException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		String str = JsonHelper.getJsonStringFromMapData(payloadData);
		System.out.println("JSON request : " + str);		
		String reqJson=CustomerOnBoardPojoHelper.setCustomerOnBoardPojo(payloadData);	
	
		String apiUrl = baseURL + resourceURL;
		System.out.println("API request URL under testing : " + apiUrl);		
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders(header1, header2, Auth), reqJson);
		String responseStringJson = response.getResponse();
		response.getResponseHeaders();
		CustomerOnBoardResponse customerOnBoardResponse= JsonHelper.setResponsePojoClass(responseStringJson, CustomerOnBoardResponse.class);
		System.out.println("JSON response : " + response.getResponse());
		
	/*	if(response.getStatusCode()==200) {
			if(bulkBoardingResp != null) {
				softAssert.assertTrue("success".equals(bulkBoardingResp.getStatus()), 
						"Invalid status received in response..{"+bulkBoardingResp.getStatus()+"}.");
				softAssert.assertTrue(bulkBoardingResp.getPayNowLink()!=null && bulkBoardingResp.getPayNowLink().contains("paynow?"), 
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
		*/
	}
	
	
	
	
}
