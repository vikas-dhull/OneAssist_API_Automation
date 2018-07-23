package com.OneAssist.com.OneAssist_API_Automation.pojoHelperClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.OneAssist.API_Automation.helperClasses.JsonHelper;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.AddressInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.AssetInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.CustomerInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.CustomerOnBoardRequest;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.OrderInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.PaymentInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest.UtmParamInfo;
import com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest.BulkBoardingRequest;

public class CustomerOnBoardPojoHelper {

	CustomerOnBoardPojoHelper(){
		super();
	}

	public static String setCustomerOnBoardPojo(Map<String, String> apiPayload) {
		String reqJson;
		List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
		List<AssetInfo> assetInfos = new ArrayList<AssetInfo>();
		List<AddressInfo> addressInfos = new ArrayList<AddressInfo>();

		AssetInfo assetInfo =new AssetInfo(apiPayload.get("customerRelationType"), apiPayload.get("productCode"),
				apiPayload.get("assetMake"), apiPayload.get("assetModel"), 
				apiPayload.get("invoiceDate"),Integer.parseInt(apiPayload.get("invoiceValue")),apiPayload.get("serialNo1") ,
				apiPayload.get("serialNo2"),Integer.parseInt(apiPayload.get("warrantyPeriod")) ,apiPayload.get("productName") ,
				apiPayload.get("categoryCode"), apiPayload.get("technology"), apiPayload.get("age"),
				apiPayload.get("size"),apiPayload.get("sizeUnit"));
		assetInfos.add(assetInfo);


		CustomerInfo customerInfo =new CustomerInfo(apiPayload.get("salutation"), apiPayload.get("firstName"),
				apiPayload.get("middleName") , apiPayload.get("lastName") , apiPayload.get("customerTempId"),apiPayload.get("emailId") ,
				Long.parseLong(apiPayload.get("mobileNumber") ) , apiPayload.get("gender"), apiPayload.get("relationship"),
				apiPayload.get("customerdob")  ,  apiPayload.get("panCard"), apiPayload.get("dlNo"), 
				apiPayload.get("passport") ,  apiPayload.get("aadharId"),apiPayload.get("previousCustomerId") , 
				apiPayload.get("documentDownload") , assetInfos) ;

		customerInfos.add(customerInfo);

		/*OrderInfo orderInfo =new OrderInfo(Integer.parseInt(apiPayload.get("orderId")), apiPayload.get("memStartDate"),
				Integer.parseInt(apiPayload.get("planCode")),Integer.parseInt(apiPayload.get("promoCode")) ,
				Integer.parseInt(apiPayload.get("partnerCode") ),
				Integer.parseInt( apiPayload.get("partnerBUCode")), apiPayload.get("applicationNo"),apiPayload.get("applicationDate") );
*/
		
		OrderInfo orderInfo = new OrderInfo();
		try {
			orderInfo.setOrderId(Integer.parseInt(apiPayload.get("orderId")));
		} catch (NumberFormatException e) {
			System.out.println("caught NumberFormatException while parsing orderId, setting as NULL ..!!");
		}		
		
		orderInfo.setMemStartDate(apiPayload.get("memStartDate"));
		
		try {
			orderInfo.setPlanCode(Integer.parseInt(apiPayload.get("planCode")));
		} catch (NumberFormatException e) {
			System.out.println("caught NumberFormatException while parsing planCode, setting as NULL ..!!");
		}
		
		try {
			orderInfo.setPromoCode(Integer.parseInt(apiPayload.get("promoCode")));
		} catch (NumberFormatException e) {
			System.out.println("caught NumberFormatException while parsing promoCode, setting as NULL ..!!");
		}
		
		try {
			orderInfo.setPartnerCode(Integer.parseInt(apiPayload.get("partnerCode")));
		} catch (NumberFormatException e) {
			System.out.println("caught NumberFormatException while parsing partnerCode, setting as NULL ..!!");
		}
		
		try {
			orderInfo.setPartnerBUCode(Integer.parseInt( apiPayload.get("partnerBUCode")));
		} catch (NumberFormatException e) {
			System.out.println("caught NumberFormatException while parsing partnerBUCode, setting as NULL ..!!");
		}
		
		orderInfo.setApplicationNo(apiPayload.get("applicationNo"));
		orderInfo.setApplicationDate(apiPayload.get("applicationDate"));
		
		PaymentInfo paymentInfo =new PaymentInfo(apiPayload.get("mid"), apiPayload.get("acquirer"), 
				apiPayload.get("accountNo"),apiPayload.get("accountHolderName") ,apiPayload.get("accountType") ,
				apiPayload.get("ifscCode"), apiPayload.get("issueOnBranch"), apiPayload.get("ecsStartDate"),
				apiPayload.get("ecsEndDate"), apiPayload.get("chequeNo"), apiPayload.get("micrNo"), apiPayload.get("expiryMonth"), 
				apiPayload.get("expiryYear"), apiPayload.get("issuerBank"), apiPayload.get("paymentStatus"),
				apiPayload.get("cardLevel"), apiPayload.get("paymentMode"))	;	 

		AddressInfo addressInfo = new AddressInfo(apiPayload.get("addrType"), apiPayload.get("addrLine1"),
				apiPayload.get("addrLine2"),apiPayload.get("landmark") ,apiPayload.get("pinCode") , 
				apiPayload.get("cityCode"), apiPayload.get("stateCode"), apiPayload.get("telNo"), 
				apiPayload.get("stdCode"), apiPayload.get("isMailingAddress"));

		addressInfos.add(addressInfo);

		UtmParamInfo utmParamInfo= new UtmParamInfo(apiPayload.get("utmSource"), apiPayload.get("adGroup"),
				apiPayload.get("crmAgent"), apiPayload.get("leadSource"),
				apiPayload.get("leadCreatedDate") ,apiPayload.get("utmCampaign") ,
				apiPayload.get("utmContent"),apiPayload.get("utmTerm") , 
				apiPayload.get("url"), apiPayload.get("utmMedium"));		

				CustomerOnBoardRequest customerOnBoardRequest =new CustomerOnBoardRequest(Integer.parseInt(apiPayload.get("initiatingSystem")), apiPayload.get("action"), apiPayload.get("activityReferenceId"), customerInfos, addressInfos, orderInfo, paymentInfo, utmParamInfo);
				reqJson = JsonHelper.getJsonStringFromJsonObject(customerOnBoardRequest);		

		return reqJson;

	}
}
