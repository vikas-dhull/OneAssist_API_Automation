
package com.OneAssist.com.OneAssist_API_Automation.pojoClasses.createRenewalResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreateRenewalResponse implements Serializable
{

    @SerializedName("payNowLink")
    @Expose
    private String payNowLink;
    @SerializedName("paymentMode")
    @Expose
    private String paymentMode;
    @SerializedName("isMailSent")
    @Expose
    private String isMailSent;
    @SerializedName("customerOrderInfo")
    @Expose
    private CustomerOrderInfo customerOrderInfo;
    @SerializedName("membershipInfo")
    @Expose
    private MembershipInfo membershipInfo;
    @SerializedName("pendingCustomerInfo")
    @Expose
    private List<PendingCustomerInfo> pendingCustomerInfo = new ArrayList<PendingCustomerInfo>();
    @SerializedName("productInfo")
    @Expose
    private List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
    @SerializedName("primaryCustomerName")
    @Expose
    private String primaryCustomerName;
    @SerializedName("secondaryCustomerName")
    @Expose
    private Object secondaryCustomerName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    private final static long serialVersionUID = -2844484202361114893L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateRenewalResponse() {
    }

    /**
     * 
     * @param isMailSent
     * @param paymentMode
     * @param payNowLink
     * @param pendingCustomerInfo
     * @param membershipInfo
     * @param secondaryCustomerName
     * @param primaryCustomerName
     * @param message
     * @param customerOrderInfo
     * @param productInfo
     * @param status
     */
    public CreateRenewalResponse(String payNowLink, String paymentMode, String isMailSent, CustomerOrderInfo customerOrderInfo, MembershipInfo membershipInfo, List<PendingCustomerInfo> pendingCustomerInfo, List<ProductInfo> productInfo, String primaryCustomerName, Object secondaryCustomerName, String status, String message) {
        super();
        this.payNowLink = payNowLink;
        this.paymentMode = paymentMode;
        this.isMailSent = isMailSent;
        this.customerOrderInfo = customerOrderInfo;
        this.membershipInfo = membershipInfo;
        this.pendingCustomerInfo = pendingCustomerInfo;
        this.productInfo = productInfo;
        this.primaryCustomerName = primaryCustomerName;
        this.secondaryCustomerName = secondaryCustomerName;
        this.status = status;
        this.message = message;
    }

    public String getPayNowLink() {
        return payNowLink;
    }

    public void setPayNowLink(String payNowLink) {
        this.payNowLink = payNowLink;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getIsMailSent() {
        return isMailSent;
    }

    public void setIsMailSent(String isMailSent) {
        this.isMailSent = isMailSent;
    }

    public CustomerOrderInfo getCustomerOrderInfo() {
        return customerOrderInfo;
    }

    public void setCustomerOrderInfo(CustomerOrderInfo customerOrderInfo) {
        this.customerOrderInfo = customerOrderInfo;
    }

    public MembershipInfo getMembershipInfo() {
        return membershipInfo;
    }

    public void setMembershipInfo(MembershipInfo membershipInfo) {
        this.membershipInfo = membershipInfo;
    }

    public List<PendingCustomerInfo> getPendingCustomerInfo() {
        return pendingCustomerInfo;
    }

    public void setPendingCustomerInfo(List<PendingCustomerInfo> pendingCustomerInfo) {
        this.pendingCustomerInfo = pendingCustomerInfo;
    }

    public List<ProductInfo> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<ProductInfo> productInfo) {
        this.productInfo = productInfo;
    }

    public String getPrimaryCustomerName() {
        return primaryCustomerName;
    }

    public void setPrimaryCustomerName(String primaryCustomerName) {
        this.primaryCustomerName = primaryCustomerName;
    }

    public Object getSecondaryCustomerName() {
        return secondaryCustomerName;
    }

    public void setSecondaryCustomerName(Object secondaryCustomerName) {
        this.secondaryCustomerName = secondaryCustomerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(payNowLink).append(paymentMode).append(isMailSent).append(customerOrderInfo).append(membershipInfo).append(pendingCustomerInfo).append(productInfo).append(primaryCustomerName).append(secondaryCustomerName).append(status).append(message).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateRenewalResponse) == false) {
            return false;
        }
        CreateRenewalResponse rhs = ((CreateRenewalResponse) other);
        return new EqualsBuilder().append(payNowLink, rhs.payNowLink).append(paymentMode, rhs.paymentMode).append(isMailSent, rhs.isMailSent).append(customerOrderInfo, rhs.customerOrderInfo).append(membershipInfo, rhs.membershipInfo).append(pendingCustomerInfo, rhs.pendingCustomerInfo).append(productInfo, rhs.productInfo).append(primaryCustomerName, rhs.primaryCustomerName).append(secondaryCustomerName, rhs.secondaryCustomerName).append(status, rhs.status).append(message, rhs.message).isEquals();
    }

}
