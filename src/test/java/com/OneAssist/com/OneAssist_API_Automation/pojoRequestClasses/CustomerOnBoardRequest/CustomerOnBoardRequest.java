
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerOnBoardRequest implements Serializable
{

    @SerializedName("initiatingSystem")
    @Expose
    private Integer initiatingSystem;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("activityReferenceId")
    @Expose
    private String activityReferenceId;
    @SerializedName("customerInfo")
    @Expose
    private List<CustomerInfo> customerInfo = new ArrayList<CustomerInfo>();
    @SerializedName("addressInfo")
    @Expose
    private List<AddressInfo> addressInfo = new ArrayList<AddressInfo>();
    @SerializedName("orderInfo")
    @Expose
    private OrderInfo orderInfo;
    @SerializedName("paymentInfo")
    @Expose
    private PaymentInfo paymentInfo;
    @SerializedName("utmParamInfo")
    @Expose
    private UtmParamInfo utmParamInfo;
    private final static long serialVersionUID = 5280781995641256114L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerOnBoardRequest() {
    }

    /**
     * 
     * @param initiatingSystem
     * @param addressInfo
     * @param utmParamInfo
     * @param orderInfo
     * @param action
     * @param customerInfo
     * @param activityReferenceId
     * @param paymentInfo
     */
    public CustomerOnBoardRequest(Integer initiatingSystem, String action, String activityReferenceId, List<CustomerInfo> customerInfo, List<AddressInfo> addressInfo, OrderInfo orderInfo, PaymentInfo paymentInfo, UtmParamInfo utmParamInfo) {
        super();
        this.initiatingSystem = initiatingSystem;
        this.action = action;
        this.activityReferenceId = activityReferenceId;
        this.customerInfo = customerInfo;
        this.addressInfo = addressInfo;
        this.orderInfo = orderInfo;
        this.paymentInfo = paymentInfo;
        this.utmParamInfo = utmParamInfo;
    }

    public Integer getInitiatingSystem() {
        return initiatingSystem;
    }

    public void setInitiatingSystem(Integer initiatingSystem) {
        this.initiatingSystem = initiatingSystem;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActivityReferenceId() {
        return activityReferenceId;
    }

    public void setActivityReferenceId(String activityReferenceId) {
        this.activityReferenceId = activityReferenceId;
    }

    public List<CustomerInfo> getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(List<CustomerInfo> customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<AddressInfo> getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(List<AddressInfo> addressInfo) {
        this.addressInfo = addressInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public UtmParamInfo getUtmParamInfo() {
        return utmParamInfo;
    }

    public void setUtmParamInfo(UtmParamInfo utmParamInfo) {
        this.utmParamInfo = utmParamInfo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(initiatingSystem).append(action).append(activityReferenceId).append(customerInfo).append(addressInfo).append(orderInfo).append(paymentInfo).append(utmParamInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerOnBoardRequest) == false) {
            return false;
        }
        CustomerOnBoardRequest rhs = ((CustomerOnBoardRequest) other);
        return new EqualsBuilder().append(initiatingSystem, rhs.initiatingSystem).append(action, rhs.action).append(activityReferenceId, rhs.activityReferenceId).append(customerInfo, rhs.customerInfo).append(addressInfo, rhs.addressInfo).append(orderInfo, rhs.orderInfo).append(paymentInfo, rhs.paymentInfo).append(utmParamInfo, rhs.utmParamInfo).isEquals();
    }

}
