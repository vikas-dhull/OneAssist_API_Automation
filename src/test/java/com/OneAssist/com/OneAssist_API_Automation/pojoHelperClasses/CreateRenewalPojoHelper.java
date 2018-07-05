package com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest.CreateRenewalRequest;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest.CustomerDetail;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest.OrderInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest.PaymentInfo;

public class CreateRenewalPojoHelper {
	
	public static String setCreateRenewalPojo(Map<String, String> apiPayload) {
		List<CustomerDetail> customerDetails = new ArrayList<CustomerDetail>();
		String reqJson;		
		
		CustomerDetail customerDetail = new CustomerDetail(apiPayload.get("firstName"),apiPayload.get("middleName"),apiPayload.get("lastName"),
				apiPayload.get("mobileNumber"),apiPayload.get("emailId"),apiPayload.get("relationship"),apiPayload.get("previousCustId"));
		customerDetails.add(customerDetail);		
		OrderInfo orderInfo = new OrderInfo(apiPayload.get("planCode"),apiPayload.get("partnerCode"),apiPayload.get("partnerBUCode"));
		PaymentInfo paymentInfo = new PaymentInfo(apiPayload.get("paymentMode"));
		CreateRenewalRequest createRenewal = new CreateRenewalRequest(customerDetails,paymentInfo,orderInfo,apiPayload.get("initiatingSystem"),
				apiPayload.get("userId"),apiPayload.get("membershipId"));
		
		reqJson = JsonHelper.getJsonStringFromJsonObject(createRenewal);		
		System.out.println("request api data JSON: "+reqJson);
		
		return reqJson;
	}
}
