package com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest.AssetInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest.BulkBoardingRequest;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest.CustomerInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest.OrderInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest.PaymentInfo;


public class BulkBoardingPojoHelper {
	
	BulkBoardingPojoHelper(){
		super();
	}
	
	public static String setBulkBoardingPojo(Map<String, String> apiPayload) {
		String reqJson;
		List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
		List<AssetInfo> assetInfos = new ArrayList<AssetInfo>();

		
		AssetInfo assetInfo = new AssetInfo(apiPayload.get("productCode"),apiPayload.get("assetMake"),apiPayload.get("assetModel"),
				apiPayload.get("invoiceDate"),Integer.parseInt(apiPayload.get("invoiceValue")),apiPayload.get("serialNo1"));
		assetInfos.add(assetInfo);
		
		CustomerInfo customerInfo = new CustomerInfo(apiPayload.get("firstName"),Long.parseLong(apiPayload.get("mobileNumber")),
				apiPayload.get("relationship"),assetInfos);
		customerInfos.add(customerInfo);
		
		OrderInfo orderInfo = new OrderInfo(Integer.parseInt(apiPayload.get("planCode")),Integer.parseInt(apiPayload.get("partnerCode")),
				Integer.parseInt(apiPayload.get("partnerBUCode")));
		PaymentInfo paymentInfo = new PaymentInfo(apiPayload.get("paymentMode"));
		
		BulkBoardingRequest bulkBoarding = new BulkBoardingRequest(Integer.parseInt(apiPayload.get("initiatingSystem")),apiPayload.get("action"),
				customerInfos,orderInfo,paymentInfo);
		
		reqJson = JsonHelper.getJsonStringFromJsonObject(bulkBoarding);		
		return reqJson;
	}
}
