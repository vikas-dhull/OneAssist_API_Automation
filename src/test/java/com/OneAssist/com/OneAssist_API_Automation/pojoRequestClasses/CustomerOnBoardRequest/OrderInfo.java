
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderInfo implements Serializable
{

    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("memStartDate")
    @Expose
    private String memStartDate;
    @SerializedName("planCode")
    @Expose
    private Integer planCode;
    @SerializedName("promoCode")
    @Expose
    private Integer promoCode;
    @SerializedName("partnerCode")
    @Expose
    private Integer partnerCode;
    @SerializedName("partnerBUCode")
    @Expose
    private Integer partnerBUCode;
    @SerializedName("applicationNo")
    @Expose
    private String applicationNo;
    @SerializedName("applicationDate")
    @Expose
    private String applicationDate;
    private final static long serialVersionUID = 6800225756473502312L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderInfo() {
    }

    /**
     * 
     * @param partnerCode
     * @param orderId
     * @param applicationNo
     * @param memStartDate
     * @param promoCode
     * @param partnerBUCode
     * @param planCode
     * @param applicationDate
     */
    public OrderInfo(Integer orderId, String memStartDate, Integer planCode, Integer promoCode, Integer partnerCode, Integer partnerBUCode, String applicationNo, String applicationDate) {
        super();
        this.orderId = orderId;
        this.memStartDate = memStartDate;
        this.planCode = planCode;
        this.promoCode = promoCode;
        this.partnerCode = partnerCode;
        this.partnerBUCode = partnerBUCode;
        this.applicationNo = applicationNo;
        this.applicationDate = applicationDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getMemStartDate() {
        return memStartDate;
    }

    public void setMemStartDate(String memStartDate) {
        this.memStartDate = memStartDate;
    }

    public Integer getPlanCode() {
        return planCode;
    }

    public void setPlanCode(Integer planCode) {
        this.planCode = planCode;
    }

    public Integer getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(Integer promoCode) {
        this.promoCode = promoCode;
    }

    public Integer getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(Integer partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getPartnerBUCode() {
        return partnerBUCode;
    }

    public void setPartnerBUCode(Integer partnerBUCode) {
        this.partnerBUCode = partnerBUCode;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(orderId).append(memStartDate).append(planCode).append(promoCode).append(partnerCode).append(partnerBUCode).append(applicationNo).append(applicationDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderInfo) == false) {
            return false;
        }
        OrderInfo rhs = ((OrderInfo) other);
        return new EqualsBuilder().append(orderId, rhs.orderId).append(memStartDate, rhs.memStartDate).append(planCode, rhs.planCode).append(promoCode, rhs.promoCode).append(partnerCode, rhs.partnerCode).append(partnerBUCode, rhs.partnerBUCode).append(applicationNo, rhs.applicationNo).append(applicationDate, rhs.applicationDate).isEquals();
    }

}
