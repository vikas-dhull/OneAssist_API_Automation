
package com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.CustomerOnBoardResponse;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerOrderInfo implements Serializable
{

    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("planName")
    @Expose
    private String planName;
    @SerializedName("taxAmount")
    @Expose
    private Integer taxAmount;
    @SerializedName("price")
    @Expose
    private Integer price;
    private final static long serialVersionUID = 4604883617980875219L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerOrderInfo() {
    }

    /**
     * 
     * @param orderId
     * @param price
     * @param discount
     * @param planName
     * @param taxAmount
     */
    public CustomerOrderInfo(Integer discount, Integer orderId, String planName, Integer taxAmount, Integer price) {
        super();
        this.discount = discount;
        this.orderId = orderId;
        this.planName = planName;
        this.taxAmount = taxAmount;
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(discount).append(orderId).append(planName).append(taxAmount).append(price).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerOrderInfo) == false) {
            return false;
        }
        CustomerOrderInfo rhs = ((CustomerOrderInfo) other);
        return new EqualsBuilder().append(discount, rhs.discount).append(orderId, rhs.orderId).append(planName, rhs.planName).append(taxAmount, rhs.taxAmount).append(price, rhs.price).isEquals();
    }

}
