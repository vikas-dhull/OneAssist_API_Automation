
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderInfo implements Serializable
{

    @SerializedName("planCode")
    @Expose
    private String planCode;
    @SerializedName("partnerCode")
    @Expose
    private String partnerCode;
    @SerializedName("partnerBUCode")
    @Expose
    private String partnerBUCode;
    private final static long serialVersionUID = 3473893497511903383L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderInfo() {
    }

    /**
     * 
     * @param partnerCode
     * @param partnerBUCode
     * @param planCode
     */
    public OrderInfo(String planCode, String partnerCode, String partnerBUCode) {
        super();
        this.planCode = planCode;
        this.partnerCode = partnerCode;
        this.partnerBUCode = partnerBUCode;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerBUCode() {
        return partnerBUCode;
    }

    public void setPartnerBUCode(String partnerBUCode) {
        this.partnerBUCode = partnerBUCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(planCode).append(partnerCode).append(partnerBUCode).toHashCode();
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
        return new EqualsBuilder().append(planCode, rhs.planCode).append(partnerCode, rhs.partnerCode).append(partnerBUCode, rhs.partnerBUCode).isEquals();
    }

}
