
package com.OneAssist.com.OneAssist_API_Automation.pojoClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreateRenewResponseClass implements Serializable
{

    @SerializedName("customerDetails")
    @Expose
    private List<CustomerDetail> customerDetails = new ArrayList<CustomerDetail>();
    @SerializedName("paymentInfo")
    @Expose
    private PaymentInfo paymentInfo;
    @SerializedName("orderInfo")
    @Expose
    private OrderInfo orderInfo;
    @SerializedName("initiatingSystem")
    @Expose
    private String initiatingSystem;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("membershipId")
    @Expose
    private String membershipId;
    private final static long serialVersionUID = 2773986187748441896L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateRenewResponseClass() {
    }

    /**
     * 
     * @param initiatingSystem
     * @param orderInfo
     * @param membershipId
     * @param customerDetails
     * @param userId
     * @param paymentInfo
     */
    public CreateRenewResponseClass(List<CustomerDetail> customerDetails, PaymentInfo paymentInfo, OrderInfo orderInfo, String initiatingSystem, String userId, String membershipId) {
        super();
        this.customerDetails = customerDetails;
        this.paymentInfo = paymentInfo;
        this.orderInfo = orderInfo;
        this.initiatingSystem = initiatingSystem;
        this.userId = userId;
        this.membershipId = membershipId;
    }

    public List<CustomerDetail> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetail> customerDetails) {
        this.customerDetails = customerDetails;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getInitiatingSystem() {
        return initiatingSystem;
    }

    public void setInitiatingSystem(String initiatingSystem) {
        this.initiatingSystem = initiatingSystem;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerDetails).append(paymentInfo).append(orderInfo).append(initiatingSystem).append(userId).append(membershipId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateRenewResponseClass) == false) {
            return false;
        }
        CreateRenewResponseClass rhs = ((CreateRenewResponseClass) other);
        return new EqualsBuilder().append(customerDetails, rhs.customerDetails).append(paymentInfo, rhs.paymentInfo).append(orderInfo, rhs.orderInfo).append(initiatingSystem, rhs.initiatingSystem).append(userId, rhs.userId).append(membershipId, rhs.membershipId).isEquals();
    }

}
