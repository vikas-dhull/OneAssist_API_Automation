package com.OneAssist.com.OneAssist_API_Automation.testSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OneAssist.com.OneAssist_API_Automation.core.APIHeaders;
import com.OneAssist.com.OneAssist_API_Automation.core.APIMethods;
import com.OneAssist.com.OneAssist_API_Automation.core.ConfigDetails;
import com.OneAssist.com.OneAssist_API_Automation.core.Response;
import com.OneAssist.com.OneAssist_API_Automation.core.Xls_Reader;
import com.OneAssist.com.OneAssist_API_Automation.pojoClasses.CreateRenewal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BulkBoardingTestSuite extends ConfigDetails {

	APIHeaders apiheaders;
	APIMethods method;
	Xls_Reader xls = new Xls_Reader(APIData);
	String baseURL = "https://qa4.1atesting.in";
	String reqJson=null;

	@Test
	public void beforeMethod() throws MalformedURLException, URISyntaxException, IOException {

		apiheaders = new APIHeaders();
		method = new APIMethods();
		try {
			method.createPOJOForJSON(System.getProperty("user.dir")+ "\\sampleJSON", "com.OneAssist.com.OneAssist_API_Automation.pojoClasses", "CreateRenewal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		CreateRenewal customerRenewal = new CreateRenewal();
		try {
	        File jsonInputFile = new File(System.getProperty("user.dir")+ "\\sampleJSON");
	        customerRenewal = mapper.readValue(jsonInputFile, CreateRenewal.class);

	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		/*List<CustomerDetail> customerDetails = new ArrayList<CustomerDetail>();
		CustomerDetail customerDetail = new CustomerDetail("rekha","Kr","C","nimit.s@oneassist.in","7838692410","1001994495");
		customerDetails.add(customerDetail);
		AssetDetails assetDetails = new AssetDetails("ACTIVA","jhdf","6735gfjhsdf","MP01","31-05-2018","50000");
		OrderInfo orderInfo = new OrderInfo("377");
		PaymentInfo paymentInfo = new PaymentInfo("online");
		CreateRenewal customerRenewal = new CreateRenewal(customerDetails,paymentInfo,orderInfo,assetDetails,"1001994495");*/
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		reqJson = gson.toJson(customerRenewal);
		System.out.println("request api data JSON: "+reqJson);
		
		String apiUrl = baseURL + "/OASYS/webservice/rest/api/renewals/";		
		Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders("application/json", "application/json", "Basic d3N0ZXN0Om9hc3lz"), reqJson);
		
		try {
			System.out.println("response API data JSON : " + gson.toJson(new JSONObject(response.getResponse())));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(response.getResponse());
		
		try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+ "\\jsonResponse");
			fileWriter.write(json.toJSONString());
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*try {
				mapper.writeValue(new File(System.getProperty("user.dir")+ "\\jsonResponse"),response.getResponse());

	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }*/

		if(response.getStatusCode()==500) {
			try {
				method.createPOJOForJSON(System.getProperty("user.dir")+ "\\jsonResponse", "com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses", "CreateRenewalResponse");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else {
			// error handling for rest error codes..
		}
		
	//	gson.fromJson(response.getResponse(), CreateRenewalResponse.class);

	}

	/*@DataProvider
	public Object[][] BulkBoardingAPI() {

		int rowCount = xls.getRowCount("BulkBoardingApi");

		//System.out.println(rowCount);

		Object[][] cases = new Object[rowCount - 1][];

		for (int i = 0; i < rowCount - 1; i++) {

			String apiurl = xls.getCellData("BulkBoardingApi", "APIURL", i + 2);
			String header1 = xls.getCellData("BulkBoardingApi", "Header1", i + 2);
			String header2 = xls.getCellData("BulkBoardingApi", "Header2", i + 2);
			String Authorization = xls.getCellData("BulkBoardingApi", "Auth", i + 2);
			String requestJson = xls.getCellData("BulkBoardingApi", "JsonRequest", i + 2);
			String responsedata = xls.getCellData("BulkBoardingApi", "jsonResponse", i+2);

			cases[i] = new Object[] { apiurl, header1, header2, Authorization, requestJson,responsedata, i + 2 };

		}

		return cases;
	}

	@Test(dataProvider = "BulkBoardingAPI")
	public void TC_001_verifyBulkBoardingAPIResponse(String url, String header1, String header2,
			String auth, String json,String expectedResponse, int i) throws MalformedURLException, URISyntaxException, IOException {

		// apiheaders.getLoggedInHeaders(header1, header2, auth);

			String apiUrl = baseURL + url;
			//System.out.println("API url" + apiUrl);
			//System.out.println("In body data" + json);

			Response response = method.Post(apiUrl, apiheaders.getLoggedInHeaders(header1, header2, auth), json);
			int statusCode = response.getStatusCode();
			long time = response.getResponseTime();
			String actualResponse = response.getResponse().toString();

			System.out.println(statusCode);
			
			
			
			//System.out.println("Response data "+ actualResponse);
			
			assert expectedResponse.equals(actualResponse):"Response is not same";
		
		
		
		

	}*/
	
	
	
	

}


	

