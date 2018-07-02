
package com.OneAssist.com.OneAssist_API_Automation.pojoClasses.BulkBoarding;

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
    private Integer planCode;
    @SerializedName("partnerCode")
    @Expose
    private Integer partnerCode;
    @SerializedName("partnerBUCode")
    @Expose
    private Integer partnerBUCode;
    private final static long serialVersionUID = 5053886938970953067L;

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
    public OrderInfo(Integer planCode, Integer partnerCode, Integer partnerBUCode) {
        super();
        this.planCode = planCode;
        this.partnerCode = partnerCode;
        this.partnerBUCode = partnerBUCode;
    }

    public Integer getPlanCode() {
        return planCode;
    }

    public void setPlanCode(Integer planCode) {
        this.planCode = planCode;
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
