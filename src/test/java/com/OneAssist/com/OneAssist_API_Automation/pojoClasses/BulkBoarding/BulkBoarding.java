
package com.OneAssist.com.OneAssist_API_Automation.pojoClasses.BulkBoarding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BulkBoarding implements Serializable
{

    @SerializedName("initiatingSystem")
    @Expose
    private Integer initiatingSystem;
    @SerializedName("action")
    @Expose
    private Object action;
    @SerializedName("customerInfo")
    @Expose
    private List<CustomerInfo> customerInfo = new ArrayList<CustomerInfo>();
    @SerializedName("orderInfo")
    @Expose
    private OrderInfo orderInfo;
    @SerializedName("paymentInfo")
    @Expose
    private PaymentInfo paymentInfo;
    private final static long serialVersionUID = 2873100192317090201L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BulkBoarding() {
    }

    /**
     * 
     * @param initiatingSystem
     * @param orderInfo
     * @param action
     * @param customerInfo
     * @param paymentInfo
     */
    public BulkBoarding(Integer initiatingSystem, Object action, List<CustomerInfo> customerInfo, OrderInfo orderInfo, PaymentInfo paymentInfo) {
        super();
        this.initiatingSystem = initiatingSystem;
        this.action = action;
        this.customerInfo = customerInfo;
        this.orderInfo = orderInfo;
        this.paymentInfo = paymentInfo;
    }

    public Integer getInitiatingSystem() {
        return initiatingSystem;
    }

    public void setInitiatingSystem(Integer initiatingSystem) {
        this.initiatingSystem = initiatingSystem;
    }

    public Object getAction() {
        return action;
    }

    public void setAction(Object action) {
        this.action = action;
    }

    public List<CustomerInfo> getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(List<CustomerInfo> customerInfo) {
        this.customerInfo = customerInfo;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(initiatingSystem).append(action).append(customerInfo).append(orderInfo).append(paymentInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BulkBoarding) == false) {
            return false;
        }
        BulkBoarding rhs = ((BulkBoarding) other);
        return new EqualsBuilder().append(initiatingSystem, rhs.initiatingSystem).append(action, rhs.action).append(customerInfo, rhs.customerInfo).append(orderInfo, rhs.orderInfo).append(paymentInfo, rhs.paymentInfo).isEquals();
    }

}
