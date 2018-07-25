package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
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
import com.google.gson.Gson;

public class CustomerOnBoarding extends ConfigDetails{

	APIHeaders apiheaders;
	APIMethods method;

	@BeforeClass
	public void setup() {
		apiheaders = new APIHeaders();
		method = new APIMethods();
/*
		try {
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
		/*String str = JsonHelper.getJsonStringFromMapData(payloadData);*/

		String reqJson=CustomerOnBoardPojoHelper.setCustomerOnBoardPojo(payloadData);
	    System.out.println("JSON request : " + reqJson);

		String apiUrl = baseURL + resourceURL;
		System.out.println("API request URL under testing : " + apiUrl);		
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders(header1, header2, Auth), reqJson);
		String responseStringJson = response.getResponse();

		Gson gson =new Gson();
		CustomerOnBoardResponse customerOnBoardResponse= gson.fromJson(response.getResponse(), CustomerOnBoardResponse.class);
		System.out.println("Paynow link is :"+customerOnBoardResponse.getPayNowLink());
		System.out.println("");
		//CustomerOnBoardResponse customerOnBoardResponse= JsonHelper.setResponsePojoClass(responseStringJson, CustomerOnBoardResponse.class);
		System.out.println("JSON response : " + response.getResponse());


		if(response.getStatusCode()==200) {
			if(customerOnBoardResponse != null && customerOnBoardResponse.getStatus().equals("success")) {
				if (payloadData.get("action").equalsIgnoreCase("submit")){

					softAssert.assertNull(payloadData.get("payNowLink"));
					softAssert.assertNull(payloadData.get("isMotoPayment"));
					softAssert.assertNull(payloadData.get("isMailSent"));
					softAssert.assertEquals(payloadData.get("paymentMode"),customerOnBoardResponse.getPaymentMode());
					String customerName=payloadData.get("firstName")+" "+ payloadData.get("middleName")+" "+payloadData.get("lastName");

					softAssert.assertEquals(customerName.trim(), customerOnBoardResponse.getPrimaryCustomerName());
					softAssert.assertNull(customerOnBoardResponse.getSecondaryCustomerName());
					softAssert.assertTrue(customerOnBoardResponse.getMessage().equals("CUSTOMER_CREATED_SUCCESSFULLY"));
					softAssert.assertNull(customerOnBoardResponse.getErrors());
					softAssert.assertNotNull(customerOnBoardResponse.getCustomerOrderInfo().getOrderId());
					softAssert.assertNotNull(customerOnBoardResponse.getCustomerOrderInfo().getPlanName());
					softAssert.assertNotNull(customerOnBoardResponse.getCustomerOrderInfo().getPrice());
					softAssert.assertNotNull(customerOnBoardResponse.getMembershipInfo().getMembershipNumber());
					softAssert.assertNotNull(customerOnBoardResponse.getMembershipInfo().getStartDate());
					softAssert.assertNotNull(customerOnBoardResponse.getMembershipInfo().getEndDate());
					softAssert.assertNotNull(customerOnBoardResponse.getMembershipInfo().getPrimaryCustomerId());
					softAssert.assertNull(customerOnBoardResponse.getMembershipInfo().getSecondaryCustomerId());
					softAssert.assertNull(customerOnBoardResponse.getPendingCustomerInfo());

					if (payloadData.get("productCode").equals("MP01")){

						softAssert.assertEquals(customerOnBoardResponse.getProductInfo().get(0).getProductCode(),payloadData.get("productCode"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getProductName().equals("MobileAssist"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getCategoryCode().equals("PE"));
					}

					else  if (payloadData.get("productCode").equals("WP01")){

						softAssert.assertEquals(customerOnBoardResponse.getProductInfo().get(0).getProductCode(),payloadData.get("productCode"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getProductName().equals("WalletAssist"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getCategoryCode().equals("F"));
					}

					else {

						softAssert.assertEquals(customerOnBoardResponse.getProductInfo().get(0).getProductCode(),payloadData.get("productCode"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getCategoryCode().equals("HA"));
					}

				}

				else if (payloadData.get("action").equalsIgnoreCase("save")){
					
					softAssert.assertNotNull(payloadData.get("payNowLink"));
					softAssert.assertNotNull(payloadData.get("isMotoPayment"));
					softAssert.assertNotNull(payloadData.get("isMailSent"));
					softAssert.assertEquals(payloadData.get("paymentMode"),customerOnBoardResponse.getPaymentMode());
					String customerName=payloadData.get("firstName")+" "+ payloadData.get("middleName")+" "+payloadData.get("lastName");
					
					softAssert.assertNull(customerOnBoardResponse.getSecondaryCustomerName());
					softAssert.assertTrue(customerOnBoardResponse.getMessage().equals("PENDING_CUSTOMER_CREATED_SUCCESSFULLY"));
					softAssert.assertNull(customerOnBoardResponse.getErrors());
					
					softAssert.assertNotNull(customerOnBoardResponse.getCustomerOrderInfo().getOrderId());
					softAssert.assertNotNull(customerOnBoardResponse.getCustomerOrderInfo().getPlanName());
					softAssert.assertNotNull(customerOnBoardResponse.getCustomerOrderInfo().getPrice());
					
					softAssert.assertNull(customerOnBoardResponse.getMembershipInfo().getMembershipNumber());
					softAssert.assertNotNull(customerOnBoardResponse.getMembershipInfo().getStartDate());
					softAssert.assertNotNull(customerOnBoardResponse.getMembershipInfo().getEndDate());
					softAssert.assertNull(customerOnBoardResponse.getMembershipInfo().getPrimaryCustomerId());
					
					softAssert.assertNotNull(customerOnBoardResponse.getPendingCustomerInfo().get(0).getCustomerTempId());
					softAssert.assertNotNull(customerOnBoardResponse.getPendingCustomerInfo().get(0).getPreviousCustomerId());
					softAssert.assertNotNull(customerOnBoardResponse.getPendingCustomerInfo().get(0).getActivityReferenceId());

					if (payloadData.get("productCode").equals("MP01")){

						softAssert.assertEquals(customerOnBoardResponse.getProductInfo().get(0).getProductCode(),payloadData.get("productCode"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getProductName().equals("MobileAssist"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getCategoryCode().equals("PE"));
					}

					else  if (payloadData.get("productCode").equals("WP01")){

						softAssert.assertEquals(customerOnBoardResponse.getProductInfo().get(0).getProductCode(),payloadData.get("productCode"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getProductName().equals("WalletAssist"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getCategoryCode().equals("F"));
					}

					else {

						softAssert.assertEquals(customerOnBoardResponse.getProductInfo().get(0).getProductCode(),payloadData.get("productCode"));
						softAssert.assertTrue(customerOnBoardResponse.getProductInfo().get(0).getCategoryCode().equals("HA"));
					}
					
					
				}


               softAssert.assertAll();




				/*	
				softAssert.assertTrue("success".equals(customerOnBoardResponse.getStatus()), 
						"Invalid status received in response..{"+customerOnBoardResponse.getStatus()+"}.");
				softAssert.assertTrue(customerOnBoardResponse.getPayNowLink()!=null && customerOnBoardResponse.getPayNowLink().contains("paynow?"), 
						"link is not valid..{"+customerOnBoardResponse.getPayNowLink()+"}.");
				 */

				/*softAssert.assertTrue(bulkBoardingResp.getMessage().contains("PENDING_CUSTOMER_CREATED_SUCCESSFULLY"), 
						"success message is wrong..{"+bulkBoardingResp.getMessage()+"}.");*/
			} 

			/*else {
				softAssert.assertTrue(false, "Something went wrong, Response is not expected, found as NULL.." + 
						"{"+response.getStatusCode() + "}. {"+response.getResponse()+"}. ");
			}*/
		} 
		/*		else if(response.getStatusCode()==500){
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
