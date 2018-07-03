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
		List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
		List<AssetInfo> assetInfos = new ArrayList<AssetInfo>();
		String reqJson;
		
		BulkBoardingRequest bulkBoarding = new BulkBoardingRequest();
		CustomerInfo customerInfo = new CustomerInfo();
		AssetInfo assetInfo = new AssetInfo();
		OrderInfo orderInfo = new OrderInfo();
		PaymentInfo paymentInfo = new PaymentInfo();
		
		customerInfo.setFirstName(apiPayload.get("firstName"));
		customerInfo.setMobileNumber(Long.parseLong(apiPayload.get("mobileNumber")));
		customerInfo.setRelationship(apiPayload.get("relationship"));
		customerInfo.setAssetInfo(assetInfos);
		customerInfos.add(customerInfo);
		
		assetInfo.setAssetMake(apiPayload.get("assetMake"));
		assetInfo.setAssetModel(apiPayload.get("assetModel"));
		assetInfo.setInvoiceDate(apiPayload.get("invoiceDate"));
		assetInfo.setInvoiceValue(Integer.parseInt(apiPayload.get("invoiceValue")));
		assetInfo.setProductCode(apiPayload.get("productCode"));
		assetInfo.setSerialNo1(apiPayload.get("serialNo1"));
		assetInfos.add(assetInfo);
		
		orderInfo.setPlanCode(Integer.parseInt(apiPayload.get("planCode")));
		orderInfo.setPartnerCode(Integer.parseInt(apiPayload.get("partnerCode")));
		orderInfo.setPartnerBUCode(Integer.parseInt(apiPayload.get("partnerBUCode")));
		
		paymentInfo.setPaymentMode(apiPayload.get("paymentMode"));
		
		bulkBoarding.setInitiatingSystem(Integer.parseInt(apiPayload.get("initiatingSystem")));
		bulkBoarding.setAction(apiPayload.get("action"));
		bulkBoarding.setCustomerInfo(customerInfos);
		bulkBoarding.setOrderInfo(orderInfo);
		bulkBoarding.setPaymentInfo(paymentInfo);
		
		reqJson = JsonHelper.getJsonStringFromJsonObject(bulkBoarding);
		
		return reqJson;
	}
}
