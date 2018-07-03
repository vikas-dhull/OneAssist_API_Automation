
package com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MembershipInfo implements Serializable
{

    @SerializedName("membershipNumber")
    @Expose
    private Object membershipNumber;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("primaryCustomerId")
    @Expose
    private Object primaryCustomerId;
    @SerializedName("secondaryCustomerId")
    @Expose
    private Object secondaryCustomerId;
    private final static long serialVersionUID = -5890434334096467605L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MembershipInfo() {
    }

    /**
     * 
     * @param membershipNumber
     * @param secondaryCustomerId
     * @param primaryCustomerId
     * @param endDate
     * @param startDate
     */
    public MembershipInfo(Object membershipNumber, String startDate, String endDate, Object primaryCustomerId, Object secondaryCustomerId) {
        super();
        this.membershipNumber = membershipNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.primaryCustomerId = primaryCustomerId;
        this.secondaryCustomerId = secondaryCustomerId;
    }

    public Object getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(Object membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Object getPrimaryCustomerId() {
        return primaryCustomerId;
    }

    public void setPrimaryCustomerId(Object primaryCustomerId) {
        this.primaryCustomerId = primaryCustomerId;
    }

    public Object getSecondaryCustomerId() {
        return secondaryCustomerId;
    }

    public void setSecondaryCustomerId(Object secondaryCustomerId) {
        this.secondaryCustomerId = secondaryCustomerId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(membershipNumber).append(startDate).append(endDate).append(primaryCustomerId).append(secondaryCustomerId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MembershipInfo) == false) {
            return false;
        }
        MembershipInfo rhs = ((MembershipInfo) other);
        return new EqualsBuilder().append(membershipNumber, rhs.membershipNumber).append(startDate, rhs.startDate).append(endDate, rhs.endDate).append(primaryCustomerId, rhs.primaryCustomerId).append(secondaryCustomerId, rhs.secondaryCustomerId).isEquals();
    }

}
