package com.OneAssist.com.OneAssist_API_Automation.pojoClasses.createRenewal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.OneAssist.API_Automation.helperClasses.JsonHelper;

public class CreateRenewalPojoHelper {

	public static String setCreateRenewalPojo(Map<String, String> apiPayload) {
		List<CustomerDetail> customerDetails = new ArrayList<CustomerDetail>();
		String reqJson;
		CreateRenewal createRenewal = new CreateRenewal();
		CustomerDetail customerDetail = new CustomerDetail();
		OrderInfo orderInfo = new OrderInfo();
		PaymentInfo paymentInfo = new PaymentInfo();
		
		customerDetail.setFirstName(apiPayload.get("firstName"));
		customerDetail.setMiddleName(apiPayload.get("middleName"));
		customerDetail.setLastName(apiPayload.get("lastName"));
		customerDetail.setMobileNumber(apiPayload.get("mobileNumber"));
		customerDetail.setEmailId(apiPayload.get("emailId"));
		customerDetail.setPreviousCustId(apiPayload.get("previousCustId"));
		customerDetail.setRelationship(apiPayload.get("relationship"));
		
		customerDetails.add(customerDetail);
		
		orderInfo.setPlanCode(apiPayload.get("planCode"));
		orderInfo.setPartnerCode(apiPayload.get("partnerCode"));
		orderInfo.setPartnerBUCode(apiPayload.get("partnerBUCode"));
		
		paymentInfo.setPaymentMode(apiPayload.get("paymentMode"));
		
		createRenewal.setCustomerDetails(customerDetails);
		createRenewal.setInitiatingSystem(apiPayload.get("initiatingSystem"));
		createRenewal.setMembershipId(apiPayload.get("membershipId"));
		createRenewal.setOrderInfo(orderInfo);
		createRenewal.setPaymentInfo(paymentInfo);
		createRenewal.setUserId(apiPayload.get("userId"));
		
		reqJson = JsonHelper.getJsonStringFromJsonObject(createRenewal);
		
		System.out.println("request api data JSON: "+reqJson);
		
		return reqJson;
	}
}
